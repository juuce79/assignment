package com.dt180g.project.characters;

import com.dt180g.project.stats.Attribute;
import com.dt180g.project.stats.BaseStat;
import com.dt180g.project.stats.CombatStat;
import com.dt180g.project.stats.Trait;
import com.dt180g.project.support.AppConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterStats {
    private Map<String, BaseStat> stats;

    public CharacterStats(List<Integer> attributes) {
        stats = new HashMap<>();

        BaseStat strength = new Attribute(AppConfig.ATTRIBUTE_STRENGTH, attributes.get(0) * AppConfig.ATTRIBUTE_BASE_VALUE);
        BaseStat dexterity = new Attribute(AppConfig.ATTRIBUTE_DEXTERITY, attributes.get(1) * AppConfig.ATTRIBUTE_BASE_VALUE);
        BaseStat intelligence = new Attribute(AppConfig.ATTRIBUTE_INTELLIGENCE, attributes.get(2) * AppConfig.ATTRIBUTE_BASE_VALUE);
        BaseStat willpower = new Attribute(AppConfig.ATTRIBUTE_WILLPOWER, attributes.get(3) * AppConfig.ATTRIBUTE_BASE_VALUE);
        
        stats.put(strength.getStatName(), strength);
        stats.put(dexterity.getStatName(), dexterity);
        stats.put(intelligence.getStatName(), intelligence);
        stats.put(willpower.getStatName(), willpower);
    
        BaseStat vitality = new Trait(AppConfig.TRAIT_VITALITY, AppConfig.TRAIT_VITALITY_BASE_VALUE);
        BaseStat energy = new Trait(AppConfig.TRAIT_ENERGY, AppConfig.TRAIT_ENERGY_BASE_VALUE);
        BaseStat attackRate = new Trait(AppConfig.TRAIT_ATTACK_RATE, AppConfig.TRAIT_ATTACK_RATE_BASE_VALUE);
        BaseStat defenceRate = new Trait(AppConfig.TRAIT_DEFENSE_RATE, AppConfig.TRAIT_DEFENCE_RATE_BASE_VALUE);
    
        stats.put(vitality.getStatName(), vitality);
        stats.put(energy.getStatName(), energy);
        stats.put(attackRate.getStatName(), attackRate);
        stats.put(defenceRate.getStatName(), defenceRate);
    
        BaseStat physicalPower = new CombatStat(AppConfig.COMBAT_STAT_PHYSICAL_POWER, strength, attackRate);
        BaseStat actionPoints = new CombatStat(AppConfig.COMBAT_STAT_ACTION_POINTS, dexterity, attackRate);
        BaseStat magicalPower = new CombatStat(AppConfig.COMBAT_STAT_MAGIC_POWER, intelligence, attackRate);
        BaseStat healingPower = new CombatStat(AppConfig.COMBAT_STAT_HEALING_POWER, willpower, attackRate);

        stats.put(physicalPower.getStatName(), physicalPower);
        stats.put(actionPoints.getStatName(), actionPoints);
        stats.put(magicalPower.getStatName(), magicalPower);
        stats.put(healingPower.getStatName(), healingPower);
    }

    public BaseStat getStat(String name) {
        return stats.get(name);
    }

    public int getStatValue(String name) {
        BaseStat stat = getStat(name);
        if (stat == null) {
        }
        return stat != null ? stat.getModifiedValue() : 0;
    }

    public int getTotalActionPoints() {
        int currentAP = getCurrentActionPoints();
        int actionModifier = getStat(AppConfig.COMBAT_STAT_ACTION_POINTS).getTotalModifier();
        int totalAP = currentAP - actionModifier;
        return totalAP;
    }

    public int getCurrentActionPoints() {
        return getStatValue(AppConfig.COMBAT_STAT_ACTION_POINTS);
    }

    public int getTotalHitPoints() {
        int currentHP = getCurrentHitPoints();
        int vitalityModifier = getStat(AppConfig.TRAIT_VITALITY).getTotalModifier();
        int totalHP = currentHP - vitalityModifier;
        return totalHP;
    }

    public int getCurrentHitPoints() {
        return getStatValue(AppConfig.TRAIT_VITALITY);
    }

    public int getTotalEnergyLevel() {
        int currentEnergy = getCurrentEnergyLevel();
        int energyModifier = getStat(AppConfig.TRAIT_ENERGY).getTotalModifier();
        int totalEnergy = currentEnergy - energyModifier;
        return totalEnergy;
    }
    
    public int getCurrentEnergyLevel() {
        return getStatValue(AppConfig.TRAIT_ENERGY);
    }

    public int getDefenceRate() {
        return getStatValue(AppConfig.TRAIT_DEFENSE_RATE);
    }

    public int getAttackRate() {
        return getStatValue(AppConfig.TRAIT_ATTACK_RATE);
    }

    public int getPhysicalPower() {
        return getStatValue(AppConfig.COMBAT_STAT_PHYSICAL_POWER);
    }

    public int getMagicPower() {
        return getStatValue(AppConfig.COMBAT_STAT_MAGIC_POWER);
    }

    public int getHealingPower() {
        return getStatValue(AppConfig.COMBAT_STAT_HEALING_POWER);
    }

    public void adjustActionPoints(int amount) {
        BaseStat actionPointsStat = getStat(AppConfig.COMBAT_STAT_ACTION_POINTS);
        actionPointsStat.adjustDynamicModifier(amount);
        System.out.println("Adjusting dynamic action points by " + amount);
    }

    public void adjustHitPoints(int amount) {
        BaseStat vitalityStat = getStat(AppConfig.TRAIT_VITALITY);
        vitalityStat.adjustDynamicModifier(amount);
        System.out.println("Adjusting dynamic hit points by " + amount);
    }

    public void adjustEnergyLevel(int amount) {
        BaseStat energyLevelStat = getStat(AppConfig.TRAIT_ENERGY);
        energyLevelStat.adjustDynamicModifier(amount);
        System.out.println("Adjusting dynamic energy level by " + amount);
    }

    public void adjustStatStaticModifier(String name, int amount) {
        getStat(name).adjustStaticModifier(amount);
        System.out.println("Adjusting static " + name + " by " + amount);
    }

    public void adjustStatDynamicModifier(String name, int amount) {
        getStat(name).adjustDynamicModifier(amount);
        System.out.println("Adjusting dynamic " + name + " by " + amount);
    }

    public void resetActionPoints() {
        BaseStat actionPointsStat = getStat(AppConfig.COMBAT_STAT_ACTION_POINTS);
        actionPointsStat.resetDynamicModifier();
    }

    public void resetHitPoints() {
        BaseStat vitalityStat = getStat(AppConfig.TRAIT_VITALITY);
        vitalityStat.resetDynamicModifier();
    }

    public void resetEnergyLevel() {
        BaseStat energyLevelStat = getStat(AppConfig.TRAIT_ENERGY);
        energyLevelStat.resetDynamicModifier();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("STATISTICS\n");

        String[] group1 = {"Strength", "Dexterity", "Intelligence", "Willpower"};
        String[] group2 = {"Vitality", "Energy", "Attack Rate", "Defense Rate"};
        String[] group3 = {"Action Points", "Physical Power", "Magical Power", "Healing Power"};

        for (int i = 0; i < group1.length; i++) {
            String name1 = group1[i];
            String name2 = group2[i];
            String name3 = group3[i];

            BaseStat stat1 = stats.get(name1);
            BaseStat stat2 = stats.get(name2);
            BaseStat stat3 = stats.get(name3);

            sb.append(String.format("%-14s %3d  %4s  |  ", name1, stat1.getBaseValue(), "+" + stat1.getStaticModifier()));
            sb.append(String.format("%-14s %3d  %4s  |  ", name2, stat2.getBaseValue(), "+" + stat2.getStaticModifier()));
            sb.append(String.format("%-14s %3d  %4s\n", name3, stat3.getBaseValue(), "+" + stat3.getStaticModifier()));
        }

        return sb.toString().trim();
    }
}
