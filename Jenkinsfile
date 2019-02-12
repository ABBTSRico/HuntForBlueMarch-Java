pipeline {
    stages {
        stage('Clean') {
          steps {
            sh 'mvn -DskipTests clean'
          }
        }
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests package' 
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}