public abstract class Leaf implements Component{
    protected String riceType, meatType;

    public Leaf(String r, String m){
        this.riceType = r;
        this.meatType = m;
    }
}