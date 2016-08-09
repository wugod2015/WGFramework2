package com.wugod.wg_framework2.bean;

import com.wugod.wg_framework2.db.DaoSession;
import com.wugod.wg_framework2.db.WeatherResultDao;
import com.wugod.wg_framework2.db.Weather_IndexDao;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "WEATHER__INDEX".
 */
public class Weather_Index {

    private Long id;
    /** Not-null value. */
    private String title;
    private String zs;
    private String tipt;
    private String des;
    private String currentCity;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient Weather_IndexDao myDao;

    private WeatherResult weatherResult_fk;
    private String weatherResult_fk__resolvedKey;


    public Weather_Index() {
    }

    public Weather_Index(Long id) {
        this.id = id;
    }

    public Weather_Index(Long id, String title, String zs, String tipt, String des, String currentCity) {
        this.id = id;
        this.title = title;
        this.zs = zs;
        this.tipt = tipt;
        this.des = des;
        this.currentCity = currentCity;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeather_IndexDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    public String getTipt() {
        return tipt;
    }

    public void setTipt(String tipt) {
        this.tipt = tipt;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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
