package FORGOTTEN.content.statuses;

import arc.struct.ObjectMap;
import arc.util.Time;
import mindustry.entities.units.StatusEntry;
import mindustry.gen.Unit;
import mindustry.type.StatusEffect;
import FORGOTTEN.content.*;
import FORGOTTEN.content.misc.LCStats;
import mindustry.world.meta.StatUnit;

public class LCCustomStatuses extends StatusEffect {
    public LCCustomStatuses(String name) {
        super(name);
    }

    private final ObjectMap<Unit, TimerState> lastStandTimerMap = new ObjectMap<>();
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

    private static class TimerState {
        float timer = 0f;
    }

    @Override
    public void setStats() {

        if(lastStand) {
            var stat = !reverseLastStand ? LCStats.lastStandActivationDrop : LCStats.lastStandActivationRise;
            stats.add(stat, lastStandHealthPercentage * 100, StatUnit.percent);
            stats.add(LCStats.lastStandDuration, lastStandDuration / 60f, StatUnit.seconds);
        }
    }

    @Override
    public void update(Unit unit, StatusEntry entry) {
        TimerState state = lastStandTimerMap.get(unit);
        if(state == null) {
            state = new TimerState();
            lastStandTimerMap.put(unit, state);
        }
        if(lastStand) {
            float lastStandTargetPercentage = unit.health / unit.maxHealth;
            if (!reverseLastStand) {
                if (lastStandTargetPercentage <= lastStandHealthPercentage) {
                    state.timer+=Time.delta;
                    unit.healthMultiplier = state.timer <= lastStandDuration ? Float.POSITIVE_INFINITY : 1f;
                    unit.damageMultiplier = state.timer <= lastStandDuration ? 3f:1;
                    unit.reloadMultiplier = state.timer <= lastStandDuration ? 2.25f:1;
                    unit.speedMultiplier = state.timer <= lastStandDuration ? 1.25f:1;
                }

            } else if (!permanentLastStand) {
                if (lastStandTargetPercentage >= lastStandHealthPercentage) {
                    unit.damageMultiplier =  3f;
                    unit.reloadMultiplier = 2.25f;
                    unit.speedMultiplier = 1.25f;
                    if (lastStandTargetPercentage <= lastStandHealthPercentage) {
                        state.timer+=Time.delta;
                        unit.healthMultiplier = state.timer <= lastStandDuration ? Float.POSITIVE_INFINITY : 1f;
                    }
                }
            } else {
                if (lastStandTargetPercentage <= lastStandHealthPercentage) {
                    state.timer+=Time.delta;
                    unit.healthMultiplier = state.timer <= lastStandDuration ? Float.POSITIVE_INFINITY : 1f;
                    unit.damageMultiplier =  3f;
                    unit.reloadMultiplier = 2.25f;
                    unit.speedMultiplier = 1.25f;
                }

            }
        }
        super.update(unit,entry);
    }

    //  Why, yes, Java is my favorite language, I love being forced to create 100 duct tapes just to create a single variable!!
    @Override
    public void onRemoved(Unit unit) {
        // Clean up when this status effect expires or is removed.
        lastStandTimerMap.remove(unit);

        super.onRemoved(unit);
    }

}