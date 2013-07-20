package net.citizensnpcs.adventures.race;

import java.util.List;
import java.util.Map;

import net.citizensnpcs.api.util.prtree.PRTree;
import net.citizensnpcs.api.util.prtree.Region3D;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class RaceRegistry implements Runnable {
    private int locationUpdateCounter = 0;
    private final Map<String, RaceDescriptor> races = Maps.newHashMap();
    private final PRTree<Region3D<Tribe>> tribeLocations = PRTree.create(new Region3D.Converter<Tribe>(), 30);
    private final List<Tribe> tribes = Lists.newArrayList();

    public void deregisterTribe(Tribe tribe) {
        tribes.remove(tribe);
    }

    public RaceDescriptor getDescriptor(String name) {
        return races.get(name.toLowerCase());
    }

    public void registerRace(RaceDescriptor desc) {
        races.put(desc.getName().toLowerCase(), desc);
    }

    public void registerTribe(Tribe tribe) {
        tribes.add(tribe);
    }

    @Override
    public void run() {
        List<Region3D<Tribe>> locations = null;
        if (++locationUpdateCounter >= LOCATION_UPDATE_DELAY) {
            tribeLocations.clear();
            locations = Lists.newArrayList();
            locationUpdateCounter = 0;
        }
        for (Tribe tribe : tribes) {
            tribe.run();
            if (locations == null)
                continue;
            Region3D<Tribe> region = tribe.getRepresentativeLocation();
            if (region == null)
                continue;
            locations.add(tribe.getRepresentativeLocation());
        }
        tribeLocations.load(locations);
    }

    private static final int LOCATION_UPDATE_DELAY = 100;
}
