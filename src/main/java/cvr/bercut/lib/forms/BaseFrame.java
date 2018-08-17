package cvr.bercut.lib.forms;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.controls.IControl;

public class BaseFrame extends VerticalLayout implements IFrame {

    private FrameBuilder builder;

    @Override
    public VerticalLayout getMainLayout() {
        return this;
    }

    public BaseFrame(AbstractLayout la) {
        builder = new FrameBuilder(this);
        la.addComponent(this);
    }

    public IControl getControl(String id) {
        return builder.getControl(id);
    }

}
