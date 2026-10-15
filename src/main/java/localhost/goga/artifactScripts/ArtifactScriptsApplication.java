package localhost.goga.artifactScripts;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ArtifactScriptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ArtifactScriptsApplication.class, args);
    Session session = new Session();
    session.getApi();
    session.requestUserData();
  }

  public static void hello() {
    System.out.println("hello");
  }

  private static class Session {

    private Dotenv dotenv = Dotenv.load();

    private String artifactsApi = Optional.ofNullable(
      dotenv.get("ARTIFACTS_API_KEY")
    ).orElseThrow(() ->
      new IllegalStateException(
        "api key not found, cant access .env or api key missing"
      )
    );

    public Session() {}

    public void getApi() {
      System.out.println("API KEY = " + artifactsApi);
    }

    public void requestUserData(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Hello, say hi back");
      String hello = scanner.nextLine();
      scanner.close();
    }
  }
}
