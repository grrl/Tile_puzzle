package whip.tile_puzzle;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Locale;

import static whip.tile_puzzle.MainActivity.getSoundandReturn;
import static whip.tile_puzzle.MainActivity.getWins;
import static whip.tile_puzzle.MainActivity.resetGame;
import static whip.tile_puzzle.MainActivity.setSoundSharedPreferences;

public class Options extends AppCompatActivity {

    private Button button;
    private RadioGroup radioGroup;
    private SharedPreferences m_sharedPreferences;
    private MediaPlayer player;
    private String selecteditem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //painike
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings.playGame = true;
                //kutsu reset metodia
                resetGame();

                startActivity(new Intent(Options.this, MainActivity.class));

            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

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
            adapter = new ArrayAdapter<String>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kuvat));
        } else if (Locale.getDefault().getLanguage().equals("ja")){
            adapter = new ArrayAdapter<String>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ピクチャ));
        } else {
            adapter = new ArrayAdapter<String>(Options.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.images));
        }
        //adapter dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {

                selecteditem =  adapter.getItemAtPosition(i).toString();

                if(Locale.getDefault().getLanguage().equals("fi")){

                    /*
                     <item>Valitse kuva</item>
                <item>Auringonlasku</item>
                <item>Kukat</item>
                <item>Kitaristi</item>
                <item>Pyykit</item>
                <item>Fuji vuori</item>
                <item>Temppeli</item>
                <item>Väsynyt palkansaaja</item>
                <item>Rautatieasema</item>
                <item>Myyntiautomaatti</item>
                    */
                    switch (selecteditem){
                        case "Auringonlasku":
                            Settings.Image = 1;
                            break;
                        case "Kukat":
                            Settings.Image = 6;
                            break;
                        case "Kitaristi":
                            Settings.Image = 5;
                            break;
                        case "Pyykit":
                            Settings.Image = 7;
                            break;
                        case "Fuji vuori":
                            Settings.Image = 2;
                            break;
                        case "Temppeli":
                            Settings.Image = 8;
                            break;
                        case "Väsynyt palkansaaja":
                            Settings.Image = 4;
                            break;
                        case "Rautatieasema":
                            Settings.Image = 3;
                            break;
                        case "Myyntiautomaatti":
                            Settings.Image = 0;
                            break;
                        default:
                            break;
                    }

                } else if (Locale.getDefault().getLanguage().equals("ja")){

                    /*
                    <item>画像を選択する</item> <!--Gazo o sentaku suru-->
                    <item>日没</item> <!--Nichibotsu -->
                    <item>花</item> <!--Hana-->
                    <item>ギタリスト</item> <!--Gitarisuto-->
                    <item>ランドリー</item> <!--Randori-->
                    <item>フジ</item> <!--Fuji-->
                    <item>寺</item> <!--Tera-->
                    <item>サラリーマン</item> <!--Sarariman-->
                    <item>鉄道の駅</item> <!--Tetsudo no eki-->
                    <item>自動販売機</item> <!--Jido hanbaiki-->
                     */
                    switch (selecteditem){

                        case "日没":
                            Settings.Image = 1;

                            break;
                        case "花":
                            Settings.Image = 6;
                            break;
                        case "ギタリスト":
                            Settings.Image = 5;
                            break;
                        case "ランドリー":
                            Settings.Image = 7;
                            break;
                        case "フジ":
                            Settings.Image = 2;
                            break;
                        case "寺":
                            Settings.Image = 8;
                            break;
                        case "サラリーマン":
                            Settings.Image = 4;
                            break;
                        case "鉄道の駅":
                            Settings.Image = 3;
                            break;
                        case "自動販売機":
                            Settings.Image = 0;

                            break;
                        default:
                            break;
                    }

                } else {
                    /*
                    <item>Choose a picture</item>
                    <item>Flowers</item>
                    <item>Guitarist</item>
                    <item>Laundry</item>
                    <item>Mount Fuji</item>
                    <item>Sunset</item>
                    <item>Temple</item>
                    <item>Tired salaryman</item>
                    <item>Railway station</item>
                    <item>Vending Machine</item>
                     */
                    switch (selecteditem){

                        case "Flowers":
                            Settings.Image = 6;
                            break;
                        case "Guitarist":
                            Settings.Image = 5;
                            break;
                        case "Laundry":
                            Settings.Image = 7;
                            break;
                        case "Mount Fuji":
                            Settings.Image = 2;
                            break;
                        case "Sunset":
                            Settings.Image = 1;
                            break;
                        case "Temple":
                            Settings.Image = 8;
                            break;
                        case "Tired salaryman":
                            Settings.Image = 4;
                            break;
                        case "Railway station":
                            Settings.Image = 3;
                            break;
                        case "Vending Machine":
                            Settings.Image = 0;
                            break;
                        default:
                            break;
                    }

                }
                System.out.println(selecteditem);
                //or this can be also right: selecteditem = level[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });


    }

    private void playSound(){
        player = MediaPlayer.create(getApplicationContext(), R.raw.soundon);

        player.start();
    }

    private boolean getSound(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getSoundandReturn(m_sharedPreferences);
    }

    private void setSound(boolean bool){
        setSoundSharedPreferences(this, bool);
    }

}
