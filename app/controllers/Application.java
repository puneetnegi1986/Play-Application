package controllers;

import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is not ready."));
    }
    
    
    public static Result add() {
    	final JsonNode json= request().body().asJson();
    	 System.out.println(" JSON: "+json);
    	
    	 final Promise<WS.Response> responsePromise = WS.url("http://localhost:8080/add").setQueryParameter("value1", json.get("data1").asText()).setQueryParameter("value2", json.get("data2").asText()).get();
         
         final Promise<String> bodyPromise = responsePromise.map(new Function<WS.Response, String>() {
             @Override
             public String apply(WS.Response response) throws Throwable {
                 final int statusCode = response.getStatus();
                 return response.getBody();
             }
         });
         return async(
                 bodyPromise.map(
                         new Function<String,Result>() {
                             public Result apply(String s) {
                                 return ok(s).as("text/html");
                             }
                         }
                 )
         );
    	 
    }
    
    public static Result sub() {
    	final JsonNode json= request().body().asJson();
   	 final Promise<WS.Response> responsePromise = WS.url("http://localhost:8080/sub").setQueryParameter("value1", json.get("data1").asText()).setQueryParameter("value2", json.get("data2").asText()).get();
     
     final Promise<String> bodyPromise = responsePromise.map(new Function<WS.Response, String>() {
         @Override
         public String apply(WS.Response response) throws Throwable {
             final int statusCode = response.getStatus();
             return response.getBody();
         }
     });
     return async(
             bodyPromise.map(
                     new Function<String,Result>() {
                         public Result apply(String s) {
                             return ok(s).as("text/html");
                         }
                     }
             )
     );
    }
    
    
    public static Result loadPart() {
  
   	 final Promise<WS.Response> responsePromise = WS.url("http://localhost:8080/loadPart").get();
     
     
   	 final Promise<String> bodyPromise = responsePromise.map(new Function<WS.Response, String>() {
         @Override
         public String apply(WS.Response response) throws Throwable {
           
             return response.getBody();
         }
     });
     return async(
             bodyPromise.map(
                     new Function<String,Result>() {
                         public Result apply(String s) {
                        	 System.out.println("Data:"+s);
                             return ok(s).as("text/html");
                            
                         }
                     }
             )
     );
    }
    
    
	public static Result savePart() {

		final JsonNode json = request().body().asJson().get("data1");
		System.out.println("Data1.... "+json.toString());
		final Promise<WS.Response> responsePromise = WS
				.url("http://localhost:8080/savePart")
				.setQueryParameter("data", json.toString()).get();
		final Promise<String> bodyPromise = responsePromise
				.map(new Function<WS.Response, String>() {
					@Override
					public String apply(WS.Response response) throws Throwable {

						return response.getBody();
					}
				});
		return async(bodyPromise.map(new Function<String, Result>() {
			public Result apply(String s) {
				System.out.println("Data:" + s);
				return ok(s).as("text/html");

			}
		}));
	}
 
}
