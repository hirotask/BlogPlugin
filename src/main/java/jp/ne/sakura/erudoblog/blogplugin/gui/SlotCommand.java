package jp.ne.sakura.erudoblog.blogplugin.gui;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public abstract class SlotCommand {

    public final int slot;
    public final ItemStack item;

    public SlotCommand(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
    }

    public abstract boolean onClick(ClickType click) throws InvalidConfigurationException;
}