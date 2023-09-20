def call() {

    node('workstation') {
        sh "find .| sed -e '1d' | xargs rm -rf "
        sh 'env'

        if (env.TAG_NAME ==~ ".*") {
            env.BRANCH_NAME = "refs/tags/${env.TAG_NAME}"
        } else {
            env.BRANCH_NAME = "${env.BRANCH_NAME}"
        }
        checkout scmGit(
                branches: [[name: BRANCH_NAME]],
                userRemoteConfigs: [[url: "https://github.com/sreedharm07/a-${component}.git"]])


        if (env.TAG_NAME ==~ ".*") {
            common.compile()
            common.release()
        } else {
            if (env.BRANCH_NAME == "main") {
                common.compile()
                common.test()
                common.codequality()
                common.codesecurity()
            } else {
                common.compile()
                common.test()
                common.codequality()
            }
        }
    }
}