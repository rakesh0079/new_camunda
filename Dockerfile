FROM openjdk:11
ADD target/camundaService.war camundaService.war
EXPOSE 8081
CMD ["java -jar /camundaService.war", "run"]
