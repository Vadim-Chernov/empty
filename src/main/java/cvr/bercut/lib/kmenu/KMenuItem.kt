package cvr.bercut.lib.kmenu

import java.util.*

class KMenuItem(var caption: String?, icon: String, commandLine: String, items: List<KMenuItem>) {
    var icon: String? = null
    var commandLine: String? = null
    private var items: MutableList<KMenuItem> = ArrayList()

    fun getItem(index: Int): KMenuItem {
        return items[index]
    }

    fun addChildItem(item: KMenuItem, child: KMenuItem) {
        item.items.add(child)
    }

    fun getItems(): List<KMenuItem> {
        return items
    }

    fun setItems(items: MutableList<KMenuItem>) {
        this.items = items
    }
}
