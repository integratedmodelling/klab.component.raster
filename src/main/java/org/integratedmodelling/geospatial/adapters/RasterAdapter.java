package org.integratedmodelling.geospatial.adapters;

import org.integratedmodelling.klab.api.data.Data;
import org.integratedmodelling.klab.api.data.Version;
import org.integratedmodelling.klab.api.geometry.Geometry;
import org.integratedmodelling.klab.api.knowledge.Observable;
import org.integratedmodelling.klab.api.knowledge.Urn;
import org.integratedmodelling.klab.api.scope.Scope;
import org.integratedmodelling.klab.api.services.resources.adapters.ResourceAdapter;
import org.integratedmodelling.klab.api.services.runtime.Notification;
import org.integratedmodelling.klab.configuration.ServiceConfiguration;

@ResourceAdapter(name = "raster", universal = true, version = Version.CURRENT)
public class RasterAdapter {

    @ResourceAdapter.Encoder
    public void encode(
            Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {
        builder.notification(Notification.debug("Enconding a raster."));
        readRaster(urn, builder, geometry, observable, scope);
        // TODO
    }

    private void readRaster(Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {

    }

    public static void main(String[] args) {
        System.out.println("Hi, raster!");

        // This sets up the k.LAB environment for the service side
        var ignored = ServiceConfiguration.INSTANCE.allowAnonymousUsage();

        String centralColombia =
                "τ0(1){ttype=LOGICAL,period=[1609459200000 1640995200000],tscope=1.0,"
                        + "tunit=YEAR}S2(934,631){bbox=[-75.2281407807369 -72.67107290964314 3.5641500380320963 5"
                        + ".302943221927137],"
                        + "shape"
                        + "=00000000030000000100000005C0522AF2DBCA0987400C8361185B1480C052CE99DBCA0987400C8361185B1480C052CE99DBCA098740153636BF7AE340C0522AF2DBCA098740153636BF7AE340C0522AF2DBCA0987400C8361185B1480,proj=EPSG:4326}";

        var observable = Observable.objects("porquerolles");
        var geometry = Geometry.create(centralColombia);
        var builder = Data.builder("colombia", observable, geometry);
        var adapter = new RasterAdapter();
        adapter.encode(Urn.of("klab:raster:test:colombia"), builder, geometry, observable, null);

        var built = builder.build();
        System.out.println(built);
    }
}
