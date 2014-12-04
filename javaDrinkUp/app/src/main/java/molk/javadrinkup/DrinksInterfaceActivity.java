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
    String urlID;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinksinterface);
        TextView descriptionHeader = (TextView) findViewById(R.id.descriptionHeader);
        TextView descriptionContent = (TextView) findViewById(R.id.descriptionContent);

        int drinkId = getIntent().getIntExtra(DrinksActivity.EXTRA_DRINK_ID, 0);

        if (drinkId == 1) {
            descriptionHeader.setText(getResources().getString(R.string.WhiterussianHead));
            descriptionContent.setText(getResources().getString(R.string.WhiterussianInfo));
            urlID = getString(R.string.linkWhiteRussian);
        } else if (drinkId == 2) {
            descriptionHeader.setText(getResources().getString(R.string.P2Head));
            descriptionContent.setText(getResources().getString(R.string.P2Info));
            urlID = getString(R.string.linkP2);
        }
        else if (drinkId == 3) {
            descriptionHeader.setText(getResources().getString(R.string.VodkaRedbullHead));
            descriptionContent.setText(getResources().getString(R.string.VodkaRedbullInfo));
            urlID = getString(R.string.linkVodkaRedbull);
        }
        else if (drinkId == 4) {
            descriptionHeader.setText(getResources().getString(R.string.GinTonicHead));
            descriptionContent.setText(getResources().getString(R.string.GinTonicInfo));
            urlID = getString(R.string.linkGinTonic);
        }
        else if (drinkId == 5) {
            descriptionHeader.setText(getResources().getString(R.string.BlueLagoonHead));
            descriptionContent.setText(getResources().getString(R.string.BlueLagoonInfo));
            urlID = getString(R.string.linkBlueLagoon);
        }
        else if (drinkId == 6) {
            descriptionHeader.setText(getResources().getString(R.string.ScrewdriverHead));
            descriptionContent.setText(getResources().getString(R.string.ScrewdriverInfo));
            urlID = getString(R.string.linkScrewdriver);
        }
        else if (drinkId == 7) {
            descriptionHeader.setText(getResources().getString(R.string.CubaLibreHead));
            descriptionContent.setText(getResources().getString(R.string.CubaLibreInfo));
            urlID = getString(R.string.linkCubaLibre);
        }
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
    public void startLink(View view) {

        String url = urlID;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
