package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.AsyncTask;

class c
  extends AsyncTask<Void, Void, Void>
{
  private a axS;
  private Context mContext;
  
  public c(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.axS = parama;
  }
  
  /* Error */
  protected Void doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/mobisystems/mobiscanner/controller/c:mContext	Landroid/content/Context;
    //   4: invokestatic 41	com/mobisystems/mobiscanner/common/d:aa	(Landroid/content/Context;)Ljava/io/File;
    //   7: astore 4
    //   9: new 43	java/io/FileOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   18: astore_1
    //   19: new 48	java/util/zip/ZipOutputStream
    //   22: dup
    //   23: new 50	java/io/BufferedOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 53	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 54	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 19	com/mobisystems/mobiscanner/controller/c:mContext	Landroid/content/Context;
    //   40: ldc 56
    //   42: aconst_null
    //   43: invokestatic 60	com/mobisystems/mobiscanner/common/d:f	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   46: astore 6
    //   48: aload 4
    //   50: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload 6
    //   57: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aload 4
    //   62: aload 5
    //   64: invokestatic 69	com/mobisystems/mobiscanner/common/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/zip/ZipOutputStream;)V
    //   67: aload_0
    //   68: getfield 19	com/mobisystems/mobiscanner/controller/c:mContext	Landroid/content/Context;
    //   71: ldc 71
    //   73: aconst_null
    //   74: invokestatic 60	com/mobisystems/mobiscanner/common/d:f	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   77: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: aload 4
    //   82: aload 5
    //   84: invokestatic 69	com/mobisystems/mobiscanner/common/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/zip/ZipOutputStream;)V
    //   87: aload_0
    //   88: getfield 19	com/mobisystems/mobiscanner/controller/c:mContext	Landroid/content/Context;
    //   91: ldc 73
    //   93: invokevirtual 79	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   96: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: aload 4
    //   101: aload 5
    //   103: invokestatic 69	com/mobisystems/mobiscanner/common/d:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/zip/ZipOutputStream;)V
    //   106: aload 5
    //   108: invokevirtual 82	java/util/zip/ZipOutputStream:close	()V
    //   111: invokestatic 88	com/mobisystems/mobiscanner/model/DocumentModel:Ip	()J
    //   114: lstore_2
    //   115: aload_1
    //   116: astore 4
    //   118: new 43	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 19	com/mobisystems/mobiscanner/controller/c:mContext	Landroid/content/Context;
    //   126: invokestatic 91	com/mobisystems/mobiscanner/common/d:ab	(Landroid/content/Context;)Ljava/io/File;
    //   129: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore 5
    //   134: aload 5
    //   136: lload_2
    //   137: invokestatic 97	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   140: invokevirtual 101	java/lang/String:getBytes	()[B
    //   143: invokevirtual 107	java/io/OutputStream:write	([B)V
    //   146: aload 5
    //   148: ifnull +8 -> 156
    //   151: aload 5
    //   153: invokevirtual 108	java/io/OutputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   163: aconst_null
    //   164: astore 4
    //   166: goto -157 -> 9
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 112	java/io/FileNotFoundException:printStackTrace	()V
    //   174: aconst_null
    //   175: astore_1
    //   176: goto -157 -> 19
    //   179: astore 4
    //   181: aload 4
    //   183: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   186: aload 5
    //   188: invokevirtual 82	java/util/zip/ZipOutputStream:close	()V
    //   191: goto -80 -> 111
    //   194: astore 4
    //   196: aload 4
    //   198: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   201: goto -90 -> 111
    //   204: astore 4
    //   206: aload 4
    //   208: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   211: aload 5
    //   213: invokevirtual 82	java/util/zip/ZipOutputStream:close	()V
    //   216: goto -105 -> 111
    //   219: astore 4
    //   221: goto -25 -> 196
    //   224: astore_1
    //   225: aload 5
    //   227: invokevirtual 82	java/util/zip/ZipOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore 5
    //   234: aload_1
    //   235: astore 4
    //   237: aload 5
    //   239: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   242: aload_1
    //   243: ifnull -87 -> 156
    //   246: aload_1
    //   247: invokevirtual 108	java/io/OutputStream:close	()V
    //   250: aconst_null
    //   251: areturn
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_1
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 108	java/io/OutputStream:close	()V
    //   270: aload_1
    //   271: athrow
    //   272: astore 4
    //   274: aload 4
    //   276: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   279: goto -49 -> 230
    //   282: astore 4
    //   284: aload 4
    //   286: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   289: goto -19 -> 270
    //   292: astore_1
    //   293: goto -40 -> 253
    //   296: astore 4
    //   298: goto -102 -> 196
    //   301: astore_1
    //   302: aload 5
    //   304: astore 4
    //   306: goto -46 -> 260
    //   309: astore 4
    //   311: aload 5
    //   313: astore_1
    //   314: aload 4
    //   316: astore 5
    //   318: goto -84 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	c
    //   0	321	1	paramVarArgs	Void[]
    //   114	23	2	l	long
    //   7	158	4	localObject1	Object
    //   179	3	4	localIOException1	java.io.IOException
    //   194	3	4	localIOException2	java.io.IOException
    //   204	3	4	localException	Exception
    //   219	1	4	localIOException3	java.io.IOException
    //   235	31	4	arrayOfVoid	Void[]
    //   272	3	4	localIOException4	java.io.IOException
    //   282	3	4	localIOException5	java.io.IOException
    //   296	1	4	localIOException6	java.io.IOException
    //   304	1	4	localObject2	Object
    //   309	6	4	localIOException7	java.io.IOException
    //   34	192	5	localObject3	Object
    //   232	80	5	localIOException8	java.io.IOException
    //   316	1	5	localIOException9	java.io.IOException
    //   46	10	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	9	158	java/io/IOException
    //   9	19	169	java/io/FileNotFoundException
    //   36	106	179	java/io/IOException
    //   186	191	194	java/io/IOException
    //   36	106	204	java/lang/Exception
    //   211	216	219	java/io/IOException
    //   36	106	224	finally
    //   181	186	224	finally
    //   206	211	224	finally
    //   118	134	232	java/io/IOException
    //   246	250	252	java/io/IOException
    //   118	134	259	finally
    //   237	242	259	finally
    //   225	230	272	java/io/IOException
    //   265	270	282	java/io/IOException
    //   151	156	292	java/io/IOException
    //   106	111	296	java/io/IOException
    //   134	146	301	finally
    //   134	146	309	java/io/IOException
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    if (this.axS != null) {
      this.axS.Em();
    }
  }
  
  public static abstract interface a
  {
    public abstract void Em();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */