package molk.javadrinkup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;



public class DrinksActivity extends Activity {
    public final static String EXTRA_MESSAGE = "molk.javaDrinkUp.MESSAGE";
    // Array of strings storing drink names

    String[] drinks = new String[] {
            "White Russian",
            "P2",
            "Vodka Redbull",
            "Gin & Tonic",
            "Blue Lagoon",
            "Screwdriver",
            "Cuba Libre (Rom & Cola)"
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
    };

    /** Called when the activity is first created. */
    public void startWhiterussian(View view) {
        Intent intent = new Intent(this, WhiterussianActivity.class);
        startActivity(intent);
    }
    public void startP2(View view) {
        Intent intent = new Intent(this, p2Activity.class);
        startActivity(intent);
    }
    public void startRedbullvodka(View view) {
        Intent intent = new Intent(this, RedbullvodkaActivity.class);
        startActivity(intent);
    }
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        String message = getIntent().getStringExtra(DrinksActivity.EXTRA_MESSAGE);
        TextView myTextview = (TextView) findViewById(R.id.search_drink);
        myTextview.setText(message);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Each row in the list stores drink name, info and pic
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<7;i++){
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
        final ListView listView = ( ListView ) findViewById(R.id.drinksListView);

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
                TextView tvDrink = (TextView) linearLayoutChild.getChildAt(0);


                if(tvDrink.getText().toString().equals("White Russian")){
                        startWhiterussian(linearLayoutChild);

                }
                if(tvDrink.getText().toString().equals("P2")){
                    startP2(linearLayoutChild);

                }
                if(tvDrink.getText().toString().equals("Vodka Redbull")){
                    startRedbullvodka(linearLayoutChild);

                }
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
    public void searchTextDrinks(View view) {

        EditText editText = (EditText) findViewById(R.id.search_drink);

        String message = editText.getText().toString().toLowerCase();
        if (message.equals("white russian")||(message.equals("whiterussian"))){
            Intent intent = new Intent(this,WhiterussianActivity.class);
            startActivity(intent);
        }
        if (message.equals("p2")){
            Intent intent = new Intent(this,p2Activity.class);
            startActivity(intent);
        }
        if (message.equals("redbull vodka")||message.equals("redbullvodka")||message.equals("vodka redbull")||message.equals("vodkaredbull")){
            Intent intent = new Intent(this,RedbullvodkaActivity.class);
            startActivity(intent);
        }

    }

}
