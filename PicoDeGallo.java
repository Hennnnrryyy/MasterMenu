public class PicoDeGallo extends Decorator{
    public PicoDeGallo(Component c, int i){
        super(c,i);
        if(i == 1)
            System.out.println("Adding pico de gallo...");
        else   
            System.out.println("Adding pico de gallo x" + i + "...");
    }

    public String getDescription(){
        return wrappee.getDescription() + "Pico de gallo" + ( (amount == 1 ? "" : " x" + amount) ) + "\n";
    }

    public double getCost(){
        return wrappee.getCost() + 0.20 * amount;
    }
}