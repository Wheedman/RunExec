pipeline {
    agent any
    
    stages {
         stage('Build') { 
            steps {
                git 'https://github.com/Wheedman/RunExec.git'
               // teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
            }
        }

         stage('Test') {
            steps {
               teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
               teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
          
            }
        }
    }
    post { 
            always {
               
            //     script {
            //      def GIT_COMMIT = ""
            //      def scmVars = checkout([$class: 'GitSCM', 
            //         branches: [[name: '*/master']], 
            //         doGenerateSubmoduleConfigurations: false, 
            //         extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
            //         submoduleCfg: [], 
            //         userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])  
            //      GIT_COMMIT = scmVars.GIT_COMMIT
            //  }
                echo "Commit ist ${GIT_COMMIT}"
              // teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
               //teamscale antPatternForFileScan: '**/*.simple', credentialsId: 'teamscale_id', partition: 'pipeline', reportFormatId: 'SIMPLE', teamscaleProject: 'jenkinsplugin', uploadMessage: 'Test', url: 'http://localhost:8100', revision: "${GIT_COMMIT}"
          
            }
    }
}
