package comps413f.android.a_to_z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AToZ {
    final static int SIZE = 16;
    final static String EMPTY = "";
    private final String lastChar = Character.toString((char) (SIZE + 65));
    private final ArrayList<String> dataList = new ArrayList<String>();   // Game data
    private String curSelection = "A";
    private int total=0;
    private int answer=0;
    
    // Constructor
    public AToZ() {
        resetDataList();
    }
    
    // Initialized and arranged game data from 'A' to 'Z'  
    private void initializedDataList() {
        // Add code here        
        // Task 1: Initialized the game data
        // i. Remove all element from dataList with clear() method
        // ii. Add 'A' to 'Z' to dataList with "add" method
        // iii. Assign the current character needed to be selected to 'A'
        dataList.clear();
        
        for (int i = 0; i < SIZE; i++) {


            Random rand = new Random();

            int  n = rand.nextInt(9) + 1;
            dataList.add(Integer.toString(n));
        }


        
        curSelection = "A";
    }
    
    // Shuffle game data
    private void shuffleDataList() {
        // Add code here        
        // Task 2: Shuffle the dataList
        Collections.shuffle(dataList);
    }

    // Reset game data
    public void resetDataList() {
        // Add code here        
        // Task 3: Reset the game list
        // i. Game data initialization
        // ii. Randomize the game data
        initializedDataList();
        shuffleDataList();


    }
    
    // Returns true if 'A' to 'Z' are selected in order
    // Otherwise, return false 
    public boolean validOrder(String itemSelected) {

            return true;

    }
    
    // Return true if game end
    // Otherwise, return false
    public boolean isGameComplete() {
        if (curSelection.equals(lastChar))
            return true;
        return false;
    }

    public int addition(int temp){
        total  += temp;
        return total;
    }
    public int addition2(int temp){
            for(int i = 0; i < SIZE; i++) {
                Random rand = new Random();

                int n = rand.nextInt(2) + 1;
                answer += Integer.valueOf(dataList.get(i));
            }
        return answer;
            }

        // Getter method
    public ArrayList<String> getDataList() {
        return dataList;
    }
}
