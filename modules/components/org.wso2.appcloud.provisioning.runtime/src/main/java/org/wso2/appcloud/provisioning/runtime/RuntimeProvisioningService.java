/*
* Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.wso2.appcloud.provisioning.runtime;

import org.wso2.appcloud.provisioning.runtime.beans.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RuntimeProvisioningService {

    /**
     * Set application details for the context.
     *
     * @param applicationContext application details
     * @throws RuntimeProvisioningException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws RuntimeProvisioningException;

    /**
     * Create an organization for given tenant details.
     *
     * @param tenantInfo details of the tenant
     * @throws RuntimeProvisioningException
     */
    void createOrganization(TenantInfo tenantInfo) throws RuntimeProvisioningException;

    /**
     * Update an organization details.
     *
     * @param tenantInfo details of the tenant
     * @throws RuntimeProvisioningException
     */
    void updateOrganization(TenantInfo tenantInfo) throws RuntimeProvisioningException;

    /**
     * Delete an organization related details.
     *
     * @param tenantInfo details of the tenant
     * @throws RuntimeProvisioningException
     */
    void deleteOrganization(TenantInfo tenantInfo) throws RuntimeProvisioningException;

    /**
     * Archive an organization.
     *
     * @param tenantInfo details of the tenant
     * @throws RuntimeProvisioningException
     */
    void archiveOrganization(TenantInfo tenantInfo) throws RuntimeProvisioningException;

   
    /**
     * Deploy an application.
     *
     * @param deploymentConfig details of the deployment
     * @return list of endpoints
     * @throws RuntimeProvisioningException
     */
    List<String> deployApplication(DeploymentConfig deploymentConfig) throws RuntimeProvisioningException;

    /**
     * Provide deployment related details.
     *
     * @return Whether deployment fail or not
     * @throws RuntimeProvisioningException
     */
    boolean getDeploymentStatus(DeploymentConfig deploymentConfig) throws RuntimeProvisioningException;

    /**
     * Provide runtime log stream.
     *
     * @return log out put stream
     * @throws RuntimeProvisioningException
     */
    DeploymentLogStream streamRuntimeLogs() throws RuntimeProvisioningException;

    /**
     * Provide snapshot logs.
     *
     * @param query query related details
     * @return Snapshot logs of application
     * @throws RuntimeProvisioningException
     */
    DeploymentLogs getRuntimeLogs(LogQuery query)
            throws RuntimeProvisioningException;

    /**
     * Set runtime variables.
     *
     * @param runtimeProperties runtime properties
     * @throws RuntimeProvisioningException
     */
    void setRuntimeProperties(List<RuntimeProperty> runtimeProperties, DeploymentConfig deploymentConfig)
            throws RuntimeProvisioningException;

    /**
     * Update existing runtime properties.
     *
     * @param runtimeProperty runtime property
     * @throws RuntimeProvisioningException
     */
    void updateRuntimeProperties(List<RuntimeProperty> runtimeProperty, DeploymentConfig deploymentConfig)
            throws RuntimeProvisioningException;

    /**
     * Provide application specific runtime properties.
     *
     * @return List of runtime properties
     * @throws RuntimeProvisioningException
     */
    List<RuntimeProperty> getRuntimeProperties() throws RuntimeProvisioningException;

    /**
     * Adding a custom domain mapping to a particular application.
     *
     * @param domains set of domains
     * @throws RuntimeProvisioningException
     */
    boolean addCustomDomain(Set<String> domains) throws RuntimeProvisioningException;

    /**
     * Update a certain custom domain mapping for a particular application version.
     *
     * @param oldDomain old domain name to be changed
     * @param newDomain new domain name to be changed to
     * @throws RuntimeProvisioningException
     */
    boolean updateCustomDomain(String oldDomain, String newDomain) throws RuntimeProvisioningException;

    /**
     * Return custom domain mappings of a certain application version.
     *
     * @return set of domains
     * @throws RuntimeProvisioningException
     */
    Set<String> getCustomDomains() throws RuntimeProvisioningException;

    /**
     * Delete a certain custom domain mapping.
     *
     * @param domain domain name
     * @throws RuntimeProvisioningException
     */
    boolean deleteCustomDomain(String domain) throws RuntimeProvisioningException;

    /**
     * Create the launch URL with respective to the environment, tenant domain, app name and the version.
     *
     * An example launch URL:
     * https://appserver.dev.milestones.appfactory.wso2.com:9443/t/man.com/webapps/foo-default-SNAPSHOT/
     *
     * @param environmentUrl
     * @return
     * @throws RuntimeProvisioningException
     */
    boolean createDeploymentUrl(String environmentUrl) throws RuntimeProvisioningException;

    /**
     * Delete deployment related K8 objects.
     *
     * @throws RuntimeProvisioningException
     */
    boolean deleteDeployment() throws RuntimeProvisioningException;

    /**
     * Create a service in K8s.
     *
     * @param serviceProxy description of the service
     * @throws RuntimeProvisioningException
     */
    public void createService(ServiceProxy serviceProxy) throws RuntimeProvisioningException;

	/**
	 * Get restart count for each pod of the application
	 * @return
	 * @throws RuntimeProvisioningException
	 */
	Map<String, String> getPodRestartCounts() throws RuntimeProvisioningException;

    /**
     * Delete kubernetes kind by name from the deployment
     *
     * @param k8sKind kubernetes kind
     * @param name    unique name refer in Kubernetes
     * @throws RuntimeProvisioningException
     */
    void deleteK8sKindByName(String k8sKind, String name) throws RuntimeProvisioningException;

    void changeExposureLevelInServices(String serviceName, String exposureLevel, String lbHost) throws  RuntimeProvisioningException;
}
