public class Bowl extends Leaf{

    public Bowl(String r, String m){
        super(r,m);
    }

    public String getDescription(){return "\nBowl with: " + "\n" + riceType + " rice\n" + meatType + "\n";}
    public double getCost(){return 7;}
}