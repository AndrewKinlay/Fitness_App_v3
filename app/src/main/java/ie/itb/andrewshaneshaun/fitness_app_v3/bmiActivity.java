package ie.itb.andrewshaneshaun.fitness_app_v3;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class bmiActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3){
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        Button btnCalc = (Button) findViewById(R.id.btnCalc);

        checkFieldsForEmptyValues();

        EditText numWeight = (EditText) findViewById(R.id.numWeight);
        EditText numHeight = (EditText) findViewById(R.id.numHeight);

        numWeight.addTextChangedListener(textWatcher);
        numHeight.addTextChangedListener(textWatcher);

        btnCalc.setOnClickListener(

            new View.OnClickListener(){


                @Override
                public void onClick(View v) {

                    //View areaBMI = findViewById(R.id.areaBMI);

                    EditText areaBMI = (EditText) findViewById(R.id.areaBMI);
                    EditText numWeight = (EditText) findViewById(R.id.numWeight);
                    EditText numHeight = (EditText) findViewById(R.id.numHeight);
                    EditText areaAbout = (EditText) findViewById(R.id.areaAbout);
                    ImageView imgFace = (ImageView) findViewById(R.id.imgFace);
                    //imgFace.setImageResource(R.drawable.sad);


                    int intWeight = Integer.parseInt(numWeight.getText().toString());
                    int intHeight = Integer.parseInt(numHeight.getText().toString());

                        int yourbmi = ((intWeight * 703)/(intHeight * intHeight));

                        String yourbmiString = Integer.toString(yourbmi);

                        areaBMI.setText(yourbmiString);

                    if(yourbmi > 30){
                        areaAbout.setText("Your BMI shows you may be obese");
                        imgFace.setImageResource(R.drawable.sad);
                    }
                    else if(yourbmi > 25 && yourbmi <30 ){
                        areaAbout.setText("Your BMI shows you may be overweight");
                        imgFace.setImageResource(R.drawable.sad);
                    }
                    else if(yourbmi > 19 && yourbmi <25 ){
                        areaAbout.setText("Your BMI shows you are a healthy size");
                        imgFace.setImageResource(R.drawable.happy);
                    }
                    else{
                        areaAbout.setText("Your BMI shows you May be underweight");
                        imgFace.setImageResource(R.drawable.sad);
                    }

                }
            }
        );
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "bmi Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ie.itb.andrewshaneshaun.fitness_app_v3/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "bmi Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ie.itb.andrewshaneshaun.fitness_app_v3/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



    private  void checkFieldsForEmptyValues(){
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        EditText numWeight = (EditText) findViewById(R.id.numWeight);
        EditText numHeight = (EditText) findViewById(R.id.numHeight);

        String s1 = numWeight.getText().toString();
        String s2 = numHeight.getText().toString();

        if(s1.equals("") && s2.equals(""))
        {
            btnCalc.setEnabled(false);
        }

        else if(!s1.equals("")&&s2.equals("")){
            btnCalc.setEnabled(false);
        }

        else if(!s2.equals("")&&s1.equals(""))
        {
            btnCalc.setEnabled(false);
        }

        else
        {
            btnCalc.setEnabled(true);
        }
    }
}
