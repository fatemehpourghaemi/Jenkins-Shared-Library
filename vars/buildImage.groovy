#!/usr/bin/env groovy

def call() {
    echo "building the docker image.."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t fatemehpourghaemi82/my-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push fatemehpourghaemi82/my-repo:jma-2.0'
    }
}