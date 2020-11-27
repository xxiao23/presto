/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.plugin.hive.oss;

import io.prestosql.plugin.hive.ConfigurationInitializer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.aliyun.oss.AliyunOSSFileSystem;

import javax.inject.Inject;

import static org.apache.hadoop.fs.aliyun.oss.Constants.ACCESS_KEY_ID;
import static org.apache.hadoop.fs.aliyun.oss.Constants.ACCESS_KEY_SECRET;
import static org.apache.hadoop.fs.aliyun.oss.Constants.ENDPOINT_KEY;

public class PrestoOssConfigurationInitializer
        implements ConfigurationInitializer
{
    private final String aliyunAccessKeyId;
    private final String aliyunSecretKey;
    private final String ossEndpoint;

    @Inject
    public PrestoOssConfigurationInitializer(HiveOssConfig config)
    {
        this.aliyunAccessKeyId = config.getAliyunAccessKeyId();
        this.aliyunSecretKey = config.getAliyunAccessKeySecret();
        this.ossEndpoint = config.getOssEndpoint();
    }

    @Override
    public void initializeConfiguration(Configuration config)
    {
        config.set("fs.oss.impl", AliyunOSSFileSystem.class.getName());

        if (aliyunAccessKeyId != null) {
            config.set(ACCESS_KEY_ID, aliyunAccessKeyId);
        }

        if (aliyunSecretKey != null) {
            config.set(ACCESS_KEY_SECRET, aliyunSecretKey);
        }

        if (ossEndpoint != null) {
            config.set(ENDPOINT_KEY, ossEndpoint);
        }
    }
}
