package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstText;
    private EditText secondText;
    private Button plusButton, minusButton;
    private EditText resultText;
    private Button navigateToSecondaryActivityButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int firstTextValue = Integer.valueOf(firstText.getText().toString());
            int secondTextValue = Integer.valueOf(secondText.getText().toString());
            int resultTextValue = Integer.valueOf(resultText.getText().toString());

            switch(view.getId()) {
                case R.id.plusb:
                    resultText.setText(String.valueOf(firstTextValue) + "+" + String.valueOf(secondTextValue) + "=" + String.valueOf(firstTextValue + secondTextValue));
                    break;
                case R.id.minusb:
                    resultText.setText(String.valueOf(firstTextValue) + "-" + String.valueOf(secondTextValue) + "=" + String.valueOf(firstTextValue - secondTextValue));
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
//                    int numberOfClicks = Integer.parseInt(leftEditText.getText().toString()) +
//                            Integer.parseInt(rightEditText.getText().toString());
                    intent.putExtra(Constants.NUMBER_OF_CLICKS, resultTextValue);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstText = (EditText)findViewById(R.id.first);
        secondText = (EditText)findViewById(R.id.second);
        resultText = (EditText)findViewById(R.id.result);
        plusButton = (Button)findViewById(R.id.plusb);
        minusButton = (Button)findViewById(R.id.minusb);

        plusButton.setOnClickListener(buttonClickListener);
        minusButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
                firstText.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
            } else {
                firstText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
                secondText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
            } else {
                secondText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey(Constants.REZ_COUNT)) {
                resultText.setText(savedInstanceState.getString(Constants.REZ_COUNT));
            } else {
                resultText.setText(String.valueOf(0));
            }
        } else {
            firstText.setText(String.valueOf(0));
            secondText.setText(String.valueOf(0));
            resultText.setText(String.valueOf(0));
        }

//        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(Constants.LEFT_COUNT, firstText.getText().toString());
        savedInstanceState.putString(Constants.RIGHT_COUNT, secondText.getText().toString());
        savedInstanceState.putString(Constants.REZ_COUNT, resultText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
            firstText.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
        } else {
            firstText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
            secondText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
        } else {
            secondText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.REZ_COUNT)) {
            resultText.setText(savedInstanceState.getString(Constants.REZ_COUNT));
            Toast.makeText(this, "The activity returned with result ", Toast.LENGTH_LONG).show();
        } else {
            resultText.setText(String.valueOf(0));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}