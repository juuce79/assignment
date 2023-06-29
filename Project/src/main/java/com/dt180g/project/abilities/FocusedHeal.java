package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class FocusedHeal extends BaseAbility {
    private final String magicPhrase;

    public FocusedHeal() {
        super(AppConfig.MEDIUM_AP_COST, AppConfig.LOW_ENERGY_COST);
        this.magicPhrase = AppConfig.MAGICAL_PHRASE_4;
    }

    @Override
    public boolean isMagic() {
        return true;
    }

    @Override
    public boolean isHeal() {
        return true;
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
        return String.format("%s: %s", magicPhrase, AppConfig.ABILITY_FOCUSED_HEAL);
    }
}
