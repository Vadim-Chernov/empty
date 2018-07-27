package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import cvr.bercut.empty.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserRepository repo;
    
    private String name;
    private String parole;
    private User user;

    public LoginService() {
    }
    

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setParole(String parole) {
        this.parole = parole;
    }

    @PostConstruct
    void report(){
        System.out.println("---===>>> repo is null ? "+repo== null);
    }
    @Override
    public User login() {
        if (parole == null || name == null)
            return null;
        user = repo.findByParoleAndName(parole, name);
        return user;
    }

}
