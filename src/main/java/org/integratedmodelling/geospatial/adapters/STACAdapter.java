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
 * STAC is service-bound so it can be embedded in a runtime.
 *
 * @author Ferd
 */
@ResourceAdapter(name = "stac", version = Version.CURRENT, embeddable = true)
public class STACAdapter {

  public STACAdapter() {}

  @ResourceAdapter.Encoder
  public void encode(
      Urn urn, Data.Builder builder, Geometry geometry, Observable observable, Scope scope) {}

  /**
   * STAC may provide all sorts of things, so the decision needs to look at the entire resource
   * parameterization.
   *
   * @param resourceUrn
   * @return
   */
  @ResourceAdapter.Type
  public Artifact.Type getType(Resource resourceUrn) {
    throw new KlabUnimplementedException("random adapter: can't handle URN " + resourceUrn);
  }
}
