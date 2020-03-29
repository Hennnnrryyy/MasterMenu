public abstract class Decorator implements Component{
    protected Component wrappee;
    protected int amount;
    public Decorator(Component c, int i){
       wrappee = c;
       amount = i;
    }

    public Decorator getSubject() {
        return this;
      }

    public void removeDecorator(Decorator toRemove) {
        if (wrappee == null) {
          return;
        } else if (wrappee.equals(toRemove)) {
            wrappee = getSubject();
        } else {
            this.removeDecorator(toRemove);
        }
      }
      
      
}