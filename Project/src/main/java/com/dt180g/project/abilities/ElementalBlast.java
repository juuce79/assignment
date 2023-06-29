package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class ElementalBlast extends BaseAbility {
    private final String magicPhrase;
    private final String element;

    public ElementalBlast(String element) {
        super(AppConfig.HIGHEST_AP_COST, AppConfig.HIGH_ENERGY_COST);
        this.magicPhrase = AppConfig.MAGICAL_PHRASE_1;
        this.element = element;
    }

    @Override
    public boolean isMagic() {
        return true;
    }

    @Override
    public boolean isHeal() {
        return false;
    }

    @Override
    public int getAmountOfTargets() {
        return AppConfig.ABILITY_GROUP_TARGET;
    }

    @Override
    public boolean execute(int targetCount, boolean magicPhrase) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s", magicPhrase, element, AppConfig.ABILITY_ELEMENTAL_BLAST);
    }
}
