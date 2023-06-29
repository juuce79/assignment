package com.dt180g.project.characters.enemies;

import java.util.List;

import com.dt180g.project.characters.BaseCharacter;
import com.dt180g.project.characters.CharacterStats;
import com.dt180g.project.gear.GearManager;
import com.dt180g.project.gear.Weapon;
import com.dt180g.project.support.ActivityLogger;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.gear.Armor;

public abstract class BaseEnemy extends BaseCharacter {
    protected String characterName;

    protected BaseEnemy(String characterName, List<Integer> attributes) {
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
            } else {
                break;
            }
        }
    
        String[] slots = {AppConfig.ARMOR_CHEST, AppConfig.ARMOR_FEET, AppConfig.ARMOR_HANDS, AppConfig.ARMOR_HEAD, AppConfig.ARMOR_LEGS};
        for (String slot : slots) {
            if (this.getEquipment().getArmorPieces() == null) {
                Armor armor = GearManager.INSTANCE.getRandomArmorOfType(slot, characterClass);
                if (armor != null) {
                    this.getEquipment().addArmorPiece(slot, armor);
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
