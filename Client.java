import java.util.Scanner;
import java.lang.Character;

public class Client {

    public static void walkToStand(){
        System.out.println("You walk up to the only Taco Stand open during quarantine.");
    }

    public static void showMenu(){
        System.out.println("Your order number is #" + getOrderNumber());
        System.out.println("Here is the menu: \n" +
            "1. Taco \n" +
            "2. Burrito \n" +
            "3. Bowl \n" +
            "4. Taco Salad \n" +
            "5. Double-decker Taco \n" +
            "6. Order of tacos (3) \n" +
            "7. Traveler's Pack \n" +
            "8. Sampler's Pack \n" +
            "9. Party Platter \n" +
            "Press 0 to leave the Taco Stand \n" +
            "All options can be served  chicken, steak, pork, or vegetarian style!");
    }

    public static int optionHandler(char o){
        int i = 0;
        switch(o){
            case '0':
                System.out.println("You will be missed. Stay safe in this quarantine!");
                i = 0;
            break;

            case '1':
                i = 1;
            break;

            case '2':
                i = 2;
            break;

            case '3':
                i = 3;
            break;

            case '4':
                i = 4;
            break;

            case '5':
                i = 5;
            break;

            case '6':
                i = 6;
            break;

            case '7':
                i = 7;
            break;

            case '8':
                i = 8;
            break;

            case '9':
                i = 9;
            break;

            default:
                System.out.println("We could not understand what you were trying to say. Maybe remove the mask and pick a number 0-9.");
                i = 10;
            break;
        }  
        return i;
    }

    private static int getOrderNumber(){
        return 4;
    }
    public static void main(String args[]){
        System.out.println("Hello hungry person.");
        walkToStand();
        char again ='Y';
        char option = '0';
        Scanner input = new Scanner(System.in);

        while(Character.toUpperCase(again) == 'Y'){
            showMenu();
            option = input.next().charAt(0);
            int i = optionHandler(option);
            again = 'N';
        }
        input.close();
    }

}