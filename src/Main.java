import java.util.HashMap;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static HashMap<String, Integer> user= new HashMap<>();
    public  static int level=3;
    public static String secreto="0";
    public static int peras=0;
    public static  int manzanas=0;
    public  static int puntaje=10000000;
    public  static int intentos=0;
    public static String nickName="";
    public static String ultimaEntrada="";
    public static boolean gano=false;
    //public static boolean[] contadas;



    public static void main(String[] args) {

        user.put("Franco", 5286);

        //Pruebas

        //int num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));

        //System.out.println(juego.codigosecreto(num));

        //sound.intro();

        splash.show();

        //System.out.println(splash.class.getResource("/img/splash.gif"));
        //System.out.println(splash.class.getResource("/sound/intro.wav"));
    }
}