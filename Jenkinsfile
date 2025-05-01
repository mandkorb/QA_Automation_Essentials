pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-11'
                    args '-u root -v $HOME/.m2:/root/.m2' // Run as root, cache Maven deps
                }
            }
            steps {
                git branch: 'jenkins', url: 'https://github.com/mandkorb/Java_Automation_Essentials.git'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-11'
                    args '-u root -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'clean -Dtest=BookingServiceImplTests test'
            }
        }
        stage('Run API Tests') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-11'
                    args '-u root -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn test -Ptestng' // Adjust profile if needed
            }
        }
        stage('Generate Allure Report') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-11'
                    args '-u root -v $HOME/.m2:/root/.m2'
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
                script {
                    if (fileExists('target/allure-results')) {
                        allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                        archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
                    } else {
                        echo 'No Allure results found, skipping report generation.'
                    }
                }
            }
            node('') {
                cleanWs()
            }
        }
    }
}