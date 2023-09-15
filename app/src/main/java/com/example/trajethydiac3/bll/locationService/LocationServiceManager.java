package com.example.trajethydiac3.bll.locationService;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class LocationServiceManager  {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 123;
    private Context context;

    public LocationServiceManager(Context context) {
        this.context = context;
    }

    public void requestLocationPermissions() {
        // Demandez les autorisations nécessaires ici, par exemple :
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Demandez l'autorisation à l'utilisateur
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }
        // Vous pouvez ajouter d'autres autorisations au besoin.
    }
}
