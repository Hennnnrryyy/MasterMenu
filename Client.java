import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
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
        System.out.println("1. Cheese ($0.50)\n" +
        "2. Pico De Gallo ($0.20)\n" + 
        "3. Lettuce ($0.10)\n" +
        "4. Sour Cream ($0.50)\n" +
        "5. Guacamole ($2.00)\n" +
        "6. Mango Salsa ($1.00)\n" +
        "7. Peach Salsa ($1.00)\n" +
        "8. Mild Sauce ($0.05)\n" +
        "9. Hot Sauce ($0.05)\n" +
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
                return new PicoDeGallo(current, amount);
            case 3:
                return new Lettuce(current, amount);
            case 4:
                return new SourCream(current, amount);
            case 5:
                return new Guacamole(current, amount);
            case 6:
                return new MangoSalsa(current, amount);
            case 7:
                return new PeachSalsa(current, amount);
            case 8:
                return new MildSauce(current, amount);
            case 9:
                return new HotSauce(current, amount);
            default:
                //System.out.println("That was incomprehensible. Let's try that again.");
                return current;
        }
    }

    public static Component customizeLeaf(Scanner input, String leaf){
        System.out.println("What type of rice would you like on your " + leaf + "?");
        String rice =  input.nextLine();
        System.out.println("What type of meat would you like on your " + leaf + "?");
        String meat = input.nextLine();
        Component myOrder = null;
        switch (leaf){
            case "Taco":
                myOrder = new Taco(rice, meat);
            break;
            case "Burrito":
                myOrder = new Burrito(rice, meat);
            break;
            case "Bowl":
                myOrder = new Bowl(rice, meat);
            break;
        }
        ArrayList<Integer> formattedToppings = getToppingsWithAmount(askForToppings(input));
        for(int j = 0; j < formattedToppings.size(); j+=2){
            myOrder = addTopping(formattedToppings.get(j), formattedToppings.get(j+1), myOrder);
        }
        return myOrder;
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
                    myOrder = customizeLeaf(input, "Taco");
                break;

                case 2:
                    myOrder = customizeLeaf(input, "Burrito");
                break;

                case 3:
                    myOrder = customizeLeaf(input, "Bowl");
                break;

                case 4:
                    Composite tacoSalad = new Composite("Taco Salad");
                    Composite bowl = new Composite("Bowl");
                    bowl.add(new Taco("White","Chicken"));
                    bowl.add(new Taco("White","Chicken"));
                    bowl.add(new Taco("White","Chicken"));
                    tacoSalad.add(bowl);
                    myOrder = tacoSalad;
                    // Where to go from here? Make classes for each composite? Or no? How to keep track of tree?
                    //(Composite) (tacoSalad.getChildren().get(0)).add(new Taco("White", "Chicken"));;
                    
                break;

                case 5:
                    
                break;

                case 6:
                    Composite orderOfTacos = new Composite("Three tacos");
                    System.out.println("Customize taco #1:");
                    orderOfTacos.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #2:");
                    orderOfTacos.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #3:");
                    orderOfTacos.add(customizeLeaf(input, "Taco"));
                    myOrder = orderOfTacos;
                break;

                case 7:
                    Composite travelersPack = new Composite("Traveler's pack");
                    System.out.println("Customize taco #1:");
                    travelersPack.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #2:");
                    travelersPack.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize burrito:");
                    travelersPack.add(customizeLeaf(input, "Burrito"));
                    myOrder = travelersPack;
                break;

                case 8:
                    Composite samplerPack = new Composite("Sampler pack");
                    System.out.println("Customize taco:");
                    samplerPack.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize burrito:");
                    samplerPack.add(customizeLeaf(input, "Burrito"));
                    System.out.println("Customize bowl:");
                    samplerPack.add(customizeLeaf(input, "Bowl"));
                    myOrder = samplerPack;
                break;

                case 9:
                    Composite partyPack = new Composite("Party pack");
                    Composite orderOfTacos1 = new Composite("First order of tacos");
                    System.out.println("Customization of first order of tacos:");
                    System.out.println("Customize taco #1:");
                    orderOfTacos1.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #2:");
                    orderOfTacos1.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #3:");
                    orderOfTacos1.add(customizeLeaf(input, "Taco"));

                    Composite orderOfTacos2 = new Composite("Second order of tacos");
                    System.out.println("Customization of second order of tacos:");
                    System.out.println("Customize taco #4:");
                    orderOfTacos2.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #5:");
                    orderOfTacos2.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #6:");
                    orderOfTacos2.add(customizeLeaf(input, "Taco"));

                    Composite orderOfTacos3 = new Composite("Third order of tacos");
                    System.out.println("Customization of third order of tacos:");
                    System.out.println("Customize taco #7:");
                    orderOfTacos3.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #8:");
                    orderOfTacos3.add(customizeLeaf(input, "Taco"));
                    System.out.println("Customize taco #9:");
                    orderOfTacos3.add(customizeLeaf(input, "Taco"));

                    partyPack.add(orderOfTacos1);
                    partyPack.add(orderOfTacos2);
                    partyPack.add(orderOfTacos3);

                    System.out.println("Customize burrito #1:");
                    partyPack.add(customizeLeaf(input, "Burrito"));
                    System.out.println("Customize burrito #2:");
                    partyPack.add(customizeLeaf(input, "Burrito"));
                    System.out.println("Customize bowl:");
                    partyPack.add(customizeLeaf(input, "Bowl"));

                    myOrder = partyPack;
                break;

                default:
                break;
            }
            if(myOrder != null){
                System.out.println("\nHere's your order:\n" + myOrder.getDescription());
                System.out.printf("Total cost: $%.2f\n", myOrder.getCost());

                System.out.println("Would you like to get some more food (Y/N)?");
                again = Character.toUpperCase(input.next().charAt(0));
            }
        }
        input.close();
        System.out.println("Thank you for eating with us! Take care and remember to practice to social distancing!");
    }
}