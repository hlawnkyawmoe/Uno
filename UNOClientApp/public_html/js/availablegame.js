$(function(){

			$.ajax({
			    type: 'GET', 
			    url: 'http://localhost:8080/UNOServerApp/api/uno/availablegame', 
			    crossDomain: true,
			    dataType: 'text',
			    success: function(data) {

			        var json = $.parseJSON(data);
                                
			        for (var i=0; i<json.length; i++)
			        {					
					$('#gid').append('<option value="'+ json[i].GameId  + '">'+ json[i].GameName +' ('+json[i].GameId +')'+'</option>');
			        }
			    }

			});
		});