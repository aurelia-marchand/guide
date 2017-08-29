package fr.prepavenir.guide.ui.details;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.R;

public class DetailsActivity extends AppActivity {

    private ImageView imageViewPhoto;
    private TextView textViewTitle, textViewCategory, textViewEtoile;
    private Button buttonPhone, buttonEmail, buttonUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        textViewEtoile = (TextView) findViewById(R.id.textViewEtoile);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonUrl = (Button) findViewById(R.id.buttonUrl);

        //récupération des données
        if (getIntent().getExtras() != null) {

            String title = getIntent().getExtras().getString("title");
            String category = getIntent().getExtras().getString("category");
            String phone = getIntent().getExtras().getString("phone");
            String email = getIntent().getExtras().getString("email");
            String url = getIntent().getExtras().getString("url");
            String image = getIntent().getExtras().getString("image");
            String etoile = getIntent().getExtras().getString("etoile");

            textViewTitle.setText(title); //afficher le titre
            textViewCategory.setText(category); //afficher la catégorie
            buttonPhone.setText(phone); //afficher le téléphone
            buttonEmail.setText(email); //afficher le mail
            buttonUrl.setText(url); //afficher l'url

            //nbr etoiles pour les hotels
            if(etoile != null) {
                textViewEtoile.setVisibility(View.VISIBLE); //rend visible quand hotel
                textViewEtoile.setText(String.format(getString(R.string.Listing_hotel_etoile), etoile));

            } else {
                textViewEtoile.setVisibility(View.GONE); //rend invisible quand restaurants
            }


            // TODO : affichage de l'image
            Picasso.with(DetailsActivity.this)
                    .load(image)
                    .into(imageViewPhoto);
        }

        //Rajout d'évènements sur les boutons pour créer les actions vers email, url ou phone
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setType("message/rfc822"); // filtre application messagerie

                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Le sujet du message");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Le corps du message");

                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{buttonEmail.getText().toString(), "mathieu.masset@vivaneo.fr"}); // destinataire
                intentEmail.putExtra(Intent.EXTRA_CC, new String[]{"email1@ddd..com", "email2@fdff.com"}); // email en copie

                startActivity(intentEmail);//Lancement
            }
        });

        buttonPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPhone = new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:" + buttonPhone.getText().toString()));
                startActivity(intentPhone);
            }
        });
        buttonUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirection vers une page web
                Intent intentWeb = new Intent(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse(buttonUrl.getText().toString()));
                startActivity(intentWeb);//lancement
            }
        });
    }
}
