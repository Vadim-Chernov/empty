package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {

    User login();

    public void setName(String id);

    public void setPassword(String pwd);
}
