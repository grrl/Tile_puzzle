package whip.tile_puzzle;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.TwoStatePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static whip.tile_puzzle.MainActivity.getDateTime;
import static whip.tile_puzzle.MainActivity.getWins;

public class Statistics extends AppCompatActivity {

    private TextView wins;
    private TextView date;
    private long startingLong;
    private Date startingDate;
    private SharedPreferences m_sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        wins = (TextView) findViewById(R.id.winsVar);
        wins.setText(Integer.toString(showWins(this)));

        date = (TextView) findViewById(R.id.dateVar);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        startingLong = getDate(this);
        startingDate = new Date(startingLong);
        String reportDate = df.format(startingDate);
        System.out.println(reportDate);
        date.setText(reportDate);
    }

    private int showWins(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getWins(m_sharedPreferences);
    }

    private long getDate(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getDateTime(m_sharedPreferences);
    }
}
