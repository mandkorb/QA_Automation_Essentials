pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '--network host -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                git branch: 'main', url: 'https://github.com/mandkorb/Java_Automation_Essentials.git'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '--network host -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Run Tests') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '--network host -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'clean -Dtest=BookingServiceImplTests test'
            }
        }
        stage('Generate Allure Report') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '--network host -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn allure:report'
            }
        }
    }
    post {
        always {
            node('') {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
            }
            // Clean workspace outside node to avoid context issues
            node('') {
                cleanWs()
            }
        }
    }
}