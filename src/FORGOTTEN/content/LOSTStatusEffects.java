package FORGOTTEN.content;

import FORGOTTEN.content.statuses.LOSTCustomStatuses;
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

        //Special
        lastStand = new LOSTCustomStatuses("Last Stand"){{
            damageMultiplier = 3;
            reloadMultiplier = 3;
            lastStand = true;
            lastStandDuration = 300;
            lastStandHealthPercentage = 0.5f;
        }};
    }
}
