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

package org.wso2.custom.outbound.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.*;

public class SOAPProvisioningConnector extends AbstractOutboundProvisioningConnector {
    private static Log log = LogFactory.getLog(SOAPProvisioningConnector.class);
    //TODO UUID

    @Override
    public void init(Property[] properties) throws IdentityProvisioningException {

    }

    @Override
    public ProvisionedIdentifier provision(ProvisioningEntity provisioningEntity) throws IdentityProvisioningException {
        if (provisioningEntity != null) {
            if (provisioningEntity.isJitProvisioning() && !isJitProvisioningEnabled()) {
                log.debug("JIT provisioning disabled for SOAP connector");
                return null;
            }
            //Connector do not support for provisioning of groups as SOAP EPs do not.
            if (provisioningEntity.getEntityType() == ProvisioningEntityType.USER) {
                provisionUser(provisioningEntity);
            }
        }
        return null;
    }

    @Override
    protected boolean isJitProvisioningEnabled() throws IdentityProvisioningException {
        return false;
    }

    private void provisionUser(ProvisioningEntity provisioningEntity) throws IdentityProvisioningException {
        if (provisioningEntity.getOperation() == ProvisioningOperation.POST) {
            log.error("**************cPrereate");
            test();
            log.error("**************Postcreate");
        } else if (provisioningEntity.getOperation() == ProvisioningOperation.DELETE) {
            log.error("**************delete");
        } else if (provisioningEntity.getOperation() == ProvisioningOperation.PUT) {
            log.error("**************put");
        } else {
            log.warn("Unsupported provisioning operation : " + provisioningEntity.getOperation() +
                    " for provisioning entity : " + provisioningEntity.getEntityName());
        }
    }

    private void test(){

    }
}
