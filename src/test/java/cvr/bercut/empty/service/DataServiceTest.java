package cvr.bercut.empty.service;

import com.google.common.collect.ImmutableList;
import cvr.bercut.empty.TestUtils;
import cvr.bercut.empty.model.BaseObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {
    @Autowired
    DataService service;

    private TestUtils utils = new TestUtils();


    @Test
    public void addDefaultObjects() {
        service.addDefaultObjects();

        List<BaseObject> list = service.findAll();
        assertThat(list.size(), is(4));
        List<Long> actualList = list.stream()
                .map(bo -> bo.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualList, containsInAnyOrder(1L, 2L, 3L, 4L));

    }


    @Test
    public void findAll() throws SQLException {
        final long l = utils.allObjCount();
        utils.createUser(100, "ivan", "1");
        utils.createUser(101, "stepan", "1");
        utils.createUser(102, "erevan", "1");
        final List<BaseObject> all = service.findAll();
        final long l1 = all.size() - l;
        assertTrue(l1==3);
    }

    @Test
    public void findById() throws SQLException {
        utils.createUser(1000, "ivan", "1");
        final BaseObject byId = service.findById(1000l);
        assertTrue(byId.getName().equals("ivan"));
    }
}