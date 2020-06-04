node{

                  checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [[$class: 'LocalBranch', localBranch: 'master']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/Wheedman/RunExec']]])

              withEnv(['TEAMSCALE_ID = credentials(\'teamscale_id\')']) {
                step([$class: 'TeamscaleUploadBuilder', 
                  url: 'http://localhost:8100',
                  userName: 'admin',
                  ideKey: 'team',
                  teamscaleProject: $TEAMSCALE_ID,
                  partition: 'pipeline',
                  uploadMessage: 'Test',
                  antPatternForFileScan: '**/*.simple',
                  reportFormatId: 'SIMPLE']) // OK
              }  
}
