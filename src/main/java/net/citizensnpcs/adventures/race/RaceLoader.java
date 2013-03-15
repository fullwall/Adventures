package net.citizensnpcs.adventures.race;

import java.io.File;
import java.util.concurrent.ExecutionException;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.scripting.ScriptFactory;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Storage;
import net.citizensnpcs.api.util.YamlStorage;

public class RaceLoader {
    private final RaceRegistry registry;
    private final File rootDirectory;

    public RaceLoader(File rootDirectory, RaceRegistry registry) {
        this.rootDirectory = rootDirectory;
        this.registry = registry;
        rootDirectory.mkdirs();
    }

    public void load() {
        for (File raceDirectory : rootDirectory.listFiles()) {
            if (!raceDirectory.isDirectory())
                continue;
            for (File possibleInfoFile : raceDirectory.listFiles()) {
                if (!possibleInfoFile.isFile() || !possibleInfoFile.getName().startsWith("info"))
                    continue;
                RaceDescriptor desc = loadRaceDescriptor(possibleInfoFile);
                if (desc != null)
                    registry.register(desc);
                break;
            }
        }
    }

    private RaceDescriptor loadAsScript(File infoFile) {
        ScriptFactory[] factories = new ScriptFactory[1];
        try {
            factories = CitizensAPI.getScriptCompiler().compile(infoFile).beginWithFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ScriptFactory factory = factories[0];
        if (factory == null)
            return null;
        Object object = factory.newInstance().invoke("getDescriptor", (Object[]) null);
        if (!(object instanceof RaceDescriptor))
            throw new RuntimeException("Expected RaceDescriptor, got " + object);
        return (RaceDescriptor) object;
    }

    private RaceDescriptor loadFromYaml(Storage storage) {
        DataKey root = storage.getKey("");
        String name = root.getString("name");
        if (name == null)
            return null;
        RaceDescriptor race = RaceDescriptor.builder(name).build();
        CitizensAPI.registerEvents(new YamlTribeGenerator(registry, root));
        return race;
    }

    private RaceDescriptor loadRaceDescriptor(File infoFile) {
        if (infoFile.getName().contains(".yml")) {
            Storage storage = new YamlStorage(infoFile);
            if (!storage.load())
                throw new RuntimeException("Couldn't load " + infoFile.getName());
            return loadFromYaml(storage);
        }
        return loadAsScript(infoFile);
    }
}
