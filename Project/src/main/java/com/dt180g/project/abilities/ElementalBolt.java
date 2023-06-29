package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class ElementalBolt extends BaseAbility {
    private final String magicPhrase;
    private final String element;

    public ElementalBolt(String element) {
        super(AppConfig.MEDIUM_AP_COST, AppConfig.LOW_ENERGY_COST);
        this.magicPhrase = AppConfig.MAGICAL_PHRASE_2;
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
        return AppConfig.ABILITY_SINGLE_TARGET;
    }

    @Override
    public boolean execute(int targetCount, boolean magicPhrase) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s Bolt", magicPhrase, element);
    }
}
