
import java.util.List;
import java.util.ArrayList;

public class Unogame {
    
    private int id;
    private List<Unoplayer> players;
    private String gameStatus;
    private Unodeck deckofCard;
    private Unocard discardPile;
    
    public Unogame(int id,List<Unoplayer> players,String gameStatus,Unodeck deckofCard,Unocard discardPile){
        
        this.id=id;
        this.players=players;
        this.gameStatus=gameStatus;
        this.deckofCard=deckofCard;
        this.discardPile=discardPile;
                
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Unoplayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Unoplayer> players) {
        this.players = players;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Unodeck getDeckofCard() {
        return deckofCard;
    }

    public void setDeckofCard(Unodeck deckofCard) {
        this.deckofCard = deckofCard;
    }

    public Unocard getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(Unocard discardPile) {
        this.discardPile = discardPile;
    }
    
    public void Addplayer(Unoplayer player){
        
        this.players.add(player);
    }
    
    public Unocard Takecardfromdeck(){
        
        return this.deckofCard.takecard();
    }
    
    public void discardPile(Unocard card){
        this.discardPile=card;
    }
    
    public Unocard takecardfromPile(){
        Unocard card=this.discardPile;
        this.discardPile=null;
        return card;
        
    }
    
    public void changegameStatus(String status){
        
        this.gameStatus=status;
    }
    
}
