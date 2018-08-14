package cvr.bercut.lib.menu;

public @interface QMenuItem1 {
    String id();

    boolean enabled() default true;

    boolean visible() default true;

    String caption() default "";

    String icon() default "";

    String method() default "";

    QMenuItem2[] items() default {};

    MenuElementType type() default MenuElementType.ITEM;

}
