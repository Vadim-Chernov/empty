package cvr.bercut.empty.service;

import cvr.bercut.empty.model.User;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {

    User login(String name,String parole);

//    public void setName(String id);
//
//    public void setParole(String pwd);
}
