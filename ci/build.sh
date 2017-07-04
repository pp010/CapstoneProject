git clone CapstoneProject resource-app
echo "cloning done"
echo "About to print pwd1 value -"
echo $(pwd)
cd resource-app
echo "About to print pwd2 value -"
echo $(pwd)
#mvn clean install -e -DskipTests=true || ErrorHandler "Build Failed for test"
for entry in ./*
do
  echo "$entry"
done
echo "------installation done---------"
echo $(pwd)
