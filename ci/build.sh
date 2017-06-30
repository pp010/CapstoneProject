#!/usr/bin/env bash
#set -e -x
git clone ppTest resource-app
echo "cloning done"

for entry in *
do
 echo $entry
done

cd resource-app
ls
cd ppTest
pwd
#cd resource-app/CapstoneProject
echo "inside resource-app/CapstoneProject"
#mvn install
#mvn install -DskipTests=false
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
echo "------installation done---------"
#mvn test
