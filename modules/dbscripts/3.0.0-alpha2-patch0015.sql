--
--  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
--
--    WSO2 Inc. licenses this file to you under the Apache License,
--    Version 2.0 (the "License"); you may not use this file except
--    in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing,
--    software distributed under the License is distributed on an
--    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
--    KIND, either express or implied.  See the License for the
--    specific language governing permissions and limitations
--    under the License.
--

-- ---------------------------------------------------------
-- Updates to the AC_RUNTIMES
-- ---------------------------------------------------------
UPDATE `AC_RUNTIME` SET `name` = 'OracleJDK 8 + WSO2 MSF4J 1.0.0 - Deprecating on 2016/12/31' WHERE `id`= 2;
UPDATE `AC_RUNTIME` SET `name` = 'OracleJDK 8 + WSO2 MSF4J 2.0.0' WHERE `id`= 8;

-- ---------------------------------------------------------
-- Updates to the AC_RUNTIME_CONTAINER_SPECIFICATIONS
-- ---------------------------------------------------------
DELETE FROM `AC_RUNTIME_CONTAINER_SPECIFICATIONS` where `id`=9 AND `CON_SPEC_ID`=3;

-- ---------------------------------------------------------
-- Updates to the AC_CLOUD_APP_TYPE
-- ---------------------------------------------------------
UPDATE `AC_CLOUD_APP_TYPE` SET`cloud_id`=1 WHERE `app_type_id`=6;