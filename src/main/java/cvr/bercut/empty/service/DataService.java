package cvr.bercut.empty.service;

import cvr.bercut.empty.model.BaseObject;
import cvr.bercut.empty.model.Role;
import cvr.bercut.empty.model.User;
import cvr.bercut.empty.repo.BaseObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataService implements IDataService {

    @Autowired
    private BaseObjectRepository baseObjectRepository;

    @Override
    public List<BaseObject> addDefaultObjects() {
        baseObjectRepository.deleteAll();
        User u1 = baseObjectRepository.save(new User("Петя", "11"));
        User u2 = baseObjectRepository.save(new User("Федя", "22"));
        Role r1 = baseObjectRepository.save(new Role());
        r1.setName("Admin");
        Role r2 = baseObjectRepository.save(new Role());
        r2.setName("user");

        u2.setRole(r2);
        List<BaseObject> list = new ArrayList();
        r2.setDescription("Пользователь " + u2.getName());
        list.add(u1);
        list.add(u2);
        list.add(r1);
        list.add(r2);
        List<BaseObject> savedAll = baseObjectRepository.saveAll(list);
        return savedAll;
    }


    @Override
    public List<BaseObject> findAll() {
        List<BaseObject> list = baseObjectRepository.findAll();
        return list;
    }

    @Override
    public BaseObject findById(long id) {
        final Optional<BaseObject> byId = baseObjectRepository.findById(id);
        BaseObject result = byId.get();
        return result;
    }

    @Override
    public String fetchDataByLastName(String lastName) {
        String result = "";

        for (BaseObject cust : baseObjectRepository.findByName(lastName)) {
            result += cust.toString() + "<br>";
        }
        return result;
    }
}
