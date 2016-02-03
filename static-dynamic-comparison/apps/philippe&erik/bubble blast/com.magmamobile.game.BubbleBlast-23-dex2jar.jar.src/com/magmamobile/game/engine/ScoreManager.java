package com.magmamobile.game.engine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import java.io.File;

public final class ScoreManager
{
  private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS scores (user TEXT,score REAL,mode INTEGER,time INTEGER);";
  private static final String SQL_FILE = "scores";
  private static final String SQL_INSERT = "INSERT INTO scores (user,score,mode,time) VALUES (%s,%s,%s,%s);";
  private static final String SQL_SELECT1 = "SELECT user,score FROM scores WHERE mode=%s ORDER BY score %s LIMIT %s;";
  private static Context _context;
  private static SQLiteDatabase _database;
  private static ScoreFormater _formater;
  private static int _mode;
  private static int _pageSize;
  private static Sorting _sort;
  private static String _user;
  
  public static SQLiteDatabase getDatabase()
  {
    return _database;
  }
  
  public static File getDatabaseFile()
  {
    return _context.getDatabasePath("scores");
  }
  
  public static ScoreFormater getFormater()
  {
    return _formater;
  }
  
  public static int getMode()
  {
    return _mode;
  }
  
  public static int getPageSize()
  {
    return _pageSize;
  }
  
  public static ScoreItem getScore()
  {
    Object localObject1 = String.format("SELECT user,score FROM scores WHERE mode=%s ORDER BY score %s LIMIT %s;", new Object[] { toSQL(_mode), getSorting(), Integer.valueOf(1) });
    Cursor localCursor = _database.rawQuery((String)localObject1, null);
    localObject1 = null;
    Object localObject2 = null;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToFirst())
      {
        localObject1 = new ScoreItem();
        ((ScoreItem)localObject1).pos = 1;
        ((ScoreItem)localObject1).user = localCursor.getString(0);
        ((ScoreItem)localObject1).score = localCursor.getDouble(1);
        ((ScoreItem)localObject1).mine = _user.equals(((ScoreItem)localObject1).user);
        if (_formater == null) {
          break label133;
        }
        _formater.onFormat((ScoreItem)localObject1);
      }
    }
    for (;;)
    {
      localCursor.close();
      return (ScoreItem)localObject1;
      label133:
      ((ScoreItem)localObject1).sScore = String.valueOf(((ScoreItem)localObject1).score);
      ((ScoreItem)localObject1).sUser = String.valueOf(1).concat(" ").concat(((ScoreItem)localObject1).user);
    }
  }
  
  public static ScoreList getScores()
  {
    localScoreList = new ScoreList();
    try
    {
      Object localObject = String.format("SELECT user,score FROM scores WHERE mode=%s ORDER BY score %s LIMIT %s;", new Object[] { toSQL(_mode), getSorting(), Integer.valueOf(_pageSize) });
      localObject = _database.rawQuery((String)localObject, null);
      int i;
      ScoreItem localScoreItem;
      if (((Cursor)localObject).moveToFirst())
      {
        i = 1;
        localScoreItem = new ScoreItem();
        localScoreItem.pos = i;
        localScoreItem.user = ((Cursor)localObject).getString(0);
        localScoreItem.score = ((Cursor)localObject).getDouble(1);
        localScoreItem.mine = _user.equals(localScoreItem.user);
        if (_formater == null) {
          break label154;
        }
        _formater.onFormat(localScoreItem);
      }
      for (;;)
      {
        localScoreList.add(localScoreItem);
        i += 1;
        if (((Cursor)localObject).moveToNext()) {
          break;
        }
        ((Cursor)localObject).close();
        return localScoreList;
        label154:
        localScoreItem.sScore = String.valueOf(localScoreItem.score);
        localScoreItem.sUser = String.valueOf(i).concat(" ").concat(localScoreItem.user);
      }
      return localScoreList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Sorting getSort()
  {
    return _sort;
  }
  
  private static String getSorting()
  {
    if (_sort == Sorting.ascending) {
      return "ASC";
    }
    return "DESC";
  }
  
  public static String getUser()
  {
    return _user;
  }
  
  public static void setFormater(ScoreFormater paramScoreFormater)
  {
    _formater = paramScoreFormater;
  }
  
  public static void setMode(int paramInt)
  {
    _mode = paramInt;
  }
  
  public static void setPageSize(int paramInt)
  {
    _pageSize = paramInt;
  }
  
  public static void setSort(Sorting paramSorting)
  {
    _sort = paramSorting;
  }
  
  public static void setUser(String paramString)
  {
    _user = paramString;
  }
  
  public static void start(Context paramContext)
  {
    stop();
    _mode = 0;
    _pageSize = 100;
    _user = "Me";
    _context = paramContext;
    _sort = Sorting.ascending;
    _database = SQLiteDatabase.openOrCreateDatabase(getDatabaseFile(), null);
    _database.execSQL("CREATE TABLE IF NOT EXISTS scores (user TEXT,score REAL,mode INTEGER,time INTEGER);");
  }
  
  public static void stop()
  {
    if (_database == null) {
      return;
    }
    _database.close();
    _database = null;
    _context = null;
  }
  
  public static void submitScore(double paramDouble)
  {
    try
    {
      String str = String.format("INSERT INTO scores (user,score,mode,time) VALUES (%s,%s,%s,%s);", new Object[] { toSQL(_user), toSQL(paramDouble), toSQL(_mode), toSQL(SystemClock.elapsedRealtime()) });
      _database.execSQL(str);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void submitScore(int paramInt, double paramDouble)
  {
    try
    {
      setMode(paramInt);
      String str = String.format("INSERT INTO scores (user,score,mode,time) VALUES (%s,%s,%s,%s);", new Object[] { toSQL(_user), toSQL(paramDouble), toSQL(_mode), toSQL(SystemClock.elapsedRealtime()) });
      _database.execSQL(str);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static String toSQL(double paramDouble)
  {
    return String.valueOf(paramDouble);
  }
  
  private static String toSQL(long paramLong)
  {
    return String.valueOf(paramLong);
  }
  
  private static String toSQL(String paramString)
  {
    return "'".concat(paramString.replace("'", "''")).concat("'");
  }
  
  public static class BaseFormater
    implements ScoreManager.ScoreFormater
  {
    public void onFormat(ScoreItem paramScoreItem) {}
  }
  
  public static abstract interface ScoreFormater
  {
    public abstract void onFormat(ScoreItem paramScoreItem);
  }
  
  public static enum Sorting
  {
    ascending,  descending;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ScoreManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */