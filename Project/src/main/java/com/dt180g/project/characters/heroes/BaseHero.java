package com.dt180g.project.characters.heroes;

import java.util.List;

import com.dt180g.project.characters.BaseCharacter;
import com.dt180g.project.characters.CharacterStats;
import com.dt180g.project.gear.GearManager;
import com.dt180g.project.gear.Weapon;
import com.dt180g.project.stats.Attribute;
import com.dt180g.project.stats.Trait;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.gear.Armor;
import com.dt180g.project.support.ActivityLogger;

public abstract class BaseHero extends BaseCharacter {
    private String characterName;

    protected BaseHero(String characterName, List<Integer> attributes) {
        super(new CharacterStats(attributes));
        this.characterName = characterName;
        equipHero(this.getClass());
    }

    protected void equipHero(Class<?> characterClass) {
        while (this.getEquipment().amountOfEmptyWeaponSlots() > 0) {
            Weapon weapon;
            if (this.getEquipment().amountOfEmptyWeaponSlots() == 1) {
                weapon = GearManager.INSTANCE.getRandomOneHandedWeapon(characterClass);
            } else {
                weapon = GearManager.INSTANCE.getRandomWeapon(characterClass);
            }
            if (weapon != null) {
                this.getEquipment().addWeapon(weapon);
                Attribute attribute = (Attribute) weapon.getStat();
                this.characterStats.adjustStatStaticModifier(attribute.getStatName(), attribute.getBaseValue());
            }
        }

        String[] slots = {AppConfig.ARMOR_CHEST, AppConfig.ARMOR_FEET, AppConfig.ARMOR_HANDS, AppConfig.ARMOR_HEAD, AppConfig.ARMOR_LEGS};
        List<Armor> currentArmorPieces = this.getEquipment().getArmorPieces();

        for (int i = 0; i < slots.length; i++) {
            Armor currentArmor = currentArmorPieces.get(i);
            if (currentArmor.getProtection() == 0) {
                Armor armor = GearManager.INSTANCE.getRandomArmorOfType(slots[i], characterClass);
                if (armor != null) {
                    this.getEquipment().addArmorPiece(slots[i], armor);
                    Trait trait = (Trait) armor.getStat();
                    this.characterStats.adjustStatStaticModifier(trait.getStatName(), trait.getBaseValue());
                }
            }
        }
    }

    public void resetHeroStats() {
        this.characterStats.resetHitPoints();
        this.characterStats.resetEnergyLevel();
        this.characterStats.resetActionPoints();
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void doTurn() {
        ActivityLogger logger = ActivityLogger.getInstance();

        logger.logTurnInfo("Turn for character: " + getCharacterName());
    }
}
