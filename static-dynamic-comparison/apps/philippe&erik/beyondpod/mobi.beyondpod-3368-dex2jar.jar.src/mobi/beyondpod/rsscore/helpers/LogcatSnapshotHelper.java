package mobi.beyondpod.rsscore.helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class LogcatSnapshotHelper
  extends AsyncTask<Boolean, Void, Void>
{
  private Exception _LastException;
  private int _NumRecoredsToGet;
  private ProgressDialog _ProgressDialog;
  private String _SavePath;
  private ILogcatSnapshot _callback;
  
  public LogcatSnapshotHelper(Context paramContext, int paramInt, String paramString, ILogcatSnapshot paramILogcatSnapshot)
  {
    this._NumRecoredsToGet = paramInt;
    this._SavePath = paramString;
    this._callback = paramILogcatSnapshot;
    this._ProgressDialog = new ProgressDialog(paramContext);
    this._ProgressDialog.setIndeterminate(true);
    this._ProgressDialog.setMessage("Reading Android Log...");
    this._ProgressDialog.setCancelable(false);
  }
  
  /* Error */
  public Void doInBackground(Boolean... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 4
    //   14: aload 7
    //   16: astore_2
    //   17: aload_1
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 27	mobi/beyondpod/rsscore/helpers/LogcatSnapshotHelper:_SavePath	Ljava/lang/String;
    //   23: invokestatic 65	mobi/beyondpod/rsscore/helpers/FileUtils:DeleteFileIfExists	(Ljava/lang/String;)Z
    //   26: pop
    //   27: aload 7
    //   29: astore_2
    //   30: aload_1
    //   31: astore_3
    //   32: new 67	java/io/BufferedWriter
    //   35: dup
    //   36: new 69	java/io/FileWriter
    //   39: dup
    //   40: new 71	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 27	mobi/beyondpod/rsscore/helpers/LogcatSnapshotHelper:_SavePath	Ljava/lang/String;
    //   48: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: iconst_0
    //   52: invokespecial 77	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   55: sipush 8192
    //   58: invokespecial 80	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   61: astore_1
    //   62: new 82	java/io/BufferedReader
    //   65: dup
    //   66: new 84	java/io/InputStreamReader
    //   69: dup
    //   70: invokestatic 90	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   73: ldc 92
    //   75: iconst_1
    //   76: anewarray 94	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 25	mobi/beyondpod/rsscore/helpers/LogcatSnapshotHelper:_NumRecoredsToGet	I
    //   85: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 110	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   95: invokevirtual 116	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   98: invokespecial 119	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   101: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   104: astore_2
    //   105: aload_2
    //   106: invokevirtual 126	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnonnull +21 -> 132
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 129	java/io/BufferedWriter:close	()V
    //   122: aload_2
    //   123: ifnull +127 -> 250
    //   126: aload_2
    //   127: invokevirtual 130	java/io/BufferedReader:close	()V
    //   130: aconst_null
    //   131: areturn
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 133	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   137: aload_1
    //   138: ldc -121
    //   140: invokevirtual 133	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   143: goto -38 -> 105
    //   146: astore 5
    //   148: aload_2
    //   149: astore 4
    //   151: aload 4
    //   153: astore_2
    //   154: aload_1
    //   155: astore_3
    //   156: aload_0
    //   157: aload 5
    //   159: putfield 137	mobi/beyondpod/rsscore/helpers/LogcatSnapshotHelper:_LastException	Ljava/lang/Exception;
    //   162: aload_1
    //   163: ifnull +7 -> 170
    //   166: aload_1
    //   167: invokevirtual 129	java/io/BufferedWriter:close	()V
    //   170: aload 4
    //   172: ifnull -42 -> 130
    //   175: aload 4
    //   177: invokevirtual 130	java/io/BufferedReader:close	()V
    //   180: goto -50 -> 130
    //   183: astore_1
    //   184: goto -54 -> 130
    //   187: astore_1
    //   188: aload_3
    //   189: ifnull +7 -> 196
    //   192: aload_3
    //   193: invokevirtual 129	java/io/BufferedWriter:close	()V
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 130	java/io/BufferedReader:close	()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: goto -77 -> 130
    //   210: astore_2
    //   211: goto -7 -> 204
    //   214: astore 4
    //   216: aload 5
    //   218: astore_2
    //   219: aload_1
    //   220: astore_3
    //   221: aload 4
    //   223: astore_1
    //   224: goto -36 -> 188
    //   227: astore 4
    //   229: aload_1
    //   230: astore_3
    //   231: aload 4
    //   233: astore_1
    //   234: goto -46 -> 188
    //   237: astore 5
    //   239: aload 6
    //   241: astore_1
    //   242: goto -91 -> 151
    //   245: astore 5
    //   247: goto -96 -> 151
    //   250: goto -120 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	LogcatSnapshotHelper
    //   0	253	1	paramVarArgs	Boolean[]
    //   16	185	2	localObject1	Object
    //   210	1	2	localException1	Exception
    //   218	1	2	localException2	Exception
    //   18	213	3	localObject2	Object
    //   12	164	4	localObject3	Object
    //   214	8	4	localObject4	Object
    //   227	5	4	localObject5	Object
    //   9	1	5	localObject6	Object
    //   146	71	5	localException3	Exception
    //   237	1	5	localException4	Exception
    //   245	1	5	localException5	Exception
    //   3	237	6	localObject7	Object
    //   6	22	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   105	110	146	java/lang/Exception
    //   132	143	146	java/lang/Exception
    //   166	170	183	java/lang/Exception
    //   175	180	183	java/lang/Exception
    //   19	27	187	finally
    //   32	62	187	finally
    //   156	162	187	finally
    //   118	122	206	java/lang/Exception
    //   126	130	206	java/lang/Exception
    //   192	196	210	java/lang/Exception
    //   200	204	210	java/lang/Exception
    //   62	105	214	finally
    //   105	110	227	finally
    //   132	143	227	finally
    //   19	27	237	java/lang/Exception
    //   32	62	237	java/lang/Exception
    //   62	105	245	java/lang/Exception
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    if (this._ProgressDialog != null) {
      this._ProgressDialog.dismiss();
    }
    if (this._callback != null)
    {
      if ((this._LastException == null) && (FileUtils.Exists(this._SavePath))) {
        this._callback.SnapshotPrepared();
      }
    }
    else {
      return;
    }
    ILogcatSnapshot localILogcatSnapshot = this._callback;
    if (this._LastException == null) {}
    for (paramVoid = "N/A";; paramVoid = this._LastException.getMessage())
    {
      localILogcatSnapshot.SnapshotFailed(paramVoid);
      return;
    }
  }
  
  protected void onPreExecute()
  {
    this._ProgressDialog.show();
  }
  
  public static abstract interface ILogcatSnapshot
  {
    public abstract void SnapshotFailed(String paramString);
    
    public abstract void SnapshotPrepared();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/LogcatSnapshotHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */