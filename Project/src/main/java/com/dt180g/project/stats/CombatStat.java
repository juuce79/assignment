package com.dt180g.project.stats;

import com.dt180g.project.support.AppConfig;

public class CombatStat extends BaseStat {
    private BaseStat attributeReliance;
    private BaseStat traitReliance;

    public CombatStat(String statName, BaseStat attributeReliance, BaseStat traitReliance) {
        super(statName, 0);
        this.attributeReliance = attributeReliance;
        this.traitReliance = traitReliance;
    }

    @Override
    public int getBaseValue() {
        int attributeValue = (int) Math.round(attributeReliance.getModifiedValue() * AppConfig.COMBAT_STAT_MULTIPLIER);
        int traitValue = (int) Math.round(traitReliance.getModifiedValue() * AppConfig.COMBAT_STAT_MULTIPLIER);
        return attributeValue + traitValue;
    }
}
