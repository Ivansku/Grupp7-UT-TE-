package molk.javadrinkup;

/**
 * Created by Ivan on 2014-12-09.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private SQLiteDatabase database;
    private DatabaseHelper helper;

    private String[] drinkColumns = { "id", "name" };

    public DataSource(Context context) {
        helper = new DatabaseHelper(context);
    }

    public void open() throws SQLiteException {
        database = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    /*
    just recipe things
     */
    public Drink createDrink(String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        long insertId = database.insert(
                DatabaseHelper.TABLE_DRINKS,
                null,
                values);
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_DRINKS,
                drinkColumns,
                "id = " + insertId,
                null, null, null, null
        );
        cursor.moveToFirst();
        Drink drink = cursorToDrink(cursor);
        cursor.close();
        return drink;
    }

    public void deleteDrink(Drink drink) {
        long id = drink.getId();
        database.delete(DatabaseHelper.TABLE_DRINKS, "id = " + id, null);
    }

    private Drink cursorToDrink(Cursor cursor) {
        Drink comment = new Drink();
        comment.setId(cursor.getLong(0));
        comment.setName(cursor.getString(1));
        return comment;
    }

    public List<Drink> getAllDrinks() {
        List<Drink> drinks = new ArrayList<Drink>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_DRINKS,
                drinkColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Drink drink = cursorToDrink(cursor);
            drinks.add(drink);
            cursor.moveToNext();
        }
        cursor.close();
        return drinks;
    }

    public Drink getDrink(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_DRINKS,
                drinkColumns,
                "id = " + id,
                null, null, null, null
        );
        cursor.moveToFirst();
        Drink drink = cursorToDrink(cursor);
        cursor.close();
        return drink;
    }
        /*
        end just recipe things
         */


}

