pipeline {
    agent {
        docker {
            image 'selenium/standalone-chrome:latest'
            args '--network host -v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mandkorb/Java_Automation_Essentials.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'clean -Dtest=BookingServiceImplTests test'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
            cleanWs()
        }
    }
}