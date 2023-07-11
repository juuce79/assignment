package com.dt180g.project.characters.enemies;

import java.util.List;

import com.dt180g.project.characters.BaseCharacter;
import com.dt180g.project.characters.CharacterStats;
import com.dt180g.project.gear.GearManager;
import com.dt180g.project.gear.Weapon;
import com.dt180g.project.stats.Attribute;
import com.dt180g.project.support.ActivityLogger;

public abstract class BaseEnemy extends BaseCharacter {
    private String characterName;

    protected BaseEnemy(String characterName, List<Integer> attributes) {
        super(new CharacterStats(attributes)); 
        this.characterName = characterName;
    }

    protected void equipEnemy(List<String> gearIdentifiers) {
        int emptySlots = this.getEquipment().amountOfEmptyWeaponSlots();
        System.out.println("Amount of empty weapon slots: " + emptySlots);
        while (emptySlots > 0) {
            Weapon weapon;
            if (emptySlots == 1) {
                weapon = GearManager.INSTANCE.getRandomOneHandedWeapon(this.getClass());
            } else {
                weapon = GearManager.INSTANCE.getRandomWeapon(this.getClass());
            }
            if (weapon != null) {
                this.getEquipment().addWeapon(weapon);
                Attribute attribute = (Attribute) weapon.getStat();
                this.characterStats.adjustStatStaticModifier(attribute.getStatName(), attribute.getBaseValue());
                System.out.println("Equipping enemy with Weapon " + weapon + ", with Attribute: " + attribute.getStatName() + " and Base Value: " + attribute.getBaseValue());
            } else {
                System.out.println("No weapon was returned by the GearManager");
            }
            emptySlots = this.getEquipment().amountOfEmptyWeaponSlots();
        }
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void doTurn() {
        ActivityLogger logger = ActivityLogger.getInstance();

        logger.logTurnInfo("Turn for character: " + getCharacterName());
    }
}
