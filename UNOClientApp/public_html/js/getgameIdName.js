$(function(){

			$.ajax({
			    type: 'GET', 
			    url: 'http://localhost:8080/UNOServerApp/api/uno/NewGame', 
			    crossDomain: true,
			    dataType: 'text',
			    success: function(data) {
                              
//
			        var json = $.parseJSON(data);

                                    $('#GameId').val(json.GameId);
                                    $('#ShowGameID').append(json.GameId);
                                    $('#Gamename').append(json.GameName);
                                                                    
                                console.log(data);			        
			    }
			});
		});