package cvr.bercut.empty.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import cvr.bercut.empty.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class StandardUI extends UI {

    @Autowired
    private DataService dataService;

    @Autowired
    private LoginDlg loginDlg;

    @Autowired
    private MainFrame mainFrame;

    @Override
    protected void init(VaadinRequest request) {
        dataService.addFakeObjects();//     <- Удалить в последствии
//        mainFrame = new MainFrame();
        setContent(mainFrame);
//        loginDlg = new LoginDlg();
        loginDlg.center();
        addWindow(loginDlg);
    }

}
