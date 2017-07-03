git clone CapstoneProject resource-app
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd resource-app
echo "About to print pwd2 value -"
echo $(pwd)
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
cd ..
cd ..
sudo chmod -R 755 /tmp/build/put/CapstoneProject/
cp /root/.m2/repository/com/cognizant/BidManagementSystem/0.1/BidManagementSystem-0.1.jar /tmp/build/put/CapstoneProject/
echo "------installation done---------"
