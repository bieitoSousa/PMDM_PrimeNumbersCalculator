package com.bieitosousa.primenumberscalculator;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.util.Log;

import android.view.Gravity;
import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private static final String TAG_onCreate = TAG +" : onCreate";
    private static final String TAG_onCreate_button_onClick = TAG_onCreate+ " : button_action_calculate : onClick";


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

        Log.i(TAG_onCreate, " - START -");
        try {
            Resources res = getResources(); // to access res/ to  take color and other parameters
            // init main activity
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            // take inputs
            String preRequest = getString(R.string.preRequest);
            String postRequest = getString(R.string.postRequest);
            final TextView textView_header = (TextView) findViewById(R.id.textView_header);
            final TextView textView_description = (TextView) findViewById(R.id.textView_description);
            final EditText editText_int_Input = (EditText) findViewById(R.id.editText_int_Input);
            final TextView textView_Label_position = (TextView) findViewById(R.id.textView_Label_position);
            final Button button_action_calculate = (Button) findViewById(R.id.button_action_calculate);
            final TextView textView_request_action = (TextView) findViewById(R.id.textView_request_action);

            // set atributes for the inputs
           //header
            textView_header.setText(getString(R.string.header));
            textView_header.setTextColor(ContextCompat.getColor(this, R.color.orange_primary));
            //description
            textView_description.setText(getString(R.string.description));
            //button
            button_action_calculate.setText(getString(R.string.button_action_calculate_text));
            button_action_calculate.setTextColor(ContextCompat.getColor(this, R.color.white));
            button_action_calculate.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_primary));
            // input label
            textView_Label_position.setText(getString(R.string.labelPosition));
            textView_Label_position.setTextColor(ContextCompat.getColor(this, R.color.orange_primary));


            // Events --> On
            button_action_calculate.setOnClickListener(
                    new View.OnClickListener()  {
                        @Override
                        public void onClick(View v) throws NumberFormatException {
                            try {
                            // take atributes for the inputs
                            final String inputNumberString = editText_int_Input.getText().toString(); // input in type String
                            int inputNumberInt = Integer.parseInt(inputNumberString);
                            final String finalRequest = preRequest + " [ " + inputNumberInt + " ] " + postRequest + "=> [ ";
                            // calculate outputs
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "Toast por defecto", Toast.LENGTH_SHORT);
                            int numberRequest = PrimeCalculator.numberOfPrimoInt(inputNumberInt);
                            // request ouputs
                            textView_request_action.setText(finalRequest + numberRequest + " ]");
                            } catch (NumberFormatException nfe) {
                               Toast toast = Toast.makeText(MainActivity.this ,getString(R.string.errorEntero), Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                                toast.show();
                                Log.d(TAG_onCreate_button_onClick, "NumberFormatException "+nfe.getMessage());
                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this ,e.getMessage(), Toast.LENGTH_LONG).show();
                                Log.d(TAG_onCreate_button_onClick,"Exception"+ e.getMessage());
                            }
                        }
                    });
        } catch (Exception e) {
            Log.i(TAG_onCreate,"MainActivity"+ e.getMessage());
        }
    }


}