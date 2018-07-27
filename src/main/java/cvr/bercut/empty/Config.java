package cvr.bercut.empty;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.server.SpringVaadinServlet;
import cvr.bercut.empty.service.DataService;
import cvr.bercut.empty.service.LoginService;
import cvr.bercut.empty.ui.LoginDlg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

@Configuration
@EnableVaadin
public class Config {
    @WebServlet(value = "/*", asyncSupported = true)
    public static class Servlet extends SpringVaadinServlet {
    }

    @Bean
    public LoginDlg loginDlg(LoginService loginService){
        return new LoginDlg(loginService);
    }
    
    @Bean
    DataService dataService() {
        DataService dataService = new DataService();
        return dataService;
    }

    @Bean
    LoginService loginService() {
        LoginService loginService = new LoginService();
        return loginService;
    }
}
