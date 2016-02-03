package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.b.a;

class aa
  implements g<b.a>
{
  private DriveId aCK;
  private String aCL;
  private a aCM;
  private c azR;
  private Context mContext;
  
  public aa(DriveId paramDriveId, c paramc, Context paramContext, String paramString, a parama)
  {
    this.aCK = paramDriveId;
    this.azR = paramc;
    this.mContext = paramContext;
    this.aCL = paramString;
    this.aCM = parama;
  }
  
  /* Error */
  public void a(b.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 53 1 0
    //   6: invokevirtual 59	com/google/android/gms/common/api/Status:mu	()Z
    //   9: ifne +24 -> 33
    //   12: aload_0
    //   13: getfield 33	com/mobisystems/mobiscanner/controller/aa:mContext	Landroid/content/Context;
    //   16: aload_1
    //   17: invokeinterface 53 1 0
    //   22: invokevirtual 63	com/google/android/gms/common/api/Status:toString	()Ljava/lang/String;
    //   25: iconst_1
    //   26: invokestatic 69	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   29: invokevirtual 72	android/widget/Toast:show	()V
    //   32: return
    //   33: aload_1
    //   34: invokeinterface 76 1 0
    //   39: astore 4
    //   41: aconst_null
    //   42: astore_1
    //   43: new 78	java/io/FileInputStream
    //   46: dup
    //   47: new 80	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: getfield 33	com/mobisystems/mobiscanner/controller/aa:mContext	Landroid/content/Context;
    //   55: invokestatic 86	com/mobisystems/mobiscanner/common/d:Z	(Landroid/content/Context;)Ljava/io/File;
    //   58: aload_0
    //   59: getfield 35	com/mobisystems/mobiscanner/controller/aa:aCL	Ljava/lang/String;
    //   62: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload 4
    //   74: invokevirtual 98	com/google/android/gms/drive/Contents:getOutputStream	()Ljava/io/OutputStream;
    //   77: invokestatic 102	com/mobisystems/mobiscanner/common/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 105	java/io/FileInputStream:close	()V
    //   88: getstatic 111	com/google/android/gms/drive/a:sO	Lcom/google/android/gms/drive/b;
    //   91: aload_0
    //   92: getfield 31	com/mobisystems/mobiscanner/controller/aa:azR	Lcom/google/android/gms/common/api/c;
    //   95: aload_0
    //   96: getfield 29	com/mobisystems/mobiscanner/controller/aa:aCK	Lcom/google/android/gms/drive/DriveId;
    //   99: invokeinterface 116 3 0
    //   104: aload_0
    //   105: getfield 31	com/mobisystems/mobiscanner/controller/aa:azR	Lcom/google/android/gms/common/api/c;
    //   108: aload 4
    //   110: invokeinterface 121 3 0
    //   115: new 9	com/mobisystems/mobiscanner/controller/aa$1
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 124	com/mobisystems/mobiscanner/controller/aa$1:<init>	(Lcom/mobisystems/mobiscanner/controller/aa;)V
    //   123: invokeinterface 129 2 0
    //   128: return
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: aload_3
    //   135: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   138: aload_2
    //   139: ifnull -51 -> 88
    //   142: aload_2
    //   143: invokevirtual 105	java/io/FileInputStream:close	()V
    //   146: goto -58 -> 88
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   154: goto -66 -> 88
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload_3
    //   161: astore_1
    //   162: aload_2
    //   163: ifnull +7 -> 170
    //   166: aload_2
    //   167: invokevirtual 105	java/io/FileInputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   177: goto -7 -> 170
    //   180: astore_1
    //   181: goto -31 -> 150
    //   184: astore_3
    //   185: aload_1
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: goto -27 -> 162
    //   192: astore_3
    //   193: goto -61 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	aa
    //   0	196	1	parama	b.a
    //   68	99	2	localObject1	Object
    //   172	2	2	localIOException1	java.io.IOException
    //   186	1	2	locala	b.a
    //   129	6	3	localIOException2	java.io.IOException
    //   157	4	3	localObject2	Object
    //   184	4	3	localObject3	Object
    //   192	1	3	localIOException3	java.io.IOException
    //   39	70	4	localContents	com.google.android.gms.drive.Contents
    // Exception table:
    //   from	to	target	type
    //   43	69	129	java/io/IOException
    //   142	146	149	java/io/IOException
    //   43	69	157	finally
    //   166	170	172	java/io/IOException
    //   84	88	180	java/io/IOException
    //   71	80	184	finally
    //   134	138	184	finally
    //   71	80	192	java/io/IOException
  }
  
  public static abstract interface a
  {
    public abstract void a(Status paramStatus, String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */