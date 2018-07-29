package cvr.bercut.empty.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import cvr.bercut.empty.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringUI
@Theme("valo")
public class StandardUI extends UI {

    @Autowired
    private DataService dataService;

//    @Autowired
    private LoginDlg loginDlg;
    
    @Override
    protected void init(VaadinRequest request) {
        try {

            dataService.addFakeObjects();//     <- Удалить в последствии
            loginDlg = new LoginDlg();
            loginDlg.center();
            addWindow(loginDlg);
        } catch (Exception ex) {
            Logger.getLogger(StandardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
