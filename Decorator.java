public abstract class Decorator implements Component{
    protected Component wrappee;
    protected int amount;
    public Decorator(Component c, int i){
       wrappee = c;
       amount = i;
    }
}