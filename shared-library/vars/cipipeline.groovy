def call () {

    pipeline {
        agent any

        stages {
            stage('Compile-code') {
                steps {
                    sh 'env'

                    }
                }
            }

            stage('Test') {
                when {
                    expression { TAG_NAME != "null"}
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Quality') {
                when {
                    expression { BRANCH_NAME == "main"}
            }
                steps {
                    echo 'Hello World'
                }
            }

            stage('Code Security') {
                steps {
                    echo 'Hello World'
                }
            }

            stage('Release') {
                steps {
                    echo 'Hello World'
                }
            }

        }
    }
}
