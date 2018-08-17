package cvr.bercut.empty.service;

import cvr.bercut.empty.model.BaseObject;
import cvr.bercut.empty.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Ignore
public class DataServiceTest extends BaseServiceTest {

    @Autowired
    private DataService service;


    @Test
    public void findAll() throws SQLException {
        final long l = utils.allObjCount();
        utils.createUser(100, "ivan", "1");
        utils.createUser(101, "stepan", "1");
        utils.createUser(102, "erevan", "1");
        final List<BaseObject> all = service.findAll();
        final long l1 = all.size() - l;
        assertEquals(3, l1);
    }

    @Test
    public void findById() throws SQLException {
        utils.createUser(1000, "ivan", "1");
        final BaseObject byId = service.findById(1000L);
        assertEquals("ivan", byId.getName());
    }

    /*  DataService     */
///////////////////////////////////////////////////////////////
    /*  LoginService    */
    @Autowired
    private LoginService loginService;

    @Test
    public void login() throws SQLException {
        String name = "ivan";
        String parole = "1";
        Random random = new Random();
        Long nextInt = random.nextLong();
        System.out.println("nextInt = " + nextInt);
        utils.createUser(nextInt, name, parole);
        final User user = loginService.login(name, parole);

        assertEquals(name, user.getName());
        assertEquals(parole,user.getParole());

        nextInt = random.nextLong();
        String fakeName = nextInt.toString();
        nextInt = random.nextLong();
        String fakeParole = nextInt.toString();
        final User faceUser = loginService.login(fakeName, fakeParole);
        assertNull(faceUser);
    }
///////////////////////////////////////////////////////////////


}

//    /*  DataService     */
//    @Test
//    public void addDefaultObjects() {
//        service.addFakeObjects();
//
//        List<BaseObject> list = service.findAll();
//        assertThat(list.size(), is(4));
//        List<Long> actualList = list.stream()
//                .map(bo -> bo.getId())
//                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
//        assertThat(actualList, containsInAnyOrder(1L, 2L, 3L, 4L));
//
//    }

