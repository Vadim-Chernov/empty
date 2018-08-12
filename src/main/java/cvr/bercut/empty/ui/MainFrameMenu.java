package cvr.bercut.empty.ui;

import cvr.bercut.lib.menu.IMenu;
import cvr.bercut.lib.menu.QMenu;
import cvr.bercut.lib.menu.QMenuBar;
import cvr.bercut.lib.menu.QMenuItem;

@QMenu(bars = {@QMenuBar
        (caption = "File", items = {
                @QMenuItem(caption = "111"),
                @QMenuItem(caption = "111"),
                @QMenuItem(caption = "111"),
                @QMenuItem(caption = "111")}
        )
})

public class MainFrameMenu implements IMenu {
}
