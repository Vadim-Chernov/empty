package cvr.bercut.lib.menu;

import java.util.List;

public interface I_Node {
    String caprion();
    List<I_Node> nodes();
    String icon();
    String command();
    I_Node parent();
}
