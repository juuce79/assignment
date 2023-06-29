package com.dt180g.project.gear;

import java.util.ArrayList;
import java.util.List;

import com.dt180g.project.characters.enemies.LichLord;
import com.dt180g.project.characters.enemies.SkeletonArcher;
import com.dt180g.project.characters.enemies.SkeletonMage;
import com.dt180g.project.characters.enemies.SkeletonWarrior;
import com.dt180g.project.characters.heroes.Cleric;
import com.dt180g.project.characters.heroes.Ranger;
import com.dt180g.project.characters.heroes.Warrior;
import com.dt180g.project.characters.heroes.Wizard;
import com.dt180g.project.stats.BaseStat;

public abstract class BaseGear {
    private String type;
    private String gearName;
    private List<Class<?>> classRestrictions;

    public BaseGear(String type, String gearName, String classRestrictions) {
        this.type = type;
        this.gearName = gearName;
        this.classRestrictions = new ArrayList<>();
        if (classRestrictions != null) {
            String[] restrictions = classRestrictions.split(",");
            for (String restriction : restrictions) {
                switch (restriction) {
                    case "Ranger":
                        this.classRestrictions.add(Ranger.class);
                        break;
                    case "Warrior":
                        this.classRestrictions.add(Warrior.class);
                        break;
                    case "Cleric":
                        this.classRestrictions.add(Cleric.class);
                        break;
                    case "Wizard":
                        this.classRestrictions.add(Wizard.class);
                        break;
                    case "SkeletonArcher":
                        this.classRestrictions.add(SkeletonArcher.class);
                        break;
                    case "SkeletonWarrior":
                        this.classRestrictions.add(SkeletonWarrior.class);
                        break;
                    case "SkeletonMage":
                        this.classRestrictions.add(SkeletonMage.class);
                        break;
                    case "LichLord":
                        this.classRestrictions.add(LichLord.class);
                        break;
                }
            }
        } else {
        }
    }

    public String getType() {
        return type;
    }

    public List<Class<?>> getClassRestrictions() {
        return classRestrictions;
    }

    public boolean checkClassRestriction(Class<?> characterClass) {
        return classRestrictions.stream()
            .anyMatch(clazz -> clazz.getSimpleName().equals(characterClass.getSimpleName()));
    }

    public abstract BaseStat getStat();

    @Override
    public String toString() {
        return gearName;
    }
}
