package cvr.bercut.lib.controls;

import com.vaadin.ui.*;
import cvr.bercut.lib.forms.QCell;

import java.util.List;

public class ASlider extends Slider implements IControl, IMinMax {

    @Override
    public Object getVal() {
        Double value = super.getValue();
        return value;
    }

    @Override
    public void setVal(Object o) {
        String str = o.toString();
        double d = Double.parseDouble(str);
        super.setValue(d);
    }

    @Override
    public IControl self() {
        return this;
    }

}
//    static IControl createCo(QCell cell) {
//        ASlider as = new ASlider();
//        as.setCaption(cell.caption());
//        as.setMax(cell.max());
//        as.setMin(cell.min());
//        as.setResolution(cell.resolution());
//        as.setWidth("100%");
//        return as;
//    }
