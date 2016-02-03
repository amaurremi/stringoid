package com.mobisystems.pdf;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobisystems.pdf.form.PDFForm;
import com.mobisystems.pdf.signatures.PDFCertificateStoreImpl;
import com.mobisystems.pdf.signatures.PDFSignatureCache;
import com.mobisystems.pdf.signatures.PDFTimeStampServerImpl;
import java.io.File;
import java.io.InputStream;

public abstract class PDFDocument
  implements Parcelable
{
  static final int FF_ALL_CAPS = 65536;
  static final int FF_FIXED_PITCH = 1;
  static final int FF_FORCE_BOLD = 262144;
  static final int FF_ITALIC = 64;
  static final int FF_NONSYMBOLIC = 32;
  static final int FF_SCRIPT = 8;
  static final int FF_SERIF = 2;
  static final int FF_SMALL_CAPS = 131072;
  static final int FF_SYMBOLIC = 4;
  static final String FN_COURIER = "Courirer";
  static final String FN_COURIER_BOLD = "Courirer-Bold";
  static final String FN_COURIER_BOLD_OBLIQUE = "Courirer-BoldOblique";
  static final String FN_COURIER_OBLIQUE = "Courirer-Oblique";
  static final String FN_HELVETICA = "Helvetica";
  static final String FN_HELVETICA_BOLD = "Helvetica-Bold";
  static final String FN_HELVETICA_BOLD_OBLIQUE = "Helvetica-BoldOblique";
  static final String FN_HELVETICA_OBLIQUE = "Helvetica-Oblique";
  static final String FN_SYMBOL = "Symbol";
  static final String FN_TIMES_BOLD = "Times-Bold";
  static final String FN_TIMES_BOLD_ITALIC = "Times-BoldItalic";
  static final String FN_TIMES_ITALIC = "Times-Italic";
  static final String FN_TIMES_ROMAN = "TimesRoman";
  static final String FN_ZAPF_DINGBATS = "ZapfDingbats";
  public static final long INVALID_HANDLE = 0L;
  protected static final String LIBRARY_NAME = "MSPDF";
  protected static PDFCertificateStoreImpl _certificateStore = null;
  protected static boolean _libraryLoaded = false;
  protected static PDFTimeStampServerImpl _tss = null;
  protected long _handle = 0L;
  protected String _path;
  
  protected PDFDocument(Parcel paramParcel)
  {
    long l = paramParcel.readLong();
    this._path = paramParcel.readString();
    PDFError.throwError(initFromHandle(l));
  }
  
  protected PDFDocument(String paramString)
  {
    loadLibrary();
    setSignatureCallbacks();
    PDFError.throwError(init(paramString, Runtime.getRuntime().maxMemory() / 8L));
    PDFError.throwError(loadSignatureInfo());
    this._path = paramString;
  }
  
  private native int loadFullPermissionsNative();
  
  protected static void loadLibrary()
  {
    try
    {
      loadLibrary("MSPDF");
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static void loadLibrary(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 87	com/mobisystems/pdf/PDFDocument:_libraryLoaded	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokestatic 152	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   19: iconst_1
    //   20: putstatic 87	com/mobisystems/pdf/PDFDocument:_libraryLoaded	Z
    //   23: goto -12 -> 11
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramString	String
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	26	finally
    //   15	23	26	finally
  }
  
  private native int loadReadOnlyPermissionsNative();
  
  private native int loadSignatureInfo();
  
  private native int popStateNative();
  
  private native int pushStateNative();
  
  /* Error */
  static void setSignatureCallbacks()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 89	com/mobisystems/pdf/PDFDocument:_certificateStore	Lcom/mobisystems/pdf/signatures/PDFCertificateStoreImpl;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +13 -> 21
    //   11: new 159	com/mobisystems/pdf/signatures/PDFCertificateStoreImpl
    //   14: dup
    //   15: invokespecial 160	com/mobisystems/pdf/signatures/PDFCertificateStoreImpl:<init>	()V
    //   18: putstatic 89	com/mobisystems/pdf/PDFDocument:_certificateStore	Lcom/mobisystems/pdf/signatures/PDFCertificateStoreImpl;
    //   21: getstatic 91	com/mobisystems/pdf/PDFDocument:_tss	Lcom/mobisystems/pdf/signatures/PDFTimeStampServerImpl;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +13 -> 39
    //   29: new 162	com/mobisystems/pdf/signatures/PDFTimeStampServerImpl
    //   32: dup
    //   33: invokespecial 163	com/mobisystems/pdf/signatures/PDFTimeStampServerImpl:<init>	()V
    //   36: putstatic 91	com/mobisystems/pdf/PDFDocument:_tss	Lcom/mobisystems/pdf/signatures/PDFTimeStampServerImpl;
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: astore_0
    //   44: ldc -91
    //   46: aload_0
    //   47: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   50: pop
    //   51: goto -30 -> 21
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    //   60: astore_0
    //   61: ldc -83
    //   63: aload_0
    //   64: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   67: pop
    //   68: goto -29 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	20	0	localObject1	Object
    //   43	4	0	localException1	Exception
    //   54	5	0	localObject2	Object
    //   60	4	0	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	21	43	java/lang/Exception
    //   3	7	54	finally
    //   11	21	54	finally
    //   21	25	54	finally
    //   29	39	54	finally
    //   44	51	54	finally
    //   61	68	54	finally
    //   29	39	60	java/lang/Exception
  }
  
  protected native void close();
  
  public native int decrementLockCount(long paramLong);
  
  public int describeContents()
  {
    return 0;
  }
  
  protected native int destroy();
  
  protected void finalize()
  {
    destroy();
    super.finalize();
  }
  
  public abstract String getCachePath();
  
  public PDFForm getForm()
  {
    return new PDFForm(this);
  }
  
  public long getHandle()
  {
    return this._handle;
  }
  
  public String getPath()
  {
    return this._path;
  }
  
  public PDFSignatureCache getSignatureCache()
  {
    return new PDFSignatureCache(this);
  }
  
  public abstract InputStream getSystemCMapStream(String paramString);
  
  public String getSystemFontPath(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) || ((paramInt & 0x4) != 0)) {
      return "/system/fonts/DroidSansFallback.ttf";
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if ("Helvetica".equals(paramString)) {
        return "/system/fonts/Roboto-Regular.ttf";
      }
      if ("Helvetica-Oblique".equals(paramString)) {
        return "/system/fonts/Roboto-Italic.ttf";
      }
      if ("Helvetica-Bold".equals(paramString)) {
        return "/system/fonts/Roboto-Bold.ttf";
      }
      if ("Helvetica-BoldOblique".equals(paramString)) {
        return "/system/fonts/Roboto-BoldItalic.ttf";
      }
    }
    else
    {
      if (("Helvetica".equals(paramString)) || ("Helvetica-Oblique".equals(paramString))) {
        return "/system/fonts/DroidSans.ttf";
      }
      if (("Helvetica-Bold".equals(paramString)) || ("Helvetica-BoldOblique".equals(paramString))) {
        return "/system/fonts/DroidSans-Bold.ttf";
      }
    }
    if ("TimesRoman".equals(paramString)) {
      return "/system/fonts/DroidSerif-Regular.ttf";
    }
    if ("Courirer".equals(paramString)) {
      return "/system/fonts/DroidSansMono.ttf";
    }
    if ("Times-Italic".equals(paramString)) {
      return "/system/fonts/DroidSerif-Italic.ttf";
    }
    if ("Courirer-Oblique".equals(paramString)) {
      return "/system/fonts/DroidSans.ttf";
    }
    if ("Times-Bold".equals(paramString)) {
      return "/system/fonts/DroidSerif-Bold.ttf";
    }
    if ("Helvetica-Bold".equals(paramString)) {
      return "/system/fonts/DroidSans-Bold.ttf";
    }
    if ("Courirer-Bold".equals(paramString)) {
      return "/system/fonts/DroidSansMono.ttf";
    }
    if ("Times-BoldItalic".equals(paramString)) {
      return "/system/fonts/DroidSerif-BoldItalic.ttf";
    }
    if ("Courirer-BoldOblique".equals(paramString)) {
      return "/system/fonts/DroidSans-Bold.ttf";
    }
    if ((paramInt & 0x2) != 0)
    {
      switch (0x40040 & paramInt)
      {
      default: 
        return "/system/fonts/DroidSerif-Regular.ttf";
      case 64: 
        return "/system/fonts/DroidSerif-Italic.ttf";
      case 262144: 
        return "/system/fonts/DroidSerif-Bold.ttf";
      }
      return "/system/fonts/DroidSerif-BoldItalic.ttf";
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      if ((paramInt & 0x40000) != 0)
      {
        if ((paramInt & 0x48) != 0) {
          return "/system/fonts/Roboto-BoldItalic.ttf";
        }
        return "/system/fonts/Roboto-Bold.ttf";
      }
      if ((paramInt & 0x48) != 0) {
        return "/system/fonts/Roboto-Italic.ttf";
      }
      return "/system/fonts/Roboto-Regular.ttf";
    }
    if ((paramInt & 0x40000) != 0) {
      return "/system/fonts/DroidSans-Bold.ttf";
    }
    return "/system/fonts/DroidSans.ttf";
  }
  
  public abstract File getTempDir();
  
  public native int incrementLockCount(long paramLong);
  
  protected native int init(String paramString, long paramLong);
  
  protected native int initFromHandle(long paramLong);
  
  public native boolean isModified();
  
  public void loadFullPermissions()
  {
    PDFError.throwError(loadFullPermissionsNative());
  }
  
  public native int loadPageCount();
  
  public void loadReadOnlyPermissions()
  {
    PDFError.throwError(loadReadOnlyPermissionsNative());
  }
  
  public abstract void onLock();
  
  public abstract void onUnlock();
  
  public native int pageCount();
  
  public void popState()
  {
    PDFError.throwError(popStateNative());
  }
  
  public void pushState()
  {
    PDFError.throwError(pushStateNative());
  }
  
  protected native int reopen(String paramString);
  
  public native boolean requiresPassword();
  
  /* Error */
  public void save(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 6
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_1
    //   19: ifnonnull +80 -> 99
    //   22: iconst_1
    //   23: istore_3
    //   24: iload_3
    //   25: ifeq +323 -> 348
    //   28: ldc_w 266
    //   31: ldc_w 268
    //   34: aload_0
    //   35: invokevirtual 270	com/mobisystems/pdf/PDFDocument:getTempDir	()Ljava/io/File;
    //   38: invokestatic 276	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   41: astore 9
    //   43: aload_0
    //   44: aload 9
    //   46: invokevirtual 279	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: invokevirtual 282	com/mobisystems/pdf/PDFDocument:saveNative	(Ljava/lang/String;)I
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq +77 -> 131
    //   57: aload 9
    //   59: invokevirtual 285	java/io/File:delete	()Z
    //   62: pop
    //   63: aconst_null
    //   64: astore 4
    //   66: aload 8
    //   68: astore_1
    //   69: aload 4
    //   71: astore 5
    //   73: aload_1
    //   74: astore 7
    //   76: iload_2
    //   77: invokestatic 120	com/mobisystems/pdf/PDFError:throwError	(I)V
    //   80: aload 4
    //   82: ifnull +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 289	java/nio/channels/FileChannel:close	()V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 289	java/nio/channels/FileChannel:close	()V
    //   98: return
    //   99: new 272	java/io/File
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 294	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   110: new 272	java/io/File
    //   113: dup
    //   114: aload_0
    //   115: getfield 110	com/mobisystems/pdf/PDFDocument:_path	Ljava/lang/String;
    //   118: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 294	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   124: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: istore_3
    //   128: goto -104 -> 24
    //   131: aload_0
    //   132: invokevirtual 295	com/mobisystems/pdf/PDFDocument:close	()V
    //   135: new 272	java/io/File
    //   138: dup
    //   139: aload_0
    //   140: getfield 110	com/mobisystems/pdf/PDFDocument:_path	Ljava/lang/String;
    //   143: invokespecial 291	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore 8
    //   148: aload 8
    //   150: invokevirtual 285	java/io/File:delete	()Z
    //   153: ifne +83 -> 236
    //   156: new 116	com/mobisystems/pdf/PDFError
    //   159: dup
    //   160: sipush 64543
    //   163: invokespecial 297	com/mobisystems/pdf/PDFError:<init>	(I)V
    //   166: athrow
    //   167: astore 6
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 5
    //   174: astore_1
    //   175: aload 4
    //   177: astore 5
    //   179: aload_1
    //   180: astore 7
    //   182: ldc_w 299
    //   185: aload 6
    //   187: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aload 4
    //   193: astore 5
    //   195: aload_1
    //   196: astore 7
    //   198: new 116	com/mobisystems/pdf/PDFError
    //   201: dup
    //   202: sipush 64543
    //   205: invokespecial 297	com/mobisystems/pdf/PDFError:<init>	(I)V
    //   208: athrow
    //   209: astore_1
    //   210: aload 7
    //   212: astore 4
    //   214: aload 5
    //   216: ifnull +8 -> 224
    //   219: aload 5
    //   221: invokevirtual 289	java/nio/channels/FileChannel:close	()V
    //   224: aload 4
    //   226: ifnull +8 -> 234
    //   229: aload 4
    //   231: invokevirtual 289	java/nio/channels/FileChannel:close	()V
    //   234: aload_1
    //   235: athrow
    //   236: new 301	java/io/FileInputStream
    //   239: dup
    //   240: aload 9
    //   242: invokespecial 304	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   245: astore_1
    //   246: new 306	java/io/FileOutputStream
    //   249: dup
    //   250: aload 8
    //   252: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   255: astore 8
    //   257: aload_1
    //   258: invokevirtual 311	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   261: astore_1
    //   262: aload 7
    //   264: astore 5
    //   266: aload 6
    //   268: astore 4
    //   270: aload 8
    //   272: invokevirtual 312	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   275: astore 6
    //   277: aload 6
    //   279: astore 5
    //   281: aload 6
    //   283: astore 4
    //   285: aload_1
    //   286: lconst_0
    //   287: aload_1
    //   288: invokevirtual 315	java/nio/channels/FileChannel:size	()J
    //   291: aload 6
    //   293: invokevirtual 319	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   296: pop2
    //   297: aload 6
    //   299: astore 5
    //   301: aload 6
    //   303: astore 4
    //   305: aload 9
    //   307: invokevirtual 285	java/io/File:delete	()Z
    //   310: pop
    //   311: aload 6
    //   313: astore 5
    //   315: aload 6
    //   317: astore 4
    //   319: aload_0
    //   320: aload_0
    //   321: getfield 110	com/mobisystems/pdf/PDFDocument:_path	Ljava/lang/String;
    //   324: invokevirtual 321	com/mobisystems/pdf/PDFDocument:reopen	(Ljava/lang/String;)I
    //   327: pop
    //   328: aload_1
    //   329: astore 4
    //   331: aload 6
    //   333: astore_1
    //   334: goto -265 -> 69
    //   337: astore 6
    //   339: aload_1
    //   340: astore 4
    //   342: aload 5
    //   344: astore_1
    //   345: goto -170 -> 175
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 282	com/mobisystems/pdf/PDFDocument:saveNative	(Ljava/lang/String;)I
    //   353: istore_2
    //   354: aconst_null
    //   355: astore 4
    //   357: aload 9
    //   359: astore_1
    //   360: goto -291 -> 69
    //   363: astore 4
    //   365: ldc_w 323
    //   368: aload 4
    //   370: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   373: pop
    //   374: goto -284 -> 90
    //   377: astore_1
    //   378: ldc_w 325
    //   381: aload_1
    //   382: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   385: pop
    //   386: return
    //   387: astore 5
    //   389: ldc_w 323
    //   392: aload 5
    //   394: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   397: pop
    //   398: goto -174 -> 224
    //   401: astore 4
    //   403: ldc_w 325
    //   406: aload 4
    //   408: invokestatic 171	com/mobisystems/pdf/PDFTrace:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   411: pop
    //   412: goto -178 -> 234
    //   415: astore_1
    //   416: aconst_null
    //   417: astore 5
    //   419: goto -205 -> 214
    //   422: astore 6
    //   424: aload_1
    //   425: astore 5
    //   427: aload 6
    //   429: astore_1
    //   430: goto -216 -> 214
    //   433: astore 6
    //   435: goto -260 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	PDFDocument
    //   0	438	1	paramString	String
    //   52	302	2	i	int
    //   23	105	3	bool	boolean
    //   7	349	4	localObject1	Object
    //   363	6	4	localIOException1	java.io.IOException
    //   401	6	4	localIOException2	java.io.IOException
    //   4	339	5	localObject2	Object
    //   387	6	5	localIOException3	java.io.IOException
    //   417	9	5	str1	String
    //   13	1	6	localObject3	Object
    //   167	100	6	localIOException4	java.io.IOException
    //   275	57	6	localFileChannel	java.nio.channels.FileChannel
    //   337	1	6	localIOException5	java.io.IOException
    //   422	6	6	localObject4	Object
    //   433	1	6	localIOException6	java.io.IOException
    //   10	253	7	str2	String
    //   16	255	8	localObject5	Object
    //   1	357	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   28	53	167	java/io/IOException
    //   57	63	167	java/io/IOException
    //   99	128	167	java/io/IOException
    //   131	167	167	java/io/IOException
    //   236	262	167	java/io/IOException
    //   348	354	167	java/io/IOException
    //   76	80	209	finally
    //   182	191	209	finally
    //   198	209	209	finally
    //   270	277	337	java/io/IOException
    //   285	297	337	java/io/IOException
    //   305	311	337	java/io/IOException
    //   319	328	337	java/io/IOException
    //   85	90	363	java/io/IOException
    //   94	98	377	java/io/IOException
    //   219	224	387	java/io/IOException
    //   229	234	401	java/io/IOException
    //   28	53	415	finally
    //   57	63	415	finally
    //   99	128	415	finally
    //   131	167	415	finally
    //   236	262	415	finally
    //   348	354	415	finally
    //   270	277	422	finally
    //   285	297	422	finally
    //   305	311	422	finally
    //   319	328	422	finally
    //   76	80	433	java/io/IOException
  }
  
  protected native int saveNative(String paramString);
  
  public native int setPassword(String paramString);
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this._handle);
    paramParcel.writeString(this._path);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/PDFDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */