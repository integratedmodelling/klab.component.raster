package org.integratedmodelling.geospatial.adapters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.integratedmodelling.geospatial.adapters.RasterAdapter.importGeotiff;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RasterAdapterTest {

    @Test
    void none() throws IOException {
        assertFalse(false);
    }

}
