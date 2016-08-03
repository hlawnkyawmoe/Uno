
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Unodeck {
    
    private int numberofcard;
    private List<Unocard> desk;
    
    public Unodeck(int numberofcard,List<Unocard> desk){
        this.numberofcard=numberofcard;
        this.desk=desk;
    }
    public Unodeck(){
    }

    public int getNumberofcard() {
        return numberofcard;
    }

    public void setNumberofcard(int numberofcard) {
        this.numberofcard = numberofcard;
    }

    public List<Unocard> getDesk() {
        return desk;
    }

    public void setDesk(List<Unocard> desk) {
        this.desk = desk;
    }
    
    public Unocard takecard()
    {
        if(this.desk.isEmpty()){
            return null;
        }
        this.numberofcard--;
        return this.desk.remove(0);
    }
    
    public Unodeck createnewDeck(){
        
          String color[] = {"Red","Yellow", "Green", "Blue"};
          String image[][] = {
            {"RED_0", "RED_1", "RED_2", "RED_3", "RED_4", "RED_5", "RED_6", "RED_7", "RED_8", "RED_9", "RED_SKIP", "RED_REVERSE", "RED_DRAWTWO"},
            {"YELLOW_0", "YELLOW_1", "YELLOW_2", "YELLOW_3", "YELLOW_4", "YELLOW_5", "YELLOW_6", "YELLOW_7", "YELLOW_8", "YELLOW_9", "YELLOW_SKIP", "YELLOW_REVERSE", "YELLOW_DRAWTWO"},
            {"BLUE_0", "BLUE_1", "BLUE_2", "BLUE_3", "BLUE_4","BLUE_5","BLUE_6","BLUE_7","BLUE_8","BLUE_9","BLUE_SKIP","BLUE_REVERSE","BLUE_DRAWTWO"},
            {"GREEN_0","GREEN_1","GREEN_2","GREEN_3","GREEN_4","GREEN_5","GREEN_6","GREEN_7","GREEN_8","GREEN_9","GREEN_SKIP","GREEN_REVERSE","GREEN_DRAWTWO"}};
        String type[] = {"Normal","Skip","Reverse", "Draw2"};
        
        Unocard cards; 
        Unocard newcards;
        Unodeck decks = new Unodeck();
        List<Unocard> cardList = new ArrayList<Unocard>();
        
       for (int c = 0; c < 4; c++) {
            for (int j = 0; j < 13; j++) {
                if (j < 9) {
                    if (j == 0) {
                        cards = new Unocard(color[c], type[0], j, image[c][j]);
                        cardList.add(cards);
                    } else {
                        for (int k = 0; k < 2; k++) {
                            cards = new Unocard(color[c], type[0], j, image[c][j]);
                            cardList.add(cards);
                        }
                    }
                } else {
                    for (int k = 0; k < 2; k++) {
                        cards = new Unocard(color[c], type[j % 9], 20, image[c][j]);
                        cardList.add(cards);
                    }
                }
            }
            cards = new Unocard("WILD", "DRAW_4", 50, "WILDCARD");
            newcards = new Unocard("WILD","DRAW_4", 50,"DRWAFOUR");
            cardList.add(cards);
            cardList.add(newcards);
        }
        Collections.shuffle(cardList);
        Unodeck deck = new Unodeck(108, cardList);
        System.out.println("The Card Finished");
        return deck;
    }
    
}
