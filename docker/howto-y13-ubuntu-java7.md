docker image name = y13/ubuntu-java7

ubuntu 14.04 LTS and Oracle Java 7

make y12/ubuntu:trusty

```
$ sudo apt-get install bootstrap
$ sudo /usr/share/docker.io/contrib/mkimage-debootstrap.sh  -i iproute,iputils-ping,git,wget,curl,vim,less,python,net-tools y12/ubuntu trusty
$ sudo docker.io images y12/ubuntu
REPOSITORY          TAG                 IMAGE ID            CREATED             VIRTUAL SIZE
y12/ubuntu          trusty              971a6d63dd36        30 seconds ago      129.3 MB
y12/ubuntu          14.04               971a6d63dd36        30 seconds ago      129.3 MB
```

make y13/ubuntu-java7

```
// install java form dockerfile url.
$ curl https://raw.githubusercontent.com/y12studio/bkbc-tools/master/projects/docker-file/y12-ubuntu-1404-oracle-java7.dockerfile
[...]
FROM y12/ubuntu:trusty

RUN apt-get install -y software-properties-common
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections
RUN apt-get install -y oracle-java7-installer
[...]
$ sudo docker.io build -t="y13/ubuntu-java7" https://raw.githubusercontent.com/y12studio/bkbc-tools/master/projects/docker-file/y12-ubuntu-1404-oracle-java7.dockerfile
$ sudo docker.io run -i -t y13/ubuntu-java7 java -version
java version "1.7.0_55"
Java(TM) SE Runtime Environment (build 1.7.0_55-b13)
Java HotSpot(TM) 64-Bit Server VM (build 24.55-b03, mixed mode)
$ sudo docker.io run -i -t y13/ubuntu-java7 lsb_release -a
No LSB modules are available.
Distributor ID: Ubuntu
Description:    Ubuntu 14.04 LTS
Release:        14.04
Codename:       trusty
$ sudo docker.io images y13/ubuntu-java7
REPOSITORY          TAG    IMAGE ID      CREATED    VIRTUAL SIZE
y13/ubuntu-java7    latest     3740e31999ed        About a minute ago   718.9 MB
```

ref [Run Jetty on Docker Ubuntu 14.04 LTS · Issue #27 · y12studio/bkbc-tools](https://github.com/y12studio/bkbc-tools/issues/27)
