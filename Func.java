public class Func {
    //Decides the random event for each turn
    public static int randEvent(){
        int randNum = (int)(Math.random() * 11);
        String response = "";

        if (randNum == 0){
            response = "Pirates have boarded your ship! They give you two choices: Hand over 10 sailors or give them $250";
        } else if (randNum == 1){
            response = "You've been hit by a storm and the ship has been damaged. To continue on your voyage you must lose weight or fix your ship. Drop 10 sailors, drop 100lbs of supplies, or spend $250";
        } else if (randNum == 2){
            response = "You encounter foreign ships and they demand you pay their toll. You can give them $250 or 100lbs of supplies";
        } else if (randNum == 3){
            response = "Ambush! Your ship has been attacked. To continue on your voyage you must lose weight or fix your ship. Drop 10 sailors, drop 100lbs of supplies, or spend $250 ";
        } else if (randNum == 4){
            response = "Mutiny! A band of 10 sailors have risen up against your command. To the plank they go!";
        } else if (randNum == 5){
            int x = (int)Math.random()*10;
            if (x>5){
                response = "Someone on your ship claims to see sunken treasure. After retrieving the chest, you find $100 of gold.";
                randNum = 8;
            } else {
                response = "Someone on your ship claims to see sunken treasure. After retrieving the chest, you realize it was only scrap metal";
            }
        } else if (randNum == 6){
            response = "You come across a mysterious island. After sending some sailors ashore, they return with supplies.";
        } else if (randNum == 7){
            response = "You dock your ship at a nearby friendly island. They provide you with more supplies.";
        } else if (randNum == 9){
            response = "Scurvy outbreak! The infected are thrown overboard.";
        } else if (randNum == 10){
            response = "Just another day on the ocean";
        } else if (randNum == 11){
            response = "Strong winds. Be sure to follow the map.";
        }
        System.out.println(response);
        return randNum;
    }

    //Updates the player's stats according to input
    public static int[] statUpdate(String response, int[] stats, int index) {
        if (response.toLowerCase().equals("give")) {
            stats[index] = stats[index] - 10;
        } else if (response.toLowerCase().equals("pay")) {
            stats[index] = stats[index] - 250;
        } else if (response.toLowerCase().equals("drop")) {
            stats[index] = stats[index] - 100;
        }
        return stats;
    }
    
    //Updates the players stats for events without input
    public static int[] bonusUpdate (int amount, int[] stats, int index){
        stats[index] += amount;
        return stats;
    }
}