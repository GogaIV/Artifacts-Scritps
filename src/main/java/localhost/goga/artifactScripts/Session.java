package localhost.goga.artifactScripts;

import java.util.*;
import java.io.IOException;
import java.net.*;
import io.github.cdimascio.dotenv.Dotenv;

public class Session {
  private Dotenv dotenv = Dotenv.load();
  private URL url = null;

  private String apiKey = Optional.ofNullable(
    dotenv.get("ARTIFACTS_API_KEY")
  ).orElseThrow(() ->
    new IllegalStateException(
      "api key not found, cant access .env or api key missing"
    )
  );

  public Session() {}

  public void getApi() {
    System.out.println("API KEY = " + apiKey);
  }

  public void appLiving(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Hello, say hi back");
    String hello = scanner.nextLine();
    scanner.close();
  }

  public boolean establishConnection(){
    HttpURLConnection con = null;
    try {
      url = new URL("https://api.artifactsmmo.com/");
    } catch (MalformedURLException e){
      System.out.println(String.format("prolly sum 400 or sum \s", e));
    }
    try{
      con = (HttpURLConnection) url.openConnection();
    } catch (IOException e){
      System.out.println("The devil never lies");
    }
    try{
      con.setRequestMethod("GET");
    } catch (ProtocolException e){
      System.out.println("so many exceptions should i have this many???");
    }

    System.out.println(con);


    return false;
  }
}
