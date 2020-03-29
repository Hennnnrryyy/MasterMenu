public class HotSauce extends Decorator{
    public HotSauce(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding hot sauce...");
        else   
            System.out.println("Adding hot sauce x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Hot sauce" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 0.05 * amount;
    }
}