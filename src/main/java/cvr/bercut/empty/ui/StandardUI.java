package cvr.bercut.empty.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import cvr.bercut.empty.model.BaseObject;
import cvr.bercut.empty.service.DataService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class StandardUI extends UI {

    @Autowired
    private DataService dataService;

    @Autowired
    private LoginDlg loginDlg;
    
    @Override
    protected void init(VaadinRequest request) {
        try {
            createDefObjects();            
            loginDlg.center();
            addWindow(loginDlg);
        } catch (Exception ex) {
            Logger.getLogger(StandardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createDefObjects() throws Exception {
        List<BaseObject> addedObjects = dataService.addDefaultObjects();
        addedObjects.forEach((bo) -> {
            System.out.println(bo.getClass().getSimpleName() + " ==>  " + bo.getName() + " ==> " + bo.getDtype());
        });
    }
    
}
