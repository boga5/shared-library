def call(def Docker_Reg_Name, def om_image_name, def cp_image_name, def Docker_Registry_URL, def Docker_Credentials, def image_version, def JobName) {
stage('Pushing Artifacts')
				{
					Reason = "Pushing Artifacts stage failed"
					if(!(JobName.contains('PR-')))
					{
                    // **** Stage for Deploying artifacts to Artifactory **** //    
					PushingArtifacts()
					 // **** Stage for Publishing Docker images **** //       
					 stage ('Publish Docker Images'){
					  Reason = "Publish Docker Images Failed"        
					  def images = []
					  images[0] = "${docker_properties.Docker_Reg_Name}/${docker_properties.om_image_name}"
					  images[1] = "${docker_properties.Docker_Reg_Name}/${docker_properties.cp_image_name}"
					   docker.withRegistry("${docker_properties.Docker_Registry_URL}", "${docker_properties.Docker_Credentials}") {
								   images.each { def image ->
						docker.image("${image}").push("${docker_properties.image_version}")
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
}
