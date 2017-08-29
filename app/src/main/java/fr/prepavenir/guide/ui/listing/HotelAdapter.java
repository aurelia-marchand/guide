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
import fr.prepavenir.guide.models.Hotel;

/**
 * Created by aurel on 25/08/2017.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private int resId; // par défaut =0
    private LayoutInflater inflater; //par défaut = null

    public HotelAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);

        resId = resource; // récupération du layout R.layout.item_hotel
        inflater = LayoutInflater.from(context); // permet d'afficher le layout item_hotel
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder myViewHolder; //declaration de variable

        // affichage du layout item_hotel
        if(convertView == null) {
            convertView = inflater.inflate(resId, null);

            myViewHolder = new ViewHolder(); // instance de class

            myViewHolder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            myViewHolder.textViewEtoile = convertView.findViewById(R.id.textViewEtoile);
            myViewHolder.textViewCategory = convertView.findViewById(R.id.textViewCategory);

            convertView.setTag(myViewHolder); //enregistrer les propriétés Title et Category
        } else {
            myViewHolder = (ViewHolder) convertView.getTag(); // recupération des propriétés
        }

        // récupération d'un objet hotel par rapport à sa position
        Hotel item = getItem(position);

        myViewHolder.textViewTitle.setText(item.getName());
        myViewHolder.textViewEtoile.setText(String.format(getContext().getString(R.string.Listing_hotel_etoile), item.getEtoile()));
        myViewHolder.textViewCategory.setText(item.getCategory());

        return convertView;
    }

    class ViewHolder {
        TextView textViewTitle;
        TextView textViewEtoile;
        TextView textViewCategory;
    }
}
