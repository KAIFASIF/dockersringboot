pipeline {
    agent any
    
    stages {
        // Stage 1: Checkout code
        stage('checkout') {
            steps {
                // Checkout the code from the specified GitHub repository and branch
                git branch: 'master', url: 'https://github.com/KAIFASIF/dockersringboot.git'
            }
        }

        // Stage 2: Build Spring Boot application
        stage('build') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'mvn clean package'
            }
        }

        // Stage 3: Build Docker image
        stage('docker_build') {
            steps {
                // Build Docker image for the Spring Boot application
                sh 'docker build -t my-spring-boot-app .'
            }
        }

        

        // Stage 6: Run Docker container
        stage('docker_run') {
            steps {
                // Run Docker container with port mapping (host:container)
                sh 'docker run -d -p 9191:9000 --name my-container my-spring-boot-app'
            }
        }
    }
}
