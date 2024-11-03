import javax.swing.*;
//import java.util.HashMap;

public class Menu {


    //no me dejo usar hasmap
    public static void principal() {
        ImageIcon game = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/control.png");
        ImageIcon gif = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/splash.gif");

        String[] options = {"1 Nueva partida", "2 Continuar", "3 Configuración", "4 Tabla de posiciones", "5 Instrucciones", "6 Creditos", "<html><h4 style='color:red; '>7 Salir</h4></html>"};

        int eleccion = JOptionPane.showOptionDialog(null,
                gif,
                "Título del diálogo",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                game,
                options,
                options[0]);

        // Procesar la respuesta del usuario
        switch (eleccion) {
            case 0:
                System.out.println("Has seleccionado la opción 1");
                agregarUser();
                break;
            case 1:
                if(Main.nickName.trim().isEmpty()){
                    err.notSesion();
                }else {
                    Main.intentos++;
                    //llamar funcion de puntaje
                    Main.puntaje = Main.puntaje/8;
                    juego.play(false);
                }
                System.out.println("Has seleccionado la opción 2");
                break;
            case 2:
                System.out.println("Has seleccionado la opción 3");
                break;

            case 3:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/pos.wav", true);
                posiciones();
                break;

            case 4:
                ayuda();
                break;

            case 5:
                splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/pos.wav", true);
                credito();
                break;

            case 6:
                System.out.println("Has seleccionado la opción 7");
                break;
            default:
                System.out.println("Opción no válida");
                //System.exit(0); para el 7
        }
    }

    public static void ayuda() {

        ImageIcon libro = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/reglas.png");
        String[] opciones = {"1 Volver al menú principal", "<html><h4 style='color:red; '>2 Salir </h4></html>"};

        String mensaje = "<html><body>"
                + "<h1><b>Reglas del juego</b></h1><hr>"
                + "<p><h2> En cada partida, se generará un nuevo número aleatorio al azar.<br>"
                + "Este número estará formado por dígitos que van del 0 al 9,<br>"
                + "y no puede repetir dígitos. Tu misión será adivinar el número secreto.<br>"
                + "Para ello, te daremos pistas:<br><br>"
                + "<u>🍐 <b>Pera:</b></u> Significa que al menos uno de los dígitos que ingresaste coincide<br>" +
                "con el número secreto, pero no está en la posición correcta.<br><br>"
                + "<u>🍎 <b>Manzana:</b></u> Significa que alguno de los dígitos que ingresaste no solo coincide<br>" +
                "con el número secreto, sino que está colocado en la posición correcta.<br><br>"
                + "Ganarás la partida al conseguir tantas manzanas como el nivel<br>"
                + "del juego en el que te encuentres."
                + "</h2></p></body></html>";

        int respuesta = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Instrucciones del juego",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                libro,
                opciones,
                opciones[0]
        );

        // Procesar la respuesta
        if (respuesta == JOptionPane.YES_OPTION) {
            System.out.println("Se seleccionó la opción 1");
            principal();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.out.println("Se seleccionó la opción 2");
            System.exit(0);
        }

    }

    public static void credito() {

        ImageIcon center = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/center.png");
        ImageIcon qr = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/qrContact.png");

        String[] opciones = {"1 Volver al menú principal", "<html><h4 style='color:red; '>2 Salir </h4></html>"};

        int respuesta = JOptionPane.showOptionDialog(
                null,
                qr,
                "Medios de contacto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                center,
                opciones,
                opciones[0]
        );

        // Procesar la respuesta
        if (respuesta == JOptionPane.YES_OPTION) {
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);
            principal();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.out.println("Se seleccionó la opción 2");
            System.exit(0);
        }

    }

    public static void posiciones() {

        ImageIcon copa = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/high.png");
        ImageIcon qr = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/qrContact.png");

        String[] opciones = {"1 Volver al menú principal", "<html><h4 style='color:red; '>2 Salir </h4></html>"};

        int respuesta = JOptionPane.showOptionDialog(
                null,
                qr, // tabla
                "Medios de contacto",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                copa,
                opciones,
                opciones[0]
        );

        // Procesar la respuesta
        if (respuesta == JOptionPane.YES_OPTION) {
            splash.playAnotherSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);
            principal();
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

    }


    public static void agregarUser() {
        ImageIcon perfil = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/user.png");
        JTextField inputField = new JTextField();

        String[] options = {"1 Volver al menú principal", "2 Iniciar nueva partida", "<html><h4 style='color:red; '>2 Salir </h4></html>"};

        int option = JOptionPane.showOptionDialog(
                null,                 // Componente padre
                inputField,                          // Mensaje (campo de entrada en este caso)
                "Ingrese su nombre de usuario",                 // Título del cuadro de diálogo
                JOptionPane.DEFAULT_OPTION,          // Tipo de opción
                JOptionPane.PLAIN_MESSAGE,           // Tipo de mensaje
                perfil,                                // Icono
                options,                             // Opciones de los botones
                options[0]                           // Botón predeterminado
        );                                             // Valor inicial

        String nickName = inputField.getText();

        switch (option) {
            case 0:
                principal();
                break;
            case 1:
                if (nickName.trim().isEmpty()) {
                    err.notNull();
                }
                ;
                // verifica antes de ingresar un nuevo user
                if (Main.user.containsKey(nickName.trim())) {
                    err.userRepetido();
                } else {
                    Main.user.put(nickName.trim(), 0);
                    Main.nickName=nickName.trim();
                    Main.secreto = juego.codigosecreto(Main.level);
                    Main.puntaje=10000000;
                }
                //mostramos todos los user sy sus puntos
                for (String clave : Main.user.keySet()) {
                    System.out.println("Nombre: " + clave + ", Puntuacion: " + Main.user.get(clave));
                }

                juego.play(false);


                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Operación cancelada.");
                break;
        }
    }

    //Main.user
};

