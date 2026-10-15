package localhost.goga.artifactScripts;

// External packages
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Local classes (Do I not need to import this???)
// import localhost.goga.artifactScripts.Session;

@SpringBootApplication
public class ArtifactScriptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ArtifactScriptsApplication.class, args);
    Session session = new Session();
    session.getApi();
    session.appLiving();
  }

  public static void hello() {
    System.out.println("hello");
  }
}
