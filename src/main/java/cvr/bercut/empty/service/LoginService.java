package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import cvr.bercut.empty.repo.UserRepository;
import cvr.bercut.lib.authentication.AuthException;
import cvr.bercut.lib.authentication.CurrentUser;
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
    public User login(String name, String parole) {
        if (parole == null || name == null)
            return null;
        user = userRepository.findByParoleAndName(parole, name);
        CurrentUser.set(user);
        return user;
    }

    @Override
    public boolean isUserSignedIn() {
        return CurrentUser.get() != null;
    }


    @Override
    public String getPrincipalName() {
        if (isUserSignedIn())
            return CurrentUser.get().getName();
        else
            throw new AuthException("Запрос PrincipalName у неавтозизованного пользователя");
    }
}
