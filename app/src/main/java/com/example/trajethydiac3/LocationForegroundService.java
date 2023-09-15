package com.example.trajethydiac3;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.location.Location;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.example.trajethydiac3.R;

public class LocationForegroundService extends Service {
    private static final int NOTIFICATION_ID = 123; // Identifiant de la notification

    public LocationForegroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Mettez en place la gestion des mises à jour de localisation ici
        // Vous pouvez utiliser le code de gestion de la localisation ici

        // Démarrer le service en premier plan
        startForeground(NOTIFICATION_ID, buildNotification());

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Arrêtez la gestion des mises à jour de localisation si nécessaire
        // Arrêtez le service en premier plan
        stopForeground(true);
        stopSelf();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Méthode pour construire une notification de service en premier plan
    private Notification buildNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Créer un canal de notification pour les versions Android >= Oreo
            String channelId = "location_service_channel";
            String channelName = "Location Service Channel";
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Créer une notification pour le service en premier plan
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "location_service_channel")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Service de localisation en cours d'exécution")
                .setContentText("Suivi de la localisation en arrière-plan")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        return builder.build();
    }
}
