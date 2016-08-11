$(function(){

			$.ajax({
			    type: 'GET', 
			    url: 'http://localhost:8080/UNOServerApp/api/uno/getplayer', 
			    crossDomain: true,
			    dataType: 'text',
			    success: function(data) {
                              
//
			        var json = $.parseJSON(data);
                                    $('#gamename').append("Waiting For "+json.GameName+" to start"); 
                                    $('#gameid').val(json.GameId);    
                                    $('#playerid').val(json.PlayerId); 
                                console.log(data);			        
			    }
			});
		});
