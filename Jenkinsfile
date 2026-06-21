pipeline {
  agent any


  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        script {
          if (isUnix()) {
            sh './gradlew clean build --no-daemon'
          } else {
            bat 'gradlew.bat clean build --no-daemon'
          }
        }
      }
    }

    stage('Publish Test Results') {
      steps {
        // JUnit XMLs produced by Gradle are here by default
        junit 'build/test-results/test/*.xml'
        // publish the html report (requires HTML Publisher plugin)
        publishHTML (target: [
          allowMissing: true,
          alwaysLinkToLastBuild: true,
          keepAll: false,
          reportDir: 'build/reports/tests/test',
          reportFiles: 'index.html',
          reportName: 'Unit Test Report'
        ])
      }
    }

    stage('Archive Artifact') {
      steps {
        archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true, allowEmptyArchive: true
      }
    }
  }

  post {
    success {
      echo "Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    }
    failure {
      echo "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    }
    always {
      // keep a short link in console
      echo "Finished. Result: ${currentBuild.currentResult}"
    }
  }
}