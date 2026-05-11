pipeline {
    agent any

    environment {
        IMAGE = "springboot-mongodb:1.0"
        APP_CONTAINER = "springboot-app"
        MONGO_CONTAINER = "mongo"
        NETWORK = "app-network"
    }

    stages {

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t springboot-mongodb:1.0 .'
            }
        }

        stage('Cleanup Old Containers') {
            steps {
                sh '''
                docker rm -f springboot-app || true
                docker rm -f mongo || true
                '''
            }
        }

        stage('Create Network') {
            steps {
                sh 'docker network create app-network || true'
            }
        }

        stage('Run MongoDB') {
            steps {
                sh '''
                docker run -d --name mongo --network app-network mongo:7
                '''
            }
        }

        stage('Wait for MongoDB') {
            steps {
                sh 'sleep 15'
            }
        }

        stage('Run Spring Boot App') {
            steps {
                sh '''
                docker run -d --name springboot-app \
                --network app-network \
                -p 8082:8082 \
                springboot-mongodb:1.0
                '''
            }
        }

        stage('Verify Containers') {
            steps {
                sh 'docker ps'
            }
        }
    }
}