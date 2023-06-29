package com.dt180g.project.characters.heroes;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.FocusedHeal;
import com.dt180g.project.abilities.GroupHeal;

public class Cleric extends BaseHero {
    public Cleric(String name) {
        super(name + " The " + AppConfig.HERO_CLERIC, AppConfig.ATTRIBUTE_VALUES_CLERIC_HERO);
        addAbilities(Arrays.asList(new WeaponAttack(), new FocusedHeal(), new GroupHeal()));
    }
}
