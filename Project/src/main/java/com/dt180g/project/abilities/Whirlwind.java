package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class Whirlwind extends BaseAbility {
    public Whirlwind() {
        super(AppConfig.HIGHEST_AP_COST, AppConfig.HIGH_ENERGY_COST);
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
        return AppConfig.ABILITY_GROUP_TARGET;
    }

    @Override
    public boolean execute(int targetCount, boolean magicPhrase) {
        return true;
    }

    @Override
    public String toString() {
        return "Whirlwind";
    }
}
