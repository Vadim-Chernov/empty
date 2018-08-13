package cvr.bercut.lib.menu;

public @interface QMenuItem2 {
    String caption() default "";
    String icon() default "";
    String method() default "";
    MenuElementType type() default MenuElementType.ITEM;
}
