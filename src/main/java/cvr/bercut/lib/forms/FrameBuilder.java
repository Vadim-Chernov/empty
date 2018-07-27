/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvr.bercut.lib.forms;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import cvr.bercut.lib.controls.AEmpty;
import cvr.bercut.lib.controls.ALabel;
import cvr.bercut.lib.controls.IControl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chernov
 */
public class FrameBuilder {

    private final VerticalLayout ctx;
    private Map<String, IControl> controls = new HashMap<>();

    public FrameBuilder(IFrame frame) {
        ctx = frame.getMainLayout();
        QFrame ann = frame.getClass().getAnnotation(QFrame.class);
        if (ann == null)
            throw new Error("Отсутствует аннотация описания формы");
        else {
            if (!"".equals(ann.title())) {
                setCaption(ann.title());
            }
            QRow[] rows = ann.rows();
            for (QRow row : rows) {
                int widthOfRow = widthOfRow(row);
                if (widthOfRow == 0) {
                    ctx.addComponent(new AEmpty());
                    continue;
                }
                GridLayout gl = new GridLayout(widthOfRow, 1);
//                gl.setHeight("15%");
                gl.setWidth("100%");
                MarginInfo mi = new MarginInfo(false, true, false, true);
                gl.setMargin(mi);

                int col = 0;
                QCell[] cells = row.cells();
                for (QCell cell : cells) {
                    IControl cntrl = IControl.createCo(cell);
                    cntrl.setCaption(cell.caption());
                    ((AbstractComponent) cntrl).setWidth("100%");
                    cntrl.drow(gl, col, col + cell.weight() - 1);
                    String id = cell.id();
                    if (!"".equals(id)) {
                        IControl get = controls.get(id);
                        if (get != null)
                            throw new Error(" Дублирование ключа (Key violation)" + id);
                        else
                            controls.put(id, cntrl);
                    }
                    col += cell.weight();
                }
                ctx.addComponent(gl);
            }
            if (!"".equals(ann.footer())) {
                ALabel l = new ALabel();
                l.setCaption(ann.footer());
                l.drow(ctx);

            }
        }
    }

    private void setCaption(String title) {
    }

    public IControl getControl(String id) {
        IControl get = controls.get(id);
        if(get==null)
            throw new Error(" Object with id="+id+" not exists!!! ");

        return get;
    }

    private int widthOfRow(QRow row) {
        int len = 0;
        for (QCell cell : row.cells())
            len += (cell.weight());
        return len;
    }

}
