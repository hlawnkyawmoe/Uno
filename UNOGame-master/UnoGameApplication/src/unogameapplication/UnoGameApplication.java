/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogameapplication;

import UNOModel.UNOGame;
import UNOModel.UNODeck;
import UNOModel.UNOPlayer;
import java.util.ArrayList;


public class UnoGameApplication {

    public static void main(String[] args) {
        
        UNOGame unogame;

        UNOPlayer p1 = new UNOPlayer("001", "Koe Koe");
        UNOPlayer p2 = new UNOPlayer("002", "Su");
        UNOPlayer p3 = new UNOPlayer("003", "Min Khant");
        UNOPlayer p4 = new UNOPlayer("004", "YaminAye");
        UNOPlayer p5 = new UNOPlayer("005", "De De");

        ArrayList<UNOPlayer> playerList = new ArrayList<UNOPlayer>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);

        String ID = "UNO-001";
        String Status = "Waiting";
        String GameName = "Team1";

        unogame = new UNOGame(ID, GameName, Status);
        
        unogame.setPlayerList(playerList);
        unogame.startPlay();
        UNODeck unodeck = new UNODeck();
        System.out.println(unogame);
    }

}
