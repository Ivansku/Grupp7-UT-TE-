package molk.javadrinkup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class OtherActivity extends Activity {
    ArrayList<String> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }
    //Method for list
    public void ListOther(View view) {

        listItems =new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, listItems);
        //Adds Items in ListView-list.
        listItems.add("Staropramen");
        listItems.add("Corona");
        listItems.add("White Russian");
        listItems.add("Smirnoff Ice");
        listItems.add("Breezer");
        listItems.add("Rom & Cola");
        listItems.add("Gin & Tonic");
        //Print list
        ListView listView = (ListView) findViewById(R.id.otherListView);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}