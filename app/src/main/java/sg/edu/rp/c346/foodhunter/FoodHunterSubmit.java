package sg.edu.rp.c346.foodhunter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by 15017381 on 13/11/2016.
 */
public class FoodHunterSubmit extends Activity{
    EditText etName;
    EditText etLocation;
    EditText etDescription;
    Button btnSubmit;

    public static final int CAMERA_REQUEST = 10;
    private ImageView imgSpecimenPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodhunter_submit);

        etName = (EditText) findViewById(R.id.editTextName);
        etLocation = (EditText) findViewById(R.id.editTextLocation);
        etDescription = (EditText) findViewById(R.id.editTextDescription);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        imgSpecimenPhoto = (ImageView) findViewById(R.id.imageViewPhotos);

        Intent i  = getIntent();
        String name = i.getStringExtra("foodname");
        String location = i.getStringExtra("foodlocation");
        String description = i.getStringExtra("fooddescription");

        etName.setText(name);
        etLocation.setText(location);
        etDescription.setText(description);

    }

    public void onSubmitClick(View v){
        if(v.getId() == R.id.buttonSubmit) {
            String foodname = etName.getText().toString();
            String foodlocation = etLocation.getText().toString();
            String fooddescription = etDescription.getText().toString();
            Intent i  = new Intent();
            i.putExtra("foodname", foodname);
            i.putExtra("foodlocation", foodlocation);
            i.putExtra("fooddescription", fooddescription);
            setResult(RESULT_OK, i);
            finish();
        }
    }

    public void btnTakePhotoClicked(View v){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,  CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                imgSpecimenPhoto.setImageBitmap(cameraImage);
            }
        }
    }
}
