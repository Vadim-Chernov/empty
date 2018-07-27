package cvr.bercut.lib.forms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface QRow {

//    String leadText() default "";

    QCell[] cells() default {};

//    String endText() default "";

    public boolean captionOnLeft() default false;;

}
