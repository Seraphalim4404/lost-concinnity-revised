package FORGOTTEN.content.statuses;

import mindustry.type.StatusEffect;

public class LCStatusEffects {
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

        lastStand = new LCCustomStatuses("lastStand"){{
            lastStand = true;
            lastStandDuration = 300f;
            lastStandHealthPercentage = 0.2f;

            permanent = true;
        }};

        //Hidden

//        lastStandTemporary = new LCCustomStatuses("lastStandTemporary"){{
//            healthMultiplier = 2.5f;
//            damageMultiplier = 3f;
//            reloadMultiplier = 2.25f;
//            speedMultiplier = 1.25f;
//        }};
//
//        lastStandTemporaryReversed = new LCCustomStatuses("lastStandTemporaryReversed"){{
//            healthMultiplier = 2.5f;
//            damageMultiplier = 3f;
//            reloadMultiplier = 2.25f;
//            speedMultiplier = 1.25f;
//        }};
//
//        lastStandPermanent = new LCCustomStatuses("lastStandPermanent"){{
//            healthMultiplier = 2.5f;
//            damageMultiplier = 3f;
//            reloadMultiplier = 2.25f;
//            speedMultiplier = 1.25f;
//
//            permanent = true;
//        }};
    }
}
