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
    private String defUserName1 = "Федя";
    private String defUserName2 = "Петя";

    private String defUserRole1 = "admin";
    private String defUserRole2 = "user";
    private String defParole = "1";

    @Autowired
    private BaseObjectRepository baseObjectRepository;


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

// Фейковые объекты
    public void addFakeObjects() {
        if(fakeObjectsExists())
            return ;
        User u1 = baseObjectRepository.save(new User(defUserName1, defParole));
        User u2 = baseObjectRepository.save(new User(defUserName2, defParole));
        Role r1 = baseObjectRepository.save(new Role());
        r1.setName(defUserRole1);
        Role r2 = baseObjectRepository.save(new Role());
        r2.setName(defUserRole2);
        u1.setRole(r1);
        u2.setRole(r2);
        ArrayList list = new ArrayList();
        r2.setDescription("Пользователь " + u2.getName());
        list.add(u1);
        list.add(u2);
        list.add(r1);
        list.add(r2);
        List<BaseObject> savedAll = baseObjectRepository.saveAll(list);
        savedAll.stream().forEach(System.out::println);
//        return savedAll;
    }

    private boolean fakeObjectsExists() {
        final List<BaseObject> list = baseObjectRepository.findByName(defUserName1);
        for (BaseObject bo : list) {
            if (bo instanceof User) {
                User user = (User) bo;
                if (defParole.equals(user.getParole()))
                    return true;
            }
        }
        return false;
    }

}