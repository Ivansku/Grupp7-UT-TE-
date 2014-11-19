package molk.javadrinkup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class RecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipe, menu);
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
    //Method open Drinks tab
    public void startDrinks(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }
    public void startBeer(View view) {
        Intent intent = new Intent(this, BeerActivity.class);
        startActivity(intent);
    }
        //Opens Alkoläsk-tab
    public void startAlksoda(View view) {
        Intent intent = new Intent(this, AlkosodaActivity.class);
        startActivity(intent);
    }
        //Opens Cider-tab
    public void startCider(View view) {
        Intent intent = new Intent(this, CiderActivity.class);
        startActivity(intent);
    }
        //Open Wine-tab
    public void startWine(View view) {
        Intent intent = new Intent(this, WineActivity.class);
        startActivity(intent);
    }

    public void startOther(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }
}
