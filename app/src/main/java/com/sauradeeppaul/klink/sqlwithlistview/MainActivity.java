package com.sauradeeppaul.klink.sqlwithlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity{

    static final String[] PENS = new String[]{
            "MONT Blanc",
            "Gucci",
            "Parker",
            "Sailor",
            "Porsche Design",
            "Rotring",
            "Sheaffer",
            "Waterman",
            "Hello",
            "Damn",
            "lol",
            "trials",
            "check",
            "bugs"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PENS));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object object = this.getListAdapter().getItem(position);
        String pen = object.toString();
        Toast.makeText(this, "You have chosen the pen: " + " " + pen, Toast.LENGTH_SHORT).show();
    }
}
