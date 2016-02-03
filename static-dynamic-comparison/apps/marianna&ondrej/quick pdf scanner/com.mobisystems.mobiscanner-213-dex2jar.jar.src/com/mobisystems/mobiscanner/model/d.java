package com.mobisystems.mobiscanner.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import com.mobisystems.mobiscanner.common.c;

public class d
{
  private static Integer aJM = Integer.valueOf(0);
  private static Integer aJN = Integer.valueOf(0);
  private SQLiteDatabase aJO;
  private final c mLog = new c(this);
  
  public d(SQLiteDatabase paramSQLiteDatabase)
  {
    this.aJO = paramSQLiteDatabase;
  }
  
  public long a(String paramString, String[] paramArrayOfString)
  {
    int j;
    long l2;
    int i;
    synchronized (aJN)
    {
      Object localObject2 = Integer.valueOf(aJN.intValue() + 1);
      aJN = (Integer)localObject2;
      j = ((Integer)localObject2).intValue();
      l2 = System.currentTimeMillis();
      this.mLog.dl("insert[" + j + "]:" + paramString);
      if (paramArrayOfString == null) {
        break label196;
      }
      ??? = "";
      i = 0;
      if (i < paramArrayOfString.length)
      {
        localObject2 = ???;
        if (i > 0) {
          localObject2 = (String)??? + ", ";
        }
        ??? = (String)localObject2 + paramArrayOfString[i];
        i += 1;
      }
    }
    this.mLog.dl("insert args[" + j + "]:" + (String)???);
    label196:
    paramString = this.aJO.compileStatement(paramString);
    if (paramArrayOfString != null) {
      i = 0;
    }
    try
    {
      while (i < paramArrayOfString.length)
      {
        paramString.bindString(i + 1, paramArrayOfString[i]);
        i += 1;
      }
      long l1 = paramString.executeInsert();
      paramString.close();
      l2 = System.currentTimeMillis() - l2;
      this.mLog.dl("insert result[" + j + "]: " + "RowId: " + l1 + ", " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(l2 % 1000L) }));
      return l1;
    }
    finally
    {
      paramString.close();
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public int b(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 23	com/mobisystems/mobiscanner/model/d:aJN	Ljava/lang/Integer;
    //   3: astore 7
    //   5: aload 7
    //   7: monitorenter
    //   8: getstatic 23	com/mobisystems/mobiscanner/model/d:aJN	Ljava/lang/Integer;
    //   11: invokevirtual 43	java/lang/Integer:intValue	()I
    //   14: iconst_1
    //   15: iadd
    //   16: invokestatic 19	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: astore 8
    //   21: aload 8
    //   23: putstatic 23	com/mobisystems/mobiscanner/model/d:aJN	Ljava/lang/Integer;
    //   26: aload 8
    //   28: invokevirtual 43	java/lang/Integer:intValue	()I
    //   31: istore 4
    //   33: aload 7
    //   35: monitorexit
    //   36: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   39: lstore 5
    //   41: aload_0
    //   42: getfield 35	com/mobisystems/mobiscanner/model/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   45: new 51	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   52: ldc -128
    //   54: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 4
    //   59: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 63
    //   64: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokevirtual 71	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: ifnull +118 -> 196
    //   81: ldc 73
    //   83: astore 7
    //   85: iconst_0
    //   86: istore_3
    //   87: iload_3
    //   88: aload_2
    //   89: arraylength
    //   90: if_icmpge +69 -> 159
    //   93: aload 7
    //   95: astore 8
    //   97: iload_3
    //   98: ifle +25 -> 123
    //   101: new 51	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   108: aload 7
    //   110: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 75
    //   115: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: astore 8
    //   123: new 51	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   130: aload 8
    //   132: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: iload_3
    //   137: aaload
    //   138: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 7
    //   146: iload_3
    //   147: iconst_1
    //   148: iadd
    //   149: istore_3
    //   150: goto -63 -> 87
    //   153: astore_1
    //   154: aload 7
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: aload_0
    //   160: getfield 35	com/mobisystems/mobiscanner/model/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   163: new 51	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   170: ldc -126
    //   172: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 4
    //   177: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc 63
    //   182: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 7
    //   187: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 71	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   196: aload_0
    //   197: getfield 37	com/mobisystems/mobiscanner/model/d:aJO	Landroid/database/sqlite/SQLiteDatabase;
    //   200: aload_1
    //   201: invokevirtual 83	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   204: astore_1
    //   205: aload_2
    //   206: ifnull +28 -> 234
    //   209: iconst_0
    //   210: istore_3
    //   211: iload_3
    //   212: aload_2
    //   213: arraylength
    //   214: if_icmpge +20 -> 234
    //   217: aload_1
    //   218: iload_3
    //   219: iconst_1
    //   220: iadd
    //   221: aload_2
    //   222: iload_3
    //   223: aaload
    //   224: invokevirtual 89	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   227: iload_3
    //   228: iconst_1
    //   229: iadd
    //   230: istore_3
    //   231: goto -20 -> 211
    //   234: invokestatic 136	com/mobisystems/mobiscanner/common/d:Dw	()Z
    //   237: ifeq +109 -> 346
    //   240: aload_1
    //   241: invokevirtual 139	android/database/sqlite/SQLiteStatement:executeUpdateDelete	()I
    //   244: istore_3
    //   245: aload_1
    //   246: invokevirtual 95	android/database/sqlite/SQLiteStatement:close	()V
    //   249: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   252: lload 5
    //   254: lsub
    //   255: lstore 5
    //   257: aload_0
    //   258: getfield 35	com/mobisystems/mobiscanner/model/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   261: new 51	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   268: ldc -115
    //   270: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 4
    //   275: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: ldc 99
    //   280: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc -113
    //   285: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_3
    //   289: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc 75
    //   294: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc 106
    //   299: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc 108
    //   304: iconst_2
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: lload 5
    //   312: ldc2_w 109
    //   315: ldiv
    //   316: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: lload 5
    //   324: ldc2_w 109
    //   327: lrem
    //   328: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   331: aastore
    //   332: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   335: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokevirtual 71	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   344: iload_3
    //   345: ireturn
    //   346: aload_1
    //   347: invokevirtual 146	android/database/sqlite/SQLiteStatement:execute	()V
    //   350: iconst_0
    //   351: istore_3
    //   352: goto -107 -> 245
    //   355: astore_2
    //   356: aload_1
    //   357: invokevirtual 95	android/database/sqlite/SQLiteStatement:close	()V
    //   360: aload_2
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	d
    //   0	362	1	paramString	String
    //   0	362	2	paramArrayOfString	String[]
    //   86	266	3	i	int
    //   31	243	4	j	int
    //   39	284	5	l	long
    //   3	183	7	localObject1	Object
    //   19	112	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	36	153	finally
    //   154	157	153	finally
    //   211	227	355	finally
    //   234	245	355	finally
    //   346	350	355	finally
  }
  
  public void beginTransaction()
  {
    synchronized (aJM)
    {
      Integer localInteger2 = Integer.valueOf(aJM.intValue() + 1);
      aJM = localInteger2;
      int i = localInteger2.intValue();
      long l = System.currentTimeMillis();
      this.mLog.dl("beginTransaction[" + i + "]:");
      this.aJO.beginTransaction();
      l = System.currentTimeMillis() - l;
      this.mLog.dl("beginTransaction finished[" + i + "]: " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l / 1000L), Long.valueOf(l % 1000L) }));
      return;
    }
  }
  
  public void endTransaction()
  {
    synchronized (aJM)
    {
      Integer localInteger2 = aJM;
      aJM = Integer.valueOf(aJM.intValue() - 1);
      int i = localInteger2.intValue();
      long l = System.currentTimeMillis();
      this.mLog.dl("endTransaction[" + i + "]:");
      this.aJO.endTransaction();
      l = System.currentTimeMillis() - l;
      this.mLog.dl("endTransaction finished[" + i + "]: " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l / 1000L), Long.valueOf(l % 1000L) }));
      return;
    }
  }
  
  public void execSQL(String paramString)
  {
    synchronized (aJN)
    {
      Integer localInteger2 = Integer.valueOf(aJN.intValue() + 1);
      aJN = localInteger2;
      int i = localInteger2.intValue();
      long l = System.currentTimeMillis();
      this.mLog.dl("execSQL[" + i + "]:" + paramString);
      this.aJO.execSQL(paramString);
      l = System.currentTimeMillis() - l;
      this.mLog.dl("execSQL result[" + i + "]: " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l / 1000L), Long.valueOf(l % 1000L) }));
      return;
    }
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
  {
    int j;
    long l;
    synchronized (aJN)
    {
      Object localObject2 = Integer.valueOf(aJN.intValue() + 1);
      aJN = (Integer)localObject2;
      j = ((Integer)localObject2).intValue();
      l = System.currentTimeMillis();
      this.mLog.dl("rawQuery[" + j + "]:" + paramString);
      if (paramArrayOfString == null) {
        break label202;
      }
      ??? = "";
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        localObject2 = ???;
        if (i > 0) {
          localObject2 = (String)??? + ", ";
        }
        ??? = (String)localObject2 + paramArrayOfString[i];
        i += 1;
      }
    }
    this.mLog.dl("rawQuery args[" + j + "]:" + (String)???);
    label202:
    if (com.mobisystems.mobiscanner.common.d.Dz()) {}
    for (paramString = this.aJO.rawQuery(paramString, paramArrayOfString, paramCancellationSignal);; paramString = this.aJO.rawQuery(paramString, paramArrayOfString))
    {
      l = System.currentTimeMillis() - l;
      this.mLog.dl("rawQuery result[" + j + "]: " + "NumRes: " + paramString.getCount() + ", " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l / 1000L), Long.valueOf(l % 1000L) }));
      return paramString;
    }
  }
  
  public void setTransactionSuccessful()
  {
    int i = aJM.intValue();
    long l = System.currentTimeMillis();
    this.mLog.dl("setTransactionSuccessful[" + i + "]:");
    this.aJO.setTransactionSuccessful();
    l = System.currentTimeMillis() - l;
    this.mLog.dl("setTransactionSuccessful finished[" + i + "]: " + "Time: " + String.format("%d.%03d", new Object[] { Long.valueOf(l / 1000L), Long.valueOf(l % 1000L) }));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/model/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */