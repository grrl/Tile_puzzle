package whip.tile_puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Options extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //painike
        button = (Button) findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Options.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.images));
        //adapter dropdown
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    button.OnClickListener(new)

}
