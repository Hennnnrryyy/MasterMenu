import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sun.awt.AWTAccessor.SystemColorAccessor;

import java.lang.Character;

public class Client {

    public static void walkToStand(){
        System.out.println("You walk up to the only Taco Stand open during quarantine.");
        System.out.println("Your order number is #" + getOrderNumber());
    }

    public static void showMenu(){
        System.out.println("Here is the menu: \n" +
            "1. Taco ($2.50)\n" +
            "2. Burrito ($8) \n" +
            "3. Bowl ($7) \n" +
            "4. Taco Salad \n" +
            "5. Double-decker Taco \n" +
            "6. Order of tacos (3) \n" +
            "7. Traveler's Pack \n" +
            "8. Sampler's Pack \n" +
            "9. Party Platter \n" +
            "Press 0 to leave the Taco Stand \n" +
            "All options can be served  chicken, steak, pork, or vegetarian style!");
    }

    public static void showToppings(){
        System.out.println("1. Cheese\n" +
        "2. Pico De Gallo\n" + 
        "3. Lettuce\n" +
        "4. Sour Cream\n" +
        "5. Guacamole\n" +
        "6. Mango Salsa\n" +
        "7. Peach Salsa\n" +
        "8. Mild Sauce\n" +
        "9. Hot Sauce\n" +
        "Press 0 for no more toppings.");
    }

    public static int optionHandler(char o, String zero){
        int i = 0;
        switch(o){
            case '0':
                System.out.println(zero);
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                System.out.println("We could not understand what you were trying to say. Maybe remove the mask and pick a number 0-9.");
                return -1;
        }  
    }
    public static ArrayList<Integer> askForToppings(Scanner input){
        ArrayList<Integer> toppingList = new ArrayList<Integer>();
        System.out.println("Choose a topping. Don't worry you'll get to choose more. Here are our options:");
        showToppings();
        char c = input.next().charAt(0);
        int j = optionHandler(c, "No more toppings? That's okay, quarantine must have you financially stressed\n");
        toppingList.add(j);
        
        while(j != 0){
            System.out.println("Choose another topping if your heart desires. Here are our options:");
            showToppings();

            c = input.next().charAt(0);
            j = optionHandler(c, "No more toppings? That's okay, quarantine must have you financially stressed\n");
            toppingList.add(j);
        }
        return toppingList;      
    }
    public static ArrayList<Integer> getToppingsWithAmount(ArrayList<Integer> a){ // ArrayList returned with format, <topping, amount, ...>
        if (a.isEmpty())
            return null;
        ArrayList<Integer> formatted = new ArrayList<Integer>();
        Collections.sort(a); // Sort parameter list

        int i = 0, count = 1;
        while(i < a.size()-1){
            if(a.get(i) <= 0){
                i++;
                continue;
            }
            if(a.get(i+1) == a.get(i))
                count++;
            else{
                formatted.add(a.get(i));
                formatted.add(count);
                count = 1;
            }
            i++;
        }
        formatted.add(a.get(i));
        formatted.add(count);

        return formatted;
    }

    public static Component addTopping(int toppingChoice, int amount, Component current){
        switch(toppingChoice){
            case 1:
                return new Cheese(current, amount);
            case 2:

            case 3:
    
            case 4:
    
            case 5:
        
            case 6:
           
            case 7:
            
            case 8:
            
            case 9:
            
            default:
                return current;
        }
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
            int i = optionHandler(option, "You will be missed. Stay safe in this quarantine!\n");
            Component myOrder = null;
            switch(i){
                case 0:
                    again = 'N';
                break;

                case 1:
                    System.out.println("What type of rice would you like?");
                    String rice =  input.next();
                    System.out.println("What type of meat would you like?");
                    String meat = input.next();
                    myOrder = new Taco(rice, meat);
                    ArrayList<Integer> formattedToppings = getToppingsWithAmount(askForToppings(input));
                    for(int j = 0; j < formattedToppings.size(); j+=2){
                        myOrder = addTopping(formattedToppings.get(j), formattedToppings.get(j+1), myOrder);
                    }
                break;

                case 2:
                    System.out.println("What type of rice would you like?");
                    String rice2 =  input.next();
                    System.out.println("What type of meat would you like?");
                    String meat2 = input.next();
                    myOrder = new Burrito(rice2, meat2);
                    ArrayList<Integer> formattedToppings2 = getToppingsWithAmount(askForToppings(input));
                    for(int j = 0; j < formattedToppings2.size(); j+=2){
                        myOrder = addTopping(formattedToppings2.get(j), formattedToppings2.get(j+1), myOrder);
                    }
                break;

                case 3:
                    System.out.println("What type of rice would you like?");
                    String rice3 =  input.next();
                    System.out.println("What type of meat would you like?");
                    String meat3 = input.next();
                    myOrder = new Bowl(rice3, meat3);
                    ArrayList<Integer> formattedToppings3 = getToppingsWithAmount(askForToppings(input));
                    for(int j = 0; j < formattedToppings3.size(); j+=2){
                        myOrder = addTopping(formattedToppings3.get(j), formattedToppings3.get(j+1), myOrder);
                    }
                break;

                case 4:

                break;

                case 5:

                break;

                case 6:

                break;

                case 7:

                break;

                case 8:

                break;

                case 9:

                break;

                default:
                break;
            }
            if(myOrder != null){
                System.out.println("Here's your order:\n" + myOrder.getDescription());
                System.out.println("Total cost: $" + myOrder.getCost());

                System.out.println("Would you like to get some more food (Y/N)?");
                again = Character.toUpperCase(input.next().charAt(0));
            }
        }
        input.close();
        System.out.println("Thank you for eating with us! Take care and remember to practice to social distancing!");
    }
}