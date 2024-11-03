import javax.swing.*;

public class splash {
    private static AudioPlayer audioPlayer = new AudioPlayer();
    public static void show()  {



        audioPlayer.playSound("C:/Users/fragu/IdeaProjects/Peras_manzanas/src/sound/intro.wav", true);


        // Cargar el GIF animado
        ImageIcon gif = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/splash.gif");
        JLabel etiquetaGIF = new JLabel(gif);


        JPanel panelGIF = new JPanel();
        panelGIF.add(etiquetaGIF);

        // Crear un array de opciones con texto y iconos
        Object[] options = {
                "<html><h4 style='color:green; '>Iniciar ✔\uFE0F</h4></html>",
                "<html><h4 style='color:red; '>Salir ❌</h4></html>"
        };

        ImageIcon game = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/p.gif");

        // Mostrar el JOptionPane con el panel del GIF
        int result = JOptionPane.showOptionDialog(
                null,
                panelGIF, // Muestra el panel con el GIF
                "Bienvenido",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options, // Botones con texto
                options[0] // Opción predeterminada
        );

        // Manejar la respuesta del usuario
        if (result == 0) {
            // Acción para "Iniciar"
            //JOptionPane.showMessageDialog(null, "Acción a definir en el futuro.
            Menu.principal();
        } else if (result == 1) {

            System.exit(0);
        }

    }

    public static void playAnotherSound(String ruta, boolean repite) {
        audioPlayer.stopSound();
        audioPlayer.playSound(ruta, repite);
    }
}
