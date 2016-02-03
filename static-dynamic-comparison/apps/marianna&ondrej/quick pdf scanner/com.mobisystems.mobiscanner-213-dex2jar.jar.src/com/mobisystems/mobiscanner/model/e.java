package com.mobisystems.mobiscanner.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.mobisystems.mobiscanner.common.c;

public class e
  extends SQLiteOpenHelper
{
  private final Context mContext;
  private final c mLog = new c(this);
  
  e(Context paramContext)
  {
    super(paramContext, "documents.db", null, 15);
    this.mContext = paramContext;
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mLog.dl("Configure database " + paramSQLiteDatabase.getPath() + ", version " + paramSQLiteDatabase.getVersion());
    paramSQLiteDatabase = new d(paramSQLiteDatabase);
    int i = 0;
    try
    {
      while (i < a.aIC.length)
      {
        paramSQLiteDatabase.execSQL(a.aIC[i]);
        i += 1;
      }
      return;
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      this.mLog.g("Exception during DB onConfigure", paramSQLiteDatabase);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mLog.dl("Create database " + paramSQLiteDatabase.getPath() + ", version " + paramSQLiteDatabase.getVersion());
    paramSQLiteDatabase = new d(paramSQLiteDatabase);
    int i = 0;
    try
    {
      while (i < a.aID.length)
      {
        paramSQLiteDatabase.execSQL(a.aID[i]);
        i += 1;
      }
      return;
    }
    catch (SQLiteException paramSQLiteDatabase)
    {
      this.mLog.g("Exception during DB onCreate", paramSQLiteDatabase);
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.mLog.A("onDowngrade: Can not downgrade database " + paramSQLiteDatabase.getPath() + "from version " + paramInt1 + " to " + paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    this.mLog.dl("Open database " + paramSQLiteDatabase.getPath() + ", version " + paramSQLiteDatabase.getVersion());
    if (!com.mobisystems.mobiscanner.common.d.Dz()) {
      onConfigure(paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   7: new 31	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   14: ldc 122
    //   16: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_1
    //   20: invokevirtual 46	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   23: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 124
    //   28: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_2
    //   32: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: ldc 97
    //   37: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 62	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   50: new 64	com/mobisystems/mobiscanner/model/d
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 66	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 127	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   65: iload_2
    //   66: iconst_1
    //   67: iadd
    //   68: istore 4
    //   70: iconst_0
    //   71: istore_2
    //   72: iload 4
    //   74: iload_3
    //   75: if_icmpgt +392 -> 467
    //   78: iconst_0
    //   79: istore_2
    //   80: iload_2
    //   81: istore 5
    //   83: iload_2
    //   84: getstatic 131	com/mobisystems/mobiscanner/model/a:aIE	[[Ljava/lang/String;
    //   87: iload 4
    //   89: aaload
    //   90: arraylength
    //   91: if_icmpge +39 -> 130
    //   94: iload_2
    //   95: istore 5
    //   97: getstatic 131	com/mobisystems/mobiscanner/model/a:aIE	[[Ljava/lang/String;
    //   100: iload 4
    //   102: aaload
    //   103: iload_2
    //   104: aaload
    //   105: invokevirtual 136	java/lang/String:length	()I
    //   108: ifle +384 -> 492
    //   111: iload_2
    //   112: istore 5
    //   114: aload 7
    //   116: getstatic 131	com/mobisystems/mobiscanner/model/a:aIE	[[Ljava/lang/String;
    //   119: iload 4
    //   121: aaload
    //   122: iload_2
    //   123: aaload
    //   124: invokevirtual 75	com/mobisystems/mobiscanner/model/d:execSQL	(Ljava/lang/String;)V
    //   127: goto +365 -> 492
    //   130: iload_2
    //   131: istore 5
    //   133: new 31	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   140: ldc -118
    //   142: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload 4
    //   147: invokestatic 142	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   150: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore 8
    //   158: iload_2
    //   159: istore 5
    //   161: ldc 68
    //   163: aload 8
    //   165: iconst_2
    //   166: anewarray 144	java/lang/Class
    //   169: dup
    //   170: iconst_0
    //   171: ldc -110
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: ldc 64
    //   178: aastore
    //   179: invokevirtual 150	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   182: astore 6
    //   184: aload 6
    //   186: ifnull +59 -> 245
    //   189: iload_2
    //   190: istore 5
    //   192: aload_0
    //   193: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   196: new 31	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   203: ldc -104
    //   205: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 8
    //   210: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 62	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   219: iload_2
    //   220: istore 5
    //   222: aload 6
    //   224: aconst_null
    //   225: iconst_2
    //   226: anewarray 154	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_0
    //   232: getfield 24	com/mobisystems/mobiscanner/model/e:mContext	Landroid/content/Context;
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: aload 7
    //   240: aastore
    //   241: invokevirtual 160	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: iload 4
    //   247: iconst_1
    //   248: iadd
    //   249: istore 4
    //   251: goto -179 -> 72
    //   254: astore 6
    //   256: iload_2
    //   257: istore 5
    //   259: aload_0
    //   260: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   263: new 31	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   270: ldc -94
    //   272: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 8
    //   277: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 62	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   286: aconst_null
    //   287: astore 6
    //   289: goto -105 -> 184
    //   292: astore 6
    //   294: iload_2
    //   295: istore 5
    //   297: aload_0
    //   298: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   301: new 31	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   308: ldc -92
    //   310: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 8
    //   315: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: aload 6
    //   323: invokevirtual 81	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   326: goto -81 -> 245
    //   329: astore 6
    //   331: iload 4
    //   333: istore_2
    //   334: new 166	java/lang/RuntimeException
    //   337: dup
    //   338: new 31	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   345: ldc -88
    //   347: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_1
    //   351: invokevirtual 46	android/database/sqlite/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   354: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc -86
    //   359: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload_2
    //   363: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc -84
    //   368: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload 5
    //   373: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aload 6
    //   381: invokespecial 174	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: athrow
    //   385: astore_1
    //   386: aload 7
    //   388: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   391: aload_1
    //   392: athrow
    //   393: astore 6
    //   395: iload_2
    //   396: istore 5
    //   398: aload_0
    //   399: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   402: new 31	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   409: ldc -92
    //   411: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 8
    //   416: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: aload 6
    //   424: invokevirtual 81	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   427: goto -182 -> 245
    //   430: astore 6
    //   432: iload_2
    //   433: istore 5
    //   435: aload_0
    //   436: getfield 22	com/mobisystems/mobiscanner/model/e:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   439: new 31	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   446: ldc -92
    //   448: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 8
    //   453: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: aload 6
    //   461: invokevirtual 81	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   464: goto -219 -> 245
    //   467: iload_2
    //   468: istore 5
    //   470: aload 7
    //   472: invokevirtual 180	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   475: aload 7
    //   477: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   480: return
    //   481: astore 6
    //   483: iconst_0
    //   484: istore 5
    //   486: iload 4
    //   488: istore_2
    //   489: goto -155 -> 334
    //   492: iload_2
    //   493: iconst_1
    //   494: iadd
    //   495: istore_2
    //   496: goto -416 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	e
    //   0	499	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	499	2	paramInt1	int
    //   0	499	3	paramInt2	int
    //   1	486	4	i	int
    //   81	404	5	j	int
    //   182	41	6	localMethod	java.lang.reflect.Method
    //   254	1	6	localNoSuchMethodException	NoSuchMethodException
    //   287	1	6	localObject	Object
    //   292	30	6	localIllegalArgumentException	IllegalArgumentException
    //   329	51	6	localSQLiteException1	SQLiteException
    //   393	30	6	localIllegalAccessException	IllegalAccessException
    //   430	30	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   481	1	6	localSQLiteException2	SQLiteException
    //   58	418	7	locald	d
    //   156	296	8	str	String
    // Exception table:
    //   from	to	target	type
    //   161	184	254	java/lang/NoSuchMethodException
    //   192	219	292	java/lang/IllegalArgumentException
    //   222	245	292	java/lang/IllegalArgumentException
    //   83	94	329	android/database/sqlite/SQLiteException
    //   97	111	329	android/database/sqlite/SQLiteException
    //   114	127	329	android/database/sqlite/SQLiteException
    //   133	158	329	android/database/sqlite/SQLiteException
    //   161	184	329	android/database/sqlite/SQLiteException
    //   192	219	329	android/database/sqlite/SQLiteException
    //   222	245	329	android/database/sqlite/SQLiteException
    //   259	286	329	android/database/sqlite/SQLiteException
    //   297	326	329	android/database/sqlite/SQLiteException
    //   398	427	329	android/database/sqlite/SQLiteException
    //   435	464	329	android/database/sqlite/SQLiteException
    //   470	475	329	android/database/sqlite/SQLiteException
    //   60	65	385	finally
    //   83	94	385	finally
    //   97	111	385	finally
    //   114	127	385	finally
    //   133	158	385	finally
    //   161	184	385	finally
    //   192	219	385	finally
    //   222	245	385	finally
    //   259	286	385	finally
    //   297	326	385	finally
    //   334	385	385	finally
    //   398	427	385	finally
    //   435	464	385	finally
    //   470	475	385	finally
    //   192	219	393	java/lang/IllegalAccessException
    //   222	245	393	java/lang/IllegalAccessException
    //   192	219	430	java/lang/reflect/InvocationTargetException
    //   222	245	430	java/lang/reflect/InvocationTargetException
    //   60	65	481	android/database/sqlite/SQLiteException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */