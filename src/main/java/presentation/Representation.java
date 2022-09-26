package presentation;

import gamesRoom.GamesRoom;
import metier.Metier;
import session.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Representation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args) throws ParseException {

        boolean proRun = true;
        // Initiate  GamesRoom class
        GamesRoom gamesRoom = new GamesRoom();

        // Initiate  metier class
        Metier metier = new Metier();
        while(proRun){
            System.out.println();
            System.out.printf(ANSI_CYAN+"%-60s %-60s %-60s %s\n"+ANSI_RESET,"1-Review posts","2-Add session","3-Get the total incoming","4-leave the program");

            Scanner input = new Scanner(System.in);


            // First choice
            System.out.printf("\nEnter your choice : ");
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
                    if(GamesRoom.places.size()>=2 ){
                        if(GamesRoom.waitingLine.size()>=8){
                            System.out.println("GameSpace is full");
                            break;
                        }
                        metier.addToWaitingLine();

                        break;
                    }
                    metier.addSession();
                    break;
                case 3 :
                    System.out.println("get the total incoming");
                    break;
                case 4 :
                    proRun = false;
                    break;
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------");
            System.out.println();
        }

    }
}
