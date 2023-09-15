package com.example.trajethydiac3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trajethydiac3.bll.locationService.LocationServiceManager;
import com.example.trajethydiac3.bo.Trajet;
import com.example.trajethydiac3.dal.util.DatabaseHelper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper  databaseHelper;;
    private LocalDateTime startTime;
    private boolean isRecording = false;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 101;
    private LocationTrack locationTrack;

    private Trajet trajet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationServiceManager locationServiceManager = new LocationServiceManager(this);

        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);

        permissions.add(READ_EXTERNAL_STORAGE);
        permissions.add(WRITE_EXTERNAL_STORAGE);

        //DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        SQLiteDatabase db = databaseHelper.getWritableDatabase();


        permissionsToRequest = findUnAskedPermissions(permissions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (permissionsToRequest.size() > 0) {
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
            }
        }

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRecording) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        startTime = LocalDateTime.now();
                    }



                    locationServiceManager.requestLocationPermissions();

                    locationTrack = new LocationTrack(MainActivity.this);
                    isRecording = true;
                    btnStart.setVisibility(View.GONE);
                    btnStop.setVisibility(View.VISIBLE);
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isRecording) {
                    View overlayView = findViewById(R.id.overlayView);
                    double distanceParcourue = locationTrack.getTotalDistance();
                    double distanceParcourueKm = distanceParcourue / 1000;
                    TextView distanceTextView = findViewById(R.id.textView2);
                    distanceTextView.setText(String.format("%.2f", distanceParcourueKm) + " km");
                    distanceTextView.setVisibility(View.VISIBLE);

                    overlayView.setVisibility(View.VISIBLE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Enregistrer le trajet?");
                    builder.setMessage("Souhaitez-vous enregistrer ce trajet dans la base de données?");
                    builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            LocalDateTime dateEnd = LocalDateTime.now();
                            double distanceParcourue = locationTrack.getTotalDistance();
                            String type = "Pro";

                            trajet = new Trajet(startTime, dateEnd, distanceParcourue, type);

                            // Insérer le trajet dans la base de données
                            try {
                                databaseHelper.insertTrajet(trajet);
                                Toast.makeText(getApplicationContext(), "Trajet enregistré avec succès!", Toast.LENGTH_SHORT).show();

                            }catch(Exception e){
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), "Erreur lors de l'enregistrement du trajet.", Toast.LENGTH_SHORT).show();
                            }

                            overlayView.setVisibility(View.GONE);

                            dialogInterface.dismiss();
                        }
                    });
                    builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            overlayView.setVisibility(View.GONE);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Trajet non enregistré.",
                                    Toast.LENGTH_SHORT).show();

                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                locationTrack.stopListener();
                isRecording = false;
                btnStart.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.GONE);
            }

        });


    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<>();
        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }
        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case ALL_PERMISSIONS_RESULT:
                for (String perm : permissionsToRequest) {
                    if (!hasPermission(perm)) {
                        permissionsRejected.add(perm);
                    }
                }
                if (permissionsRejected.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                                String[] permissionsArray = permissionsToRequest.toArray(new String[permissionsToRequest.size()]);
                                                requestPermissions(permissionsArray, ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Fermeture de la base de données lorsque l'activité est détruite
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }



}
