package whip.tile_puzzle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * CustomAdapter luokka
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<Button> mButtons;
    private int m_ColumnWidth, m_ColumnHeight;

    /**
     * @param buttons
     * @param columnWidth
     * @param columnHeight
     */
    public CustomAdapter(ArrayList<Button> buttons, int columnWidth, int columnHeight) {
        mButtons = buttons;
        m_ColumnWidth = columnWidth;
        m_ColumnHeight = columnHeight;
    }

    /**
     * @return
     */
    @Override
    public int getCount() {
        return mButtons.size();
    }

    /**
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {return (Object) mButtons.get(position);}

    /**
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;

        if (convertView == null) {
            button = mButtons.get(position);
        } else {
            button = (Button) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(m_ColumnWidth, m_ColumnHeight);
        button.setLayoutParams(params);

        return button;
    }
}