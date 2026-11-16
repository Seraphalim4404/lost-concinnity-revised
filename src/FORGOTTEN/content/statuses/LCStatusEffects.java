package FORGOTTEN.content.statuses;

import mindustry.type.StatusEffect;

public class LCStatusEffects {
    public static StatusEffect
    surger, broken, lastStand, restrained;
    public static void load(){
        broken = new StatusEffect("broken"){{
            damageMultiplier = speedMultiplier = reloadMultiplier = buildSpeedMultiplier = dragMultiplier = 0.5f;

            permanent = true;

            intervalDamage = 100 / 60f;
            intervalDamagePierce = true;
            intervalDamageTime = 60;
        }};

        surger = new StatusEffect("surger"){{
            speedMultiplier = 1.5f;
            damageMultiplier = 1.5f;
            reloadMultiplier = 1.25f;
            dragMultiplier = 0.25f;
        }};

        //Specialized Status Effects

        lastStand = new LCCustomStatuses("last-stand"){{
            lastStand = true;
            lastStandDuration = 300f;
            lastStandHealthPercentage = 0.2f;

            damageMultiplierOnTrigger = 3f;
            speedMultiplierOnTrigger = 1.25f;
            reloadMultiplierOnTrigger = 2.25f;

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
