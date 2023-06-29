package com.dt180g.project.abilities;

public abstract class BaseAbility {
    private int actionPointCost;
    private int energyCost;

    protected BaseAbility(int actionPointCost, int energyCost) {
        this.actionPointCost = actionPointCost;
        this.energyCost = energyCost;
    }

    protected String performAbilityInfo() {
        String abilityType = isMagic() ? "Magical " : "Physical ";
        String abilityName = getClass().getSimpleName();
        return String.format("%s%s (AP: %d, Energy: %d)", abilityType, abilityName, actionPointCost, energyCost);
    }

    public int getActionPointCost() {
        return actionPointCost;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public abstract boolean isMagic();

    public abstract boolean isHeal();

    public abstract int getAmountOfTargets();

    public abstract boolean execute(int targetCount, boolean magicPhrase);
}
