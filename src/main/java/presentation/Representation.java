package presentation;

import gamesRoom.GamesRoom;
import metier.Metier;
import session.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Representation {
    public static void main(String[] args) throws ParseException {

        boolean proRun = true;

        // Initiate  GamesRoom class
        GamesRoom gamesRoom = new GamesRoom();

        // Initiate  metier class
        Metier metier = new Metier();
        while(proRun){

            System.out.printf("%-60s %-60s %-60s %s\n","1-Review posts","2-Add session","3-Get the total incoming","4-leave the program");

            Scanner input = new Scanner(System.in);


            // First choice
            System.out.print("Enter your choice : ");
            int inst1 = Integer.parseInt(input.nextLine());


            // Make sure for the input
            while(inst1 > 4){
                System.out.print("Enter the right number : ");
                inst1 = Integer.parseInt(input.nextLine());
            }


            // Execute the asking
            switch(inst1){
                case 1 :
                    metier.checkPosts();
                    break;
                case 2 :

                    System.out.printf("\nFirst Name : ");
                    String fName = input.nextLine();

                    System.out.printf("\nLast Name : ");
                    String lName = input.nextLine();

                    System.out.printf("\nGame : ");
                    String game = input.nextLine();

                    System.out.printf("\nPost number : ");
                    int nPost = Integer.parseInt(input.nextLine());

                    System.out.printf("\nPeriod : ");
                    int period = Integer.parseInt(input.nextLine());

                    System.out.printf("\nTime to Start : ");
                    String strTime = input.nextLine();

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    java.sql.Time startTime = new java.sql.Time(format.parse(strTime).getTime());

                    metier.addSession(fName,lName,game,nPost,period,startTime);

                    break;
                case 3 :
                    System.out.println("get the total incoming");
                    break;
                case 4 :
                    proRun = false;
                    break;
            }
            System.out.println("-----------------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------");
        }

    }
}
