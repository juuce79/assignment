package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class GroupHeal extends BaseAbility {
    private final String magicPhrase;

    public GroupHeal() {
        super(AppConfig.HIGHEST_AP_COST, AppConfig.HIGH_ENERGY_COST);
        this.magicPhrase = AppConfig.MAGICAL_PHRASE_3;
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
        return AppConfig.ABILITY_GROUP_TARGET;
    }

    @Override
    public boolean execute(int targetCount, boolean magicPhrase) {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", magicPhrase, AppConfig.ABILITY_GROUP_HEAL);
    }
}
