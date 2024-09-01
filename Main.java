import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int chance = 0;
        int[] stats = new int [3];
        stats[0] = 100;
        stats[1] = 1000;
        stats[2] = 1000;
        String response = "";
        int prompt = 0;
        int index = 0;
        boolean gameLost = false;
        
        

        //Initializing Game
        System.out.println(" _______  _______  ___   ___        _______  __   __  _______    _______  _______  _______ ");
        System.out.println("|       ||   _   ||   | |   |      |       ||  | |  ||       |  |       ||       ||   _   |");
        System.out.println("|  _____||  |_|  ||   | |   |      |_     _||  |_|  ||    ___|  |  _____||    ___||  |_|  |");
        System.out.println("| |_____ |       ||   | |   |        |   |  |       ||   |___   | |_____ |   |___ |       |");
        System.out.println("|_____  ||       ||   | |   |___     |   |  |       ||    ___|  |_____  ||    ___||       |");
        System.out.println(" _____| ||   _   ||   | |       |    |   |  |   _   ||   |___    _____| ||   |___ |   _   |");
        System.out.println("|_______||__| |__||___| |_______|    |___|  |__| |__||_______|  |_______||_______||__| |__|");
        System.out.println("");
        System.out.println("The year is 1500. Christopher Columbus has returned from his voyage bearing news of fortune in the New World.");
        System.out.println("As an esteemed captain, you are sent to investigate and bring back riches for yourself and for the crown.");
        System.out.println("Your ship has " + stats[0]+ " sailors, " + stats[1] + " lbs of supplies, and " + stats[2] + " dollars.");
        System.out.println("To set sail, type begin.");
        response = in.nextLine();

        //Wait until correct input is received
        while (!response.toLowerCase().equals("begin")){
            System.out.println("I couldn't understand that. Try again.");
            response = in.nextLine();
        } 

        System.out.println("Your ship sets sail from Venice and enters the Mediterranean.");
        for (int turns = 0; turns <16; turns++){
            if (stats[0] <= 0 || stats[1] <= 0 || stats[2] <= 0){
                gameLost = true;
                break;
            }
            prompt = Func.randEvent();
            System.out.println("Possible commands are: \"give\", \"drop\", or \"pay\" You can also press enter if the above are not applicable. ");
            response = in.nextLine();
            
            //Receives input based on the prompt
            if (prompt == 0 ) {
                while (!response.toLowerCase().equals("give") && !response.toLowerCase().equals("pay")){
                    System.out.println("I couldn't understand that. Try again.");
                    response = in.nextLine();
                }
                if (response.toLowerCase().equals("give")) {
                    index = 0;
                } else if (response.toLowerCase().equals("pay")){
                    index = 2;
                }
            } else if (prompt == 1 || prompt ==3) {
                while (!response.toLowerCase().equals("give") && !response.toLowerCase().equals("pay") && !response.toLowerCase().equals("drop")){
                    System.out.println("I couldn't understand that. Try again.");
                    response = in.nextLine();
                }
                if (response.toLowerCase().equals("give")) {
                    index = 0;
                } else if (response.toLowerCase().equals("pay")){
                    index = 2;
                } else if (!response.toLowerCase().equals("drop")){
                    index =1;
                }
            } else if (prompt ==2){
                while (!response.toLowerCase().equals("drop") && !response.toLowerCase().equals("pay")){
                    System.out.println("I couldn't understand that. Try again.");
                    response = in.nextLine();
                }
                if (response.toLowerCase().equals("drop")) {
                    index = 1;
                } else if (response.toLowerCase().equals("pay")){
                    index = 2;
                }
            } else if (prompt == 4 || prompt == 9){
                Func.bonusUpdate(-10, stats, 0);
            } else if (prompt == 8){
                Func.bonusUpdate(100, stats, 2);
            } else if (prompt == 6 || prompt == 7) {
                Func.bonusUpdate(100, stats, 1);
            }
            //Stats are updated and a recap message is displayed
            Func.statUpdate(response, stats, index);
            System.out.println("");
            System.out.println("Your current stats are:" + stats[0]+ " sailors, " + stats[1] + " lbs of supplies, and " + stats[2] + " dollars.");
            System.out.println("You continue to sail west when...");
            System.out.println("");
        }
        
        //End of game messages
        if (gameLost){
            System.out.println("You didn't make it. Try again.");
        } else {
            System.out.println("You made it!");
            System.out.println("Your final stats were:" + stats[0]+ " sailors, " + stats[1] + " lbs of supplies, and " + stats[2] + " dollars.");
        }
    }
}
