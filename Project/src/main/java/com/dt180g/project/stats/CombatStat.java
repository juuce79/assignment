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
        return (int) Math.round((attributeReliance.getModifiedValue() + traitReliance.getModifiedValue()) * AppConfig.COMBAT_STAT_MULTIPLIER);
    }
}
