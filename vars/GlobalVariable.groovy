class GlobalVar
{
    def JobName	= null						    // variable to get jobname  
    def Sonar_project_name = null 				// varibale passed as SonarQube parameter while building the application
    def robot_result_folder = null 				// variable used to store Robot Framework test results
    def server = Artifactory.server 'server1'	    // Artifactory server instance declaration. 'server1' is the Server ID given to Artifactory server in Jenkins
    def buildInfo = null 						// variable to store build info which is used by Artifactory
    def rtMaven = Artifactory.newMavenBuild()	// creating an Artifactory Maven Build instance
    def Reason = "JOB FAILED"					// variable to display the build failure reason
    def VariableObject                                    // object for class A
}
def call()
{
    GlobalVar globalVar = new GlobalVar()
    return globalVar
}
