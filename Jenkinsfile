pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                git branch: 'jenkins', url: 'https://github.com/mandkorb/Java_Automation_Essentials.git'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2'
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
                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2 --network host'
                }
            }
            steps {
                sh 'mvn test -Ptestng' // Assumes TestNG profile
            }
        }
        stage('Generate Allure Report') {
            agent {
                docker {
                    image 'selenium/standalone-chrome:latest'
                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2'
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