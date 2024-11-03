import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;

public class juego {

    public static String codigosecreto(int n){
        Random rand = new Random();
        HashSet<Integer> numeros = new HashSet<>();
        StringBuilder codigo = new StringBuilder();
        while (codigo.length() < n) {
            int digit = rand.nextInt(10); // Genera un número entre 0 y 9
            if (!numeros.contains(digit)) {
                numeros.add(digit);
                codigo.append(digit);
            }
        } return codigo.toString();
    }

    public static void play(boolean jugando){
        //setea sonido con bandera
        if(Main.gano){
            jugando=true;
        }

        if(jugando ) {
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/oldUser.wav", true);
        } else {
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);
        }

        //limita la entrada de texto
        JTextField entrada = new JTextField(Main.level){
            //sobre escribe el metodo para controlar limitando el campo de entrada
            @Override
            public void processKeyEvent(KeyEvent ev){
                if (getText().length() >= Main.level) {
                    ev.consume();
                } else {
                    super.processKeyEvent(ev);
                }
            };

        };

        //intenta cambiar el tamaño de input field
        entrada.setPreferredSize(new Dimension(200, 30));

        JPanel panel = new JPanel();

        //cambia la imagen segun el intento
        ImageIcon img;
        if (Main.manzanas >0) {
            //pera
            img = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/apple.png");
        } else if (Main.peras >0) {
            //manzana
            img = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/pera.png");
        } else {
            //none
            img = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/none.png");
        }

        String[] opciones= { "1 Volver al menú principal", "2 Ingresar nuevo intento", "3 Rendirse", "<html><h4 style='color:red; '>4 Salir </h4></html>"};

        String mensaje = "<html><body>"
                + "<h1><b>Puntaje : " + Main.puntaje+ "<br>Intento Número "+ Main.intentos +"<br>"
                + (Main.ultimaEntrada.isBlank()? "" : "Ultimo ingreso: "+ Main.ultimaEntrada +".")
                +"</b></h1><hr>"
                + "<p><h2> Debes adivinar un número de "+ Main.level +" cifras.<br>"
                + "Los Digitos no se repiten<br>"
                + "Tienes intentos ilimitados, pero con cada<br>"
                + "nuevo intento disminuye tu puntaje<br>"
                + "<br>"
                + "<u>🍐 <b>Per"+ (Main.peras >1 ? "as" : "a") +":</b></u> "+ Main.peras +"<br>" +
                "<br>"
                + "<u>🍎 <b>Manzan" + (Main.manzanas > 1 ? "as" : "a") + ":</b></u> "+ Main.manzanas +"<br>" +
                "<br>"
                + "<br>"
                + "Intenta adivinar: "
                + "</h2></p></body></html>";



        panel.add(entrada);
        //panel.setPreferredSize(new Dimension(250, 100));

        int ventana = JOptionPane.showOptionDialog(
                null, // Componente padre
                new Object[] {mensaje, panel}, // Mensaje y panel combinado
                " "+ Main.nickName+" estás jugando en el nivel "+ Main.level +".", // Título del cuadro de diálogo
                JOptionPane.YES_NO_OPTION, // Tipo de opción
                JOptionPane.PLAIN_MESSAGE, // Tipo de mensaje
                img, // Icono personalizado (null si no hay)
                opciones, // Botones personalizados
                opciones[0] // Botón predeterminado
        );

        Main.ultimaEntrada=entrada.getText();

        switch (ventana){
            case 0:
                Menu.principal();
                break;
            case 1:
                //ingresa un intento
                if(Main.ultimaEntrada.equals(Main.secreto) ){
                    ganaste();
                }
                estadoInicial(false);
                Main.manzanas= hayManzanas(entrada.getText());
                Main.peras=hayPeras(entrada.getText());
                Main.puntaje= Main.puntaje -(2605);
                System.out.println(entrada.getText());
                System.out.println("El código secreto es: ");
                System.out.println(Main.secreto);
                Main.intentos++;
                play(false);
                break;
            case 2:
                //rendirse
                rendirse();
                //Mostrar el codigo
                //ganaste();
                System.out.println(Main.secreto);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Operación cancelada.");
                break;
        }

    }

    public static int hayManzanas(String entrada){

        int manzanas=0;
        for (int i = 0; i < Main.level-1; i++) {
            if(entrada.charAt(i) == Main.secreto.charAt(i)){
                manzanas++;
            }
        }
        System.out.println("Manzanas:");
        System.out.println(manzanas);
        if(manzanas>0){
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/manzana.wav", false);
        }
        return  manzanas;
    }

    public static  int hayPeras(String entrada){
        int peras=0;
        for (int i = 0; i < Main.level-1; i++) {
            if(entrada.charAt(i) != Main.secreto.charAt(i) &&
                Main.secreto.contains(String.valueOf(entrada.charAt(i)))){
                boolean yaEnManzana = entrada.charAt(i) == Main.secreto.charAt(i);
                if(!yaEnManzana) {
                    peras++;
                }
            }
        }
        System.out.println("Peras:");
        System.out.println(peras);
        if(peras>0){
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/pera.wav", false);
        }
        return peras;
    }

    public static void ganaste(){
        splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/winner.wav", false);
        Main.gano=true;

        ImageIcon winner = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/winner.png");

        String[] opciones = {"1 Volver al menú principal", "2 Jugar de nuevo","3 Jugar en nivel "+(Main.level + 1),  "<html><h4 style='color:red; '>4 Salir </h4></html>"};

        String msj="<html><body>"
                +"<h1><b>¡FELICITACIONES " + Main.nickName + "!<br>"
                +" Ganaste el nivel " + Main.level
                +"</b></h1><h3>"
                + (Main.intentos < 2 ? "Eso fue suerte, prueba de nuevo."
                : "Despues de "+Main.intentos + " intentos." )
                +"<br>"
                +"El número secreto era: <b>" + Main.secreto
                +"</b></h3></body></html>";

        int respuesta = JOptionPane.showOptionDialog(
                null,
                msj,
                Main.nickName + " ganaste el nivel " + Main.level,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                winner,
                opciones,
                opciones[0]
        );

        switch (respuesta){
            case 0:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);
                Menu.principal();
                break;
            case 1:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/retry.wav", false);
                Main.secreto = juego.codigosecreto(Main.level);
                Main.puntaje=Main.puntaje + 12500;
                estadoInicial(true);
                juego.play(true);
                break;
            case 2:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/lvlup.wav", false);
                Main.level++;
                Main.secreto= juego.codigosecreto(Main.level);
                Main.puntaje= Main.puntaje + 1428571;
                estadoInicial(true);
                juego.play(true);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }

    }

    public static void rendirse(){
        splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/lose.wav", false);

        ImageIcon game = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/game.png");

        String[] opciones = {"1 Volver al menú principal", "2 Volver al juego",  "<html><h4 style='color:red; '>3 Salir </h4></html>"};

        String msj="<html><body>"
                +"<h1><b>¿Abandonarás la partida " + Main.nickName + "?<br>"
                +"Tú puedes con el nivel " + Main.level
                +"</b></h1><h3>"
                +"<br>"
                +"El número secreto era: <b>" + Main.secreto
                +"</b></h3></body></html>";

        int respuesta = JOptionPane.showOptionDialog(
                null,
                msj,
                Main.nickName + " estás por salir del juego en curso ",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                game,
                opciones,
                opciones[0]
        );

        switch (respuesta){
            case 0:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);
                Main.secreto= codigosecreto(Main.level);
                Main.puntaje=10000000;
                Main.intentos=0;
                Menu.principal();
                break;
            case 1:
                Main.intentos++;
                //llamar funcion de puntaje
                Main.puntaje = Main.puntaje/200;
                juego.play(false);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                break;
        }

    }

    public static void estadoInicial(boolean todo){
        Main.peras=0;
        Main.manzanas=0;
        if(todo) {
            Main.intentos = 0;
            Main.ultimaEntrada = "";
        }
    }

}
