### Run Presto Hive Tests
```shell script
$ cd $PRESTO_SRC/presto-hive-hadoop2/bin
$ ./run_hive_tests.sh
```

### Start Hive and Run Tests Separately
```shell script
$ cd $PRESTO_SRC/presto-hive-hadoop2/bin
$ ./start_hive.sh
Proxy: 192.168.99.100:1180
Hadoop: 172.22.0.2
Docker: ebf9f715ced6

docker exec -it ebf9f715ced6 bash

$ docker exec -it ebf9f715ced6 bash 
[root@hadoop-master /]# hive -f /docker/sql/create-test.sql

[root@hadoop-master /]# exit

$ export TESTS_HIVE_VERSION_MAJOR=1
$ export PROXY=192.168.99.100
$ export HADOOP_MASTER_IP=172.22.0.2
$ ./mvnw -B -pl presto-hive-hadoop2 test -P test-hive-hadoop2 \                                                                                                                     2332  06:47:17 
      -DHADOOP_USER_NAME=hive \
      -Dhive.hadoop2.metastoreHost=localhost \
      -Dhive.hadoop2.metastorePort=9083 \
      -Dhive.hadoop2.databaseName=default \
      -Dhive.hadoop2.hiveVersionMajor="${TESTS_HIVE_VERSION_MAJOR}" \
      -Dhive.hadoop2.timeZone=Asia/Kathmandu \
      -Dhive.metastore.thrift.client.socks-proxy="${PROXY}:1180" \
      -Dhive.hdfs.socks-proxy="${PROXY}:1180" \
      -Dhadoop-master-ip="${HADOOP_MASTER_IP}"
```
You can also create test in IntelliJ and 
pass the same JVM options above to your tests.
