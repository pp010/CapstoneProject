#!/usr/bin/env bash
#set -e -x
git clone ppTest resource-app
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd resource-app
echo "About to print pwd2 value -"
echo $(pwd)

var = $(pwd)
for entry in "$var"/*
do
  echo "$entry"
done
 
#cd resource-app/CapstoneProject
echo "inside resource-app/CapstoneProject"
#mvn install
#mvn install -DskipTests=false
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
cp $var/target/*.jar /home/ubuntu/
cp $(pwd)/target/*.jar /home/ubuntu/
#mv ppTest/build/libs/*.jar ../resource-app
echo "------installation done---------"
#mvn test
