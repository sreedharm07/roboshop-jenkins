def call () {

    pipeline {
        agent any

        stages {
            stage('Compile-code') {
                steps {
                    sh 'env'
                }
            }

            stage('Test') {
                when{
                    expression{ env.BRANCH_NAME == ".*"}
                }
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Quality') {
                when{
                    expression{ env.BRANCH_NAME == ".*"}
                }
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Security') {
                when {
                    expression { BRANCH_NAME == "main"}
                }
                steps {
                    echo 'Hello World'
                }
            }

            stage('Release') {
                when{
                    expression{ env.TAG_NAME ==~ ".*" }
                }
                steps {
                    sh 'env'
                    echo 'Hello World'
                }
            }

        }
    }
}