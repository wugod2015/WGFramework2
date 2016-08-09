package com.wugod.wg_framework2.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.wugod.wg_framework2.bean.Weather;
import com.wugod.wg_framework2.bean.WeatherResult;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "WEATHER".
*/
public class WeatherDao extends AbstractDao<Weather, Long> {

    public static final String TABLENAME = "WEATHER";

    /**
     * Properties of entity Weather.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Date = new Property(1, String.class, "date", false, "DATE");
        public final static Property DayPictureUrl = new Property(2, String.class, "dayPictureUrl", false, "DAY_PICTURE_URL");
        public final static Property NightPictureUrl = new Property(3, String.class, "nightPictureUrl", false, "NIGHT_PICTURE_URL");
        public final static Property Weather = new Property(4, String.class, "weather", false, "WEATHER");
        public final static Property Wind = new Property(5, String.class, "wind", false, "WIND");
        public final static Property Temperature = new Property(6, String.class, "temperature", false, "TEMPERATURE");
        public final static Property CurrentCity = new Property(7, String.class, "currentCity", false, "CURRENT_CITY");
    };

    private DaoSession daoSession;

    private Query<Weather> weatherResult_Weather_dataQuery;

    public WeatherDao(DaoConfig config) {
        super(config);
    }
    
    public WeatherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"WEATHER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DATE\" TEXT NOT NULL ," + // 1: date
                "\"DAY_PICTURE_URL\" TEXT," + // 2: dayPictureUrl
                "\"NIGHT_PICTURE_URL\" TEXT," + // 3: nightPictureUrl
                "\"WEATHER\" TEXT NOT NULL ," + // 4: weather
                "\"WIND\" TEXT," + // 5: wind
                "\"TEMPERATURE\" TEXT," + // 6: temperature
                "\"CURRENT_CITY\" TEXT);"); // 7: currentCity
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"WEATHER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Weather entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getDate());
 
        String dayPictureUrl = entity.getDayPictureUrl();
        if (dayPictureUrl != null) {
            stmt.bindString(3, dayPictureUrl);
        }
 
        String nightPictureUrl = entity.getNightPictureUrl();
        if (nightPictureUrl != null) {
            stmt.bindString(4, nightPictureUrl);
        }
        stmt.bindString(5, entity.getWeather());
 
        String wind = entity.getWind();
        if (wind != null) {
            stmt.bindString(6, wind);
        }
 
        String temperature = entity.getTemperature();
        if (temperature != null) {
            stmt.bindString(7, temperature);
        }
 
        String currentCity = entity.getCurrentCity();
        if (currentCity != null) {
            stmt.bindString(8, currentCity);
        }
    }

    @Override
    protected void attachEntity(Weather entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Weather readEntity(Cursor cursor, int offset) {
        Weather entity = new Weather( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // date
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // dayPictureUrl
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // nightPictureUrl
            cursor.getString(offset + 4), // weather
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // wind
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // temperature
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // currentCity
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Weather entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDate(cursor.getString(offset + 1));
        entity.setDayPictureUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNightPictureUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setWeather(cursor.getString(offset + 4));
        entity.setWind(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTemperature(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCurrentCity(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Weather entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Weather entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "weather_data" to-many relationship of WeatherResult. */
    public List<Weather> _queryWeatherResult_Weather_data(String currentCity) {
        synchronized (this) {
            if (weatherResult_Weather_dataQuery == null) {
                QueryBuilder<Weather> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CurrentCity.eq(null));
                weatherResult_Weather_dataQuery = queryBuilder.build();
            }
        }
        Query<Weather> query = weatherResult_Weather_dataQuery.forCurrentThread();
        query.setParameter(0, currentCity);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getWeatherResultDao().getAllColumns());
            builder.append(" FROM WEATHER T");
            builder.append(" LEFT JOIN WEATHER_RESULT T0 ON T.\"CURRENT_CITY\"=T0.\"CURRENT_CITY\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Weather loadCurrentDeep(Cursor cursor, boolean lock) {
        Weather entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        WeatherResult weatherResult_fk = loadCurrentOther(daoSession.getWeatherResultDao(), cursor, offset);
        entity.setWeatherResult_fk(weatherResult_fk);

        return entity;    
    }

    public Weather loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Weather> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Weather> list = new ArrayList<Weather>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Weather> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Weather> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
