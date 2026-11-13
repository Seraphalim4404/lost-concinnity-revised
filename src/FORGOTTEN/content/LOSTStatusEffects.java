package FORGOTTEN.content;

import FORGOTTEN.content.statuses.LOSTCustomStatuses;
import mindustry.type.StatusEffect;

public class LOSTStatusEffects {
    public static StatusEffect
    surgeRusher, broken, lastStand,

    lastStandTemporary, lastStandTemporaryReversed, lastStandPermanent;
    public static void load(){
        broken = new StatusEffect("broken"){{
            damageMultiplier = speedMultiplier = reloadMultiplier = buildSpeedMultiplier = dragMultiplier = 0.5f;

            permanent = true;

            intervalDamage = 100 / 60f;
            intervalDamagePierce = true;
            intervalDamageTime = 60;
        }};

        surgeRusher = new StatusEffect("surgeRusher"){{
            speedMultiplier = 1.5f;
            damageMultiplier = 1.5f;
            reloadMultiplier = 1.25f;
            dragMultiplier = 0.25f;
        }};

        //Specialized Status Effects

        lastStand = new LOSTCustomStatuses("lastStand"){{
            lastStand = true;
            lastStandDuration = 300;
            lastStandHealthPercentage = 0.5f;

            permanent = true;
        }};

        //Hidden

        lastStandTemporary = new LOSTCustomStatuses("lastStandTemporary"){{
            healthMultiplier = 2.5f;
            damageMultiplier = 3f;
            reloadMultiplier = 2.25f;
            speedMultiplier = 1.25f;
        }};

        lastStandTemporaryReversed = new LOSTCustomStatuses("lastStandTemporaryReversed"){{
            healthMultiplier = 2.5f;
            damageMultiplier = 3f;
            reloadMultiplier = 2.25f;
            speedMultiplier = 1.25f;
        }};

        lastStandPermanent = new LOSTCustomStatuses("lastStandPermanent"){{
            healthMultiplier = 2.5f;
            damageMultiplier = 3f;
            reloadMultiplier = 2.25f;
            speedMultiplier = 1.25f;

            permanent = true;
        }};
    }
}
