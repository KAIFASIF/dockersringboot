pipeline {
    agent any
    
    stages {
        // Stage 1: Checkout code
        stage('checkout') {
            steps {
                // Checkout the code from the specified GitHub repository and branch
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KAIFASIF/vitereactapp.git']])
            }
        }

        // Stage 2: Delete all existing containers
        stage('delete_containers') {
            steps {
                // Delete all Docker containers
                sh 'docker rm -f $(docker ps -a -q) || true'
            }
        }

        // Stage 3: Delete all existing images
        stage('delete_images') {
            steps {
                // Delete all Docker images
                sh 'docker rmi -f $(docker images -q) || true'
            }
        }

        // Stage 4: Build Docker image
        stage('build') {
            steps {
                // Print information about the build environment
                sh 'uname -a'
                sh 'df -h'

                // Build Docker image with the tag 'vitedockerreact'
                sh 'docker build -t vite-docker-app .'
            }
        }

        // Stage 5: Kill process on port 3000 and run Docker container
        stage('run') {
            steps {
                // Print Docker version for debugging
                sh 'docker version'

                // Print the images available on the host for debugging
                sh 'docker images'

                // Kill the process using port 3000
                sh 'fuser -k 3000/tcp || true'

                // Run Docker container with port mapping (host:container)
                sh 'docker run -d -p 3000:80 --name react-container vite-docker-app'

                // Sleep for a short duration to allow the container to start
                sh 'sleep 10'

                // Print running containers for debugging
                sh 'docker ps'

                // Print container logs for debugging
                sh 'docker logs $(docker ps -q)'
            }
        }
    }
}
