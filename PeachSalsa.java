public class PeachSalsa extends Decorator{
    public PeachSalsa(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding peach salsa...");
        else   
            System.out.println("Adding peach salsa x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Peach Salsa" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 1.00 * amount;
    }
}