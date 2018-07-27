
package cvr.bercut.empty.ui;

import com.vaadin.data.HasValue;
import com.vaadin.ui.Button.ClickListener;
import cvr.bercut.empty.model.User;
import cvr.bercut.empty.service.LoginService;
import cvr.bercut.lib.controls.AButton;
import cvr.bercut.lib.controls.ALabel;
import cvr.bercut.lib.controls.APasswordField;
import cvr.bercut.lib.controls.ATextField;
import cvr.bercut.lib.forms.*;
import cvr.bercut.lib.uiutils.Say;

@QFrame(title = "ВХОД В СИСТЕМУ", height = "40%",
        rows = {
                @QRow(cells = {
                        @QCell(caption = "Введите имя", weight = 2, control = ALabel.class),
                        @QCell(weight = 3, control = ATextField.class, id = LoginDlg.ID),}
                )
                ,
                @QRow(cells = {
                        @QCell(caption = "Введите пароль", weight = 2, control = ALabel.class),
                        @QCell(weight = 3, control = APasswordField.class, id = LoginDlg.PASSWORD),}
                )
                ,
                @QRow
                ,
                @QRow(cells = {
                        @QCell(caption = "ok", weight = 2, control = AButton.class, id = LoginDlg.BTN_OK),
                        @QCell(caption = "cancel", weight = 2, control = AButton.class, id = LoginDlg.BTN_CANCEL),}
                )
        }
)

public class LoginDlg extends AWindow implements IFrame {

    static final String ID = "id";
    static final String PASSWORD = "password";
    static final String BTN_OK = "btnOk";
    static final String BTN_CANCEL = "btnCancel";

    private final AButton btnOk;
    private final AButton btnCancel;
    private final ATextField txtId;
    private final APasswordField pswField;
    private User user;

    private LoginService loginService;

    public LoginDlg(LoginService loginService) {
        super(LoginDlg.class.getAnnotation(QFrame.class));
        this.loginService = loginService;
        btnCancel = (AButton) getControl(BTN_CANCEL);
        btnOk = (AButton) getControl(BTN_OK);
        txtId = (ATextField) getControl(ID);
        pswField = (APasswordField) getControl(PASSWORD);
        enableOkBtn();
        txtId.addValueChangeListener((HasValue.ValueChangeListener) event -> enableOkBtn());
        pswField.addValueChangeListener((HasValue.ValueChangeListener) event -> enableOkBtn());
        btnCancel.addClickListener((ClickListener) event -> close());
        btnOk.addClickListener((ClickListener) event -> checkLoginInfo());
    }

    private void enableOkBtn() {
        String id = txtId.getValue();
        String pwd = pswField.getValue();
        if (id.isEmpty() || pwd.isEmpty())
            btnOk.setEnabled(false);
        else
            btnOk.setEnabled(true);
    }

    private void checkLoginInfo() {
        String id = txtId.getValue();
        String pwd = pswField.getValue();
        System.out.println("Проверка id = " + id + "  password = " + pwd);
        user = loginService.login(id, pwd);
        if (user == null)
            Say.sayWarning("Не верное и мя или пароль");
        else {
            Say.sayWarning("Поздравляю!", "Пользователь [" + user + "] вошел в систему");
            close();
        }
    }
}
