package com.dt180g.project.stats;

public abstract class BaseStat {
    private String statName;
    private int baseValue;
    private int staticModifier;
    private int dynamicModifier;

    protected BaseStat(String statName, int baseValue) {
        this.statName = statName;
        this.baseValue = baseValue;
        this.staticModifier = 0;
        this.dynamicModifier = 0;
    }

    public String getStatName() {
        return statName;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public int getTotalModifier() {
        return staticModifier + dynamicModifier;
    }

    public int getStaticModifier() {
        return staticModifier;
    }

    public void adjustStaticModifier(int modifier) {
        this.staticModifier += modifier;
    }

    public void adjustDynamicModifier(int modifier) {
        this.dynamicModifier += modifier;
    }

    public void resetDynamicModifier() {
        this.dynamicModifier = 0;
    }

    public int getModifiedValue() {
        return getBaseValue() + getTotalModifier();
    }

    @Override
    public String toString() {
        return String.format("StatName: %s, BaseValue: %d, ModifiedValue: %d, TotalModifier: %d",
                getStatName(), getBaseValue(), getModifiedValue(), getTotalModifier());
    }
}
