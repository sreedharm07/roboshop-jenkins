def call() {

    node('workstation') {
        sh 'find .'

        stage('compile-code') {
            common.compile()
        }

        stage('test') {
            echo 'test'
        }

        stage('code-quality') {
            echo 'code-quality'
        }

        stage('code-security') {
            echo 'code-security'
        }

        stage('release') {
            echo 'release'
        }
    }
}