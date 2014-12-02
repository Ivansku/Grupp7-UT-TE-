package molk.javadrinkup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DrinksInterfaceActivity extends DrinksActivity {


    /*/public DrinksInterfaceActivity(int ID){
        super();
        //Gör databas
        //Select From Drinks(bas)where ID = X
        //SQL LITE
    }
    /*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinksinterface);
        DrinksActivity hej = new DrinksActivity();
        TextView descriptionHeader = (TextView) findViewById(R.id.descriptionHeader);
        TextView descriptionContent = (TextView) findViewById(R.id.descriptionContent);

        descriptionHeader.setText(getResources().getString(R.string.WhiterussianHead));
        descriptionContent.setText(getResources().getString(R.string.WhiterussianInfo));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void startSystem(View view) {

        String url = getResources().getString(R.string.linkStaropramen);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
