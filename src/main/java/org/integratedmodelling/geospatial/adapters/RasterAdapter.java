package org.integratedmodelling.geospatial.adapters;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.coverage.grid.io.AbstractGridCoverage2DReader;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.coverage.grid.io.GridFormatFinder;
import org.integratedmodelling.klab.api.collections.Parameters;
import org.integratedmodelling.klab.api.data.Data;
import org.integratedmodelling.klab.api.data.Version;
import org.integratedmodelling.klab.api.exceptions.KlabIOException;
import org.integratedmodelling.klab.api.geometry.Geometry;
import org.integratedmodelling.klab.api.knowledge.Artifact;
import org.integratedmodelling.klab.api.knowledge.KlabAsset;
import org.integratedmodelling.klab.api.knowledge.Observable;
import org.integratedmodelling.klab.api.knowledge.Urn;
import org.integratedmodelling.klab.api.scope.Scope;
import org.integratedmodelling.klab.api.services.resources.adapters.Importer;
import org.integratedmodelling.klab.api.services.resources.adapters.Parameter;
import org.integratedmodelling.klab.api.services.resources.adapters.ResourceAdapter;
import org.integratedmodelling.klab.api.services.resources.impl.ResourceBuilderImpl;
import org.integratedmodelling.klab.api.services.runtime.Notification;
import org.integratedmodelling.klab.configuration.ServiceConfiguration;
import org.opengis.geometry.Envelope;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.apache.commons.io.IOUtils.copy;

@ResourceAdapter(
    name = "raster",
    version = Version.CURRENT,
    type = Artifact.Type.NUMBER,
    parameters = {
      // TODO
      @Parameter(name = "noData", type = Artifact.Type.NUMBER)//, description = "No data value")
    })
public class RasterAdapter {

  @ResourceAdapter.Encoder
  public void encode(
      Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {
    builder.notification(Notification.debug("Encoding a raster."));
    readRaster(urn, builder, geometry, observable, scope);
    // TODO
    
  }

  private void readRaster(
      Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {}

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

  @Importer(
      schema = "geotiff.import",
      knowledgeClass = KlabAsset.KnowledgeClass.RESOURCE,
      description = "Imports a raster resource",
      mediaType = "image/tiff;application=geotiff",
      fileExtensions = {"tiff"})
  public static String importGeotiff() {
    //ResourceBuilderImpl builder = validateLocalImport();
    return null;
  }

  @ResourceAdapter.Validator(
      phase = ResourceAdapter.Validator.LifecyclePhase.LocalImport,
      metadataConventions = ""
  )
  public static ResourceBuilderImpl validateLocalImport(String urn, URL url, Parameters<String> userData) throws IOException {
    ResourceBuilderImpl ret = new ResourceBuilderImpl(urn);
    ret.withParameters(userData);

    File file = getFileForURL(url);
    ret.addImportedFile(file);

    ret.withAdapterType("raster");


    AbstractGridFormat format = GridFormatFinder.findFormat(file);
    AbstractGridCoverage2DReader reader = format.getReader(file);
    GridCoverage2D coverage = reader.read(null);
    Envelope envelope = coverage.getEnvelope();
    CoordinateReferenceSystem crs = coverage.getCoordinateReferenceSystem();
    GridGeometry2D grid = coverage.getGridGeometry();
    coverage.getGridGeometry().getEnvelope();

    // TODO set geometry
    Geometry geometry = null;
    ret.withGeometry(geometry);
    return ret;
  }

  // Utils
  /**
   * Gets the file for URL.
   *
   * @param url the url
   * @return the file for URL
   * @throws KlabIOException the klab IO exception
   */
  public static File getFileForURL(URL url) throws KlabIOException, IOException {
    if (url.toString().startsWith("file:")) {
      return new File(url.getFile());
    } else {
      File temp;
      try {
        temp = File.createTempFile("url", "url");
      } catch (IOException e) {
        throw new KlabIOException(e);
      }
      copy(url, temp);
      return temp;
    }
  }
}
