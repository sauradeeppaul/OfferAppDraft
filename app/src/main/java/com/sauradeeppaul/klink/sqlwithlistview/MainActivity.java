package com.sauradeeppaul.klink.sqlwithlistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


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
            "bugs",
            "Local"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setListAdapter(new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, PENS));

        setListAdapter(new ArrayAdapter(
                this,android.R.layout.simple_list_item_1,
                this.populate()));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object object = this.getListAdapter().getItem(position);
        String pen = object.toString();
        Toast.makeText(this, "You have chosen the pen: " + " " + pen, Toast.LENGTH_SHORT).show();
    }

    private ArrayList<String> populate() {
        ArrayList<String> items = new ArrayList<String>();

        try {
            URL url = new URL
                    ("http://api.myjson.com/bins/37xva");
            HttpURLConnection urlConnection =
                    (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // gets the server json data
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            urlConnection.getInputStream()));
            String next;
            while ((next = bufferedReader.readLine()) != null){
                JSONArray ja = new JSONArray(next);

                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = (JSONObject) ja.get(i);
                    items.add(jo.getString("text"));
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return items;
    }
}
