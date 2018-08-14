package cvr.bercut.lib.uiutils;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

public class Say {

    public static void warning(String message) {
        // Notification with default settings for a warning
        Notification notif = new Notification(
                "Предупреждение",
                message,
                Notification.Type.WARNING_MESSAGE);

        notif.setPosition(Position.BOTTOM_RIGHT);
        notif.show(Page.getCurrent());
    }

    public static void warning(String message, String caption) {
        // Notification with default settings for a warning
        Notification notif = new Notification(
                caption,
                message,
                Notification.Type.WARNING_MESSAGE);

        notif.setPosition(Position.BOTTOM_RIGHT);
        notif.show(Page.getCurrent());
    }
}
