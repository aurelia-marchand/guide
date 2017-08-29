package fr.prepavenir.guide.ui.listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.R;
import fr.prepavenir.guide.models.Hotel;
import fr.prepavenir.guide.models.Restaurant;
import fr.prepavenir.guide.ui.details.DetailsActivity;

public class ListingActivity extends AppActivity {

    // déclaration des propriétés
    private TextView textViewTitle;
    private GridView gridViewData;

    private List<Restaurant> restaurantList = new ArrayList<>();//initialise liste vide

    //création d'une liste vide d'hotels
    private List<Hotel> hotelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        gridViewData = (GridView) findViewById(R.id.listViewData);

        //vérifier si des données (Extras) ont été envoyées
        if (getIntent().getExtras() != null) {

            // récupération de la clé et sa valeur : true ou false
            boolean isRestaurant = getIntent().getExtras().getBoolean(("isRestaurant"));

            if (isRestaurant) { //true
                textViewTitle.setText(getString(R.string.Listing_title_restaurant));

                //ajout des resto
                restaurantList.add(new Restaurant("Le littoral", "Poissons", "littoral@gmail.com", "0236325212", "http://lito.com", "http://www.bsoft-team.com/articles/public/ImagesArticles2013/resto-le-littoral-facade.jpg"));
                restaurantList.add(new Restaurant("Sushi top", "Japonnais", "sushi@gmail.com", "0236326598", "http://sushi.com", "http://www.nautiljon.com/images/restaurants/00/37/1347182423679.jpg"));
                restaurantList.add(new Restaurant("Le bouchon", "Gastronomique", "bouchon@gmail.com", "0358452596", "http://bouchon.com", "https://www.thomaskeller.com/sites/default/files/styles/homepage_height_620px/public/media/franchises/interior_exterior_images/tk.com_byv_homepage_2.2a.new_.jpg?itok=Cm9JpVGM"));

                //gridViewData.setAdapter(new ArrayAdapter<Restaurant>(ListingActivity.this,
                //      R.layout.item_restaurant, restaurantList));

                gridViewData.setNumColumns(2);

                gridViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent myIntent = new Intent(ListingActivity.this, DetailsActivity.class);

                        // TODO : envoyer les informations
                        myIntent.putExtra("title", restaurantList.get(i).getName());
                        myIntent.putExtra("category", restaurantList.get(i).getCategorie());
                        myIntent.putExtra("email", restaurantList.get(i).getEmail());
                        myIntent.putExtra("url", restaurantList.get(i).getUrl());
                        myIntent.putExtra("phone", restaurantList.get(i).getPhone());
                        myIntent.putExtra("image", restaurantList.get(i).getImage());

                        //Pour déclencher l'ouverture de l'ecran détails
                        startActivity(myIntent);

                    }
                });
            } else { // false
                textViewTitle.setText(R.string.Listing_title_hotel);

                //ajout des hotels à la liste
                hotelList.add(new Hotel("Formule 1","Discount" , "0134670108", "formule1@gmail.com", "http://www.formule1.fr", "2", "http://aff.bstatic.com/images/hotel/org/210/2107237.jpg"));
                hotelList.add(new Hotel("Hotel première", "Discount","0952635214", "hpremiere@gmail.com", "http://www.premiere.fr", "1", "https://media.iceportal.com/44285/photos/1536699_M.jpg"));
                hotelList.add(new Hotel("Novotel", "Confortable","0205252854", "novotel@gmail.com", "http://www.novotel.fr", "4", "https://www.ahstatic.com/photos/5558_ho_00_p_1024x768.jpg"));
                hotelList.add(new Hotel("Alhambra", "Confortable", "0852416325", "alhambra@gmail.com", "http://www.alhambra.fr", "3", "https://s-ec.bstatic.com/images/hotel/max1024x768/514/51402272.jpg"));
                hotelList.add(new Hotel("Best Western", "Luxe", "0325251485", "bw@gmail.com", "http://www.bw.fr", "1", "https://media-cdn.tripadvisor.com/media/photo-s/01/e3/c2/f1/best-western-plus-austin.jpg"));

                gridViewData.setAdapter(new HotelAdapter(ListingActivity.this, R.layout.item_hotel, hotelList));

                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent myIntent = new Intent(ListingActivity.this, DetailsActivity.class);

                        myIntent.putExtra("title", hotelList.get(i).getName());
                        myIntent.putExtra("category", hotelList.get(i).getCategory());
                        myIntent.putExtra("etoile", hotelList.get(i).getEtoile());
                        myIntent.putExtra("email", hotelList.get(i).getEmail());
                        myIntent.putExtra("url", hotelList.get(i).getUrl());
                        myIntent.putExtra("phone", hotelList.get(i).getPhone());
                        myIntent.putExtra("image", hotelList.get(i).getImage());

                        startActivity(myIntent);
                    }
                });




            }
        }
    }
}
