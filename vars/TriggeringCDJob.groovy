def call()
{
  CD_Job_name = Sonar_project_name + "_QA"
	build job: CD_Job_name//, parameters: [[$class: 'StringParameterValue', name: 'var1', value: 'var1_value']]
}
