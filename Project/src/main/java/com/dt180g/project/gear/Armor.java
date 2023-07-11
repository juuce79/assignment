package com.dt180g.project.gear;

import java.util.Map;

import com.dt180g.project.stats.BaseStat;
import com.dt180g.project.stats.StatsManager;
import com.dt180g.project.stats.Trait;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.support.Randomizer;

public class Armor extends BaseGear {
    private int protection;
    private String material;
    private Trait trait;

    public Armor(Map<String, String> mappedValues) {
        super(mappedValues.get("type"), mappedValues.get("name"), mappedValues.get("restriction"));
        protection = Integer.parseInt(mappedValues.get("protection"));
        material = mappedValues.get("material");
        String traitName = StatsManager.INSTANCE.getRandomTraitName();
        trait = new Trait(traitName, Randomizer.INSTANCE.getRandomValue(AppConfig.ARMOR_STAT_VALUE_UPPER_BOUND));
        System.out.println("Creating Armor with Trait: " + trait.getStatName() + ", Base Value: " + trait.getBaseValue());
    }

    public int getProtection() {
        return protection;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public BaseStat getStat() {
        return trait;
    }

    @Override
    public String toString() {
        return super.toString() + " of " + trait.getStatName();
    }
}
