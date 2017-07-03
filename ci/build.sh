#!/usr/bin/env bash
#git clone ppTest resource-app
echo "cloning done"
cd ppTest
echo "inside resource-app/CapstoneProject"
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
mv CapstoneProject/build/libs/*.jar ../resource-app
echo "------installation done---------"
