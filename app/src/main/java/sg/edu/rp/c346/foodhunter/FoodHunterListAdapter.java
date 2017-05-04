package sg.edu.rp.c346.foodhunter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15017381 on 16/11/2016.
 */
public class FoodHunterListAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Food> foodList;

    public FoodHunterListAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        foodList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Food foodItem = foodList.get(position);
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.foodhunter_listadapter, parent, false);

        TextView tvName = (TextView)rowView.findViewById(R.id.textViewNewName);
        TextView tvLocation = (TextView)rowView.findViewById(R.id.textViewNewLocation);
        TextView tvDescription = (TextView)rowView.findViewById(R.id.textViewNewDescription);
        ImageView image = (ImageView) rowView.findViewById(R.id.imageViewNewImage);

        tvName.setText(foodItem.getName());
        tvLocation.setText(foodItem.getLocation());
        tvDescription.setText(foodItem.getDescription());
        image.setImageBitmap(Bitmap.createScaledBitmap(foodItem.getImg(), 720, 480, false));
//        image.setImageBitmap(foodItem.getImg());

        return rowView;
    }
}
