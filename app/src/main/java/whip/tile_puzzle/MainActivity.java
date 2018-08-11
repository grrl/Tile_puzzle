package whip.tile_puzzle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static String[] tileList;

    private static GestureDetectGridView m_GridView ;

    private static final int COLUMNS = 5;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private static int m_ColumnWidth, m_ColumnHeight;

    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";

    private Button button;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "You have clicked on setting" +
                        "action menu", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Options.class));
                break;
            case R.id.action_statistics:
                Toast.makeText(MainActivity.this, "You have clicked on statisctics" +
                        "action menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(MainActivity.this, "You have clicked on about" +
                        "action menu", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    public static void resetGame(){

        init();

        scramble();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_GridView = findViewById(R.id.grid);

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

    protected static void init(){
        //m_GridView = findViewById(R.id.grid);

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

    protected static void scramble() {
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

            } else if (Settings.Image == 3){

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.automaatti_part_001);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.automaatti_part_002);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.automaatti_part_003);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.automaatti_part_004);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.automaatti_part_005);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.automaatti_part_006);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.automaatti_part_007);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.automaatti_part_008);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.automaatti_part_009);
                else if (tileList[i].equals("9"))
                    button.setBackgroundResource(R.drawable.automaatti_part_010);
                else if (tileList[i].equals("10"))
                    button.setBackgroundResource(R.drawable.automaatti_part_011);
                else if (tileList[i].equals("11"))
                    button.setBackgroundResource(R.drawable.automaatti_part_012);
                else if (tileList[i].equals("12"))
                    button.setBackgroundResource(R.drawable.automaatti_part_013);
                else if (tileList[i].equals("13"))
                    button.setBackgroundResource(R.drawable.automaatti_part_014);
                else if (tileList[i].equals("14"))
                    button.setBackgroundResource(R.drawable.automaatti_part_015);
                else if (tileList[i].equals("15"))
                    button.setBackgroundResource(R.drawable.automaatti_part_016);
                else if (tileList[i].equals("16"))
                    button.setBackgroundResource(R.drawable.automaatti_part_017);
                else if (tileList[i].equals("17"))
                    button.setBackgroundResource(R.drawable.automaatti_part_018);
                else if (tileList[i].equals("18"))
                    button.setBackgroundResource(R.drawable.automaatti_part_019);
                else if (tileList[i].equals("19"))
                    button.setBackgroundResource(R.drawable.automaatti_part_020);
                else if (tileList[i].equals("20"))
                    button.setBackgroundResource(R.drawable.automaatti_part_021);
                else if (tileList[i].equals("21"))
                    button.setBackgroundResource(R.drawable.automaatti_part_022);
                else if (tileList[i].equals("22"))
                    button.setBackgroundResource(R.drawable.automaatti_part_023);
                else if (tileList[i].equals("23"))
                    button.setBackgroundResource(R.drawable.automaatti_part_024);
                else if (tileList[i].equals("24"))
                    button.setBackgroundResource(R.drawable.automaatti_part_025);

            }

            buttons.add(button);
            System.out.println(getLocation("24"));
        }
        m_GridView.setAdapter(new CustomAdapter(buttons, m_ColumnWidth, m_ColumnHeight));

    }

    private static int getLocation(String tile){
        return Arrays.asList(tileList).indexOf(tile);
    }

    public static boolean gameStatus(){

        if(getLocation("24") != 24)
            return false;

        for(int i = 0; i < tileList.length; i++){
            if(tileList[i] != Integer.toString(i))
                return false;
        }
        return true;
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

            if(gameStatus())
                alertDialogShow(context);

        }

    }


    public static void alertDialogShow(Context context)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // 2. Chain together various setter methods to set the dialog characteristics
        Drawable i = context.getDrawable(R.drawable.ic_clear_black_24dp);
        builder.setMessage("Won") //stats here as message
                .setTitle("you wonned").setPositiveButtonIcon(i);

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        Settings.playGame = false;
        //Näytä iso kuva lopuksi?
        // 4. Show the dialog
        setSharedPreferences(context);

        dialog.show();
    }

    /*
    public void storeWins(){
        SharedPreferences m_sharedPreferences = getSharedPreferences("Wins", MODE_PRIVATE);
        SharedPreferences.Editor m_editor = m_sharedPreferences.edit();
        m_editor.putInt("WinAmount", getWins() + 1);
        m_editor.apply();
    }

    public static int getWins(){
        SharedPreferences m_sharedPreferences = getSharedPreferences(Context ctx)
        int i = m_sharedPreferences.getInt("WinAmount", 0);
        return i;
    }
    */

    public static void setSharedPreferences (Context ctx){
        SharedPreferences m_sharedPreferences = getSharedPreferences(ctx);
        SharedPreferences.Editor m_editor = m_sharedPreferences.edit();
        m_editor.putInt("WinAmount", getWins(m_sharedPreferences) + 1);
        m_editor.apply();
        System.out.println("Voitot " + getWins(m_sharedPreferences));
    }

    public static int getWins(SharedPreferences p){
        return p.getInt("WinAmount", 0);

    }

    public static SharedPreferences getSharedPreferences(Context ctx){

        return ctx.getSharedPreferences("Wins", 0);
    }


    public static void moveTiles(Context context, int position){

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

    }


}
