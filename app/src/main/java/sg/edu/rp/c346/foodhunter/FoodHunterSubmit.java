package sg.edu.rp.c346.foodhunter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by 15017381 on 13/11/2016.
 */
public class FoodHunterSubmit extends Activity{
    EditText etName;
    EditText etLocation;
    EditText etDescription;
    Button btnSubmit, btnCapture;

    public static final int CAMERA_REQUEST = 10;
    ImageView imgSpecimenPhoto;
    Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodhunter_submit);

        etName = (EditText) findViewById(R.id.editTextName);
        etLocation = (EditText) findViewById(R.id.editTextLocation);
        etDescription = (EditText) findViewById(R.id.editTextDescription);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        btnCapture = (Button)findViewById(R.id.buttonCapture);
        imgSpecimenPhoto = (ImageView) findViewById(R.id.imageViewPhotos);

//        Intent i  = getIntent();
//        String name = i.getStringExtra("foodname");
//        String location = i.getStringExtra("foodlocation");
//        String description = i.getStringExtra("fooddescription");
//
//        etName.setText(name);
//        etLocation.setText(location);
//        etDescription.setText(description);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String foodname = etName.getText().toString();
                String foodlocation = etLocation.getText().toString();
                String fooddescription = etDescription.getText().toString();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                Intent i  = new Intent();
                i.putExtra("foodname", foodname);
                i.putExtra("foodlocation", foodlocation);
                i.putExtra("fooddescription", fooddescription);
                i.putExtra("image", byteArray);
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnCapture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,  CAMERA_REQUEST);
            }
        });

    }

//    public void onSubmitClick(View v){
//        if(v.getId() == R.id.buttonSubmit) {
//            String foodname = etName.getText().toString();
//            String foodlocation = etLocation.getText().toString();
//            String fooddescription = etDescription.getText().toString();
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte[] byteArray = stream.toByteArray();
//
//            Intent i  = new Intent();
//            i.putExtra("foodname", foodname);
//            i.putExtra("foodlocation", foodlocation);
//            i.putExtra("fooddescription", fooddescription);
//            i.putExtra("image",byteArray);
//            setResult(RESULT_OK, i);
//            finish();
//        }
//    }

//    public void btnTakePhotoClicked(View v){
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent,  CAMERA_REQUEST);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                bm = cameraImage;
                imgSpecimenPhoto.setImageBitmap(cameraImage);
            }
        }
    }
}
