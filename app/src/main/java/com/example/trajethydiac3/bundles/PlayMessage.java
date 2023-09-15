package com.example.trajethydiac3.bundles;

import java.util.ResourceBundle;

public class PlayMessage {
    private static ResourceBundle rb;

    static {
        try {
            rb = ResourceBundle.getBundle("com.example.trajethydiac2.bundles.messages");
        } catch (Exception e) {
            e.printStackTrace();
        }

       /** public static String getMessageErreur(Integer code) {
            String message = "";

            try {
                if(rb != null) {
                    message = rb.getString(String.valueOf(code));
                } else {
                    message = "Problème lors de la lecture du fichier messages_erreur";
                }
            } catch (Exception e) {
                e.printStackTrace();
                message = "Erreur inconnue";
            }

            return message;
        }*/
    }
}
