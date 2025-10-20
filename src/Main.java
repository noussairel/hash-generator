import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args){


        SimpleLogger logger = SimpleLogger.getLogger(Main.class);

        String random = UUID.randomUUID().toString();
        while(true){
            logger.info(random);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                logger.error("Thread was interrupted");
                Thread.currentThread().interrupt();
            }
        }

    }
}
