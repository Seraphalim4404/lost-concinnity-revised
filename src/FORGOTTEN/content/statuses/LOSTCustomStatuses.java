package FORGOTTEN.content.statuses;

import FORGOTTEN.content.*;
import FORGOTTEN.content.misc.LOSTStats;
import mindustry.gen.Unit;
import mindustry.entities.units.StatusEntry;
import mindustry.type.StatusEffect;
import mindustry.world.meta.StatUnit;

import static mindustry.graphics.Pal.health;
import static mindustry.graphics.Pal.stat;

public class LOSTCustomStatuses extends StatusEffect {
    public LOSTCustomStatuses(String name) {
        super(name);
    }

    /**How long this unit does not take damage during this time. Activates if lastStand is true.**/
    public float lastStandDuration = 60f;
    /**Percentage of*+ this unit's health upon activating the status. Activates if lastStand is true.**/
    public float lastStandHealthPercentage = 0.35f;
    /**Whether to give this status Last Stand features. Effects activate after certain health falls below %.**/
    public boolean lastStand;
    /**Whether to reverse the lastStand features. Effects instead activate if certain health is above %. **/
    public boolean reverseLastStand;
    /**Whether to retain the effects even after the duration has ended. Does not work if reverseLastStand is active.**/
    public boolean permanentLastStand;





    @Override
    public void setStats() {

        if(lastStand) {
            var stat = !reverseLastStand ? LOSTStats.LastStandActivationDrop : LOSTStats.LastStandActivationRise;
            stats.add(stat, lastStandHealthPercentage * 100, StatUnit.percent);
            stats.add(LOSTStats.lastStandDuration, lastStandDuration / 60f, StatUnit.seconds);
        }
    }

    @Override
    public void update(Unit unit, StatusEntry entry) {
        if(lastStand) {
            float lastStandTargetPercentage = unit.health / unit.maxHealth;
            if (!reverseLastStand) {
                if (lastStandTargetPercentage <= lastStandHealthPercentage) {
                    for (int timer = 0; timer <= lastStandDuration; timer++) {
                        unit.healthMultiplier = Float.POSITIVE_INFINITY;
                        unit.apply(LOSTStatusEffects.lastStandTemporary, lastStandDuration);
                    }
                }

            } else if (!permanentLastStand) {
                if (lastStandTargetPercentage >= lastStandHealthPercentage) {
                    for (int reverseTimer = 0; reverseTimer <= lastStandDuration; reverseTimer++) {
                        unit.healthMultiplier = Float.POSITIVE_INFINITY;
                    }
                    unit.apply(LOSTStatusEffects.lastStandTemporaryReversed, lastStandDuration);
                }
            } else {
                for (int permanentTimer = 0; permanentTimer <= lastStandDuration; permanentTimer++) {
                        unit.healthMultiplier = Float.POSITIVE_INFINITY;
                        unit.apply(LOSTStatusEffects.lastStandPermanent);
                }
            }
        }
    }
}
