package cvr.bercut.lib.security;

import cvr.bercut.lib.menu.GMenu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface QSecurity {
    Class<? extends GMenu> menu() default GMenu.class;
}
