pipeline {
    tools { 
        maven 'localMaven' 
        jdk 'JDK11' 
    }
    agent any
    stages {
        stage('Build Application') {
            steps {
                bat'mvn -f pom.xml clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.war'
                }
            }
        }
 
        stage('Create Tomcat Docker Image'){
            steps {
                bat"docker build . -t camundaService:${env.BUILD_ID}"
            }
        }
 
    }
}
