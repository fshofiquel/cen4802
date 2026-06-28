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
            bat '''
              set "JAVA_HOME=C:\\Users\\fshof\\.jdks\\temurin-21.0.11"
              set "PATH=%JAVA_HOME%\bin;%PATH%"
              echo JAVA_HOME=%JAVA_HOME%
              where java
              java -version
              gradlew.bat clean build --no-daemon
            '''
          }
        }
      }
    }

    stage('Publish Test Results') {
      steps {
        // JUnit XMLs produced by Gradle are here by default
        junit 'build/test-results/test/*.xml'
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