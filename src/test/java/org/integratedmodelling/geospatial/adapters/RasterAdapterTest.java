package org.integratedmodelling.geospatial.adapters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class RasterAdapterTest {

    @Test
    void none() {
        assertFalse(false);
    }

    @Test
    @Disabled
    void importBaseTest() {
        PluginManager pluginManager = new DefaultPluginManager(Paths.get("plugins"));
        // 2. Load Plugins
        pluginManager.loadPlugins();

        // 3. Start Plugins
        pluginManager.startPlugins();

        // 4. Verify Plugin States
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        assertFalse(startedPlugins.isEmpty(), "No plugins were started.");
    }

    @Test
    @Disabled
    void encoderBaseTest() {
        Assertions.assertTrue(true);
    }
}
