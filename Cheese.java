public class Cheese extends Decorator{
    public Cheese(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding cheese...");
        else   
            System.out.println("Adding cheese x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Cheese" + ( (amount == 1 ? "" : " x" + amount) );
    }

    public double getCost(){
        return wrappee.getCost() + 0.50 * amount;
    }
}