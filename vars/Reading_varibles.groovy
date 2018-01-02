
class A {
	def lock_resource_name 
         def Sonar_project_name 
}
def call() {
JobName = "${JOB_NAME}"
	A a = new A()
	
           a.lock_resource_name = "jenkins-file"
           a.Sonar_project_name = "jenkins-file"
	println a.lock_resource_name
           println a.Sonar_project_name
	return a
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
