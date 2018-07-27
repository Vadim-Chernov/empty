package cvr.bercut.empty.service;

import com.google.common.collect.ImmutableList;
import cvr.bercut.empty.model.BaseObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {
    @Autowired
    DataService service;


    @Test
    public void addDefaultObjects() {
        service.addDefaultObjects();

        List<BaseObject> list = service.findAll();
        assertThat(list.size(), is(4));
        List<Long> actualList = list.stream()
                .map(bo -> bo.getId())
                .collect(collectingAndThen( toList(),ImmutableList::copyOf));
        assertThat(actualList, containsInAnyOrder(1L,2L,3L,4L));

    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }
}