package cvr.bercut.lib.menu;

public @interface QMenuItem  {
    String caption() default "";
    String icon() default "";
    String method() default "";
    QMenuItem1[] items() default {};
    MenuElement type() default MenuElement.ITEM;
}
