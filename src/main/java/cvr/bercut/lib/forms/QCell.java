package cvr.bercut.lib.forms;

import cvr.bercut.lib.controls.IControl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface QCell {

    String id() default "";

    String caption() default "";

    Class<? extends IControl> control();

    int weight() default 1;

    double min() default 0;

    double max() default 0;

    public int resolution() default 0;
}
