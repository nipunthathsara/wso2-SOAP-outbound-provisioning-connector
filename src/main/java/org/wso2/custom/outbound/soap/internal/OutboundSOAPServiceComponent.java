/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.custom.outbound.soap.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.custom.outbound.soap.OutboundSOAPConnector;

/**
 * @scr.component name="org.wso2.custom.outbound.soap.connector"
 * immediate="true"
 */
public class OutboundSOAPServiceComponent {
    private static Log log = LogFactory.getLog(OutboundSOAPServiceComponent.class);

    protected void activate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Activating SOAP outbound provisioning connector...");
        }
        //TODO check why google connector registers by Factory
        OutboundSOAPConnector outboundSOAPConnector = new OutboundSOAPConnector();
        context.getBundleContext().registerService(AbstractOutboundProvisioningConnector.class.getName(),
                outboundSOAPConnector, null);
        try {
            if (log.isDebugEnabled()) {
                log.debug("SOAP outbound provisioning connector is activated");
            }
        } catch (Throwable e) {
            log.error("Error while activating SOAP outbound provisioning connector", e);
        }
    }
}