package com.angelo.locateme.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.angelo.locateme.R;
import com.angelo.locateme.model.Devslopes;

/**
 * Created by crumali on 6/30/2017.
 */

public class LocationsViewHolder  extends RecyclerView.ViewHolder {

    private TextView location_title,location_address;
    private ImageView location_image;

    public LocationsViewHolder(View itemView) {
        super(itemView);

        location_image = (ImageView)itemView.findViewById(R.id.location_image);
        location_title = (TextView)itemView.findViewById(R.id.location_title);
        location_address = (TextView)itemView.findViewById(R.id.location_address);



    }

    public void updateUI(Devslopes location){
      String uri = location.getImgURL();
      int resource = location_image.getResources().getIdentifier(uri,null,location_image.getContext().getPackageName());
      location_image.setImageResource(resource);
      location_title.setText(location.getLocationTitle());
      location_address.setText(location.getLocationAddress());
    }

}
