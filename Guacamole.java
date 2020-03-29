public class Guacamole extends Decorator{
    public Guacamole(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding guacamole...");
        else   
            System.out.println("Adding guacamole x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Guacamole" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 2.00 * amount;
    }
}