public class Taco extends Leaf{

    public Taco(String r, String m){
        super(r,m);
    }

    public String getDescription(){return "Taco with: " + "\n" + riceType + " rice\n" + meatType + "\n";}
    public double getCost(){return 2.50;}
}