package cvr.bercut.lib.menu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface QMenu {
    String id();

    boolean enabled() default true;

    boolean visible() default true;

    QMenuBar[] bars() default {};
}
