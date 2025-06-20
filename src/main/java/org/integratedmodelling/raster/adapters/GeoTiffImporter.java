package org.integratedmodelling.raster.adapters;

import org.integratedmodelling.klab.api.knowledge.Artifact;
import org.integratedmodelling.klab.api.knowledge.KlabAsset;
import org.integratedmodelling.klab.api.services.resources.adapters.Importer;
import org.integratedmodelling.klab.api.services.runtime.extension.KlabFunction;

@Importer(
        schema = "geotiff.import",
        knowledgeClass = KlabAsset.KnowledgeClass.RESOURCE,
        description = "Imports a raster resource",
        mediaType = "image/tiff;application=geotiff",
        properties = {
                // TODO
                @KlabFunction.Argument(
                        name = "noData",
                        type = Artifact.Type.NUMBER,
                        description = "No data value"
                )
        },
        fileExtensions = {"tiff"}
)
public class GeoTiffImporter {
    public static String importRasterResource() {
        return null;
    }
}
