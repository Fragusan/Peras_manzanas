import javax.swing.*;

public class err {

    public static  void userRepetido(){
        ImageIcon alert = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/alert.png");

        String[] btn = {"Aceptar"};

        int option = JOptionPane.showOptionDialog(
                null,                                // Componente padre
                "No puedes usar este nombre.\nUsuario ya en uso", // Mensaje (String)
                "Advertencia",                       // Título del cuadro de diálogo
                JOptionPane.DEFAULT_OPTION,          // Tipo de opción
                JOptionPane.PLAIN_MESSAGE,           // Tipo de mensaje
                alert,                  // Icono personalizado
                btn,                            // Botón personalizado
                btn[0]                          // Botón predeterminado
        );

        if (option == 0) {
            Menu.agregarUser();
        }

    }

    public static  void notNull() {
        ImageIcon alert = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/alert.png");

        String[] btn = {"Entendido"};

        int option = JOptionPane.showOptionDialog(
                null,                                // Componente padre
                "El nombre de usuario no\npuede quedar en blanco", // Mensaje (String)
                "Advertencia",                       // Título del cuadro de diálogo
                JOptionPane.DEFAULT_OPTION,          // Tipo de opción
                JOptionPane.PLAIN_MESSAGE,           // Tipo de mensaje
                alert,                  // Icono personalizado
                btn,                            // Botón personalizado
                btn[0]                          // Botón predeterminado
        );

        if(option == 0){
            Menu.agregarUser();
        }
    }

    public static  void notSesion() {
        ImageIcon alert = new ImageIcon("C:/Users/fragu/IdeaProjects/Peras_manzanas/out/production/Peras_manzanas/img/none.png");

        String[] btn = {"Entendido"};

        int option = JOptionPane.showOptionDialog(
                null,                                // Componente padre
                "No se encontro una sesión previa.", // Mensaje (String)
                "Advertencia",                       // Título del cuadro de diálogo
                JOptionPane.DEFAULT_OPTION,          // Tipo de opción
                JOptionPane.PLAIN_MESSAGE,           // Tipo de mensaje
                alert,                  // Icono personalizado
                btn,                            // Botón personalizado
                btn[0]                          // Botón predeterminado
        );

        if(option == 0){
            Menu.agregarUser();
        }
    }

}
