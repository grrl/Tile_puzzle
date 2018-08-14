package whip.tile_puzzle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static whip.tile_puzzle.MainActivity.getDateTime;
import static whip.tile_puzzle.MainActivity.getTurns;
import static whip.tile_puzzle.MainActivity.getWins;

/**
 *
 */
public class Statistics extends AppCompatActivity {

    private TextView wins;
    private TextView date;
    private TextView turns;
    private long startingLong;
    private Date startingDate;
    private SharedPreferences m_sharedPreferences;
    private DateFormat df;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        wins = /*(TextView)*/ findViewById(R.id.winsVar);
        wins.setText(Integer.toString(showWins(this)));

        date = /*(TextView)*/ findViewById(R.id.dateVar);

        if(Locale.getDefault().getLanguage().equals("fi")){
            df = new SimpleDateFormat("dd'.'MM'.'yyyy HH:mm:ss");

        } else if (Locale.getDefault().getLanguage().equals("ja")){
            df = new SimpleDateFormat("yyyy'年'MM'月'dd'日' HH:mm:ss");

        } else {
            df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        }

        startingLong = getDate(this);
        startingDate = new Date(startingLong);
        String reportDate = df.format(startingDate);
        System.out.println(reportDate);

        turns = /*(TextView)*/ findViewById(R.id.turnsVar);
        turns.setText(Integer.toString(showTurns(this)));

        date.setText(reportDate);

    }

    /**
     * @param context
     * @return
     */
    private int showWins(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getWins(m_sharedPreferences);
    }

    /**
     * @param context
     * @return
     */
    private long getDate(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getDateTime(m_sharedPreferences);
    }

    /**
     * @param context
     * @return
     */
    private int showTurns(Context context){
        m_sharedPreferences = MainActivity.getSharedPreferences(context);
        return getTurns(m_sharedPreferences);
    }
}
