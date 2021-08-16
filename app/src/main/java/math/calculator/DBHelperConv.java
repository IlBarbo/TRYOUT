package math.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelperConv extends SQLiteOpenHelper {
    private final Context context;

    private static final String DATABASE_NAME="convertitorecron.db";
    private static final String TABLE_NAME="convhistory";
    private static final String FROMNUM ="fromnum";
    private static final String TONUM ="tonum";
    private static final String SPINNERFROM ="spinnerfrom";
    private static final String SPINNERTO ="spinnerto";
    private static final String ID ="id";

    private  static final int VERSION_NUMBER=1;
    final String CREATE_TABLE= " CREATE TABLE " + TABLE_NAME + " ( " + FROMNUM + " TEXT , " + TONUM + " TEXT , " + SPINNERFROM + " TEXT, " + SPINNERTO + " TEXT, " + ID + " INTEGER primary key AUTOINCREMENT); ";


    public DBHelperConv(Context context) {
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


    public Boolean insertDataConv(String fromnum, String tonum,String spinnerfrom,String spinnerto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fromnum", fromnum);
        contentValues.put("tonum", tonum);
        contentValues.put("spinnerfrom", spinnerfrom);
        contentValues.put("spinnerto", spinnerto);
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
    public void deleteSingleData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(" delete from " + TABLE_NAME + " where  id = " + id);

    }


}
