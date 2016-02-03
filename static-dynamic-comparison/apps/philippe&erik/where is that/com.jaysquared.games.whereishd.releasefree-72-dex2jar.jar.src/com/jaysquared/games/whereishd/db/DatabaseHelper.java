package com.jaysquared.games.whereishd.db;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jaysquared.games.whereishd.utils.SLog;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class DatabaseHelper
  extends OrmLiteSqliteOpenHelper
{
  public static final String DATABASE_NAME = "jaysquared.sqlite";
  private static final int DATABASE_VERSION = 20;
  private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();
  private Dao<Categories, String> categoriesDao = null;
  private Dao<CategoriesUserdata, String> categoriesUserdataDao = null;
  private final Context context;
  private Dao<Locations, String> locationsDao = null;
  private Dao<LocationsUserdata, String> locationsUserdataDao = null;
  
  public DatabaseHelper(Context paramContext)
  {
    super(paramContext, "jaysquared.sqlite", null, 20);
    this.context = paramContext;
  }
  
  /* Error */
  private void updateCategories()
  {
    // Byte code:
    //   0: getstatic 33	com/jaysquared/games/whereishd/db/DatabaseHelper:LOG_TAG	Ljava/lang/String;
    //   3: ldc 56
    //   5: invokestatic 62	com/jaysquared/games/whereishd/utils/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 64	java/io/DataInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 49	com/jaysquared/games/whereishd/db/DatabaseHelper:context	Landroid/content/Context;
    //   16: invokevirtual 70	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: ldc 71
    //   21: invokevirtual 77	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   24: invokespecial 80	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_1
    //   28: new 82	java/io/BufferedReader
    //   31: dup
    //   32: new 84	java/io/InputStreamReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 85	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: sipush 8192
    //   43: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +215 -> 268
    //   56: getstatic 33	com/jaysquared/games/whereishd/db/DatabaseHelper:LOG_TAG	Ljava/lang/String;
    //   59: new 93	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   66: ldc 97
    //   68: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_3
    //   72: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 62	com/jaysquared/games/whereishd/utils/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_3
    //   82: ifnull -35 -> 47
    //   85: aload_3
    //   86: invokevirtual 110	java/lang/String:length	()I
    //   89: ifle -42 -> 47
    //   92: aload_0
    //   93: invokevirtual 114	com/jaysquared/games/whereishd/db/DatabaseHelper:getCategoriesDao	()Lcom/j256/ormlite/dao/Dao;
    //   96: aload_3
    //   97: iconst_0
    //   98: anewarray 106	java/lang/String
    //   101: invokeinterface 120 3 0
    //   106: pop
    //   107: goto -60 -> 47
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   115: aload_0
    //   116: invokevirtual 114	com/jaysquared/games/whereishd/db/DatabaseHelper:getCategoriesDao	()Lcom/j256/ormlite/dao/Dao;
    //   119: invokeinterface 127 1 0
    //   124: astore_1
    //   125: aload_1
    //   126: invokeinterface 133 1 0
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 139 1 0
    //   138: ifeq +145 -> 283
    //   141: aload_2
    //   142: invokeinterface 143 1 0
    //   147: checkcast 145	com/jaysquared/games/whereishd/db/Categories
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 149	com/jaysquared/games/whereishd/db/Categories:getUserdata	()Lcom/jaysquared/games/whereishd/db/CategoriesUserdata;
    //   155: ifnonnull -23 -> 132
    //   158: new 151	com/jaysquared/games/whereishd/db/CategoriesUserdata
    //   161: dup
    //   162: invokespecial 152	com/jaysquared/games/whereishd/db/CategoriesUserdata:<init>	()V
    //   165: astore 4
    //   167: aload 4
    //   169: aload_3
    //   170: invokevirtual 155	com/jaysquared/games/whereishd/db/Categories:getUuid	()Ljava/lang/String;
    //   173: invokevirtual 159	com/jaysquared/games/whereishd/db/CategoriesUserdata:setCategory_id	(Ljava/lang/String;)V
    //   176: getstatic 33	com/jaysquared/games/whereishd/db/DatabaseHelper:LOG_TAG	Ljava/lang/String;
    //   179: new 93	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   186: ldc -95
    //   188: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_3
    //   192: invokevirtual 165	com/jaysquared/games/whereishd/db/Categories:getTreshold	()Ljava/lang/Double;
    //   195: invokevirtual 170	java/lang/Double:intValue	()I
    //   198: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 62	com/jaysquared/games/whereishd/utils/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload 4
    //   209: aload_3
    //   210: invokevirtual 165	com/jaysquared/games/whereishd/db/Categories:getTreshold	()Ljava/lang/Double;
    //   213: invokevirtual 177	java/lang/Double:doubleValue	()D
    //   216: ldc2_w 178
    //   219: ddiv
    //   220: d2i
    //   221: invokevirtual 183	com/jaysquared/games/whereishd/db/CategoriesUserdata:setDistanceFactor	(I)V
    //   224: aload_3
    //   225: aload 4
    //   227: invokevirtual 187	com/jaysquared/games/whereishd/db/Categories:setUserdata	(Lcom/jaysquared/games/whereishd/db/CategoriesUserdata;)V
    //   230: aload_0
    //   231: invokevirtual 190	com/jaysquared/games/whereishd/db/DatabaseHelper:getCategoriesUserdataDao	()Lcom/j256/ormlite/dao/Dao;
    //   234: aload 4
    //   236: invokeinterface 194 2 0
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 114	com/jaysquared/games/whereishd/db/DatabaseHelper:getCategoriesDao	()Lcom/j256/ormlite/dao/Dao;
    //   246: aload_3
    //   247: invokeinterface 197 2 0
    //   252: pop
    //   253: goto -121 -> 132
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 198	java/sql/SQLException:printStackTrace	()V
    //   261: aload_1
    //   262: invokeinterface 201 1 0
    //   267: return
    //   268: aload_1
    //   269: invokevirtual 202	java/io/DataInputStream:close	()V
    //   272: goto -157 -> 115
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 198	java/sql/SQLException:printStackTrace	()V
    //   280: goto -165 -> 115
    //   283: aload_1
    //   284: invokeinterface 201 1 0
    //   289: return
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 198	java/sql/SQLException:printStackTrace	()V
    //   295: return
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 198	java/sql/SQLException:printStackTrace	()V
    //   301: return
    //   302: astore_2
    //   303: aload_1
    //   304: invokeinterface 201 1 0
    //   309: aload_2
    //   310: athrow
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual 198	java/sql/SQLException:printStackTrace	()V
    //   316: goto -7 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	DatabaseHelper
    //   27	10	1	localDataInputStream	DataInputStream
    //   110	2	1	localIOException	IOException
    //   124	145	1	localCloseableWrappedIterable	CloseableWrappedIterable
    //   275	9	1	localSQLException1	java.sql.SQLException
    //   290	2	1	localSQLException2	java.sql.SQLException
    //   296	8	1	localSQLException3	java.sql.SQLException
    //   311	2	1	localSQLException4	java.sql.SQLException
    //   46	96	2	localObject1	Object
    //   256	2	2	localSQLException5	java.sql.SQLException
    //   302	8	2	localObject2	Object
    //   51	196	3	localObject3	Object
    //   165	70	4	localCategoriesUserdata	CategoriesUserdata
    // Exception table:
    //   from	to	target	type
    //   47	52	110	java/io/IOException
    //   56	81	110	java/io/IOException
    //   85	107	110	java/io/IOException
    //   268	272	110	java/io/IOException
    //   125	132	256	java/sql/SQLException
    //   132	253	256	java/sql/SQLException
    //   47	52	275	java/sql/SQLException
    //   56	81	275	java/sql/SQLException
    //   85	107	275	java/sql/SQLException
    //   268	272	275	java/sql/SQLException
    //   283	289	290	java/sql/SQLException
    //   261	267	296	java/sql/SQLException
    //   125	132	302	finally
    //   132	253	302	finally
    //   257	261	302	finally
    //   303	309	311	java/sql/SQLException
  }
  
  private void updateLocations(SQLiteDatabase paramSQLiteDatabase)
  {
    SLog.d(LOG_TAG, "db update locations");
    Object localObject1 = new DataInputStream(this.context.getResources().openRawResource(2131034116));
    Object localObject3 = new BufferedReader(new InputStreamReader((InputStream)localObject1));
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement("INSERT INTO locations (uuid,boundaries,latitude,longitude,title,title_de,title_es,title_fr,title_it,title_pt,title_nl,wikipedia,wikipedia_de,wikipedia_es,wikipedia_fr,wikipedia_it,wikipedia_pt,wikipedia_nl,category_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    try
    {
      Object localObject4;
      for (;;)
      {
        localObject4 = ((BufferedReader)localObject3).readLine();
        if (localObject4 == null) {
          break;
        }
        if ((localObject4 != null) && (((String)localObject4).length() > 0))
        {
          localObject4 = ((String)localObject4).split(";");
          paramSQLiteDatabase.bindString(1, localObject4[0]);
          paramSQLiteDatabase.bindString(2, localObject4[1]);
          paramSQLiteDatabase.bindString(3, localObject4[2].replace(",", ""));
          paramSQLiteDatabase.bindString(4, localObject4[3].replace(",", ""));
          paramSQLiteDatabase.bindString(5, localObject4[4]);
          paramSQLiteDatabase.bindString(6, localObject4[5]);
          paramSQLiteDatabase.bindString(7, localObject4[6]);
          paramSQLiteDatabase.bindString(8, localObject4[7]);
          paramSQLiteDatabase.bindString(9, localObject4[8]);
          paramSQLiteDatabase.bindString(10, localObject4[9]);
          paramSQLiteDatabase.bindString(11, localObject4[10]);
          paramSQLiteDatabase.bindString(12, localObject4[11]);
          paramSQLiteDatabase.bindString(13, localObject4[12]);
          paramSQLiteDatabase.bindString(14, localObject4[13]);
          paramSQLiteDatabase.bindString(15, localObject4[14]);
          paramSQLiteDatabase.bindString(16, localObject4[15]);
          paramSQLiteDatabase.bindString(17, localObject4[16]);
          paramSQLiteDatabase.bindString(18, localObject4[17]);
          paramSQLiteDatabase.bindString(19, localObject4[18]);
          paramSQLiteDatabase.executeInsert();
          paramSQLiteDatabase.clearBindings();
          localObject4 = (Categories)getCategoriesDao().queryForId(localObject4[18]);
          if (localObject4 != null)
          {
            localObject4 = ((Categories)localObject4).getUserdata();
            if (localObject4 != null)
            {
              ((CategoriesUserdata)localObject4).setLocationsTotal(((CategoriesUserdata)localObject4).getLocationsTotal() + 1);
              getCategoriesUserdataDao().update(localObject4);
            }
          }
        }
      }
      try
      {
        paramSQLiteDatabase.close();
        throw ((Throwable)localObject2);
      }
      catch (java.sql.SQLException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
        }
      }
    }
    catch (IOException paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
      SLog.d(LOG_TAG, "db import complete");
      paramSQLiteDatabase = getLocationsDao().getWrappedIterable();
    }
    catch (java.sql.SQLException paramSQLiteDatabase)
    {
      try
      {
        localObject1 = paramSQLiteDatabase.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Locations)((Iterator)localObject1).next();
          if (((Locations)localObject3).getUserdata() == null)
          {
            localObject4 = new LocationsUserdata();
            ((LocationsUserdata)localObject4).setLocation_id(((Locations)localObject3).getUuid());
            getLocationsUserdataDao().create(localObject4);
            ((Locations)localObject3).setUserdata((LocationsUserdata)localObject4);
            getLocationsDao().update(localObject3);
          }
        }
      }
      catch (java.sql.SQLException localSQLException)
      {
        for (;;)
        {
          localSQLException = localSQLException;
          localSQLException.printStackTrace();
          try
          {
            paramSQLiteDatabase.close();
            for (;;)
            {
              SLog.d(LOG_TAG, "db import complete 2");
              return;
              localSQLException.close();
              break;
              paramSQLiteDatabase = paramSQLiteDatabase;
              paramSQLiteDatabase.printStackTrace();
              break;
              try
              {
                paramSQLiteDatabase.close();
              }
              catch (java.sql.SQLException paramSQLiteDatabase)
              {
                paramSQLiteDatabase.printStackTrace();
              }
            }
          }
          catch (java.sql.SQLException paramSQLiteDatabase)
          {
            for (;;)
            {
              paramSQLiteDatabase.printStackTrace();
            }
          }
        }
      }
      finally {}
    }
  }
  
  public Dao<Categories, String> getCategoriesDao()
  {
    if (this.categoriesDao == null) {}
    try
    {
      this.categoriesDao = getDao(Categories.class);
      return this.categoriesDao;
    }
    catch (java.sql.SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
  }
  
  public Dao<CategoriesUserdata, String> getCategoriesUserdataDao()
  {
    if (this.categoriesUserdataDao == null) {}
    try
    {
      this.categoriesUserdataDao = getDao(CategoriesUserdata.class);
      return this.categoriesUserdataDao;
    }
    catch (java.sql.SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
  }
  
  public Dao<Locations, String> getLocationsDao()
  {
    if (this.locationsDao == null) {}
    try
    {
      this.locationsDao = getDao(Locations.class);
      return this.locationsDao;
    }
    catch (java.sql.SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
  }
  
  public Dao<LocationsUserdata, String> getLocationsUserdataDao()
  {
    if (this.locationsUserdataDao == null) {}
    try
    {
      this.locationsUserdataDao = getDao(LocationsUserdata.class);
      return this.locationsUserdataDao;
    }
    catch (java.sql.SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource)
  {
    SLog.d(LOG_TAG, "db oncreate");
    try
    {
      TableUtils.createTable(paramConnectionSource, Categories.class);
      TableUtils.createTable(paramConnectionSource, Locations.class);
      TableUtils.createTable(paramConnectionSource, CategoriesUserdata.class);
      TableUtils.createTable(paramConnectionSource, LocationsUserdata.class);
      updateCategories();
      updateLocations(paramSQLiteDatabase);
      return;
    }
    catch (android.database.SQLException paramSQLiteDatabase)
    {
      SLog.e(LOG_TAG, DatabaseHelper.class.getName() + " Can't create database" + paramSQLiteDatabase);
      throw new RuntimeException(paramSQLiteDatabase);
    }
    catch (java.sql.SQLException paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, ConnectionSource paramConnectionSource, int paramInt1, int paramInt2)
  {
    SLog.d(LOG_TAG, "db onupgrade");
    try
    {
      getCategoriesDao().updateRaw("DELETE FROM categories", new String[0]);
      updateCategories();
      getLocationsDao().updateRaw("DELETE FROM locations", new String[0]);
      updateLocations(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/db/DatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */