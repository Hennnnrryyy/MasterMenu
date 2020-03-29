public class Taco extends Leaf{
    protected char placement;

    public Taco(String r, String m, char c){ // char used to determine if regular, outside, or stuffed
        super(r,m);
        placement = c;
    }

    public Taco (String r, String m){
        super(r,m);
    }

    public String getDescription(){return "\n" + (placement == 'r' ? "" : (placement == 'o' ? "Outside " : "Stuffed ")) + "Taco with: " + "\n" + riceType + " rice\n" + meatType + "\n";}
    public double getCost(){return 2.50;}
}