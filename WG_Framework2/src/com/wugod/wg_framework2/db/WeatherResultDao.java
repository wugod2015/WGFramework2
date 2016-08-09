package com.wugod.wg_framework2.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.wugod.wg_framework2.bean.WeatherResult;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WEATHER_RESULT".
*/
public class WeatherResultDao extends AbstractDao<WeatherResult, String> {

    public static final String TABLENAME = "WEATHER_RESULT";

    /**
     * Properties of entity WeatherResult.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CurrentCity = new Property(0, String.class, "currentCity", true, "CURRENT_CITY");
        public final static Property Pm25 = new Property(1, String.class, "pm25", false, "PM25");
    };

    private DaoSession daoSession;


    public WeatherResultDao(DaoConfig config) {
        super(config);
    }
    
    public WeatherResultDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WEATHER_RESULT\" (" + //
                "\"CURRENT_CITY\" TEXT PRIMARY KEY NOT NULL ," + // 0: currentCity
                "\"PM25\" TEXT);"); // 1: pm25
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WEATHER_RESULT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, WeatherResult entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getCurrentCity());
 
        String pm25 = entity.getPm25();
        if (pm25 != null) {
            stmt.bindString(2, pm25);
        }
    }

    @Override
    protected void attachEntity(WeatherResult entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public WeatherResult readEntity(Cursor cursor, int offset) {
        WeatherResult entity = new WeatherResult( //
            cursor.getString(offset + 0), // currentCity
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // pm25
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, WeatherResult entity, int offset) {
        entity.setCurrentCity(cursor.getString(offset + 0));
        entity.setPm25(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(WeatherResult entity, long rowId) {
        return entity.getCurrentCity();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(WeatherResult entity) {
        if(entity != null) {
            return entity.getCurrentCity();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}