package com.bieitosousa.primenumberscalculator;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
/*   =            =      Texto      =
            [https://developer.android.com/guide/topics/resources/string-resource?hl=es#java]
                #   En Java: R.string.string_name
                        -----------------------------------------------
                        String string = getString(R.string.hello);
                        -----------------------------------------------
                #   En XML:@string/string_name
     =            =     Color     =
               deprecate --> [https://developer.android.com/guide/topics/resources/more-resources#Color]
               actual --> [https://stackoverflow.com/questions/31590714/getcolorint-id-deprecated-on-android-6-0-marshmallow-api-23]
                #   En Java: R.color.color_name
                     --------------------------------------------------
                        Resources res = getResources();
                        //  int color = res.getColor(R.color.opaque_red);
                        // getColor deprecate [int color = res.(R.color.opaque_red);]


                       ContextCompat.getColor(this, R.color.orange_primary)
                    ----------------------------------------------------
                #  En XML: @[package:]color/color_name
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Resources res = getResources(); // to access res/ to  take color and other
            // init main activity
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // take inputs
            String preRequest = getString(R.string.preRequest);
            String postRequest = getString(R.string.postRequest);
            final TextView textView_header = (TextView) findViewById(R.id.textView_header);
            final TextView textView_description = (TextView) findViewById(R.id.textView_description);
            final EditText editText_int_Input = (EditText) findViewById(R.id.editText_int_Input);
            final Button button_action_calculate = (Button) findViewById(R.id.button_action_calculate);
            final TextView textView_request_action = (TextView) findViewById(R.id.textView_request_action);
            // set atributes for the inputs
            button_action_calculate.setText(getString(R.string.button_action_calculate_text));
            button_action_calculate.setTextColor(ContextCompat.getColor(this, R.color.white));
            button_action_calculate.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_primary));
            textView_header.setText(getString(R.string.header));
            textView_header.setTextColor(ContextCompat.getColor(this, R.color.orange_primary));
            textView_description.setText(getString(R.string.description));
            // take atributes for the inputs
            String inputNumberString =  editText_int_Input.getText().toString(); // input in type String
            int inputNumberInt = Integer.parseInt(inputNumberString);
            final String finalRequest = preRequest + inputNumberInt + postRequest ;
            // Events --> On
            button_action_calculate.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // calculate outputs
                   int numberRequest = PrimeCalculator.numberOfPrimoInt(inputNumberInt);
                    // request ouputs
                    textView_request_action.setText(finalRequest + numberRequest);
                }
            });
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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