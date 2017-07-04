#!/usr/bin/env bash

git clone CapstoneProject resource-app
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd resource-app
echo "About to print pwd2 value -"
echo $(pwd)
#mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
echo $(ls -lart)
cd /tmp/build/3bb15873/resource-app/target
echo $(ls)
echo "------installation done---------"
echo $(pwd)
