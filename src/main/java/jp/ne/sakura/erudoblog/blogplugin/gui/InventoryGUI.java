package jp.ne.sakura.erudoblog.blogplugin.gui;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class InventoryGUI {

    protected final JavaPlugin plugin;
    protected final int slot;
    protected final String title;
    protected final Player player;
    protected final Inventory inventory;
    protected final Map<Integer, SlotCommand> map = new HashMap<>();

    public InventoryGUI(JavaPlugin main, int slot, String title, Player player) {
        this.plugin = main;
        this.slot = slot;
        this.title = title;
        this.player = player;
        inventory = create();
        initialize();
    }

    private Inventory create() {
        Inventory inv = Bukkit.createInventory(null, slot, title);
        return inv;
    }

    protected abstract void initialize();

    protected void addItem(SlotCommand slotCommand) {
        int slot = slotCommand.slot;
        if (map.containsKey(slot)) map.remove(slot);
        inventory.setItem(slot, slotCommand.item);
        map.put(new Integer(slot), slotCommand);
    }

    public void open() {
        player.openInventory(inventory);
    }

    public boolean onClick(int slot, ClickType click) throws InvalidConfigurationException {
        SlotCommand slotCommand = map.get(new Integer(slot));
        if (slotCommand == null) return true;
        return map.get(new Integer(slot)).onClick(click);
    }
}