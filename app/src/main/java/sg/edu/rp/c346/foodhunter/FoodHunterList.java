package sg.edu.rp.c346.foodhunter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 16/11/2016.
 */
public class FoodHunterList extends Activity {

    ListView lvFood;
    ImageView newImgSpecimenPhoto;
    Button btnAdd;

    ArrayList<Food> food = new ArrayList<>();
    FoodHunterListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodhunter_list);

        lvFood = (ListView)findViewById(R.id.listViewFood);
        newImgSpecimenPhoto = (ImageView) findViewById(R.id.imageViewPhotos);
        btnAdd = (Button)findViewById(R.id.btnAdd);

        adapter = new FoodHunterListAdapter(this, R.layout.foodhunter_listadapter, food);
        lvFood.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodHunterList.this, FoodHunterSubmit.class);
                startActivityForResult(i, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == RESULT_OK){
            if (data != null) {
                String foodname = data.getStringExtra("foodname");
                String foodlocation = data.getStringExtra("foodlocation");
                String fooddescription = data.getStringExtra("fooddescription");
                byte[] test = data.getByteArrayExtra("image");
                Bitmap bmp = BitmapFactory.decodeByteArray(test, 0, test.length);

                if(requestCode == 99){
                    food.add(new Food(foodname, foodlocation, fooddescription, bmp));
                    adapter.notifyDataSetChanged();
                }

            }
        }
    }
}
