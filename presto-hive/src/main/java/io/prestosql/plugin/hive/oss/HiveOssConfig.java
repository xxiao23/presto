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

import io.airlift.configuration.Config;
import io.airlift.configuration.ConfigSecuritySensitive;

public class HiveOssConfig
{
    private String aliyunAccessKeyId;
    private String aliyunAccessKeySecret;
    private String ossEndpoint;

    public String getAliyunAccessKeyId()
    {
        return aliyunAccessKeyId;
    }

    @Config("hive.oss.aliyun-access-key")
    public HiveOssConfig setAliyunAccessKeyId(String aliyunAccessKeyId)
    {
        this.aliyunAccessKeyId = aliyunAccessKeyId;
        return this;
    }

    public String getAliyunAccessKeySecret()
    {
        return aliyunAccessKeySecret;
    }

    @Config("hive.oss.aliyun-secret-key")
    @ConfigSecuritySensitive
    public HiveOssConfig setAliyunAccessKeySecret(String aliyunAccessKeySecret)
    {
        this.aliyunAccessKeySecret = aliyunAccessKeySecret;
        return this;
    }

    public String getOssEndpoint() {
        return ossEndpoint;
    }

    @Config("hive.oss.endpoint")
    public void setOssEndpoint(String ossEndpoint) {
        this.ossEndpoint = ossEndpoint;
    }
}
