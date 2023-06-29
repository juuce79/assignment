package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class HeavyAttack extends BaseAbility {
    public HeavyAttack() {
        super(AppConfig.MEDIUM_AP_COST, AppConfig.LOW_ENERGY_COST);
    }

    @Override
    public boolean isMagic() {
        return false;
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
        return "Heavy Attack";
    }
}
