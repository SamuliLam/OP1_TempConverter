pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
        GIT_CREDENTIALS = credentials('f20fa5db-cb60-4b5d-9eab-1375c94a18c7')
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'SamuliLam', url: 'https://github.com/SamuliLam/OP1_TempConverter.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
    }
}
