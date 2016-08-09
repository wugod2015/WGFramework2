package com.wugod.wg_framework2.bean;

import com.wugod.wg_framework2.db.DaoSession;
import com.wugod.wg_framework2.db.WeatherDao;
import com.wugod.wg_framework2.db.WeatherResultDao;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "WEATHER".
 */
public class Weather implements java.io.Serializable {

    private Long id;
    /** Not-null value. */
    private String date;
    private String dayPictureUrl;
    private String nightPictureUrl;
    /** Not-null value. */
    private String weather;
    private String wind;
    private String temperature;
    private String currentCity;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient WeatherDao myDao;

    private WeatherResult weatherResult_fk;
    private String weatherResult_fk__resolvedKey;


    public Weather() {
    }

    public Weather(Long id) {
        this.id = id;
    }

    public Weather(Long id, String date, String dayPictureUrl, String nightPictureUrl, String weather, String wind, String temperature, String currentCity) {
        this.id = id;
        this.date = date;
        this.dayPictureUrl = dayPictureUrl;
        this.nightPictureUrl = nightPictureUrl;
        this.weather = weather;
        this.wind = wind;
        this.temperature = temperature;
        this.currentCity = currentCity;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeatherDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getDate() {
        return date;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDate(String date) {
        this.date = date;
    }

    public String getDayPictureUrl() {
        return dayPictureUrl;
    }

    public void setDayPictureUrl(String dayPictureUrl) {
        this.dayPictureUrl = dayPictureUrl;
    }

    public String getNightPictureUrl() {
        return nightPictureUrl;
    }

    public void setNightPictureUrl(String nightPictureUrl) {
        this.nightPictureUrl = nightPictureUrl;
    }

    /** Not-null value. */
    public String getWeather() {
        return weather;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    /** To-one relationship, resolved on first access. */
    public WeatherResult getWeatherResult_fk() {
        String __key = this.currentCity;
        if (weatherResult_fk__resolvedKey == null || weatherResult_fk__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WeatherResultDao targetDao = daoSession.getWeatherResultDao();
            WeatherResult weatherResult_fkNew = targetDao.load(__key);
            synchronized (this) {
                weatherResult_fk = weatherResult_fkNew;
            	weatherResult_fk__resolvedKey = __key;
            }
        }
        return weatherResult_fk;
    }

    public void setWeatherResult_fk(WeatherResult weatherResult_fk) {
        synchronized (this) {
            this.weatherResult_fk = weatherResult_fk;
            currentCity = weatherResult_fk == null ? null : weatherResult_fk.getCurrentCity();
            weatherResult_fk__resolvedKey = currentCity;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}