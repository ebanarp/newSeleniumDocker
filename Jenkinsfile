pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='ebanarp/selenium-docker-test' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhubid', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    sh "docker login --username=${user} --password=${pass}"
			        sh "docker push ebanarp/selenium-docker-test:latest"
			    }                           
            }
        }
    }
}