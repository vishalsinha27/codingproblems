package ss.practice;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App 
{
  public void startTimesTableTest(int start, int end, int timesStart, int timesEnd, int numberOfMins, Score score, Scanner scan) {
    Instant startTime  = Instant.now() ;
    int elaspsedMins = 0 ;

    do{
      Instant currentTime = Instant.now() ;
      Duration d = Duration.between(startTime, currentTime) ;
      elaspsedMins = (int)d.getSeconds()/60 ;
      int multiplier = ThreadLocalRandom.current().nextInt(start, end + 1);
      int times = ThreadLocalRandom.current().nextInt(timesStart, timesEnd + 1);
      System.out.print(multiplier + " X "+ times + " = ");
      String answerStr = scan.next() ;
      int answer = 0  ;
      try{
        answer = Integer.parseInt(answerStr) ;
      }catch(Exception e) {
        return ;
      }
      
      int correctAnswer = multiplier * times ;
      score.total = score.total+1 ;
      if(correctAnswer == answer) {
        score.currentScore = score.currentScore+1 ;
        System.out.println("Correct!");
      } else {
        System.out.println("Wrong! "+multiplier+" X "+times+ " = "+correctAnswer);
      }
      
    }while(elaspsedMins<numberOfMins) ;
  }
  
  public static class Score{
    int currentScore ;
    int total ;
    String name ;
  }
    public static void main( String[] args )
    {
        System.out.print("Please enter your name ");
        Scanner scanner = new Scanner(System.in) ;
        String s = scanner.next() ;
        //System.out.println();
        //System.out.println("Welcome "+s+ ". Lets start the fun");
        System.out.println();
        System.out.print(s+" enter the number of mins you want to play this game ");

        String mins = scanner.next() ;
        int totalMins = 3 ;
        if(mins!=null) {
          try{
            totalMins = Integer.parseInt(mins) ;
            if(totalMins > 10) {
              totalMins = 10 ;
            }
          }catch(Exception e){
          }
        }

        System.out.println("You are going to play for "+totalMins + " mins.");
        Score score = new Score() ;
        score.name = s ;
        if(totalMins > 0) {
          App app = new App() ;
          
          app.startTimesTableTest(12, 15, 2, 10, totalMins, score, scanner);

        }
        scanner.close();

        System.out.println();
        System.out.println(score.name + ", your score is "+score.currentScore+ " out of "+score.total+ " in "+totalMins + " mins");
        System.out.println("Bye...");

    }
}
