package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager
{
  private static final String SAVE_POINT_PREFIX = "ORMLITE";
  private static final Logger logger = LoggerFactory.getLogger(TransactionManager.class);
  private static AtomicInteger savePointCounter = new AtomicInteger();
  private ConnectionSource connectionSource;
  
  public TransactionManager() {}
  
  public TransactionManager(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
    initialize();
  }
  
  public static <T> T callInTransaction(ConnectionSource paramConnectionSource, Callable<T> paramCallable)
    throws SQLException
  {
    DatabaseConnection localDatabaseConnection = paramConnectionSource.getReadWriteConnection();
    try
    {
      paramCallable = callInTransaction(localDatabaseConnection, paramConnectionSource.saveSpecialConnection(localDatabaseConnection), paramConnectionSource.getDatabaseType(), paramCallable);
      return paramCallable;
    }
    finally
    {
      paramConnectionSource.clearSpecialConnection(localDatabaseConnection);
      paramConnectionSource.releaseConnection(localDatabaseConnection);
    }
  }
  
  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, DatabaseType paramDatabaseType, Callable<T> paramCallable)
    throws SQLException
  {
    return (T)callInTransaction(paramDatabaseConnection, false, paramDatabaseType, paramCallable);
  }
  
  /* Error */
  public static <T> T callInTransaction(DatabaseConnection paramDatabaseConnection, boolean paramBoolean, DatabaseType paramDatabaseType, Callable<T> paramCallable)
    throws SQLException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 4
    //   12: aconst_null
    //   13: astore 8
    //   15: iload_1
    //   16: ifne +15 -> 31
    //   19: iload 6
    //   21: istore_1
    //   22: aload_2
    //   23: invokeinterface 80 1 0
    //   28: ifeq +118 -> 146
    //   31: iload 7
    //   33: istore 5
    //   35: iload 6
    //   37: istore_1
    //   38: aload_0
    //   39: invokeinterface 85 1 0
    //   44: ifeq +48 -> 92
    //   47: iload 6
    //   49: istore_1
    //   50: aload_0
    //   51: invokeinterface 88 1 0
    //   56: istore 6
    //   58: iload 6
    //   60: istore 5
    //   62: iload 6
    //   64: ifeq +28 -> 92
    //   67: iload 6
    //   69: istore_1
    //   70: aload_0
    //   71: iconst_0
    //   72: invokeinterface 92 2 0
    //   77: iload 6
    //   79: istore_1
    //   80: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   83: ldc 94
    //   85: invokevirtual 100	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   88: iload 6
    //   90: istore 5
    //   92: iload 5
    //   94: istore_1
    //   95: aload_0
    //   96: new 102	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   103: ldc 8
    //   105: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 31	com/j256/ormlite/misc/TransactionManager:savePointCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   111: invokevirtual 111	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   114: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokeinterface 122 2 0
    //   125: astore 8
    //   127: aload 8
    //   129: ifnonnull +63 -> 192
    //   132: iload 5
    //   134: istore_1
    //   135: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   138: ldc 124
    //   140: invokevirtual 100	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   143: iconst_1
    //   144: istore 4
    //   146: iload 5
    //   148: istore_1
    //   149: aload_3
    //   150: invokeinterface 130 1 0
    //   155: astore_2
    //   156: iload 4
    //   158: ifeq +12 -> 170
    //   161: iload 5
    //   163: istore_1
    //   164: aload_0
    //   165: aload 8
    //   167: invokestatic 134	com/j256/ormlite/misc/TransactionManager:commit	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   170: iload 5
    //   172: ifeq +18 -> 190
    //   175: aload_0
    //   176: iconst_1
    //   177: invokeinterface 92 2 0
    //   182: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   185: ldc -120
    //   187: invokevirtual 100	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   190: aload_2
    //   191: areturn
    //   192: iload 5
    //   194: istore_1
    //   195: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   198: ldc -118
    //   200: aload 8
    //   202: invokeinterface 143 1 0
    //   207: invokevirtual 146	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;Ljava/lang/Object;)V
    //   210: goto -67 -> 143
    //   213: astore_2
    //   214: iload_1
    //   215: ifeq +18 -> 233
    //   218: aload_0
    //   219: iconst_1
    //   220: invokeinterface 92 2 0
    //   225: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   228: ldc -120
    //   230: invokevirtual 100	com/j256/ormlite/logger/Logger:debug	(Ljava/lang/String;)V
    //   233: aload_2
    //   234: athrow
    //   235: astore_2
    //   236: iload 4
    //   238: ifeq +12 -> 250
    //   241: iload 5
    //   243: istore_1
    //   244: aload_0
    //   245: aload 8
    //   247: invokestatic 149	com/j256/ormlite/misc/TransactionManager:rollBack	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   250: iload 5
    //   252: istore_1
    //   253: aload_2
    //   254: athrow
    //   255: astore_3
    //   256: iload 5
    //   258: istore_1
    //   259: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   262: aload_2
    //   263: ldc -105
    //   265: invokevirtual 155	com/j256/ormlite/logger/Logger:error	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   268: goto -18 -> 250
    //   271: astore_2
    //   272: iload 4
    //   274: ifeq +12 -> 286
    //   277: iload 5
    //   279: istore_1
    //   280: aload_0
    //   281: aload 8
    //   283: invokestatic 149	com/j256/ormlite/misc/TransactionManager:rollBack	(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/sql/Savepoint;)V
    //   286: iload 5
    //   288: istore_1
    //   289: ldc -99
    //   291: aload_2
    //   292: invokestatic 163	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   295: athrow
    //   296: astore_3
    //   297: iload 5
    //   299: istore_1
    //   300: getstatic 24	com/j256/ormlite/misc/TransactionManager:logger	Lcom/j256/ormlite/logger/Logger;
    //   303: aload_2
    //   304: ldc -105
    //   306: invokevirtual 155	com/j256/ormlite/logger/Logger:error	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   309: goto -23 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramDatabaseConnection	DatabaseConnection
    //   0	312	1	paramBoolean	boolean
    //   0	312	2	paramDatabaseType	DatabaseType
    //   0	312	3	paramCallable	Callable<T>
    //   10	263	4	i	int
    //   1	297	5	bool1	boolean
    //   4	85	6	bool2	boolean
    //   7	25	7	bool3	boolean
    //   13	269	8	localSavepoint	Savepoint
    // Exception table:
    //   from	to	target	type
    //   22	31	213	finally
    //   38	47	213	finally
    //   50	58	213	finally
    //   70	77	213	finally
    //   80	88	213	finally
    //   95	127	213	finally
    //   135	143	213	finally
    //   149	156	213	finally
    //   164	170	213	finally
    //   195	210	213	finally
    //   244	250	213	finally
    //   253	255	213	finally
    //   259	268	213	finally
    //   280	286	213	finally
    //   289	296	213	finally
    //   300	309	213	finally
    //   149	156	235	java/sql/SQLException
    //   164	170	235	java/sql/SQLException
    //   244	250	255	java/sql/SQLException
    //   149	156	271	java/lang/Exception
    //   164	170	271	java/lang/Exception
    //   280	286	296	java/sql/SQLException
  }
  
  private static void commit(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint)
    throws SQLException
  {
    if (paramSavepoint == null) {}
    for (String str = null;; str = paramSavepoint.getSavepointName())
    {
      paramDatabaseConnection.commit(paramSavepoint);
      if (str != null) {
        break;
      }
      logger.debug("committed savePoint transaction");
      return;
    }
    logger.debug("committed savePoint transaction {}", str);
  }
  
  private static void rollBack(DatabaseConnection paramDatabaseConnection, Savepoint paramSavepoint)
    throws SQLException
  {
    if (paramSavepoint == null) {}
    for (String str = null;; str = paramSavepoint.getSavepointName())
    {
      paramDatabaseConnection.rollback(paramSavepoint);
      if (str != null) {
        break;
      }
      logger.debug("rolled back savePoint transaction");
      return;
    }
    logger.debug("rolled back savePoint transaction {}", str);
  }
  
  public <T> T callInTransaction(Callable<T> paramCallable)
    throws SQLException
  {
    return (T)callInTransaction(this.connectionSource, paramCallable);
  }
  
  public void initialize()
  {
    if (this.connectionSource == null) {
      throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
    }
  }
  
  public void setConnectionSource(ConnectionSource paramConnectionSource)
  {
    this.connectionSource = paramConnectionSource;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/misc/TransactionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */