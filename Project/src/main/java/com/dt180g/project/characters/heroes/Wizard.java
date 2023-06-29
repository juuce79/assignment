package com.dt180g.project.characters.heroes;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.ElementalBolt;
import com.dt180g.project.abilities.ElementalBlast;

public class Wizard extends BaseHero {
    public Wizard(String name) {
        super(name + " The " + AppConfig.HERO_WIZARD, AppConfig.ATTRIBUTE_VALUES_WIZARD_HERO);
        addAbilities(Arrays.asList(
            new WeaponAttack(), 
            new ElementalBolt(AppConfig.ELEMENT_FIRE), new ElementalBolt(AppConfig.ELEMENT_ICE), new ElementalBolt(AppConfig.ELEMENT_AIR), 
            new ElementalBlast(AppConfig.ELEMENT_FIRE), new ElementalBlast(AppConfig.ELEMENT_ICE), new ElementalBlast(AppConfig.ELEMENT_AIR)
        ));
    }
}
