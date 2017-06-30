#!/usr/bin/env bash

set -e -x
#DIR="/tmp/build/"
#rm -r -- "$DIR"*
#for entry in `ls $tmp`; do
   # echo $entry
#done
#for entry in `ls $build`; do
   # echo $entry
#done
git clone ppTest resource-app
cd resource-app/CapstoneProject
#mvn install
mvn install -DskipTests=true
echo "------installation done---------"

#mvn test
echo "------testing done------"