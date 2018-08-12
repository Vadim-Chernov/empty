package cvr.bercut.empty.ui;

import cvr.bercut.lib.menu.*;

@QMenu(bars = {@QMenuBar
        (caption = "File", items = {
                @QMenuItem(caption = "111"),
                @QMenuItem(caption = "111",
                        items = {@QMenuItem1(caption = "222" ,items = @QMenuItem2(caption = "333"))}

                ),
                @QMenuItem(caption = "111"),
                @QMenuItem(caption = "111")}
        )
})

public class MainFrameMenu implements IMenu {
}
