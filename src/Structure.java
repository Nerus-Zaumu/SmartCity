import java.util.ArrayList;

public class Structure {
    String name;
    String town;
    int eval;
    int recommendVal;
    int availableLodges;
    public Structure(String name, String town, int eval, int recommendVal, int availableLodges){
        this.name = name;
        this.town = town;
        this.eval = eval;
        this.recommendVal = recommendVal;
        this.availableLodges = availableLodges;
    }
    public Structure(){
        this("", "", 0, 0, 0);
    }

    static ArrayList<Structure> hotels = new ArrayList<>();
    
}
