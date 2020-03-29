public class MildSauce extends Decorator{
    public MildSauce(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding mild sauce...");
        else   
            System.out.println("Adding mild sauce x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Mild sauce" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 0.05 * amount;
    }
}