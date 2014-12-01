package com.example.georgicaracu.thehiddencampus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ViewEvent extends ActionBarActivity {

    private static boolean savedEvent = false;
    private static boolean participatingEvent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        final Button btn_save = (Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(savedEvent){
                    showToast("Event removed from your list.");
                    btn_save.setText("Save");
                    savedEvent = false;
                }
                else {
                    showToast("Event saved to your list.");
                    btn_save.setText("Remove");
                    savedEvent = true;
                }
            }
        });

        final Button btn_participate = (Button)findViewById(R.id.btn_participate);
        btn_participate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(participatingEvent){
                    showToast("Not going.");
                    btn_participate.setText("Participate");
                    participatingEvent = false;
                }
                else {
                    showToast("Going to this event");
                    btn_participate.setText("Not participating.");
                    participatingEvent = true;
                }
            }
        });
    }

    private void showToast(CharSequence toastText){
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_event, menu);
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
