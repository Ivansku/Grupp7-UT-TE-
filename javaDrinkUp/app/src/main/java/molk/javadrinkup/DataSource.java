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
    public Recipe createRecipe(String name) {
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
        Recipe recipe = cursorToRecipe(cursor);
        cursor.close();
        return recipe;
    }

    public void deleteRecipe(Recipe recipe) {
        long id = recipe.getId();
        database.delete(DatabaseHelper.TABLE_RECIPES, "id = " + id, null);
    }

    private Recipe cursorToRecipe(Cursor cursor) {
        Recipe comment = new Recipe();
        comment.setId(cursor.getLong(0));
        comment.setName(cursor.getString(1));
        return comment;
    }

    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_RECIPES,
                recipeColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Recipe recipe = cursorToRecipe(cursor);
            recipes.add(recipe);
            cursor.moveToNext();
        }
        cursor.close();
        return recipes;
    }

    public Recipe getRecipe(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_RECIPES,
                recipeColumns,
                "id = " + id,
                null, null, null, null
        );
        cursor.moveToFirst();
        Recipe recipe = cursorToRecipe(cursor);
        cursor.close();
        return recipe;
    }
        /*
        end just recipe things
         */

    /*
    start just ingredient things
     */
    public Ingredient createIngredient(String name, Recipe recipe) {
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
        Ingredient ingredient = cursorToIngredient(cursor);
        cursor.close();
        return ingredient;
    }

    public void deleteIngredient(Ingredient ingredient) {
        long id = ingredient.getId();
        database.delete(DatabaseHelper.TABLE_INGREDIENTS, "id = " + id, null);
    }

    private Ingredient cursorToIngredient(Cursor cursor) {
        Ingredient comment = new Ingredient();
        comment.setId(cursor.getLong(0));
        comment.setIngredient(cursor.getString(1));
        return comment;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ingredient ingredient = cursorToIngredient(cursor);
            ingredients.add(ingredient);
            cursor.moveToNext();
        }
        cursor.close();
        return ingredients;
    }

    public Ingredient getIngredient(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                "id = " + id,
                null, null, null, null
        );
        cursor.moveToFirst();
        Ingredient ingredient = cursorToIngredient(cursor);
        cursor.close();
        return ingredient;
    }
    /*
    end just ingredient things
     */
    public List<Ingredient> getIngredientsForRecipe(Recipe recipe) {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_INGREDIENTS,
                ingredientColumns,
                "recipe_id =" + recipe.getId(),
                null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ingredient ingredient = cursorToIngredient(cursor);
            ingredients.add(ingredient);
            cursor.moveToNext();
        }
        cursor.close();
        return ingredients;
    }
}

