def call() {

    node('workstation') {
         sh "find .| sed -e '1d' | xargs rm -rf "

        if (env.TAG_NAME ==~ ".*"){
            env.BRANCH_NAME = "refs/tags/${env.TAG_NAME}"
        }
        else
            env.BRANCH_NAME = "${env.BRANCH_NAME}"

        checkout scmGit(
                branches: [[name: BRANCH_NAME]],
                userRemoteConfigs: [[url: "https://github.com/sreedharm07/a-cart.git"]])

        stage('compile-code') {
            common.compile()
        }

        if ( env.TAG_NAME == null){
        stage('test') {
            echo 'test'
        }
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