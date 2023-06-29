package com.dt180g.project.characters.heroes;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.FocusedShot;
import com.dt180g.project.abilities.SprayOfArrows;

public class Ranger extends BaseHero {
    public Ranger(String name) {
        super(name + " The " + AppConfig.HERO_RANGER, AppConfig.ATTRIBUTE_VALUES_RANGER_HERO);
        addAbilities(Arrays.asList(new WeaponAttack(), new FocusedShot(), new SprayOfArrows()));
    }
}
