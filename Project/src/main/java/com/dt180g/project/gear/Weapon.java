package com.dt180g.project.gear;

import java.util.Map;

import com.dt180g.project.stats.Attribute;
import com.dt180g.project.stats.BaseStat;
import com.dt180g.project.stats.StatsManager;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.support.Randomizer;

public class Weapon extends BaseGear {
    private int damage;
    private String wield;
    private Attribute attribute;

    public Weapon(Map<String, String> mappedValues) {
        super(mappedValues.get("type"), mappedValues.get("name"), mappedValues.get("restriction"));
        damage = Integer.parseInt(mappedValues.get("damage"));
        wield = mappedValues.get("wield");
        String attributeName = StatsManager.INSTANCE.getRandomAttributeName();
        attribute = new Attribute(attributeName, Randomizer.INSTANCE.getRandomValue(AppConfig.WEAPON_ATTRIBUTE_VALUE_UPPER_BOUND));
        System.out.println("Creating Weapon: " + getName() + " with Attribute: " + attribute.getStatName() + ", Base Value: " + attribute.getBaseValue());
    }

    public int getDamage() {
        return damage;
    }

    public String getWield() {
        return wield;
    }

    @Override
    public BaseStat getStat() {
        return attribute;
    }

    public boolean isTwoHanded() {
        return wield.equals("two-handed") || wield.toLowerCase().contains("two handed");
    }    

    @Override
    public String toString() {
        return super.toString() + " of " + attribute.getStatName();
    }
}
