///*
// * This file is part of k.LAB.
// *
// * k.LAB is free software: you can redistribute it and/or modify
// * it under the terms of the Affero GNU General Public License as published
// * by the Free Software Foundation, either version 3 of the License,
// * or (at your option) any later version.
// *
// * A copy of the GNU Affero General Public License is distributed in the root
// * directory of the k.LAB distribution (LICENSE.txt). If this cannot be found
// * see <http://www.gnu.org/licenses/>.
// *
// * Copyright (C) 2007-2018 integratedmodelling.org and any authors mentioned
// * in author tags. All rights reserved.
// */
//package org.integratedmodelling.geospatial.adapters.raster;
//
//import org.integratedmodelling.klab.api.data.IResource;
//import org.integratedmodelling.klab.api.data.IResourceCatalog;
//import org.integratedmodelling.klab.api.data.adapters.IResourcePublisher;
//import org.integratedmodelling.klab.api.runtime.monitoring.IMonitor;
//import org.integratedmodelling.klab.exceptions.KlabException;
//
///**
// * The raster publisher will attempt WCS publishing if a WCS server is
// * connected.
// *
// * @author ferdinando.villa
// *
// */
//public class RasterPublisher implements IResourcePublisher {
//
//    @Override
//    public IResource publish( IResource localResource, IResourceCatalog catalog, IMonitor monitor ) throws KlabException {
//        IResource ret = localResource;
//
//        /*
//         * If we have geoserver, publish there. Honor any mirroring configuration,
//         * possibly publish to a CKAN instance if that is configured in.
//         */
//
//        return ret;
//    }
//
//    @Override
//    public boolean unpublish( IResource resource, IMonitor monitor ) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//}
