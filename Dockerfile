FROM openjdk:11
ADD target/camundaService.war /usr/local/camundaService.war
EXPOSE 8081
CMD ["java -jar /usr/local/camundaService.war", "run"]
