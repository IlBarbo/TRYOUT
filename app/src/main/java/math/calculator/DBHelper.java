package math.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    private  Context context;

    private static final String DATABASE_NAME="cronologiacalc.db";
    private static final String TABLE_NAME="history";
    private static final String ESPRESSIONE ="espressione";
    private static final String RISULTATO ="risultato";
    private static final String ID ="id";
    private  static final int VERSION_NUMBER=1;

    final String CREATE_TABLE =" CREATE TABLE " + TABLE_NAME +" ( " + ESPRESSIONE + "  TEXT , " + RISULTATO + " TEXT, " + ID + " INTEGER primary key AUTOINCREMENT); ";


    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public Boolean insertData(String espressione,String risultato){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("espressione", espressione);
            contentValues.put("risultato", risultato);

            long ris = db.insert(TABLE_NAME, "null", contentValues);
            if (ris == -1) {
                //crea una finestra di dialogo
                Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }

        Cursor readData(){
        String query="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor=null;
        if(db != null){
           cursor= db.rawQuery(query,null);
        }
        return cursor;
        }
    public void deleteData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + TABLE_NAME);
    }
    public void deleteSingleData(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = readData();
        int position=cursor.getPosition();
        db.execSQL("delete from "+ TABLE_NAME + " where " + ID + " =? " + position) ;
        //long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
        /*if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }*/

    }
    }

