package sg.edu.np.WhackAMole;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public  Button ButtonLeft;
    public  Button ButtonMiddle;
    public  Button ButtonRight;
    public TextView scoreTxtView;
    private static final String TAG = "ButtonActivity";

    String selectedValue;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonLeft = (Button) findViewById(R.id.button1);
        ButtonMiddle = (Button) findViewById(R.id.button2);
        ButtonRight = (Button) findViewById(R.id.button3);
        scoreTxtView = (TextView) findViewById(R.id.scoreTxtView);

        scoreTxtView.setText(String.valueOf(score));

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "ButtonLeft click");
                //Get value of button
                selectedValue = ButtonLeft.getText().toString();
                validate(selectedValue);
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "ButtonMiddle click");
                //Get value of button
                selectedValue = ButtonMiddle.getText().toString();
                validate(selectedValue);
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "ButtonRight click");
                //Get value of button
                selectedValue = ButtonRight.getText().toString();
                validate(selectedValue);
            }
        });

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }


    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);

        if (randomLocation == 1){
            ButtonLeft.setText("*");
            ButtonMiddle.setText("O");
            ButtonRight.setText("O");
        }
        else if (randomLocation == 2){
            ButtonLeft.setText("O");
            ButtonMiddle.setText("*");
            ButtonRight.setText("O");
        }
        else{
            ButtonLeft.setText("O");
            ButtonMiddle.setText("O");
            ButtonRight.setText("*");
        }
    }

    public void validate(String value){
        // If correct button pressed
        if(value == "*"){
            Log.v(TAG, "Hit, score added!");
            score += 1;
            scoreTxtView.setText(String.valueOf(score));
            setNewMole();
        }
        // If Incorrect button pressed
        else{
            if (score >0){
                score -= 1;
                scoreTxtView.setText(String.valueOf(score));
            }
            Log.v(TAG, "Missed, score deducted!");
        }
    }

}
