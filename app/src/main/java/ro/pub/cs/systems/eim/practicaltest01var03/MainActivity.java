package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText firstText;
    private EditText secondText;
    private Button plusButton, minusButton;
    private EditText resultText;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            int firstTextValue = Integer.valueOf(firstText.getText().toString());
            int secondTextValue = Integer.valueOf(secondText.getText().toString());

            switch(view.getId()) {
                case R.id.plusb:
                    resultText.setText(String.valueOf(firstTextValue) + "+" + String.valueOf(secondTextValue) + "=" + String.valueOf(firstTextValue + secondTextValue));
                    break;
                case R.id.minusb:
                    resultText.setText(String.valueOf(firstTextValue) + "" + String.valueOf(secondTextValue) + "=" + String.valueOf(firstTextValue - secondTextValue));
                    break;
//                case R.id.navigate_to_secondary_activity_button:
//                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
//                    int numberOfClicks = Integer.parseInt(leftEditText.getText().toString()) +
//                            Integer.parseInt(rightEditText.getText().toString());
//                    intent.putExtra(Constants.NUMBER_OF_CLICKS, numberOfClicks);
//                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
//                    break;
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
    }
}