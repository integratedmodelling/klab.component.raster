package org.integratedmodelling.geospatial.adapters;

import org.integratedmodelling.klab.api.data.Data;
import org.integratedmodelling.klab.api.data.Version;
import org.integratedmodelling.klab.api.exceptions.KlabUnimplementedException;
import org.integratedmodelling.klab.api.geometry.Geometry;
import org.integratedmodelling.klab.api.knowledge.Artifact;
import org.integratedmodelling.klab.api.knowledge.Observable;
import org.integratedmodelling.klab.api.knowledge.Resource;
import org.integratedmodelling.klab.api.knowledge.Urn;
import org.integratedmodelling.klab.api.scope.Scope;
import org.integratedmodelling.klab.api.services.resources.adapters.ResourceAdapter;

/**
 * WFS is service-bound so it's embeddable.
 *
 * @author Ferd
 */
@ResourceAdapter(
    name = "wfs",
    type = Artifact.Type.OBJECT,
    version = Version.CURRENT,
    embeddable = true)
public class WFSAdapter {

  public WFSAdapter() {}

  @ResourceAdapter.Encoder
  public void encode(
      Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {}

  /**
   * If there's no type param in the resource adapter annotation. This may take a URN and/or a full
   * Resource according to what is needed to establish the type.
   *
   * @param resourceUrn
   * @return
   */
  @ResourceAdapter.Type
  public Artifact.Type getType(Resource resourceUrn) {
    throw new KlabUnimplementedException("random adapter: can't handle URN " + resourceUrn);
  }
}
