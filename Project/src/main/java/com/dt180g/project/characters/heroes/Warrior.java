package com.dt180g.project.characters.heroes;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.abilities.HeavyAttack;
import com.dt180g.project.abilities.Whirlwind;
import com.dt180g.project.support.AppConfig;

public class Warrior extends BaseHero {
    public Warrior(String name) {
        super(name + " The " + AppConfig.HERO_WARRIOR, AppConfig.ATTRIBUTE_VALUES_WARRIOR_HERO);
        addAbilities(Arrays.asList(new WeaponAttack(), new HeavyAttack(), new Whirlwind()));
    }
}
