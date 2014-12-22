package molk.javadrinkup;

/**
 * Created by Ivan on 2014-12-09.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_DRINKS = "drinks";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "drinks.db";

    private static final String TABLE_DRINKS_CREATE = "CREATE TABLE `drinks` (\n" +
            "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`category`\tINTEGER,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`info`\tTEXT,\n" +
            "\t`url`\tTEXT,\n" +
            "\t`image_resource`\tINTEGER\n" +
            ");";

    private static final String TABLE_DRINKS_INITIAL_CONTENT = "INSERT INTO `drinks` VALUES ('1','1','P2','Alkoholhalt: 5,0 %\n" +
            "Användning: Partydrink\n" +
            "Smak: Syrlig spritdryck\n" +
            "Färg: En vattenklar färg med nyanser av grönt\n" +
            "Råvaror: Vaniljvodka, Sourz Sour Apple, Limejuice och fruktsoda','http://www.dricka.se/drinkar/p2/','1');\n" +
            "INSERT INTO `drinks` VALUES ('2','1','White Russian','Alkoholhalt: 5,0 %\n" +
            "Användning: Partydrink som passar när det är varmt ute\n" +
            "Smak: Sötsmakad choklad med en hint av spritsmak\n" +
            "Färg: En blandning av brun och vit färg\n" +
            "Råvaror: Vodka, Kahlúa och Mjölk\n" +
            "','http://www.dricka.se/drinkar/white-russian/','1');\n";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_DRINKS_CREATE);

        // Add initial data
        database.execSQL(TABLE_DRINKS_INITIAL_CONTENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRINKS);
        onCreate(db);
    }

}

