package localhost.goga.artifactScripts;

import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ArtifactScriptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ArtifactScriptsApplication.class, args);
    Session session = new Session();
    session.getApi();
  }

  public static void hello() {
    System.out.println("hello");
  }

  private static class Session {
    private Dotenv dotenv = Dotenv.load();

    private String artifactsApi = Optional.ofNullable(
      dotenv.get("ARTIFACTS_API_KEY")
    ).orElse("ninja");

    public Session() {}

    public void getApi() {
      System.out.println("API KEY = " + artifactsApi);
    }
  }
}
