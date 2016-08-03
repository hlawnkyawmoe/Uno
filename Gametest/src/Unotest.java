import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Unotest {
    public static void main(String[] args) {
     //Unodeck testDeck = new Unodeck();  
     Unodeck testDeck = new Unodeck();
     testDeck = testDeck.createnewDeck();
        Unogame game;
        //testDeck.createnewDeck();
        
        
        Unoplayer p1 = new Unoplayer(001,"Hlawn");
       Unoplayer p2 = new Unoplayer(002, "Card Master");
        Unoplayer p3 = new Unoplayer(003, "God of Gambler");
        Unoplayer p4 = new Unoplayer(004, "John");
        Unoplayer p5 = new Unoplayer(005, "Steve");
        
        List<Unoplayer> playerList = new ArrayList<Unoplayer>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
       
        
        int gameId  = 001;
        String status = "Waiting";
        
        game = new Unogame(gameId, playerList, status, testDeck, testDeck.takecard());
        
       // game.startplay();
        
        //System.out.println(game);

    for (Unoplayer p : game.getPlayers()) {
            for (int i = 0; i < 7; i++) {
                p.Addtocard(game.getDeckofCard().takecard());
            }
        }

        System.out.println("run: ");
        System.out.println("Id: " + game.getId());
        System.out.println("Discard: card: " + game.getDiscardPile());
        System.out.println("Cards on deck: " + game.getDeckofCard().getNumberofcard());
        for (Unoplayer p : game.getPlayers()) {
            System.out.println("        Player:" + p);
            System.out.println("        Cards in hand:");
            for (Unocard c : p.getPlayerholds()) {
                System.out.println("                Card: " + c);
            }
            System.out.println();
        }
    }
   
}
