#!/bin/bash

set -e -x

pushd CapstoneProject
  ./mvnw clean package
popd

cp CapstoneProject/target/BidManagementSystem-0.1.jar  resource-app/.
