FROM openjdk:17-slim

WORKDIR /usr/share/arpan

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD Testng.xml Testng.xml
ADD target/runscript.sh runscript.sh

ENTRYPOINT ["/bin/sh","./runscript.sh"]