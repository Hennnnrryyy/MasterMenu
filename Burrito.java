public class Burrito extends Leaf{

    public Burrito(String r, String m){
        super(r,m);
    }

    public String getDescription(){return "\nBurrito with: " + "\n" + riceType + " rice\n" + meatType + "\n";}
    public double getCost(){return 8;}
}