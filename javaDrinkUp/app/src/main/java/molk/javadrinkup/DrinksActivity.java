package molk.javadrinkup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;



public class DrinksActivity extends Activity {
    // Array of strings storing drink names
    String[] drinks = new String[] {
            "Staropramen",
            "Corona",
            "Rom & Cola",
            "Whisky",
            "White Russian",
            "Bulldog IPA",
            "Gin & Tonic",
            "Smirnoff Ice",
            "Breezer",
            "Sake"
    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] pictures = new int[]{
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    // Array of strings to store info
    String[] info = new String[]{
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl",
            "Alkoholhalt: 5% Storlek:50cl"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        // Each row in the list stores drink name, info and pic
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "" + drinks[i]);
            hm.put("inf","Info : " + info[i]);
            hm.put("pic", Integer.toString(pictures[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "pic","txt","inf" };

        // Ids of views in listview_layout
        int[] to = { R.id.pic,R.id.txt,R.id.inf};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_drink_list, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.drinksListView);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        // Item Click Listener for the listview
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                // Getting the Container Layout of the ListView
                LinearLayout linearLayoutParent = (LinearLayout) container;

                // Getting the inner Linear Layout
                LinearLayout linearLayoutChild = (LinearLayout ) linearLayoutParent.getChildAt(1);

                // Getting the Country TextView
                TextView tvCountry = (TextView) linearLayoutChild.getChildAt(0);

                Toast.makeText(getBaseContext(), tvCountry.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        };

        // Setting the item click listener for the listview
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
