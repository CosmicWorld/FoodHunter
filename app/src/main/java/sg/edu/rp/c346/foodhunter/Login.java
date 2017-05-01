package sg.edu.rp.c346.foodhunter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 15017381 on 9/11/2016.
 */
public class Login extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void onLoginClick(View v){
        if(v.getId() == R.id.buttonLogin){
            EditText etUsername = (EditText)findViewById(R.id.editTextUsername);
            String strUsername = etUsername.getText().toString();
            EditText etPassword = (EditText)findViewById(R.id.editTextPassword);
            String strPassword = etPassword.getText().toString();

            String password = helper.searchPass(strUsername);
            if(strPassword.equals(password)){
                Intent i = new Intent(Login.this, FoodHunterList.class);
                startActivity(i);
                Toast popup = Toast.makeText(Login.this, "Login successfully!", Toast.LENGTH_SHORT);
                popup.show();
            } else {
                Toast temp = Toast.makeText(Login.this, "Username or Password don't match! Please try again!", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    }
}
