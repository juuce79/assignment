package com.dt180g.project.characters.enemies;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.abilities.HeavyAttack;
import com.dt180g.project.abilities.Whirlwind;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.ElementalBolt;
import com.dt180g.project.abilities.ElementalBlast;
import com.dt180g.project.abilities.FocusedHeal;

public class LichLord extends BaseEnemy {
    public LichLord() {
        super(AppConfig.ENEMY_LICH_LORD, AppConfig.ATTRIBUTE_VALUES_LICH_LORD);
        addAbilities(Arrays.asList(
            new WeaponAttack(),
            new HeavyAttack(),
            new Whirlwind(),
            new ElementalBolt(AppConfig.ELEMENT_FIRE),
            new ElementalBlast(AppConfig.ELEMENT_FIRE),
            new FocusedHeal()
        ));
    }
}
