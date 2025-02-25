pipeline {
    agent any
 stages {
        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        } 
    }
    post{
always{

archiveArtifacts artifacts: '*//*/*.jar', followSymlinks: false

        emailext body: '''Hi,

This is status of pipeline executed.

Thanks,''', subject: 'Pipeline Status', to: 'borkar.sharda92@gmail.com'
    }}}
