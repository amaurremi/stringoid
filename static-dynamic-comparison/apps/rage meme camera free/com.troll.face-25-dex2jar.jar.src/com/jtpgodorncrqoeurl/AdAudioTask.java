package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.os.AsyncTask;

public class AdAudioTask
  extends AsyncTask
{
  private AdController a;
  private Context b;
  
  public AdAudioTask(AdController paramAdController, Context paramContext)
  {
    this.a = paramAdController;
    this.b = paramContext;
  }
  
  /* Error */
  private Integer a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: new 27	java/net/URL
    //   14: dup
    //   15: aload_1
    //   16: iconst_0
    //   17: aaload
    //   18: invokespecial 30	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 34	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 36	java/net/HttpURLConnection
    //   27: astore_1
    //   28: aload_1
    //   29: ldc 38
    //   31: invokevirtual 41	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: sipush 5000
    //   38: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload_1
    //   42: invokevirtual 48	java/net/HttpURLConnection:connect	()V
    //   45: aload_1
    //   46: invokevirtual 52	java/net/HttpURLConnection:getResponseCode	()I
    //   49: istore_2
    //   50: iload_2
    //   51: lookupswitch	default:+25->76, 200:+34->85, 404:+112->163
    //   76: aload_1
    //   77: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   80: iconst_0
    //   81: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: areturn
    //   85: aload_1
    //   86: invokevirtual 65	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   89: astore_3
    //   90: aload_0
    //   91: getfield 17	com/jtpgodorncrqoeurl/AdAudioTask:b	Landroid/content/Context;
    //   94: ldc 67
    //   96: iconst_0
    //   97: invokevirtual 73	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   100: astore 4
    //   102: sipush 128
    //   105: newarray <illegal type>
    //   107: astore 5
    //   109: aload_3
    //   110: aload 5
    //   112: invokevirtual 79	java/io/InputStream:read	([B)I
    //   115: istore_2
    //   116: iload_2
    //   117: ifle +25 -> 142
    //   120: aload 4
    //   122: aload 5
    //   124: iconst_0
    //   125: iload_2
    //   126: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   129: goto -20 -> 109
    //   132: astore_3
    //   133: aload_1
    //   134: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   137: iconst_2
    //   138: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: areturn
    //   142: aload_3
    //   143: invokevirtual 88	java/io/InputStream:close	()V
    //   146: aload 4
    //   148: invokevirtual 91	java/io/FileOutputStream:flush	()V
    //   151: aload 4
    //   153: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   156: goto -80 -> 76
    //   159: astore_3
    //   160: goto -84 -> 76
    //   163: aload_1
    //   164: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   167: iconst_4
    //   168: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: areturn
    //   172: astore_1
    //   173: aload 5
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   180: iconst_3
    //   181: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: areturn
    //   185: astore_1
    //   186: aload 6
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   193: iconst_3
    //   194: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: areturn
    //   198: astore 4
    //   200: aload_3
    //   201: astore_1
    //   202: aload 4
    //   204: astore_3
    //   205: aload_1
    //   206: invokevirtual 55	java/net/HttpURLConnection:disconnect	()V
    //   209: aload_3
    //   210: athrow
    //   211: astore_3
    //   212: goto -7 -> 205
    //   215: astore_3
    //   216: goto -27 -> 189
    //   219: astore_3
    //   220: goto -44 -> 176
    //   223: astore_1
    //   224: aload 4
    //   226: astore_1
    //   227: goto -94 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	AdAudioTask
    //   0	230	1	paramVarArgs	String[]
    //   49	77	2	i	int
    //   7	103	3	localInputStream	java.io.InputStream
    //   132	11	3	localMalformedURLException	java.net.MalformedURLException
    //   159	42	3	localIOException1	java.io.IOException
    //   204	6	3	localObject1	Object
    //   211	1	3	localObject2	Object
    //   215	1	3	localException	Exception
    //   219	1	3	localIOException2	java.io.IOException
    //   9	143	4	localFileOutputStream	java.io.FileOutputStream
    //   198	27	4	localObject3	Object
    //   1	173	5	arrayOfByte	byte[]
    //   4	183	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   28	50	132	java/net/MalformedURLException
    //   85	109	132	java/net/MalformedURLException
    //   109	116	132	java/net/MalformedURLException
    //   120	129	132	java/net/MalformedURLException
    //   142	156	132	java/net/MalformedURLException
    //   142	156	159	java/io/IOException
    //   11	28	172	java/io/IOException
    //   11	28	185	java/lang/Exception
    //   11	28	198	finally
    //   28	50	211	finally
    //   85	109	211	finally
    //   109	116	211	finally
    //   120	129	211	finally
    //   142	156	211	finally
    //   28	50	215	java/lang/Exception
    //   85	109	215	java/lang/Exception
    //   109	116	215	java/lang/Exception
    //   120	129	215	java/lang/Exception
    //   142	156	215	java/lang/Exception
    //   28	50	219	java/io/IOException
    //   85	109	219	java/io/IOException
    //   109	116	219	java/io/IOException
    //   120	129	219	java/io/IOException
    //   11	28	223	java/net/MalformedURLException
  }
  
  protected void onCancelled()
  {
    AdLog.d("LBAdController", "AdAudioTask cancelled");
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdAudioTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */