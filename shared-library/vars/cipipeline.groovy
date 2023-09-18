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
                    allof {
                        expression{ env.BRANCH_NAME != null}
                        expression{ env.TAG_NAME  == null }

                    }
                }
                steps {
                    echo 'Hello World'
                    sh 'env'
                }
            }

            stage('Code Quality') {
                when {
                    allof {
                        expression { env.BRANCH_NAME != null }
                        expression { env.BRANCH_NAME == null }
                    }
                }
                steps {
                    echo 'Hello World'
                    sh 'env'
                }
            }

            stage('Code Security') {
                when {
                    expression { BRANCH_NAME == "main"}
                }
                steps {
                    echo 'Hello World'
                    sh 'env'
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