Install hadoop 2.4.0 

- [hadoop-common/BUILDING.txt at trunk · apache/hadoop-common](https://github.com/apache/hadoop-common/blob/trunk/BUILDING.txt)
- [hadoop-2.1.0-beta.x86_64.tar.gz 64-bit native library Y12 Studio](http://y12.tw/wp/2013/09/diy-hadoop-2-1-0-beta-x86_64-tar-gz-64-bit-native-library/)




## os setup

Update [Build Hadoop 2.4 on Ubuntu 14.04 LTS · Issue #5](https://github.com/y12studio/y12hadoop/issues/5)

download ubutnu 12.04.4 x64 iso ,boot vm with bridge network interface.


```
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install build-essential openjdk-7-jdk git maven subversion
sudo apt-get install g++ autoconf automake libtool cmake zlib1g-dev pkg-config libssl-dev

$ java -version
java version "1.6.0_30"
OpenJDK Runtime Environment (IcedTea6 1.13.1) (6b30-1.13.1-1ubuntu2~0.12.04.3)
OpenJDK 64-Bit Server VM (build 23.25-b01, mixed mode)

$ update-java-alternatives -l
java-1.6.0-openjdk-amd64 1061 /usr/lib/jvm/java-1.6.0-openjdk-amd64
java-1.7.0-openjdk-amd64 1051 /usr/lib/jvm/java-1.7.0-openjdk-amd64
$ sudo update-java-alternatives -s java-1.7.0-openjdk-amd64
$ java -version
java version "1.7.0_51"
OpenJDK Runtime Environment (IcedTea 2.4.4) (7u51-2.4.4-0ubuntu0.12.04.2)
OpenJDK 64-Bit Server VM (build 24.45-b08, mixed mode)
# git --version
git version 1.7.9.5
# mvn -version
Apache Maven 3.0.4
Maven home: /usr/share/maven
Java version: 1.7.0_51, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-7-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.11.0-15-generic", arch: "amd64", family: "unix"

```

## proto buffer 2.5.0
```
$ wget https://protobuf.googlecode.com/files/protobuf-2.5.0.tar.gz
$ tar zxvr protobuf-2.5.0.tar.gz
$ cd protobuf-2.5.0
$ ./configure
$ make
$ make check
$ sudo make install
$ sudo ldconfig
$ protoc --version
libprotoc 2.5.0

```


## build hadoop

```
$ git clone https://github.com/apache/hadoop-common
$ cd hadoop-common
$ git tag -l '*2.4.*'
$ git checkout release-2.4.0
$ mvn package -Pdist,native -DskipTests -Dtar
[INFO] Apache Hadoop Main ................................ SUCCESS [2:17.434s]
[INFO] Apache Hadoop Project POM ......................... SUCCESS [1:00.161s]
[INFO] Apache Hadoop Annotations ......................... SUCCESS [31.013s]
[INFO] Apache Hadoop Assemblies .......................... SUCCESS [0.275s]
[INFO] Apache Hadoop Project Dist POM .................... SUCCESS [32.102s]
[INFO] Apache Hadoop Maven Plugins ....................... SUCCESS [38.087s]
[INFO] Apache Hadoop MiniKDC ............................. SUCCESS [2:59.561s]
[INFO] Apache Hadoop Auth ................................ SUCCESS [37.992s]
[INFO] Apache Hadoop Auth Examples ....................... SUCCESS [10.832s]
[INFO] Apache Hadoop Common .............................. SUCCESS [3:47.087s]
[INFO] Apache Hadoop NFS ................................. SUCCESS [20.226s]
[INFO] Apache Hadoop Common Project ...................... SUCCESS [0.041s]
[INFO] Apache Hadoop HDFS ................................ SUCCESS [3:44.313s]
[INFO] Apache Hadoop HttpFS .............................. SUCCESS [47.828s]
[INFO] Apache Hadoop HDFS BookKeeper Journal ............. SUCCESS [1:45.858s]
[INFO] Apache Hadoop HDFS-NFS ............................ SUCCESS [4.785s]
[INFO] Apache Hadoop HDFS Project ........................ SUCCESS [0.068s]
[INFO] hadoop-yarn ....................................... SUCCESS [0.064s]
[INFO] hadoop-yarn-api ................................... SUCCESS [57.037s]
[INFO] hadoop-yarn-common ................................ SUCCESS [49.269s]
[INFO] hadoop-yarn-server ................................ SUCCESS [0.083s]
[INFO] hadoop-yarn-server-common ......................... SUCCESS [9.994s]
[INFO] hadoop-yarn-server-nodemanager .................... SUCCESS [55.330s]
[INFO] hadoop-yarn-server-web-proxy ...................... SUCCESS [3.582s]
[INFO] hadoop-yarn-server-applicationhistoryservice ...... SUCCESS [15.521s]
[INFO] hadoop-yarn-server-resourcemanager ................ SUCCESS [15.054s]
[INFO] hadoop-yarn-server-tests .......................... SUCCESS [1.854s]
[INFO] hadoop-yarn-client ................................ SUCCESS [5.396s]
[INFO] hadoop-yarn-applications .......................... SUCCESS [0.082s]
[INFO] hadoop-yarn-applications-distributedshell ......... SUCCESS [2.730s]
[INFO] hadoop-yarn-applications-unmanaged-am-launcher .... SUCCESS [1.801s]
[INFO] hadoop-yarn-site .................................. SUCCESS [0.094s]
[INFO] hadoop-yarn-project ............................... SUCCESS [4.988s]
[INFO] hadoop-mapreduce-client ........................... SUCCESS [0.088s]
[INFO] hadoop-mapreduce-client-core ...................... SUCCESS [23.372s]
[INFO] hadoop-mapreduce-client-common .................... SUCCESS [17.766s]
[INFO] hadoop-mapreduce-client-shuffle ................... SUCCESS [3.050s]
[INFO] hadoop-mapreduce-client-app ....................... SUCCESS [11.481s]
[INFO] hadoop-mapreduce-client-hs ........................ SUCCESS [8.822s]
[INFO] hadoop-mapreduce-client-jobclient ................. SUCCESS [14.411s]
[INFO] hadoop-mapreduce-client-hs-plugins ................ SUCCESS [2.981s]
[INFO] Apache Hadoop MapReduce Examples .................. SUCCESS [6.096s]
[INFO] hadoop-mapreduce .................................. SUCCESS [3.595s]
[INFO] Apache Hadoop MapReduce Streaming ................. SUCCESS [9.118s]
[INFO] Apache Hadoop Distributed Copy .................... SUCCESS [23.039s]
[INFO] Apache Hadoop Archives ............................ SUCCESS [8.856s]
[INFO] Apache Hadoop Rumen ............................... SUCCESS [6.160s]
[INFO] Apache Hadoop Gridmix ............................. SUCCESS [4.660s]
[INFO] Apache Hadoop Data Join ........................... SUCCESS [2.831s]
[INFO] Apache Hadoop Extras .............................. SUCCESS [3.049s]
[INFO] Apache Hadoop Pipes ............................... SUCCESS [12.240s]
[INFO] Apache Hadoop OpenStack support ................... SUCCESS [6.097s]
[INFO] Apache Hadoop Client .............................. SUCCESS [5.588s]
[INFO] Apache Hadoop Mini-Cluster ........................ SUCCESS [0.917s]
[INFO] Apache Hadoop Scheduler Load Simulator ............ SUCCESS [12.214s]
[INFO] Apache Hadoop Tools Dist .......................... SUCCESS [4.103s]
[INFO] Apache Hadoop Tools ............................... SUCCESS [0.024s]
[INFO] Apache Hadoop Distribution ........................ SUCCESS [1:01.998s]

$ cd hadoop-dist
$ file target/hadoop-2.4.0/lib/native/*
$ export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
$ target/hadoop-2.4.0/bin/hadoop version
Hadoop 2.4.0
Subversion https://github.com/apache/hadoop-common -r 23f5c1d3bf46d0ed8429d579319efddef4a7d641
$ mv target/hadoop-2.4.0.tar.gz target/hadoop-2.4.0-y12.tar.gz

```

## configure hadoop

[Hadoop 2.1.0 beta Single Node and Ubuntu 13.04 server Y12 Studio](http://y12.tw/wp/2013/08/hadoop-2-1-0-beta-single-node-and-ubuntu-13-04-server/)

ipv6 disable
```
$ cat /etc/sysctl.conf
net.ipv6.conf.all.disable_ipv6 = 1
net.ipv6.conf.default.disable_ipv6 = 1
net.ipv6.conf.lo.disable_ipv6 = 1
$ sudo sysctl -p
$ cat /proc/sys/net/ipv6/conf/all/disable_ipv6
1
```
create user and group
```
$ sudo addgroup hadoop
$ sudo adduser --ingroup hadoop hduser
$ sudo adduser hduser sudo
$ su - hduser
$ ssh-keygen -t rsa -P ''
...
Your identification has been saved in /home/hduser/.ssh/id_rsa.
Your public key has been saved in /home/hduser/.ssh/id_rsa.pub.
...
$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
$ ssh localhost
```
login hduser and download hadoop
```
$ cd ~
$ wget http://0.y12.tw/hadoop-2.4.0-y12.tar.gz
$ sudo tar vxzf hadoop-2.4.0-y12.tar.gz -C /usr/local
$ cd /usr/local
$ sudo mv hadoop-2.4.0/ hadoop
$ sudo chown -R hduser:hadoop hadoop
```
env setting
```
$ cat ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
export HADOOP_INSTALL=/usr/local/hadoop
export PATH=$PATH:$HADOOP_INSTALL/bin
export PATH=$PATH:$HADOOP_INSTALL/sbin
export HADOOP_MAPRED_HOME=$HADOOP_INSTALL
export HADOOP_COMMON_HOME=$HADOOP_INSTALL
export HADOOP_HDFS_HOME=$HADOOP_INSTALL
export YARN_HOME=$HADOOP_INSTALL

$ cat /usr/local/hadoop/etc/hadoop/hadoop-env.sh
export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/
$ cd ~
$ hadoop version
Hadoop 2.4.0
Subversion https://github.com/apache/hadoop-common -r 23f5c1d3bf46d0ed8429d579319efddef4a7d641
```
xml setting
```
$ cd /usr/local/hadoop/etc/hadoop
$ wget https://raw.githubusercontent.com/y12studio/y12hadoop/master/conf/hadoop240/core-site.xml -O core-site.xml
$ wget https://raw.githubusercontent.com/y12studio/y12hadoop/master/conf/hadoop240/yarn-site.xml -O yarn-site.xml
$ wget https://raw.githubusercontent.com/y12studio/y12hadoop/master/conf/hadoop240/mapred-site.xml -O mapred-site.xml
$ wget https://raw.githubusercontent.com/y12studio/y12hadoop/master/conf/hadoop240/hdfs-site.xml -O hdfs-site.xml
$ cd ~
$ mkdir -p mydata/hdfs/namenode
$ mkdir -p mydata/hdfs/datanode

```
start service
```
$ hdfs namenode -format
$ start-dfs.sh
$ start-yarn.sh
$ jps
3749 Jps
2643 NameNode
2886 DataNode
3160 SecondaryNameNode
3296 ResourceManager
$ sudo netstat -plten | grep java
```

[hadoop 2.1.0 beta hdfs remote write Y12 Studio](http://y12.tw/wp/2013/09/hadoop-2-1-0-beta-hdfs-remote-write/)


## test

TODO

## Online : create droplets

- Add SSH Keys/No root password
- boot 512MB Ram 20GB SSD Disk Singapore 1 Ubuntu 12.04.4 x64

Update : 512MB/1G Ram not enough to mvn package. (Swap?)

root@ssh key 

```
# apt-get update
# apt-get upgrade
# apt-get install openjdk-7-jdk git maven
# java -version
java version "1.7.0_51"
OpenJDK Runtime Environment (IcedTea 2.4.4) (7u51-2.4.4-0ubuntu0.12.04.2)
OpenJDK 64-Bit Server VM (build 24.45-b08, mixed mode)
// sshd config
# cat /etc/ssh/sshd_config
...
PasswordAuthentication no
...
UsePAM no
# reload ssh
```
