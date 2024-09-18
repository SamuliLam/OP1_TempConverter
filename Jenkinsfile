pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Program Files\\Git\\bin" // Update the PATH to include the directory of cmd.exe
        GIT_CREDENTIALS = credentials('SamuliLam')
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
