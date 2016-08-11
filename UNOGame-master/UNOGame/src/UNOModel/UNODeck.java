/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UNOModel;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author e0000708
 */
public class UNODeck 
{
    
     private ArrayList<UNOCard> deck = new ArrayList<UNOCard>();

    public UNODeck() {
        addDeck();
    }

    public ArrayList<UNOCard> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<UNOCard> deck) {
        this.deck = deck;
    }
    
    public void setCardToDeck(UNOCard und){
        this.getDeck().add(und);
    }
    public UNOCard getCardFromDeck()
    {
        return this.getDeck().remove(0);
    }
    public void addDeck()
    {
        String Color[] = {"Red", "Yellow", "Green", "Blue", "RYGB"};
        String type[] = {"Normal","Skip","Reverse","Draw2","Wild", "WildDrawFour"};
        
        UNOCard ucard;
       
        
        for (int c=0 ; c<Color.length;c++)
        {
            int index =0 ;
         
        
        for(int i=0 ; i <=12 ;i++)
        {
            int value = i;
       
            if (i>9)
            {
                index++;
                value=20;
            }
        
            if (c!=4)
            {
                ucard = new UNOCard(Color[c],type[index],value,Color[c]+type[0]+value);
                this.setCardToDeck(ucard);
            
                if(i!=0)
                this.setCardToDeck(ucard);
            }
        }
            if(c==4)
            {
                int count = 1;
                while(count <=4)
                {
                    for(int j=4;j<type.length;j++)
                    {
                        ucard = new UNOCard(Color[c],type[j],50,Color[c]+type[j]+50);
                        this.setCardToDeck(ucard);
                    }
                    count ++ ;
                }

            }
        }
       
    }    

    
    public void ShuffleDeck(){
        Collections.shuffle(getDeck());
    }
    
    @Override
    public String toString() 
    {
       return "UNO Card on Deck: " + this.getDeck().size()+"\n"+deck;
    }  
        
}    
    
    

