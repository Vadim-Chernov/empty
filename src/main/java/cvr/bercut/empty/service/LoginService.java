package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import cvr.bercut.empty.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements ILoginService {

    @Autowired
    private UserRepository userRepository;
    
    private User user;

    public LoginService() {
    }
    
    @Override
    public User login(String name,String parole) {
        if (parole == null || name == null)
            return null;
        user = userRepository.findByParoleAndName(parole, name);
        return user;
    }
}
