import java.lang.reflect.Array;
import java.util.ArrayList;

public class Composite implements Component{

    private ArrayList<Component> children = new ArrayList<Component>();
    private String name;

    public Composite(String name){
        this.name = name;
    }

    public void add(Component c){children.add(c);}
    public void remove(Component c){children.remove(c);}
    public ArrayList<Component> getChildren(){return children;};

    public String getDescription(){
        String s = name + " consisting of: \n";
        for(int i = 0; i < children.size(); i++)
            s += children.get(i).getDescription();
        return s;
    }
    public double getCost(){
        double runningTotal = 0;
        for(int i = 0; i < children.size(); i++)
            runningTotal += children.get(i).getCost();
        return runningTotal;
    }
}