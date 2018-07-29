package cvr.bercut.lib.authentication;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import cvr.bercut.empty.model.User;

public final class CurrentUser {

    private static final String CUR_USER_SESSION_ATTR_KEY = CurrentUser.class.getCanonicalName();

    private CurrentUser() {
    }

    public static User get() {
        User user = (User) getCurrentRequest().getWrappedSession()
                .getAttribute(CUR_USER_SESSION_ATTR_KEY);
        if (user == null) {
            throw new IllegalStateException("Пользователь неопределен!");
        } else {
            return user;
        }
    }

    public static void set(User user) {
        if (user == null) {
            getCurrentRequest().getWrappedSession().removeAttribute(
                    CUR_USER_SESSION_ATTR_KEY);
        } else {
            getCurrentRequest().getWrappedSession().setAttribute(
                    CUR_USER_SESSION_ATTR_KEY, user);
        }
    }

    private static VaadinRequest getCurrentRequest() {
        VaadinRequest request = VaadinService.getCurrentRequest();
        if (request == null) {
            throw new AuthException("No request bound to current thread");
        }
        return request;
    }

}
