def call()

pipeline {
    agent any

    parameters {
        string(name: 'COMPONENT', defaultValue: '', description: 'which component to deploy ?')
        string(name: 'ENV', defaultValue: '', description: 'which environment to deploy ?')
        string(name: 'VERSION', defaultValue: '', description: 'which version to deploy ?')
    }


    stages {
        stage ('deploy'){
            steps {
                sh '''



'''
            }
        }
    }
}