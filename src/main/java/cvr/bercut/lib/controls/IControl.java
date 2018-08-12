package cvr.bercut.lib.controls;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.AbstractLayout;

import cvr.bercut.lib.forms.QCell;

import java.io.Serializable;

public interface IControl extends Serializable {

    IControl self();

    Object getVal();

    void setVal(Object o);

    void setCaption(String caption);

    String getCaption();

    default IControl create(QCell cell) {
        return createCo(cell);
    }

    default void drow(GridLayout ctx, int from, int to) {
        FormLayout fl = new FormLayout();
        fl.setWidth("100%");
        fl.setMargin(false);
        fl.addComponent((Component) self());
        ctx.addComponent(fl, from, 0, to, 0);
        fl.setComponentAlignment((Component) self(), Alignment.MIDDLE_CENTER);
    }

    default void drow(GridLayout ctx, int at) {
        drow(ctx, at, at);
    }

    default void drow(AbstractLayout ctx) {
        ctx.addComponent((Component) self());
    }

    static IControl createCo(QCell cell) {
        IControl newInstance = null;
        Class<? extends IControl> control = cell.control();
        String canonicalName = control.getCanonicalName();
        try {
            Class<?> forName = Class.forName(canonicalName);
            newInstance = (IControl) forName.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (newInstance instanceof IMinMax) {
            ((IMinMax) newInstance).setMax(cell.max());
            ((IMinMax) newInstance).setMin(cell.min());
            ((IMinMax) newInstance).setResolution(cell.resolution());
        }
        return newInstance;
    }
}
