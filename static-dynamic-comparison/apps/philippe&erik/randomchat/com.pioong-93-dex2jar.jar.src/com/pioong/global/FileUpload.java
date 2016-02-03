package com.pioong.global;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.net.URL;

public class FileUpload
  implements Runnable
{
  public static final int DID_ERROR = 2;
  public static final int DID_SUCCEED = 1;
  protected Bitmap bmp;
  String boundary = "*****";
  private URL connectUrl = null;
  protected int h;
  protected Handler handler;
  String lineEnd = "\r\n";
  protected String mid;
  protected String room;
  protected String sid;
  String twoHyphens = "--";
  protected String url;
  protected int w;
  
  public FileUpload(Handler paramHandler, String paramString, Bitmap paramBitmap)
  {
    this.handler = paramHandler;
    this.url = paramString;
    this.bmp = paramBitmap;
    new Thread(this).start();
  }
  
  public FileUpload(Handler paramHandler, String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this.handler = paramHandler;
    this.url = paramString1;
    this.bmp = paramBitmap;
    this.sid = paramString2;
    this.mid = paramString4;
    this.room = paramString3;
    this.w = paramInt1;
    this.h = paramInt2;
    this.url = (this.url + "?sid=" + this.sid + "&room=" + this.room + "&mid=" + this.mid + "&w=" + Integer.toString(this.w) + "&h=" + Integer.toString(this.h));
    new Thread(this).start();
  }
  
  /* Error */
  private String HttpFileUpload()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: new 111	java/net/URL
    //   4: dup
    //   5: aload_0
    //   6: getfield 50	com/pioong/global/FileUpload:url	Ljava/lang/String;
    //   9: invokespecial 112	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: putfield 34	com/pioong/global/FileUpload:connectUrl	Ljava/net/URL;
    //   15: aload_0
    //   16: getfield 34	com/pioong/global/FileUpload:connectUrl	Ljava/net/URL;
    //   19: invokevirtual 116	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 118	java/net/HttpURLConnection
    //   25: astore_3
    //   26: aload_3
    //   27: iconst_1
    //   28: invokevirtual 122	java/net/HttpURLConnection:setDoInput	(Z)V
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 125	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   36: aload_3
    //   37: iconst_0
    //   38: invokevirtual 128	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   41: aload_3
    //   42: ldc -126
    //   44: invokevirtual 133	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: ldc -121
    //   50: ldc -119
    //   52: invokevirtual 141	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_3
    //   56: ldc -113
    //   58: new 74	java/lang/StringBuilder
    //   61: dup
    //   62: ldc -111
    //   64: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 46	com/pioong/global/FileUpload:boundary	Ljava/lang/String;
    //   71: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 141	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: new 147	java/io/DataOutputStream
    //   83: dup
    //   84: aload_3
    //   85: invokevirtual 151	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   88: invokespecial 154	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   91: astore_2
    //   92: aload_2
    //   93: new 74	java/lang/StringBuilder
    //   96: dup
    //   97: aload_0
    //   98: getfield 42	com/pioong/global/FileUpload:twoHyphens	Ljava/lang/String;
    //   101: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 46	com/pioong/global/FileUpload:boundary	Ljava/lang/String;
    //   111: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: getfield 38	com/pioong/global/FileUpload:lineEnd	Ljava/lang/String;
    //   118: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokevirtual 157	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   127: aload_2
    //   128: new 74	java/lang/StringBuilder
    //   131: dup
    //   132: ldc -97
    //   134: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 38	com/pioong/global/FileUpload:lineEnd	Ljava/lang/String;
    //   141: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 157	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   150: aload_2
    //   151: aload_0
    //   152: getfield 38	com/pioong/global/FileUpload:lineEnd	Ljava/lang/String;
    //   155: invokevirtual 157	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   158: new 161	java/io/ByteArrayOutputStream
    //   161: dup
    //   162: invokespecial 162	java/io/ByteArrayOutputStream:<init>	()V
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 52	com/pioong/global/FileUpload:bmp	Landroid/graphics/Bitmap;
    //   171: getstatic 168	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   174: bipush 90
    //   176: aload 4
    //   178: invokevirtual 174	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   181: pop
    //   182: aload 4
    //   184: invokevirtual 178	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   187: astore 4
    //   189: aload_2
    //   190: aload 4
    //   192: iconst_0
    //   193: aload 4
    //   195: arraylength
    //   196: invokevirtual 182	java/io/DataOutputStream:write	([BII)V
    //   199: aload_2
    //   200: aload_0
    //   201: getfield 38	com/pioong/global/FileUpload:lineEnd	Ljava/lang/String;
    //   204: invokevirtual 157	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   207: aload_2
    //   208: new 74	java/lang/StringBuilder
    //   211: dup
    //   212: aload_0
    //   213: getfield 42	com/pioong/global/FileUpload:twoHyphens	Ljava/lang/String;
    //   216: invokestatic 80	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   219: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload_0
    //   223: getfield 46	com/pioong/global/FileUpload:boundary	Ljava/lang/String;
    //   226: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 42	com/pioong/global/FileUpload:twoHyphens	Ljava/lang/String;
    //   233: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_0
    //   237: getfield 38	com/pioong/global/FileUpload:lineEnd	Ljava/lang/String;
    //   240: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 157	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   249: ldc -72
    //   251: ldc -70
    //   253: invokestatic 192	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   256: pop
    //   257: aload_2
    //   258: invokevirtual 195	java/io/DataOutputStream:flush	()V
    //   261: aload_3
    //   262: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   265: astore_3
    //   266: new 201	java/lang/StringBuffer
    //   269: dup
    //   270: invokespecial 202	java/lang/StringBuffer:<init>	()V
    //   273: astore 4
    //   275: aload_3
    //   276: invokevirtual 208	java/io/InputStream:read	()I
    //   279: istore_1
    //   280: iload_1
    //   281: iconst_m1
    //   282: if_icmpne +37 -> 319
    //   285: aload 4
    //   287: invokevirtual 209	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   290: astore_3
    //   291: ldc -72
    //   293: new 74	java/lang/StringBuilder
    //   296: dup
    //   297: ldc -45
    //   299: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_3
    //   303: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 192	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: aload_2
    //   314: invokevirtual 214	java/io/DataOutputStream:close	()V
    //   317: aload_3
    //   318: areturn
    //   319: aload 4
    //   321: iload_1
    //   322: i2c
    //   323: invokevirtual 217	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   326: pop
    //   327: goto -52 -> 275
    //   330: astore_2
    //   331: ldc -72
    //   333: new 74	java/lang/StringBuilder
    //   336: dup
    //   337: ldc -37
    //   339: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_2
    //   343: invokevirtual 222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   346: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 225	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: new 109	java/lang/Exception
    //   359: dup
    //   360: invokespecial 226	java/lang/Exception:<init>	()V
    //   363: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	FileUpload
    //   279	43	1	i	int
    //   91	223	2	localDataOutputStream	java.io.DataOutputStream
    //   330	13	2	localException	Exception
    //   25	293	3	localObject1	Object
    //   165	155	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	275	330	java/lang/Exception
    //   275	280	330	java/lang/Exception
    //   285	317	330	java/lang/Exception
    //   319	327	330	java/lang/Exception
  }
  
  public void run()
  {
    try
    {
      Object localObject = HttpFileUpload();
      localObject = Message.obtain(this.handler, 1, localObject);
      this.handler.sendMessage((Message)localObject);
      return;
    }
    catch (Exception localException)
    {
      Message localMessage = Message.obtain(this.handler, 2, "");
      this.handler.sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/global/FileUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */