def call() {

    node('workstation') {
         sh 'env'
        checkout scmGit(
                branches: [[name: '']],
                userRemoteConfigs: [[url: "https://github.com/sreedharm07/a-${component}.git"]])

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