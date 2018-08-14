package cvr.bercut.empty.ui

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.UI
import cvr.bercut.empty.service.DataService
import org.springframework.beans.factory.annotation.Autowired

@SpringUI
@Theme("mytheme")
class StandardUI : UI() {

    @Autowired
    private val dataService: DataService? = null

    @Autowired
    private val loginDlg: LoginDlg? = null

    @Autowired
    private val mainFrame: MainFrame? = null

    override fun init(request: VaadinRequest) {
        dataService!!.addFakeObjects()//     <- Удалить в последствии
        content = mainFrame
        loginDlg!!.center()
        addWindow(loginDlg)
    }

}
