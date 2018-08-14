package whip.tile_puzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;
import java.util.Set;

import static whip.tile_puzzle.MainActivity.getSoundandReturn;
import static whip.tile_puzzle.MainActivity.getWins;
import static whip.tile_puzzle.MainActivity.resetGame;
import static whip.tile_puzzle.MainActivity.setSoundSharedPreferences;

/**
 * Options luokka
 */
public class Options extends AppCompatActivity {

    private Button button;
    private RadioGroup radioGroup;
    private SharedPreferences m_sharedPreferences;
    private MediaPlayer player;
    private String selecteditem;
    private ImageView imageView;
    private CheckBox checkBox;
    private Boolean isSelected;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Spinner spinner = /*(Spinner)*/ findViewById(R.id.spinner);

        isSelected = false;

        //painike
        button = /*(Button)*/ findViewById(R.id.button);

        imageView = /*(ImageView)*/ findViewById(R.id.imageView);

        checkBox = /*(CheckBox)*/ findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Settings.debugMode = b;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isSelected){

                    Toast.makeText(Options.this, R.string.selectImage, Toast.LENGTH_SHORT).show();

                }else {

                    Settings.playGame = true;
                    //kutsu reset metodia
                    resetGame();

                    startActivity(new Intent(Options.this, MainActivity.class));
                }
            }
        });

        radioGroup = /*(RadioGroup)*/ findViewById(R.id.radioGroup);

        if(getSound(this))
            radioGroup.check(R.id.soundOn);
        else
            radioGroup.check(R.id.soundOff);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.soundOn:
                        //play sound here
                        setSound(true);
                        playSound();
                        break;

                    case R.id.soundOff:
                        setSound(false);
                        break;

                    default:
                        break;
                }
            }
        });

        final ArrayAdapter<String> adapter;

        if(Locale.getDefault().getLanguage().equals("fi")){
            adapter = new ArrayAdapter</*String*/>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kuvat));
        } else if (Locale.getDefault().getLanguage().equals("ja")){
            adapter = new ArrayAdapter</*String*/>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ピクチャ));
        } else {
            adapter = new ArrayAdapter</*String*/>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.images));
        }
        //adapter dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            /**
             * @param adapter
             * @param v
             * @param i
             * @param lng
             */
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {

                selecteditem =  adapter.getItemAtPosition(i).toString();

                if(Locale.getDefault().getLanguage().equals("fi")){

                    switch (selecteditem){
                        case "Auringonlasku":
                            Settings.Image = 1;
                            imageView.setImageResource(R.drawable.p1);
                            isSelected = true;
                            break;
                        case "Klassinen":
                            Settings.Image = 9;
                            imageView.setImageResource(R.drawable.p10);
                            isSelected = true;
                            break;
                        case "Kukat":
                            Settings.Image = 6;
                            imageView.setImageResource(R.drawable.p5);
                            isSelected = true;
                            break;
                        case "Kitaristi":
                            Settings.Image = 5;
                            imageView.setImageResource(R.drawable.p6);
                            isSelected = true;
                            break;
                        case "Pyykit":
                            Settings.Image = 7;
                            imageView.setImageResource(R.drawable.p9);
                            isSelected = true;
                            break;
                        case "Fuji vuori":
                            Settings.Image = 2;
                            imageView.setImageResource(R.drawable.p3);
                            isSelected = true;
                            break;
                        case "Temppeli":
                            Settings.Image = 8;
                            imageView.setImageResource(R.drawable.p4);
                            isSelected = true;
                            break;
                        case "Väsynyt palkansaaja":
                            Settings.Image = 4;
                            imageView.setImageResource(R.drawable.p8);
                            isSelected = true;
                            break;
                        case "Rautatieasema":
                            Settings.Image = 3;
                            imageView.setImageResource(R.drawable.p2);
                            isSelected = true;
                            break;
                        case "Myyntiautomaatti":
                            Settings.Image = 0;
                            imageView.setImageResource(R.drawable.p7);
                            isSelected = true;
                            break;
                        default:
                            imageView.setImageResource(android.R.drawable.ic_menu_gallery);
                            isSelected = false;
                            break;
                    }

                } else if (Locale.getDefault().getLanguage().equals("ja")){

                    switch (selecteditem){

                        case "クラシック":
                            Settings.Image = 9;
                            imageView.setImageResource(R.drawable.p10);
                            isSelected = true;
                            break;
                        case "日没":
                            Settings.Image = 1;
                            imageView.setImageResource(R.drawable.p1);
                            isSelected = true;
                            break;
                        case "花":
                            Settings.Image = 6;
                            imageView.setImageResource(R.drawable.p5);
                            isSelected = true;
                            break;
                        case "ギタリスト":
                            Settings.Image = 5;
                            imageView.setImageResource(R.drawable.p6);
                            isSelected = true;
                            break;
                        case "ランドリー":
                            Settings.Image = 7;
                            imageView.setImageResource(R.drawable.p9);
                            isSelected = true;
                            break;
                        case "フジ":
                            Settings.Image = 2;
                            imageView.setImageResource(R.drawable.p3);
                            isSelected = true;
                            break;
                        case "寺":
                            Settings.Image = 8;
                            imageView.setImageResource(R.drawable.p4);
                            isSelected = true;
                            break;
                        case "サラリーマン":
                            Settings.Image = 4;
                            imageView.setImageResource(R.drawable.p8);
                            isSelected = true;
                            break;
                        case "鉄道の駅":
                            Settings.Image = 3;
                            imageView.setImageResource(R.drawable.p2);
                            isSelected = true;
                            break;
                        case "自動販売機":
                            Settings.Image = 0;
                            imageView.setImageResource(R.drawable.p7);
                            isSelected = true;
                            break;
                        default:
                            imageView.setImageResource(android.R.drawable.ic_menu_gallery);
                            isSelected = false;
                            break;
                    }

                } else {

                    switch (selecteditem){

                        case "Classic":
                            Settings.Image = 9;
                            imageView.setImageResource(R.drawable.p10);
                            isSelected = true;
                            break;
                        case "Flowers":
                            Settings.Image = 6;
                            imageView.setImageResource(R.drawable.p5);
                            isSelected = true;
                            break;
                        case "Guitarist":
                            Settings.Image = 5;
                            imageView.setImageResource(R.drawable.p6);
                            isSelected = true;
                            break;
                        case "Laundry":
                            Settings.Image = 7;
                            imageView.setImageResource(R.drawable.p9);
                            isSelected = true;
                            break;
                        case "Mount Fuji":
                            Settings.Image = 2;
                            imageView.setImageResource(R.drawable.p3);
                            isSelected = true;
                            break;
                        case "Sunset":
                            Settings.Image = 1;
                            imageView.setImageResource(R.drawable.p1);
                            isSelected = true;
                            break;
                        case "Temple":
                            Settings.Image = 8;
                            imageView.setImageResource(R.drawable.p4);
                            isSelected = true;
                            break;
                        case "Tired salaryman":
                            Settings.Image = 4;
                            imageView.setImageResource(R.drawable.p8);
                            isSelected = true;
                            break;
                        case "Railway station":
                            Settings.Image = 3;
                            imageView.setImageResource(R.drawable.p2);
                            isSelected = true;
                            break;
                        case "Vending Machine":
                            Settings.Image = 0;
                            imageView.setImageResource(R.drawable.p7);
                            isSelected = true;
                            break;
                        default:
                            imageView.setImageResource(android.R.drawable.ic_menu_gallery);
                            isSelected = false;
                            break;
                    }

                }
                System.out.println(selecteditem);

            }

            /**
             * @param parentView
             */
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });


    }

    /**
     *
     */
    private void playSound(){
        player = MediaPlayer.create(getApplicationContext(), R.raw.soundon);

        player.start();
    }

    /**
     * @param context
     * @return
     */
    private boolean getSound(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getSoundandReturn(m_sharedPreferences);
    }

    /**
     * @param bool
     */
    private void setSound(boolean bool){
        setSoundSharedPreferences(this, bool);
    }

}
