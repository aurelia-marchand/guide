package fr.prepavenir.guide;

import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import fr.prepavenir.guide.ui.home.HomeActivity;

/**
 * Created by aurel on 29/08/2017.
 */

public class AppActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                // TODO : fermer l'activity
                //finish();
                onBackPressed(); //méthode flèche de retour physique/virtuelle présente sur le téléphone
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verif si il y a une action bar pour afficher la flèche retour
        if(getSupportActionBar() != null) {
            // vérif si on n'est pas sur la page home, pour ne pas inciter à quitter l'appli
            if(!(this instanceof HomeActivity)) {
                //affichage flèche de retour
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

        }

    }
}
