package cvr.bercut.lib.security;

import cvr.bercut.lib.menu.IMenu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})

public @interface QSecurity {
    Class<? extends IMenu> menu() default IMenu.class;
}
