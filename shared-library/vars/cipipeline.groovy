def call() {

    node('workstation') {
         sh 'env'
        if (env.TAG_NAME ==~ ".*"){
            env.BRANCH_NAME = "refs/tags/${TAG_NAME}"
        }
        else
            env.BRANCH_NAME = "${BRANCH_NAME}"

        checkout scmGit(
                branches: [[name: BRANCH_NAME]],
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