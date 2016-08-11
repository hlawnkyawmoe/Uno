
package sa42.team2.uno;


import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import UNOModel.UNOGame;
import UNOModel.UNOPlayer;
import UNOModel.UNOCard;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
/**
 *
 * @author Yamin
 */
@RequestScoped
@Path("/uno")
public class UNOGameServelet {
   public static Map<String,UNOGame> hashmap = new HashMap<String, UNOGame>();
   public static String CurrentGameID="";
   public static String CurrentPlayerID="";
   private final String localhostport = "http://10.10.24.124:8383";
    @POST
    @Path("/addgame")
    @Produces("text/plain")
    public Response AddGame(@FormParam("GameName") String gamename )
    {
        CurrentGameID = UUID.randomUUID().toString().substring(0,8);
        UNOGame game = new UNOGame(CurrentGameID,gamename,"waiting");
        hashmap.put(CurrentGameID,game);
        try{
            URI Location = new URI(localhostport+"/UNOClientApp/StartGame.html");
            return Response.seeOther(Location).build();
        }
        catch(URISyntaxException ex){
            return Response.status(404).entity("Fail").build();
        }
        
    }
    
    @GET
    @Path("/NewGame")
    @Produces("text/plain")
    public Response NewGame(){
        JsonObject jso ;
       

        UNOGame game = hashmap.get(CurrentGameID);
        
        jso = Json.createObjectBuilder()
            .add("GameId",game.getGameID())
            .add("GameName", game.getGameName())
            .add("Status", game.getStatus())
            .build();

        Response resp = Response.ok(jso.toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        return resp;
    }
    @GET
    @Path("/getplayer")
    @Produces("text/plain")
    public Response GetPlayer()
    {
        
       JsonObject Jobj;
        UNOGame game = hashmap.get(CurrentGameID);
        
        Jobj = Json.createObjectBuilder()
            .add("GameId",game.getGameID())
            .add("GameName",game.getGameName())
            .add("PlayerId",CurrentPlayerID)
            .build();

        Response resp = Response.ok(Jobj.toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        return resp;
    }
            
            
    @POST
    @Path("/WaitingPlayer")
    @Produces("text/plain")
    public Response startTablePlay(@FormParam("GameId") String gid){
        
        CurrentGameID = gid;
        
        
        UNOGame game = hashmap.get(CurrentGameID); 
        game.startPlay();
        
        try {
            URI location = new java.net.URI(localhostport+"/UNOClientApp/GameView.html");            
            return Response.seeOther(location).build();
        } catch (URISyntaxException ex) {
            return Response.status(404).entity("Redirect Fail").build();
        }
    }
    @GET
    @Path("/availablegame")
    @Produces("text/plain")
    public Response AvailableGameList(){
        JsonObject Jobj ;
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        Iterator entries = hashmap.entrySet().iterator();
        while (entries.hasNext()) {
          Map.Entry thisEntry = (Map.Entry) entries.next();
          Object key = thisEntry.getKey();
          Object value = thisEntry.getValue();
          
           Jobj = Json.createObjectBuilder()
            .add("GameId",thisEntry.getKey().toString())
            .add("GameName", ((UNOGame)thisEntry.getValue()).getGameName())
            .add("Status", ((UNOGame)thisEntry.getValue()).getStatus())
            .build();
           
           arrBuilder.add(Jobj);
        }
       
        Response resp = Response.ok(arrBuilder.build().toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        return resp;
    }
    
    @POST
    @Path("/joinplayer")
    @Produces("text/plain")
    public Response JoinPlayer(@FormParam("GameId") String gid, @FormParam("PlayerName") String pname){
        
        CurrentGameID = gid;
        String playerName = pname;
        String playerId = UUID.randomUUID().toString().substring(0,8);
        
        UNOPlayer player = new UNOPlayer(playerId, playerName);
        CurrentPlayerID = playerId;
        
        hashmap.get(CurrentGameID).addPlayer(player);
        System.out.println(">>>>>> Player List " + hashmap.get(CurrentGameID).getPlayerList().toString());
        try {
            URI location = new java.net.URI(localhostport+"/UNOClientApp/WaitingPlayer.html");            
            return Response.seeOther(location).build();
        } catch (URISyntaxException ex) {
            return Response.status(404).entity("Redirect Fail").build();
        }  
    }
    
    @POST
    @Path("/startgame")
    @Produces("text/plain")
    public Response startPlayerPlay(@FormParam("GameId") String gid, @FormParam("PlayerId") String pid){
        
        CurrentGameID = gid;
        CurrentPlayerID = pid;
          
          
        try {
            URI location = new java.net.URI(localhostport+"/UNOClientApp/PlayerView.html");            
            return Response.seeOther(location).build();
        } catch (URISyntaxException ex) {
            return Response.status(404).entity("Redirect Fail").build();
        }
    }
    
    
    @GET
    @Path("/playerlist")
    @Produces("text/plain")
    public Response listPlayer(){
        JsonObject Jobj ;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        
        UNOGame game = hashmap.get(CurrentGameID); 
                
        ArrayList<UNOPlayer> pList = game.getPlayerList();
        
        for (int i = 0; i < pList.size(); i++) {
            UNOPlayer player = pList.get(i);
            
            Jobj = Json.createObjectBuilder()
            .add("pid",player.getPlayerID())
            .add("name", player.getPlayerName())
            .add("status",game.getStatus())
            .build();
           
           arrayBuilder.add(Jobj);
            
        }
      
        Response resp = Response.ok(arrayBuilder.build().toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        return resp;
    }
    
    @GET
    @Path("/discardcard")
    @Produces("text/plain")
    public Response showTableCards(){
        JsonObject jso ;
        
        UNOGame game = hashmap.get(CurrentGameID);
        
        UNOCard card = game.getUnocard();
        
        jso = Json.createObjectBuilder()
            .add("gid",game.getGameID())
            .add("gname",game.getGameName())
            .add("color",card.getColor())
            .add("type", card.getType())
            .add("value",card.getScore())
            .add("image",card.getImage())
            .build();

        System.out.println("Show Card>>>>" + jso.toString());
        Response resp = Response.ok(jso.toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        return resp;
    }
    @GET
    @Path("/playcard")
    @Produces("text/plain")
    public Response showPlayerCards(){
        JsonObject jso ;
        JsonArrayBuilder jsa = Json.createArrayBuilder();
        UNOPlayer player=null;
        UNOGame game = hashmap.get(CurrentGameID);
        
        System.out.println("Show Player Current Game ID >>>>" + CurrentGameID);
        System.out.println("Show Player Current Player ID >>>>" + CurrentPlayerID);
        
        
        
        ArrayList<UNOPlayer> pList = game.getPlayerList();
        for (int i = 0; i < pList.size(); i++) {
            
            player = pList.get(i);
            if(player.getPlayerID().equals(CurrentPlayerID)){
                break;
            }
            else{
                player =null;
            }
            
        }
        
        ArrayList<UNOCard> cardinhand = player.getHoldCard();
        
        for (int i = 0; i < cardinhand.size(); i++) {
            UNOCard card = cardinhand.get(i);
            
            jso = Json.createObjectBuilder()
            .add("color",card.getColor())
            .add("type", card.getType())
            .add("value",card.getScore())
            .add("image",card.getImage())
            .build();

           jsa.add(jso);
            
        }

        Response resp = Response.ok(jsa.build().toString())
                .header("Access-Control-Allow-Origin", "*")
                .build();
        
        return resp;
    }
  
}
