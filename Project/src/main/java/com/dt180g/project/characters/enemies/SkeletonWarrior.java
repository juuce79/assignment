package com.dt180g.project.characters.enemies;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.abilities.HeavyAttack;
import com.dt180g.project.abilities.Whirlwind;
import com.dt180g.project.support.AppConfig;

public class SkeletonWarrior extends BaseEnemy {
    public SkeletonWarrior(int id) {
        super(AppConfig.ENEMY_SKELETON_WARRIOR + " " + id, AppConfig.ATTRIBUTE_VALUES_SKELETON_WARRIOR);
        addAbilities(Arrays.asList(new WeaponAttack(), new HeavyAttack(), new Whirlwind()));
    }
}
