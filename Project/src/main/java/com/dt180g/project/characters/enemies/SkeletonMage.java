package com.dt180g.project.characters.enemies;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.ElementalBolt;
import com.dt180g.project.abilities.ElementalBlast;

public class SkeletonMage extends BaseEnemy {
    public SkeletonMage(int id) {
        super(AppConfig.ENEMY_SKELETON_MAGE + " " + id, AppConfig.ATTRIBUTE_VALUES_SKELETON_MAGE);
        addAbilities(Arrays.asList(
            new WeaponAttack(), 
            new ElementalBolt(AppConfig.ELEMENT_FIRE), new ElementalBolt(AppConfig.ELEMENT_ICE), new ElementalBolt(AppConfig.ELEMENT_AIR), 
            new ElementalBlast(AppConfig.ELEMENT_FIRE), new ElementalBlast(AppConfig.ELEMENT_ICE), new ElementalBlast(AppConfig.ELEMENT_AIR)
        ));
    }
}
