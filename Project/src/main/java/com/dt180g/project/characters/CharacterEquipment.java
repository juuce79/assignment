package com.dt180g.project.characters;

import com.dt180g.project.gear.Armor;
import com.dt180g.project.gear.Weapon;
import com.dt180g.project.support.AppConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterEquipment {
    private List<Weapon> weapons;
    private Map<String, Armor> armorPieces;

    public CharacterEquipment() {
        this.weapons = new ArrayList<>();
        this.armorPieces = new HashMap<>();

        Map<String, String> emptyArmorValues = new HashMap<>();
        emptyArmorValues.put("type", "None");
        emptyArmorValues.put("name", "None");
        emptyArmorValues.put("restriction", "None");
        emptyArmorValues.put("protection", "0");
        emptyArmorValues.put("material", "None");

        armorPieces.put(AppConfig.ARMOR_CHEST, new Armor(emptyArmorValues));
        armorPieces.put(AppConfig.ARMOR_FEET, new Armor(emptyArmorValues));
        armorPieces.put(AppConfig.ARMOR_HANDS, new Armor(emptyArmorValues));
        armorPieces.put(AppConfig.ARMOR_HEAD, new Armor(emptyArmorValues));
        armorPieces.put(AppConfig.ARMOR_LEGS, new Armor(emptyArmorValues));
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Armor> getArmorPieces() {
        return new ArrayList<>(armorPieces.values());
    }

    public int getTotalWeaponDamage() {
        int totalDamage = 0;
        for (Weapon weapon : weapons) {
            totalDamage += weapon.getDamage();
        }
        return totalDamage;
    }

    public int getTotalArmorProtection() {
        int totalProtection = 0;
        for (Armor armor : armorPieces.values()) {
            if (armor != null) {
                totalProtection += armor.getProtection();
            }
        }
        return totalProtection;
    }

    public int amountOfEmptyWeaponSlots() {
        int slotsOccupied = 0;
        for (Weapon weapon : weapons) {
            slotsOccupied += weapon.isTwoHanded() ? 2 : 1;
        }
        return 2 - slotsOccupied;
    }

    public int amountOfEmptyArmorSlots() {
        int emptySlots = 0;
        for (Armor armor : armorPieces.values()) {
            if (armor.getProtection() == 0) {
                emptySlots++;
            }
        }
        return emptySlots;
    }

    public boolean addWeapon(Weapon weapon) {
        if (weapon != null) {
            if (weapon.isTwoHanded()) {
                if (weapons.isEmpty()) {
                    weapons.add(weapon);
                    return true;
                }
            } else {
                if (weapons.size() < 2 && !(weapons.size() == 1 && weapons.get(0).isTwoHanded())) {
                    weapons.add(weapon);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addArmorPiece(String slot, Armor armor) {
        if (armorPieces.containsKey(slot) && armorPieces.get(slot).getProtection() == 0) {
            armorPieces.put(slot, armor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EQUIPMENT\n");
        if (armorPieces != null) {
            for (Map.Entry<String, Armor> entry : armorPieces.entrySet()) {
                String slot = entry.getKey();
                Armor armor = entry.getValue();
                if (armor != null) {
                    String weaponString = (weapons.size() > 0) ? weapons.get(0).toString() : "";
                    sb.append(String.format("%-10s | %-10s | Protection %+4d | %s%n",
                            "[" + slot + "]", armor.getMaterial(), armor.getProtection(), weaponString));
                    if (weapons.size() > 0) {
                        weapons.remove(0);
                    }
                }
            }
        }
        return sb.toString();
    }
}
