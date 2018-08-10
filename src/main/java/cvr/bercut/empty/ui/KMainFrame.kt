package cvr.bercut.empty.ui

import com.vaadin.ui.MenuBar
import com.vaadin.ui.VerticalLayout
import cvr.bercut.lib.menu.GMenu
import cvr.bercut.lib.security.QSecurity

class KMainFrame : VerticalLayout() {
    private val menuBar = MenuBar()

    init {
        addComponent(menuBar)
        isVisible = true
    }

    private var gMenu: GMenu? = null

    fun buildMenu() {
        val ann = MainFrame::class.java.getAnnotation(QSecurity::class.java)
        val menu = ann.menu
        try {
            gMenu =  menu.objectInstance
        } catch (e: Exception) {
            e.printStackTrace()
            return
        }
        val bars = gMenu.bars
        for (mb in bars) {
            val caption = mb.caption
            val mi = mb.items
            val menuItem = menuBar.addItem(caption)
            for (mim in mi) {
                menuItem.addItem(mim.caption)
            }
        }
    }

}