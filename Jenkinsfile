pipeline {
    agent any
    
    stages {
         stage('Build') { 
            steps {
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
            }
        }
         stage('Test') { 
             environment {
                 TEST = '15'
                 GIT_COMMIT = 'Whatever'
             }
             script {
                 def scmVars = checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
                 GIT_COMMIT = scmVars.SVN_REVISION
             }

            steps {
                echo "Test is ${TEST}"
                echo "Commit ist ${GIT_COMMIT}"
               // git 'https://github.com/Wheedman/RunExec.git'
               // teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100'
            }
        }


        stage('Deploy') { 
            environment {
                GIT_COMMIT = "${env.GIT_COMMIT}"
            }
            steps {
                sh 'echo "${env.GIT_COMMIT}"'
                step([$class: 'TeamscaleUploadBuilder', 
                  url: 'http://localhost:8100',
                  credentialsId: 'teamscale_id', 
                  teamscaleProject: 'jenkinsplugin',
                  partition: 'pipeline',
                  uploadMessage: 'Test',
                  antPatternForFileScan: '**/*.simple',
                  reportFormatId: 'SIMPLE']) // OK
            }
        }
    }
}
