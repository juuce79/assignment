package com.dt180g.project.gear;

import com.dt180g.project.support.IOHelper;
import com.dt180g.project.support.Randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GearManager {
    public static final GearManager INSTANCE = new GearManager();
    private Map<String, List<Weapon>> weapons;
    private Map<String, List<Armor>> armorPieces;

    private GearManager() {
        weapons = getAllMappedWeapons();
        armorPieces = getAllMappedArmorPieces();
    }

    public Map<String, List<Weapon>> getAllMappedWeapons() {
        String filePath = "gear_weapons.json";
        List<Map<String, String>> weaponData = IOHelper.readFromFile(filePath);
        Map<String, List<Weapon>> weapons = new HashMap<>();
    
        for (Map<String, String> weaponDetails : weaponData) {
            String type = weaponDetails.get("type");
            Weapon weapon = new Weapon(weaponDetails);
    
            if (weapons.containsKey(type)) {
                weapons.get(type).add(weapon);
            } else {
                List<Weapon> weaponList = new ArrayList<>();
                weaponList.add(weapon);
                weapons.put(type, weaponList);
            }
        }
    
        return weapons;
    }    
    
    public Map<String, List<Armor>> getAllMappedArmorPieces() {
        String filePath = "gear_armor.json";
        List<Map<String, String>> armorData = IOHelper.readFromFile(filePath);
        Map<String, List<Armor>> armorPieces = new HashMap<>();
    
        for (Map<String, String> armorDetails : armorData) {
            String type = armorDetails.get("type");
            Armor armor = new Armor(armorDetails);
    
            if (armorPieces.containsKey(type)) {
                armorPieces.get(type).add(armor);
            } else {
                List<Armor> armorList = new ArrayList<>();
                armorList.add(armor);
                armorPieces.put(type, armorList);
            }
        }
    
        return armorPieces;
    }    

    public List<Weapon> getWeaponsOfType(String type) {
        return weapons.getOrDefault(type, new ArrayList<>());
    }

    public Weapon getRandomWeapon(Class<?> characterClass) {
        List<Weapon> suitableWeapons = new ArrayList<>();
        for (List<Weapon> weaponList : weapons.values()) {
            for (Weapon weapon : weaponList) {
                if (weapon.getClassRestrictions().contains(characterClass)) {
                    suitableWeapons.add(weapon);
                }
            }
        }
        if (suitableWeapons.isEmpty()) {
            return null;
        }
        int randomIndex = Randomizer.INSTANCE.getRandomValue(suitableWeapons.size() - 1);
        return suitableWeapons.get(randomIndex);
    }

    public Weapon getRandomWeapon(List<String> weaponTypes) {
        List<Weapon> weapons = new ArrayList<>();
        for (String type : weaponTypes) {
            weapons.addAll(getWeaponsOfType(type));
        }
        if (weapons.isEmpty()) {
            return null;
        }
        int randomIndex = Randomizer.INSTANCE.getRandomValue(weapons.size() - 1);
        return weapons.get(randomIndex);
    }

    public Weapon getRandomOneHandedWeapon(Class<?> characterClass) {
        List<Weapon> suitableOneHandedWeapons = new ArrayList<>();
        for (List<Weapon> weaponList : weapons.values()) {
            for (Weapon weapon : weaponList) {
                if (!weapon.isTwoHanded() && weapon.getClassRestrictions().contains(characterClass)) {
                    suitableOneHandedWeapons.add(weapon);
                }
            }
        }

        if (suitableOneHandedWeapons.isEmpty()) {
            return null;
        }
        int randomIndex = Randomizer.INSTANCE.getRandomValue(suitableOneHandedWeapons.size() - 1);
        return suitableOneHandedWeapons.get(randomIndex);
    }

    public Weapon getRandomOneHandedWeapon(List<String> weaponTypes) {
        List<Weapon> oneHandedWeapons = new ArrayList<>();
        for (String type : weaponTypes) {
            List<Weapon> weaponsOfType = getWeaponsOfType(type);
            for (Weapon weapon : weaponsOfType) {
                if (!weapon.isTwoHanded()) {
                    oneHandedWeapons.add(weapon);
                }
            }
        }
        if (oneHandedWeapons.isEmpty()) {
            return null;
        }
        int randomIndex = Randomizer.INSTANCE.getRandomValue(oneHandedWeapons.size() - 1);
        return oneHandedWeapons.get(randomIndex);
    }

    public List<Armor> getAllArmorForRestriction(Class<?> characterClass) {
    
        List<Armor> suitableArmor = new ArrayList<>();
        for (List<Armor> armorList : armorPieces.values()) {
            for (Armor armor : armorList) {
                if (armor.getClassRestrictions().contains(characterClass)) {
                    suitableArmor.add(armor);
                }
            }
        }
    
        return suitableArmor;
    }

    public Armor getRandomArmorOfType(String type, Class<?> characterClass) {
        if (type == null || characterClass == null) {
            return null;
        }
    
        List<Armor> armor = getAllArmorForRestriction(characterClass);
        if (armor.isEmpty()) {
            return null;
        }
    
        List<Armor> armorOfType = armor.stream()
                .filter(a -> a.getType() != null && a.getType().equals(type))
                .collect(Collectors.toList());
    
        if (armorOfType.isEmpty()) {
            return null;
        }
    
        int randomIndex = Randomizer.INSTANCE.getRandomValue(armorOfType.size() - 1);
        return armorOfType.get(randomIndex);
    }
}
