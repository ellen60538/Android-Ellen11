package tw.org.iii.ellen.ellen11;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db ;
    private MyHelper myHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new MyHelper(this, "iii", null, 1) ;
        db = myHelper.getReadableDatabase() ;


    }

    public void query(View view) {
        // SELECT * FROM cust
        Cursor cursor = db.query("cust",null,
                                null,null,
                                null,null,null) ;
        Log.v("ellen","col count" + cursor.getColumnCount()) ;
        while (cursor.moveToNext()){
            String id = cursor.getString(0) ;
            Log.v("ellen","id =" + id) ;
        }
    }

    public void insert(View view) {
        db.execSQL("INSERT INTO cust (cname, tel, birthday) VALUES ('Ellen','123','1999-01-01')") ;
        query(null) ;

    }
}
