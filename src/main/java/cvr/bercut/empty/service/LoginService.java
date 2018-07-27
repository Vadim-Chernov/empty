package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import cvr.bercut.empty.repo.BaseObjectRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cvr.bercut.empty.repo.UserRepository;


@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserRepository repo;
    
    private String name;
    private String password;
    private User user;

    public LoginService() {
    }
    

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @PostConstruct
    void report(){
        System.out.println("---===>>> repo is null ? "+repo== null);
    }
    @Override
    public User login() {
        if (password == null || name == null)
            return null;
        user = repo.findByPasswordAndName(password, name);
        return user;
    }

}
