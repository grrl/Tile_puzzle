package whip.tile_puzzle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import static whip.tile_puzzle.MainActivity.getSoundandReturn;
import static whip.tile_puzzle.MainActivity.getWins;
import static whip.tile_puzzle.MainActivity.resetGame;
import static whip.tile_puzzle.MainActivity.setSoundSharedPreferences;

public class Options extends AppCompatActivity {

    private Button button;
    private RadioGroup radioGroup;
    private SharedPreferences m_sharedPreferences;
    private MediaPlayer player;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Options.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.images));
        //adapter dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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
        setSoundSharedPreferences(this, false);
    }

}
