package fr.prepavenir.guide.ui.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.ui.listing.ListingActivity;
import fr.prepavenir.guide.R;

public class HomeActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showRestaurant(View view) {
        //créer la redirection de homeActivity vers listingActivity
        Intent intentRestaurant = new Intent(HomeActivity.this, ListingActivity.class);

        //passage de paramètre, ici isrestaurant (boolean)
        intentRestaurant.putExtra("isRestaurant", true);

        startActivity(intentRestaurant);// déclenche l'ouverture de la page (activity)
    }

    public void showHotel(View view) {

        Intent intentHotel = new Intent(HomeActivity.this, ListingActivity.class);

        intentHotel.putExtra("isRestaurant", false);

        startActivity(intentHotel);
    }
}
