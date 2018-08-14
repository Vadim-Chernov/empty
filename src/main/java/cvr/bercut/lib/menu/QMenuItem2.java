package cvr.bercut.lib.menu;

public @interface QMenuItem2 {
    String id();

    boolean enabled() default true;

    boolean visible() default true;

    String caption() default "";

    String icon() default "";

    String method() default "";

    MenuElementType type() default MenuElementType.ITEM;
}
