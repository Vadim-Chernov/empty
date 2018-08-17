package cvr.bercut.lib.forms;


import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import cvr.bercut.lib.controls.IControl;

public class AWindow extends Window implements IFrame{
    private final VerticalLayout layout = new VerticalLayout();
    private FrameBuilder frameBuilder;

    public AWindow(QFrame ann ) {
        if (ann != null) {
            setCaption(ann.title());
            this.setWidth(ann.width());
            this.setHeight(ann.height());
        }
        this.setContent(layout);
        createWindow();
        center();
    }

    private void createWindow() {
        frameBuilder = new FrameBuilder(this);
    }

    @Override
    public VerticalLayout getMainLayout() {
        return layout;
    }

    public IControl getControl(String id) {
        return frameBuilder.getControl(id);
    }
}
