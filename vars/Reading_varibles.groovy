def call() {
JobName = "${JOB_NAME}"
           lock_resource_name = "jenkins-file"
            Sonar_project_name = "jenkins-file"
	println lock_resource_name
	println Sonar_project_name
        println JobName
	/*	if("${BRANCH_NAME}".startsWith('PR-'))
			{
             	lock_resource_name = JobName.substring(0 , JobName.indexOf("/"))+"_"+"${CHANGE_TARGET}"
                Sonar_project_name = lock_resource_name + "PR"
			}
			else
			{
				 lock_resource_name = JobName.substring(0 , JobName.indexOf("/"))+"_"+"${BRANCH_NAME}"
				 Sonar_project_name = lock_resource_name
			} */
}
