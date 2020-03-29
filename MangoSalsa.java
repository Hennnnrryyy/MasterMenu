public class MangoSalsa extends Decorator{
    public MangoSalsa(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding mango salsa...");
        else   
            System.out.println("Adding mango salsa x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Mango Salsa" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 1.00 * amount;
    }
}