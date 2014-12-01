package com.example.georgicaracu.thehiddencampus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView passwordView = (TextView)findViewById(R.id.input_password_register);
                String password = String.valueOf(passwordView.getText());

                TextView passwordConfirmationView = (TextView)findViewById(R.id.input_register_password_confirmation);
                String passwordConfirmation = String.valueOf(passwordConfirmationView.getText());

                TextView usernameView = (TextView)findViewById(R.id.input_username_register);
                String username = String.valueOf(usernameView.getText());

                TextView usernameConfirmationView = (TextView)findViewById(R.id.input_register_confirm_username);
                String usernameConfirmation = String.valueOf(usernameConfirmationView.getText());

                TextView passwordError = (TextView)findViewById(R.id.passwordError);
                TextView userError = (TextView)findViewById(R.id.usernameError);

                boolean validPassword = false;
                boolean validUsername = false;

                if(password.equals(passwordConfirmation)) {
                    validPassword = true;
                }
                else {
                    passwordError.setVisibility(View.VISIBLE);
                }

                if(username.equals(usernameConfirmation)){
                    validUsername = true;
                }
                else {
                    userError.setVisibility(View.VISIBLE);
                }

                if(validPassword && validUsername){
                    Toast.makeText(getApplicationContext(), "Thank you for registering with us. A confirmation email will be sent to your email address.", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
