def call(def lock_resource_name, def robot_result_folder, def rtMaven, def server, def Docker_Reg_Name, def om_image_name, def cp_image_name, def Docker_Registry_URL, def Docker_Credentials, def image_version, def jar_name, def JobName) {
println "Inside"
Reason = "Docker Deployment or Robot Framework Test cases Failed"
   lock(lock_resource_name) {
    // Docker Compose starts // 
    sh "jarfile_name=${jar_name} /usr/local/bin/docker-compose up -d"
    sh "sudo chmod 777 wait_for_robot.sh "
                sh './wait_for_robot.sh'
     step([$class: 'RobotPublisher',
     outputPath: "/home/robot/${robot_result_folder}",
     passThreshold: 0,
     unstableThreshold: 0,
     otherFiles: ""])
     println "outside"
    // If Robot Framework test case fails, then the build will be failed // 
    if("${currentBuild.result}" == "FAILURE")
      { 
                         sh ''' ./clean_up.sh
                         echo "after cleanup"
       exit 1'''
      } 
    // If it is a GitHub PR job, then this part doesn't execute //      
   stage('Pushing Artifacts')
    {
                Reason = "Pushing Artifacts stage failed"
    if(!(JobName.contains('PR-')))
    {
                    // **** Stage for Deploying artifacts to Artifactory **** //    
     stage ('Artifacts Deployment'){  
      Reason = "Artifacts Deployment Failed"
      rtMaven.deployer.deployArtifacts buildInfo
      server.publishBuildInfo buildInfo
     }
     // **** Stage for Publishing Docker images **** //       
     stage ('Publish Docker Images'){
      Reason = "Publish Docker Images Failed"        
      def images = []
      images[0] = "${Docker_Reg_Name}/${om_image_name}"
      images[1] = "${Docker_Reg_Name}/${cp_image_name}"
       docker.withRegistry("${Docker_Registry_URL}", "${Docker_Credentials}") {
                   images.each { def image ->
        docker.image("${image}").push("${image_version}")
        docker.image("${image}").push("latest")
               }
       }
      sh """docker logout
       """
        }  //Docker publish stage ends here
     
     // **** Stage for triggering CD pipeline **** //    
    /* stage ('Starting QA job') {
     Reason = "Trriggering downStream Job Failed"
                    CD_Job_name = Sonar_project_name + "_QA"
          build job: CD_Job_name//, parameters: [[$class: 'StringParameterValue', name: 'var1', value: 'var1_value']]
     }*/ 
    }     //if loop
    }
    sh './clean_up.sh' 
   }
}

