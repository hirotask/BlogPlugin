package jp.ne.sakura.erudoblog.blogplugin.gui.menu;

import jp.ne.sakura.erudoblog.blogplugin.gui.InventoryGUI;
import jp.ne.sakura.erudoblog.blogplugin.gui.SlotCommand;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class TestMenu extends InventoryGUI {

    public static final String title = "テストメニュー";

    public TestMenu(JavaPlugin main, Player player) {
        super(main, 18, title, player);
    }

    @Override
    protected void initialize() {
        //アイテムの作成
        ItemStack item = new ItemStack(Material.STONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("石！！！");
        item.setItemMeta(meta);

        addItem(new SlotCommand(0, item) {
            @Override
            public boolean onClick(ClickType click) throws InvalidConfigurationException {
                //石がクリックされたときの処理
                return true;
            }
        });
    }
}
