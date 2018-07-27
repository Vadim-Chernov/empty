package cvr.bercut.empty;

import com.google.common.collect.ImmutableList;
import cvr.bercut.empty.model.BaseObject;
import cvr.bercut.empty.service.DataService;
import org.junit.Ignore;
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

@Ignore

@RunWith(SpringRunner.class)
@SpringBootTest

public class IT_EmptyApplicationTest {
    @Autowired
    DataService service;

//    @Test
    public void findAllTest() {//contextLoads
        List<BaseObject> list = service.findAll();
        assertThat(list.size(), is(4));
        List<Long> actualList = list.stream()
                .map(bo -> bo.getId())
                .collect(collectingAndThen( toList(),ImmutableList::copyOf));
        assertThat(actualList, containsInAnyOrder(1L,2L,3L,4L));
    }
}

