FROM tomcat:9.0
 
ADD /target/*.war /usr/local/tomcat/webapps
 
EXPOSE 8088
CMD ["catalina.sh", "run"]
