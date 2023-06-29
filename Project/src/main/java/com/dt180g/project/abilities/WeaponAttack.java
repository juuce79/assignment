package com.dt180g.project.abilities;

import com.dt180g.project.support.AppConfig;

public class WeaponAttack extends BaseAbility {
    public WeaponAttack() {
        super(AppConfig.LOWEST_AP_COST, 0);
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
        return AppConfig.ABILITY_WEAPON_ATTACK;
    }
}
