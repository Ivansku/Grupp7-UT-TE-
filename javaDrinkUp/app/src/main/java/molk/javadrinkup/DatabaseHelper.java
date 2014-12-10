package molk.javadrinkup;

/**
 * Created by Ivan on 2014-12-09.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_INGREDIENTS = "ingredients";
    public static final String TABLE_RECIPES = "recipes";
    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_NAME = "recipes.db";

    private static final String TABLE_RECIPES_CREATE = "CREATE TABLE `recipes` (\n" +
            "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT NOT NULL\n" +
            ");";
    private static final String TABLE_INGREDIENTS_CREATE = "CREATE TABLE `ingredients` (\n" +
            "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`ingredient`\tTEXT NOT NULL,\n" +
            "recipe_id INTEGER" +
            ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_RECIPES_CREATE);
        database.execSQL(TABLE_INGREDIENTS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INGREDIENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }

}

