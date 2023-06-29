package com.dt180g.project.characters;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.dt180g.project.abilities.BaseAbility;

public abstract class BaseCharacter {
    protected CharacterStats characterStats;
    private CharacterEquipment equipment;
    private List<BaseAbility> abilities;

    protected BaseCharacter(CharacterStats characterStats) {
        this.characterStats = characterStats;
        this.equipment = new CharacterEquipment();
        this.abilities = new ArrayList<>();
    }

    protected void addAbilities(List<BaseAbility> abilities) {
        if(this.abilities == null){
            this.abilities = new ArrayList<>();
        }
        this.abilities.addAll(abilities);
    }

    protected String getTurnInformation(String info) {
        return String.format("Turn Information: %s", info);
    }

    protected boolean executeActions(boolean action) {
        return action;
    }

    protected Deque<BaseAbility> determineActions() {
        return new LinkedList<>(this.abilities);
    }

    public List<Integer> registerDamage(int damage, boolean isMagic) {
        int currentHitPoints = this.characterStats.getCurrentHitPoints();
        int newHitPoints = Math.max(currentHitPoints - damage, 0);
        int actualDamage = currentHitPoints - newHitPoints;

        this.characterStats.adjustHitPoints(-actualDamage);
        return null;
    }

    public int registerHealing(int healing) {
        int currentHitPoints = this.characterStats.getCurrentHitPoints();
        int maxHitPoints = this.characterStats.getTotalHitPoints();
        int newHitPoints = Math.min(currentHitPoints + healing, maxHitPoints);
        int actualHealing = newHitPoints - currentHitPoints;

        this.characterStats.adjustHitPoints(actualHealing);

        return actualHealing;
    }

    public void roundReset() {
        this.characterStats.resetActionPoints();
        this.characterStats.resetHitPoints();
        this.characterStats.resetEnergyLevel();
    }

    public abstract void doTurn();

    public abstract String getCharacterName();

    public CharacterStats getCharacterStats() {
        return this.characterStats;
    }

    public CharacterEquipment getEquipment() {
        return this.equipment;
    }

    public int getActionPoints() {
        return this.characterStats.getTotalActionPoints();
    }

    public int getHitPoints() {
        return this.characterStats.getTotalHitPoints();
    }

    public int getEnergyLevel() {
        return this.characterStats.getTotalEnergyLevel();
    }

    public List<BaseAbility> getAbilities() {
        return this.abilities;
    }

    public boolean isDead() {
        return this.characterStats.getCurrentHitPoints() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("******************************************\n");
        sb.append(String.format("%20s%n", getCharacterName().toUpperCase()));
        sb.append("******************************************\n");
        sb.append(characterStats.toString());
        sb.append("\n");
        if (equipment != null) {
            sb.append(equipment.toString());
        }
        sb.append("\n");

        return sb.toString();
    }
}
