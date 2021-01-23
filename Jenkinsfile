pipeline {
  agent any
  stages {
    stage('Build on Dev') {
      parallel {
        stage('Build on Dev') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run On Dev') {
          steps {
            sh 'mvn test -Denv=dev
          }
        }

      }
    }

    stage('Run on QA') {
      parallel {
        stage('Build on QA  ') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run Test on QA and Chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('Run Test on QA and safari') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=safari'
          }
        }

      }
    }

    stage('Build on Stage') {
      parallel {
        stage('Build on Stage') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

       stage('Run Test on stage and chrome') {
          steps {
            sh 'mvn test -Denv=stage -Dbrowser=chrome'
          }
        }

      }
    }

    stage('Run on Prod') {
      parallel {
         stage('Run on Prod') {
          steps {
        sh 'mvn clean install -DskipTests=true'
      }
    }

   stage('Run Test on Prod and safari') {
          steps {
            sh 'mvn test -Denv=prod -Dbrowser=safari'
          }
    }
        stage('Chrome') {
      steps {
        sh 'mvn test -Denv=prod -Dbrowser=chrome'
      }
    }

  }
}
  }
  
  stage('publish Reports'){
  steps{
  script{
  allure([
  includeProperties:false,
  jdk:'',
  properties:[],
  reportBuildPolicy:'ALAWAYS',
  results:[[path:'/allure-results']]
  ])
  }
  }
  }
}
