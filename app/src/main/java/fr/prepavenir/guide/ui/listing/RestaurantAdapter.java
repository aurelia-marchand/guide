package fr.prepavenir.guide.ui.listing;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.models.Restaurant;

/**
 * Created by aurel on 24/08/2017.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{

    private int resId; // par défaut =0
    private LayoutInflater inflater; //par défaut = null

    public RestaurantAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        resId = resource; // récupération du layout R.layout.item_restaurant
        inflater = LayoutInflater.from(context); // permet d'afficher le layout item_restaurant
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) { //méthode de arrayAdapter appelé autant de foi qu'il y a de ligne

        ViewHolder myViewHolder; //declaration de variable

        // affichage du layout item_restaurant
        if(convertView == null) { //si ligne vide charge le template
            convertView = inflater.inflate(resId, null); //remplace le convertview via l'inflater (include dans php)

            // classe qui permet de mettre a jour le titre et la catégorie dynamiquement
            myViewHolder = new ViewHolder(); // instance de class

            myViewHolder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            myViewHolder.textViewCategory = convertView.findViewById(R.id.textViewCategory);

            //on stock la class view holder dans le convertView, setTag permet d'enregistrer un objet
            convertView.setTag(myViewHolder); //enregistrer les propriétés Title et Category
        } else {//a partir de la deuxieme ligne, on récupère uniquement ce qui est dans le setTag
            myViewHolder = (ViewHolder) convertView.getTag(); // recupération des propriétés
        }

        // récupération d'un objet restaurant par rapport à sa position
        Restaurant item = getItem(position);

        //mise à jour du titre et de la catégorie
        myViewHolder.textViewTitle.setText(item.getName());
        myViewHolder.textViewCategory.setText(item.getCategorie());


        return convertView;
    }

    class ViewHolder {
        TextView textViewTitle;
        TextView textViewCategory;
    }
}
