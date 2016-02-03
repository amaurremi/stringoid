package com.google.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class DataLayerPersistentStoreImpl
  implements DataLayer.PersistentStore
{
  private static final String CREATE_MAPS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  private static final String DATABASE_NAME = "google_tagmanager.db";
  private static final String EXPIRE_FIELD = "expires";
  private static final String ID_FIELD = "ID";
  private static final String KEY_FIELD = "key";
  private static final String MAPS_TABLE = "datalayer";
  private static final int MAX_NUM_STORED_ITEMS = 2000;
  private static final String VALUE_FIELD = "value";
  private Clock mClock;
  private final Context mContext;
  private DatabaseHelper mDbHelper;
  private final Executor mExecutor;
  private int mMaxNumStoredItems;
  
  public DataLayerPersistentStoreImpl(Context paramContext)
  {
    this(paramContext, new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    }, "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  @VisibleForTesting
  DataLayerPersistentStoreImpl(Context paramContext, Clock paramClock, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.mClock = paramClock;
    this.mMaxNumStoredItems = paramInt;
    this.mExecutor = paramExecutor;
    this.mDbHelper = new DatabaseHelper(this.mContext, paramString);
  }
  
  private void clearKeysWithPrefixSingleThreaded(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for clearKeysWithPrefix.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "key = ? OR key LIKE ?", new String[] { paramString, paramString + ".%" });
      Log.v("Cleared " + i + " items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error deleting entries with key prefix: " + paramString + " (" + localSQLiteException + ").");
      return;
    }
    finally
    {
      closeDatabaseConnection();
    }
  }
  
  private void closeDatabaseConnection()
  {
    try
    {
      this.mDbHelper.close();
      return;
    }
    catch (SQLiteException localSQLiteException) {}
  }
  
  private void deleteEntries(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = getWritableDatabase("Error opening database for deleteEntries.");
    } while (localSQLiteDatabase == null);
    String str = String.format("%s in (%s)", new Object[] { "ID", TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    try
    {
      localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error deleting entries " + Arrays.toString(paramArrayOfString));
    }
  }
  
  private void deleteEntriesOlderThan(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {
      return;
    }
    try
    {
      int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", new String[] { Long.toString(paramLong) });
      Log.v("Deleted " + i + " expired items");
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w("Error deleting old entries.");
    }
  }
  
  private int getNumStoredEntries()
  {
    k = 0;
    int i = 0;
    Object localObject5 = getWritableDatabase("Error opening database for getNumStoredEntries.");
    if (localObject5 == null) {
      return 0;
    }
    Object localObject3 = null;
    localObject1 = null;
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from datalayer", null);
      localObject1 = localObject5;
      localObject3 = localObject5;
      if (((Cursor)localObject5).moveToFirst())
      {
        localObject1 = localObject5;
        localObject3 = localObject5;
        long l = ((Cursor)localObject5).getLong(0);
        i = (int)l;
      }
      j = i;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        j = i;
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        Log.w("Error getting numStoredEntries");
        int j = k;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = k;
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label137;
      }
      ((Cursor)localObject4).close();
    }
    return j;
  }
  
  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.mDbHelper.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.w(paramString);
    }
    return null;
  }
  
  private List<KeyAndSerialized> loadSerialized()
  {
    Object localObject = getWritableDatabase("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((SQLiteDatabase)localObject).query("datalayer", new String[] { "key", "value" }, null, null, null, null, "ID", null);
    try
    {
      if (((Cursor)localObject).moveToNext()) {
        localArrayList.add(new KeyAndSerialized(((Cursor)localObject).getString(0), ((Cursor)localObject).getBlob(1)));
      }
      return localList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private List<DataLayer.KeyValue> loadSingleThreaded()
  {
    try
    {
      deleteEntriesOlderThan(this.mClock.currentTimeMillis());
      List localList = unserializeValues(loadSerialized());
      return localList;
    }
    finally
    {
      closeDatabaseConnection();
    }
  }
  
  private void makeRoomForEntries(int paramInt)
  {
    paramInt = getNumStoredEntries() - this.mMaxNumStoredItems + paramInt;
    if (paramInt > 0)
    {
      List localList = peekEntryIds(paramInt);
      Log.i("DataLayer store full, deleting " + localList.size() + " entries to make room.");
      deleteEntries((String[])localList.toArray(new String[0]));
    }
  }
  
  private List<String> peekEntryIds(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt <= 0) {
      Log.w("Invalid maxEntries specified. Skipping.");
    }
    for (;;)
    {
      return localArrayList;
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for peekEntryIds.");
      if (localSQLiteDatabase == null) {
        continue;
      }
      Object localObject3 = null;
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localObject3;
      try
      {
        String str1 = String.format("%s ASC", new Object[] { "ID" });
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        String str2 = Integer.toString(paramInt);
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localCursor2 = localSQLiteDatabase.query("datalayer", new String[] { "ID" }, null, null, null, null, str1, str2);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          boolean bool;
          do
          {
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            localArrayList.add(String.valueOf(localCursor2.getLong(0)));
            localCursor1 = localCursor2;
            localObject1 = localCursor2;
            bool = localCursor2.moveToNext();
          } while (bool);
        }
        if (localCursor2 == null) {
          continue;
        }
        localCursor2.close();
        return localArrayList;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject1 = localCursor1;
        Log.w("Error in peekEntries fetching entryIds: " + localSQLiteException.getMessage());
        if (localCursor1 == null) {
          continue;
        }
        localCursor1.close();
        return localArrayList;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
  }
  
  /* Error */
  private void saveSingleThreaded(List<KeyAndSerialized> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/tagmanager/DataLayerPersistentStoreImpl:mClock	Lcom/google/tagmanager/Clock;
    //   6: invokeinterface 284 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 286	com/google/tagmanager/DataLayerPersistentStoreImpl:deleteEntriesOlderThan	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 306 1 0
    //   26: invokespecial 340	com/google/tagmanager/DataLayerPersistentStoreImpl:makeRoomForEntries	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 343	com/google/tagmanager/DataLayerPersistentStoreImpl:writeEntriesToDatabase	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 159	com/google/tagmanager/DataLayerPersistentStoreImpl:closeDatabaseConnection	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 159	com/google/tagmanager/DataLayerPersistentStoreImpl:closeDatabaseConnection	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	DataLayerPersistentStoreImpl
    //   0	57	1	paramList	List<KeyAndSerialized>
    //   0	57	2	paramLong	long
    //   11	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	52	finally
    //   46	52	52	finally
  }
  
  /* Error */
  private byte[] serialize(Object paramObject)
  {
    // Byte code:
    //   0: new 350	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 351	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 4
    //   14: new 353	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload 5
    //   20: invokespecial 356	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   23: astore_2
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 360	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   29: aload 5
    //   31: invokevirtual 364	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   34: astore_1
    //   35: aload_2
    //   36: ifnull +7 -> 43
    //   39: aload_2
    //   40: invokevirtual 365	java/io/ObjectOutputStream:close	()V
    //   43: aload 5
    //   45: invokevirtual 366	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_1
    //   49: areturn
    //   50: astore_1
    //   51: aload 4
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +7 -> 62
    //   58: aload_1
    //   59: invokevirtual 365	java/io/ObjectOutputStream:close	()V
    //   62: aload 5
    //   64: invokevirtual 366	java/io/ByteArrayOutputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_1
    //   70: aconst_null
    //   71: areturn
    //   72: astore_1
    //   73: aload_3
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 365	java/io/ObjectOutputStream:close	()V
    //   83: aload 5
    //   85: invokevirtual 366	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: goto -3 -> 88
    //   94: astore_1
    //   95: goto -20 -> 75
    //   98: astore_1
    //   99: aload_2
    //   100: astore_1
    //   101: goto -47 -> 54
    //   104: astore_2
    //   105: goto -57 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	DataLayerPersistentStoreImpl
    //   0	108	1	paramObject	Object
    //   23	57	2	localObject1	Object
    //   90	10	2	localIOException1	java.io.IOException
    //   104	1	2	localIOException2	java.io.IOException
    //   10	64	3	localObject2	Object
    //   12	40	4	localObject3	Object
    //   7	77	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   14	24	50	java/io/IOException
    //   58	62	69	java/io/IOException
    //   62	67	69	java/io/IOException
    //   14	24	72	finally
    //   79	83	90	java/io/IOException
    //   83	88	90	java/io/IOException
    //   24	35	94	finally
    //   24	35	98	java/io/IOException
    //   39	43	104	java/io/IOException
    //   43	48	104	java/io/IOException
  }
  
  private List<KeyAndSerialized> serializeValues(List<DataLayer.KeyValue> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.KeyValue localKeyValue = (DataLayer.KeyValue)paramList.next();
      localArrayList.add(new KeyAndSerialized(localKeyValue.mKey, serialize(localKeyValue.mValue)));
    }
    return localArrayList;
  }
  
  /* Error */
  private Object unserialize(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 398	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 401	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: aconst_null
    //   16: astore_3
    //   17: new 403	java/io/ObjectInputStream
    //   20: dup
    //   21: aload 5
    //   23: invokespecial 406	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 409	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 410	java/io/ObjectInputStream:close	()V
    //   40: aload 5
    //   42: invokevirtual 411	java/io/ByteArrayInputStream:close	()V
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: aload_3
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 410	java/io/ObjectInputStream:close	()V
    //   58: aload 5
    //   60: invokevirtual 411	java/io/ByteArrayInputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: aconst_null
    //   67: areturn
    //   68: astore_1
    //   69: aload 4
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 410	java/io/ObjectInputStream:close	()V
    //   80: aload 5
    //   82: invokevirtual 411	java/io/ByteArrayInputStream:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_1
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: aload_2
    //   92: ifnull +7 -> 99
    //   95: aload_2
    //   96: invokevirtual 410	java/io/ObjectInputStream:close	()V
    //   99: aload 5
    //   101: invokevirtual 411	java/io/ByteArrayInputStream:close	()V
    //   104: aload_1
    //   105: athrow
    //   106: astore_2
    //   107: goto -3 -> 104
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload_3
    //   114: astore_1
    //   115: goto -24 -> 91
    //   118: astore_2
    //   119: goto -47 -> 72
    //   122: astore_2
    //   123: goto -73 -> 50
    //   126: astore_1
    //   127: goto -82 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	DataLayerPersistentStoreImpl
    //   0	130	1	paramArrayOfByte	byte[]
    //   14	82	2	localObject1	Object
    //   106	1	2	localIOException1	java.io.IOException
    //   112	1	2	arrayOfByte	byte[]
    //   118	1	2	localClassNotFoundException	ClassNotFoundException
    //   122	1	2	localIOException2	java.io.IOException
    //   16	33	3	localObject2	Object
    //   110	4	3	localObject3	Object
    //   11	59	4	localObject4	Object
    //   8	92	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   17	27	47	java/io/IOException
    //   54	58	65	java/io/IOException
    //   58	63	65	java/io/IOException
    //   17	27	68	java/lang/ClassNotFoundException
    //   76	80	87	java/io/IOException
    //   80	85	87	java/io/IOException
    //   17	27	90	finally
    //   95	99	106	java/io/IOException
    //   99	104	106	java/io/IOException
    //   27	32	110	finally
    //   27	32	118	java/lang/ClassNotFoundException
    //   27	32	122	java/io/IOException
    //   36	40	126	java/io/IOException
    //   40	45	126	java/io/IOException
  }
  
  private List<DataLayer.KeyValue> unserializeValues(List<KeyAndSerialized> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      KeyAndSerialized localKeyAndSerialized = (KeyAndSerialized)paramList.next();
      localArrayList.add(new DataLayer.KeyValue(localKeyAndSerialized.mKey, unserialize(localKeyAndSerialized.mSerialized)));
    }
    return localArrayList;
  }
  
  private void writeEntriesToDatabase(List<KeyAndSerialized> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        KeyAndSerialized localKeyAndSerialized = (KeyAndSerialized)paramList.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", localKeyAndSerialized.mKey);
        localContentValues.put("value", localKeyAndSerialized.mSerialized);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  public void clearKeysWithPrefix(final String paramString)
  {
    this.mExecutor.execute(new Runnable()
    {
      public void run()
      {
        DataLayerPersistentStoreImpl.this.clearKeysWithPrefixSingleThreaded(paramString);
      }
    });
  }
  
  public void loadSaved(final DataLayer.PersistentStore.Callback paramCallback)
  {
    this.mExecutor.execute(new Runnable()
    {
      public void run()
      {
        paramCallback.onKeyValuesLoaded(DataLayerPersistentStoreImpl.this.loadSingleThreaded());
      }
    });
  }
  
  public void saveKeyValues(final List<DataLayer.KeyValue> paramList, final long paramLong)
  {
    paramList = serializeValues(paramList);
    this.mExecutor.execute(new Runnable()
    {
      public void run()
      {
        DataLayerPersistentStoreImpl.this.saveSingleThreaded(paramList, paramLong);
      }
    });
  }
  
  @VisibleForTesting
  class DatabaseHelper
    extends SQLiteOpenHelper
  {
    DatabaseHelper(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject = null;
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { paramString }, null, null, null);
        localSQLiteDatabase = paramSQLiteDatabase;
        localObject = paramSQLiteDatabase;
        boolean bool = paramSQLiteDatabase.moveToFirst();
        if (paramSQLiteDatabase != null) {
          paramSQLiteDatabase.close();
        }
        return bool;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        localObject = localSQLiteDatabase;
        Log.w("Error querying for table " + paramString);
        if (localSQLiteDatabase != null) {
          localSQLiteDatabase.close();
        }
        return false;
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
    }
    
    private void validateColumnsPresent(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
        int i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        paramSQLiteDatabase.close();
        if ((!localHashSet.remove("key")) || (!localHashSet.remove("value")) || (!localHashSet.remove("ID")) || (!localHashSet.remove("expires"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      if (!((Set)localObject).isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      Object localObject1 = null;
      try
      {
        localObject2 = super.getWritableDatabase();
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Object localObject2;
          DataLayerPersistentStoreImpl.this.mContext.getDatabasePath("google_tagmanager.db").delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!tablePresent("datalayer", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(DataLayerPersistentStoreImpl.CREATE_MAPS_TABLE);
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      validateColumnsPresent(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
  
  private static class KeyAndSerialized
  {
    final String mKey;
    final byte[] mSerialized;
    
    KeyAndSerialized(String paramString, byte[] paramArrayOfByte)
    {
      this.mKey = paramString;
      this.mSerialized = paramArrayOfByte;
    }
    
    public String toString()
    {
      return "KeyAndSerialized: key = " + this.mKey + " serialized hash = " + Arrays.hashCode(this.mSerialized);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DataLayerPersistentStoreImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */