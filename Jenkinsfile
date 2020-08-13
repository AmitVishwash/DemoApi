
pipeline {
  agent any
  stages {
  stage('Build Stage 1') {
      steps {
        script {
          echo ' BuildingStage 1......'
        }
      }
    }
  stage('TestStage 2') {
      steps {
        script {
          echo ' Testing Stage 2.....'
        }
      }
    }
    stage('Deploy Stage 3')
    {
      steps{
        script{
          echo ' Deploying to stage 3'
          echo 'Deployed Successfuly'
        }
      }
    }
  }
}
