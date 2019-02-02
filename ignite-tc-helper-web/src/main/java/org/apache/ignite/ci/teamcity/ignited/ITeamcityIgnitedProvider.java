/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ignite.ci.teamcity.ignited;

import javax.annotation.Nullable;
import org.apache.ignite.ci.user.ICredentialsProv;
import org.apache.ignite.ci.web.rest.exception.ServiceUnauthorizedException;

/**
 * Provides instance of particular cache-based teamcity connection.
 */
public interface ITeamcityIgnitedProvider {
    public boolean hasAccess(String srvId, @Nullable ICredentialsProv prov);

    /**
     * @param srvId Server id.
     * @param prov Prov.
     */
    public ITeamcityIgnited server(String srvId, @Nullable ICredentialsProv prov);

    default void checkAccess(@Nullable String srvId, ICredentialsProv credsProv) {
        if (!hasAccess(srvId, credsProv))
            throw ServiceUnauthorizedException.noCreds(srvId);
    }
}
