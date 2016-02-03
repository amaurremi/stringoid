package com.mobisystems.mobiscanner.model;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import com.google.gson.b.a;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.image.Image;
import com.mobisystems.mobiscanner.image.Image.ImageException;
import com.mobisystems.mobiscanner.image.Image.InvalidImageTypeException;
import com.mobisystems.mobiscanner.image.ImageOrientation;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

public class DocumentModel
{
  private static e aIF = null;
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private static Context mContext;
  private CancellationSignal aIG = null;
  private AtomicBoolean aIH = new AtomicBoolean(false);
  private OperationStatus aII = OperationStatus.avB;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  public DocumentModel()
  {
    this.mLog.dl("Created");
  }
  
  public static long Ip()
  {
    Cursor localCursor = new DocumentModel().a(null, DocListSortBy.aIL, SortOrder.aIQ, 0, 1);
    long l1 = 0L;
    long l2 = l1;
    if (localCursor != null)
    {
      if (localCursor.moveToPosition(0)) {
        l1 = localCursor.getInt(localCursor.getColumnIndex("doc_last_modification_time"));
      }
      localCursor.close();
      l2 = l1;
    }
    return l2;
  }
  
  public static void Iq()
  {
    apd.dl("releaseDb called");
    if (aIF != null)
    {
      aIF.close();
      aIF = null;
    }
  }
  
  @TargetApi(16)
  private void Ir()
  {
    try
    {
      this.mLog.dl("createCancellationSignal called");
      this.aIG = null;
      if (com.mobisystems.mobiscanner.common.d.Dz()) {
        this.aIG = new CancellationSignal();
      }
      this.aIH.set(false);
      return;
    }
    finally {}
  }
  
  private void Is()
  {
    try
    {
      this.mLog.dl("releaseCancellationSignal called");
      this.aIG = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private long Iv()
  {
    this.mLog.dl("addCameraRollDocument called");
    locald = new d(aIF.getWritableDatabase());
    for (;;)
    {
      try
      {
        locald.beginTransaction();
        b localb = new b();
        localb.setName("CAMERA");
        l = f(localb);
        if (l >= 0L) {
          locald.b("UPDATE config SET camera_roll_doc_id=?;", new String[] { String.valueOf(l) });
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        long l = -1L;
        this.mLog.g("Exception adding camera roll document", localSQLiteException1);
        this.aII = OperationStatus.awd;
        continue;
      }
      finally
      {
        locald.endTransaction();
      }
      try
      {
        this.aII = OperationStatus.avC;
        locald.endTransaction();
        return l;
      }
      catch (SQLiteException localSQLiteException2)
      {
        continue;
      }
      this.aII = OperationStatus.awd;
      l = -1L;
    }
  }
  
  /* Error */
  private long Ix()
  {
    // Byte code:
    //   0: new 134	com/mobisystems/mobiscanner/model/d
    //   3: dup
    //   4: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   7: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   13: astore 8
    //   15: aload 8
    //   17: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   20: aload 8
    //   22: ldc -65
    //   24: aconst_null
    //   25: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   28: pop
    //   29: aload 8
    //   31: ldc -63
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +17 -> 59
    //   45: aload 5
    //   47: astore 6
    //   49: aload 5
    //   51: invokeinterface 200 1 0
    //   56: ifne +61 -> 117
    //   59: aload 5
    //   61: astore 6
    //   63: new 130	android/database/sqlite/SQLiteException
    //   66: dup
    //   67: ldc -54
    //   69: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   72: athrow
    //   73: astore 7
    //   75: ldc2_w 181
    //   78: lstore_1
    //   79: aload 5
    //   81: astore 6
    //   83: aload_0
    //   84: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   87: ldc -50
    //   89: aload 7
    //   91: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload 8
    //   96: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   99: lload_1
    //   100: lstore_3
    //   101: aload 5
    //   103: ifnull +12 -> 115
    //   106: aload 5
    //   108: invokeinterface 99 1 0
    //   113: lload_1
    //   114: lstore_3
    //   115: lload_3
    //   116: lreturn
    //   117: aload 5
    //   119: astore 6
    //   121: aload 5
    //   123: iconst_0
    //   124: invokeinterface 210 2 0
    //   129: lstore_1
    //   130: aload 5
    //   132: astore 6
    //   134: aload 8
    //   136: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   139: aload 8
    //   141: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   144: lload_1
    //   145: lstore_3
    //   146: aload 5
    //   148: ifnull -33 -> 115
    //   151: goto -45 -> 106
    //   154: astore 5
    //   156: aconst_null
    //   157: astore 6
    //   159: aload 8
    //   161: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   164: aload 6
    //   166: ifnull +10 -> 176
    //   169: aload 6
    //   171: invokeinterface 99 1 0
    //   176: aload 5
    //   178: athrow
    //   179: astore 5
    //   181: goto -22 -> 159
    //   184: astore 7
    //   186: aconst_null
    //   187: astore 5
    //   189: ldc2_w 181
    //   192: lstore_1
    //   193: goto -114 -> 79
    //   196: astore 7
    //   198: goto -119 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	DocumentModel
    //   78	115	1	l1	long
    //   100	46	3	l2	long
    //   38	109	5	localCursor1	Cursor
    //   154	23	5	localObject1	Object
    //   179	1	5	localObject2	Object
    //   187	1	5	localObject3	Object
    //   47	123	6	localCursor2	Cursor
    //   73	17	7	localSQLiteException1	SQLiteException
    //   184	1	7	localSQLiteException2	SQLiteException
    //   196	1	7	localSQLiteException3	SQLiteException
    //   13	147	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   49	59	73	android/database/sqlite/SQLiteException
    //   63	73	73	android/database/sqlite/SQLiteException
    //   121	130	73	android/database/sqlite/SQLiteException
    //   15	40	154	finally
    //   49	59	179	finally
    //   63	73	179	finally
    //   83	94	179	finally
    //   121	130	179	finally
    //   134	139	179	finally
    //   15	40	184	android/database/sqlite/SQLiteException
    //   134	139	196	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  private long a(long paramLong, String paramString, boolean paramBoolean, byte[] paramArrayOfByte, c paramc)
  {
    // Byte code:
    //   0: new 134	com/mobisystems/mobiscanner/model/d
    //   3: dup
    //   4: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   7: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   13: astore 10
    //   15: aload 10
    //   17: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   20: lload_1
    //   21: lstore 8
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: ifge +14 -> 40
    //   29: aload_0
    //   30: aload 6
    //   32: invokevirtual 223	com/mobisystems/mobiscanner/model/c:IS	()Lcom/mobisystems/mobiscanner/model/b;
    //   35: invokevirtual 156	com/mobisystems/mobiscanner/model/DocumentModel:f	(Lcom/mobisystems/mobiscanner/model/b;)J
    //   38: lstore 8
    //   40: aload_0
    //   41: lload 8
    //   43: invokevirtual 227	com/mobisystems/mobiscanner/model/DocumentModel:ai	(J)I
    //   46: istore 7
    //   48: iload 7
    //   50: iflt +1698 -> 1748
    //   53: aload_3
    //   54: ifnull +705 -> 759
    //   57: aload_3
    //   58: ldc -27
    //   60: invokevirtual 233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +696 -> 759
    //   66: new 235	java/io/File
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload 6
    //   78: invokevirtual 240	com/mobisystems/mobiscanner/model/c:Jk	()I
    //   81: ifne +98 -> 179
    //   84: new 242	android/media/ExifInterface
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 243	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   92: astore_3
    //   93: iconst_2
    //   94: newarray <illegal type>
    //   96: astore 11
    //   98: aload_3
    //   99: aload 11
    //   101: invokevirtual 247	android/media/ExifInterface:getLatLong	([F)Z
    //   104: ifeq +75 -> 179
    //   107: aload 6
    //   109: aload 11
    //   111: iconst_0
    //   112: faload
    //   113: f2d
    //   114: invokevirtual 251	com/mobisystems/mobiscanner/model/c:q	(D)V
    //   117: aload 6
    //   119: aload 11
    //   121: iconst_1
    //   122: faload
    //   123: f2d
    //   124: invokevirtual 254	com/mobisystems/mobiscanner/model/c:p	(D)V
    //   127: aload 6
    //   129: aload_3
    //   130: dconst_0
    //   131: invokevirtual 258	android/media/ExifInterface:getAltitude	(D)D
    //   134: invokevirtual 261	com/mobisystems/mobiscanner/model/c:r	(D)V
    //   137: aload 6
    //   139: iconst_1
    //   140: invokevirtual 265	com/mobisystems/mobiscanner/model/c:gy	(I)V
    //   143: invokestatic 270	android/location/Geocoder:isPresent	()Z
    //   146: ifeq +33 -> 179
    //   149: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   152: invokestatic 276	com/mobisystems/mobiscanner/common/d:ap	(Landroid/content/Context;)Z
    //   155: ifeq +24 -> 179
    //   158: aload 6
    //   160: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   163: aload 11
    //   165: iconst_0
    //   166: faload
    //   167: f2d
    //   168: aload 11
    //   170: iconst_1
    //   171: faload
    //   172: f2d
    //   173: invokestatic 279	com/mobisystems/mobiscanner/common/d:a	(Landroid/content/Context;DD)Ljava/lang/String;
    //   176: invokevirtual 282	com/mobisystems/mobiscanner/model/c:dR	(Ljava/lang/String;)V
    //   179: aload 10
    //   181: ldc_w 284
    //   184: bipush 31
    //   186: anewarray 160	java/lang/String
    //   189: dup
    //   190: iconst_0
    //   191: lload 8
    //   193: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: aastore
    //   197: dup
    //   198: iconst_1
    //   199: iload 7
    //   201: iconst_1
    //   202: iadd
    //   203: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: aload 6
    //   211: invokevirtual 291	com/mobisystems/mobiscanner/model/c:IV	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   214: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   217: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   220: aastore
    //   221: dup
    //   222: iconst_3
    //   223: aload 6
    //   225: invokevirtual 300	com/mobisystems/mobiscanner/model/c:getWidth	()F
    //   228: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   231: aastore
    //   232: dup
    //   233: iconst_4
    //   234: aload 6
    //   236: invokevirtual 306	com/mobisystems/mobiscanner/model/c:getHeight	()F
    //   239: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   242: aastore
    //   243: dup
    //   244: iconst_5
    //   245: aload 6
    //   247: invokevirtual 310	com/mobisystems/mobiscanner/model/c:IW	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   250: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   253: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   256: aastore
    //   257: dup
    //   258: bipush 6
    //   260: aload 6
    //   262: invokevirtual 316	com/mobisystems/mobiscanner/model/c:IX	()F
    //   265: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   268: aastore
    //   269: dup
    //   270: bipush 7
    //   272: aload 6
    //   274: invokevirtual 319	com/mobisystems/mobiscanner/model/c:IY	()F
    //   277: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   280: aastore
    //   281: dup
    //   282: bipush 8
    //   284: aload 6
    //   286: invokevirtual 322	com/mobisystems/mobiscanner/model/c:IZ	()F
    //   289: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: bipush 9
    //   296: aload 6
    //   298: invokevirtual 325	com/mobisystems/mobiscanner/model/c:Ja	()F
    //   301: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   304: aastore
    //   305: dup
    //   306: bipush 10
    //   308: aload 6
    //   310: invokevirtual 329	com/mobisystems/mobiscanner/model/c:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   313: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   316: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   319: aastore
    //   320: dup
    //   321: bipush 11
    //   323: aload 6
    //   325: invokevirtual 336	com/mobisystems/mobiscanner/model/c:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   328: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   331: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   334: aastore
    //   335: dup
    //   336: bipush 12
    //   338: aload 6
    //   340: invokevirtual 343	com/mobisystems/mobiscanner/model/c:Jb	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   343: invokevirtual 346	com/mobisystems/mobiscanner/image/ImageOrientation:Dp	()I
    //   346: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   349: aastore
    //   350: dup
    //   351: bipush 13
    //   353: aload 6
    //   355: invokevirtual 349	com/mobisystems/mobiscanner/model/c:Jg	()Z
    //   358: invokestatic 352	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   361: aastore
    //   362: dup
    //   363: bipush 14
    //   365: aload 6
    //   367: invokevirtual 355	com/mobisystems/mobiscanner/model/c:Jh	()F
    //   370: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   373: aastore
    //   374: dup
    //   375: bipush 15
    //   377: aload 6
    //   379: invokevirtual 358	com/mobisystems/mobiscanner/model/c:Ji	()F
    //   382: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   385: aastore
    //   386: dup
    //   387: bipush 16
    //   389: aload 6
    //   391: invokevirtual 361	com/mobisystems/mobiscanner/model/c:Jj	()F
    //   394: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   397: aastore
    //   398: dup
    //   399: bipush 17
    //   401: aload 6
    //   403: invokevirtual 240	com/mobisystems/mobiscanner/model/c:Jk	()I
    //   406: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   409: aastore
    //   410: dup
    //   411: bipush 18
    //   413: aload 6
    //   415: invokevirtual 365	com/mobisystems/mobiscanner/model/c:Jl	()D
    //   418: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   421: aastore
    //   422: dup
    //   423: bipush 19
    //   425: aload 6
    //   427: invokevirtual 371	com/mobisystems/mobiscanner/model/c:Jm	()D
    //   430: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   433: aastore
    //   434: dup
    //   435: bipush 20
    //   437: aload 6
    //   439: invokevirtual 374	com/mobisystems/mobiscanner/model/c:Jn	()D
    //   442: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   445: aastore
    //   446: dup
    //   447: bipush 21
    //   449: aload 5
    //   451: invokevirtual 378	java/io/File:getName	()Ljava/lang/String;
    //   454: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   457: aastore
    //   458: dup
    //   459: bipush 22
    //   461: aload 6
    //   463: invokevirtual 384	com/mobisystems/mobiscanner/model/c:Jq	()Ljava/lang/String;
    //   466: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   469: aastore
    //   470: dup
    //   471: bipush 23
    //   473: aload 6
    //   475: invokevirtual 387	com/mobisystems/mobiscanner/model/c:Jr	()Ljava/lang/String;
    //   478: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   481: aastore
    //   482: dup
    //   483: bipush 24
    //   485: aload 6
    //   487: invokevirtual 390	com/mobisystems/mobiscanner/model/c:Js	()Ljava/lang/String;
    //   490: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   493: aastore
    //   494: dup
    //   495: bipush 25
    //   497: aload 6
    //   499: invokevirtual 394	com/mobisystems/mobiscanner/model/c:Jt	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   502: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   505: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   508: aastore
    //   509: dup
    //   510: bipush 26
    //   512: aload 6
    //   514: invokevirtual 400	com/mobisystems/mobiscanner/model/c:Ju	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   517: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   520: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   523: aastore
    //   524: dup
    //   525: bipush 27
    //   527: aload 6
    //   529: invokevirtual 403	com/mobisystems/mobiscanner/model/c:Jv	()I
    //   532: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   535: aastore
    //   536: dup
    //   537: bipush 28
    //   539: aload 6
    //   541: invokevirtual 406	com/mobisystems/mobiscanner/model/c:Jw	()J
    //   544: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   547: aastore
    //   548: dup
    //   549: bipush 29
    //   551: aload 6
    //   553: invokevirtual 409	com/mobisystems/mobiscanner/model/c:Jx	()I
    //   556: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   559: aastore
    //   560: dup
    //   561: bipush 30
    //   563: aload 6
    //   565: invokevirtual 412	com/mobisystems/mobiscanner/model/c:Jy	()F
    //   568: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   571: aastore
    //   572: invokevirtual 415	com/mobisystems/mobiscanner/model/d:a	(Ljava/lang/String;[Ljava/lang/String;)J
    //   575: lstore_1
    //   576: aload 10
    //   578: ldc_w 417
    //   581: iconst_2
    //   582: anewarray 160	java/lang/String
    //   585: dup
    //   586: iconst_0
    //   587: lload_1
    //   588: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   591: aastore
    //   592: dup
    //   593: iconst_1
    //   594: lload_1
    //   595: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   598: aastore
    //   599: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   602: pop
    //   603: new 419	com/mobisystems/mobiscanner/image/Image
    //   606: dup
    //   607: aload 5
    //   609: invokespecial 422	com/mobisystems/mobiscanner/image/Image:<init>	(Ljava/io/File;)V
    //   612: pop
    //   613: aload_0
    //   614: lload_1
    //   615: invokespecial 426	com/mobisystems/mobiscanner/model/DocumentModel:as	(J)Ljava/io/File;
    //   618: astore_3
    //   619: iload 4
    //   621: ifeq +95 -> 716
    //   624: aload 5
    //   626: aload_3
    //   627: invokestatic 429	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/File;Ljava/io/File;)V
    //   630: iload 7
    //   632: ifne +31 -> 663
    //   635: aload 10
    //   637: ldc_w 431
    //   640: iconst_2
    //   641: anewarray 160	java/lang/String
    //   644: dup
    //   645: iconst_0
    //   646: lload_1
    //   647: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   650: aastore
    //   651: dup
    //   652: iconst_1
    //   653: lload 8
    //   655: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   658: aastore
    //   659: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   662: pop
    //   663: aload 6
    //   665: invokevirtual 434	com/mobisystems/mobiscanner/model/c:getId	()J
    //   668: ldc2_w 181
    //   671: lcmp
    //   672: ifle +14 -> 686
    //   675: aload_0
    //   676: aload 6
    //   678: invokevirtual 434	com/mobisystems/mobiscanner/model/c:getId	()J
    //   681: lload_1
    //   682: invokevirtual 438	com/mobisystems/mobiscanner/model/DocumentModel:h	(JJ)Z
    //   685: pop
    //   686: aload_0
    //   687: lload_1
    //   688: invokespecial 442	com/mobisystems/mobiscanner/model/DocumentModel:aE	(J)V
    //   691: aload 10
    //   693: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   696: aload_0
    //   697: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   700: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   703: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   706: invokestatic 446	com/mobisystems/mobiscanner/common/d:an	(Landroid/content/Context;)V
    //   709: aload 10
    //   711: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   714: lload_1
    //   715: lreturn
    //   716: aload 5
    //   718: aload_3
    //   719: invokestatic 448	com/mobisystems/mobiscanner/common/d:b	(Ljava/io/File;Ljava/io/File;)V
    //   722: goto -92 -> 630
    //   725: astore_3
    //   726: ldc2_w 181
    //   729: lstore_1
    //   730: aload_0
    //   731: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   734: ldc_w 450
    //   737: aload_3
    //   738: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   741: aload_0
    //   742: getstatic 453	com/mobisystems/mobiscanner/common/OperationStatus:awh	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   745: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   748: goto -39 -> 709
    //   751: astore_3
    //   752: aload 10
    //   754: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   757: aload_3
    //   758: athrow
    //   759: aload 5
    //   761: ifnull +476 -> 1237
    //   764: aload 10
    //   766: ldc_w 284
    //   769: bipush 31
    //   771: anewarray 160	java/lang/String
    //   774: dup
    //   775: iconst_0
    //   776: lload 8
    //   778: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   781: aastore
    //   782: dup
    //   783: iconst_1
    //   784: iload 7
    //   786: iconst_1
    //   787: iadd
    //   788: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   791: aastore
    //   792: dup
    //   793: iconst_2
    //   794: aload 6
    //   796: invokevirtual 291	com/mobisystems/mobiscanner/model/c:IV	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   799: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   802: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   805: aastore
    //   806: dup
    //   807: iconst_3
    //   808: aload 6
    //   810: invokevirtual 300	com/mobisystems/mobiscanner/model/c:getWidth	()F
    //   813: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   816: aastore
    //   817: dup
    //   818: iconst_4
    //   819: aload 6
    //   821: invokevirtual 306	com/mobisystems/mobiscanner/model/c:getHeight	()F
    //   824: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   827: aastore
    //   828: dup
    //   829: iconst_5
    //   830: aload 6
    //   832: invokevirtual 310	com/mobisystems/mobiscanner/model/c:IW	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   835: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   838: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   841: aastore
    //   842: dup
    //   843: bipush 6
    //   845: aload 6
    //   847: invokevirtual 316	com/mobisystems/mobiscanner/model/c:IX	()F
    //   850: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   853: aastore
    //   854: dup
    //   855: bipush 7
    //   857: aload 6
    //   859: invokevirtual 319	com/mobisystems/mobiscanner/model/c:IY	()F
    //   862: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   865: aastore
    //   866: dup
    //   867: bipush 8
    //   869: aload 6
    //   871: invokevirtual 322	com/mobisystems/mobiscanner/model/c:IZ	()F
    //   874: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   877: aastore
    //   878: dup
    //   879: bipush 9
    //   881: aload 6
    //   883: invokevirtual 325	com/mobisystems/mobiscanner/model/c:Ja	()F
    //   886: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   889: aastore
    //   890: dup
    //   891: bipush 10
    //   893: aload 6
    //   895: invokevirtual 329	com/mobisystems/mobiscanner/model/c:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   898: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   901: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   904: aastore
    //   905: dup
    //   906: bipush 11
    //   908: aload 6
    //   910: invokevirtual 336	com/mobisystems/mobiscanner/model/c:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   913: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   916: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   919: aastore
    //   920: dup
    //   921: bipush 12
    //   923: aload 6
    //   925: invokevirtual 343	com/mobisystems/mobiscanner/model/c:Jb	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   928: invokevirtual 346	com/mobisystems/mobiscanner/image/ImageOrientation:Dp	()I
    //   931: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   934: aastore
    //   935: dup
    //   936: bipush 13
    //   938: aload 6
    //   940: invokevirtual 349	com/mobisystems/mobiscanner/model/c:Jg	()Z
    //   943: invokestatic 352	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   946: aastore
    //   947: dup
    //   948: bipush 14
    //   950: aload 6
    //   952: invokevirtual 355	com/mobisystems/mobiscanner/model/c:Jh	()F
    //   955: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   958: aastore
    //   959: dup
    //   960: bipush 15
    //   962: aload 6
    //   964: invokevirtual 358	com/mobisystems/mobiscanner/model/c:Ji	()F
    //   967: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   970: aastore
    //   971: dup
    //   972: bipush 16
    //   974: aload 6
    //   976: invokevirtual 361	com/mobisystems/mobiscanner/model/c:Jj	()F
    //   979: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   982: aastore
    //   983: dup
    //   984: bipush 17
    //   986: aload 6
    //   988: invokevirtual 240	com/mobisystems/mobiscanner/model/c:Jk	()I
    //   991: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   994: aastore
    //   995: dup
    //   996: bipush 18
    //   998: aload 6
    //   1000: invokevirtual 365	com/mobisystems/mobiscanner/model/c:Jl	()D
    //   1003: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1006: aastore
    //   1007: dup
    //   1008: bipush 19
    //   1010: aload 6
    //   1012: invokevirtual 371	com/mobisystems/mobiscanner/model/c:Jm	()D
    //   1015: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1018: aastore
    //   1019: dup
    //   1020: bipush 20
    //   1022: aload 6
    //   1024: invokevirtual 374	com/mobisystems/mobiscanner/model/c:Jn	()D
    //   1027: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1030: aastore
    //   1031: dup
    //   1032: bipush 21
    //   1034: aload 6
    //   1036: invokevirtual 456	com/mobisystems/mobiscanner/model/c:Jp	()Ljava/lang/String;
    //   1039: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1042: aastore
    //   1043: dup
    //   1044: bipush 22
    //   1046: aload 6
    //   1048: invokevirtual 384	com/mobisystems/mobiscanner/model/c:Jq	()Ljava/lang/String;
    //   1051: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1054: aastore
    //   1055: dup
    //   1056: bipush 23
    //   1058: aload 6
    //   1060: invokevirtual 387	com/mobisystems/mobiscanner/model/c:Jr	()Ljava/lang/String;
    //   1063: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1066: aastore
    //   1067: dup
    //   1068: bipush 24
    //   1070: aload 6
    //   1072: invokevirtual 390	com/mobisystems/mobiscanner/model/c:Js	()Ljava/lang/String;
    //   1075: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1078: aastore
    //   1079: dup
    //   1080: bipush 25
    //   1082: aload 6
    //   1084: invokevirtual 394	com/mobisystems/mobiscanner/model/c:Jt	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   1087: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   1090: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1093: aastore
    //   1094: dup
    //   1095: bipush 26
    //   1097: aload 6
    //   1099: invokevirtual 400	com/mobisystems/mobiscanner/model/c:Ju	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   1102: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   1105: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1108: aastore
    //   1109: dup
    //   1110: bipush 27
    //   1112: aload 6
    //   1114: invokevirtual 403	com/mobisystems/mobiscanner/model/c:Jv	()I
    //   1117: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1120: aastore
    //   1121: dup
    //   1122: bipush 28
    //   1124: aload 6
    //   1126: invokevirtual 406	com/mobisystems/mobiscanner/model/c:Jw	()J
    //   1129: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1132: aastore
    //   1133: dup
    //   1134: bipush 29
    //   1136: aload 6
    //   1138: invokevirtual 409	com/mobisystems/mobiscanner/model/c:Jx	()I
    //   1141: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1144: aastore
    //   1145: dup
    //   1146: bipush 30
    //   1148: aload 6
    //   1150: invokevirtual 412	com/mobisystems/mobiscanner/model/c:Jy	()F
    //   1153: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1156: aastore
    //   1157: invokevirtual 415	com/mobisystems/mobiscanner/model/d:a	(Ljava/lang/String;[Ljava/lang/String;)J
    //   1160: lstore_1
    //   1161: aload 10
    //   1163: ldc_w 417
    //   1166: iconst_2
    //   1167: anewarray 160	java/lang/String
    //   1170: dup
    //   1171: iconst_0
    //   1172: lload_1
    //   1173: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1176: aastore
    //   1177: dup
    //   1178: iconst_1
    //   1179: lload_1
    //   1180: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1183: aastore
    //   1184: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   1187: pop
    //   1188: new 419	com/mobisystems/mobiscanner/image/Image
    //   1191: dup
    //   1192: aload 5
    //   1194: invokespecial 459	com/mobisystems/mobiscanner/image/Image:<init>	([B)V
    //   1197: pop
    //   1198: aload 5
    //   1200: aload_0
    //   1201: lload_1
    //   1202: invokespecial 426	com/mobisystems/mobiscanner/model/DocumentModel:as	(J)Ljava/io/File;
    //   1205: invokestatic 462	com/mobisystems/mobiscanner/common/d:a	([BLjava/io/File;)V
    //   1208: goto -578 -> 630
    //   1211: astore_3
    //   1212: ldc2_w 181
    //   1215: lstore_1
    //   1216: aload_0
    //   1217: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1220: ldc_w 464
    //   1223: aload_3
    //   1224: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1227: aload_0
    //   1228: getstatic 467	com/mobisystems/mobiscanner/common/OperationStatus:awg	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1231: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1234: goto -525 -> 709
    //   1237: aload 10
    //   1239: ldc_w 469
    //   1242: bipush 35
    //   1244: anewarray 160	java/lang/String
    //   1247: dup
    //   1248: iconst_0
    //   1249: lload 8
    //   1251: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_1
    //   1257: aload 6
    //   1259: invokevirtual 472	com/mobisystems/mobiscanner/model/c:IT	()J
    //   1262: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1265: aastore
    //   1266: dup
    //   1267: iconst_2
    //   1268: iload 7
    //   1270: iconst_1
    //   1271: iadd
    //   1272: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1275: aastore
    //   1276: dup
    //   1277: iconst_3
    //   1278: aload 6
    //   1280: invokevirtual 291	com/mobisystems/mobiscanner/model/c:IV	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   1283: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   1286: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1289: aastore
    //   1290: dup
    //   1291: iconst_4
    //   1292: aload 6
    //   1294: invokevirtual 300	com/mobisystems/mobiscanner/model/c:getWidth	()F
    //   1297: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1300: aastore
    //   1301: dup
    //   1302: iconst_5
    //   1303: aload 6
    //   1305: invokevirtual 306	com/mobisystems/mobiscanner/model/c:getHeight	()F
    //   1308: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1311: aastore
    //   1312: dup
    //   1313: bipush 6
    //   1315: aload 6
    //   1317: invokevirtual 310	com/mobisystems/mobiscanner/model/c:IW	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   1320: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   1323: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1326: aastore
    //   1327: dup
    //   1328: bipush 7
    //   1330: aload 6
    //   1332: invokevirtual 316	com/mobisystems/mobiscanner/model/c:IX	()F
    //   1335: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1338: aastore
    //   1339: dup
    //   1340: bipush 8
    //   1342: aload 6
    //   1344: invokevirtual 319	com/mobisystems/mobiscanner/model/c:IY	()F
    //   1347: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1350: aastore
    //   1351: dup
    //   1352: bipush 9
    //   1354: aload 6
    //   1356: invokevirtual 322	com/mobisystems/mobiscanner/model/c:IZ	()F
    //   1359: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1362: aastore
    //   1363: dup
    //   1364: bipush 10
    //   1366: aload 6
    //   1368: invokevirtual 325	com/mobisystems/mobiscanner/model/c:Ja	()F
    //   1371: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1374: aastore
    //   1375: dup
    //   1376: bipush 11
    //   1378: aload 6
    //   1380: invokevirtual 329	com/mobisystems/mobiscanner/model/c:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   1383: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   1386: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1389: aastore
    //   1390: dup
    //   1391: bipush 12
    //   1393: aload 6
    //   1395: invokevirtual 336	com/mobisystems/mobiscanner/model/c:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   1398: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   1401: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1404: aastore
    //   1405: dup
    //   1406: bipush 13
    //   1408: aload 6
    //   1410: invokevirtual 343	com/mobisystems/mobiscanner/model/c:Jb	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   1413: invokevirtual 346	com/mobisystems/mobiscanner/image/ImageOrientation:Dp	()I
    //   1416: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1419: aastore
    //   1420: dup
    //   1421: bipush 14
    //   1423: aload 6
    //   1425: invokevirtual 475	com/mobisystems/mobiscanner/model/c:Jc	()J
    //   1428: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1431: aastore
    //   1432: dup
    //   1433: bipush 15
    //   1435: aload 6
    //   1437: invokevirtual 478	com/mobisystems/mobiscanner/model/c:Jd	()I
    //   1440: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1443: aastore
    //   1444: dup
    //   1445: bipush 16
    //   1447: aload 6
    //   1449: invokevirtual 481	com/mobisystems/mobiscanner/model/c:Jf	()Ljava/lang/String;
    //   1452: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1455: aastore
    //   1456: dup
    //   1457: bipush 17
    //   1459: aload 6
    //   1461: invokevirtual 349	com/mobisystems/mobiscanner/model/c:Jg	()Z
    //   1464: invokestatic 352	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1467: aastore
    //   1468: dup
    //   1469: bipush 18
    //   1471: aload 6
    //   1473: invokevirtual 355	com/mobisystems/mobiscanner/model/c:Jh	()F
    //   1476: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1479: aastore
    //   1480: dup
    //   1481: bipush 19
    //   1483: aload 6
    //   1485: invokevirtual 358	com/mobisystems/mobiscanner/model/c:Ji	()F
    //   1488: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1491: aastore
    //   1492: dup
    //   1493: bipush 20
    //   1495: aload 6
    //   1497: invokevirtual 361	com/mobisystems/mobiscanner/model/c:Jj	()F
    //   1500: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1503: aastore
    //   1504: dup
    //   1505: bipush 21
    //   1507: aload 6
    //   1509: invokevirtual 240	com/mobisystems/mobiscanner/model/c:Jk	()I
    //   1512: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1515: aastore
    //   1516: dup
    //   1517: bipush 22
    //   1519: aload 6
    //   1521: invokevirtual 365	com/mobisystems/mobiscanner/model/c:Jl	()D
    //   1524: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1527: aastore
    //   1528: dup
    //   1529: bipush 23
    //   1531: aload 6
    //   1533: invokevirtual 371	com/mobisystems/mobiscanner/model/c:Jm	()D
    //   1536: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1539: aastore
    //   1540: dup
    //   1541: bipush 24
    //   1543: aload 6
    //   1545: invokevirtual 374	com/mobisystems/mobiscanner/model/c:Jn	()D
    //   1548: invokestatic 368	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   1551: aastore
    //   1552: dup
    //   1553: bipush 25
    //   1555: aload 6
    //   1557: invokevirtual 456	com/mobisystems/mobiscanner/model/c:Jp	()Ljava/lang/String;
    //   1560: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1563: aastore
    //   1564: dup
    //   1565: bipush 26
    //   1567: aload 6
    //   1569: invokevirtual 384	com/mobisystems/mobiscanner/model/c:Jq	()Ljava/lang/String;
    //   1572: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1575: aastore
    //   1576: dup
    //   1577: bipush 27
    //   1579: aload 6
    //   1581: invokevirtual 387	com/mobisystems/mobiscanner/model/c:Jr	()Ljava/lang/String;
    //   1584: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1587: aastore
    //   1588: dup
    //   1589: bipush 28
    //   1591: aload 6
    //   1593: invokevirtual 390	com/mobisystems/mobiscanner/model/c:Js	()Ljava/lang/String;
    //   1596: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1599: aastore
    //   1600: dup
    //   1601: bipush 29
    //   1603: aload 6
    //   1605: invokevirtual 394	com/mobisystems/mobiscanner/model/c:Jt	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   1608: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   1611: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1614: aastore
    //   1615: dup
    //   1616: bipush 30
    //   1618: aload 6
    //   1620: invokevirtual 400	com/mobisystems/mobiscanner/model/c:Ju	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   1623: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   1626: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1629: aastore
    //   1630: dup
    //   1631: bipush 31
    //   1633: aload 6
    //   1635: invokevirtual 403	com/mobisystems/mobiscanner/model/c:Jv	()I
    //   1638: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1641: aastore
    //   1642: dup
    //   1643: bipush 32
    //   1645: aload 6
    //   1647: invokevirtual 406	com/mobisystems/mobiscanner/model/c:Jw	()J
    //   1650: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1653: aastore
    //   1654: dup
    //   1655: bipush 33
    //   1657: aload 6
    //   1659: invokevirtual 409	com/mobisystems/mobiscanner/model/c:Jx	()I
    //   1662: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1665: aastore
    //   1666: dup
    //   1667: bipush 34
    //   1669: aload 6
    //   1671: invokevirtual 412	com/mobisystems/mobiscanner/model/c:Jy	()F
    //   1674: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   1677: aastore
    //   1678: invokevirtual 415	com/mobisystems/mobiscanner/model/d:a	(Ljava/lang/String;[Ljava/lang/String;)J
    //   1681: lstore_1
    //   1682: goto -1052 -> 630
    //   1685: astore_3
    //   1686: ldc2_w 181
    //   1689: lstore_1
    //   1690: aload_0
    //   1691: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1694: ldc_w 483
    //   1697: aload_3
    //   1698: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1701: aload_0
    //   1702: getstatic 486	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1705: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1708: goto -999 -> 709
    //   1711: aload_0
    //   1712: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1715: ldc_w 488
    //   1718: aload_3
    //   1719: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1722: aload_0
    //   1723: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1726: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1729: goto -1020 -> 709
    //   1732: astore_3
    //   1733: goto -22 -> 1711
    //   1736: astore_3
    //   1737: goto -47 -> 1690
    //   1740: astore_3
    //   1741: goto -525 -> 1216
    //   1744: astore_3
    //   1745: goto -1015 -> 730
    //   1748: ldc2_w 181
    //   1751: lstore_1
    //   1752: goto -1043 -> 709
    //   1755: astore_3
    //   1756: ldc2_w 181
    //   1759: lstore_1
    //   1760: goto -49 -> 1711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1763	0	this	DocumentModel
    //   0	1763	1	paramLong	long
    //   0	1763	3	paramString	String
    //   0	1763	4	paramBoolean	boolean
    //   0	1763	5	paramArrayOfByte	byte[]
    //   0	1763	6	paramc	c
    //   46	1226	7	i	int
    //   21	1229	8	l	long
    //   13	1225	10	locald	d
    //   96	73	11	arrayOfFloat	float[]
    // Exception table:
    //   from	to	target	type
    //   15	20	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   29	40	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   40	48	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   57	179	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   179	619	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   624	630	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   635	663	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   663	686	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   686	696	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   716	722	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   764	1208	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   1237	1682	725	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   15	20	751	finally
    //   29	40	751	finally
    //   40	48	751	finally
    //   57	179	751	finally
    //   179	619	751	finally
    //   624	630	751	finally
    //   635	663	751	finally
    //   663	686	751	finally
    //   686	696	751	finally
    //   696	709	751	finally
    //   716	722	751	finally
    //   730	748	751	finally
    //   764	1208	751	finally
    //   1216	1234	751	finally
    //   1237	1682	751	finally
    //   1690	1708	751	finally
    //   1711	1729	751	finally
    //   15	20	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   29	40	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   40	48	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   57	179	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   179	619	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   624	630	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   635	663	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   663	686	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   686	696	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   716	722	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   764	1208	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   1237	1682	1211	com/mobisystems/mobiscanner/image/Image$ImageException
    //   15	20	1685	java/io/IOException
    //   29	40	1685	java/io/IOException
    //   40	48	1685	java/io/IOException
    //   57	179	1685	java/io/IOException
    //   179	619	1685	java/io/IOException
    //   624	630	1685	java/io/IOException
    //   635	663	1685	java/io/IOException
    //   663	686	1685	java/io/IOException
    //   686	696	1685	java/io/IOException
    //   716	722	1685	java/io/IOException
    //   764	1208	1685	java/io/IOException
    //   1237	1682	1685	java/io/IOException
    //   696	709	1732	android/database/sqlite/SQLiteException
    //   696	709	1736	java/io/IOException
    //   696	709	1740	com/mobisystems/mobiscanner/image/Image$ImageException
    //   696	709	1744	com/mobisystems/mobiscanner/image/Image$InvalidImageTypeException
    //   15	20	1755	android/database/sqlite/SQLiteException
    //   29	40	1755	android/database/sqlite/SQLiteException
    //   40	48	1755	android/database/sqlite/SQLiteException
    //   57	179	1755	android/database/sqlite/SQLiteException
    //   179	619	1755	android/database/sqlite/SQLiteException
    //   624	630	1755	android/database/sqlite/SQLiteException
    //   635	663	1755	android/database/sqlite/SQLiteException
    //   663	686	1755	android/database/sqlite/SQLiteException
    //   686	696	1755	android/database/sqlite/SQLiteException
    //   716	722	1755	android/database/sqlite/SQLiteException
    //   764	1208	1755	android/database/sqlite/SQLiteException
    //   1237	1682	1755	android/database/sqlite/SQLiteException
  }
  
  private long a(c paramc, b paramb, int paramInt)
  {
    long l = a(paramb.getId(), null, false, null, paramc);
    if (l < 0L) {
      throw new IOException("Error adding page " + l);
    }
    int i = paramb.IL();
    if ((paramInt > 0) && (paramInt <= i) && (!a(paramb.getId(), i + 1, paramInt))) {
      throw new IOException("Error moving page " + l);
    }
    return l;
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    int k = 0;
    j = 0;
    i = k;
    try
    {
      if (Class.forName("android.os.OperationCanceledException").isInstance(paramRuntimeException))
      {
        i = k;
        this.mLog.dl("Operation cancelled");
        i = 1;
        j = 1;
        this.aII = OperationStatus.avD;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        j = i;
      }
    }
    if (j == 0)
    {
      this.mLog.g("Runtime exception:", paramRuntimeException);
      this.aII = OperationStatus.awf;
    }
  }
  
  private boolean a(long paramLong, String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject9 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Cursor localCursor1 = null;
    this.aII = OperationStatus.awf;
    d locald = new d(aIF.getWritableDatabase());
    Cursor localCursor2 = localCursor1;
    Object localObject2 = localObject5;
    Object localObject3 = localObject6;
    Object localObject4 = localObject7;
    Object localObject1 = localObject8;
    for (;;)
    {
      try
      {
        locald.beginTransaction();
        localObject1 = localObject9;
        if (paramLong >= 0L)
        {
          localCursor2 = localCursor1;
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject4 = localObject7;
          localObject1 = localObject8;
          localCursor1 = locald.rawQuery("SELECT doc_id, proc_image_id FROM pages WHERE id = ?;", new String[] { String.valueOf(paramLong) }, null);
          if (localCursor1 != null)
          {
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            if (localCursor1.moveToFirst()) {}
          }
          else
          {
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            throw new SQLiteException("Could not get page to delete");
          }
        }
      }
      catch (Image.InvalidImageTypeException paramString)
      {
        localObject1 = localCursor2;
        this.mLog.g("Invalid Image Type Exception while adding processed image", paramString);
        localObject1 = localCursor2;
        this.aII = OperationStatus.awh;
        locald.endTransaction();
        if (localCursor2 != null)
        {
          paramString = localCursor2;
          paramString.close();
        }
        if (this.aII == OperationStatus.avC)
        {
          return true;
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l1 = localCursor1.getLong(0);
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l2 = localCursor1.getLong(1);
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l3 = Ix();
          localObject1 = localCursor1;
          if (l3 >= 0L)
          {
            i = 0;
            if (paramString == null) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            if (paramString.equals("")) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            locald.b("UPDATE pages SET proc_image_id = ?, proc_image_orientation = ?, image_version = 1, last_modification_time = strftime('%s', 'now') WHERE id=?;", new String[] { String.valueOf(l3), String.valueOf(ImageOrientation.aHV.Dp()), String.valueOf(paramLong) });
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            paramString = new File(paramString);
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            new Image(paramString);
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            paramArrayOfByte = au(paramLong);
            if (!paramBoolean) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            com.mobisystems.mobiscanner.common.d.a(paramString, paramArrayOfByte);
            break label1023;
            localObject1 = localCursor1;
            if (i != 0)
            {
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              aK(paramLong);
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              aD(l1);
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              locald.setTransactionSuccessful();
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              this.aII = OperationStatus.avC;
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              am(l2);
              localObject1 = localCursor1;
            }
          }
          locald.endTransaction();
          if (localObject1 == null) {
            continue;
          }
          paramString = (String)localObject1;
          continue;
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          com.mobisystems.mobiscanner.common.d.b(paramString, paramArrayOfByte);
        }
      }
      catch (Image.ImageException paramString)
      {
        localObject1 = localObject2;
        this.mLog.g("Image Exception while adding processed image", paramString);
        localObject1 = localObject2;
        this.aII = OperationStatus.awg;
        locald.endTransaction();
        if (localObject2 == null) {
          continue;
        }
        paramString = (String)localObject2;
        continue;
        if (paramArrayOfByte == null) {
          continue;
        }
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        locald.b("UPDATE pages SET proc_image_id = ?, proc_image_orientation = ?, image_version = 1, last_modification_time = strftime('%s', 'now') WHERE id=?;", new String[] { String.valueOf(paramLong), String.valueOf(ImageOrientation.aHV.Dp()), String.valueOf(paramLong) });
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        new Image(paramArrayOfByte);
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        com.mobisystems.mobiscanner.common.d.a(paramArrayOfByte, au(paramLong));
        i = 1;
        continue;
      }
      catch (IOException paramString)
      {
        localObject1 = localObject3;
        this.mLog.g("IO Exception while adding processed image", paramString);
        localObject1 = localObject3;
        this.aII = OperationStatus.awe;
        locald.endTransaction();
        if (localObject3 == null) {
          continue;
        }
        paramString = (String)localObject3;
        continue;
      }
      catch (SQLiteException paramString)
      {
        localObject1 = localObject4;
        this.mLog.g("SQL Exception while adding processed image", paramString);
        localObject1 = localObject4;
        this.aII = OperationStatus.awd;
        locald.endTransaction();
        if (localObject4 == null) {
          continue;
        }
        paramString = (String)localObject4;
        continue;
      }
      finally
      {
        locald.endTransaction();
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      return false;
      label1023:
      int i = 1;
    }
  }
  
  private int aA(long paramLong)
  {
    this.mLog.dl("getRawImageNumPages called, rawImageId=" + paramLong);
    j = -1;
    d locald = new d(aIF.getWritableDatabase());
    Object localObject5 = null;
    Object localObject6 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    Object localObject4 = localObject5;
    localObject1 = localObject6;
    try
    {
      Ir();
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      CancellationSignal localCancellationSignal = this.aIG;
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      localCursor2 = locald.rawQuery("SELECT count(*) raw_image_num_pages FROM pages WHERE raw_image_id = ?;", new String[] { String.valueOf(paramLong) }, localCancellationSignal);
      i = j;
      if (localCursor2 != null)
      {
        i = j;
        localCursor1 = localCursor2;
        localObject4 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          localCursor1 = localCursor2;
          localObject4 = localCursor2;
          localObject1 = localCursor2;
          i = localCursor2.getInt(0);
        }
      }
      Is();
      k = i;
      if (localCursor2 == null) {
        break label203;
      }
      localCursor1 = localCursor2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject1 = localCursor1;
        this.mLog.g("Exception reading page count", localSQLiteException);
        localObject1 = localCursor1;
        this.aII = OperationStatus.awd;
        Is();
        k = j;
        if (localCursor1 != null) {
          i = j;
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i;
        label203:
        localObject1 = localSQLiteException;
        a(localRuntimeException);
        Is();
        int k = j;
        if (localSQLiteException != null)
        {
          i = j;
          Object localObject2 = localSQLiteException;
        }
      }
    }
    finally
    {
      Is();
      if (localObject1 == null) {
        break label307;
      }
      ((Cursor)localObject1).close();
    }
    localCursor1.close();
    k = i;
    return k;
  }
  
  public static void aA(Context paramContext)
  {
    apd.dl("attachDb called");
    Iq();
    mContext = paramContext;
    if (aIF == null) {
      aIF = new e(paramContext);
    }
    aIF.getWritableDatabase();
  }
  
  private int aB(long paramLong)
  {
    this.mLog.dl("getProcImageNumPages called, procImageId=" + paramLong);
    j = -1;
    d locald = new d(aIF.getWritableDatabase());
    Object localObject5 = null;
    Object localObject6 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    Object localObject4 = localObject5;
    localObject1 = localObject6;
    try
    {
      Ir();
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      CancellationSignal localCancellationSignal = this.aIG;
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      localCursor2 = locald.rawQuery("SELECT count(*) proc_image_num_pages FROM pages WHERE proc_image_id = ?;", new String[] { String.valueOf(paramLong) }, localCancellationSignal);
      i = j;
      if (localCursor2 != null)
      {
        i = j;
        localCursor1 = localCursor2;
        localObject4 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          localCursor1 = localCursor2;
          localObject4 = localCursor2;
          localObject1 = localCursor2;
          i = localCursor2.getInt(0);
        }
      }
      Is();
      k = i;
      if (localCursor2 == null) {
        break label203;
      }
      localCursor1 = localCursor2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject1 = localCursor1;
        this.mLog.g("Exception reading page count", localSQLiteException);
        localObject1 = localCursor1;
        this.aII = OperationStatus.awd;
        Is();
        k = j;
        if (localCursor1 != null) {
          i = j;
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i;
        label203:
        localObject1 = localSQLiteException;
        a(localRuntimeException);
        Is();
        int k = j;
        if (localSQLiteException != null)
        {
          i = j;
          Object localObject2 = localSQLiteException;
        }
      }
    }
    finally
    {
      Is();
      if (localObject1 == null) {
        break label307;
      }
      ((Cursor)localObject1).close();
    }
    localCursor1.close();
    k = i;
    return k;
  }
  
  private int aC(long paramLong)
  {
    this.mLog.dl("getCroppedImageNumPages called, croppedImageId=" + paramLong);
    j = -1;
    d locald = new d(aIF.getWritableDatabase());
    Object localObject5 = null;
    Object localObject6 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    Object localObject4 = localObject5;
    localObject1 = localObject6;
    try
    {
      Ir();
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      CancellationSignal localCancellationSignal = this.aIG;
      localCursor1 = localCursor2;
      localObject4 = localObject5;
      localObject1 = localObject6;
      localCursor2 = locald.rawQuery("SELECT count(*) cropped_image_num_pages FROM pages WHERE cropped_image_id = ?;", new String[] { String.valueOf(paramLong) }, localCancellationSignal);
      i = j;
      if (localCursor2 != null)
      {
        i = j;
        localCursor1 = localCursor2;
        localObject4 = localCursor2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst())
        {
          localCursor1 = localCursor2;
          localObject4 = localCursor2;
          localObject1 = localCursor2;
          i = localCursor2.getInt(0);
        }
      }
      Is();
      k = i;
      if (localCursor2 == null) {
        break label203;
      }
      localCursor1 = localCursor2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        localObject1 = localCursor1;
        this.mLog.g("Exception reading page count", localSQLiteException);
        localObject1 = localCursor1;
        this.aII = OperationStatus.awd;
        Is();
        k = j;
        if (localCursor1 != null) {
          i = j;
        }
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        int i;
        label203:
        localObject1 = localSQLiteException;
        a(localRuntimeException);
        Is();
        int k = j;
        if (localSQLiteException != null)
        {
          i = j;
          Object localObject2 = localSQLiteException;
        }
      }
    }
    finally
    {
      Is();
      if (localObject1 == null) {
        break label307;
      }
      ((Cursor)localObject1).close();
    }
    localCursor1.close();
    k = i;
    return k;
  }
  
  private void aD(long paramLong)
  {
    this.mLog.dl("updateDocTime called, docId=" + paramLong);
    d locald = new d(aIF.getWritableDatabase());
    try
    {
      locald.beginTransaction();
      locald.b("UPDATE documents SET last_modification_time = strftime('%s', 'now') WHERE id = ?;", new String[] { String.valueOf(paramLong) });
      locald.setTransactionSuccessful();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        this.mLog.g("SQL Exception updating document time", localSQLiteException);
        this.aII = OperationStatus.awd;
      }
    }
    finally
    {
      locald.endTransaction();
    }
  }
  
  private void aE(long paramLong)
  {
    this.mLog.dl("updateDocTimeByPage called, pageId=" + paramLong);
    d locald = new d(aIF.getWritableDatabase());
    try
    {
      locald.beginTransaction();
      locald.b("UPDATE documents SET last_modification_time = (SELECT last_modification_time FROM pages WHERE id = ?) WHERE id = (SELECT doc_id FROM pages WHERE id = ?);", new String[] { String.valueOf(paramLong), String.valueOf(paramLong) });
      locald.setTransactionSuccessful();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        this.mLog.g("SQL Exception updating document time", localSQLiteException);
        this.aII = OperationStatus.awd;
      }
    }
    finally
    {
      locald.endTransaction();
    }
  }
  
  private boolean am(long paramLong)
  {
    if ((paramLong >= 0L) && (aB(paramLong) == 0)) {
      try
      {
        File localFile = av(paramLong);
        if (localFile != null)
        {
          if (localFile.delete())
          {
            com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "proc_images", null));
            return false;
          }
          this.mLog.A("Could not delete processed images ID " + paramLong);
          return false;
        }
      }
      catch (IOException localIOException)
      {
        this.mLog.g("Error deleting processed image", localIOException);
      }
    }
    return false;
  }
  
  private boolean an(long paramLong)
  {
    if ((paramLong >= 0L) && (aC(paramLong) == 0)) {
      try
      {
        File localFile = ax(paramLong);
        if (localFile != null)
        {
          if (localFile.delete())
          {
            com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "proc_images", null));
            return false;
          }
          this.mLog.A("Could not delete cropped images ID " + paramLong);
          return false;
        }
      }
      catch (IOException localIOException)
      {
        this.mLog.g("Error deleting cropped image", localIOException);
      }
    }
    return false;
  }
  
  private File as(long paramLong)
  {
    c localc = aj(paramLong);
    if (localc == null) {
      throw new IOException("Error reading page " + paramLong);
    }
    return at(localc.IT());
  }
  
  private File at(long paramLong)
  {
    File localFile = com.mobisystems.mobiscanner.common.d.f(mContext, "raw_images", String.valueOf(paramLong / 1000L));
    if (!localFile.exists()) {
      throw new IOException("Can not create raw images dir");
    }
    return new File(localFile, String.valueOf(paramLong));
  }
  
  private File au(long paramLong)
  {
    c localc = aj(paramLong);
    if (localc == null) {
      throw new IOException("Error reading page " + paramLong);
    }
    File localFile = null;
    if (localc.Jd() == 1) {
      localFile = av(localc.Jc());
    }
    return localFile;
  }
  
  private File av(long paramLong)
  {
    File localFile2 = com.mobisystems.mobiscanner.common.d.f(mContext, "proc_images", String.valueOf(paramLong / 1000L));
    if (!localFile2.exists()) {
      throw new IOException("Can not create processed images dir");
    }
    File localFile1 = null;
    if (paramLong >= 0L) {
      localFile1 = new File(localFile2, String.valueOf(paramLong));
    }
    return localFile1;
  }
  
  private File aw(long paramLong)
  {
    c localc = aj(paramLong);
    if (localc == null) {
      throw new IOException("Error reading page " + paramLong);
    }
    File localFile = null;
    if (localc.Jd() == 2) {
      localFile = ax(localc.Jw());
    }
    return localFile;
  }
  
  private File ax(long paramLong)
  {
    File localFile2 = com.mobisystems.mobiscanner.common.d.f(mContext, "proc_images", String.valueOf(paramLong / 1000L));
    if (!localFile2.exists()) {
      throw new IOException("Can not create cropped images dir");
    }
    File localFile1 = null;
    if (paramLong >= 0L) {
      localFile1 = new File(localFile2, String.valueOf(paramLong));
    }
    return localFile1;
  }
  
  private File ay(long paramLong)
  {
    File localFile = com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_raw_images", String.valueOf(paramLong / 1000L));
    if (!localFile.exists()) {
      throw new IOException("Can not create deleted raw images dir");
    }
    return new File(localFile, String.valueOf(paramLong));
  }
  
  private File az(long paramLong)
  {
    File localFile = com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_proc_images", String.valueOf(paramLong / 1000L));
    if (!localFile.exists()) {
      throw new IOException("Can not create deleted processed images dir");
    }
    return new File(localFile, String.valueOf(paramLong));
  }
  
  private boolean b(long paramLong, String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject9 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Cursor localCursor1 = null;
    this.aII = OperationStatus.awf;
    d locald = new d(aIF.getWritableDatabase());
    Cursor localCursor2 = localCursor1;
    Object localObject2 = localObject5;
    Object localObject3 = localObject6;
    Object localObject4 = localObject7;
    Object localObject1 = localObject8;
    for (;;)
    {
      try
      {
        locald.beginTransaction();
        localObject1 = localObject9;
        if (paramLong >= 0L)
        {
          localCursor2 = localCursor1;
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject4 = localObject7;
          localObject1 = localObject8;
          localCursor1 = locald.rawQuery("SELECT doc_id, cropped_image_id FROM pages WHERE id = ?;", new String[] { String.valueOf(paramLong) }, null);
          if (localCursor1 != null)
          {
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            if (localCursor1.moveToFirst()) {}
          }
          else
          {
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            throw new SQLiteException("Could not get page to add cropped image");
          }
        }
      }
      catch (Image.InvalidImageTypeException paramString)
      {
        localObject1 = localCursor2;
        this.mLog.g("Invalid Image Type Exception while adding cropped image", paramString);
        localObject1 = localCursor2;
        this.aII = OperationStatus.awh;
        locald.endTransaction();
        if (localCursor2 != null)
        {
          paramString = localCursor2;
          paramString.close();
        }
        if (this.aII == OperationStatus.avC)
        {
          return true;
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l1 = localCursor1.getLong(0);
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l2 = localCursor1.getLong(1);
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          long l3 = Ix();
          localObject1 = localCursor1;
          if (l3 >= 0L)
          {
            i = 0;
            if (paramString == null) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            if (paramString.equals("")) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            locald.b("UPDATE pages SET cropped_image_id = ?, image_version = 2, has_recognized_content = -1, last_modification_time = strftime('%s', 'now'),has_crop_data = 2 WHERE id=?;", new String[] { String.valueOf(l3), String.valueOf(paramLong) });
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            paramString = new File(paramString);
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            new Image(paramString);
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            paramArrayOfByte = aw(paramLong);
            if (!paramBoolean) {
              continue;
            }
            localCursor2 = localCursor1;
            localObject2 = localCursor1;
            localObject3 = localCursor1;
            localObject4 = localCursor1;
            localObject1 = localCursor1;
            com.mobisystems.mobiscanner.common.d.a(paramString, paramArrayOfByte);
            break label999;
            localObject1 = localCursor1;
            if (i != 0)
            {
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              aD(l1);
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              locald.setTransactionSuccessful();
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              this.aII = OperationStatus.avC;
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              an(l2);
              localCursor2 = localCursor1;
              localObject2 = localCursor1;
              localObject3 = localCursor1;
              localObject4 = localCursor1;
              localObject1 = localCursor1;
              com.mobisystems.mobiscanner.common.d.an(mContext);
              localObject1 = localCursor1;
            }
          }
          locald.endTransaction();
          if (localObject1 == null) {
            continue;
          }
          paramString = (String)localObject1;
          continue;
          localCursor2 = localCursor1;
          localObject2 = localCursor1;
          localObject3 = localCursor1;
          localObject4 = localCursor1;
          localObject1 = localCursor1;
          com.mobisystems.mobiscanner.common.d.b(paramString, paramArrayOfByte);
        }
      }
      catch (Image.ImageException paramString)
      {
        localObject1 = localObject2;
        this.mLog.g("Image Exception while adding cropped image", paramString);
        localObject1 = localObject2;
        this.aII = OperationStatus.awg;
        locald.endTransaction();
        if (localObject2 == null) {
          continue;
        }
        paramString = (String)localObject2;
        continue;
        if (paramArrayOfByte == null) {
          continue;
        }
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        locald.b("UPDATE pages SET cropped_image_id = ?, image_version = 2, has_recognized_content = -1, last_modification_time = strftime('%s', 'now'),has_crop_data = 2 WHERE id=?;", new String[] { String.valueOf(paramLong), String.valueOf(paramLong) });
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        new Image(paramArrayOfByte);
        localCursor2 = localCursor1;
        localObject2 = localCursor1;
        localObject3 = localCursor1;
        localObject4 = localCursor1;
        localObject1 = localCursor1;
        com.mobisystems.mobiscanner.common.d.a(paramArrayOfByte, aw(paramLong));
        i = 1;
        continue;
      }
      catch (IOException paramString)
      {
        localObject1 = localObject3;
        this.mLog.g("IO Exception while adding cropped image", paramString);
        localObject1 = localObject3;
        this.aII = OperationStatus.awe;
        locald.endTransaction();
        if (localObject3 == null) {
          continue;
        }
        paramString = (String)localObject3;
        continue;
      }
      catch (SQLiteException paramString)
      {
        localObject1 = localObject4;
        this.mLog.g("SQL Exception while adding cropped image", paramString);
        localObject1 = localObject4;
        this.aII = OperationStatus.awd;
        locald.endTransaction();
        if (localObject4 == null) {
          continue;
        }
        paramString = (String)localObject4;
        continue;
      }
      finally
      {
        locald.endTransaction();
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      return false;
      label999:
      int i = 1;
    }
  }
  
  private void c(long[] paramArrayOfLong)
  {
    this.mLog.dl("deletePageImages: " + paramArrayOfLong.length + " images");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      Object localObject = aj(l);
      if (localObject == null) {
        throw new IOException("Error reading page " + l);
      }
      File localFile1;
      if (aA(((c)localObject).IT()) <= 1)
      {
        localFile1 = at(((c)localObject).IT());
        File localFile2 = ay(l);
        if (localFile1.exists())
        {
          if (!localFile1.renameTo(localFile2)) {
            throw new IOException("Coud not delete raw image file for page " + l);
          }
        }
        else {
          this.mLog.A("deletePageImages, image dos not exist" + localFile1.getAbsolutePath());
        }
      }
      if ((((c)localObject).Jc() >= 0L) && (aB(((c)localObject).Jc()) <= 1))
      {
        localObject = av(((c)localObject).Jc());
        localFile1 = az(l);
        if (((File)localObject).exists())
        {
          if (!((File)localObject).renameTo(localFile1)) {
            throw new IOException("Coud not delete processed image file for page " + l);
          }
        }
        else {
          this.mLog.A("deletePageImages, image dos not exist" + ((File)localObject).getAbsolutePath());
        }
      }
      i += 1;
    }
    try
    {
      com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "raw_images", null));
    }
    catch (IOException paramArrayOfLong)
    {
      for (;;)
      {
        try
        {
          com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "proc_images", null));
          return;
        }
        catch (IOException paramArrayOfLong)
        {
          this.mLog.g("Error cleaning processed images directory", paramArrayOfLong);
        }
        paramArrayOfLong = paramArrayOfLong;
        this.mLog.g("Error cleaning raw images directory", paramArrayOfLong);
      }
    }
  }
  
  private void d(long[] paramArrayOfLong)
  {
    this.mLog.dl("undeletePageImages: " + paramArrayOfLong.length + " images");
    int j = paramArrayOfLong.length;
    int i = 0;
    long l;
    while (i < j)
    {
      l = paramArrayOfLong[i];
      try
      {
        File localFile1 = as(l);
        File localFile2 = ay(l);
        if ((localFile2.exists()) && (!localFile2.renameTo(localFile1))) {
          this.mLog.A("undeletePageImages: Could not undelete raw image for page " + l);
        }
        localFile1 = au(l);
        localFile2 = az(l);
        if ((localFile2.exists()) && (!localFile2.renameTo(localFile1))) {
          this.mLog.A("undeletePageImages: Could not undelete processed image for page " + l);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mLog.g("IO Exception undeleting images for page " + l, localIOException);
          this.aII = OperationStatus.awe;
        }
      }
      i += 1;
    }
    try
    {
      com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_raw_images", null));
    }
    catch (IOException paramArrayOfLong)
    {
      for (;;)
      {
        try
        {
          com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_proc_images", null));
          return;
        }
        catch (IOException paramArrayOfLong)
        {
          this.mLog.g("Error cleaning deleted processed images directory", paramArrayOfLong);
        }
        paramArrayOfLong = paramArrayOfLong;
        this.mLog.g("Error cleaning deleted raw images directory", paramArrayOfLong);
      }
    }
  }
  
  private void e(long[] paramArrayOfLong)
  {
    this.mLog.dl("purgePageImages: " + paramArrayOfLong.length + " images");
    int j = paramArrayOfLong.length;
    int i = 0;
    long l;
    while (i < j)
    {
      l = paramArrayOfLong[i];
      try
      {
        File localFile = ay(l);
        if ((localFile.exists()) && (!localFile.delete())) {
          this.mLog.A("Could not purge deleted raw image for page " + l);
        }
        localFile = az(l);
        if ((localFile.exists()) && (!localFile.delete())) {
          this.mLog.A("Could not purge deleted processed image for page " + l);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mLog.g("IO Exception purging deleted images for page " + l, localIOException);
          this.aII = OperationStatus.awe;
        }
      }
      i += 1;
    }
    try
    {
      com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_raw_images", null));
    }
    catch (IOException paramArrayOfLong)
    {
      for (;;)
      {
        try
        {
          com.mobisystems.mobiscanner.common.d.d(com.mobisystems.mobiscanner.common.d.f(mContext, "deleted_proc_images", null));
          return;
        }
        catch (IOException paramArrayOfLong)
        {
          this.mLog.g("Error cleaning deleted processed images directory", paramArrayOfLong);
        }
        paramArrayOfLong = paramArrayOfLong;
        this.mLog.g("Error cleaning deleted raw images directory", paramArrayOfLong);
      }
    }
  }
  
  public OperationStatus It()
  {
    return this.aII;
  }
  
  /* Error */
  public b Iu()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: ldc_w 759
    //   7: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   10: new 134	com/mobisystems/mobiscanner/model/d
    //   13: dup
    //   14: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   17: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: astore_3
    //   24: aload_0
    //   25: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   28: aload_3
    //   29: ldc_w 761
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   37: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +190 -> 234
    //   47: aload 4
    //   49: astore 6
    //   51: aload 4
    //   53: invokeinterface 200 1 0
    //   58: ifeq +53 -> 111
    //   61: aload 4
    //   63: astore 6
    //   65: new 146	com/mobisystems/mobiscanner/model/b
    //   68: dup
    //   69: aload 4
    //   71: invokespecial 764	com/mobisystems/mobiscanner/model/b:<init>	(Landroid/database/Cursor;)V
    //   74: astore_3
    //   75: aload 4
    //   77: astore 6
    //   79: aload_0
    //   80: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   83: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   86: aload_0
    //   87: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   90: aload_3
    //   91: astore 5
    //   93: aload 4
    //   95: ifnull +13 -> 108
    //   98: aload 4
    //   100: invokeinterface 99 1 0
    //   105: aload_3
    //   106: astore 5
    //   108: aload 5
    //   110: areturn
    //   111: aload 4
    //   113: astore 6
    //   115: aload 4
    //   117: invokeinterface 99 1 0
    //   122: aload 4
    //   124: astore 6
    //   126: aload_0
    //   127: invokespecial 766	com/mobisystems/mobiscanner/model/DocumentModel:Iv	()J
    //   130: lstore_1
    //   131: aload 4
    //   133: astore 6
    //   135: aload_0
    //   136: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   139: astore 5
    //   141: aload 4
    //   143: astore 6
    //   145: aload_3
    //   146: ldc_w 768
    //   149: iconst_1
    //   150: anewarray 160	java/lang/String
    //   153: dup
    //   154: iconst_0
    //   155: lload_1
    //   156: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   159: aastore
    //   160: aload 5
    //   162: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   165: astore_3
    //   166: aload_3
    //   167: ifnull +51 -> 218
    //   170: aload_3
    //   171: astore 6
    //   173: aload_3
    //   174: invokeinterface 200 1 0
    //   179: ifeq +39 -> 218
    //   182: aload_3
    //   183: astore 6
    //   185: new 146	com/mobisystems/mobiscanner/model/b
    //   188: dup
    //   189: aload_3
    //   190: invokespecial 764	com/mobisystems/mobiscanner/model/b:<init>	(Landroid/database/Cursor;)V
    //   193: astore 4
    //   195: aload_3
    //   196: astore 6
    //   198: aload_0
    //   199: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   202: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   205: aload_3
    //   206: astore 5
    //   208: aload 4
    //   210: astore_3
    //   211: aload 5
    //   213: astore 4
    //   215: goto -129 -> 86
    //   218: aload_3
    //   219: astore 6
    //   221: aload_0
    //   222: getstatic 771	com/mobisystems/mobiscanner/common/OperationStatus:avZ	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   225: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   228: aconst_null
    //   229: astore 4
    //   231: goto -26 -> 205
    //   234: aload 4
    //   236: astore 6
    //   238: aload_0
    //   239: getstatic 771	com/mobisystems/mobiscanner/common/OperationStatus:avZ	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   242: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   245: aconst_null
    //   246: astore_3
    //   247: goto -161 -> 86
    //   250: astore 5
    //   252: aconst_null
    //   253: astore_3
    //   254: aconst_null
    //   255: astore 4
    //   257: aload_3
    //   258: astore 6
    //   260: aload_0
    //   261: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   264: ldc_w 773
    //   267: aload 5
    //   269: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload_3
    //   273: astore 6
    //   275: aload_0
    //   276: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   279: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   282: aload_0
    //   283: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   286: aload 4
    //   288: astore 5
    //   290: aload_3
    //   291: ifnull -183 -> 108
    //   294: aload_3
    //   295: invokeinterface 99 1 0
    //   300: aload 4
    //   302: areturn
    //   303: astore 5
    //   305: aconst_null
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: aload 4
    //   312: astore 6
    //   314: aload_0
    //   315: aload 5
    //   317: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   320: aload_0
    //   321: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   324: aload_3
    //   325: astore 5
    //   327: aload 4
    //   329: ifnull -221 -> 108
    //   332: goto -234 -> 98
    //   335: astore_3
    //   336: aconst_null
    //   337: astore 6
    //   339: aload_0
    //   340: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   343: aload 6
    //   345: ifnull +10 -> 355
    //   348: aload 6
    //   350: invokeinterface 99 1 0
    //   355: aload_3
    //   356: athrow
    //   357: astore_3
    //   358: goto -19 -> 339
    //   361: astore_3
    //   362: goto -23 -> 339
    //   365: astore 5
    //   367: aconst_null
    //   368: astore_3
    //   369: goto -59 -> 310
    //   372: astore 5
    //   374: goto -64 -> 310
    //   377: astore 5
    //   379: aload_3
    //   380: astore 4
    //   382: aconst_null
    //   383: astore_3
    //   384: goto -74 -> 310
    //   387: astore 5
    //   389: aload_3
    //   390: astore 6
    //   392: aload 4
    //   394: astore_3
    //   395: aload 6
    //   397: astore 4
    //   399: goto -89 -> 310
    //   402: astore 5
    //   404: aload 4
    //   406: astore_3
    //   407: aconst_null
    //   408: astore 4
    //   410: goto -153 -> 257
    //   413: astore 5
    //   415: aload_3
    //   416: astore 6
    //   418: aload 4
    //   420: astore_3
    //   421: aload 6
    //   423: astore 4
    //   425: goto -168 -> 257
    //   428: astore 5
    //   430: aconst_null
    //   431: astore 4
    //   433: goto -176 -> 257
    //   436: astore 5
    //   438: goto -181 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	DocumentModel
    //   130	26	1	l	long
    //   23	302	3	localObject1	Object
    //   335	21	3	localObject2	Object
    //   357	1	3	localObject3	Object
    //   361	1	3	localObject4	Object
    //   368	53	3	localObject5	Object
    //   40	392	4	localObject6	Object
    //   91	121	5	localObject7	Object
    //   250	18	5	localSQLiteException1	SQLiteException
    //   288	1	5	localObject8	Object
    //   303	13	5	localRuntimeException1	RuntimeException
    //   325	1	5	localObject9	Object
    //   365	1	5	localRuntimeException2	RuntimeException
    //   372	1	5	localRuntimeException3	RuntimeException
    //   377	1	5	localRuntimeException4	RuntimeException
    //   387	1	5	localRuntimeException5	RuntimeException
    //   402	1	5	localSQLiteException2	SQLiteException
    //   413	1	5	localSQLiteException3	SQLiteException
    //   428	1	5	localSQLiteException4	SQLiteException
    //   436	1	5	localSQLiteException5	SQLiteException
    //   49	373	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   24	42	250	android/database/sqlite/SQLiteException
    //   24	42	303	java/lang/RuntimeException
    //   24	42	335	finally
    //   51	61	357	finally
    //   65	75	357	finally
    //   79	86	357	finally
    //   115	122	357	finally
    //   126	131	357	finally
    //   135	141	357	finally
    //   145	166	357	finally
    //   238	245	357	finally
    //   314	320	357	finally
    //   173	182	361	finally
    //   185	195	361	finally
    //   198	205	361	finally
    //   221	228	361	finally
    //   260	272	361	finally
    //   275	282	361	finally
    //   51	61	365	java/lang/RuntimeException
    //   65	75	365	java/lang/RuntimeException
    //   115	122	365	java/lang/RuntimeException
    //   126	131	365	java/lang/RuntimeException
    //   135	141	365	java/lang/RuntimeException
    //   145	166	365	java/lang/RuntimeException
    //   238	245	365	java/lang/RuntimeException
    //   79	86	372	java/lang/RuntimeException
    //   173	182	377	java/lang/RuntimeException
    //   185	195	377	java/lang/RuntimeException
    //   221	228	377	java/lang/RuntimeException
    //   198	205	387	java/lang/RuntimeException
    //   51	61	402	android/database/sqlite/SQLiteException
    //   65	75	402	android/database/sqlite/SQLiteException
    //   115	122	402	android/database/sqlite/SQLiteException
    //   126	131	402	android/database/sqlite/SQLiteException
    //   135	141	402	android/database/sqlite/SQLiteException
    //   145	166	402	android/database/sqlite/SQLiteException
    //   238	245	402	android/database/sqlite/SQLiteException
    //   79	86	413	android/database/sqlite/SQLiteException
    //   173	182	428	android/database/sqlite/SQLiteException
    //   185	195	428	android/database/sqlite/SQLiteException
    //   221	228	428	android/database/sqlite/SQLiteException
    //   198	205	436	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean Iw()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: ldc_w 776
    //   7: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   10: new 134	com/mobisystems/mobiscanner/model/d
    //   13: dup
    //   14: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   17: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: astore 19
    //   25: aconst_null
    //   26: astore 18
    //   28: aload 19
    //   30: ldc_w 778
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   38: astore 16
    //   40: aload 16
    //   42: ifnonnull +84 -> 126
    //   45: new 130	android/database/sqlite/SQLiteException
    //   48: dup
    //   49: ldc_w 780
    //   52: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: astore 18
    //   58: aconst_null
    //   59: astore 19
    //   61: iconst_0
    //   62: istore 11
    //   64: aload 16
    //   66: astore 17
    //   68: aload 19
    //   70: astore 16
    //   72: aload_0
    //   73: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   76: ldc_w 782
    //   79: aload 18
    //   81: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: aload_0
    //   85: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   88: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   91: aload 17
    //   93: ifnull +10 -> 103
    //   96: aload 17
    //   98: invokeinterface 99 1 0
    //   103: iload 11
    //   105: istore 12
    //   107: aload 16
    //   109: ifnull +14 -> 123
    //   112: aload 16
    //   114: invokeinterface 99 1 0
    //   119: iload 11
    //   121: istore 12
    //   123: iload 12
    //   125: ireturn
    //   126: aload 16
    //   128: invokeinterface 200 1 0
    //   133: ifne +46 -> 179
    //   136: new 130	android/database/sqlite/SQLiteException
    //   139: dup
    //   140: ldc_w 784
    //   143: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   146: athrow
    //   147: aconst_null
    //   148: astore 18
    //   150: astore 17
    //   152: aload 16
    //   154: ifnull +10 -> 164
    //   157: aload 16
    //   159: invokeinterface 99 1 0
    //   164: aload 18
    //   166: ifnull +10 -> 176
    //   169: aload 18
    //   171: invokeinterface 99 1 0
    //   176: aload 17
    //   178: athrow
    //   179: aload 16
    //   181: invokeinterface 787 1 0
    //   186: istore 10
    //   188: iconst_0
    //   189: istore 8
    //   191: aconst_null
    //   192: astore 17
    //   194: iload 8
    //   196: iload 10
    //   198: if_icmpge +290 -> 488
    //   201: aload 16
    //   203: iload 8
    //   205: invokeinterface 86 2 0
    //   210: pop
    //   211: aload 16
    //   213: iconst_0
    //   214: invokeinterface 210 2 0
    //   219: lstore 14
    //   221: aload 16
    //   223: iconst_1
    //   224: invokeinterface 791 2 0
    //   229: dstore_1
    //   230: aload 16
    //   232: iconst_2
    //   233: invokeinterface 791 2 0
    //   238: dstore_3
    //   239: aload 16
    //   241: iconst_3
    //   242: invokeinterface 791 2 0
    //   247: dstore 5
    //   249: aload 16
    //   251: iconst_4
    //   252: invokeinterface 795 2 0
    //   257: fstore 7
    //   259: iload 8
    //   261: iload 10
    //   263: iconst_1
    //   264: isub
    //   265: if_icmpge +84 -> 349
    //   268: aload 16
    //   270: invokeinterface 798 1 0
    //   275: pop
    //   276: aload 19
    //   278: ldc_w 800
    //   281: iconst_2
    //   282: anewarray 160	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: lload 14
    //   289: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload 16
    //   297: iconst_0
    //   298: invokeinterface 210 2 0
    //   303: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   306: aastore
    //   307: aconst_null
    //   308: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   311: astore 17
    //   313: aload 17
    //   315: ifnonnull +60 -> 375
    //   318: new 130	android/database/sqlite/SQLiteException
    //   321: dup
    //   322: ldc_w 802
    //   325: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   328: athrow
    //   329: astore 18
    //   331: aload 16
    //   333: astore 19
    //   335: iconst_0
    //   336: istore 11
    //   338: aload 17
    //   340: astore 16
    //   342: aload 19
    //   344: astore 17
    //   346: goto -274 -> 72
    //   349: aload 19
    //   351: ldc_w 804
    //   354: iconst_1
    //   355: anewarray 160	java/lang/String
    //   358: dup
    //   359: iconst_0
    //   360: lload 14
    //   362: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   365: aastore
    //   366: aconst_null
    //   367: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   370: astore 17
    //   372: goto -59 -> 313
    //   375: aload 17
    //   377: invokeinterface 200 1 0
    //   382: ifne +291 -> 673
    //   385: goto +279 -> 664
    //   388: iload 9
    //   390: aload 17
    //   392: invokeinterface 787 1 0
    //   397: if_icmpge +68 -> 465
    //   400: aload 17
    //   402: iload 9
    //   404: invokeinterface 86 2 0
    //   409: pop
    //   410: aload 17
    //   412: iconst_0
    //   413: invokeinterface 210 2 0
    //   418: lstore 14
    //   420: ldc -27
    //   422: astore 18
    //   424: invokestatic 270	android/location/Geocoder:isPresent	()Z
    //   427: ifeq +13 -> 440
    //   430: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   433: dload_3
    //   434: dload_1
    //   435: invokestatic 279	com/mobisystems/mobiscanner/common/d:a	(Landroid/content/Context;DD)Ljava/lang/String;
    //   438: astore 18
    //   440: aload_0
    //   441: lload 14
    //   443: iconst_1
    //   444: dload_1
    //   445: dload_3
    //   446: dload 5
    //   448: fload 7
    //   450: aload 18
    //   452: invokevirtual 807	com/mobisystems/mobiscanner/model/DocumentModel:a	(JIDDDFLjava/lang/String;)Z
    //   455: pop
    //   456: iload 9
    //   458: iconst_1
    //   459: iadd
    //   460: istore 9
    //   462: goto -74 -> 388
    //   465: aload 17
    //   467: invokeinterface 99 1 0
    //   472: goto +192 -> 664
    //   475: astore 19
    //   477: aload 17
    //   479: astore 18
    //   481: aload 19
    //   483: astore 17
    //   485: goto -333 -> 152
    //   488: aload 19
    //   490: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   493: aload 19
    //   495: ldc_w 809
    //   498: aconst_null
    //   499: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   502: pop
    //   503: aload 19
    //   505: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   508: aload 19
    //   510: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   513: iconst_1
    //   514: istore 11
    //   516: iconst_1
    //   517: istore 13
    //   519: iconst_1
    //   520: istore 12
    //   522: aload_0
    //   523: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   526: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   529: aload 16
    //   531: ifnull +10 -> 541
    //   534: aload 16
    //   536: invokeinterface 99 1 0
    //   541: iload 13
    //   543: istore 12
    //   545: aload 17
    //   547: ifnull -424 -> 123
    //   550: aload 17
    //   552: astore 16
    //   554: goto -442 -> 112
    //   557: astore 18
    //   559: aload 19
    //   561: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   564: aload 18
    //   566: athrow
    //   567: astore 18
    //   569: aload 16
    //   571: astore 19
    //   573: iconst_0
    //   574: istore 11
    //   576: aload 17
    //   578: astore 16
    //   580: aload 19
    //   582: astore 17
    //   584: goto -512 -> 72
    //   587: astore 17
    //   589: aconst_null
    //   590: astore 16
    //   592: goto -440 -> 152
    //   595: astore 19
    //   597: aload 17
    //   599: astore 18
    //   601: aload 19
    //   603: astore 17
    //   605: goto -453 -> 152
    //   608: astore 18
    //   610: aload 17
    //   612: astore 19
    //   614: aload 18
    //   616: astore 17
    //   618: aload 16
    //   620: astore 18
    //   622: aload 19
    //   624: astore 16
    //   626: goto -474 -> 152
    //   629: astore 18
    //   631: aconst_null
    //   632: astore 17
    //   634: aconst_null
    //   635: astore 16
    //   637: iconst_0
    //   638: istore 11
    //   640: goto -568 -> 72
    //   643: astore 18
    //   645: aload 16
    //   647: astore 19
    //   649: iload 12
    //   651: istore 11
    //   653: aload 17
    //   655: astore 16
    //   657: aload 19
    //   659: astore 17
    //   661: goto -589 -> 72
    //   664: iload 8
    //   666: iconst_1
    //   667: iadd
    //   668: istore 8
    //   670: goto -476 -> 194
    //   673: iconst_0
    //   674: istore 9
    //   676: goto -288 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	DocumentModel
    //   229	216	1	d1	double
    //   238	208	3	d2	double
    //   247	200	5	d3	double
    //   257	192	7	f	float
    //   189	480	8	i	int
    //   388	287	9	j	int
    //   186	79	10	k	int
    //   62	590	11	bool1	boolean
    //   105	545	12	bool2	boolean
    //   517	25	13	bool3	boolean
    //   219	223	14	l	long
    //   38	618	16	localObject1	Object
    //   66	31	17	localObject2	Object
    //   150	27	17	localObject3	Object
    //   192	391	17	localObject4	Object
    //   587	11	17	localObject5	Object
    //   603	57	17	localObject6	Object
    //   26	1	18	localObject7	Object
    //   56	24	18	localSQLiteException1	SQLiteException
    //   148	22	18	localObject8	Object
    //   329	1	18	localSQLiteException2	SQLiteException
    //   422	58	18	localObject9	Object
    //   557	8	18	localObject10	Object
    //   567	1	18	localSQLiteException3	SQLiteException
    //   599	1	18	localObject11	Object
    //   608	7	18	localObject12	Object
    //   620	1	18	localObject13	Object
    //   629	1	18	localSQLiteException4	SQLiteException
    //   643	1	18	localSQLiteException5	SQLiteException
    //   23	327	19	localObject14	Object
    //   475	85	19	localObject15	Object
    //   571	10	19	localObject16	Object
    //   595	7	19	localObject17	Object
    //   612	46	19	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   45	56	56	android/database/sqlite/SQLiteException
    //   126	147	56	android/database/sqlite/SQLiteException
    //   179	188	56	android/database/sqlite/SQLiteException
    //   268	313	56	android/database/sqlite/SQLiteException
    //   349	372	56	android/database/sqlite/SQLiteException
    //   45	56	147	finally
    //   126	147	147	finally
    //   179	188	147	finally
    //   268	313	147	finally
    //   349	372	147	finally
    //   318	329	329	android/database/sqlite/SQLiteException
    //   375	385	329	android/database/sqlite/SQLiteException
    //   388	420	329	android/database/sqlite/SQLiteException
    //   424	440	329	android/database/sqlite/SQLiteException
    //   440	456	329	android/database/sqlite/SQLiteException
    //   465	472	329	android/database/sqlite/SQLiteException
    //   318	329	475	finally
    //   375	385	475	finally
    //   388	420	475	finally
    //   424	440	475	finally
    //   440	456	475	finally
    //   465	472	475	finally
    //   488	508	557	finally
    //   201	259	567	android/database/sqlite/SQLiteException
    //   508	513	567	android/database/sqlite/SQLiteException
    //   559	567	567	android/database/sqlite/SQLiteException
    //   28	40	587	finally
    //   201	259	595	finally
    //   508	513	595	finally
    //   522	529	595	finally
    //   559	567	595	finally
    //   72	91	608	finally
    //   28	40	629	android/database/sqlite/SQLiteException
    //   522	529	643	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public Cursor Iy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: ldc_w 813
    //   7: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   10: new 134	com/mobisystems/mobiscanner/model/d
    //   13: dup
    //   14: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   17: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: astore_1
    //   24: aload_0
    //   25: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   28: aload_0
    //   29: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   32: astore_2
    //   33: aload_1
    //   34: ldc_w 815
    //   37: iconst_0
    //   38: anewarray 160	java/lang/String
    //   41: aload_2
    //   42: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_0
    //   47: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   50: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   53: aload_0
    //   54: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   57: aload_1
    //   58: areturn
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   66: ldc_w 817
    //   69: aload_2
    //   70: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   77: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   80: goto -27 -> 53
    //   83: astore_1
    //   84: aload_0
    //   85: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_0
    //   94: aload_2
    //   95: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   98: goto -45 -> 53
    //   101: astore_2
    //   102: goto -9 -> 93
    //   105: astore_2
    //   106: goto -44 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	DocumentModel
    //   23	39	1	localObject1	Object
    //   83	6	1	localObject2	Object
    //   92	1	1	localObject3	Object
    //   32	10	2	localCancellationSignal	CancellationSignal
    //   59	11	2	localSQLiteException1	SQLiteException
    //   90	5	2	localRuntimeException1	RuntimeException
    //   101	1	2	localRuntimeException2	RuntimeException
    //   105	1	2	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   24	46	59	android/database/sqlite/SQLiteException
    //   24	46	83	finally
    //   46	53	83	finally
    //   62	80	83	finally
    //   93	98	83	finally
    //   24	46	90	java/lang/RuntimeException
    //   46	53	101	java/lang/RuntimeException
    //   46	53	105	android/database/sqlite/SQLiteException
  }
  
  public long a(long paramLong, String paramString, boolean paramBoolean, c paramc)
  {
    this.mLog.dl("addPage called, docId=" + paramLong + ", rawImageFilePath=" + paramString);
    return a(paramLong, paramString, paramBoolean, null, paramc);
  }
  
  public long a(long paramLong, byte[] paramArrayOfByte, c paramc, float[] paramArrayOfFloat)
  {
    this.mLog.dl("addPageFromCustomCamera with image data called, docId=" + paramLong);
    if (paramArrayOfFloat != null)
    {
      paramc.br(true);
      paramc.P(paramArrayOfFloat[1]);
      paramc.Q(paramArrayOfFloat[2]);
      paramc.R(paramArrayOfFloat[0]);
    }
    paramc.gy(-1);
    paramc.gA(-1);
    paramLong = a(paramLong, null, false, paramArrayOfByte, paramc);
    com.mobisystems.mobiscanner.common.d.b(mContext, paramLong);
    return paramLong;
  }
  
  /* Error */
  public Cursor a(String paramString, DocListSortBy paramDocListSortBy, SortOrder paramSortOrder, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: ldc_w 846
    //   7: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   10: new 134	com/mobisystems/mobiscanner/model/d
    //   13: dup
    //   14: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   17: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: astore 9
    //   25: aload_0
    //   26: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   29: ldc_w 848
    //   32: astore 8
    //   34: new 494	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 850
    //   44: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 850
    //   54: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload_1
    //   63: ifnull +305 -> 368
    //   66: aload_1
    //   67: invokevirtual 853	java/lang/String:length	()I
    //   70: ifle +298 -> 368
    //   73: ldc_w 855
    //   76: astore_1
    //   77: iconst_1
    //   78: anewarray 160	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: aload 6
    //   85: aastore
    //   86: astore 7
    //   88: aload_1
    //   89: astore 6
    //   91: iload 4
    //   93: ifle +66 -> 159
    //   96: aload_1
    //   97: astore 6
    //   99: aload_1
    //   100: invokevirtual 853	java/lang/String:length	()I
    //   103: ifle +25 -> 128
    //   106: new 494	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc_w 857
    //   120: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore 6
    //   128: new 494	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   135: aload 6
    //   137: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 859
    //   143: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload 4
    //   148: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   151: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 6
    //   159: aload 6
    //   161: astore_1
    //   162: aload 6
    //   164: invokevirtual 853	java/lang/String:length	()I
    //   167: ifle +25 -> 192
    //   170: new 494	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   177: aload 6
    //   179: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: ldc_w 857
    //   185: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore_1
    //   192: new 494	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   199: aload_1
    //   200: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 861
    //   206: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 6
    //   214: aload 8
    //   216: astore_1
    //   217: aload 6
    //   219: invokevirtual 853	java/lang/String:length	()I
    //   222: ifle +31 -> 253
    //   225: new 494	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 848
    //   235: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 863
    //   241: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 6
    //   246: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore_1
    //   253: new 494	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   260: aload_1
    //   261: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 865
    //   267: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_2
    //   271: invokevirtual 868	com/mobisystems/mobiscanner/model/DocumentModel$DocListSortBy:Iz	()Ljava/lang/String;
    //   274: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc_w 870
    //   280: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 871	com/mobisystems/mobiscanner/model/DocumentModel$SortOrder:Iz	()Ljava/lang/String;
    //   287: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: astore_1
    //   294: new 494	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   301: aload_1
    //   302: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 873
    //   308: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: iload 5
    //   313: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   316: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore_1
    //   323: aload 9
    //   325: new 494	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   332: aload_1
    //   333: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 875
    //   339: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: aload 7
    //   347: aload_0
    //   348: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   351: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   354: astore_1
    //   355: aload_0
    //   356: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   359: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   362: aload_0
    //   363: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   366: aload_1
    //   367: areturn
    //   368: ldc -27
    //   370: astore_1
    //   371: aconst_null
    //   372: astore 7
    //   374: goto -286 -> 88
    //   377: astore_2
    //   378: aconst_null
    //   379: astore_1
    //   380: aload_0
    //   381: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   384: ldc_w 877
    //   387: aload_2
    //   388: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_0
    //   392: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   395: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   398: goto -36 -> 362
    //   401: astore_1
    //   402: aload_0
    //   403: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   406: aload_1
    //   407: athrow
    //   408: astore_2
    //   409: aconst_null
    //   410: astore_1
    //   411: aload_0
    //   412: aload_2
    //   413: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   416: goto -54 -> 362
    //   419: astore_2
    //   420: goto -9 -> 411
    //   423: astore_2
    //   424: goto -44 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	DocumentModel
    //   0	427	1	paramString	String
    //   0	427	2	paramDocListSortBy	DocListSortBy
    //   0	427	3	paramSortOrder	SortOrder
    //   0	427	4	paramInt1	int
    //   0	427	5	paramInt2	int
    //   60	185	6	str1	String
    //   86	287	7	arrayOfString	String[]
    //   32	183	8	str2	String
    //   23	301	9	locald	d
    // Exception table:
    //   from	to	target	type
    //   25	29	377	android/database/sqlite/SQLiteException
    //   34	62	377	android/database/sqlite/SQLiteException
    //   66	73	377	android/database/sqlite/SQLiteException
    //   77	88	377	android/database/sqlite/SQLiteException
    //   99	128	377	android/database/sqlite/SQLiteException
    //   128	159	377	android/database/sqlite/SQLiteException
    //   162	192	377	android/database/sqlite/SQLiteException
    //   192	214	377	android/database/sqlite/SQLiteException
    //   217	253	377	android/database/sqlite/SQLiteException
    //   253	355	377	android/database/sqlite/SQLiteException
    //   25	29	401	finally
    //   34	62	401	finally
    //   66	73	401	finally
    //   77	88	401	finally
    //   99	128	401	finally
    //   128	159	401	finally
    //   162	192	401	finally
    //   192	214	401	finally
    //   217	253	401	finally
    //   253	355	401	finally
    //   355	362	401	finally
    //   380	398	401	finally
    //   411	416	401	finally
    //   25	29	408	java/lang/RuntimeException
    //   34	62	408	java/lang/RuntimeException
    //   66	73	408	java/lang/RuntimeException
    //   77	88	408	java/lang/RuntimeException
    //   99	128	408	java/lang/RuntimeException
    //   128	159	408	java/lang/RuntimeException
    //   162	192	408	java/lang/RuntimeException
    //   192	214	408	java/lang/RuntimeException
    //   217	253	408	java/lang/RuntimeException
    //   253	355	408	java/lang/RuntimeException
    //   355	362	419	java/lang/RuntimeException
    //   355	362	423	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public java.util.HashMap<Long, com.mobisystems.mobiscanner.controller.bi> a(String paramString, long[] paramArrayOfLong, android.database.MatrixCursor paramMatrixCursor)
  {
    // Byte code:
    //   0: new 880	java/util/HashMap
    //   3: dup
    //   4: invokespecial 881	java/util/HashMap:<init>	()V
    //   7: astore 17
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 863
    //   16: invokespecial 882	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: astore 12
    //   21: iconst_0
    //   22: istore 5
    //   24: iload 5
    //   26: istore 4
    //   28: aload_2
    //   29: ifnull +92 -> 121
    //   32: aload_2
    //   33: arraylength
    //   34: istore 6
    //   36: iload 6
    //   38: ifle +12 -> 50
    //   41: aload 12
    //   43: ldc_w 884
    //   46: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: iconst_0
    //   51: istore 4
    //   53: iload 4
    //   55: iload 6
    //   57: if_icmpge +43 -> 100
    //   60: aload 12
    //   62: aload_2
    //   63: iload 4
    //   65: laload
    //   66: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   69: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: iload 4
    //   75: iload 6
    //   77: iconst_1
    //   78: isub
    //   79: if_icmpge +12 -> 91
    //   82: aload 12
    //   84: ldc_w 886
    //   87: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: iload 4
    //   93: iconst_1
    //   94: iadd
    //   95: istore 4
    //   97: goto -44 -> 53
    //   100: iload 5
    //   102: istore 4
    //   104: iload 6
    //   106: ifle +15 -> 121
    //   109: aload 12
    //   111: ldc_w 888
    //   114: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: iconst_1
    //   119: istore 4
    //   121: new 134	com/mobisystems/mobiscanner/model/d
    //   124: dup
    //   125: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   128: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   131: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   134: astore_3
    //   135: aload_1
    //   136: invokestatic 894	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +609 -> 748
    //   142: iload 4
    //   144: ifeq +12 -> 156
    //   147: aload 12
    //   149: ldc_w 857
    //   152: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 12
    //   158: ldc_w 896
    //   161: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: iconst_3
    //   166: anewarray 160	java/lang/String
    //   169: astore_2
    //   170: aload_2
    //   171: iconst_0
    //   172: new 494	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 850
    //   182: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 850
    //   192: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aastore
    //   199: aload_2
    //   200: iconst_1
    //   201: new 494	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 850
    //   211: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 850
    //   221: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aastore
    //   228: aload_2
    //   229: iconst_2
    //   230: new 494	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   237: ldc_w 850
    //   240: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_1
    //   244: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 850
    //   250: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: aastore
    //   257: new 494	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   264: ldc_w 898
    //   267: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 12
    //   272: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 12
    //   283: new 494	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   290: aload 12
    //   292: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 900
    //   298: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore 12
    //   306: aload_0
    //   307: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   310: aload_3
    //   311: aload 12
    //   313: aload_2
    //   314: aload_0
    //   315: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   318: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   321: astore_2
    //   322: aload_2
    //   323: ifnull +238 -> 561
    //   326: aload_2
    //   327: astore_3
    //   328: aload_2
    //   329: invokeinterface 200 1 0
    //   334: ifeq +227 -> 561
    //   337: aload_2
    //   338: astore_3
    //   339: aload_2
    //   340: aload_2
    //   341: ldc_w 902
    //   344: invokeinterface 92 2 0
    //   349: invokeinterface 210 2 0
    //   354: lstore 7
    //   356: aload_2
    //   357: astore_3
    //   358: aload_2
    //   359: aload_2
    //   360: ldc_w 904
    //   363: invokeinterface 92 2 0
    //   368: invokeinterface 210 2 0
    //   373: lstore 9
    //   375: aload_2
    //   376: astore_3
    //   377: aload_2
    //   378: aload_2
    //   379: ldc_w 906
    //   382: invokeinterface 92 2 0
    //   387: invokeinterface 909 2 0
    //   392: astore 14
    //   394: aload_2
    //   395: astore_3
    //   396: aload_2
    //   397: aload_2
    //   398: ldc_w 911
    //   401: invokeinterface 92 2 0
    //   406: invokeinterface 909 2 0
    //   411: astore 15
    //   413: aload_2
    //   414: astore_3
    //   415: aload_2
    //   416: aload_2
    //   417: ldc_w 913
    //   420: invokeinterface 92 2 0
    //   425: invokeinterface 909 2 0
    //   430: astore 16
    //   432: aload_2
    //   433: astore_3
    //   434: aload 17
    //   436: lload 7
    //   438: invokestatic 918	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   441: invokevirtual 922	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   444: checkcast 924	com/mobisystems/mobiscanner/controller/bi
    //   447: astore 13
    //   449: aload 13
    //   451: astore 12
    //   453: aload 13
    //   455: ifnonnull +86 -> 541
    //   458: aload_2
    //   459: astore_3
    //   460: new 924	com/mobisystems/mobiscanner/controller/bi
    //   463: dup
    //   464: invokespecial 925	com/mobisystems/mobiscanner/controller/bi:<init>	()V
    //   467: astore 13
    //   469: aload_2
    //   470: astore_3
    //   471: aload 13
    //   473: lload 7
    //   475: invokevirtual 928	com/mobisystems/mobiscanner/controller/bi:ac	(J)V
    //   478: aload_2
    //   479: astore_3
    //   480: aload_1
    //   481: invokestatic 894	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   484: ifne +257 -> 741
    //   487: aload 14
    //   489: ifnull +98 -> 587
    //   492: aload_2
    //   493: astore_3
    //   494: aload 14
    //   496: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   499: aload_1
    //   500: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   503: invokevirtual 934	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   506: ifeq +81 -> 587
    //   509: aload 14
    //   511: astore 12
    //   513: aload_2
    //   514: astore_3
    //   515: aload 13
    //   517: aload 12
    //   519: invokevirtual 937	com/mobisystems/mobiscanner/controller/bi:dJ	(Ljava/lang/String;)V
    //   522: aload_2
    //   523: astore_3
    //   524: aload 17
    //   526: lload 7
    //   528: invokestatic 918	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   531: aload 13
    //   533: invokevirtual 941	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: aload 13
    //   539: astore 12
    //   541: aload_2
    //   542: astore_3
    //   543: aload 12
    //   545: lload 9
    //   547: invokevirtual 944	com/mobisystems/mobiscanner/controller/bi:ad	(J)V
    //   550: aload_2
    //   551: astore_3
    //   552: aload_2
    //   553: invokeinterface 798 1 0
    //   558: ifne -221 -> 337
    //   561: aload_2
    //   562: astore_3
    //   563: aload_0
    //   564: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   567: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   570: aload_2
    //   571: ifnull +9 -> 580
    //   574: aload_2
    //   575: invokeinterface 99 1 0
    //   580: aload_0
    //   581: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   584: aload 17
    //   586: areturn
    //   587: aload 15
    //   589: ifnull +27 -> 616
    //   592: aload_2
    //   593: astore_3
    //   594: aload 15
    //   596: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   599: aload_1
    //   600: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   603: invokevirtual 934	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   606: ifeq +10 -> 616
    //   609: aload 15
    //   611: astore 12
    //   613: goto -100 -> 513
    //   616: aload 16
    //   618: ifnull +123 -> 741
    //   621: aload_2
    //   622: astore_3
    //   623: aload 16
    //   625: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   628: aload_1
    //   629: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   632: invokevirtual 934	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   635: istore 11
    //   637: iload 11
    //   639: ifeq +102 -> 741
    //   642: aload 16
    //   644: astore 12
    //   646: goto -133 -> 513
    //   649: astore_1
    //   650: aconst_null
    //   651: astore_2
    //   652: aload_2
    //   653: astore_3
    //   654: aload_0
    //   655: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   658: ldc_w 946
    //   661: aload_1
    //   662: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   665: aload_2
    //   666: astore_3
    //   667: aload_0
    //   668: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   671: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   674: aload_2
    //   675: ifnull -95 -> 580
    //   678: aload_2
    //   679: invokeinterface 99 1 0
    //   684: goto -104 -> 580
    //   687: astore_1
    //   688: aconst_null
    //   689: astore_2
    //   690: aload_2
    //   691: astore_3
    //   692: aload_0
    //   693: aload_1
    //   694: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   697: aload_2
    //   698: ifnull -118 -> 580
    //   701: aload_2
    //   702: invokeinterface 99 1 0
    //   707: goto -127 -> 580
    //   710: astore_1
    //   711: aconst_null
    //   712: astore_3
    //   713: aload_3
    //   714: ifnull +9 -> 723
    //   717: aload_3
    //   718: invokeinterface 99 1 0
    //   723: aload_0
    //   724: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   727: aload_1
    //   728: athrow
    //   729: astore_1
    //   730: goto -17 -> 713
    //   733: astore_1
    //   734: goto -44 -> 690
    //   737: astore_1
    //   738: goto -86 -> 652
    //   741: ldc -27
    //   743: astore 12
    //   745: goto -232 -> 513
    //   748: iconst_0
    //   749: anewarray 160	java/lang/String
    //   752: astore_2
    //   753: goto -496 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	DocumentModel
    //   0	756	1	paramString	String
    //   0	756	2	paramArrayOfLong	long[]
    //   0	756	3	paramMatrixCursor	android.database.MatrixCursor
    //   26	117	4	i	int
    //   22	79	5	j	int
    //   34	71	6	k	int
    //   354	173	7	l1	long
    //   373	173	9	l2	long
    //   635	3	11	bool	boolean
    //   19	725	12	localObject	Object
    //   447	91	13	localbi	com.mobisystems.mobiscanner.controller.bi
    //   392	118	14	str1	String
    //   411	199	15	str2	String
    //   430	213	16	str3	String
    //   7	578	17	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   306	322	649	android/database/sqlite/SQLiteException
    //   306	322	687	java/lang/RuntimeException
    //   306	322	710	finally
    //   328	337	729	finally
    //   339	356	729	finally
    //   358	375	729	finally
    //   377	394	729	finally
    //   396	413	729	finally
    //   415	432	729	finally
    //   434	449	729	finally
    //   460	469	729	finally
    //   471	478	729	finally
    //   480	487	729	finally
    //   494	509	729	finally
    //   515	522	729	finally
    //   524	537	729	finally
    //   543	550	729	finally
    //   552	561	729	finally
    //   563	570	729	finally
    //   594	609	729	finally
    //   623	637	729	finally
    //   654	665	729	finally
    //   667	674	729	finally
    //   692	697	729	finally
    //   328	337	733	java/lang/RuntimeException
    //   339	356	733	java/lang/RuntimeException
    //   358	375	733	java/lang/RuntimeException
    //   377	394	733	java/lang/RuntimeException
    //   396	413	733	java/lang/RuntimeException
    //   415	432	733	java/lang/RuntimeException
    //   434	449	733	java/lang/RuntimeException
    //   460	469	733	java/lang/RuntimeException
    //   471	478	733	java/lang/RuntimeException
    //   480	487	733	java/lang/RuntimeException
    //   494	509	733	java/lang/RuntimeException
    //   515	522	733	java/lang/RuntimeException
    //   524	537	733	java/lang/RuntimeException
    //   543	550	733	java/lang/RuntimeException
    //   552	561	733	java/lang/RuntimeException
    //   563	570	733	java/lang/RuntimeException
    //   594	609	733	java/lang/RuntimeException
    //   623	637	733	java/lang/RuntimeException
    //   328	337	737	android/database/sqlite/SQLiteException
    //   339	356	737	android/database/sqlite/SQLiteException
    //   358	375	737	android/database/sqlite/SQLiteException
    //   377	394	737	android/database/sqlite/SQLiteException
    //   396	413	737	android/database/sqlite/SQLiteException
    //   415	432	737	android/database/sqlite/SQLiteException
    //   434	449	737	android/database/sqlite/SQLiteException
    //   460	469	737	android/database/sqlite/SQLiteException
    //   471	478	737	android/database/sqlite/SQLiteException
    //   480	487	737	android/database/sqlite/SQLiteException
    //   494	509	737	android/database/sqlite/SQLiteException
    //   515	522	737	android/database/sqlite/SQLiteException
    //   524	537	737	android/database/sqlite/SQLiteException
    //   543	550	737	android/database/sqlite/SQLiteException
    //   552	561	737	android/database/sqlite/SQLiteException
    //   563	570	737	android/database/sqlite/SQLiteException
    //   594	609	737	android/database/sqlite/SQLiteException
    //   623	637	737	android/database/sqlite/SQLiteException
  }
  
  public boolean a(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat)
  {
    this.mLog.dl("addGPSTimestamp called timestamp = " + paramLong + " ; long = " + paramDouble1 + " ; lat = " + paramDouble2 + " ; accuracy = " + paramFloat);
    d locald = new d(aIF.getWritableDatabase());
    try
    {
      locald.beginTransaction();
      locald.a("INSERT INTO savedcoords ( creation_time, longitude, latitude, altitude, accuracy) VALUES ( ?, ?, ?, ?, ? );", new String[] { String.valueOf(paramLong), String.valueOf(paramDouble1), String.valueOf(paramDouble2), String.valueOf(paramDouble3), String.valueOf(paramFloat) });
      locald.setTransactionSuccessful();
      this.aII = OperationStatus.avC;
      return true;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.mLog.g("Exception adding timestamp", localSQLiteException);
      this.aII = OperationStatus.awd;
      return false;
    }
    finally
    {
      locald.endTransaction();
    }
  }
  
  /* Error */
  public boolean a(long paramLong, float paramFloat)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 970
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 7
    //   55: ldc_w 972
    //   58: iconst_2
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: fload_3
    //   65: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: lload_1
    //   72: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   79: pop
    //   80: aload 7
    //   82: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   85: aload_0
    //   86: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   89: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   92: aload 7
    //   94: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   97: iload 4
    //   99: ireturn
    //   100: astore 6
    //   102: iconst_0
    //   103: istore 4
    //   105: aload_0
    //   106: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   109: ldc_w 974
    //   112: aload 6
    //   114: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   121: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   124: goto -32 -> 92
    //   127: astore 6
    //   129: aload 7
    //   131: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   134: aload 6
    //   136: athrow
    //   137: astore 6
    //   139: iload 5
    //   141: istore 4
    //   143: goto -38 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	DocumentModel
    //   0	146	1	paramLong	long
    //   0	146	3	paramFloat	float
    //   4	138	4	bool1	boolean
    //   1	139	5	bool2	boolean
    //   100	13	6	localSQLiteException1	SQLiteException
    //   127	8	6	localObject	Object
    //   137	1	6	localSQLiteException2	SQLiteException
    //   46	84	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	85	100	android/database/sqlite/SQLiteException
    //   48	85	127	finally
    //   85	92	127	finally
    //   105	124	127	finally
    //   85	92	137	android/database/sqlite/SQLiteException
  }
  
  public boolean a(long paramLong, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString)
  {
    this.mLog.dl("setLocationData called, pageId=" + paramLong + " ; hasLocationData = " + paramInt + " ; locationDataLong = " + paramDouble1 + " ; locationDataLat = " + paramDouble2 + " ; locationDataAlt = " + paramDouble3 + " ; accuracy = " + paramFloat);
    boolean bool2 = false;
    Object localObject2 = null;
    Cursor localCursor2 = null;
    d locald = new d(aIF.getWritableDatabase());
    Cursor localCursor1 = localCursor2;
    boolean bool1 = bool2;
    Object localObject1 = localObject2;
    try
    {
      locald.beginTransaction();
      localCursor1 = localCursor2;
      bool1 = bool2;
      localObject1 = localObject2;
      localCursor2 = locald.rawQuery("SELECT doc_id FROM pages WHERE id = ?;", new String[] { String.valueOf(paramLong) }, null);
      if (localCursor2 != null)
      {
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        if (localCursor2.moveToFirst()) {}
      }
      else
      {
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        throw new SQLiteException("Could not get page to update");
      }
    }
    catch (SQLiteException paramString)
    {
      localObject1 = localCursor1;
      this.mLog.g("SQL Exception setting location data", paramString);
      localObject1 = localCursor1;
      this.aII = OperationStatus.awd;
      locald.endTransaction();
      if (localCursor1 != null) {
        localCursor1.close();
      }
      for (;;)
      {
        try
        {
          com.mobisystems.mobiscanner.common.d.a(as(paramLong).getCanonicalPath(), paramDouble1, paramDouble2, paramDouble3);
          return bool1;
        }
        catch (IOException paramString)
        {
          long l;
          paramString.printStackTrace();
        }
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        l = localCursor2.getLong(0);
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        locald.b("UPDATE pages SET has_location_data = ?, location_data_long = ?, location_data_lat = ? , location_data_alt = ? , location_data_accuracy = ? , location_data_address = ? WHERE id=?;", new String[] { String.valueOf(paramInt), String.valueOf(paramDouble1), String.valueOf(paramDouble2), String.valueOf(paramDouble3), String.valueOf(paramFloat), String.valueOf(paramString), String.valueOf(paramLong) });
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        aD(l);
        localCursor1 = localCursor2;
        bool1 = bool2;
        localObject1 = localCursor2;
        locald.setTransactionSuccessful();
        bool1 = true;
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        this.aII = OperationStatus.avC;
        locald.endTransaction();
        if (localCursor2 != null) {
          localCursor2.close();
        }
        bool1 = true;
      }
    }
    finally
    {
      locald.endTransaction();
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    return bool1;
  }
  
  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    bool2 = true;
    bool1 = true;
    this.mLog.dl("movePage called, docId=" + paramLong + ", from idx " + paramInt1 + ", to idx " + paramInt2);
    locald = new d(aIF.getWritableDatabase());
    for (;;)
    {
      try
      {
        locald.beginTransaction();
        locald.b("UPDATE pages SET idx_within_doc = ? WHERE doc_id = ? AND idx_within_doc = ?;", new String[] { String.valueOf(0), String.valueOf(paramLong), String.valueOf(paramInt1) });
        if (paramInt1 < paramInt2)
        {
          locald.b("UPDATE pages SET idx_within_doc = idx_within_doc - 1 WHERE doc_id = ? AND idx_within_doc BETWEEN ? AND ?;", new String[] { String.valueOf(paramLong), String.valueOf(paramInt1 + 1), String.valueOf(paramInt2) });
          locald.b("UPDATE pages SET idx_within_doc = ? WHERE doc_id = ? AND idx_within_doc = ?;", new String[] { String.valueOf(paramInt2), String.valueOf(paramLong), String.valueOf(0) });
          aD(paramLong);
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        bool1 = false;
        this.mLog.g("SQL Exception moving page", localSQLiteException1);
        this.aII = OperationStatus.awd;
        continue;
      }
      finally
      {
        locald.endTransaction();
      }
      try
      {
        this.aII = OperationStatus.avC;
        locald.endTransaction();
        return bool1;
      }
      catch (SQLiteException localSQLiteException2)
      {
        bool1 = bool2;
        continue;
      }
      if (paramInt1 > paramInt2) {
        locald.b("UPDATE pages SET idx_within_doc = idx_within_doc + 1 WHERE doc_id = ? AND idx_within_doc BETWEEN ? AND ?;", new String[] { String.valueOf(paramLong), String.valueOf(paramInt2), String.valueOf(paramInt1 - 1) });
      }
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    this.mLog.dl("movePage called, pageId=" + paramLong1 + ", docId=" + paramLong2 + ", to idx " + paramInt);
    d locald = new d(aIF.getWritableDatabase());
    boolean bool1;
    boolean bool2;
    int k;
    label196:
    long l1;
    int j;
    int i;
    label278:
    do
    {
      try
      {
        locald.beginTransaction();
        c localc = aj(paramLong1);
        if (localc == null) {
          throw new IOException("Error reading page " + paramLong1);
        }
      }
      catch (IOException localIOException1)
      {
        bool1 = false;
        this.mLog.g("IO Exception copying page", localIOException1);
        this.aII = OperationStatus.awe;
        bool2 = bool1;
        return bool2;
        k = localIOException1.IU();
        b localb1 = af(paramLong1);
        if (localb1 == null) {
          throw new IOException("Error reading document by page " + paramLong1);
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        for (;;)
        {
          bool1 = false;
          this.mLog.g("SQL Exception moving page", localSQLiteException1);
          this.aII = OperationStatus.awd;
          bool2 = bool1;
        }
      }
      finally
      {
        locald.endTransaction();
      }
      l1 = ((b)localObject).getId();
      j = ((b)localObject).IL();
      if (l1 != paramLong2) {
        break;
      }
      i = paramInt;
      if (paramInt <= 0) {
        i = j;
      }
      bool1 = a(l1, k, i);
      bool2 = bool1;
    } while (!bool1);
    for (;;)
    {
      try
      {
        locald.setTransactionSuccessful();
        this.aII = OperationStatus.avC;
        bool2 = bool1;
      }
      catch (IOException localIOException2)
      {
        break;
        locald.b("UPDATE pages SET idx_within_doc = idx_within_doc - 1 WHERE doc_id = ? AND idx_within_doc BETWEEN ? AND ?;", new String[] { String.valueOf(l1), String.valueOf(k + 1), String.valueOf(j) });
        long l2 = localIOException2.IO();
        aD(l1);
        b localb2 = ae(paramLong2);
        if (localb2 == null) {
          throw new IOException("Error reading document " + paramLong2);
        }
        i = localb2.IL();
        if (paramInt <= 0) {
          break label530;
        }
        locald.b("UPDATE pages SET idx_within_doc = idx_within_doc + 1 WHERE doc_id = ? AND idx_within_doc BETWEEN ? AND ?;", new String[] { String.valueOf(paramLong2), String.valueOf(paramInt), String.valueOf(i) });
        locald.b("UPDATE pages SET doc_id = ?, idx_within_doc = ? WHERE id = ?;", new String[] { String.valueOf(paramLong2), String.valueOf(paramInt), String.valueOf(paramLong1) });
        aD(paramLong2);
        if (paramLong1 == l2) {
          locald.b("UPDATE documents SET title_page_id = coalesce( (SELECT id FROM pages WHERE doc_id=documents.id AND idx_within_doc=1), -1 ) WHERE id = ?;", new String[] { String.valueOf(l1) });
        }
        bool1 = true;
        break label278;
      }
      catch (SQLiteException localSQLiteException2) {}
      break label196;
      label530:
      paramInt = i + 1;
    }
  }
  
  /* Error */
  public boolean a(long paramLong, android.graphics.Matrix paramMatrix)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 7
    //   9: bipush 9
    //   11: newarray <illegal type>
    //   13: astore 10
    //   15: aload_3
    //   16: aload 10
    //   18: invokevirtual 1050	android/graphics/Matrix:getValues	([F)V
    //   21: aload_0
    //   22: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   25: new 494	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 1052
    //   35: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: lload_1
    //   39: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: ldc_w 1054
    //   45: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 10
    //   50: invokestatic 1059	java/util/Arrays:toString	([F)Ljava/lang/String;
    //   53: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   62: new 134	com/mobisystems/mobiscanner/model/d
    //   65: dup
    //   66: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   69: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   72: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   75: astore 11
    //   77: aload 11
    //   79: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   82: aload 11
    //   84: ldc_w 986
    //   87: iconst_1
    //   88: anewarray 160	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: lload_1
    //   94: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: aastore
    //   98: aconst_null
    //   99: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +15 -> 119
    //   107: aload_3
    //   108: astore 9
    //   110: aload_3
    //   111: invokeinterface 200 1 0
    //   116: ifne +73 -> 189
    //   119: aload_3
    //   120: astore 9
    //   122: new 130	android/database/sqlite/SQLiteException
    //   125: dup
    //   126: ldc_w 545
    //   129: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: astore 10
    //   135: iconst_0
    //   136: istore 6
    //   138: aload_3
    //   139: astore 9
    //   141: aload_0
    //   142: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   145: ldc_w 1061
    //   148: aload 10
    //   150: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_3
    //   154: astore 9
    //   156: aload_0
    //   157: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   160: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   163: aload 11
    //   165: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   168: iload 6
    //   170: istore 7
    //   172: aload_3
    //   173: ifnull +13 -> 186
    //   176: aload_3
    //   177: invokeinterface 99 1 0
    //   182: iload 6
    //   184: istore 7
    //   186: iload 7
    //   188: ireturn
    //   189: aload_3
    //   190: astore 9
    //   192: aload_3
    //   193: iconst_0
    //   194: invokeinterface 210 2 0
    //   199: lstore 4
    //   201: aload_3
    //   202: astore 9
    //   204: aload 11
    //   206: ldc_w 1063
    //   209: iconst_2
    //   210: anewarray 160	java/lang/String
    //   213: dup
    //   214: iconst_0
    //   215: aload 10
    //   217: invokestatic 1059	java/util/Arrays:toString	([F)Ljava/lang/String;
    //   220: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: lload_1
    //   227: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   230: aastore
    //   231: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   234: pop
    //   235: aload_3
    //   236: astore 9
    //   238: aload_0
    //   239: lload 4
    //   241: invokespecial 565	com/mobisystems/mobiscanner/model/DocumentModel:aD	(J)V
    //   244: aload_3
    //   245: astore 9
    //   247: aload 11
    //   249: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   252: aload_3
    //   253: astore 9
    //   255: aload_0
    //   256: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   259: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   262: aload 11
    //   264: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   267: iload 8
    //   269: istore 7
    //   271: aload_3
    //   272: ifnull -86 -> 186
    //   275: goto -99 -> 176
    //   278: astore_3
    //   279: aconst_null
    //   280: astore 9
    //   282: aload 11
    //   284: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   287: aload 9
    //   289: ifnull +10 -> 299
    //   292: aload 9
    //   294: invokeinterface 99 1 0
    //   299: aload_3
    //   300: athrow
    //   301: astore_3
    //   302: goto -20 -> 282
    //   305: astore 10
    //   307: aconst_null
    //   308: astore_3
    //   309: iconst_0
    //   310: istore 6
    //   312: goto -174 -> 138
    //   315: astore 10
    //   317: iload 7
    //   319: istore 6
    //   321: goto -183 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	DocumentModel
    //   0	324	1	paramLong	long
    //   0	324	3	paramMatrix	android.graphics.Matrix
    //   199	41	4	l	long
    //   1	319	6	bool1	boolean
    //   7	311	7	bool2	boolean
    //   4	264	8	bool3	boolean
    //   108	185	9	localMatrix	android.graphics.Matrix
    //   13	36	10	arrayOfFloat	float[]
    //   133	83	10	localSQLiteException1	SQLiteException
    //   305	1	10	localSQLiteException2	SQLiteException
    //   315	1	10	localSQLiteException3	SQLiteException
    //   75	208	11	locald	d
    // Exception table:
    //   from	to	target	type
    //   110	119	133	android/database/sqlite/SQLiteException
    //   122	133	133	android/database/sqlite/SQLiteException
    //   192	201	133	android/database/sqlite/SQLiteException
    //   204	235	133	android/database/sqlite/SQLiteException
    //   238	244	133	android/database/sqlite/SQLiteException
    //   247	252	133	android/database/sqlite/SQLiteException
    //   77	103	278	finally
    //   110	119	301	finally
    //   122	133	301	finally
    //   141	153	301	finally
    //   156	163	301	finally
    //   192	201	301	finally
    //   204	235	301	finally
    //   238	244	301	finally
    //   247	252	301	finally
    //   255	262	301	finally
    //   77	103	305	android/database/sqlite/SQLiteException
    //   255	262	315	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean a(long paramLong, com.mobisystems.mobiscanner.common.util.h paramh)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1066
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 6
    //   55: ldc_w 1068
    //   58: iconst_2
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: new 1070	com/google/gson/d
    //   67: dup
    //   68: invokespecial 1071	com/google/gson/d:<init>	()V
    //   71: aload_3
    //   72: invokevirtual 1074	com/google/gson/d:al	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload 6
    //   92: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   95: aload_0
    //   96: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   102: aload 6
    //   104: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   107: iload 4
    //   109: ireturn
    //   110: astore_3
    //   111: iconst_0
    //   112: istore 4
    //   114: aload_0
    //   115: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   118: ldc_w 1076
    //   121: aload_3
    //   122: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   129: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   132: goto -30 -> 102
    //   135: astore_3
    //   136: aload 6
    //   138: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   141: aload_3
    //   142: athrow
    //   143: astore_3
    //   144: iload 5
    //   146: istore 4
    //   148: goto -34 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DocumentModel
    //   0	151	1	paramLong	long
    //   0	151	3	paramh	com.mobisystems.mobiscanner.common.util.h
    //   4	143	4	bool1	boolean
    //   1	144	5	bool2	boolean
    //   46	91	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	95	110	android/database/sqlite/SQLiteException
    //   48	95	135	finally
    //   95	102	135	finally
    //   114	132	135	finally
    //   95	102	143	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean a(long paramLong, ImageOrientation paramImageOrientation)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1079
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 6
    //   55: ldc_w 1081
    //   58: iconst_2
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: invokevirtual 346	com/mobisystems/mobiscanner/image/ImageOrientation:Dp	()I
    //   68: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: lload_1
    //   75: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: aastore
    //   79: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: lload_1
    //   85: invokespecial 442	com/mobisystems/mobiscanner/model/DocumentModel:aE	(J)V
    //   88: aload 6
    //   90: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   93: aload_0
    //   94: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   97: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   100: aload 6
    //   102: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   105: iload 4
    //   107: ireturn
    //   108: astore_3
    //   109: iconst_0
    //   110: istore 4
    //   112: aload_0
    //   113: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   116: ldc_w 1083
    //   119: aload_3
    //   120: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_0
    //   124: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   127: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   130: goto -30 -> 100
    //   133: astore_3
    //   134: aload 6
    //   136: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   139: aload_3
    //   140: athrow
    //   141: astore_3
    //   142: iload 5
    //   144: istore 4
    //   146: goto -34 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	DocumentModel
    //   0	149	1	paramLong	long
    //   0	149	3	paramImageOrientation	ImageOrientation
    //   4	141	4	bool1	boolean
    //   1	142	5	bool2	boolean
    //   46	89	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	93	108	android/database/sqlite/SQLiteException
    //   48	93	133	finally
    //   93	100	133	finally
    //   112	130	133	finally
    //   93	100	141	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean a(long paramLong, b paramb)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1086
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 6
    //   55: ldc_w 1088
    //   58: bipush 14
    //   60: anewarray 160	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: aload_3
    //   66: invokevirtual 1089	com/mobisystems/mobiscanner/model/b:getName	()Ljava/lang/String;
    //   69: invokevirtual 1092	java/lang/String:trim	()Ljava/lang/String;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_3
    //   76: invokevirtual 1095	com/mobisystems/mobiscanner/model/b:IB	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   79: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   82: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: aload_3
    //   89: invokevirtual 1098	com/mobisystems/mobiscanner/model/b:IC	()F
    //   92: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_3
    //   98: aload_3
    //   99: invokevirtual 1101	com/mobisystems/mobiscanner/model/b:ID	()F
    //   102: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   105: aastore
    //   106: dup
    //   107: iconst_4
    //   108: aload_3
    //   109: invokevirtual 1104	com/mobisystems/mobiscanner/model/b:IE	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   112: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   115: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_5
    //   121: aload_3
    //   122: invokevirtual 1107	com/mobisystems/mobiscanner/model/b:IF	()F
    //   125: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: bipush 6
    //   132: aload_3
    //   133: invokevirtual 1110	com/mobisystems/mobiscanner/model/b:IG	()F
    //   136: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: bipush 7
    //   143: aload_3
    //   144: invokevirtual 1113	com/mobisystems/mobiscanner/model/b:IH	()F
    //   147: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   150: aastore
    //   151: dup
    //   152: bipush 8
    //   154: aload_3
    //   155: invokevirtual 1116	com/mobisystems/mobiscanner/model/b:II	()F
    //   158: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   161: aastore
    //   162: dup
    //   163: bipush 9
    //   165: aload_3
    //   166: invokevirtual 1117	com/mobisystems/mobiscanner/model/b:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   169: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   172: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: bipush 10
    //   179: aload_3
    //   180: invokevirtual 1118	com/mobisystems/mobiscanner/model/b:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   183: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   186: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   189: aastore
    //   190: dup
    //   191: bipush 11
    //   193: aload_3
    //   194: invokevirtual 1121	com/mobisystems/mobiscanner/model/b:IQ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   197: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   200: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   203: aastore
    //   204: dup
    //   205: bipush 12
    //   207: aload_3
    //   208: invokevirtual 1124	com/mobisystems/mobiscanner/model/b:IR	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   211: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   214: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: bipush 13
    //   221: lload_1
    //   222: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   225: aastore
    //   226: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   229: pop
    //   230: aload 6
    //   232: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   235: aload_0
    //   236: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   239: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   242: aload 6
    //   244: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   247: iload 4
    //   249: ireturn
    //   250: astore_3
    //   251: iconst_0
    //   252: istore 4
    //   254: aload_0
    //   255: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   258: ldc_w 1126
    //   261: aload_3
    //   262: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_0
    //   266: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   269: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   272: goto -30 -> 242
    //   275: astore_3
    //   276: aload 6
    //   278: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   281: aload_3
    //   282: athrow
    //   283: astore_3
    //   284: iload 5
    //   286: istore 4
    //   288: goto -34 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	DocumentModel
    //   0	291	1	paramLong	long
    //   0	291	3	paramb	b
    //   4	283	4	bool1	boolean
    //   1	284	5	bool2	boolean
    //   46	231	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	235	250	android/database/sqlite/SQLiteException
    //   48	235	275	finally
    //   235	242	275	finally
    //   254	272	275	finally
    //   235	242	283	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean a(long paramLong, c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1129
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 7
    //   55: ldc_w 1131
    //   58: bipush 14
    //   60: anewarray 160	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: aload_3
    //   66: invokevirtual 291	com/mobisystems/mobiscanner/model/c:IV	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   69: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   72: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_3
    //   79: invokevirtual 300	com/mobisystems/mobiscanner/model/c:getWidth	()F
    //   82: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: aload_3
    //   89: invokevirtual 306	com/mobisystems/mobiscanner/model/c:getHeight	()F
    //   92: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_3
    //   98: aload_3
    //   99: invokevirtual 310	com/mobisystems/mobiscanner/model/c:IW	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   102: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   105: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_4
    //   111: aload_3
    //   112: invokevirtual 316	com/mobisystems/mobiscanner/model/c:IX	()F
    //   115: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_5
    //   121: aload_3
    //   122: invokevirtual 319	com/mobisystems/mobiscanner/model/c:IY	()F
    //   125: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: bipush 6
    //   132: aload_3
    //   133: invokevirtual 322	com/mobisystems/mobiscanner/model/c:IZ	()F
    //   136: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: bipush 7
    //   143: aload_3
    //   144: invokevirtual 325	com/mobisystems/mobiscanner/model/c:Ja	()F
    //   147: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   150: aastore
    //   151: dup
    //   152: bipush 8
    //   154: aload_3
    //   155: invokevirtual 329	com/mobisystems/mobiscanner/model/c:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   158: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   161: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: bipush 9
    //   168: aload_3
    //   169: invokevirtual 336	com/mobisystems/mobiscanner/model/c:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   172: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   175: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: aastore
    //   179: dup
    //   180: bipush 10
    //   182: aload_3
    //   183: invokevirtual 394	com/mobisystems/mobiscanner/model/c:Jt	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   186: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   189: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   192: aastore
    //   193: dup
    //   194: bipush 11
    //   196: aload_3
    //   197: invokevirtual 400	com/mobisystems/mobiscanner/model/c:Ju	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   200: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   203: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: bipush 12
    //   210: aload_3
    //   211: invokevirtual 403	com/mobisystems/mobiscanner/model/c:Jv	()I
    //   214: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: bipush 13
    //   221: lload_1
    //   222: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   225: aastore
    //   226: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   229: pop
    //   230: aload_0
    //   231: lload_1
    //   232: invokespecial 442	com/mobisystems/mobiscanner/model/DocumentModel:aE	(J)V
    //   235: aload 7
    //   237: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   240: aload_0
    //   241: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   244: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   247: iload 5
    //   249: istore 4
    //   251: aload_3
    //   252: invokevirtual 403	com/mobisystems/mobiscanner/model/c:Jv	()I
    //   255: ifge +13 -> 268
    //   258: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   261: invokestatic 446	com/mobisystems/mobiscanner/common/d:an	(Landroid/content/Context;)V
    //   264: iload 5
    //   266: istore 4
    //   268: aload 7
    //   270: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   273: iload 4
    //   275: ireturn
    //   276: astore_3
    //   277: iconst_0
    //   278: istore 4
    //   280: aload_0
    //   281: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   284: ldc_w 1133
    //   287: aload_3
    //   288: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload_0
    //   292: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   295: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   298: goto -30 -> 268
    //   301: astore_3
    //   302: aload 7
    //   304: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   307: aload_3
    //   308: athrow
    //   309: astore_3
    //   310: iload 6
    //   312: istore 4
    //   314: goto -34 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	DocumentModel
    //   0	317	1	paramLong	long
    //   0	317	3	paramc	c
    //   249	64	4	bool1	boolean
    //   4	261	5	bool2	boolean
    //   1	310	6	bool3	boolean
    //   46	257	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	240	276	android/database/sqlite/SQLiteException
    //   48	240	301	finally
    //   240	247	301	finally
    //   251	264	301	finally
    //   280	298	301	finally
    //   240	247	309	android/database/sqlite/SQLiteException
    //   251	264	309	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean a(long paramLong, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1136
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 7
    //   55: ldc_w 1138
    //   58: iconst_3
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload 4
    //   73: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: lload_1
    //   80: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   83: aastore
    //   84: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   87: pop
    //   88: aload 7
    //   90: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   93: aload_0
    //   94: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   97: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   100: aload 7
    //   102: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   105: iload 5
    //   107: ireturn
    //   108: astore_3
    //   109: iconst_0
    //   110: istore 5
    //   112: aload_0
    //   113: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   116: ldc_w 1140
    //   119: aload_3
    //   120: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_0
    //   124: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   127: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   130: goto -30 -> 100
    //   133: astore_3
    //   134: aload 7
    //   136: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   139: aload_3
    //   140: athrow
    //   141: astore_3
    //   142: iload 6
    //   144: istore 5
    //   146: goto -34 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	DocumentModel
    //   0	149	1	paramLong	long
    //   0	149	3	paramString1	String
    //   0	149	4	paramString2	String
    //   4	141	5	bool1	boolean
    //   1	142	6	bool2	boolean
    //   46	89	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	93	108	android/database/sqlite/SQLiteException
    //   48	93	133	finally
    //   93	100	133	finally
    //   112	130	133	finally
    //   93	100	141	android/database/sqlite/SQLiteException
  }
  
  public boolean a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.mLog.dl("procImageFilePath called, pageId=" + paramLong + ", procImageFilePath=" + paramString + ", copyFileFlag" + paramBoolean);
    return a(paramLong, paramString, paramBoolean, null);
  }
  
  /* Error */
  public boolean a(long paramLong, java.util.List<com.mobisystems.mobiscanner.common.util.b> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1155
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 6
    //   55: ldc_w 1157
    //   58: iconst_2
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: new 1070	com/google/gson/d
    //   67: dup
    //   68: invokespecial 1071	com/google/gson/d:<init>	()V
    //   71: aload_3
    //   72: invokevirtual 1074	com/google/gson/d:al	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokestatic 381	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload 6
    //   92: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   95: aload_0
    //   96: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   102: aload 6
    //   104: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   107: iload 4
    //   109: ireturn
    //   110: astore_3
    //   111: iconst_0
    //   112: istore 4
    //   114: aload_0
    //   115: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   118: ldc_w 1159
    //   121: aload_3
    //   122: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   129: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   132: goto -30 -> 102
    //   135: astore_3
    //   136: aload 6
    //   138: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   141: aload_3
    //   142: athrow
    //   143: astore_3
    //   144: iload 5
    //   146: istore 4
    //   148: goto -34 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DocumentModel
    //   0	151	1	paramLong	long
    //   0	151	3	paramList	java.util.List<com.mobisystems.mobiscanner.common.util.b>
    //   4	143	4	bool1	boolean
    //   1	144	5	bool2	boolean
    //   46	91	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	95	110	android/database/sqlite/SQLiteException
    //   48	95	135	finally
    //   95	102	135	finally
    //   114	132	135	finally
    //   95	102	143	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean aF(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1163
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   52: aload 6
    //   54: ldc_w 1165
    //   57: iconst_1
    //   58: anewarray 160	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: lload_1
    //   64: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   77: aload_0
    //   78: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   81: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   84: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   87: invokestatic 446	com/mobisystems/mobiscanner/common/d:an	(Landroid/content/Context;)V
    //   90: aload 6
    //   92: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   95: iload_3
    //   96: ireturn
    //   97: astore 5
    //   99: iconst_0
    //   100: istore_3
    //   101: aload_0
    //   102: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   105: ldc_w 1167
    //   108: aload 5
    //   110: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   117: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   120: goto -30 -> 90
    //   123: astore 5
    //   125: aload 6
    //   127: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   130: aload 5
    //   132: athrow
    //   133: astore 5
    //   135: iload 4
    //   137: istore_3
    //   138: goto -37 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	DocumentModel
    //   0	141	1	paramLong	long
    //   4	134	3	bool1	boolean
    //   1	135	4	bool2	boolean
    //   97	12	5	localSQLiteException1	SQLiteException
    //   123	8	5	localObject	Object
    //   133	1	5	localSQLiteException2	SQLiteException
    //   45	81	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   47	77	97	android/database/sqlite/SQLiteException
    //   47	77	123	finally
    //   77	90	123	finally
    //   101	120	123	finally
    //   77	90	133	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean aG(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1170
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   52: aload 6
    //   54: ldc_w 1172
    //   57: iconst_1
    //   58: anewarray 160	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: lload_1
    //   64: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   77: aload_0
    //   78: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   81: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   84: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   87: invokestatic 446	com/mobisystems/mobiscanner/common/d:an	(Landroid/content/Context;)V
    //   90: aload 6
    //   92: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   95: iload_3
    //   96: ireturn
    //   97: astore 5
    //   99: iconst_0
    //   100: istore_3
    //   101: aload_0
    //   102: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   105: ldc_w 1174
    //   108: aload 5
    //   110: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   117: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   120: goto -30 -> 90
    //   123: astore 5
    //   125: aload 6
    //   127: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   130: aload 5
    //   132: athrow
    //   133: astore 5
    //   135: iload 4
    //   137: istore_3
    //   138: goto -37 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	DocumentModel
    //   0	141	1	paramLong	long
    //   4	134	3	bool1	boolean
    //   1	135	4	bool2	boolean
    //   97	12	5	localSQLiteException1	SQLiteException
    //   123	8	5	localObject	Object
    //   133	1	5	localSQLiteException2	SQLiteException
    //   45	81	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   47	77	97	android/database/sqlite/SQLiteException
    //   47	77	123	finally
    //   77	90	123	finally
    //   101	120	123	finally
    //   77	90	133	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean aH(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1177
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   52: aload 6
    //   54: ldc_w 1179
    //   57: iconst_1
    //   58: anewarray 160	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: lload_1
    //   64: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   77: aload_0
    //   78: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   81: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   84: getstatic 272	com/mobisystems/mobiscanner/model/DocumentModel:mContext	Landroid/content/Context;
    //   87: invokestatic 446	com/mobisystems/mobiscanner/common/d:an	(Landroid/content/Context;)V
    //   90: aload 6
    //   92: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   95: iload_3
    //   96: ireturn
    //   97: astore 5
    //   99: iconst_0
    //   100: istore_3
    //   101: aload_0
    //   102: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   105: ldc_w 1181
    //   108: aload 5
    //   110: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_0
    //   114: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   117: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   120: goto -30 -> 90
    //   123: astore 5
    //   125: aload 6
    //   127: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   130: aload 5
    //   132: athrow
    //   133: astore 5
    //   135: iload 4
    //   137: istore_3
    //   138: goto -37 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	DocumentModel
    //   0	141	1	paramLong	long
    //   4	134	3	bool1	boolean
    //   1	135	4	bool2	boolean
    //   97	12	5	localSQLiteException1	SQLiteException
    //   123	8	5	localObject	Object
    //   133	1	5	localSQLiteException2	SQLiteException
    //   45	81	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   47	77	97	android/database/sqlite/SQLiteException
    //   47	77	123	finally
    //   77	90	123	finally
    //   101	120	123	finally
    //   77	90	133	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public com.mobisystems.mobiscanner.common.util.h aI(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 540	com/mobisystems/mobiscanner/common/OperationStatus:awf	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   4: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   7: new 134	com/mobisystems/mobiscanner/model/d
    //   10: dup
    //   11: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   14: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   20: astore_3
    //   21: lload_1
    //   22: lconst_0
    //   23: lcmp
    //   24: iflt +238 -> 262
    //   27: aload_3
    //   28: ldc_w 1185
    //   31: iconst_1
    //   32: anewarray 160	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: lload_1
    //   38: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   41: aastore
    //   42: aconst_null
    //   43: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +17 -> 67
    //   53: aload 4
    //   55: astore 5
    //   57: aload 4
    //   59: invokeinterface 200 1 0
    //   64: ifne +70 -> 134
    //   67: aload 4
    //   69: astore 5
    //   71: new 130	android/database/sqlite/SQLiteException
    //   74: dup
    //   75: ldc_w 1187
    //   78: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: astore 6
    //   84: aconst_null
    //   85: astore_3
    //   86: aload 4
    //   88: astore 5
    //   90: aload_0
    //   91: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   94: ldc_w 1189
    //   97: aload 6
    //   99: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aload 4
    //   104: astore 5
    //   106: aload_0
    //   107: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   110: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   113: aload_3
    //   114: astore 5
    //   116: aload 4
    //   118: ifnull +13 -> 131
    //   121: aload 4
    //   123: invokeinterface 99 1 0
    //   128: aload_3
    //   129: astore 5
    //   131: aload 5
    //   133: areturn
    //   134: aload 4
    //   136: astore 5
    //   138: aload 4
    //   140: iconst_0
    //   141: invokeinterface 909 2 0
    //   146: astore_3
    //   147: aload 4
    //   149: astore 5
    //   151: new 1070	com/google/gson/d
    //   154: dup
    //   155: invokespecial 1071	com/google/gson/d:<init>	()V
    //   158: aload_3
    //   159: ldc_w 1191
    //   162: invokevirtual 1194	com/google/gson/d:a	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   165: checkcast 1191	com/mobisystems/mobiscanner/common/util/h
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull +48 -> 218
    //   173: aload 4
    //   175: astore 5
    //   177: aload_3
    //   178: invokevirtual 1198	com/mobisystems/mobiscanner/common/util/h:vh	()Ljava/util/List;
    //   181: astore 6
    //   183: aload 6
    //   185: ifnonnull +33 -> 218
    //   188: aload 4
    //   190: astore 5
    //   192: new 130	android/database/sqlite/SQLiteException
    //   195: dup
    //   196: ldc_w 1200
    //   199: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   202: athrow
    //   203: astore_3
    //   204: aload 5
    //   206: ifnull +10 -> 216
    //   209: aload 5
    //   211: invokeinterface 99 1 0
    //   216: aload_3
    //   217: athrow
    //   218: aload 4
    //   220: astore 5
    //   222: aload_0
    //   223: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   226: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   229: aload_3
    //   230: astore 5
    //   232: aload 4
    //   234: ifnull -103 -> 131
    //   237: goto -116 -> 121
    //   240: astore_3
    //   241: aconst_null
    //   242: astore 5
    //   244: goto -40 -> 204
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 4
    //   252: aconst_null
    //   253: astore_3
    //   254: goto -168 -> 86
    //   257: astore 6
    //   259: goto -173 -> 86
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_3
    //   267: goto -38 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	DocumentModel
    //   0	270	1	paramLong	long
    //   20	158	3	localObject1	Object
    //   203	27	3	localObject2	Object
    //   240	1	3	localObject3	Object
    //   253	14	3	localObject4	Object
    //   46	218	4	localCursor	Cursor
    //   55	188	5	localObject5	Object
    //   82	16	6	localSQLiteException1	SQLiteException
    //   181	3	6	localList	java.util.List
    //   247	1	6	localSQLiteException2	SQLiteException
    //   257	1	6	localSQLiteException3	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   57	67	82	android/database/sqlite/SQLiteException
    //   71	82	82	android/database/sqlite/SQLiteException
    //   138	147	82	android/database/sqlite/SQLiteException
    //   151	169	82	android/database/sqlite/SQLiteException
    //   192	203	82	android/database/sqlite/SQLiteException
    //   57	67	203	finally
    //   71	82	203	finally
    //   90	102	203	finally
    //   106	113	203	finally
    //   138	147	203	finally
    //   151	169	203	finally
    //   177	183	203	finally
    //   192	203	203	finally
    //   222	229	203	finally
    //   27	48	240	finally
    //   27	48	247	android/database/sqlite/SQLiteException
    //   177	183	257	android/database/sqlite/SQLiteException
    //   222	229	257	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public java.util.List<com.mobisystems.mobiscanner.common.util.b> aJ(long paramLong)
  {
    // Byte code:
    //   0: new 1204	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 1205	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getstatic 540	com/mobisystems/mobiscanner/common/OperationStatus:awf	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   12: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   15: new 134	com/mobisystems/mobiscanner/model/d
    //   18: dup
    //   19: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   22: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   28: astore 4
    //   30: lload_1
    //   31: lconst_0
    //   32: lcmp
    //   33: iflt +222 -> 255
    //   36: aload 4
    //   38: ldc_w 1207
    //   41: iconst_1
    //   42: anewarray 160	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: lload_1
    //   48: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   51: aastore
    //   52: aconst_null
    //   53: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +17 -> 77
    //   63: aload 4
    //   65: astore 5
    //   67: aload 4
    //   69: invokeinterface 200 1 0
    //   74: ifne +68 -> 142
    //   77: aload 4
    //   79: astore 5
    //   81: new 130	android/database/sqlite/SQLiteException
    //   84: dup
    //   85: ldc_w 1209
    //   88: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   91: athrow
    //   92: astore 6
    //   94: aload 4
    //   96: astore 5
    //   98: aload_0
    //   99: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   102: ldc_w 1211
    //   105: aload 6
    //   107: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload 4
    //   112: astore 5
    //   114: aload_0
    //   115: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   118: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   121: aload_3
    //   122: astore 5
    //   124: aload 4
    //   126: ifnull +13 -> 139
    //   129: aload 4
    //   131: invokeinterface 99 1 0
    //   136: aload_3
    //   137: astore 5
    //   139: aload 5
    //   141: areturn
    //   142: aload 4
    //   144: astore 5
    //   146: aload 4
    //   148: iconst_0
    //   149: invokeinterface 909 2 0
    //   154: astore 6
    //   156: aload 4
    //   158: astore 5
    //   160: new 1070	com/google/gson/d
    //   163: dup
    //   164: invokespecial 1071	com/google/gson/d:<init>	()V
    //   167: aload 6
    //   169: new 6	com/mobisystems/mobiscanner/model/DocumentModel$1
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 1214	com/mobisystems/mobiscanner/model/DocumentModel$1:<init>	(Lcom/mobisystems/mobiscanner/model/DocumentModel;)V
    //   177: invokevirtual 1218	com/mobisystems/mobiscanner/model/DocumentModel$1:Aa	()Ljava/lang/reflect/Type;
    //   180: invokevirtual 1221	com/google/gson/d:a	(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   183: checkcast 1223	java/util/List
    //   186: astore 6
    //   188: aload 4
    //   190: astore 5
    //   192: aload_0
    //   193: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   196: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   199: aload 6
    //   201: astore_3
    //   202: aload_3
    //   203: astore 5
    //   205: aload 4
    //   207: ifnull -68 -> 139
    //   210: goto -81 -> 129
    //   213: astore_3
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 5
    //   219: ifnull +10 -> 229
    //   222: aload 5
    //   224: invokeinterface 99 1 0
    //   229: aload_3
    //   230: athrow
    //   231: astore_3
    //   232: goto -15 -> 217
    //   235: astore 6
    //   237: aconst_null
    //   238: astore 4
    //   240: goto -146 -> 94
    //   243: astore 5
    //   245: aload 6
    //   247: astore_3
    //   248: aload 5
    //   250: astore 6
    //   252: goto -158 -> 94
    //   255: aconst_null
    //   256: astore 4
    //   258: goto -56 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	DocumentModel
    //   0	261	1	paramLong	long
    //   7	196	3	localObject1	Object
    //   213	17	3	localObject2	Object
    //   231	1	3	localObject3	Object
    //   247	1	3	localObject4	Object
    //   28	229	4	localObject5	Object
    //   65	158	5	localObject6	Object
    //   243	6	5	localSQLiteException1	SQLiteException
    //   92	14	6	localSQLiteException2	SQLiteException
    //   154	46	6	localObject7	Object
    //   235	11	6	localSQLiteException3	SQLiteException
    //   250	1	6	localSQLiteException4	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   67	77	92	android/database/sqlite/SQLiteException
    //   81	92	92	android/database/sqlite/SQLiteException
    //   146	156	92	android/database/sqlite/SQLiteException
    //   160	188	92	android/database/sqlite/SQLiteException
    //   36	58	213	finally
    //   67	77	231	finally
    //   81	92	231	finally
    //   98	110	231	finally
    //   114	121	231	finally
    //   146	156	231	finally
    //   160	188	231	finally
    //   192	199	231	finally
    //   36	58	235	android/database/sqlite/SQLiteException
    //   192	199	243	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean aK(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1226
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload 6
    //   49: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   52: aload 6
    //   54: ldc_w 1228
    //   57: iconst_1
    //   58: anewarray 160	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: lload_1
    //   64: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   71: pop
    //   72: aload 6
    //   74: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   77: aload_0
    //   78: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   81: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   84: aload 6
    //   86: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   89: iload_3
    //   90: ireturn
    //   91: astore 5
    //   93: iconst_0
    //   94: istore_3
    //   95: aload_0
    //   96: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   99: ldc_w 1230
    //   102: aload 5
    //   104: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   111: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   114: goto -30 -> 84
    //   117: astore 5
    //   119: aload 6
    //   121: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   124: aload 5
    //   126: athrow
    //   127: astore 5
    //   129: iload 4
    //   131: istore_3
    //   132: goto -37 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	DocumentModel
    //   0	135	1	paramLong	long
    //   4	128	3	bool1	boolean
    //   1	129	4	bool2	boolean
    //   91	12	5	localSQLiteException1	SQLiteException
    //   117	8	5	localObject	Object
    //   127	1	5	localSQLiteException2	SQLiteException
    //   45	75	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   47	77	91	android/database/sqlite/SQLiteException
    //   47	77	117	finally
    //   77	84	117	finally
    //   95	114	117	finally
    //   77	84	127	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public b ae(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1232
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload_3
    //   48: astore 5
    //   50: aload_0
    //   51: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   54: aload_3
    //   55: astore 5
    //   57: aload_0
    //   58: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   61: astore 7
    //   63: aload_3
    //   64: astore 5
    //   66: aload 6
    //   68: ldc_w 768
    //   71: iconst_1
    //   72: anewarray 160	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: lload_1
    //   78: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: aastore
    //   82: aload 7
    //   84: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +63 -> 152
    //   92: aload_3
    //   93: astore 5
    //   95: aload_3
    //   96: invokeinterface 200 1 0
    //   101: ifeq +51 -> 152
    //   104: aload_3
    //   105: astore 5
    //   107: new 146	com/mobisystems/mobiscanner/model/b
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 764	com/mobisystems/mobiscanner/model/b:<init>	(Landroid/database/Cursor;)V
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: aload_0
    //   121: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   124: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   127: aload_0
    //   128: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   131: aload 4
    //   133: astore 5
    //   135: aload_3
    //   136: ifnull +13 -> 149
    //   139: aload_3
    //   140: invokeinterface 99 1 0
    //   145: aload 4
    //   147: astore 5
    //   149: aload 5
    //   151: areturn
    //   152: aload_3
    //   153: astore 5
    //   155: aload_0
    //   156: getstatic 771	com/mobisystems/mobiscanner/common/OperationStatus:avZ	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   159: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   162: aconst_null
    //   163: astore 4
    //   165: goto -38 -> 127
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_3
    //   172: aload 4
    //   174: astore 5
    //   176: aload_0
    //   177: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   180: ldc_w 773
    //   183: aload 6
    //   185: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload 4
    //   190: astore 5
    //   192: aload_0
    //   193: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   196: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   199: aload_0
    //   200: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   203: aload_3
    //   204: astore 5
    //   206: aload 4
    //   208: ifnull -59 -> 149
    //   211: aload 4
    //   213: invokeinterface 99 1 0
    //   218: aload_3
    //   219: areturn
    //   220: astore 6
    //   222: aconst_null
    //   223: astore_3
    //   224: aconst_null
    //   225: astore 4
    //   227: aload_3
    //   228: astore 5
    //   230: aload_0
    //   231: aload 6
    //   233: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   236: aload_0
    //   237: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   240: aload 4
    //   242: astore 5
    //   244: aload_3
    //   245: ifnull -96 -> 149
    //   248: goto -109 -> 139
    //   251: astore_3
    //   252: aload_0
    //   253: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   256: aload 5
    //   258: ifnull +10 -> 268
    //   261: aload 5
    //   263: invokeinterface 99 1 0
    //   268: aload_3
    //   269: athrow
    //   270: astore_3
    //   271: goto -19 -> 252
    //   274: astore 6
    //   276: aconst_null
    //   277: astore 4
    //   279: goto -52 -> 227
    //   282: astore 6
    //   284: goto -57 -> 227
    //   287: astore 6
    //   289: aconst_null
    //   290: astore 5
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -126 -> 172
    //   301: astore 6
    //   303: aload_3
    //   304: astore 5
    //   306: aload 4
    //   308: astore_3
    //   309: aload 5
    //   311: astore 4
    //   313: goto -141 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	DocumentModel
    //   0	316	1	paramLong	long
    //   1	244	3	localCursor	Cursor
    //   251	18	3	localObject1	Object
    //   270	23	3	localObject2	Object
    //   297	12	3	localObject3	Object
    //   3	309	4	localObject4	Object
    //   48	262	5	localObject5	Object
    //   45	22	6	locald	d
    //   168	16	6	localSQLiteException1	SQLiteException
    //   220	12	6	localRuntimeException1	RuntimeException
    //   274	1	6	localRuntimeException2	RuntimeException
    //   282	1	6	localRuntimeException3	RuntimeException
    //   287	1	6	localSQLiteException2	SQLiteException
    //   301	1	6	localSQLiteException3	SQLiteException
    //   61	22	7	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   50	54	168	android/database/sqlite/SQLiteException
    //   57	63	168	android/database/sqlite/SQLiteException
    //   66	88	168	android/database/sqlite/SQLiteException
    //   50	54	220	java/lang/RuntimeException
    //   57	63	220	java/lang/RuntimeException
    //   66	88	220	java/lang/RuntimeException
    //   50	54	251	finally
    //   57	63	251	finally
    //   66	88	251	finally
    //   176	188	251	finally
    //   192	199	251	finally
    //   95	104	270	finally
    //   107	117	270	finally
    //   120	127	270	finally
    //   155	162	270	finally
    //   230	236	270	finally
    //   95	104	274	java/lang/RuntimeException
    //   107	117	274	java/lang/RuntimeException
    //   155	162	274	java/lang/RuntimeException
    //   120	127	282	java/lang/RuntimeException
    //   95	104	287	android/database/sqlite/SQLiteException
    //   107	117	287	android/database/sqlite/SQLiteException
    //   155	162	287	android/database/sqlite/SQLiteException
    //   120	127	301	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public b af(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   9: new 494	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1234
    //   19: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   26: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   32: new 134	com/mobisystems/mobiscanner/model/d
    //   35: dup
    //   36: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   39: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   45: astore 6
    //   47: aload_3
    //   48: astore 5
    //   50: aload_0
    //   51: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   54: aload_3
    //   55: astore 5
    //   57: aload_0
    //   58: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   61: astore 7
    //   63: aload_3
    //   64: astore 5
    //   66: aload 6
    //   68: ldc_w 1236
    //   71: iconst_1
    //   72: anewarray 160	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: lload_1
    //   78: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: aastore
    //   82: aload 7
    //   84: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   87: astore_3
    //   88: aload_3
    //   89: ifnull +63 -> 152
    //   92: aload_3
    //   93: astore 5
    //   95: aload_3
    //   96: invokeinterface 200 1 0
    //   101: ifeq +51 -> 152
    //   104: aload_3
    //   105: astore 5
    //   107: new 146	com/mobisystems/mobiscanner/model/b
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 764	com/mobisystems/mobiscanner/model/b:<init>	(Landroid/database/Cursor;)V
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: aload_0
    //   121: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   124: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   127: aload_0
    //   128: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   131: aload 4
    //   133: astore 5
    //   135: aload_3
    //   136: ifnull +13 -> 149
    //   139: aload_3
    //   140: invokeinterface 99 1 0
    //   145: aload 4
    //   147: astore 5
    //   149: aload 5
    //   151: areturn
    //   152: aload_3
    //   153: astore 5
    //   155: aload_0
    //   156: getstatic 1239	com/mobisystems/mobiscanner/common/OperationStatus:awa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   159: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   162: aconst_null
    //   163: astore 4
    //   165: goto -38 -> 127
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_3
    //   172: aload 4
    //   174: astore 5
    //   176: aload_0
    //   177: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   180: ldc_w 1241
    //   183: aload 6
    //   185: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload 4
    //   190: astore 5
    //   192: aload_0
    //   193: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   196: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   199: aload_0
    //   200: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   203: aload_3
    //   204: astore 5
    //   206: aload 4
    //   208: ifnull -59 -> 149
    //   211: aload 4
    //   213: invokeinterface 99 1 0
    //   218: aload_3
    //   219: areturn
    //   220: astore 6
    //   222: aconst_null
    //   223: astore_3
    //   224: aconst_null
    //   225: astore 4
    //   227: aload_3
    //   228: astore 5
    //   230: aload_0
    //   231: aload 6
    //   233: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   236: aload_0
    //   237: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   240: aload 4
    //   242: astore 5
    //   244: aload_3
    //   245: ifnull -96 -> 149
    //   248: goto -109 -> 139
    //   251: astore_3
    //   252: aload_0
    //   253: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   256: aload 5
    //   258: ifnull +10 -> 268
    //   261: aload 5
    //   263: invokeinterface 99 1 0
    //   268: aload_3
    //   269: athrow
    //   270: astore_3
    //   271: goto -19 -> 252
    //   274: astore 6
    //   276: aconst_null
    //   277: astore 4
    //   279: goto -52 -> 227
    //   282: astore 6
    //   284: goto -57 -> 227
    //   287: astore 6
    //   289: aconst_null
    //   290: astore 5
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_3
    //   298: goto -126 -> 172
    //   301: astore 6
    //   303: aload_3
    //   304: astore 5
    //   306: aload 4
    //   308: astore_3
    //   309: aload 5
    //   311: astore 4
    //   313: goto -141 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	DocumentModel
    //   0	316	1	paramLong	long
    //   1	244	3	localCursor	Cursor
    //   251	18	3	localObject1	Object
    //   270	23	3	localObject2	Object
    //   297	12	3	localObject3	Object
    //   3	309	4	localObject4	Object
    //   48	262	5	localObject5	Object
    //   45	22	6	locald	d
    //   168	16	6	localSQLiteException1	SQLiteException
    //   220	12	6	localRuntimeException1	RuntimeException
    //   274	1	6	localRuntimeException2	RuntimeException
    //   282	1	6	localRuntimeException3	RuntimeException
    //   287	1	6	localSQLiteException2	SQLiteException
    //   301	1	6	localSQLiteException3	SQLiteException
    //   61	22	7	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   50	54	168	android/database/sqlite/SQLiteException
    //   57	63	168	android/database/sqlite/SQLiteException
    //   66	88	168	android/database/sqlite/SQLiteException
    //   50	54	220	java/lang/RuntimeException
    //   57	63	220	java/lang/RuntimeException
    //   66	88	220	java/lang/RuntimeException
    //   50	54	251	finally
    //   57	63	251	finally
    //   66	88	251	finally
    //   176	188	251	finally
    //   192	199	251	finally
    //   95	104	270	finally
    //   107	117	270	finally
    //   120	127	270	finally
    //   155	162	270	finally
    //   230	236	270	finally
    //   95	104	274	java/lang/RuntimeException
    //   107	117	274	java/lang/RuntimeException
    //   155	162	274	java/lang/RuntimeException
    //   120	127	282	java/lang/RuntimeException
    //   95	104	287	android/database/sqlite/SQLiteException
    //   107	117	287	android/database/sqlite/SQLiteException
    //   155	162	287	android/database/sqlite/SQLiteException
    //   120	127	301	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean ag(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 7
    //   6: iconst_1
    //   7: istore 8
    //   9: iconst_1
    //   10: istore 9
    //   12: iconst_1
    //   13: istore 4
    //   15: iconst_0
    //   16: istore 5
    //   18: aload_0
    //   19: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   22: new 494	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1244
    //   32: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_1
    //   36: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   45: new 134	com/mobisystems/mobiscanner/model/d
    //   48: dup
    //   49: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   52: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   55: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   58: astore 15
    //   60: aload 15
    //   62: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   65: iconst_1
    //   66: anewarray 160	java/lang/String
    //   69: astore 12
    //   71: aload 12
    //   73: iconst_0
    //   74: lload_1
    //   75: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: aastore
    //   79: aload 15
    //   81: ldc_w 1246
    //   84: aload 12
    //   86: aconst_null
    //   87: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   90: astore 10
    //   92: aload 10
    //   94: invokeinterface 787 1 0
    //   99: newarray <illegal type>
    //   101: astore 11
    //   103: aload 10
    //   105: invokeinterface 200 1 0
    //   110: pop
    //   111: iconst_0
    //   112: istore_3
    //   113: aload 10
    //   115: invokeinterface 1249 1 0
    //   120: ifne +30 -> 150
    //   123: aload 11
    //   125: iload_3
    //   126: aload 10
    //   128: iconst_0
    //   129: invokeinterface 210 2 0
    //   134: lastore
    //   135: aload 10
    //   137: invokeinterface 798 1 0
    //   142: pop
    //   143: iload_3
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: goto -34 -> 113
    //   150: aload_0
    //   151: aload 11
    //   153: invokespecial 1251	com/mobisystems/mobiscanner/model/DocumentModel:c	([J)V
    //   156: aload 15
    //   158: ldc_w 1253
    //   161: aload 12
    //   163: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   166: pop
    //   167: aload 15
    //   169: ldc_w 1255
    //   172: aload 12
    //   174: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   177: pop
    //   178: aload 15
    //   180: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   183: iload 9
    //   185: istore 5
    //   187: aload 11
    //   189: astore 13
    //   191: aload 10
    //   193: astore 12
    //   195: aload_0
    //   196: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   199: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   202: aload 15
    //   204: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   207: aload 11
    //   209: ifnull +9 -> 218
    //   212: aload_0
    //   213: aload 11
    //   215: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   218: iload 6
    //   220: istore 5
    //   222: aload 10
    //   224: ifnull +14 -> 238
    //   227: aload 10
    //   229: invokeinterface 99 1 0
    //   234: iload 4
    //   236: istore 5
    //   238: iload 5
    //   240: ireturn
    //   241: astore 14
    //   243: aconst_null
    //   244: astore 11
    //   246: aconst_null
    //   247: astore 10
    //   249: iconst_0
    //   250: istore 4
    //   252: iload 4
    //   254: istore 5
    //   256: aload 11
    //   258: astore 13
    //   260: aload 10
    //   262: astore 12
    //   264: aload_0
    //   265: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   268: ldc_w 1259
    //   271: aload 14
    //   273: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: iload 4
    //   278: istore 5
    //   280: aload 11
    //   282: astore 13
    //   284: aload 10
    //   286: astore 12
    //   288: aload_0
    //   289: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   292: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   295: aload 15
    //   297: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   300: aload 11
    //   302: ifnull +14 -> 316
    //   305: iload 4
    //   307: ifeq +165 -> 472
    //   310: aload_0
    //   311: aload 11
    //   313: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   316: iload 4
    //   318: istore 5
    //   320: aload 10
    //   322: ifnull -84 -> 238
    //   325: goto -98 -> 227
    //   328: astore 14
    //   330: aconst_null
    //   331: astore 11
    //   333: aconst_null
    //   334: astore 10
    //   336: iconst_0
    //   337: istore 4
    //   339: iload 4
    //   341: istore 5
    //   343: aload 11
    //   345: astore 13
    //   347: aload 10
    //   349: astore 12
    //   351: aload_0
    //   352: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   355: ldc_w 1259
    //   358: aload 14
    //   360: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: iload 4
    //   365: istore 5
    //   367: aload 11
    //   369: astore 13
    //   371: aload 10
    //   373: astore 12
    //   375: aload_0
    //   376: getstatic 486	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   379: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   382: aload 15
    //   384: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   387: aload 11
    //   389: ifnull +14 -> 403
    //   392: iload 4
    //   394: ifeq +87 -> 481
    //   397: aload_0
    //   398: aload 11
    //   400: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   403: iload 4
    //   405: istore 5
    //   407: aload 10
    //   409: ifnull -171 -> 238
    //   412: goto -185 -> 227
    //   415: astore 14
    //   417: aconst_null
    //   418: astore 11
    //   420: aconst_null
    //   421: astore 10
    //   423: iload 5
    //   425: istore 4
    //   427: aload 15
    //   429: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   432: aload 11
    //   434: ifnull +14 -> 448
    //   437: iload 4
    //   439: ifeq +24 -> 463
    //   442: aload_0
    //   443: aload 11
    //   445: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   448: aload 10
    //   450: ifnull +10 -> 460
    //   453: aload 10
    //   455: invokeinterface 99 1 0
    //   460: aload 14
    //   462: athrow
    //   463: aload_0
    //   464: aload 11
    //   466: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   469: goto -21 -> 448
    //   472: aload_0
    //   473: aload 11
    //   475: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   478: goto -162 -> 316
    //   481: aload_0
    //   482: aload 11
    //   484: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   487: goto -84 -> 403
    //   490: astore 14
    //   492: aconst_null
    //   493: astore 11
    //   495: iload 5
    //   497: istore 4
    //   499: goto -72 -> 427
    //   502: astore 14
    //   504: iload 5
    //   506: istore 4
    //   508: goto -81 -> 427
    //   511: astore 14
    //   513: iload 5
    //   515: istore 4
    //   517: aload 13
    //   519: astore 11
    //   521: aload 12
    //   523: astore 10
    //   525: goto -98 -> 427
    //   528: astore 14
    //   530: aconst_null
    //   531: astore 11
    //   533: iconst_0
    //   534: istore 4
    //   536: goto -197 -> 339
    //   539: astore 14
    //   541: iconst_0
    //   542: istore 4
    //   544: goto -205 -> 339
    //   547: astore 14
    //   549: iload 8
    //   551: istore 4
    //   553: goto -214 -> 339
    //   556: astore 14
    //   558: aconst_null
    //   559: astore 11
    //   561: iconst_0
    //   562: istore 4
    //   564: goto -312 -> 252
    //   567: astore 14
    //   569: iconst_0
    //   570: istore 4
    //   572: goto -320 -> 252
    //   575: astore 14
    //   577: iload 7
    //   579: istore 4
    //   581: goto -329 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	DocumentModel
    //   0	584	1	paramLong	long
    //   112	35	3	i	int
    //   13	567	4	bool1	boolean
    //   16	498	5	bool2	boolean
    //   1	218	6	bool3	boolean
    //   4	574	7	bool4	boolean
    //   7	543	8	bool5	boolean
    //   10	174	9	bool6	boolean
    //   90	434	10	localObject1	Object
    //   101	459	11	localObject2	Object
    //   69	453	12	localObject3	Object
    //   189	329	13	localObject4	Object
    //   241	31	14	localSQLiteException1	SQLiteException
    //   328	31	14	localIOException1	IOException
    //   415	46	14	localObject5	Object
    //   490	1	14	localObject6	Object
    //   502	1	14	localObject7	Object
    //   511	1	14	localObject8	Object
    //   528	1	14	localIOException2	IOException
    //   539	1	14	localIOException3	IOException
    //   547	1	14	localIOException4	IOException
    //   556	1	14	localSQLiteException2	SQLiteException
    //   567	1	14	localSQLiteException3	SQLiteException
    //   575	1	14	localSQLiteException4	SQLiteException
    //   58	370	15	locald	d
    // Exception table:
    //   from	to	target	type
    //   60	92	241	android/database/sqlite/SQLiteException
    //   60	92	328	java/io/IOException
    //   60	92	415	finally
    //   92	103	490	finally
    //   103	111	502	finally
    //   113	143	502	finally
    //   150	183	502	finally
    //   195	202	511	finally
    //   264	276	511	finally
    //   288	295	511	finally
    //   351	363	511	finally
    //   375	382	511	finally
    //   92	103	528	java/io/IOException
    //   103	111	539	java/io/IOException
    //   113	143	539	java/io/IOException
    //   150	183	539	java/io/IOException
    //   195	202	547	java/io/IOException
    //   92	103	556	android/database/sqlite/SQLiteException
    //   103	111	567	android/database/sqlite/SQLiteException
    //   113	143	567	android/database/sqlite/SQLiteException
    //   150	183	567	android/database/sqlite/SQLiteException
    //   195	202	575	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public Cursor ah(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: new 494	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1265
    //   14: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   27: new 134	com/mobisystems/mobiscanner/model/d
    //   30: dup
    //   31: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   34: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   40: astore_3
    //   41: aload_0
    //   42: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   45: aload_0
    //   46: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   49: astore 4
    //   51: aload_3
    //   52: ldc_w 1267
    //   55: iconst_1
    //   56: anewarray 160	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: lload_1
    //   62: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   65: aastore
    //   66: aload 4
    //   68: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   71: astore_3
    //   72: aload_0
    //   73: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   76: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   79: aload_0
    //   80: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   83: aload_3
    //   84: areturn
    //   85: astore 4
    //   87: aconst_null
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   93: ldc_w 1269
    //   96: aload 4
    //   98: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_0
    //   102: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   105: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   108: goto -29 -> 79
    //   111: astore_3
    //   112: aload_0
    //   113: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   116: aload_3
    //   117: athrow
    //   118: astore 4
    //   120: aconst_null
    //   121: astore_3
    //   122: aload_0
    //   123: aload 4
    //   125: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   128: goto -49 -> 79
    //   131: astore 4
    //   133: goto -11 -> 122
    //   136: astore 4
    //   138: goto -49 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	DocumentModel
    //   0	141	1	paramLong	long
    //   40	49	3	localObject1	Object
    //   111	6	3	localObject2	Object
    //   121	1	3	localObject3	Object
    //   49	18	4	localCancellationSignal	CancellationSignal
    //   85	12	4	localSQLiteException1	SQLiteException
    //   118	6	4	localRuntimeException1	RuntimeException
    //   131	1	4	localRuntimeException2	RuntimeException
    //   136	1	4	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   41	72	85	android/database/sqlite/SQLiteException
    //   41	72	111	finally
    //   72	79	111	finally
    //   89	108	111	finally
    //   122	128	111	finally
    //   41	72	118	java/lang/RuntimeException
    //   72	79	131	java/lang/RuntimeException
    //   72	79	136	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public int ai(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: new 494	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1271
    //   14: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   27: iconst_m1
    //   28: istore 5
    //   30: new 134	com/mobisystems/mobiscanner/model/d
    //   33: dup
    //   34: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   37: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   43: astore 8
    //   45: aconst_null
    //   46: astore 6
    //   48: aload 6
    //   50: astore 7
    //   52: aload_0
    //   53: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   56: aload 6
    //   58: astore 7
    //   60: aload_0
    //   61: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   64: astore 9
    //   66: aload 6
    //   68: astore 7
    //   70: aload 8
    //   72: ldc_w 1273
    //   75: iconst_1
    //   76: anewarray 160	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: aload 9
    //   88: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   91: astore 6
    //   93: aload 6
    //   95: ifnull +91 -> 186
    //   98: aload 6
    //   100: astore 7
    //   102: iload 5
    //   104: istore_3
    //   105: iload 5
    //   107: istore 4
    //   109: aload 6
    //   111: invokeinterface 200 1 0
    //   116: ifeq +70 -> 186
    //   119: aload 6
    //   121: astore 7
    //   123: iload 5
    //   125: istore_3
    //   126: iload 5
    //   128: istore 4
    //   130: aload 6
    //   132: iconst_0
    //   133: invokeinterface 96 2 0
    //   138: istore 5
    //   140: aload 6
    //   142: astore 7
    //   144: iload 5
    //   146: istore_3
    //   147: iload 5
    //   149: istore 4
    //   151: aload_0
    //   152: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   155: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   158: iload 5
    //   160: istore_3
    //   161: aload_0
    //   162: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   165: iload_3
    //   166: istore 4
    //   168: aload 6
    //   170: ifnull +13 -> 183
    //   173: aload 6
    //   175: invokeinterface 99 1 0
    //   180: iload_3
    //   181: istore 4
    //   183: iload 4
    //   185: ireturn
    //   186: aload 6
    //   188: astore 7
    //   190: iload 5
    //   192: istore_3
    //   193: iload 5
    //   195: istore 4
    //   197: aload_0
    //   198: getstatic 1276	com/mobisystems/mobiscanner/common/OperationStatus:awb	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   201: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   204: iconst_m1
    //   205: istore_3
    //   206: goto -45 -> 161
    //   209: astore 8
    //   211: iconst_m1
    //   212: istore_3
    //   213: aconst_null
    //   214: astore 6
    //   216: aload 6
    //   218: astore 7
    //   220: aload_0
    //   221: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   224: ldc_w 587
    //   227: aload 8
    //   229: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload 6
    //   234: astore 7
    //   236: aload_0
    //   237: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   240: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   243: aload_0
    //   244: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   247: iload_3
    //   248: istore 4
    //   250: aload 6
    //   252: ifnull -69 -> 183
    //   255: aload 6
    //   257: invokeinterface 99 1 0
    //   262: iload_3
    //   263: ireturn
    //   264: astore 8
    //   266: iconst_m1
    //   267: istore_3
    //   268: aconst_null
    //   269: astore 6
    //   271: aload 6
    //   273: astore 7
    //   275: aload_0
    //   276: aload 8
    //   278: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   281: aload_0
    //   282: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   285: iload_3
    //   286: istore 4
    //   288: aload 6
    //   290: ifnull -107 -> 183
    //   293: goto -38 -> 255
    //   296: astore 6
    //   298: aload_0
    //   299: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   302: aload 7
    //   304: ifnull +10 -> 314
    //   307: aload 7
    //   309: invokeinterface 99 1 0
    //   314: aload 6
    //   316: athrow
    //   317: astore 6
    //   319: goto -21 -> 298
    //   322: astore 8
    //   324: goto -53 -> 271
    //   327: astore 8
    //   329: iload 4
    //   331: istore_3
    //   332: goto -116 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	DocumentModel
    //   0	335	1	paramLong	long
    //   104	228	3	i	int
    //   107	223	4	j	int
    //   28	166	5	k	int
    //   46	243	6	localCursor1	Cursor
    //   296	19	6	localObject1	Object
    //   317	1	6	localObject2	Object
    //   50	258	7	localCursor2	Cursor
    //   43	28	8	locald	d
    //   209	19	8	localSQLiteException1	SQLiteException
    //   264	13	8	localRuntimeException1	RuntimeException
    //   322	1	8	localRuntimeException2	RuntimeException
    //   327	1	8	localSQLiteException2	SQLiteException
    //   64	23	9	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   52	56	209	android/database/sqlite/SQLiteException
    //   60	66	209	android/database/sqlite/SQLiteException
    //   70	93	209	android/database/sqlite/SQLiteException
    //   52	56	264	java/lang/RuntimeException
    //   60	66	264	java/lang/RuntimeException
    //   70	93	264	java/lang/RuntimeException
    //   52	56	296	finally
    //   60	66	296	finally
    //   70	93	296	finally
    //   109	119	296	finally
    //   130	140	296	finally
    //   151	158	296	finally
    //   197	204	296	finally
    //   220	232	317	finally
    //   236	243	317	finally
    //   275	281	317	finally
    //   109	119	322	java/lang/RuntimeException
    //   130	140	322	java/lang/RuntimeException
    //   151	158	322	java/lang/RuntimeException
    //   197	204	322	java/lang/RuntimeException
    //   109	119	327	android/database/sqlite/SQLiteException
    //   130	140	327	android/database/sqlite/SQLiteException
    //   151	158	327	android/database/sqlite/SQLiteException
    //   197	204	327	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public c aj(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   12: new 494	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1278
    //   22: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   35: new 134	com/mobisystems/mobiscanner/model/d
    //   38: dup
    //   39: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   42: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   48: astore 6
    //   50: aload_0
    //   51: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   54: aload_0
    //   55: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   58: astore 7
    //   60: aload 6
    //   62: ldc_w 1280
    //   65: iconst_1
    //   66: anewarray 160	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: lload_1
    //   72: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: aload 7
    //   78: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   81: astore 6
    //   83: aload 6
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +175 -> 262
    //   90: aload_3
    //   91: invokeinterface 200 1 0
    //   96: ifeq +166 -> 262
    //   99: aload_3
    //   100: aload_3
    //   101: ldc_w 902
    //   104: invokeinterface 92 2 0
    //   109: invokeinterface 210 2 0
    //   114: lstore_1
    //   115: aload_0
    //   116: lload_1
    //   117: invokevirtual 1037	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   120: astore 4
    //   122: aload 4
    //   124: ifnonnull +94 -> 218
    //   127: new 217	java/io/IOException
    //   130: dup
    //   131: new 494	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 1039
    //   141: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: lload_1
    //   145: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 508	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   154: athrow
    //   155: astore 6
    //   157: aconst_null
    //   158: astore 4
    //   160: aload_3
    //   161: astore 5
    //   163: aload 4
    //   165: astore_3
    //   166: aload 5
    //   168: astore 4
    //   170: aload_0
    //   171: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   174: ldc_w 1282
    //   177: aload 6
    //   179: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload 5
    //   184: astore 4
    //   186: aload_0
    //   187: getstatic 486	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   190: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   193: aload_0
    //   194: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   197: aload_3
    //   198: astore 4
    //   200: aload 5
    //   202: ifnull +13 -> 215
    //   205: aload 5
    //   207: invokeinterface 99 1 0
    //   212: aload_3
    //   213: astore 4
    //   215: aload 4
    //   217: areturn
    //   218: new 219	com/mobisystems/mobiscanner/model/c
    //   221: dup
    //   222: aload 4
    //   224: aload_3
    //   225: invokespecial 1285	com/mobisystems/mobiscanner/model/c:<init>	(Lcom/mobisystems/mobiscanner/model/b;Landroid/database/Cursor;)V
    //   228: astore 4
    //   230: aload_0
    //   231: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   234: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   237: aload 4
    //   239: astore 5
    //   241: aload_0
    //   242: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   245: aload 5
    //   247: astore 4
    //   249: aload_3
    //   250: ifnull -35 -> 215
    //   253: aload_3
    //   254: invokeinterface 99 1 0
    //   259: aload 5
    //   261: areturn
    //   262: aload_0
    //   263: getstatic 1288	com/mobisystems/mobiscanner/common/OperationStatus:awc	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   266: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   269: aconst_null
    //   270: astore 5
    //   272: goto -31 -> 241
    //   275: astore 6
    //   277: aconst_null
    //   278: astore 4
    //   280: aload_3
    //   281: astore 5
    //   283: aload 4
    //   285: astore_3
    //   286: aload 5
    //   288: astore 4
    //   290: aload_0
    //   291: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   294: ldc_w 1282
    //   297: aload 6
    //   299: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload 5
    //   304: astore 4
    //   306: aload_0
    //   307: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   310: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   313: aload_0
    //   314: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   317: aload_3
    //   318: astore 4
    //   320: aload 5
    //   322: ifnull -107 -> 215
    //   325: goto -120 -> 205
    //   328: astore 6
    //   330: aconst_null
    //   331: astore_3
    //   332: aload 4
    //   334: astore 5
    //   336: aload 5
    //   338: astore 4
    //   340: aload_0
    //   341: aload 6
    //   343: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   346: aload_0
    //   347: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   350: aload_3
    //   351: astore 4
    //   353: aload 5
    //   355: ifnull -140 -> 215
    //   358: goto -153 -> 205
    //   361: astore 4
    //   363: aconst_null
    //   364: astore_3
    //   365: aload_0
    //   366: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   369: aload_3
    //   370: ifnull +9 -> 379
    //   373: aload_3
    //   374: invokeinterface 99 1 0
    //   379: aload 4
    //   381: athrow
    //   382: astore 4
    //   384: goto -19 -> 365
    //   387: astore 5
    //   389: aload 4
    //   391: astore_3
    //   392: aload 5
    //   394: astore 4
    //   396: goto -31 -> 365
    //   399: astore 6
    //   401: aconst_null
    //   402: astore 4
    //   404: aload_3
    //   405: astore 5
    //   407: aload 4
    //   409: astore_3
    //   410: goto -74 -> 336
    //   413: astore 6
    //   415: aload_3
    //   416: astore 5
    //   418: aload 4
    //   420: astore_3
    //   421: goto -85 -> 336
    //   424: astore 6
    //   426: aconst_null
    //   427: astore 4
    //   429: aload_3
    //   430: astore 5
    //   432: aload 4
    //   434: astore_3
    //   435: goto -149 -> 286
    //   438: astore 6
    //   440: aload_3
    //   441: astore 5
    //   443: aload 4
    //   445: astore_3
    //   446: goto -160 -> 286
    //   449: astore 6
    //   451: aconst_null
    //   452: astore_3
    //   453: goto -287 -> 166
    //   456: astore 6
    //   458: aload_3
    //   459: astore 5
    //   461: aload 4
    //   463: astore_3
    //   464: goto -298 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	DocumentModel
    //   0	467	1	paramLong	long
    //   1	463	3	localObject1	Object
    //   3	349	4	localObject2	Object
    //   361	19	4	localObject3	Object
    //   382	8	4	localObject4	Object
    //   394	68	4	localObject5	Object
    //   6	348	5	localObject6	Object
    //   387	6	5	localObject7	Object
    //   405	55	5	localObject8	Object
    //   48	36	6	localObject9	Object
    //   155	23	6	localIOException1	IOException
    //   275	23	6	localSQLiteException1	SQLiteException
    //   328	14	6	localRuntimeException1	RuntimeException
    //   399	1	6	localRuntimeException2	RuntimeException
    //   413	1	6	localRuntimeException3	RuntimeException
    //   424	1	6	localSQLiteException2	SQLiteException
    //   438	1	6	localSQLiteException3	SQLiteException
    //   449	1	6	localIOException2	IOException
    //   456	1	6	localIOException3	IOException
    //   58	19	7	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   90	122	155	java/io/IOException
    //   127	155	155	java/io/IOException
    //   218	230	155	java/io/IOException
    //   262	269	155	java/io/IOException
    //   50	83	275	android/database/sqlite/SQLiteException
    //   50	83	328	java/lang/RuntimeException
    //   50	83	361	finally
    //   90	122	382	finally
    //   127	155	382	finally
    //   218	230	382	finally
    //   230	237	382	finally
    //   262	269	382	finally
    //   170	182	387	finally
    //   186	193	387	finally
    //   290	302	387	finally
    //   306	313	387	finally
    //   340	346	387	finally
    //   90	122	399	java/lang/RuntimeException
    //   127	155	399	java/lang/RuntimeException
    //   218	230	399	java/lang/RuntimeException
    //   262	269	399	java/lang/RuntimeException
    //   230	237	413	java/lang/RuntimeException
    //   90	122	424	android/database/sqlite/SQLiteException
    //   127	155	424	android/database/sqlite/SQLiteException
    //   218	230	424	android/database/sqlite/SQLiteException
    //   262	269	424	android/database/sqlite/SQLiteException
    //   230	237	438	android/database/sqlite/SQLiteException
    //   50	83	449	java/io/IOException
    //   230	237	456	java/io/IOException
  }
  
  /* Error */
  public boolean ak(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: new 494	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 1291
    //   14: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload_1
    //   18: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   27: iconst_0
    //   28: istore 9
    //   30: new 134	com/mobisystems/mobiscanner/model/d
    //   33: dup
    //   34: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   37: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   43: astore 19
    //   45: aload 19
    //   47: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   50: iconst_1
    //   51: anewarray 160	java/lang/String
    //   54: astore 16
    //   56: aload 16
    //   58: iconst_0
    //   59: lload_1
    //   60: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   63: aastore
    //   64: aload 19
    //   66: ldc_w 1293
    //   69: aload 16
    //   71: aconst_null
    //   72: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   75: astore 14
    //   77: aload 14
    //   79: ifnull +13 -> 92
    //   82: aload 14
    //   84: invokeinterface 200 1 0
    //   89: ifne +109 -> 198
    //   92: new 130	android/database/sqlite/SQLiteException
    //   95: dup
    //   96: ldc_w 545
    //   99: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore 18
    //   105: aconst_null
    //   106: astore 15
    //   108: iconst_0
    //   109: istore 9
    //   111: iload 9
    //   113: istore 10
    //   115: aload 15
    //   117: astore 17
    //   119: aload 14
    //   121: astore 16
    //   123: aload_0
    //   124: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   127: ldc_w 1295
    //   130: aload 18
    //   132: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: iload 9
    //   137: istore 10
    //   139: aload 15
    //   141: astore 17
    //   143: aload 14
    //   145: astore 16
    //   147: aload_0
    //   148: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   151: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   154: aload 19
    //   156: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   159: aload 15
    //   161: ifnull +14 -> 175
    //   164: iload 9
    //   166: ifeq +379 -> 545
    //   169: aload_0
    //   170: aload 15
    //   172: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   175: iload 9
    //   177: istore 10
    //   179: aload 14
    //   181: ifnull +14 -> 195
    //   184: aload 14
    //   186: invokeinterface 99 1 0
    //   191: iload 9
    //   193: istore 10
    //   195: iload 10
    //   197: ireturn
    //   198: aload 14
    //   200: iconst_0
    //   201: invokeinterface 210 2 0
    //   206: lstore 5
    //   208: aload 14
    //   210: iconst_1
    //   211: invokeinterface 96 2 0
    //   216: istore_3
    //   217: aload 14
    //   219: iconst_2
    //   220: invokeinterface 210 2 0
    //   225: lstore 7
    //   227: iload_3
    //   228: iconst_1
    //   229: iadd
    //   230: istore_3
    //   231: aload_0
    //   232: lload 5
    //   234: invokevirtual 227	com/mobisystems/mobiscanner/model/DocumentModel:ai	(J)I
    //   237: istore 4
    //   239: iconst_1
    //   240: newarray <illegal type>
    //   242: astore 15
    //   244: aload 15
    //   246: iconst_0
    //   247: lload_1
    //   248: lastore
    //   249: aload_0
    //   250: aload 15
    //   252: invokespecial 1251	com/mobisystems/mobiscanner/model/DocumentModel:c	([J)V
    //   255: aload 19
    //   257: ldc_w 1297
    //   260: aload 16
    //   262: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   265: pop
    //   266: iload_3
    //   267: iload 4
    //   269: if_icmpgt +39 -> 308
    //   272: aload 19
    //   274: ldc_w 1011
    //   277: iconst_3
    //   278: anewarray 160	java/lang/String
    //   281: dup
    //   282: iconst_0
    //   283: lload 5
    //   285: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   288: aastore
    //   289: dup
    //   290: iconst_1
    //   291: iload_3
    //   292: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: aastore
    //   296: dup
    //   297: iconst_2
    //   298: iload 4
    //   300: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   303: aastore
    //   304: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   307: pop
    //   308: lload_1
    //   309: lload 7
    //   311: lcmp
    //   312: ifne +24 -> 336
    //   315: aload 19
    //   317: ldc_w 1043
    //   320: iconst_1
    //   321: anewarray 160	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: lload 5
    //   328: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   331: aastore
    //   332: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   335: pop
    //   336: aload_0
    //   337: lload 5
    //   339: invokespecial 565	com/mobisystems/mobiscanner/model/DocumentModel:aD	(J)V
    //   342: aload 19
    //   344: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   347: iconst_1
    //   348: istore 9
    //   350: iconst_1
    //   351: istore 12
    //   353: iconst_1
    //   354: istore 13
    //   356: iconst_1
    //   357: istore 10
    //   359: iconst_1
    //   360: istore 11
    //   362: aload 15
    //   364: astore 17
    //   366: aload 14
    //   368: astore 16
    //   370: aload_0
    //   371: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   374: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   377: aload 19
    //   379: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   382: aload 15
    //   384: ifnull +9 -> 393
    //   387: aload_0
    //   388: aload 15
    //   390: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   393: iload 12
    //   395: istore 10
    //   397: aload 14
    //   399: ifnull -204 -> 195
    //   402: goto -218 -> 184
    //   405: astore 18
    //   407: aconst_null
    //   408: astore 14
    //   410: aconst_null
    //   411: astore 15
    //   413: iconst_0
    //   414: istore 9
    //   416: iload 9
    //   418: istore 10
    //   420: aload 15
    //   422: astore 17
    //   424: aload 14
    //   426: astore 16
    //   428: aload_0
    //   429: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   432: ldc_w 1299
    //   435: aload 18
    //   437: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   440: iload 9
    //   442: istore 10
    //   444: aload 15
    //   446: astore 17
    //   448: aload 14
    //   450: astore 16
    //   452: aload_0
    //   453: getstatic 486	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   456: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   459: aload 19
    //   461: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   464: aload 15
    //   466: ifnull +14 -> 480
    //   469: iload 9
    //   471: ifeq +83 -> 554
    //   474: aload_0
    //   475: aload 15
    //   477: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   480: iload 9
    //   482: istore 10
    //   484: aload 14
    //   486: ifnull -291 -> 195
    //   489: goto -305 -> 184
    //   492: astore 18
    //   494: aconst_null
    //   495: astore 14
    //   497: aconst_null
    //   498: astore 15
    //   500: aload 19
    //   502: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   505: aload 15
    //   507: ifnull +14 -> 521
    //   510: iload 9
    //   512: ifeq +24 -> 536
    //   515: aload_0
    //   516: aload 15
    //   518: invokespecial 1257	com/mobisystems/mobiscanner/model/DocumentModel:e	([J)V
    //   521: aload 14
    //   523: ifnull +10 -> 533
    //   526: aload 14
    //   528: invokeinterface 99 1 0
    //   533: aload 18
    //   535: athrow
    //   536: aload_0
    //   537: aload 15
    //   539: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   542: goto -21 -> 521
    //   545: aload_0
    //   546: aload 15
    //   548: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   551: goto -376 -> 175
    //   554: aload_0
    //   555: aload 15
    //   557: invokespecial 1261	com/mobisystems/mobiscanner/model/DocumentModel:d	([J)V
    //   560: goto -80 -> 480
    //   563: astore 18
    //   565: aconst_null
    //   566: astore 15
    //   568: goto -68 -> 500
    //   571: astore 18
    //   573: goto -73 -> 500
    //   576: astore 18
    //   578: iload 10
    //   580: istore 9
    //   582: aload 17
    //   584: astore 15
    //   586: aload 16
    //   588: astore 14
    //   590: goto -90 -> 500
    //   593: astore 18
    //   595: aconst_null
    //   596: astore 15
    //   598: iconst_0
    //   599: istore 9
    //   601: goto -185 -> 416
    //   604: astore 18
    //   606: iconst_0
    //   607: istore 9
    //   609: goto -193 -> 416
    //   612: astore 18
    //   614: iload 13
    //   616: istore 9
    //   618: goto -202 -> 416
    //   621: astore 18
    //   623: aconst_null
    //   624: astore 14
    //   626: aconst_null
    //   627: astore 15
    //   629: iconst_0
    //   630: istore 9
    //   632: goto -521 -> 111
    //   635: astore 18
    //   637: iconst_0
    //   638: istore 9
    //   640: goto -529 -> 111
    //   643: astore 18
    //   645: iload 11
    //   647: istore 9
    //   649: goto -538 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	DocumentModel
    //   0	652	1	paramLong	long
    //   216	76	3	i	int
    //   237	62	4	j	int
    //   206	132	5	l1	long
    //   225	85	7	l2	long
    //   28	620	9	bool1	boolean
    //   113	466	10	bool2	boolean
    //   360	286	11	bool3	boolean
    //   351	43	12	bool4	boolean
    //   354	261	13	bool5	boolean
    //   75	550	14	localObject1	Object
    //   106	522	15	localObject2	Object
    //   54	533	16	localObject3	Object
    //   117	466	17	localObject4	Object
    //   103	28	18	localSQLiteException1	SQLiteException
    //   405	31	18	localIOException1	IOException
    //   492	42	18	localObject5	Object
    //   563	1	18	localObject6	Object
    //   571	1	18	localObject7	Object
    //   576	1	18	localObject8	Object
    //   593	1	18	localIOException2	IOException
    //   604	1	18	localIOException3	IOException
    //   612	1	18	localIOException4	IOException
    //   621	1	18	localSQLiteException2	SQLiteException
    //   635	1	18	localSQLiteException3	SQLiteException
    //   643	1	18	localSQLiteException4	SQLiteException
    //   43	458	19	locald	d
    // Exception table:
    //   from	to	target	type
    //   82	92	103	android/database/sqlite/SQLiteException
    //   92	103	103	android/database/sqlite/SQLiteException
    //   198	227	103	android/database/sqlite/SQLiteException
    //   231	244	103	android/database/sqlite/SQLiteException
    //   45	77	405	java/io/IOException
    //   45	77	492	finally
    //   82	92	563	finally
    //   92	103	563	finally
    //   198	227	563	finally
    //   231	244	563	finally
    //   249	266	571	finally
    //   272	308	571	finally
    //   315	336	571	finally
    //   336	347	571	finally
    //   123	135	576	finally
    //   147	154	576	finally
    //   370	377	576	finally
    //   428	440	576	finally
    //   452	459	576	finally
    //   82	92	593	java/io/IOException
    //   92	103	593	java/io/IOException
    //   198	227	593	java/io/IOException
    //   231	244	593	java/io/IOException
    //   249	266	604	java/io/IOException
    //   272	308	604	java/io/IOException
    //   315	336	604	java/io/IOException
    //   336	347	604	java/io/IOException
    //   370	377	612	java/io/IOException
    //   45	77	621	android/database/sqlite/SQLiteException
    //   249	266	635	android/database/sqlite/SQLiteException
    //   272	308	635	android/database/sqlite/SQLiteException
    //   315	336	635	android/database/sqlite/SQLiteException
    //   336	347	635	android/database/sqlite/SQLiteException
    //   370	377	643	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean al(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 9
    //   6: iconst_1
    //   7: istore 8
    //   9: aload_0
    //   10: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   13: new 494	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1301
    //   23: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_1
    //   27: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   36: new 134	com/mobisystems/mobiscanner/model/d
    //   39: dup
    //   40: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   43: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   49: astore 13
    //   51: aload 13
    //   53: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   56: aload 13
    //   58: ldc_w 543
    //   61: iconst_1
    //   62: anewarray 160	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: aastore
    //   72: aconst_null
    //   73: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   76: astore 10
    //   78: aload 10
    //   80: ifnull +17 -> 97
    //   83: aload 10
    //   85: astore 11
    //   87: aload 10
    //   89: invokeinterface 200 1 0
    //   94: ifne +78 -> 172
    //   97: aload 10
    //   99: astore 11
    //   101: new 130	android/database/sqlite/SQLiteException
    //   104: dup
    //   105: ldc_w 545
    //   108: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    //   112: astore 12
    //   114: iconst_0
    //   115: istore 7
    //   117: aload 10
    //   119: astore 11
    //   121: aload_0
    //   122: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   125: ldc_w 1061
    //   128: aload 12
    //   130: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload 10
    //   135: astore 11
    //   137: aload_0
    //   138: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   141: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   144: aload 13
    //   146: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   149: iload 7
    //   151: istore 8
    //   153: aload 10
    //   155: ifnull +14 -> 169
    //   158: aload 10
    //   160: invokeinterface 99 1 0
    //   165: iload 7
    //   167: istore 8
    //   169: iload 8
    //   171: ireturn
    //   172: aload 10
    //   174: astore 11
    //   176: aload 10
    //   178: iconst_0
    //   179: invokeinterface 210 2 0
    //   184: lstore_3
    //   185: aload 10
    //   187: astore 11
    //   189: aload 10
    //   191: iconst_1
    //   192: invokeinterface 210 2 0
    //   197: lstore 5
    //   199: aload 10
    //   201: astore 11
    //   203: aload 13
    //   205: ldc_w 1303
    //   208: iconst_2
    //   209: anewarray 160	java/lang/String
    //   212: dup
    //   213: iconst_0
    //   214: getstatic 555	com/mobisystems/mobiscanner/image/ImageOrientation:aHV	Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   217: invokevirtual 346	com/mobisystems/mobiscanner/image/ImageOrientation:Dp	()I
    //   220: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: lload_1
    //   227: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   230: aastore
    //   231: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   234: pop
    //   235: aload 10
    //   237: astore 11
    //   239: aload_0
    //   240: lload_3
    //   241: invokespecial 565	com/mobisystems/mobiscanner/model/DocumentModel:aD	(J)V
    //   244: aload 10
    //   246: astore 11
    //   248: aload 13
    //   250: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   253: aload 10
    //   255: astore 11
    //   257: aload_0
    //   258: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   261: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   264: aload 10
    //   266: astore 11
    //   268: aload_0
    //   269: lload 5
    //   271: invokespecial 568	com/mobisystems/mobiscanner/model/DocumentModel:am	(J)Z
    //   274: pop
    //   275: aload 13
    //   277: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   280: iload 9
    //   282: istore 8
    //   284: aload 10
    //   286: ifnull -117 -> 169
    //   289: goto -131 -> 158
    //   292: astore 10
    //   294: aconst_null
    //   295: astore 11
    //   297: aload 13
    //   299: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   302: aload 11
    //   304: ifnull +10 -> 314
    //   307: aload 11
    //   309: invokeinterface 99 1 0
    //   314: aload 10
    //   316: athrow
    //   317: astore 10
    //   319: goto -22 -> 297
    //   322: astore 12
    //   324: aconst_null
    //   325: astore 10
    //   327: iconst_0
    //   328: istore 7
    //   330: goto -213 -> 117
    //   333: astore 12
    //   335: iload 8
    //   337: istore 7
    //   339: goto -222 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	DocumentModel
    //   0	342	1	paramLong	long
    //   184	57	3	l1	long
    //   197	73	5	l2	long
    //   1	337	7	bool1	boolean
    //   7	329	8	bool2	boolean
    //   4	277	9	bool3	boolean
    //   76	209	10	localCursor1	Cursor
    //   292	23	10	localObject1	Object
    //   317	1	10	localObject2	Object
    //   325	1	10	localObject3	Object
    //   85	223	11	localCursor2	Cursor
    //   112	17	12	localSQLiteException1	SQLiteException
    //   322	1	12	localSQLiteException2	SQLiteException
    //   333	1	12	localSQLiteException3	SQLiteException
    //   49	249	13	locald	d
    // Exception table:
    //   from	to	target	type
    //   87	97	112	android/database/sqlite/SQLiteException
    //   101	112	112	android/database/sqlite/SQLiteException
    //   176	185	112	android/database/sqlite/SQLiteException
    //   189	199	112	android/database/sqlite/SQLiteException
    //   203	235	112	android/database/sqlite/SQLiteException
    //   239	244	112	android/database/sqlite/SQLiteException
    //   248	253	112	android/database/sqlite/SQLiteException
    //   51	78	292	finally
    //   87	97	317	finally
    //   101	112	317	finally
    //   121	133	317	finally
    //   137	144	317	finally
    //   176	185	317	finally
    //   189	199	317	finally
    //   203	235	317	finally
    //   239	244	317	finally
    //   248	253	317	finally
    //   257	264	317	finally
    //   268	275	317	finally
    //   51	78	322	android/database/sqlite/SQLiteException
    //   257	264	333	android/database/sqlite/SQLiteException
    //   268	275	333	android/database/sqlite/SQLiteException
  }
  
  public Image ao(long paramLong)
  {
    this.mLog.dl("getProcessedImage called, pageId=" + paramLong);
    try
    {
      localObject1 = au(paramLong);
      if (localObject1 == null) {
        break label147;
      }
      localObject1 = new Image((File)localObject1);
    }
    catch (Image.ImageException localImageException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        this.mLog.g("Image Exception getting processed image", localImageException);
        this.aII = OperationStatus.awg;
        Object localObject2 = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.mLog.g("IO Exception getting processed image", localIOException);
        this.aII = OperationStatus.awe;
        Object localObject3 = null;
      }
    }
    localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = ap(paramLong);
    }
    if (localObject4 != null)
    {
      localObject1 = aj(paramLong);
      if ((localObject1 != null) && (((c)localObject1).Jb() != ImageOrientation.aHV)) {
        ((Image)localObject4).b(((c)localObject1).Jb());
      }
      this.aII = OperationStatus.avC;
    }
    return (Image)localObject4;
  }
  
  public Image ap(long paramLong)
  {
    this.mLog.dl("getRawImage called, pageId=" + paramLong);
    try
    {
      Image localImage = new Image(as(paramLong));
      return localImage;
    }
    catch (Image.ImageException localImageException)
    {
      this.mLog.g("Image Exception getting raw image", localImageException);
      this.aII = OperationStatus.awg;
      return null;
    }
    catch (IOException localIOException)
    {
      this.mLog.g("IO Exception getting raw image", localIOException);
      this.aII = OperationStatus.awe;
    }
    return null;
  }
  
  public Image aq(long paramLong)
  {
    this.mLog.dl("getCroppedImage called, pageId=" + paramLong);
    try
    {
      localObject1 = aw(paramLong);
      if (localObject1 == null) {
        break label147;
      }
      localObject1 = new Image((File)localObject1);
    }
    catch (Image.ImageException localImageException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        this.mLog.g("Image Exception getting cropped image", localImageException);
        this.aII = OperationStatus.awg;
        Object localObject2 = null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.mLog.g("IO Exception getting cropped image", localIOException);
        this.aII = OperationStatus.awe;
        Object localObject3 = null;
      }
    }
    localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = ao(paramLong);
    }
    if (localObject4 != null)
    {
      localObject1 = aj(paramLong);
      if ((localObject1 != null) && (((c)localObject1).Jb() != ImageOrientation.aHV)) {
        ((Image)localObject4).b(((c)localObject1).Jb());
      }
      this.aII = OperationStatus.avC;
    }
    return (Image)localObject4;
  }
  
  public boolean ar(long paramLong)
  {
    this.mLog.dl("updateDocAccessTime called, docId=" + paramLong);
    d locald = new d(aIF.getWritableDatabase());
    try
    {
      locald.beginTransaction();
      locald.b("UPDATE documents SET last_access_time = strftime('%s', 'now'), accessed_flag = 1 WHERE id = ?;", new String[] { String.valueOf(paramLong) });
      locald.setTransactionSuccessful();
      this.aII = OperationStatus.avC;
      return true;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.mLog.g("SQL Exception updating document access time", localSQLiteException);
      this.aII = OperationStatus.awd;
      return false;
    }
    finally
    {
      locald.endTransaction();
    }
  }
  
  public long b(long paramLong1, long paramLong2, int paramInt)
  {
    this.mLog.dl("copyPage called, pageId=" + paramLong1 + ", docId=" + paramLong2 + ", to idx " + paramInt);
    d locald = new d(aIF.getWritableDatabase());
    for (;;)
    {
      c localc;
      try
      {
        locald.beginTransaction();
        long l = paramLong2;
        if (paramLong2 < 0L) {
          l = f(new b());
        }
        b localb1 = ae(l);
        if (localb1 == null) {
          throw new IOException("Error reading document " + l);
        }
      }
      catch (IOException localIOException1)
      {
        paramLong1 = -1L;
        this.mLog.g("IO Exception copying page", localIOException1);
        this.aII = OperationStatus.awe;
        return paramLong1;
        localc = aj(paramLong1);
        if (localc == null) {
          throw new IOException("Error reading page " + paramLong1);
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        paramLong1 = -1L;
        this.mLog.g("SQL Exception copying page", localSQLiteException1);
        this.aII = OperationStatus.awd;
        continue;
      }
      finally
      {
        locald.endTransaction();
      }
      paramLong1 = a(localc, localb2, paramInt);
      locald.setTransactionSuccessful();
      try
      {
        this.aII = OperationStatus.avC;
      }
      catch (IOException localIOException2) {}catch (SQLiteException localSQLiteException2) {}
    }
  }
  
  /* Error */
  public Cursor b(String paramString, DocListSortBy paramDocListSortBy, SortOrder paramSortOrder, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 1347	android/database/MatrixCursor
    //   3: dup
    //   4: bipush 6
    //   6: anewarray 160	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 904
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: ldc_w 1349
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: ldc_w 1351
    //   26: aastore
    //   27: dup
    //   28: iconst_3
    //   29: ldc_w 1353
    //   32: aastore
    //   33: dup
    //   34: iconst_4
    //   35: ldc_w 1355
    //   38: aastore
    //   39: dup
    //   40: iconst_5
    //   41: ldc 88
    //   43: aastore
    //   44: invokespecial 1358	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   47: astore 12
    //   49: new 134	com/mobisystems/mobiscanner/model/d
    //   52: dup
    //   53: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   56: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   62: astore 13
    //   64: aload_0
    //   65: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   68: ldc_w 1360
    //   71: astore 11
    //   73: new 494	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 850
    //   83: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 850
    //   93: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 9
    //   101: aload_1
    //   102: ifnull +1018 -> 1120
    //   105: aload_1
    //   106: invokevirtual 853	java/lang/String:length	()I
    //   109: ifle +1011 -> 1120
    //   112: ldc_w 1362
    //   115: astore 8
    //   117: iconst_1
    //   118: anewarray 160	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: aload 9
    //   125: aastore
    //   126: astore 10
    //   128: aload 8
    //   130: astore 9
    //   132: iload 4
    //   134: ifle +69 -> 203
    //   137: aload 8
    //   139: astore 9
    //   141: aload 8
    //   143: invokevirtual 853	java/lang/String:length	()I
    //   146: ifle +26 -> 172
    //   149: new 494	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   156: aload 8
    //   158: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 857
    //   164: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 9
    //   172: new 494	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   179: aload 9
    //   181: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 859
    //   187: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 4
    //   192: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   195: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 9
    //   203: aload 9
    //   205: astore 8
    //   207: aload 9
    //   209: invokevirtual 853	java/lang/String:length	()I
    //   212: ifle +26 -> 238
    //   215: new 494	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   222: aload 9
    //   224: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 857
    //   230: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 8
    //   238: new 494	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   245: aload 8
    //   247: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 861
    //   253: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 9
    //   261: aload 11
    //   263: astore 8
    //   265: aload 9
    //   267: invokevirtual 853	java/lang/String:length	()I
    //   270: ifle +32 -> 302
    //   273: new 494	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   280: ldc_w 1360
    //   283: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 863
    //   289: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload 9
    //   294: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore 8
    //   302: new 494	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   309: aload 8
    //   311: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 865
    //   317: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 868	com/mobisystems/mobiscanner/model/DocumentModel$DocListSortBy:Iz	()Ljava/lang/String;
    //   324: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 870
    //   330: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_3
    //   334: invokevirtual 871	com/mobisystems/mobiscanner/model/DocumentModel$SortOrder:Iz	()Ljava/lang/String;
    //   337: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore_2
    //   344: new 494	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   351: aload_2
    //   352: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: ldc_w 873
    //   358: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: iload 5
    //   363: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   366: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore_2
    //   373: aload 13
    //   375: new 494	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   382: aload_2
    //   383: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc_w 1364
    //   389: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: aload 10
    //   397: aload_0
    //   398: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   401: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   404: astore_3
    //   405: aconst_null
    //   406: astore_2
    //   407: aload_3
    //   408: ifnull +180 -> 588
    //   411: aload_3
    //   412: invokeinterface 787 1 0
    //   417: istore 5
    //   419: aload_3
    //   420: invokeinterface 200 1 0
    //   425: pop
    //   426: iload 5
    //   428: newarray <illegal type>
    //   430: astore_2
    //   431: iconst_0
    //   432: istore 4
    //   434: iload 4
    //   436: iload 5
    //   438: if_icmpge +144 -> 582
    //   441: aload_3
    //   442: iload 4
    //   444: invokeinterface 86 2 0
    //   449: pop
    //   450: aload_2
    //   451: iload 4
    //   453: aload_3
    //   454: aload_3
    //   455: ldc_w 904
    //   458: invokeinterface 92 2 0
    //   463: invokeinterface 96 2 0
    //   468: i2l
    //   469: lastore
    //   470: aload 12
    //   472: bipush 6
    //   474: anewarray 4	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_3
    //   480: aload_3
    //   481: ldc_w 904
    //   484: invokeinterface 92 2 0
    //   489: invokeinterface 96 2 0
    //   494: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: aload_3
    //   501: aload_3
    //   502: ldc_w 1371
    //   505: invokeinterface 92 2 0
    //   510: invokeinterface 909 2 0
    //   515: aastore
    //   516: dup
    //   517: iconst_2
    //   518: aconst_null
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: ldc_w 1372
    //   525: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: aastore
    //   529: dup
    //   530: iconst_4
    //   531: aload_3
    //   532: aload_3
    //   533: ldc_w 904
    //   536: invokeinterface 92 2 0
    //   541: invokeinterface 96 2 0
    //   546: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: dup
    //   551: iconst_5
    //   552: aload_3
    //   553: aload_3
    //   554: ldc 88
    //   556: invokeinterface 92 2 0
    //   561: invokeinterface 96 2 0
    //   566: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: aastore
    //   570: invokevirtual 1376	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   573: iload 4
    //   575: iconst_1
    //   576: iadd
    //   577: istore 4
    //   579: goto -145 -> 434
    //   582: aload_3
    //   583: invokeinterface 99 1 0
    //   588: aload_0
    //   589: aload_1
    //   590: aload_2
    //   591: aload 12
    //   593: invokevirtual 1378	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/String;[JLandroid/database/MatrixCursor;)Ljava/util/HashMap;
    //   596: astore 8
    //   598: aload 8
    //   600: ifnull +530 -> 1130
    //   603: aload 8
    //   605: invokevirtual 1381	java/util/HashMap:size	()I
    //   608: newarray <illegal type>
    //   610: astore_3
    //   611: aload 8
    //   613: invokevirtual 1385	java/util/HashMap:values	()Ljava/util/Collection;
    //   616: invokeinterface 1391 1 0
    //   621: astore 9
    //   623: iconst_0
    //   624: istore 4
    //   626: aload_3
    //   627: astore_2
    //   628: aload 9
    //   630: invokeinterface 1396 1 0
    //   635: ifeq +30 -> 665
    //   638: aload_3
    //   639: iload 4
    //   641: aload 9
    //   643: invokeinterface 1400 1 0
    //   648: checkcast 924	com/mobisystems/mobiscanner/controller/bi
    //   651: invokevirtual 1403	com/mobisystems/mobiscanner/controller/bi:HK	()J
    //   654: l2i
    //   655: iastore
    //   656: iload 4
    //   658: iconst_1
    //   659: iadd
    //   660: istore 4
    //   662: goto -36 -> 626
    //   665: new 494	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   672: astore_3
    //   673: aload_3
    //   674: ldc_w 1405
    //   677: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload_2
    //   682: ifnull +49 -> 731
    //   685: aload_2
    //   686: arraylength
    //   687: istore 5
    //   689: iconst_0
    //   690: istore 4
    //   692: iload 4
    //   694: iload 5
    //   696: if_icmpge +35 -> 731
    //   699: aload_3
    //   700: aload_2
    //   701: iload 4
    //   703: iaload
    //   704: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   707: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: iload 4
    //   713: iload 5
    //   715: iconst_1
    //   716: isub
    //   717: if_icmpge +418 -> 1135
    //   720: aload_3
    //   721: ldc_w 886
    //   724: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: goto +407 -> 1135
    //   731: aload_3
    //   732: ldc_w 1407
    //   735: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 13
    //   741: new 494	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   748: ldc_w 1409
    //   751: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_3
    //   755: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: aconst_null
    //   765: aload_0
    //   766: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   769: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   772: astore_2
    //   773: aload_2
    //   774: ifnull +294 -> 1068
    //   777: aload_2
    //   778: invokeinterface 787 1 0
    //   783: istore 5
    //   785: aload_2
    //   786: invokeinterface 200 1 0
    //   791: pop
    //   792: iconst_0
    //   793: istore 4
    //   795: iload 4
    //   797: iload 5
    //   799: if_icmpge +263 -> 1062
    //   802: aload_2
    //   803: iload 4
    //   805: invokeinterface 86 2 0
    //   810: pop
    //   811: aload_2
    //   812: aload_2
    //   813: ldc_w 904
    //   816: invokeinterface 92 2 0
    //   821: invokeinterface 96 2 0
    //   826: istore 6
    //   828: aload 8
    //   830: new 915	java/lang/Long
    //   833: dup
    //   834: iload 6
    //   836: i2l
    //   837: invokespecial 1411	java/lang/Long:<init>	(J)V
    //   840: invokevirtual 922	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   843: checkcast 924	com/mobisystems/mobiscanner/controller/bi
    //   846: astore 9
    //   848: new 494	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 1413
    //   858: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: aload 9
    //   863: invokevirtual 1416	com/mobisystems/mobiscanner/controller/bi:HN	()I
    //   866: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: ldc_w 1418
    //   872: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload_2
    //   876: aload_2
    //   877: ldc_w 1420
    //   880: invokeinterface 92 2 0
    //   885: invokeinterface 96 2 0
    //   890: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: ldc_w 1422
    //   896: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: astore_3
    //   903: aload 9
    //   905: invokevirtual 1425	com/mobisystems/mobiscanner/controller/bi:HM	()Ljava/lang/String;
    //   908: astore 9
    //   910: aload 9
    //   912: ldc_w 870
    //   915: aload 9
    //   917: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   920: aload_1
    //   921: invokevirtual 931	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   924: invokevirtual 1428	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   927: iconst_1
    //   928: isub
    //   929: invokevirtual 1432	java/lang/String:lastIndexOf	(Ljava/lang/String;I)I
    //   932: istore 7
    //   934: aload 9
    //   936: iload 7
    //   938: iconst_1
    //   939: iadd
    //   940: iload 7
    //   942: bipush 100
    //   944: iadd
    //   945: aload 9
    //   947: invokevirtual 853	java/lang/String:length	()I
    //   950: invokestatic 1438	java/lang/Math:min	(II)I
    //   953: invokevirtual 1442	java/lang/String:substring	(II)Ljava/lang/String;
    //   956: astore 9
    //   958: aload 12
    //   960: bipush 6
    //   962: anewarray 4	java/lang/Object
    //   965: dup
    //   966: iconst_0
    //   967: iload 6
    //   969: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   972: aastore
    //   973: dup
    //   974: iconst_1
    //   975: aload_2
    //   976: aload_2
    //   977: ldc_w 1371
    //   980: invokeinterface 92 2 0
    //   985: invokeinterface 909 2 0
    //   990: aastore
    //   991: dup
    //   992: iconst_2
    //   993: new 494	java/lang/StringBuilder
    //   996: dup
    //   997: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   1000: aload_3
    //   1001: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload 9
    //   1006: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_3
    //   1015: ldc_w 1443
    //   1018: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1021: aastore
    //   1022: dup
    //   1023: iconst_4
    //   1024: iload 6
    //   1026: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: aastore
    //   1030: dup
    //   1031: iconst_5
    //   1032: aload_2
    //   1033: aload_2
    //   1034: ldc 88
    //   1036: invokeinterface 92 2 0
    //   1041: invokeinterface 96 2 0
    //   1046: invokestatic 1369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: invokevirtual 1376	android/database/MatrixCursor:addRow	([Ljava/lang/Object;)V
    //   1053: iload 4
    //   1055: iconst_1
    //   1056: iadd
    //   1057: istore 4
    //   1059: goto -264 -> 795
    //   1062: aload_2
    //   1063: invokeinterface 99 1 0
    //   1068: aload_0
    //   1069: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1072: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1075: aload_0
    //   1076: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   1079: aload 12
    //   1081: areturn
    //   1082: astore_1
    //   1083: aload_0
    //   1084: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   1087: ldc_w 877
    //   1090: aload_1
    //   1091: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1094: aload_0
    //   1095: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1098: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   1101: goto -26 -> 1075
    //   1104: astore_1
    //   1105: aload_0
    //   1106: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   1109: aload_1
    //   1110: athrow
    //   1111: astore_1
    //   1112: aload_0
    //   1113: aload_1
    //   1114: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   1117: goto -42 -> 1075
    //   1120: ldc -27
    //   1122: astore 8
    //   1124: aconst_null
    //   1125: astore 10
    //   1127: goto -999 -> 128
    //   1130: aconst_null
    //   1131: astore_2
    //   1132: goto -467 -> 665
    //   1135: iload 4
    //   1137: iconst_1
    //   1138: iadd
    //   1139: istore 4
    //   1141: goto -449 -> 692
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1144	0	this	DocumentModel
    //   0	1144	1	paramString	String
    //   0	1144	2	paramDocListSortBy	DocListSortBy
    //   0	1144	3	paramSortOrder	SortOrder
    //   0	1144	4	paramInt1	int
    //   0	1144	5	paramInt2	int
    //   826	199	6	i	int
    //   932	13	7	j	int
    //   115	1008	8	localObject1	Object
    //   99	906	9	localObject2	Object
    //   126	1000	10	arrayOfString	String[]
    //   71	191	11	str	String
    //   47	1033	12	localMatrixCursor	android.database.MatrixCursor
    //   62	678	13	locald	d
    // Exception table:
    //   from	to	target	type
    //   64	68	1082	android/database/sqlite/SQLiteException
    //   73	101	1082	android/database/sqlite/SQLiteException
    //   105	112	1082	android/database/sqlite/SQLiteException
    //   117	128	1082	android/database/sqlite/SQLiteException
    //   141	172	1082	android/database/sqlite/SQLiteException
    //   172	203	1082	android/database/sqlite/SQLiteException
    //   207	238	1082	android/database/sqlite/SQLiteException
    //   238	261	1082	android/database/sqlite/SQLiteException
    //   265	302	1082	android/database/sqlite/SQLiteException
    //   302	405	1082	android/database/sqlite/SQLiteException
    //   411	431	1082	android/database/sqlite/SQLiteException
    //   441	573	1082	android/database/sqlite/SQLiteException
    //   582	588	1082	android/database/sqlite/SQLiteException
    //   588	598	1082	android/database/sqlite/SQLiteException
    //   603	623	1082	android/database/sqlite/SQLiteException
    //   628	656	1082	android/database/sqlite/SQLiteException
    //   665	681	1082	android/database/sqlite/SQLiteException
    //   685	689	1082	android/database/sqlite/SQLiteException
    //   699	711	1082	android/database/sqlite/SQLiteException
    //   720	728	1082	android/database/sqlite/SQLiteException
    //   731	773	1082	android/database/sqlite/SQLiteException
    //   777	792	1082	android/database/sqlite/SQLiteException
    //   802	1053	1082	android/database/sqlite/SQLiteException
    //   1062	1068	1082	android/database/sqlite/SQLiteException
    //   1068	1075	1082	android/database/sqlite/SQLiteException
    //   64	68	1104	finally
    //   73	101	1104	finally
    //   105	112	1104	finally
    //   117	128	1104	finally
    //   141	172	1104	finally
    //   172	203	1104	finally
    //   207	238	1104	finally
    //   238	261	1104	finally
    //   265	302	1104	finally
    //   302	405	1104	finally
    //   411	431	1104	finally
    //   441	573	1104	finally
    //   582	588	1104	finally
    //   588	598	1104	finally
    //   603	623	1104	finally
    //   628	656	1104	finally
    //   665	681	1104	finally
    //   685	689	1104	finally
    //   699	711	1104	finally
    //   720	728	1104	finally
    //   731	773	1104	finally
    //   777	792	1104	finally
    //   802	1053	1104	finally
    //   1062	1068	1104	finally
    //   1068	1075	1104	finally
    //   1083	1101	1104	finally
    //   1112	1117	1104	finally
    //   64	68	1111	java/lang/RuntimeException
    //   73	101	1111	java/lang/RuntimeException
    //   105	112	1111	java/lang/RuntimeException
    //   117	128	1111	java/lang/RuntimeException
    //   141	172	1111	java/lang/RuntimeException
    //   172	203	1111	java/lang/RuntimeException
    //   207	238	1111	java/lang/RuntimeException
    //   238	261	1111	java/lang/RuntimeException
    //   265	302	1111	java/lang/RuntimeException
    //   302	405	1111	java/lang/RuntimeException
    //   411	431	1111	java/lang/RuntimeException
    //   441	573	1111	java/lang/RuntimeException
    //   582	588	1111	java/lang/RuntimeException
    //   588	598	1111	java/lang/RuntimeException
    //   603	623	1111	java/lang/RuntimeException
    //   628	656	1111	java/lang/RuntimeException
    //   665	681	1111	java/lang/RuntimeException
    //   685	689	1111	java/lang/RuntimeException
    //   699	711	1111	java/lang/RuntimeException
    //   720	728	1111	java/lang/RuntimeException
    //   731	773	1111	java/lang/RuntimeException
    //   777	792	1111	java/lang/RuntimeException
    //   802	1053	1111	java/lang/RuntimeException
    //   1062	1068	1111	java/lang/RuntimeException
    //   1068	1075	1111	java/lang/RuntimeException
  }
  
  /* Error */
  public Cursor b(long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   6: ldc_w 846
    //   9: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   12: new 134	com/mobisystems/mobiscanner/model/d
    //   15: dup
    //   16: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   19: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   25: astore 7
    //   27: aload_0
    //   28: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   31: ldc_w 848
    //   34: astore 5
    //   36: ldc -27
    //   38: astore 6
    //   40: ldc_w 1446
    //   43: astore_3
    //   44: iload_2
    //   45: aload_1
    //   46: arraylength
    //   47: if_icmpge +76 -> 123
    //   50: aload_3
    //   51: astore 4
    //   53: iload_2
    //   54: ifle +25 -> 79
    //   57: new 494	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   64: aload_3
    //   65: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 1448
    //   71: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: new 494	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   86: aload 4
    //   88: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 1450
    //   94: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: iload_2
    //   99: laload
    //   100: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   103: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 1450
    //   109: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_3
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -76 -> 44
    //   123: new 494	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   130: aload_3
    //   131: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 1452
    //   137: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore 4
    //   145: aload 6
    //   147: astore_1
    //   148: ldc -27
    //   150: invokevirtual 853	java/lang/String:length	()I
    //   153: ifle +25 -> 178
    //   156: new 494	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   163: ldc -27
    //   165: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 857
    //   171: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_1
    //   178: new 494	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   185: aload_1
    //   186: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 861
    //   192: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_3
    //   199: aload_3
    //   200: astore_1
    //   201: aload_3
    //   202: invokevirtual 853	java/lang/String:length	()I
    //   205: ifle +24 -> 229
    //   208: new 494	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   215: aload_3
    //   216: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 857
    //   222: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_1
    //   229: new 494	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   236: aload_1
    //   237: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 4
    //   242: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: astore_3
    //   249: aload 5
    //   251: astore_1
    //   252: aload_3
    //   253: invokevirtual 853	java/lang/String:length	()I
    //   256: ifle +30 -> 286
    //   259: new 494	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 848
    //   269: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 863
    //   275: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_3
    //   279: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore_1
    //   286: new 494	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   293: aload_1
    //   294: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 875
    //   300: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_1
    //   307: aload_0
    //   308: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   311: astore_3
    //   312: aload 7
    //   314: aload_1
    //   315: iconst_0
    //   316: anewarray 160	java/lang/String
    //   319: aload_3
    //   320: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   323: astore_1
    //   324: aload_0
    //   325: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   328: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   331: aload_0
    //   332: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   335: aload_1
    //   336: areturn
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_1
    //   340: aload_0
    //   341: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   344: ldc_w 877
    //   347: aload_3
    //   348: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload_0
    //   352: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   355: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   358: goto -27 -> 331
    //   361: astore_1
    //   362: aload_0
    //   363: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   366: aload_1
    //   367: athrow
    //   368: astore_3
    //   369: aconst_null
    //   370: astore_1
    //   371: aload_0
    //   372: aload_3
    //   373: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   376: goto -45 -> 331
    //   379: astore_3
    //   380: goto -9 -> 371
    //   383: astore_3
    //   384: goto -44 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	DocumentModel
    //   0	387	1	paramArrayOfLong	long[]
    //   1	119	2	i	int
    //   43	277	3	localObject1	Object
    //   337	11	3	localSQLiteException1	SQLiteException
    //   368	5	3	localRuntimeException1	RuntimeException
    //   379	1	3	localRuntimeException2	RuntimeException
    //   383	1	3	localSQLiteException2	SQLiteException
    //   51	190	4	localObject2	Object
    //   34	216	5	str1	String
    //   38	108	6	str2	String
    //   25	288	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   27	31	337	android/database/sqlite/SQLiteException
    //   44	50	337	android/database/sqlite/SQLiteException
    //   57	79	337	android/database/sqlite/SQLiteException
    //   79	116	337	android/database/sqlite/SQLiteException
    //   123	145	337	android/database/sqlite/SQLiteException
    //   148	178	337	android/database/sqlite/SQLiteException
    //   178	199	337	android/database/sqlite/SQLiteException
    //   201	229	337	android/database/sqlite/SQLiteException
    //   229	249	337	android/database/sqlite/SQLiteException
    //   252	286	337	android/database/sqlite/SQLiteException
    //   286	324	337	android/database/sqlite/SQLiteException
    //   27	31	361	finally
    //   44	50	361	finally
    //   57	79	361	finally
    //   79	116	361	finally
    //   123	145	361	finally
    //   148	178	361	finally
    //   178	199	361	finally
    //   201	229	361	finally
    //   229	249	361	finally
    //   252	286	361	finally
    //   286	324	361	finally
    //   324	331	361	finally
    //   340	358	361	finally
    //   371	376	361	finally
    //   27	31	368	java/lang/RuntimeException
    //   44	50	368	java/lang/RuntimeException
    //   57	79	368	java/lang/RuntimeException
    //   79	116	368	java/lang/RuntimeException
    //   123	145	368	java/lang/RuntimeException
    //   148	178	368	java/lang/RuntimeException
    //   178	199	368	java/lang/RuntimeException
    //   201	229	368	java/lang/RuntimeException
    //   229	249	368	java/lang/RuntimeException
    //   252	286	368	java/lang/RuntimeException
    //   286	324	368	java/lang/RuntimeException
    //   324	331	379	java/lang/RuntimeException
    //   324	331	383	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean b(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1455
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc_w 1457
    //   30: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_3
    //   34: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   43: new 134	com/mobisystems/mobiscanner/model/d
    //   46: dup
    //   47: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   50: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   56: astore 7
    //   58: aload 7
    //   60: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   63: aload 7
    //   65: ldc_w 1459
    //   68: iconst_2
    //   69: anewarray 160	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: iload_3
    //   75: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload 7
    //   92: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   95: aload_0
    //   96: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   102: aload 7
    //   104: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   107: iload 4
    //   109: ireturn
    //   110: astore 6
    //   112: iconst_0
    //   113: istore 4
    //   115: aload_0
    //   116: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   119: ldc_w 1461
    //   122: aload 6
    //   124: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_0
    //   128: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   131: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   134: goto -32 -> 102
    //   137: astore 6
    //   139: aload 7
    //   141: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   144: aload 6
    //   146: athrow
    //   147: astore 6
    //   149: iload 5
    //   151: istore 4
    //   153: goto -38 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	DocumentModel
    //   0	156	1	paramLong	long
    //   0	156	3	paramInt	int
    //   4	148	4	bool1	boolean
    //   1	149	5	bool2	boolean
    //   110	13	6	localSQLiteException1	SQLiteException
    //   137	8	6	localObject	Object
    //   147	1	6	localSQLiteException2	SQLiteException
    //   56	84	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   58	95	110	android/database/sqlite/SQLiteException
    //   58	95	137	finally
    //   95	102	137	finally
    //   115	134	137	finally
    //   95	102	147	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean b(long paramLong, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1464
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc_w 1466
    //   30: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   43: new 134	com/mobisystems/mobiscanner/model/d
    //   46: dup
    //   47: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   50: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   56: astore 6
    //   58: aload 6
    //   60: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   63: aload 6
    //   65: ldc_w 1468
    //   68: iconst_2
    //   69: anewarray 160	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_3
    //   75: invokevirtual 1092	java/lang/String:trim	()Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload 6
    //   92: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   95: aload_0
    //   96: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   102: aload 6
    //   104: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   107: iload 4
    //   109: ireturn
    //   110: astore_3
    //   111: iconst_0
    //   112: istore 4
    //   114: aload_0
    //   115: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   118: ldc_w 1126
    //   121: aload_3
    //   122: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   129: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   132: goto -30 -> 102
    //   135: astore_3
    //   136: aload 6
    //   138: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   141: aload_3
    //   142: athrow
    //   143: astore_3
    //   144: iload 5
    //   146: istore 4
    //   148: goto -34 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DocumentModel
    //   0	151	1	paramLong	long
    //   0	151	3	paramString	String
    //   4	143	4	bool1	boolean
    //   1	144	5	bool2	boolean
    //   56	81	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   58	95	110	android/database/sqlite/SQLiteException
    //   58	95	135	finally
    //   95	102	135	finally
    //   114	132	135	finally
    //   95	102	143	android/database/sqlite/SQLiteException
  }
  
  public boolean b(long paramLong, String paramString, boolean paramBoolean)
  {
    this.mLog.dl("croppedImageFilePath called, pageId=" + paramLong + ", croppedImageFilePath=" + paramString + ", copyFileFlag" + paramBoolean);
    return b(paramLong, paramString, paramBoolean, null);
  }
  
  /* Error */
  public c c(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   16: new 494	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1477
    //   26: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_1
    //   30: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 1479
    //   36: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_3
    //   40: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   49: new 134	com/mobisystems/mobiscanner/model/d
    //   52: dup
    //   53: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   56: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   62: astore 7
    //   64: aload 4
    //   66: astore 5
    //   68: aload_0
    //   69: invokespecial 581	com/mobisystems/mobiscanner/model/DocumentModel:Ir	()V
    //   72: aload 4
    //   74: astore 5
    //   76: aload_0
    //   77: getfield 45	com/mobisystems/mobiscanner/model/DocumentModel:aIG	Landroid/os/CancellationSignal;
    //   80: astore 10
    //   82: aload 4
    //   84: astore 5
    //   86: aload 7
    //   88: ldc_w 1481
    //   91: iconst_2
    //   92: anewarray 160	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: lload_1
    //   98: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: iload_3
    //   105: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: aastore
    //   109: aload 10
    //   111: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   114: astore 4
    //   116: aload 4
    //   118: ifnull +167 -> 285
    //   121: aload 4
    //   123: invokeinterface 200 1 0
    //   128: ifeq +157 -> 285
    //   131: aload_0
    //   132: lload_1
    //   133: invokevirtual 1037	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   136: astore 5
    //   138: aload 5
    //   140: ifnonnull +98 -> 238
    //   143: new 217	java/io/IOException
    //   146: dup
    //   147: new 494	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 1039
    //   157: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: lload_1
    //   161: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 508	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: astore 7
    //   173: aconst_null
    //   174: astore 5
    //   176: aload 4
    //   178: astore 6
    //   180: aload 5
    //   182: astore 4
    //   184: aload 6
    //   186: astore 5
    //   188: aload_0
    //   189: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   192: ldc_w 1282
    //   195: aload 7
    //   197: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload 6
    //   202: astore 5
    //   204: aload_0
    //   205: getstatic 486	com/mobisystems/mobiscanner/common/OperationStatus:awe	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   208: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   211: aload_0
    //   212: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   215: aload 4
    //   217: astore 5
    //   219: aload 6
    //   221: ifnull +14 -> 235
    //   224: aload 6
    //   226: invokeinterface 99 1 0
    //   231: aload 4
    //   233: astore 5
    //   235: aload 5
    //   237: areturn
    //   238: new 219	com/mobisystems/mobiscanner/model/c
    //   241: dup
    //   242: aload 5
    //   244: aload 4
    //   246: invokespecial 1285	com/mobisystems/mobiscanner/model/c:<init>	(Lcom/mobisystems/mobiscanner/model/b;Landroid/database/Cursor;)V
    //   249: astore 5
    //   251: aload_0
    //   252: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   255: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   258: aload 5
    //   260: astore 6
    //   262: aload_0
    //   263: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   266: aload 6
    //   268: astore 5
    //   270: aload 4
    //   272: ifnull -37 -> 235
    //   275: aload 4
    //   277: invokeinterface 99 1 0
    //   282: aload 6
    //   284: areturn
    //   285: aload_0
    //   286: getstatic 1288	com/mobisystems/mobiscanner/common/OperationStatus:awc	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   289: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   292: aconst_null
    //   293: astore 6
    //   295: goto -33 -> 262
    //   298: astore 7
    //   300: aconst_null
    //   301: astore 4
    //   303: aload 8
    //   305: astore 6
    //   307: aload 6
    //   309: astore 5
    //   311: aload_0
    //   312: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   315: ldc_w 1282
    //   318: aload 7
    //   320: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   323: aload 6
    //   325: astore 5
    //   327: aload_0
    //   328: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   331: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   334: aload_0
    //   335: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   338: aload 4
    //   340: astore 5
    //   342: aload 6
    //   344: ifnull -109 -> 235
    //   347: goto -123 -> 224
    //   350: astore 7
    //   352: aconst_null
    //   353: astore 4
    //   355: aload 9
    //   357: astore 6
    //   359: aload 6
    //   361: astore 5
    //   363: aload_0
    //   364: aload 7
    //   366: invokespecial 589	com/mobisystems/mobiscanner/model/DocumentModel:a	(Ljava/lang/RuntimeException;)V
    //   369: aload_0
    //   370: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   373: aload 4
    //   375: astore 5
    //   377: aload 6
    //   379: ifnull -144 -> 235
    //   382: goto -158 -> 224
    //   385: astore 4
    //   387: aload_0
    //   388: invokespecial 585	com/mobisystems/mobiscanner/model/DocumentModel:Is	()V
    //   391: aload 5
    //   393: ifnull +10 -> 403
    //   396: aload 5
    //   398: invokeinterface 99 1 0
    //   403: aload 4
    //   405: athrow
    //   406: astore 6
    //   408: aload 4
    //   410: astore 5
    //   412: aload 6
    //   414: astore 4
    //   416: goto -29 -> 387
    //   419: astore 7
    //   421: aconst_null
    //   422: astore 5
    //   424: aload 4
    //   426: astore 6
    //   428: aload 5
    //   430: astore 4
    //   432: goto -73 -> 359
    //   435: astore 7
    //   437: aload 4
    //   439: astore 6
    //   441: aload 5
    //   443: astore 4
    //   445: goto -86 -> 359
    //   448: astore 7
    //   450: aconst_null
    //   451: astore 5
    //   453: aload 4
    //   455: astore 6
    //   457: aload 5
    //   459: astore 4
    //   461: goto -154 -> 307
    //   464: astore 7
    //   466: aload 4
    //   468: astore 6
    //   470: aload 5
    //   472: astore 4
    //   474: goto -167 -> 307
    //   477: astore 7
    //   479: aconst_null
    //   480: astore 4
    //   482: goto -298 -> 184
    //   485: astore 7
    //   487: aload 4
    //   489: astore 6
    //   491: aload 5
    //   493: astore 4
    //   495: goto -311 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	DocumentModel
    //   0	498	1	paramLong	long
    //   0	498	3	paramInt	int
    //   7	367	4	localObject1	Object
    //   385	24	4	localObject2	Object
    //   414	80	4	localObject3	Object
    //   66	426	5	localObject4	Object
    //   10	368	6	localObject5	Object
    //   406	7	6	localObject6	Object
    //   426	64	6	localObject7	Object
    //   62	25	7	locald	d
    //   171	25	7	localIOException1	IOException
    //   298	21	7	localSQLiteException1	SQLiteException
    //   350	15	7	localRuntimeException1	RuntimeException
    //   419	1	7	localRuntimeException2	RuntimeException
    //   435	1	7	localRuntimeException3	RuntimeException
    //   448	1	7	localSQLiteException2	SQLiteException
    //   464	1	7	localSQLiteException3	SQLiteException
    //   477	1	7	localIOException2	IOException
    //   485	1	7	localIOException3	IOException
    //   1	303	8	localObject8	Object
    //   4	352	9	localObject9	Object
    //   80	30	10	localCancellationSignal	CancellationSignal
    // Exception table:
    //   from	to	target	type
    //   121	138	171	java/io/IOException
    //   143	171	171	java/io/IOException
    //   238	251	171	java/io/IOException
    //   285	292	171	java/io/IOException
    //   68	72	298	android/database/sqlite/SQLiteException
    //   76	82	298	android/database/sqlite/SQLiteException
    //   86	116	298	android/database/sqlite/SQLiteException
    //   68	72	350	java/lang/RuntimeException
    //   76	82	350	java/lang/RuntimeException
    //   86	116	350	java/lang/RuntimeException
    //   68	72	385	finally
    //   76	82	385	finally
    //   86	116	385	finally
    //   188	200	385	finally
    //   204	211	385	finally
    //   311	323	385	finally
    //   327	334	385	finally
    //   363	369	385	finally
    //   121	138	406	finally
    //   143	171	406	finally
    //   238	251	406	finally
    //   251	258	406	finally
    //   285	292	406	finally
    //   121	138	419	java/lang/RuntimeException
    //   143	171	419	java/lang/RuntimeException
    //   238	251	419	java/lang/RuntimeException
    //   285	292	419	java/lang/RuntimeException
    //   251	258	435	java/lang/RuntimeException
    //   121	138	448	android/database/sqlite/SQLiteException
    //   143	171	448	android/database/sqlite/SQLiteException
    //   238	251	448	android/database/sqlite/SQLiteException
    //   285	292	448	android/database/sqlite/SQLiteException
    //   251	258	464	android/database/sqlite/SQLiteException
    //   68	72	477	java/io/IOException
    //   76	82	477	java/io/IOException
    //   86	116	477	java/io/IOException
    //   251	258	485	java/io/IOException
  }
  
  /* Error */
  public boolean d(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 7
    //   9: aload_0
    //   10: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   13: new 494	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1483
    //   23: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_1
    //   27: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 1485
    //   33: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload_3
    //   37: invokevirtual 708	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   46: new 134	com/mobisystems/mobiscanner/model/d
    //   49: dup
    //   50: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   53: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   56: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   59: astore 12
    //   61: aload 12
    //   63: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   66: aload 12
    //   68: ldc_w 986
    //   71: iconst_1
    //   72: anewarray 160	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: lload_1
    //   78: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: aastore
    //   82: aconst_null
    //   83: invokevirtual 197	com/mobisystems/mobiscanner/model/d:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   86: astore 9
    //   88: aload 9
    //   90: ifnull +17 -> 107
    //   93: aload 9
    //   95: astore 10
    //   97: aload 9
    //   99: invokeinterface 200 1 0
    //   104: ifne +78 -> 182
    //   107: aload 9
    //   109: astore 10
    //   111: new 130	android/database/sqlite/SQLiteException
    //   114: dup
    //   115: ldc_w 988
    //   118: invokespecial 204	android/database/sqlite/SQLiteException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore 11
    //   124: iconst_0
    //   125: istore 6
    //   127: aload 9
    //   129: astore 10
    //   131: aload_0
    //   132: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   135: ldc_w 1487
    //   138: aload 11
    //   140: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload 9
    //   145: astore 10
    //   147: aload_0
    //   148: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   151: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   154: aload 12
    //   156: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   159: iload 6
    //   161: istore 7
    //   163: aload 9
    //   165: ifnull +14 -> 179
    //   168: aload 9
    //   170: invokeinterface 99 1 0
    //   175: iload 6
    //   177: istore 7
    //   179: iload 7
    //   181: ireturn
    //   182: aload 9
    //   184: astore 10
    //   186: aload 9
    //   188: iconst_0
    //   189: invokeinterface 210 2 0
    //   194: lstore 4
    //   196: aload 9
    //   198: astore 10
    //   200: aload 12
    //   202: ldc_w 1489
    //   205: iconst_2
    //   206: anewarray 160	java/lang/String
    //   209: dup
    //   210: iconst_0
    //   211: iload_3
    //   212: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: lload_1
    //   219: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   222: aastore
    //   223: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   226: pop
    //   227: aload 9
    //   229: astore 10
    //   231: aload_0
    //   232: lload 4
    //   234: invokespecial 565	com/mobisystems/mobiscanner/model/DocumentModel:aD	(J)V
    //   237: aload 9
    //   239: astore 10
    //   241: aload_0
    //   242: lload_1
    //   243: invokevirtual 562	com/mobisystems/mobiscanner/model/DocumentModel:aK	(J)Z
    //   246: pop
    //   247: aload 9
    //   249: astore 10
    //   251: aload 12
    //   253: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   256: aload 9
    //   258: astore 10
    //   260: aload_0
    //   261: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   264: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   267: aload 12
    //   269: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   272: iload 8
    //   274: istore 7
    //   276: aload 9
    //   278: ifnull -99 -> 179
    //   281: goto -113 -> 168
    //   284: astore 9
    //   286: aconst_null
    //   287: astore 10
    //   289: aload 12
    //   291: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   294: aload 10
    //   296: ifnull +10 -> 306
    //   299: aload 10
    //   301: invokeinterface 99 1 0
    //   306: aload 9
    //   308: athrow
    //   309: astore 9
    //   311: goto -22 -> 289
    //   314: astore 11
    //   316: aconst_null
    //   317: astore 9
    //   319: iconst_0
    //   320: istore 6
    //   322: goto -195 -> 127
    //   325: astore 11
    //   327: iload 7
    //   329: istore 6
    //   331: goto -204 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	DocumentModel
    //   0	334	1	paramLong	long
    //   0	334	3	paramInt	int
    //   194	39	4	l	long
    //   1	329	6	bool1	boolean
    //   7	321	7	bool2	boolean
    //   4	269	8	bool3	boolean
    //   86	191	9	localCursor1	Cursor
    //   284	23	9	localObject1	Object
    //   309	1	9	localObject2	Object
    //   317	1	9	localObject3	Object
    //   95	205	10	localCursor2	Cursor
    //   122	17	11	localSQLiteException1	SQLiteException
    //   314	1	11	localSQLiteException2	SQLiteException
    //   325	1	11	localSQLiteException3	SQLiteException
    //   59	231	12	locald	d
    // Exception table:
    //   from	to	target	type
    //   97	107	122	android/database/sqlite/SQLiteException
    //   111	122	122	android/database/sqlite/SQLiteException
    //   186	196	122	android/database/sqlite/SQLiteException
    //   200	227	122	android/database/sqlite/SQLiteException
    //   231	237	122	android/database/sqlite/SQLiteException
    //   241	247	122	android/database/sqlite/SQLiteException
    //   251	256	122	android/database/sqlite/SQLiteException
    //   61	88	284	finally
    //   97	107	309	finally
    //   111	122	309	finally
    //   131	143	309	finally
    //   147	154	309	finally
    //   186	196	309	finally
    //   200	227	309	finally
    //   231	237	309	finally
    //   241	247	309	finally
    //   251	256	309	finally
    //   260	267	309	finally
    //   61	88	314	android/database/sqlite/SQLiteException
    //   260	267	325	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean e(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1491
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 7
    //   55: ldc_w 1493
    //   58: iconst_2
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: iload_3
    //   65: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: lload_1
    //   72: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   79: pop
    //   80: aload 7
    //   82: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   85: aload_0
    //   86: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   89: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   92: aload 7
    //   94: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   97: iload 4
    //   99: ireturn
    //   100: astore 6
    //   102: iconst_0
    //   103: istore 4
    //   105: aload_0
    //   106: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   109: ldc_w 1495
    //   112: aload 6
    //   114: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   121: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   124: goto -32 -> 92
    //   127: astore 6
    //   129: aload 7
    //   131: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   134: aload 6
    //   136: athrow
    //   137: astore 6
    //   139: iload 5
    //   141: istore 4
    //   143: goto -38 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	DocumentModel
    //   0	146	1	paramLong	long
    //   0	146	3	paramInt	int
    //   4	138	4	bool1	boolean
    //   1	139	5	bool2	boolean
    //   100	13	6	localSQLiteException1	SQLiteException
    //   127	8	6	localObject	Object
    //   137	1	6	localSQLiteException2	SQLiteException
    //   46	84	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	85	100	android/database/sqlite/SQLiteException
    //   48	85	127	finally
    //   85	92	127	finally
    //   105	124	127	finally
    //   85	92	137	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public boolean e(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1497
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc_w 1499
    //   30: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload_3
    //   34: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   37: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   43: new 134	com/mobisystems/mobiscanner/model/d
    //   46: dup
    //   47: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   50: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   56: astore 8
    //   58: aload 8
    //   60: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   63: aload 8
    //   65: ldc_w 1501
    //   68: iconst_2
    //   69: anewarray 160	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: lload_3
    //   75: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: lload_1
    //   82: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   89: pop
    //   90: aload 8
    //   92: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   95: aload_0
    //   96: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   102: aload 8
    //   104: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   107: iload 5
    //   109: ireturn
    //   110: astore 7
    //   112: iconst_0
    //   113: istore 5
    //   115: aload_0
    //   116: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   119: ldc_w 1503
    //   122: aload 7
    //   124: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_0
    //   128: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   131: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   134: goto -32 -> 102
    //   137: astore 7
    //   139: aload 8
    //   141: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   144: aload 7
    //   146: athrow
    //   147: astore 7
    //   149: iload 6
    //   151: istore 5
    //   153: goto -38 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	DocumentModel
    //   0	156	1	paramLong1	long
    //   0	156	3	paramLong2	long
    //   4	148	5	bool1	boolean
    //   1	149	6	bool2	boolean
    //   110	13	7	localSQLiteException1	SQLiteException
    //   137	8	7	localObject	Object
    //   147	1	7	localSQLiteException2	SQLiteException
    //   56	84	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   58	95	110	android/database/sqlite/SQLiteException
    //   58	95	137	finally
    //   95	102	137	finally
    //   115	134	137	finally
    //   95	102	147	android/database/sqlite/SQLiteException
  }
  
  @SuppressLint({"DefaultLocale"})
  public long f(long paramLong1, long paramLong2)
  {
    this.mLog.dl("moveAllPages called, fromDocId=" + paramLong1 + ", toDocId=" + paramLong2);
    d locald = new d(aIF.getWritableDatabase());
    label244:
    label251:
    for (;;)
    {
      try
      {
        locald.beginTransaction();
        this.aII = OperationStatus.awd;
        if (paramLong2 >= 0L) {
          break label251;
        }
        paramLong2 = f(new b());
        if (paramLong2 != paramLong1)
        {
          int i = ai(paramLong2);
          if (i < 0) {
            break label244;
          }
          locald.b("UPDATE pages SET doc_id = ?, idx_within_doc = ( idx_within_doc + ? ) WHERE doc_id = ?;", new String[] { String.valueOf(paramLong2), String.valueOf(i), String.valueOf(paramLong1) });
          locald.b("UPDATE documents SET title_page_id = -1 WHERE id = ?;", new String[] { String.valueOf(paramLong1) });
          aD(paramLong1);
          aD(paramLong2);
          paramLong1 = paramLong2;
          paramLong2 = paramLong1;
          if (paramLong1 < 0L) {}
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        paramLong1 = -1L;
        this.mLog.g("SQL Exception moving page", localSQLiteException1);
        this.aII = OperationStatus.awd;
        paramLong2 = paramLong1;
        continue;
      }
      finally
      {
        locald.endTransaction();
      }
      try
      {
        locald.setTransactionSuccessful();
        this.aII = OperationStatus.avC;
        paramLong2 = paramLong1;
        locald.endTransaction();
        return paramLong2;
      }
      catch (SQLiteException localSQLiteException2)
      {
        continue;
      }
      continue;
      paramLong1 = -1L;
    }
  }
  
  /* Error */
  public long f(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   4: ldc_w 1516
    //   7: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   10: new 134	com/mobisystems/mobiscanner/model/d
    //   13: dup
    //   14: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   17: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   23: astore 6
    //   25: aload 6
    //   27: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   30: aload_1
    //   31: invokevirtual 1089	com/mobisystems/mobiscanner/model/b:getName	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 5
    //   42: ldc -27
    //   44: invokevirtual 233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +8 -> 55
    //   50: ldc_w 1518
    //   53: astore 4
    //   55: aload 6
    //   57: ldc_w 1520
    //   60: bipush 15
    //   62: anewarray 160	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload 4
    //   69: invokevirtual 1092	java/lang/String:trim	()Ljava/lang/String;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: aload_1
    //   76: invokevirtual 1095	com/mobisystems/mobiscanner/model/b:IB	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageSize;
    //   79: invokevirtual 296	com/mobisystems/mobiscanner/common/CommonPreferences$PageSize:Dp	()I
    //   82: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: aload_1
    //   89: invokevirtual 1098	com/mobisystems/mobiscanner/model/b:IC	()F
    //   92: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   95: aastore
    //   96: dup
    //   97: iconst_3
    //   98: aload_1
    //   99: invokevirtual 1101	com/mobisystems/mobiscanner/model/b:ID	()F
    //   102: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   105: aastore
    //   106: dup
    //   107: iconst_4
    //   108: aload_1
    //   109: invokevirtual 1104	com/mobisystems/mobiscanner/model/b:IE	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation;
    //   112: invokevirtual 313	com/mobisystems/mobiscanner/common/CommonPreferences$PageOrientation:Dp	()I
    //   115: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_5
    //   121: aload_1
    //   122: invokevirtual 1107	com/mobisystems/mobiscanner/model/b:IF	()F
    //   125: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: bipush 6
    //   132: aload_1
    //   133: invokevirtual 1110	com/mobisystems/mobiscanner/model/b:IG	()F
    //   136: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: bipush 7
    //   143: aload_1
    //   144: invokevirtual 1113	com/mobisystems/mobiscanner/model/b:IH	()F
    //   147: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   150: aastore
    //   151: dup
    //   152: bipush 8
    //   154: aload_1
    //   155: invokevirtual 1116	com/mobisystems/mobiscanner/model/b:II	()F
    //   158: invokestatic 303	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   161: aastore
    //   162: dup
    //   163: bipush 9
    //   165: aload_1
    //   166: invokevirtual 1117	com/mobisystems/mobiscanner/model/b:IJ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality;
    //   169: invokevirtual 332	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageQuality:Dp	()I
    //   172: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: bipush 10
    //   179: aload_1
    //   180: invokevirtual 1118	com/mobisystems/mobiscanner/model/b:IK	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity;
    //   183: invokevirtual 339	com/mobisystems/mobiscanner/common/CommonPreferences$PDFImageDensity:Dp	()I
    //   186: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   189: aastore
    //   190: dup
    //   191: bipush 11
    //   193: aload_1
    //   194: invokevirtual 1523	com/mobisystems/mobiscanner/model/b:IN	()I
    //   197: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   200: aastore
    //   201: dup
    //   202: bipush 12
    //   204: aload_1
    //   205: invokevirtual 1034	com/mobisystems/mobiscanner/model/b:IO	()J
    //   208: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   211: aastore
    //   212: dup
    //   213: bipush 13
    //   215: aload_1
    //   216: invokevirtual 1121	com/mobisystems/mobiscanner/model/b:IQ	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   219: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   222: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: bipush 14
    //   229: aload_1
    //   230: invokevirtual 1124	com/mobisystems/mobiscanner/model/b:IR	()Lcom/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage;
    //   233: invokevirtual 397	com/mobisystems/mobiscanner/common/CommonPreferences$OCRLanguage:Dp	()I
    //   236: invokestatic 287	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   239: aastore
    //   240: invokevirtual 415	com/mobisystems/mobiscanner/model/d:a	(Ljava/lang/String;[Ljava/lang/String;)J
    //   243: lstore_2
    //   244: aload_1
    //   245: invokevirtual 1089	com/mobisystems/mobiscanner/model/b:getName	()Ljava/lang/String;
    //   248: ldc -27
    //   250: invokevirtual 233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +49 -> 302
    //   256: aload 6
    //   258: ldc_w 1525
    //   261: iconst_2
    //   262: anewarray 160	java/lang/String
    //   265: dup
    //   266: iconst_0
    //   267: new 494	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 1518
    //   277: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: lload_2
    //   281: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   284: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: lload_2
    //   294: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   297: aastore
    //   298: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   301: pop
    //   302: aload 6
    //   304: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   307: aload_0
    //   308: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   311: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   314: aload 6
    //   316: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   319: lload_2
    //   320: lreturn
    //   321: astore_1
    //   322: ldc2_w 181
    //   325: lstore_2
    //   326: aload_0
    //   327: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   330: ldc_w 1527
    //   333: aload_1
    //   334: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: aload_0
    //   338: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   341: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   344: goto -30 -> 314
    //   347: astore_1
    //   348: aload 6
    //   350: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   353: aload_1
    //   354: athrow
    //   355: astore_1
    //   356: goto -30 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	DocumentModel
    //   0	359	1	paramb	b
    //   243	83	2	l	long
    //   38	30	4	str1	String
    //   34	7	5	str2	String
    //   23	326	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   25	36	321	android/database/sqlite/SQLiteException
    //   40	50	321	android/database/sqlite/SQLiteException
    //   55	302	321	android/database/sqlite/SQLiteException
    //   302	307	321	android/database/sqlite/SQLiteException
    //   25	36	347	finally
    //   40	50	347	finally
    //   55	302	347	finally
    //   302	307	347	finally
    //   307	314	347	finally
    //   326	344	347	finally
    //   307	314	355	android/database/sqlite/SQLiteException
  }
  
  public boolean g(long paramLong1, long paramLong2)
  {
    this.mLog.dl("setDocTime called, docId=" + paramLong1 + ", time=" + paramLong2);
    d locald = new d(aIF.getWritableDatabase());
    try
    {
      locald.beginTransaction();
      locald.b("UPDATE documents SET last_modification_time = ? WHERE id = ?;", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      locald.setTransactionSuccessful();
      this.aII = OperationStatus.avC;
      return true;
    }
    catch (SQLiteException localSQLiteException)
    {
      this.mLog.g("SQL Exception setting document time", localSQLiteException);
      this.aII = OperationStatus.awd;
      return false;
    }
    finally
    {
      locald.endTransaction();
    }
  }
  
  /* Error */
  public boolean h(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   10: new 494	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 495	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 1537
    //   20: invokevirtual 501	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload_1
    //   24: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 507	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokevirtual 65	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   33: new 134	com/mobisystems/mobiscanner/model/d
    //   36: dup
    //   37: getstatic 36	com/mobisystems/mobiscanner/model/DocumentModel:aIF	Lcom/mobisystems/mobiscanner/model/e;
    //   40: invokevirtual 138	com/mobisystems/mobiscanner/model/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   43: invokespecial 141	com/mobisystems/mobiscanner/model/d:<init>	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   46: astore 8
    //   48: aload 8
    //   50: invokevirtual 144	com/mobisystems/mobiscanner/model/d:beginTransaction	()V
    //   53: aload 8
    //   55: ldc_w 1539
    //   58: iconst_3
    //   59: anewarray 160	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: lload_1
    //   65: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: lload_1
    //   72: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: lload_3
    //   79: invokestatic 164	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   82: aastore
    //   83: invokevirtual 168	com/mobisystems/mobiscanner/model/d:b	(Ljava/lang/String;[Ljava/lang/String;)I
    //   86: pop
    //   87: aload 8
    //   89: invokevirtual 171	com/mobisystems/mobiscanner/model/d:setTransactionSuccessful	()V
    //   92: aload_0
    //   93: getstatic 174	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   96: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   99: aload 8
    //   101: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   104: iload 5
    //   106: ireturn
    //   107: astore 7
    //   109: iconst_0
    //   110: istore 5
    //   112: aload_0
    //   113: getfield 43	com/mobisystems/mobiscanner/model/DocumentModel:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   116: ldc_w 1541
    //   119: aload 7
    //   121: invokevirtual 188	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_0
    //   125: getstatic 180	com/mobisystems/mobiscanner/common/OperationStatus:awd	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   128: putfield 59	com/mobisystems/mobiscanner/model/DocumentModel:aII	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   131: goto -32 -> 99
    //   134: astore 7
    //   136: aload 8
    //   138: invokevirtual 177	com/mobisystems/mobiscanner/model/d:endTransaction	()V
    //   141: aload 7
    //   143: athrow
    //   144: astore 7
    //   146: iload 6
    //   148: istore 5
    //   150: goto -38 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	DocumentModel
    //   0	153	1	paramLong1	long
    //   0	153	3	paramLong2	long
    //   4	145	5	bool1	boolean
    //   1	146	6	bool2	boolean
    //   107	13	7	localSQLiteException1	SQLiteException
    //   134	8	7	localObject	Object
    //   144	1	7	localSQLiteException2	SQLiteException
    //   46	91	8	locald	d
    // Exception table:
    //   from	to	target	type
    //   48	92	107	android/database/sqlite/SQLiteException
    //   48	92	134	finally
    //   92	99	134	finally
    //   112	131	134	finally
    //   92	99	144	android/database/sqlite/SQLiteException
  }
  
  public static enum DocListSortBy
  {
    private final String val;
    
    private DocListSortBy(String paramString)
    {
      this.val = paramString;
    }
    
    public String Iz()
    {
      return this.val;
    }
  }
  
  public static enum SortOrder
  {
    private final String val;
    
    private SortOrder(String paramString)
    {
      this.val = paramString;
    }
    
    public String Iz()
    {
      return this.val;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/model/DocumentModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */