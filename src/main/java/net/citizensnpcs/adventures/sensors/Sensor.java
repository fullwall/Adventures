package net.citizensnpcs.adventures.sensors;

import net.citizensnpcs.adventures.goap.WorldState;

public interface Sensor {
    WorldState generateState();
}