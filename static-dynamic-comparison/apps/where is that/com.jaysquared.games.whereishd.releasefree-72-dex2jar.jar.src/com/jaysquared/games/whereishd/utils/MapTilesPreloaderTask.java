package com.jaysquared.games.whereishd.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.db.DatabaseHelper;
import com.jaysquared.games.whereishd.ui.MainMenuActivity;
import java.io.File;

public class MapTilesPreloaderTask
  extends AsyncTask<Void, Void, Void>
{
  private static final String LOG_TAG = MapTilesPreloaderTask.class.getSimpleName();
  private final Activity activicty;
  
  public MapTilesPreloaderTask(Activity paramActivity, boolean paramBoolean)
  {
    this.activicty = paramActivity;
    if (paramBoolean)
    {
      SLog.v(LOG_TAG, "Resetting map tiles cache ...");
      deleteMapFile("easy.mbtiles");
      if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
        deleteMapFile("hdedition.mbtiles");
      }
    }
  }
  
  /* Error */
  private File decompressMapFile(String paramString)
  {
    // Byte code:
    //   0: new 72	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 76	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:getExternalFilesDir	()Ljava/io/File;
    //   8: aload_1
    //   9: invokespecial 79	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore 11
    //   14: aload 11
    //   16: invokevirtual 83	java/io/File:exists	()Z
    //   19: ifeq +6 -> 25
    //   22: aload 11
    //   24: areturn
    //   25: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: ldc 88
    //   37: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 11
    //   42: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 101	com/jaysquared/games/whereishd/utils/SLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore 4
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 6
    //   60: aconst_null
    //   61: astore 10
    //   63: aconst_null
    //   64: astore 8
    //   66: aconst_null
    //   67: astore 9
    //   69: iconst_1
    //   70: istore_2
    //   71: aload_1
    //   72: ldc 64
    //   74: if_acmpne +85 -> 159
    //   77: aload 8
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 26	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:activicty	Landroid/app/Activity;
    //   85: invokevirtual 107	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   88: ldc 108
    //   90: invokevirtual 114	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   93: astore_1
    //   94: aload_1
    //   95: astore 6
    //   97: aload_1
    //   98: astore 4
    //   100: aload 8
    //   102: astore 5
    //   104: aload_1
    //   105: astore 7
    //   107: new 116	java/io/FileOutputStream
    //   110: dup
    //   111: aload 11
    //   113: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   116: astore 8
    //   118: ldc 120
    //   120: newarray <illegal type>
    //   122: astore 4
    //   124: aload_1
    //   125: aload 4
    //   127: invokevirtual 126	java/io/InputStream:read	([B)I
    //   130: istore_3
    //   131: iload_3
    //   132: ifge +47 -> 179
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 129	java/io/InputStream:close	()V
    //   143: aload 8
    //   145: ifnull +8 -> 153
    //   148: aload 8
    //   150: invokevirtual 132	java/io/OutputStream:close	()V
    //   153: iload_2
    //   154: ifne -132 -> 22
    //   157: aconst_null
    //   158: areturn
    //   159: aload 8
    //   161: astore 5
    //   163: aload_0
    //   164: getfield 26	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:activicty	Landroid/app/Activity;
    //   167: invokevirtual 107	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   170: ldc -123
    //   172: invokevirtual 114	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   175: astore_1
    //   176: goto -82 -> 94
    //   179: aload 8
    //   181: aload 4
    //   183: invokevirtual 137	java/io/OutputStream:write	([B)V
    //   186: goto -62 -> 124
    //   189: astore 4
    //   191: aload 8
    //   193: astore 6
    //   195: aload 4
    //   197: astore 8
    //   199: aload_1
    //   200: astore 4
    //   202: aload 6
    //   204: astore 5
    //   206: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   209: new 85	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   216: ldc -117
    //   218: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 8
    //   223: invokevirtual 142	java/io/FileNotFoundException:getLocalizedMessage	()Ljava/lang/String;
    //   226: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: iconst_0
    //   236: istore_3
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 129	java/io/InputStream:close	()V
    //   245: iload_3
    //   246: istore_2
    //   247: aload 6
    //   249: ifnull -96 -> 153
    //   252: aload 6
    //   254: invokevirtual 132	java/io/OutputStream:close	()V
    //   257: iload_3
    //   258: istore_2
    //   259: goto -106 -> 153
    //   262: astore_1
    //   263: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   266: new 85	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   273: ldc -109
    //   275: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_1
    //   279: invokevirtual 148	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   282: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload_3
    //   292: istore_2
    //   293: goto -140 -> 153
    //   296: astore_1
    //   297: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   300: new 85	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   307: ldc -109
    //   309: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_1
    //   313: invokevirtual 148	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   316: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -172 -> 153
    //   328: astore 4
    //   330: aload 10
    //   332: astore 7
    //   334: aload 6
    //   336: astore_1
    //   337: aload 4
    //   339: astore 6
    //   341: aload_1
    //   342: astore 4
    //   344: aload 7
    //   346: astore 5
    //   348: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   351: new 85	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   358: ldc -106
    //   360: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 6
    //   365: invokevirtual 148	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   368: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: iconst_0
    //   378: istore_3
    //   379: aload_1
    //   380: ifnull +7 -> 387
    //   383: aload_1
    //   384: invokevirtual 129	java/io/InputStream:close	()V
    //   387: iload_3
    //   388: istore_2
    //   389: aload 7
    //   391: ifnull -238 -> 153
    //   394: aload 7
    //   396: invokevirtual 132	java/io/OutputStream:close	()V
    //   399: iload_3
    //   400: istore_2
    //   401: goto -248 -> 153
    //   404: astore_1
    //   405: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   408: new 85	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   415: ldc -109
    //   417: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 148	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   424: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: iload_3
    //   434: istore_2
    //   435: goto -282 -> 153
    //   438: astore_1
    //   439: aload 4
    //   441: ifnull +8 -> 449
    //   444: aload 4
    //   446: invokevirtual 129	java/io/InputStream:close	()V
    //   449: aload 5
    //   451: ifnull +8 -> 459
    //   454: aload 5
    //   456: invokevirtual 132	java/io/OutputStream:close	()V
    //   459: aload_1
    //   460: athrow
    //   461: astore 4
    //   463: getstatic 19	com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask:LOG_TAG	Ljava/lang/String;
    //   466: new 85	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   473: ldc -109
    //   475: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 4
    //   480: invokevirtual 148	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   483: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 145	com/jaysquared/games/whereishd/utils/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: goto -33 -> 459
    //   495: astore 6
    //   497: aload 8
    //   499: astore 5
    //   501: aload_1
    //   502: astore 4
    //   504: aload 6
    //   506: astore_1
    //   507: goto -68 -> 439
    //   510: astore 6
    //   512: aload 8
    //   514: astore 7
    //   516: goto -175 -> 341
    //   519: astore 8
    //   521: aload 7
    //   523: astore_1
    //   524: aload 9
    //   526: astore 6
    //   528: goto -329 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	MapTilesPreloaderTask
    //   0	531	1	paramString	String
    //   70	365	2	i	int
    //   130	304	3	j	int
    //   52	130	4	localObject1	Object
    //   189	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   200	1	4	str1	String
    //   328	10	4	localIOException1	java.io.IOException
    //   342	103	4	str2	String
    //   461	18	4	localIOException2	java.io.IOException
    //   502	1	4	str3	String
    //   79	421	5	localObject2	Object
    //   58	306	6	localObject3	Object
    //   495	10	6	localObject4	Object
    //   510	1	6	localIOException3	java.io.IOException
    //   526	1	6	localObject5	Object
    //   55	467	7	localObject6	Object
    //   64	449	8	localObject7	Object
    //   519	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   67	458	9	localObject8	Object
    //   61	270	10	localObject9	Object
    //   12	100	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   118	124	189	java/io/FileNotFoundException
    //   124	131	189	java/io/FileNotFoundException
    //   179	186	189	java/io/FileNotFoundException
    //   241	245	262	java/io/IOException
    //   252	257	262	java/io/IOException
    //   139	143	296	java/io/IOException
    //   148	153	296	java/io/IOException
    //   81	94	328	java/io/IOException
    //   107	118	328	java/io/IOException
    //   163	176	328	java/io/IOException
    //   383	387	404	java/io/IOException
    //   394	399	404	java/io/IOException
    //   81	94	438	finally
    //   107	118	438	finally
    //   163	176	438	finally
    //   206	235	438	finally
    //   348	377	438	finally
    //   444	449	461	java/io/IOException
    //   454	459	461	java/io/IOException
    //   118	124	495	finally
    //   124	131	495	finally
    //   179	186	495	finally
    //   118	124	510	java/io/IOException
    //   124	131	510	java/io/IOException
    //   179	186	510	java/io/IOException
    //   81	94	519	java/io/FileNotFoundException
    //   107	118	519	java/io/FileNotFoundException
    //   163	176	519	java/io/FileNotFoundException
  }
  
  private void deleteMapFile(String paramString)
  {
    new File(getExternalFilesDir(), paramString).delete();
  }
  
  private File getExternalFilesDir()
  {
    return this.activicty.getExternalFilesDir(null);
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    decompressMapFile("easy.mbtiles");
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS) {
      decompressMapFile("hdedition.mbtiles");
    }
    ((DatabaseHelper)OpenHelperManager.getHelper(this.activicty, DatabaseHelper.class)).getWritableDatabase();
    paramVarArgs = new Intent(this.activicty, MainMenuActivity.class);
    this.activicty.startActivity(paramVarArgs);
    this.activicty.finish();
    return null;
  }
  
  protected void onPostExecute(Void paramVoid) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/MapTilesPreloaderTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */