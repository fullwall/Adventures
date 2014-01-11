package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.citizensnpcs.api.util.prtree.DistanceResult;
import net.citizensnpcs.api.util.prtree.NodeFilter;
import net.citizensnpcs.api.util.prtree.PRTree;
import net.citizensnpcs.api.util.prtree.PointND;
import net.citizensnpcs.api.util.prtree.Region3D;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
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

    public void destroyAllTribes() {
        tribeLocations.clear();
        for (Tribe tribe : Lists.newArrayList(tribes)) {
            deregisterTribe(tribe);
            tribe.destroy();
        }
    }

    public RaceDescriptor getDescriptor(String name) {
        return races.get(name.toLowerCase());
    }

    public Collection<Tribe> getNearbyTribes(PointND root, int maxHits) {
        return getNearbyTribes(root, maxHits, Region3D.<Tribe> alwaysAcceptNodeFilter());
    }

    public Collection<Tribe> getNearbyTribes(PointND root, int maxHits, NodeFilter<Region3D<Tribe>> filter) {
        List<Tribe> result = Lists.newArrayListWithCapacity(maxHits);
        for (DistanceResult<Region3D<Tribe>> res : tribeLocations.nearestNeighbour(
                Region3D.<Tribe> distanceCalculator(), filter, maxHits, root)) {
            result.add(res.get().getData());
        }
        return result;
    }

    public Iterable<RaceDescriptor> getRaces() {
        return races.values();
    }

    public Iterable<Tribe> getTribes() {
        return tribes;
    }

    public Collection<Tribe> getTribesByRace(RaceDescriptor race) {
        return getTribesByRace(race, null);
    }

    public Collection<Tribe> getTribesByRace(final RaceDescriptor race, final Tribe excluding) {
        return Collections2.filter(tribes, new Predicate<Tribe>() {
            @Override
            public boolean apply(Tribe input) {
                return input.getRace().equals(race) && !input.equals(excluding);
            }
        });
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
        for (int i = 0; i < tribes.size(); i++) {
            Tribe tribe = tribes.get(i);
            tribe.run();
            if (locations == null)
                continue;
            Region3D<Tribe> region = tribe.getRepresentativeLocation();
            if (region != null) {
                locations.add(region);
            }
        }
        if (locations != null) {
            tribeLocations.load(locations);
        }
    }

    private static final int LOCATION_UPDATE_DELAY = 100;
}
