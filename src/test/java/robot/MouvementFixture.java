package robot;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RunWith(ConcordionRunner.class)
public class MouvementFixture {
    private Robot wallE = new Robot(0 , new Battery(), new RoadBookCalculator());

    public String resultatMouvement(String mouvement) throws InaccessibleCoordinate, UnlandedRobotException, InsufficientChargeException, LandSensorDefaillance {

       wallE.land(new Coordinates(2, 2), new LandSensor(new Random()));

        String result = "";

       switch(mouvement) {
           case "se déplace en avant":
               wallE.moveForward();
               if(wallE.getYposition()==1) result="avance d'une case vers le nord";
               break;
           case "se déplace en arrière":
               wallE.moveBackward();
               if(wallE.getYposition()==3) result="avance d'une case vers le sud";
               break;
           case "tourne dans le sens":
               wallE.turnRight();
               if(wallE.getDirection() == Direction.EAST) result="est orienté vers l'est";
               break;
           case "tourne dans le sens inverse":
               wallE.turnLeft();
               if(wallE.getDirection() == Direction.WEST) result="est orienté vers l'ouest";
               break;
           default:
               result = "KO";
           break;
       }
        return result;
    }
}
