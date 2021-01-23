pipeline {
  agent any
  stages {
    stage('Build On DEV') {
      parallel {
        stage('Build On DEV') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run On DEV') {
          steps {
            bat 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Build On QA') {
      parallel {
        stage('Build On QA') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run On QA') {
          steps {
            bat 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Build On Stage') {
      parallel {
        stage('Build On Stage') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run On Stage') {
          steps {
            bat 'mvn test -Denv=stage'
          }
        }

      }
    }

    stage('Publish Reports') {
      steps {
        script {
          allure([
            includeProperties: false,
            jdk: '',
            Properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: '/allure-results']]
          ])
        }

      }
    }

  }
}