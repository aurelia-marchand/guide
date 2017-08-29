package fr.prepavenir.guide.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.ui.home.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // transition vers l'écran d'accueil
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                // TODO : lancer l'ecran HomeActivity
                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(myIntent);
                //finish(); // Pour fermer l'activity ou android:noHistory="true" dans le Manifest
            }
        }, 2000);
    }
}
