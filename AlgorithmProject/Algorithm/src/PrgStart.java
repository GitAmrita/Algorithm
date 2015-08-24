import java.util.Random;
import java.util.UUID;

/**
 * Created by achowdhury on 6/30/2015.
 */
public class PrgStart {
    public static void main(String args[])
    {
       /* System.out.println("******************************ASSUMPTIONS*************************************");
        System.out.println("1.  WHEN THE GAME STARTS THE CIRCLE ALREADY CONTAINS 100 CUPS");
        System.out.println("2.  THE FIRST CUP PICKED IS ALWAYS 1 SO NOT TAKING THE USER INPUT");
        System.out.println("3.  CUPS CAN ONLY BE PICKED IN CLOCKWISE MANNER (MEANING 1,3,5,7,...)");
        System.out.println("*******************************************************************************");
        System.out.println("The game starts here .......................");
        PopSugar  r = new  PopSugar();
        r.StartGame();*/

        MightyBellProducer ds = new MightyBellProducer();
        ds.Start();
    }
}
