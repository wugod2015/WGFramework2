package com.wugod.wg_framework2.db;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;

import com.wugod.wg_framework2.bean.Movie;
import com.wugod.wg_framework2.bean.Weather;
import com.wugod.wg_framework2.bean.WeatherResult;
import com.wugod.wg_framework2.bean.Weather_Index;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig movieDaoConfig;
    private final DaoConfig weatherResultDaoConfig;
    private final DaoConfig weatherDaoConfig;
    private final DaoConfig weather_IndexDaoConfig;

    private final MovieDao movieDao;
    private final WeatherResultDao weatherResultDao;
    private final WeatherDao weatherDao;
    private final Weather_IndexDao weather_IndexDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        movieDaoConfig = daoConfigMap.get(MovieDao.class).clone();
        movieDaoConfig.initIdentityScope(type);

        weatherResultDaoConfig = daoConfigMap.get(WeatherResultDao.class).clone();
        weatherResultDaoConfig.initIdentityScope(type);

        weatherDaoConfig = daoConfigMap.get(WeatherDao.class).clone();
        weatherDaoConfig.initIdentityScope(type);

        weather_IndexDaoConfig = daoConfigMap.get(Weather_IndexDao.class).clone();
        weather_IndexDaoConfig.initIdentityScope(type);

        movieDao = new MovieDao(movieDaoConfig, this);
        weatherResultDao = new WeatherResultDao(weatherResultDaoConfig, this);
        weatherDao = new WeatherDao(weatherDaoConfig, this);
        weather_IndexDao = new Weather_IndexDao(weather_IndexDaoConfig, this);

        registerDao(Movie.class, movieDao);
        registerDao(WeatherResult.class, weatherResultDao);
        registerDao(Weather.class, weatherDao);
        registerDao(Weather_Index.class, weather_IndexDao);
    }
    
    public void clear() {
        movieDaoConfig.getIdentityScope().clear();
        weatherResultDaoConfig.getIdentityScope().clear();
        weatherDaoConfig.getIdentityScope().clear();
        weather_IndexDaoConfig.getIdentityScope().clear();
    }

    public MovieDao getMovieDao() {
        return movieDao;
    }

    public WeatherResultDao getWeatherResultDao() {
        return weatherResultDao;
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }

    public Weather_IndexDao getWeather_IndexDao() {
        return weather_IndexDao;
    }

}
