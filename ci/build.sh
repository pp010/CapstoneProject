#!/usr/bin/env bash
set -e -x
git clone ppTest resource-app
cd resource-app/CapstoneProject
#mvn install
mvn install -DskipTests=false
echo "------installation done---------"
#mvn test
echo "------testing done------"
cd ..