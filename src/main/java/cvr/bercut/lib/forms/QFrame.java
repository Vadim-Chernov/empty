package cvr.bercut.lib.forms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)


public @interface QFrame {
    String title() default "";
    QRow[] rows() default {};
    String footer() default "";
    String height() default "50%";
    String width() default "50%";

}
