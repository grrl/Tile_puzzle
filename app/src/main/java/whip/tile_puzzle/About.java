package whip.tile_puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class About extends AppCompatActivity {

    private Spinner spinner;
    private String selecteditem;
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerAbout);

        imageView = (ImageView) findViewById(R.id.imageView12);

        textView = (TextView) findViewById(R.id.textViewAbout);

        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        final ArrayAdapter<String> adapter;

        if(Locale.getDefault().getLanguage().equals("fi")){
            adapter = new ArrayAdapter<String>(About.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.kuvat));
        } else if (Locale.getDefault().getLanguage().equals("ja")){
            adapter = new ArrayAdapter<String>(About.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ピクチャ));
        } else {
            adapter = new ArrayAdapter<String>(About.this,
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
                            imageView.setImageResource(R.drawable.p1);
                            textView.setText(R.string.p1s);
                            break;
                        case "Kukat":
                            imageView.setImageResource(R.drawable.p5);
                            textView.setText(R.string.p5s);
                            break;
                        case "Kitaristi":
                            imageView.setImageResource(R.drawable.p6);
                            textView.setText(R.string.p6s);
                            break;
                        case "Pyykit":
                            imageView.setImageResource(R.drawable.p9);
                            textView.setText(R.string.p9s);
                            break;
                        case "Fuji vuori":
                            imageView.setImageResource(R.drawable.p3);
                            textView.setText(R.string.p3s);
                            break;
                        case "Temppeli":
                            imageView.setImageResource(R.drawable.p4);
                            textView.setText(R.string.p4s);
                            break;
                        case "Väsynyt palkansaaja":
                            imageView.setImageResource(R.drawable.p8);
                            textView.setText(R.string.p8s);
                            break;
                        case "Rautatieasema":
                            imageView.setImageResource(R.drawable.p2);
                            textView.setText(R.string.p2s);
                            break;
                        case "Myyntiautomaatti":
                            imageView.setImageResource(R.drawable.p7);
                            textView.setText(R.string.p7s);
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
                            imageView.setImageResource(R.drawable.p1);
                            textView.setText(R.string.p1s);
                            break;
                        case "花":
                            imageView.setImageResource(R.drawable.p6);
                            textView.setText(R.string.p6s);
                            break;
                        case "ギタリスト":
                            imageView.setImageResource(R.drawable.p5);
                            textView.setText(R.string.p5s);
                            break;
                        case "ランドリー":
                            imageView.setImageResource(R.drawable.p9);
                            textView.setText(R.string.p9s);
                            break;
                        case "フジ":
                            imageView.setImageResource(R.drawable.p3);
                            textView.setText(R.string.p3s);
                            break;
                        case "寺":
                            imageView.setImageResource(R.drawable.p4);
                            textView.setText(R.string.p4s);
                            break;
                        case "サラリーマン":
                            imageView.setImageResource(R.drawable.p8);
                            textView.setText(R.string.p8s);
                            break;
                        case "鉄道の駅":
                            imageView.setImageResource(R.drawable.p2);
                            textView.setText(R.string.p2s);
                            break;
                        case "自動販売機":
                            imageView.setImageResource(R.drawable.p7);
                            textView.setText(R.string.p7s);
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
                            imageView.setImageResource(R.drawable.p5);
                            textView.setText(R.string.p5s);
                            break;
                        case "Guitarist":
                            imageView.setImageResource(R.drawable.p6);
                            textView.setText(R.string.p6s);
                            break;
                        case "Laundry":
                            imageView.setImageResource(R.drawable.p9);
                            textView.setText(R.string.p9s);
                            break;
                        case "Mount Fuji":
                            imageView.setImageResource(R.drawable.p3);
                            textView.setText(R.string.p3s);
                            break;
                        case "Sunset":
                            imageView.setImageResource(R.drawable.p1);
                            textView.setText(R.string.p1s);
                            break;
                        case "Temple":
                            imageView.setImageResource(R.drawable.p4);
                            textView.setText(R.string.p4s);
                            break;
                        case "Tired salaryman":
                            imageView.setImageResource(R.drawable.p8);
                            textView.setText(R.string.p8s);
                            break;
                        case "Railway station":
                            imageView.setImageResource(R.drawable.p2);
                            textView.setText(R.string.p2s);
                            break;
                        case "Vending Machine":
                            imageView.setImageResource(R.drawable.p7);
                            textView.setText(R.string.p7s);
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
}
