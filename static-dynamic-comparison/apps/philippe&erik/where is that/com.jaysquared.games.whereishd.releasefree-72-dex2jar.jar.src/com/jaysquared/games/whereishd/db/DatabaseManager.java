package com.jaysquared.games.whereishd.db;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.jaysquared.games.whereishd.utils.SLog;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DatabaseManager
{
  private static final String LOG_TAG = DatabaseManager.class.getSimpleName();
  private DatabaseHelper databaseHelper = null;
  
  private DatabaseHelper getHelper()
  {
    return this.databaseHelper;
  }
  
  public static DatabaseManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public List<Categories> getAllCategories()
  {
    try
    {
      List localList = getHelper().getCategoriesDao().queryForAll();
      return localList;
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
    }
    return null;
  }
  
  public Categories getCategory(String paramString)
  {
    try
    {
      SLog.d(LOG_TAG, "fetch category" + paramString);
      paramString = (Categories)getHelper().getCategoriesDao().queryForId(paramString);
      return paramString;
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public CategoriesUserdata getCategoryUserdata(String paramString)
  {
    SLog.d(LOG_TAG, "db fetch category userdata");
    return getCategory(paramString).getUserdata();
  }
  
  public Locations getLocations(String paramString1, String paramString2)
  {
    SLog.d(LOG_TAG, "db fetch location");
    try
    {
      SLog.d(LOG_TAG, "db query location");
      QueryBuilder localQueryBuilder = getHelper().getLocationsDao().queryBuilder();
      Where localWhere = localQueryBuilder.where();
      localWhere.eq("category_id", paramString1);
      localWhere.and();
      localWhere.eq("uuid", paramString2);
      paramString1 = localQueryBuilder.prepare();
      paramString1 = (Locations)getHelper().getLocationsDao().queryForFirst(paramString1);
      return paramString1;
    }
    catch (SQLException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public long getLocationsCount(String paramString, boolean paramBoolean)
  {
    Object localObject = getCategoryUserdata(paramString);
    int i = ((CategoriesUserdata)localObject).getExclude();
    if (paramBoolean) {
      return ((CategoriesUserdata)localObject).getLocationsTotal();
    }
    try
    {
      localObject = getHelper().getLocationsDao().queryBuilder();
      ((QueryBuilder)localObject).where().eq("category_id", paramString);
      ((QueryBuilder)localObject).orderBy("lasttimestamp", true);
      ((QueryBuilder)localObject).limit(Long.valueOf(10L));
      paramString = getHelper().getLocationsUserdataDao().queryBuilder();
      Where localWhere = paramString.where();
      localWhere.lt("exclude_rights", Integer.valueOf(i));
      localWhere.or();
      localWhere.lt("exclude_rights", Integer.valueOf(2));
      ((QueryBuilder)localObject).setCountOf(true);
      long l = ((QueryBuilder)localObject).join(paramString).countOf();
      SLog.d(LOG_TAG, "db location count: " + l);
      return l;
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public Locations getRandomLearnLocation(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getRandomLocation(paramString);
    }
    int i = getInstance().getCategoryUserdata(paramString).getExclude();
    Object localObject2 = null;
    SLog.d(LOG_TAG, "db load location:" + paramString);
    Object localObject1 = localObject2;
    try
    {
      QueryBuilder localQueryBuilder = getHelper().getLocationsDao().queryBuilder();
      localObject1 = localObject2;
      localQueryBuilder.where().eq("category_id", paramString);
      localObject1 = localObject2;
      localQueryBuilder.orderBy("lasttimestamp", true);
      localObject1 = localObject2;
      paramString = getHelper().getLocationsUserdataDao().queryBuilder();
      localObject1 = localObject2;
      Where localWhere = paramString.where();
      localObject1 = localObject2;
      localWhere.lt("exclude_rights", Integer.valueOf(i));
      localObject1 = localObject2;
      localWhere.or();
      localObject1 = localObject2;
      localWhere.lt("exclude_rights", Integer.valueOf(2));
      localObject1 = localObject2;
      paramString = localQueryBuilder.join(paramString).query();
      localObject1 = localObject2;
      if (paramString.size() > 0)
      {
        localObject1 = localObject2;
        i = new Random().nextInt(paramString.size());
        localObject1 = localObject2;
        SLog.d(LOG_TAG, "db location found random entry: " + i + "(of " + paramString.size() + ")");
        localObject1 = localObject2;
        paramString = (Locations)paramString.get(i);
        localObject1 = paramString;
        paramString.setTimestamp();
        localObject1 = paramString;
        getHelper().getLocationsDao().update(paramString);
        return paramString;
      }
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
      return (Locations)localObject1;
    }
    localObject1 = localObject2;
    SLog.d(LOG_TAG, "db no location found");
    return null;
  }
  
  public Locations getRandomLocation(String paramString)
  {
    Object localObject2 = null;
    SLog.d(LOG_TAG, "db load location:" + paramString);
    Object localObject1 = localObject2;
    try
    {
      QueryBuilder localQueryBuilder = getHelper().getLocationsDao().queryBuilder();
      localObject1 = localObject2;
      Where localWhere = localQueryBuilder.where();
      localObject1 = localObject2;
      SLog.d(LOG_TAG, "db" + paramString);
      localObject1 = localObject2;
      localWhere.eq("category_id", paramString);
      localObject1 = localObject2;
      localQueryBuilder.orderBy("lasttimestamp", true);
      localObject1 = localObject2;
      paramString = localQueryBuilder.prepare();
      localObject1 = localObject2;
      paramString = getHelper().getLocationsDao().query(paramString);
      localObject1 = localObject2;
      if (paramString.size() > 0)
      {
        localObject1 = localObject2;
        int i = new Random().nextInt(paramString.size());
        localObject1 = localObject2;
        SLog.d(LOG_TAG, "db location found random entry: " + i + "(of " + paramString.size() + ")");
        localObject1 = localObject2;
        paramString = (Locations)paramString.get(i);
        localObject1 = paramString;
        paramString.setTimestamp();
        localObject1 = paramString;
        getHelper().getLocationsDao().update(paramString);
        return paramString;
      }
      localObject1 = localObject2;
      SLog.d(LOG_TAG, "db no location found");
      return null;
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
    }
    return (Locations)localObject1;
  }
  
  public void init(Context paramContext)
  {
    if (this.databaseHelper == null) {
      this.databaseHelper = new DatabaseHelper(paramContext);
    }
  }
  
  public void resetCategory(String paramString)
  {
    Object localObject1;
    try
    {
      localObject1 = getHelper().getLocationsDao().queryBuilder();
      ((QueryBuilder)localObject1).where().eq("category_id", paramString);
      localObject1 = ((QueryBuilder)localObject1).prepare();
      localObject1 = getHelper().getLocationsDao().query((PreparedQuery)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Locations)((Iterator)localObject1).next()).getUserdata();
        ((LocationsUserdata)localObject2).resetLocation();
        getInstance().updateLocationUserdata((LocationsUserdata)localObject2);
      }
      localObject1 = getInstance().getCategory(paramString);
    }
    catch (SQLException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramString = getInstance().getCategoryUserdata(paramString);
    Object localObject2 = new CategoriesUserdata();
    ((CategoriesUserdata)localObject2).setDistanceFactor((int)(((Categories)localObject1).getTreshold().doubleValue() / 1000.0D));
    ((CategoriesUserdata)localObject2).setCategory_id(((Categories)localObject1).getUuid());
    ((CategoriesUserdata)localObject2).setLocationsTotal(paramString.getLocationsTotal());
    ((Categories)localObject1).setUserdata((CategoriesUserdata)localObject2);
    getHelper().getCategoriesUserdataDao().create(localObject2);
    getHelper().getCategoriesUserdataDao().update(localObject2);
    getHelper().getCategoriesDao().update(localObject1);
  }
  
  public void updateCategoryUserdata(CategoriesUserdata paramCategoriesUserdata)
  {
    try
    {
      getHelper().getCategoriesUserdataDao().update(paramCategoriesUserdata);
      return;
    }
    catch (SQLException paramCategoriesUserdata)
    {
      paramCategoriesUserdata.printStackTrace();
    }
  }
  
  public void updateLocation(Locations paramLocations)
  {
    try
    {
      getHelper().getLocationsDao().update(paramLocations);
      return;
    }
    catch (SQLException paramLocations)
    {
      paramLocations.printStackTrace();
    }
  }
  
  public void updateLocationUserdata(LocationsUserdata paramLocationsUserdata)
  {
    try
    {
      getHelper().getLocationsUserdataDao().update(paramLocationsUserdata);
      return;
    }
    catch (SQLException paramLocationsUserdata)
    {
      paramLocationsUserdata.printStackTrace();
    }
  }
  
  private static class SingletonHolder
  {
    private static final DatabaseManager INSTANCE = new DatabaseManager(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/DatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */