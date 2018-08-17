package cvr.bercut.empty.ui;

import cvr.bercut.lib.menu.*;


// Структура меню
@QMenu(id = "MainMenu",
        bars = {@QMenuBar(id = "bar1", caption = "File",
                items = {
                        @QMenuItem(id = "1", caption = "111"),
                        @QMenuItem(id = "2", caption = "111",
                                items = {@QMenuItem1(id = "3", caption = "222",
                                        items = {
                                                @QMenuItem2(id = "4", caption = "333"),
                                                @QMenuItem2(id = "41", caption = "56565"),
                                                @QMenuItem2(id = "42", caption = "7878787"),
                                                @QMenuItem2(id = "43", caption = "wertwt")
                                        })
                                }
                        ),
                        @QMenuItem(id = "5", caption = "111", type = MenuElementType.SEPARATOR),
                        @QMenuItem(id = "6", caption = "Выход", method = "close")}
        )
        })
class MainFrameMenu implements IMenu {
}
