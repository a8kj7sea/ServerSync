package com.ultimismc.skywars.core.game.features.kits.impl;

import com.ultimismc.skywars.core.game.features.PurchasableDesign;
import com.ultimismc.skywars.core.game.features.kits.AbstractKit;
import com.ultimismc.skywars.core.game.features.kits.KitRarity;
import lombok.Getter;
import org.bukkit.Material;

/**
 * @author DirectPlan
 */
@Getter
public class ArmorsmithKit extends AbstractKit {

    private final PurchasableDesign design = new PurchasableDesign(Material.ANVIL);

    public ArmorsmithKit() {
        super("Armorsmith", KitRarity.COMMON);
    }

    @Override
    public boolean isDefault() {
        return true;
    }
}
