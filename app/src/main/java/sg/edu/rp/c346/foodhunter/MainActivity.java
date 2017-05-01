package sg.edu.rp.c346.foodhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSignUp;
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = (Button)findViewById(R.id.buttonSignUp);
        btnLogIn = (Button)findViewById(R.id.buttonLogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.buttonSignUp){
                    Intent i = new Intent(MainActivity.this, SignUp.class);
                    startActivity(i);
                }
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.buttonLogIn) {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    startActivity(i);
                }
            }
        });
    }
}
