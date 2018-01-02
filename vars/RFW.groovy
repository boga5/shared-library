def call(def lock_resource_name, def robot_result_folder, def rtMaven, def server) {
sh "jarfile_name=${jar_name} /usr/local/bin/docker-compose up -d"
    sh "sudo chmod 777 wait_for_robot.sh "
                sh './wait_for_robot.sh'
    robot_result_folder = docker_properties.robot_result_folder
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
}
