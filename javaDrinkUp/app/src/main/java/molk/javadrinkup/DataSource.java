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

    private String[] recipeColumns = { "id", "name" };
    private String[] ingredientColumns= { "id", "ingredient" };

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
    public Drinks createRecipe(String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        long insertId = database.insert(
                DatabaseHelper.TABLE_RECIPES,
                null,
                values);
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_RECIPES,
                recipeColumns,
                "id = " + insertId,
                null, null, null, null
        );
        cursor.moveToFirst();
        Drinks recipe = cursorToRecipe(cursor);
        cursor.close();
        return recipe;
    }

    public void deleteRecipe(Drinks recipe) {
        long id = recipe.getId();
        database.delete(DatabaseHelper.TABLE_RECIPES, "id = " + id, null);
    }

    private Drinks cursorToRecipe(Cursor cursor) {
        Drinks comment = new Drinks();
        comment.setId(cursor.getLong(0));
        comment.setName(cursor.getString(1));
        return comment;
    }

    public List<Drinks> getAllRecipes() {
        List<Drinks> recipes = new ArrayList<Drinks>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_RECIPES,
                recipeColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Drinks recipe = cursorToRecipe(cursor);
            recipes.add(recipe);
            cursor.moveToNext();
        }
        cursor.close();
        return recipes;
    }

    public Drinks getRecipe(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_RECIPES,
                recipeColumns,
                "id = " + id,
                null, null, null, null
        );
        cursor.moveToFirst();
        Drinks recipe = cursorToRecipe(cursor);
        cursor.close();
        return recipe;
    }
        /*
        end just recipe things
         */

    /*
    start just ingredient things
     */
    public Content createIngredient(String name, Drinks recipe) {
        ContentValues values = new ContentValues();
        values.put("ingredient", name);
        values.put("recipe_id", recipe.getId());
        long insertId = database.insert(
                DatabaseHelper.TABLE_INGREDIENTS,
                null,
                values);
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                "id = " + insertId,
                null, null, null, null
        );
        cursor.moveToFirst();
        Content ingredient = cursorToIngredient(cursor);
        cursor.close();
        return ingredient;
    }

    public void deleteIngredient(Content ingredient) {
        long id = ingredient.getId();
        database.delete(DatabaseHelper.TABLE_INGREDIENTS, "id = " + id, null);
    }

    private Content cursorToIngredient(Cursor cursor) {
        Content comment = new Content();
        comment.setId(cursor.getLong(0));
        comment.setIngredient(cursor.getString(1));
        return comment;
    }

    public List<Content> getAllIngredients() {
        List<Content> ingredients = new ArrayList<Content>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Content ingredient = cursorToIngredient(cursor);
            ingredients.add(ingredient);
            cursor.moveToNext();
        }
        cursor.close();
        return ingredients;
    }

    public Content getIngredient(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                "id = " + id,
                null, null, null, null
        );
        cursor.moveToFirst();
        Content ingredient = cursorToIngredient(cursor);
        cursor.close();
        return ingredient;
    }
    /*
    end just ingredient things
     */
    public List<Content> getIngredientsForRecipe(Drinks recipe) {
        List<Content> ingredients = new ArrayList<Content>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                "recipe_id =" + recipe.getId(),
                null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Content ingredient = cursorToIngredient(cursor);
            ingredients.add(ingredient);
            cursor.moveToNext();
        }
        cursor.close();
        return ingredients;
    }
}

