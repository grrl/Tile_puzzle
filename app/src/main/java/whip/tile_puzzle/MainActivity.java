package whip.tile_puzzle;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static String[] tileList;

    private static GestureDetectGridView m_GridView;

    private static final int COLUMNS = 5;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private static int m_ColumnWidth, m_ColumnHeight;

    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        scramble();

        setDimensions();

    }

    private View.OnClickListener tileListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button guessButton = (Button) view;

            System.out.println("hit button numer " + guessButton);
        }
    };

    private void init(){
        m_GridView = findViewById(R.id.grid);

        m_GridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];


        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }

        /*
        int k = 0;
        for (int i = 0; i <= 4; i++){
            for(int j = 0; i <= 4; j++) {
                tileList[i][j] = [i][j];
                k++;
            }
        }
        */
    }

    private void scramble() {
        int index;
        String temp;
        Random random = new Random();

        //add debug scramble
        String p18 = tileList[18]; //18
        String p19 = tileList[19]; //19
        String p23 = tileList[23]; //23

        if(Settings.debugMode) {
            for (int i = 0; i < tileList.length - 1; i++){



                if(i == 18){ //23 tiili (22) matches

                    tileList[i] = p23;

                } else if (i == 19){ //24 tiili (23 matches)

                    tileList[i] = p18;

                } else if (i == 23){

                    tileList[i] = p19;
                }
            }

            //valkoinen pala aina viimeinen

        } else {
            for (int i = tileList.length - 1; i > 0; i--) {

                index = random.nextInt(i + 1);
                temp = tileList[index];
                tileList[index] = tileList[i];
                tileList[i] = temp;
            }
        }
    }

        /*
        for (int i = tileList - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            System.out.println("Arvotaan " + index);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
        */


    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    private void setDimensions(){

        ViewTreeObserver viewTreeObserver = m_GridView.getViewTreeObserver();

        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                m_GridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = m_GridView.getMeasuredWidth();
                int displayHeight = m_GridView.getMeasuredHeight();
                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                m_ColumnWidth = displayWidth / COLUMNS;
                m_ColumnHeight = requiredHeight / COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    private static void display(Context context){
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;

        for (int i = 0; i<tileList.length; i++){

            button = new Button(context);

            if(Settings.Image == 0) {

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.image_part_001);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.image_part_002);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.image_part_003);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.image_part_004);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.image_part_005);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.image_part_006);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.image_part_007);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.image_part_008);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.image_part_009);
                else if (tileList[i].equals("9"))
                    button.setBackgroundResource(R.drawable.image_part_010);
                else if (tileList[i].equals("10"))
                    button.setBackgroundResource(R.drawable.image_part_011);
                else if (tileList[i].equals("11"))
                    button.setBackgroundResource(R.drawable.image_part_012);
                else if (tileList[i].equals("12"))
                    button.setBackgroundResource(R.drawable.image_part_013);
                else if (tileList[i].equals("13"))
                    button.setBackgroundResource(R.drawable.image_part_014);
                else if (tileList[i].equals("14"))
                    button.setBackgroundResource(R.drawable.image_part_015);
                else if (tileList[i].equals("15"))
                    button.setBackgroundResource(R.drawable.image_part_016);
                else if (tileList[i].equals("16"))
                    button.setBackgroundResource(R.drawable.image_part_017);
                else if (tileList[i].equals("17"))
                    button.setBackgroundResource(R.drawable.image_part_018);
                else if (tileList[i].equals("18"))
                    button.setBackgroundResource(R.drawable.image_part_019);
                else if (tileList[i].equals("19"))
                    button.setBackgroundResource(R.drawable.image_part_020);
                else if (tileList[i].equals("20"))
                    button.setBackgroundResource(R.drawable.image_part_021);
                else if (tileList[i].equals("21"))
                    button.setBackgroundResource(R.drawable.image_part_022);
                else if (tileList[i].equals("22"))
                    button.setBackgroundResource(R.drawable.image_part_023);
                else if (tileList[i].equals("23"))
                    button.setBackgroundResource(R.drawable.image_part_024);
                else if (tileList[i].equals("24"))
                    button.setBackgroundResource(R.drawable.image_part_025);

            } else if (Settings.Image == 1){

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.image_part_002);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.image_part_003);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.image_part_004);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.image_part_005);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.image_part_006);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.image_part_007);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.image_part_008);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.image_part_009);
                else if (tileList[i].equals("9"))
                    button.setBackgroundResource(R.drawable.image_part_010);
                else if (tileList[i].equals("10"))
                    button.setBackgroundResource(R.drawable.image_part_011);
                else if (tileList[i].equals("11"))
                    button.setBackgroundResource(R.drawable.image_part_012);
                else if (tileList[i].equals("12"))
                    button.setBackgroundResource(R.drawable.image_part_013);
                else if (tileList[i].equals("13"))
                    button.setBackgroundResource(R.drawable.image_part_014);
                else if (tileList[i].equals("14"))
                    button.setBackgroundResource(R.drawable.image_part_015);
                else if (tileList[i].equals("15"))
                    button.setBackgroundResource(R.drawable.image_part_016);
                else if (tileList[i].equals("16"))
                    button.setBackgroundResource(R.drawable.image_part_017);
                else if (tileList[i].equals("17"))
                    button.setBackgroundResource(R.drawable.image_part_018);
                else if (tileList[i].equals("18"))
                    button.setBackgroundResource(R.drawable.image_part_019);
                else if (tileList[i].equals("19"))
                    button.setBackgroundResource(R.drawable.image_part_020);
                else if (tileList[i].equals("20"))
                    button.setBackgroundResource(R.drawable.image_part_021);
                else if (tileList[i].equals("21"))
                    button.setBackgroundResource(R.drawable.image_part_022);
                else if (tileList[i].equals("22"))
                    button.setBackgroundResource(R.drawable.image_part_023);
                else if (tileList[i].equals("23"))
                    button.setBackgroundResource(R.drawable.image_part_024);
                else if (tileList[i].equals("24"))
                    button.setBackgroundResource(R.drawable.image_part_025);
            }

            buttons.add(button);
            System.out.println(getLocation("24"));
        }
        m_GridView.setAdapter(new CustomAdapter(buttons, m_ColumnWidth, m_ColumnHeight));

    }

    private static int getLocation(String tile){
        return Arrays.asList(tileList).indexOf(tile);
    }

    private static void swap(Context context, int currentPosition, int swap){

        int blankTile = getLocation("24");

        int posAbove = blankTile + 5;
        int posBelow = blankTile - 5;
        int posRight = blankTile + 1;
        int posLeft = blankTile - 1;

        System.out.println("current is " + currentPosition);

        if(currentPosition == posAbove || currentPosition == posBelow ||
                currentPosition == posRight || currentPosition == posLeft) {

            String newPosition = tileList[currentPosition + swap];
            tileList[currentPosition + swap] = tileList[currentPosition];
            tileList[currentPosition] = newPosition;
            display(context);
        }

    }

    public static void moveTiles2(Context context, int position){

        int blankTile = getLocation("24");


        if(blankTile == position + 1)
            swap(context, position, 1);
        else if (blankTile == position - 1)
            swap(context, position, -1);
        else if (blankTile == position + 5)
            swap(context, position, 5);
        else if (blankTile == position - 5)
            swap(context, position, -5);
        else
            Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

        /*
        if (position == 0) {

            if (blankTile == position + 1) swap(context, position, 1);
            else if (blankTile == position + 5) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLUMNS - 1) {
            if (blankTile == position - 1) swap(context, position, -1);
            else if (blankTile == position + 5) swap(context, position, COLUMNS);
            else if (blankTile == position + 1) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLUMNS - 1) {
            if (blankTile == position - 1) swap(context, position, -1);
            else if (blankTile == position + 5) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (blankTile == position - 5) swap(context, position, -COLUMNS);
            else if (blankTile == position + 1) swap(context, position, 1);
            else if (blankTile == position + 5) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (blankTile == position - 5) swap(context, position, -COLUMNS);
            else if (blankTile == position - 1) swap(context, position, -1);
            else if (blankTile == position + 5) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (blankTile == position - 5) swap(context, position, -COLUMNS);
            else if (blankTile == position + 1) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (blankTile == position - 5) swap(context, position, -COLUMNS);
            else if (blankTile == position - 1) swap(context, position, -1);
            else if (blankTile == position + 1) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (blankTile == position - 5) swap(context, position, -COLUMNS);
            else if (blankTile == position - 1) swap(context, position, -1);
            else if (blankTile == position + 1) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }
        */
    }

    public static void moveTiles(Context context, String direction, int position){
        if (position == 0) {

            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-center tiles
        } else if (position > 0 && position < COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Upper-right-corner tile
        } else if (position == COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Left-side tiles
        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();

            // Center tiles
        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
        }
    }
}
