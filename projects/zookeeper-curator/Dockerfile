#
# ZooKeeper/Curator Dockerfile (mvn package on host)
# git clone https://github.com/y12studio/y12hadoop
# cd projects/zookeeper-curator && mvn package
# sudo docker.io build -t="y13/zoocur" .
#
FROM y13/ubuntu-java7
MAINTAINER Y12STUDIO

USER root

ENV PREFIX /usr/local/zoocur
ADD target/latest/y12hadoop-zookeeper-curator-latest.jar $PREFIX/zoocur.jar
CMD java -jar $PREFIX/zoocur.jar