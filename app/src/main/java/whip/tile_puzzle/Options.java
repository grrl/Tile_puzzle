package whip.tile_puzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static whip.tile_puzzle.MainActivity.resetGame;

public class Options extends AppCompatActivity {

    private Button button;


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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Options.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.images));
        //adapter dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
