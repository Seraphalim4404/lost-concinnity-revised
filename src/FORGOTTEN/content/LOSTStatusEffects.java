package FORGOTTEN.content;

//import mindustry.content;
//import arc.graphics;
import mindustry.type.StatusEffect;

public class LOSTStatusEffects {
    public static StatusEffect
    broken, lastStand;

    public static void load(){
        broken = new StatusEffect("Broken"){{
            damageMultiplier = speedMultiplier = reloadMultiplier = buildSpeedMultiplier = dragMultiplier = 0.5f;

            intervalDamage = 100 / 60f;
            intervalDamagePierce = true;
            intervalDamageTime = 60;
        }};

        lastStand = new StatusEffect("Last Stand"){{

        }};
    }
}
