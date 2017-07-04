#!/bin/bash
git clone CapstoneProject CapstoneProject
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd CapstoneProject
echo "About to print pwd2 value -"
echo $(pwd)
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
echo "------installation done---------"
