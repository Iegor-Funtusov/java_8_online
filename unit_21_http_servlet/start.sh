mvn clean package
kill -9 $(lsof -t -i:8080)
rm -rf ./apache-tomcat-10.1.15/webapps/*
cp ./target/unit_21_http_servlet.war ./apache-tomcat-10.1.15/webapps/
sh ./apache-tomcat-10.1.15/bin/startup.sh
