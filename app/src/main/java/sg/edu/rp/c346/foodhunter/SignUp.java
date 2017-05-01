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
public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v){
        if(v.getId() == R.id.buttonSignUp){
            EditText name = (EditText)findViewById(R.id.editTextName);
            EditText email = (EditText)findViewById(R.id.editTextEmail);
            EditText username = (EditText)findViewById(R.id.editTextUsername);
            EditText password = (EditText)findViewById(R.id.editTextPassword);
            EditText confirmpassword = (EditText)findViewById(R.id.editTextConfirmPassword);

            String strname = name.getText().toString();
            String stremail = email.getText().toString();
            String strusername = username.getText().toString();
            String strpassword = password.getText().toString();
            String strconfirmpassword = confirmpassword.getText().toString();

            if(!strpassword.equals(strconfirmpassword)) {
                Toast popup = Toast.makeText(SignUp.this, "Password don't match! Please try again!", Toast.LENGTH_SHORT);
                popup.show();
            } else {
                //Insert the details in database
                UsersInformation u = new UsersInformation();
                u.setName(strname);
                u.setEmail(stremail);
                u.setUsername(strusername);
                u.setPassword(strpassword);

                helper.insertUsersInformation(u);

                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);
                Toast popup = Toast.makeText(SignUp.this, "Sign up successfully!", Toast.LENGTH_SHORT);
                popup.show();
            }
        }
    }
}
