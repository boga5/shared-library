
def call(def Sonar_project_name)
{
  def Reason = "Triggering CD job failed"
  CD_Job_name = Sonar_project_name + "_QA"
  build job: 'Docker_registry'//, parameters: [[$class: 'StringParameterValue', name: 'var1', value: 'var1_value']]
  return Reason
}
