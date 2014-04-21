# hadoop 2.4.0 native 64 bit on Ubuntu14.04/Oracle Java7
# y13/ubuntu-java7 image base on https://github.com/y12studio/bkbc-tools/issues/27
# ref https://github.com/sequenceiq/hadoop-docker/blob/master/Dockerfile
# git clone https://github.com/y12studio/y12hadoop
# cd y12hadoop/docker/v240/
# sudo docker.io build -t="y13/hadoop240" .
# 
FROM y13/ubuntu-java7
MAINTAINER Y12STUDIO
# hadoop
RUN curl -s http://0.y12.tw/hadoop240/hadoop-2.4.0.tar.gz | tar -xz -C /usr/local/
RUN cd /usr/local && ln -s hadoop-2.4.0 hadoop

# open jdk
# ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64
# oracle jdk
ENV JAVA_HOME /usr/lib/jvm/java-7-oracle
ENV PATH $PATH:$JAVA_HOME/bin

ENV HADOOP_PREFIX /usr/local/hadoop
RUN sed -i '/^export JAVA_HOME/ s:.*:export JAVA_HOME=/usr/java/default\nexport HADOOP_PREFIX=/usr/local/hadoop\nexport HADOOP_HOME=/usr/local/hadoop\n:' $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
RUN sed -i '/^export HADOOP_CONF_DIR/ s:.*:export HADOOP_CONF_DIR=/usr/local/hadoop/etc/hadoop/:' $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh


ADD core-site.xml $HADOOP_PREFIX/etc/hadoop/core-site.xml
ADD hdfs-site.xml $HADOOP_PREFIX/etc/hadoop/hdfs-site.xml

ADD mapred-site.xml $HADOOP_PREFIX/etc/hadoop/mapred-site.xml
ADD yarn-site.xml $HADOOP_PREFIX/etc/hadoop/yarn-site.xml
