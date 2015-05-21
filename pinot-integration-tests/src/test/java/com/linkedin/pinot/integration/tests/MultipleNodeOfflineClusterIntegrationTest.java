/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.integration.tests;

import java.io.File;


/**
 * TODO Document me!
 *
 * @author jfim
 */
public class MultipleNodeOfflineClusterIntegrationTest extends OfflineClusterIntegrationTest {
  private static final int BROKER_COUNT = 3;
  private static final int SERVER_COUNT = 5;
  private static final int SERVER_INSTANCE_COUNT = SERVER_COUNT;
  private static final int BROKER_INSTANCE_COUNT = BROKER_COUNT;
  private static final int REPLICA_COUNT = 2;

  @Override
  protected void startCluster() {
    startZk();
    startController();
    startServers(SERVER_COUNT);
    startBrokers(BROKER_COUNT);
  }

  @Override
  protected void createResource() throws Exception {
    File schemaFile =
        new File(OfflineClusterIntegrationTest.class.getClassLoader()
            .getResource("On_Time_On_Time_Performance_2014_100k_subset_nonulls.schema").getFile());
    setUpTable(schemaFile, BROKER_COUNT, SERVER_COUNT);
  }
}
