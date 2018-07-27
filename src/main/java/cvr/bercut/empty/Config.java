package cvr.bercut.empty;

import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.server.SpringVaadinServlet;
import cvr.bercut.empty.model.BaseObject;
import cvr.bercut.empty.model.Role;
import cvr.bercut.empty.model.User;
import cvr.bercut.empty.service.DataService;
import cvr.bercut.empty.service.LoginService;
import cvr.bercut.empty.ui.LoginDlg;
import javax.persistence.EntityManagerFactory;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableVaadin
//@EnableJpaRepositories(basePackages = "cvr.bercut.empty.repo")
//@PropertySource("classpath:application.properties")
////@ComponentScan("cvr.bercut.empty.model")
//@EntityScan(basePackageClasses = {BaseObject.class,Role.class,User.class})
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
