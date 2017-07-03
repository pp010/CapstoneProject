#!/usr/bin/env bash
#set -e -x
git clone ppTest resource-app
echo "cloning done"
cd resource-app
ls
cd ppTest
echo "About to print pwd value -"
echo $(pwd)
#cd resource-app/CapstoneProject
echo "inside resource-app/CapstoneProject"
#mvn install
#mvn install -DskipTests=false
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
#mv ppTest/build/libs/*.jar ../resource-app
echo "------installation done---------"
#mvn test
