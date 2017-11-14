package comps413f.android.a_to_z;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AToZActivity extends Activity implements OnClickListener {
    private AToZ aToZ;
    private long startTime = 0;   // Recording the start time

    private Button startButton;   // Start button
    private TextView cal;
    private Button aToZButton[] = new Button[AToZ.SIZE];
    private int idArray[] = { R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8,
            R.id.button9, R.id.button10, R.id.button11, R.id.button12,
            R.id.button13, R.id.button14, R.id.button15, R.id.button16};



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        cal =  (TextView)findViewById(R.id.calculation);
        startButton = (Button)findViewById(R.id.startbutton);
        startButton.setOnClickListener(this);

        aToZ = new AToZ();
        
        for (int i=0; i<aToZButton.length; i++) {
            aToZButton[i] = (Button) findViewById(idArray[i]);
            aToZButton[i].setOnClickListener(this);  // Register event handler
        }

        resetGame();    // Start a new game if activity is first created
    }
    
    // Player click any button 
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()) {
        case R.id.startbutton:  // Start button clicked
            resetGame();   // Start a new game
            break;

        default:  // Other button in gridlayout
            // Add code here
            // Task 3: Item click handler
            // i. Obtain the label of the clicked button
            // ii. Check if it is a valid button
            // iii. If it is a valid button, check if the character is selected in order
            // iv. If correct character is selected
            //     a. Set the button label to empty string
            //     b. Call the "isGameComplete" to check if end of game
            // v. If game ends, execute the "gameCompleted" method
            String answer = ((Button) v).getText().toString();   // Get user selected character
            if (answer.length()>0) {  // Valid button
                if (aToZ.validOrder(answer)) {  // If player completed the game
                    String temp = (((Button) v).getText().toString());
                    int temp2 = aToZ.addition(Integer.parseInt(temp));
                    String temp3 = String.valueOf(temp2);
                    cal.setText(temp3);


                    ((Button) v).setText(AToZ.EMPTY);
                    if (aToZ.isGameComplete()) {
                        gameCompleted();
                    }
                }
            }
        }
    }

    // Resets the game and updates display
    private void resetGame() {
        // Add code here
        // Task 1: Reset the game
        // i. Set startTime to current system time
        // ii. Randomize the character by invoking the "resetDataList" method with the aToZ object
        // iii. Update gridlayout display by invoking the "updateButtonLabel" method
        startTime = System.currentTimeMillis();    // Record start time
        aToZ.resetDataList();    // Reset game data
        updateButtonLabel();    // Update gridlayout display
    }
    
    // Update button label according to the content of the datalist of the aToZ object
    private void updateButtonLabel() {
        ArrayList<String> al = aToZ.getDataList();
        for (int i=0; i<aToZButton.length; i++) {
            aToZButton[i].setText(al.get(i));
        }
    }
    
    // Show statistics after completion of the game
    private void gameCompleted() {
        // Add code here
        // Task 2: displaying statistics after completion of game
        // i. Obtain the current time and evaluating the total time used for solving the puzzle
        // ii. Create and display an AlertDialog, the corresponding title and message can be find in the string resource file
        double time = (System.currentTimeMillis() - startTime) / 1000.0;   // Calculate the time used
        new AlertDialog.Builder(AToZActivity.this)   // Show statistic with AlertDialog 
            .setTitle(R.string.congratulation)
            .setMessage(getString(R.string.congratulation_msg, time))
            .setNeutralButton(android.R.string.ok, null)
            .show();
    }
    
}