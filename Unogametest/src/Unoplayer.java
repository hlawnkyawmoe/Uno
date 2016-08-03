
import java.util.ArrayList;
import java.util.List;


public class Unoplayer {
    
    private int id;
    private String name;
    
    private List<Unocard> playerholds;
    
    public Unoplayer(int id,String name){
        this.id=id;
        this.name=name;
        this.playerholds=new ArrayList<Unocard>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unocard> getPlayerholds() {
        return playerholds;
    }

    public void setPlayerholds(List<Unocard> playerholds) {
        this.playerholds = playerholds;
    }
    
    public Unoplayer(String name, List<Unocard> playerholds){
        this.name=name;
        this.playerholds=playerholds;
    }
    
    public void Addtocard(Unocard card){
        
        this.playerholds.add(card);
    }
            
    public Unocard RemovefromHand(){
        if(this.playerholds.isEmpty()){
            return null;
        }
        
        return this.playerholds.remove(0);
    }

    @Override
    public String toString() {
        return  "id=" + id + ", name=" + name ;
    }
    
}
