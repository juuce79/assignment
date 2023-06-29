package com.dt180g.project.characters.enemies;

import java.util.Arrays;
import com.dt180g.project.abilities.WeaponAttack;
import com.dt180g.project.support.AppConfig;
import com.dt180g.project.abilities.FocusedShot;
import com.dt180g.project.abilities.SprayOfArrows;

public class SkeletonArcher extends BaseEnemy {
    public SkeletonArcher(int id) {
        super(AppConfig.ENEMY_SKELETON_ARCHER + " " + id, AppConfig.ATTRIBUTE_VALUES_SKELETON_ARCHER);
        addAbilities(Arrays.asList(new WeaponAttack(), new FocusedShot(), new SprayOfArrows()));
    }
}
