public class SourCream extends Decorator{
    public SourCream(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding sour cream...");
        else   
            System.out.println("Adding sour cream x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Sour Cream" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 0.50 * amount;
    }
}