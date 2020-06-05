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

        stage('Deploy') { 
            steps {
               withCredentials([file(credentialsId: 'teamscale_file', variable: 'TEAMSCALE_ID')]) {
                echo '$TEAMSCALE_ID'
                step([$class: 'TeamscaleUploadBuilder', 
                  url: 'http://localhost:8100',
                  userName: 'admin',
                  ideKey: hudson.util.Secret.fromString('$TEAMSCALE_ID'),
                  teamscaleProject: 'jenkinsplugin',
                  partition: 'pipeline',
                  uploadMessage: 'Test',
                  antPatternForFileScan: '**/*.simple',
                  reportFormatId: 'SIMPLE']) // OK
               } 
            }
        }
    }
}
