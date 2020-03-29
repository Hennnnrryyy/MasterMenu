public class Lettuce extends Decorator{
    public Lettuce(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding lettuce...");
        else   
            System.out.println("Adding lettuce x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Lettuce" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 0.10 * amount;
    }
}