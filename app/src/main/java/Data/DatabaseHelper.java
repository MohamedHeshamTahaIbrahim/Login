package Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.UI.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by محمد on 10/02/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME ="signup.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<SignUpModel,String>signupmodelDao=null;
    private RuntimeExceptionDao<SignUpModel, String> signupRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION,R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, SignUpModel.class);
        }
        catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try{
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, SignUpModel.class, true);
            onCreate(database, connectionSource);
        }
        catch (SQLException e){
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVersion + " to new "
                    + newVersion, e);
            throw new RuntimeException(e);
        }
    }
    public Dao<SignUpModel,String>getSignupmodelDao() throws SQLException{
        if (signupmodelDao==null){
       signupmodelDao=getDao(SignUpModel.class);
        }
        return signupmodelDao;
    }
    public RuntimeExceptionDao<SignUpModel,String> getSignupDataDao() {
        if (signupRuntimeDao == null) {
            signupRuntimeDao = getRuntimeExceptionDao(SignUpModel.class);
        }
        return signupRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
        signupmodelDao=null;
        signupRuntimeDao=null;
    }
}
