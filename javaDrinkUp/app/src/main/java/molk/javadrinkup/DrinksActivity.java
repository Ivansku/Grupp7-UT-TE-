package molk.javadrinkup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class DrinksActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }
//Method for list
    public void ListDrinks(View view) {
        ArrayList<String> listItems=new ArrayList<String>();
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
        ListView listView = (ListView) findViewById(R.id.drinksListView);
        listView.setAdapter(adapter);

    }
    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drinks, menu);
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
