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
                 GIT_COMMIT = 'Whatever'
             }

            steps {
                script {
                 def scmVars = git 'https://github.com/Wheedman/RunExec.git'
                 GIT_COMMIT = scmVars.GIT_COMMIT
             }
                echo "Commit ist ${GIT_COMMIT}"
               teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
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
