git clone CapstoneProject resource-app
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd resource-app
echo "About to print pwd2 value -"
echo $(pwd)
mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
cp /root/.m2/repository/com/cognizant/BidManagementSystem/0.1/BidManagementSystem-0.1.jar ../../put/CapstoneProject/BidManagementSystem-0.1.jar
echo "------installation done---------"
