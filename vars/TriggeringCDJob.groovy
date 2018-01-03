def call(def Sonar_project_name)
{
  CD_Job_name = Sonar_project_name + "_QA"
  build job: "Docker_registry"//, parameters: [[$class: 'StringParameterValue', name: 'var1', value: 'var1_value']]
}
