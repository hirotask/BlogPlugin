package jp.ne.sakura.erudoblog.blogplugin.gui;

import jp.ne.sakura.erudoblog.blogplugin.gui.menu.TestMenu;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

//インベントリがクリックされたときの記述
public class OnInventoryClick implements Listener {

    private JavaPlugin plugin;

    public OnInventoryClick(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryclick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        Player player = (Player) e.getWhoClicked();
        int slot = e.getSlot();
        ClickType clickType = e.getClick();

        if(title.equals(TestMenu.title)) {
            try {
                if(new TestMenu(plugin,player).onClick(slot,clickType)) {
                    e.isCancelled();
                }
            } catch (InvalidConfigurationException invalidConfigurationException) {
            }
        }
    }
}
