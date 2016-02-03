package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class at
  extends bb
{
  private long[] aDR;
  
  public at(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDR = paramBundle.getLongArray("PAGES");
  }
  
  /* Error */
  private File Y(long paramLong)
  {
    // Byte code:
    //   0: new 31	com/mobisystems/mobiscanner/model/DocumentModel
    //   3: dup
    //   4: invokespecial 34	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: lload_1
    //   12: invokevirtual 38	com/mobisystems/mobiscanner/model/DocumentModel:aj	(J)Lcom/mobisystems/mobiscanner/model/c;
    //   15: astore 4
    //   17: aload 5
    //   19: lload_1
    //   20: invokevirtual 42	com/mobisystems/mobiscanner/model/DocumentModel:aq	(J)Lcom/mobisystems/mobiscanner/image/Image;
    //   23: astore 5
    //   25: aload 4
    //   27: ifnull +238 -> 265
    //   30: aload 5
    //   32: ifnull +233 -> 265
    //   35: aload 5
    //   37: invokevirtual 48	com/mobisystems/mobiscanner/image/Image:HY	()Lcom/mobisystems/mobiscanner/image/Image$ImageStreamType;
    //   40: invokevirtual 54	com/mobisystems/mobiscanner/image/Image$ImageStreamType:If	()Ljava/lang/String;
    //   43: astore 6
    //   45: new 56	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 63	com/mobisystems/mobiscanner/model/c:IS	()Lcom/mobisystems/mobiscanner/model/b;
    //   57: invokevirtual 68	com/mobisystems/mobiscanner/model/b:getName	()Ljava/lang/String;
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 74
    //   65: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 4
    //   70: invokevirtual 78	com/mobisystems/mobiscanner/model/c:IU	()I
    //   73: invokestatic 84	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 4
    //   89: aload 5
    //   91: invokevirtual 91	com/mobisystems/mobiscanner/image/Image:HZ	()Ljava/io/BufferedInputStream;
    //   94: astore 7
    //   96: new 93	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 97	com/mobisystems/mobiscanner/controller/at:mContext	Landroid/content/Context;
    //   104: invokestatic 103	com/mobisystems/mobiscanner/common/d:ad	(Landroid/content/Context;)Ljava/io/File;
    //   107: aload 4
    //   109: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   112: astore 4
    //   114: new 108	java/io/BufferedOutputStream
    //   117: dup
    //   118: new 110	java/io/FileOutputStream
    //   121: dup
    //   122: aload 4
    //   124: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: invokespecial 116	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   130: astore 6
    //   132: aload 6
    //   134: astore 10
    //   136: aload 7
    //   138: astore 9
    //   140: aload 4
    //   142: astore 8
    //   144: aload 7
    //   146: aload 6
    //   148: aload_0
    //   149: invokestatic 120	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   152: aload 6
    //   154: astore 10
    //   156: aload 7
    //   158: astore 9
    //   160: aload 4
    //   162: astore 8
    //   164: aload 7
    //   166: invokevirtual 125	java/io/InputStream:close	()V
    //   169: aload 6
    //   171: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   174: aload 5
    //   176: invokevirtual 130	com/mobisystems/mobiscanner/image/Image:HW	()Lcom/mobisystems/mobiscanner/image/Image$a;
    //   179: invokevirtual 136	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   182: aload 5
    //   184: invokevirtual 139	com/mobisystems/mobiscanner/image/Image:HX	()Lcom/mobisystems/mobiscanner/image/Image$a;
    //   187: invokevirtual 136	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   190: if_acmpeq +34 -> 224
    //   193: aload 5
    //   195: invokevirtual 48	com/mobisystems/mobiscanner/image/Image:HY	()Lcom/mobisystems/mobiscanner/image/Image$ImageStreamType;
    //   198: getstatic 143	com/mobisystems/mobiscanner/image/Image$ImageStreamType:aHq	Lcom/mobisystems/mobiscanner/image/Image$ImageStreamType;
    //   201: invokevirtual 147	com/mobisystems/mobiscanner/image/Image$ImageStreamType:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +20 -> 224
    //   207: aload 4
    //   209: invokevirtual 150	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   212: aload 5
    //   214: invokevirtual 130	com/mobisystems/mobiscanner/image/Image:HW	()Lcom/mobisystems/mobiscanner/image/Image$a;
    //   217: invokevirtual 136	com/mobisystems/mobiscanner/image/Image$a:Ic	()Lcom/mobisystems/mobiscanner/image/ImageOrientation;
    //   220: invokestatic 153	com/mobisystems/mobiscanner/image/Image:a	(Ljava/lang/String;Lcom/mobisystems/mobiscanner/image/ImageOrientation;)Z
    //   223: pop
    //   224: iconst_1
    //   225: istore_3
    //   226: iconst_0
    //   227: ifeq +11 -> 238
    //   230: new 155	java/lang/NullPointerException
    //   233: dup
    //   234: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   237: athrow
    //   238: iconst_0
    //   239: ifeq +11 -> 250
    //   242: new 155	java/lang/NullPointerException
    //   245: dup
    //   246: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   249: athrow
    //   250: iload_3
    //   251: ifne +391 -> 642
    //   254: aload 4
    //   256: ifnull +9 -> 265
    //   259: aload 4
    //   261: invokevirtual 160	java/io/File:delete	()Z
    //   264: pop
    //   265: aconst_null
    //   266: areturn
    //   267: astore 5
    //   269: aconst_null
    //   270: astore 6
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 6
    //   277: astore 10
    //   279: aload 7
    //   281: astore 9
    //   283: aload 4
    //   285: astore 8
    //   287: aload_0
    //   288: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   291: ldc -90
    //   293: aload 5
    //   295: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   298: aload 7
    //   300: ifnull +8 -> 308
    //   303: aload 7
    //   305: invokevirtual 125	java/io/InputStream:close	()V
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   318: aload 4
    //   320: ifnull -55 -> 265
    //   323: goto -64 -> 259
    //   326: astore 5
    //   328: aconst_null
    //   329: astore 6
    //   331: aconst_null
    //   332: astore 4
    //   334: aload 7
    //   336: ifnull +8 -> 344
    //   339: aload 7
    //   341: invokevirtual 125	java/io/InputStream:close	()V
    //   344: aload 6
    //   346: ifnull +8 -> 354
    //   349: aload 6
    //   351: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   354: aload 4
    //   356: ifnull +9 -> 365
    //   359: aload 4
    //   361: invokevirtual 160	java/io/File:delete	()Z
    //   364: pop
    //   365: aload 5
    //   367: athrow
    //   368: astore 7
    //   370: aload_0
    //   371: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   374: ldc -82
    //   376: aload 7
    //   378: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -37 -> 344
    //   384: astore 6
    //   386: aload_0
    //   387: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   390: ldc -80
    //   392: aload 6
    //   394: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   397: goto -43 -> 354
    //   400: astore 5
    //   402: aload_0
    //   403: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   406: ldc -82
    //   408: aload 5
    //   410: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -105 -> 308
    //   416: astore 5
    //   418: aload_0
    //   419: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   422: ldc -80
    //   424: aload 5
    //   426: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -111 -> 318
    //   432: astore 4
    //   434: aconst_null
    //   435: astore 6
    //   437: aconst_null
    //   438: astore 4
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 125	java/io/InputStream:close	()V
    //   450: aload 6
    //   452: ifnull +8 -> 460
    //   455: aload 6
    //   457: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   460: aload 4
    //   462: ifnull -197 -> 265
    //   465: goto -206 -> 259
    //   468: astore 5
    //   470: aload_0
    //   471: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   474: ldc -82
    //   476: aload 5
    //   478: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -31 -> 450
    //   484: astore 5
    //   486: aload_0
    //   487: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   490: ldc -80
    //   492: aload 5
    //   494: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   497: goto -37 -> 460
    //   500: astore 5
    //   502: aload_0
    //   503: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   506: ldc -82
    //   508: aload 5
    //   510: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   513: goto -275 -> 238
    //   516: astore 5
    //   518: aload_0
    //   519: getfield 164	com/mobisystems/mobiscanner/controller/at:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   522: ldc -80
    //   524: aload 5
    //   526: invokevirtual 172	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -281 -> 250
    //   534: astore 5
    //   536: aconst_null
    //   537: astore 6
    //   539: goto -205 -> 334
    //   542: astore 5
    //   544: aload 10
    //   546: astore 6
    //   548: aload 9
    //   550: astore 7
    //   552: aload 8
    //   554: astore 4
    //   556: goto -222 -> 334
    //   559: astore 5
    //   561: aconst_null
    //   562: astore 7
    //   564: goto -230 -> 334
    //   567: astore 5
    //   569: aconst_null
    //   570: astore 6
    //   572: aconst_null
    //   573: astore 7
    //   575: goto -241 -> 334
    //   578: astore 5
    //   580: aconst_null
    //   581: astore 6
    //   583: goto -143 -> 440
    //   586: astore 5
    //   588: goto -148 -> 440
    //   591: astore 5
    //   593: aconst_null
    //   594: astore 7
    //   596: goto -156 -> 440
    //   599: astore 5
    //   601: aconst_null
    //   602: astore 6
    //   604: aconst_null
    //   605: astore 7
    //   607: goto -167 -> 440
    //   610: astore 5
    //   612: aconst_null
    //   613: astore 6
    //   615: goto -340 -> 275
    //   618: astore 5
    //   620: goto -345 -> 275
    //   623: astore 5
    //   625: aconst_null
    //   626: astore 7
    //   628: goto -353 -> 275
    //   631: astore 5
    //   633: aconst_null
    //   634: astore 6
    //   636: aconst_null
    //   637: astore 7
    //   639: goto -364 -> 275
    //   642: aload 4
    //   644: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	at
    //   0	645	1	paramLong	long
    //   225	306	3	i	int
    //   15	345	4	localObject1	Object
    //   432	1	4	localInterruptedException1	InterruptedException
    //   438	205	4	localObject2	Object
    //   7	206	5	localObject3	Object
    //   267	27	5	localIOException1	IOException
    //   326	40	5	localObject4	Object
    //   400	9	5	localIOException2	IOException
    //   416	9	5	localIOException3	IOException
    //   468	9	5	localIOException4	IOException
    //   484	9	5	localIOException5	IOException
    //   500	9	5	localIOException6	IOException
    //   516	9	5	localIOException7	IOException
    //   534	1	5	localObject5	Object
    //   542	1	5	localObject6	Object
    //   559	1	5	localObject7	Object
    //   567	1	5	localObject8	Object
    //   578	1	5	localInterruptedException2	InterruptedException
    //   586	1	5	localInterruptedException3	InterruptedException
    //   591	1	5	localInterruptedException4	InterruptedException
    //   599	1	5	localInterruptedException5	InterruptedException
    //   610	1	5	localIOException8	IOException
    //   618	1	5	localIOException9	IOException
    //   623	1	5	localIOException10	IOException
    //   631	1	5	localIOException11	IOException
    //   43	307	6	localObject9	Object
    //   384	9	6	localIOException12	IOException
    //   435	200	6	localObject10	Object
    //   94	246	7	localBufferedInputStream1	java.io.BufferedInputStream
    //   368	78	7	localIOException13	IOException
    //   550	88	7	localObject11	Object
    //   142	411	8	localObject12	Object
    //   138	411	9	localBufferedInputStream2	java.io.BufferedInputStream
    //   134	411	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   96	114	267	java/io/IOException
    //   96	114	326	finally
    //   339	344	368	java/io/IOException
    //   349	354	384	java/io/IOException
    //   303	308	400	java/io/IOException
    //   313	318	416	java/io/IOException
    //   96	114	432	java/lang/InterruptedException
    //   445	450	468	java/io/IOException
    //   455	460	484	java/io/IOException
    //   230	238	500	java/io/IOException
    //   242	250	516	java/io/IOException
    //   114	132	534	finally
    //   144	152	542	finally
    //   164	169	542	finally
    //   287	298	542	finally
    //   169	174	559	finally
    //   174	224	567	finally
    //   114	132	578	java/lang/InterruptedException
    //   144	152	586	java/lang/InterruptedException
    //   164	169	586	java/lang/InterruptedException
    //   169	174	591	java/lang/InterruptedException
    //   174	224	599	java/lang/InterruptedException
    //   114	132	610	java/io/IOException
    //   144	152	618	java/io/IOException
    //   164	169	618	java/io/IOException
    //   169	174	623	java/io/IOException
    //   174	224	631	java/io/IOException
  }
  
  protected Bundle c(Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        this.mLog.dl("Async page export operation started, number of pages=" + this.aDR.length);
        this.aGa = OperationStatus.avG;
        int i;
        try
        {
          paramVarArgs = d.ad(this.mContext);
          if (paramVarArgs == null) {
            break label277;
          }
          this.aGa = OperationStatus.avH;
          arrayOfString = new String[this.aDR.length];
          i = 0;
          paramVarArgs = arrayOfString;
          if (i < this.aDR.length)
          {
            this.mLog.dl("Start exporting of page ID:" + this.aDR[i]);
            this.aGc.getAndIncrement();
            e(Integer.valueOf(0));
            paramVarArgs = Y(this.aDR[i]);
            if (paramVarArgs == null)
            {
              this.aGa = OperationStatus.avG;
              this.mLog.A("Error exporting of page ID:" + this.aDR[i]);
              if (!isCancelled()) {
                break label270;
              }
              paramVarArgs = arrayOfString;
            }
          }
          else
          {
            this.aFZ.putStringArray("EXPORTED_FILES", paramVarArgs);
            paramVarArgs = this.aFZ;
            return paramVarArgs;
          }
        }
        catch (IOException paramVarArgs)
        {
          String[] arrayOfString;
          this.mLog.g("IO Exception exporting pages", paramVarArgs);
          paramVarArgs = null;
          continue;
          arrayOfString[i] = paramVarArgs.getAbsolutePath();
          this.mLog.dl("Finish exporting of page ID:" + this.aDR[i]);
          continue;
        }
        i += 1;
      }
      finally {}
      label270:
      continue;
      label277:
      paramVarArgs = null;
    }
  }
  
  protected void o(Bundle paramBundle)
  {
    this.mLog.dl("Async PDF operation onCancelled");
    String[] arrayOfString = paramBundle.getStringArray("EXPORTED_FILES");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str != null) {
          new File(str).delete();
        }
        i += 1;
      }
    }
    super.o(paramBundle);
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aDR.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */