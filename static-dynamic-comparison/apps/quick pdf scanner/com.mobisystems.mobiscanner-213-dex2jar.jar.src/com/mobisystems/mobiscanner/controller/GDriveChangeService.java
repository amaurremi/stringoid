package com.mobisystems.mobiscanner.controller;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.a;
import com.google.android.gms.drive.b.a;
import com.google.android.gms.drive.b.b;
import com.google.android.gms.drive.c.a;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.a;
import com.google.android.gms.drive.f;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.a;
import com.mobisystems.mobiscanner.model.DocumentModel;

public class GDriveChangeService
  extends Service
  implements c.c, c.d, DriveEvent.a<ChangeEvent>
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private com.google.android.gms.common.api.c aAB = null;
  private DriveId aCO = null;
  private DriveId aCP = null;
  private long aCQ = -1L;
  Runnable aCR = new Runnable()
  {
    public void run()
    {
      if (GDriveChangeService.a(GDriveChangeService.this) != null)
      {
        if (!GDriveChangeService.a(GDriveChangeService.this).isConnected()) {
          GDriveChangeService.b(GDriveChangeService.this);
        }
      }
      else {
        return;
      }
      GDriveChangeService.c(GDriveChangeService.this);
    }
  };
  private int aCS = 2;
  Handler mHandler = new Handler();
  
  private void Gg()
  {
    this.aAB = new c.b(this).a(a.sN).a(a.sK).a(this).a(this).mp();
    Gh();
  }
  
  private void Gh()
  {
    if (this.aAB != null) {}
    try
    {
      this.aAB.connect();
      return;
    }
    catch (Exception localException)
    {
      while (!(localException instanceof DeadObjectException)) {}
      Gg();
    }
  }
  
  private void Gi()
  {
    Query localQuery1 = new Query.a().a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ug, com.mobisystems.mobiscanner.common.d.aj(this))).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.uh, getString(2131297104))).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ui, Boolean.valueOf(false))).nx();
    Query localQuery2 = new Query.a().a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ug, com.mobisystems.mobiscanner.common.d.ak(this))).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.uh, getString(2131297107))).a(com.google.android.gms.drive.query.b.c(com.google.android.gms.drive.query.c.ui, Boolean.valueOf(false))).nx();
    com.google.android.gms.drive.d locald = a.sO.b(this.aAB);
    if (this.aCO == null) {
      locald.a(this.aAB, localQuery1).a(new com.google.android.gms.common.api.g()
      {
        public void a(b.b paramAnonymousb)
        {
          GDriveChangeService.Gm().dl("onResult result = " + paramAnonymousb.mq().toString());
          if (!paramAnonymousb.mq().mu()) {
            return;
          }
          com.google.android.gms.drive.g localg = paramAnonymousb.mR();
          int j = localg.getCount();
          Object localObject = null;
          int i = 0;
          for (;;)
          {
            paramAnonymousb = (b.b)localObject;
            if (i < j)
            {
              paramAnonymousb = localg.bs(i);
              if (!paramAnonymousb.mY()) {
                paramAnonymousb = paramAnonymousb.mV();
              }
            }
            else
            {
              localg.close();
              GDriveChangeService.a(GDriveChangeService.this, paramAnonymousb);
              GDriveChangeService.d(GDriveChangeService.this);
              return;
            }
            i += 1;
          }
        }
      });
    }
    if (this.aCP == null) {
      locald.a(this.aAB, localQuery2).a(new com.google.android.gms.common.api.g()
      {
        public void a(b.b paramAnonymousb)
        {
          GDriveChangeService.Gm().dl("onResult result = " + paramAnonymousb.mq().toString());
          if (!paramAnonymousb.mq().mu()) {
            return;
          }
          com.google.android.gms.drive.g localg = paramAnonymousb.mR();
          int j = localg.getCount();
          Object localObject = null;
          int i = 0;
          for (;;)
          {
            paramAnonymousb = (b.b)localObject;
            if (i < j)
            {
              paramAnonymousb = localg.bs(i);
              if (!paramAnonymousb.mY()) {
                paramAnonymousb = paramAnonymousb.mV();
              }
            }
            else
            {
              localg.close();
              GDriveChangeService.b(GDriveChangeService.this, paramAnonymousb);
              GDriveChangeService.d(GDriveChangeService.this);
              return;
            }
            i += 1;
          }
        }
      });
    }
  }
  
  private void Gj()
  {
    if ((this.aCO != null) && (this.aCP != null))
    {
      apd.dl("Backup file found, start listener");
      this.mHandler.removeCallbacks(this.aCR);
      com.google.android.gms.drive.c localc = a.sO.a(this.aAB, this.aCO);
      Gk();
      localc.a(this.aAB, this);
      return;
    }
    apd.dl("No backupFile or meta ");
    this.mHandler.removeCallbacks(this.aCR);
    this.mHandler.postDelayed(this.aCR, 10000L);
  }
  
  private void Gk()
  {
    final long l = DocumentModel.Ip();
    if (this.aCP == null) {
      return;
    }
    a.sO.a(this.aAB, this.aCP).a(this.aAB, 268435456, new c.a()
    {
      public void a(long paramAnonymousLong1, long paramAnonymousLong2) {}
    }).a(new com.google.android.gms.common.api.g()
    {
      /* Error */
      public void a(b.a paramAnonymousa)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 5
        //   3: aload_1
        //   4: invokeinterface 38 1 0
        //   9: invokevirtual 44	com/google/android/gms/common/api/Status:mu	()Z
        //   12: ifne +37 -> 49
        //   15: invokestatic 48	com/mobisystems/mobiscanner/controller/GDriveChangeService:Gm	()Lcom/mobisystems/mobiscanner/common/c;
        //   18: new 50	java/lang/StringBuilder
        //   21: dup
        //   22: invokespecial 51	java/lang/StringBuilder:<init>	()V
        //   25: ldc 53
        //   27: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: aload_1
        //   31: invokeinterface 38 1 0
        //   36: invokevirtual 61	com/google/android/gms/common/api/Status:toString	()Ljava/lang/String;
        //   39: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   45: invokevirtual 68	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
        //   48: return
        //   49: aload_1
        //   50: invokeinterface 72 1 0
        //   55: invokevirtual 78	com/google/android/gms/drive/Contents:getInputStream	()Ljava/io/InputStream;
        //   58: astore 7
        //   60: aload_0
        //   61: getfield 20	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   64: invokestatic 84	com/mobisystems/mobiscanner/common/d:ab	(Landroid/content/Context;)Ljava/io/File;
        //   67: astore_1
        //   68: new 86	java/io/BufferedOutputStream
        //   71: dup
        //   72: new 88	java/io/FileOutputStream
        //   75: dup
        //   76: aload_1
        //   77: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   80: invokespecial 94	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   83: astore 4
        //   85: aload 7
        //   87: aload 4
        //   89: invokestatic 98	com/mobisystems/mobiscanner/common/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   92: aload 4
        //   94: invokevirtual 101	java/io/BufferedOutputStream:close	()V
        //   97: aload 7
        //   99: invokevirtual 104	java/io/InputStream:close	()V
        //   102: new 106	java/io/FileInputStream
        //   105: dup
        //   106: aload_1
        //   107: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   110: astore_1
        //   111: new 109	java/io/BufferedReader
        //   114: dup
        //   115: new 111	java/io/InputStreamReader
        //   118: dup
        //   119: aload_1
        //   120: invokespecial 114	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   123: invokespecial 117	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   126: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   129: astore 4
        //   131: aload 7
        //   133: ifnull +8 -> 141
        //   136: aload 7
        //   138: invokevirtual 104	java/io/InputStream:close	()V
        //   141: iconst_0
        //   142: ifeq +11 -> 153
        //   145: new 122	java/lang/NullPointerException
        //   148: dup
        //   149: invokespecial 123	java/lang/NullPointerException:<init>	()V
        //   152: athrow
        //   153: aload 4
        //   155: astore 5
        //   157: aload_1
        //   158: ifnull +11 -> 169
        //   161: aload_1
        //   162: invokevirtual 104	java/io/InputStream:close	()V
        //   165: aload 4
        //   167: astore 5
        //   169: aload 5
        //   171: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   174: ifne +312 -> 486
        //   177: aload 5
        //   179: bipush 10
        //   181: invokestatic 135	java/lang/Long:parseLong	(Ljava/lang/String;I)J
        //   184: lstore_2
        //   185: invokestatic 48	com/mobisystems/mobiscanner/controller/GDriveChangeService:Gm	()Lcom/mobisystems/mobiscanner/common/c;
        //   188: new 50	java/lang/StringBuilder
        //   191: dup
        //   192: invokespecial 51	java/lang/StringBuilder:<init>	()V
        //   195: ldc -119
        //   197: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: aload_0
        //   201: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCU	J
        //   204: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   207: ldc -114
        //   209: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: lload_2
        //   213: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   216: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   219: invokevirtual 68	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
        //   222: aload_0
        //   223: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCU	J
        //   226: lload_2
        //   227: lcmp
        //   228: ifge -180 -> 48
        //   231: aload_0
        //   232: getfield 20	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   235: invokestatic 146	com/mobisystems/mobiscanner/common/d:ap	(Landroid/content/Context;)Z
        //   238: ifeq -190 -> 48
        //   241: aload_0
        //   242: getfield 20	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   245: invokestatic 150	com/mobisystems/mobiscanner/controller/GDriveChangeService:e	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)J
        //   248: lload_2
        //   249: lcmp
        //   250: ifeq -202 -> 48
        //   253: aload_0
        //   254: getfield 20	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   257: lload_2
        //   258: invokestatic 153	com/mobisystems/mobiscanner/controller/GDriveChangeService:a	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;J)J
        //   261: pop2
        //   262: aload_0
        //   263: getfield 20	com/mobisystems/mobiscanner/controller/GDriveChangeService$4:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   266: invokestatic 157	com/mobisystems/mobiscanner/controller/GDriveChangeService:f	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)V
        //   269: return
        //   270: astore 5
        //   272: aconst_null
        //   273: astore_1
        //   274: aconst_null
        //   275: astore 4
        //   277: aload 5
        //   279: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   282: aload 7
        //   284: ifnull +8 -> 292
        //   287: aload 7
        //   289: invokevirtual 104	java/io/InputStream:close	()V
        //   292: aload 4
        //   294: ifnull +8 -> 302
        //   297: aload 4
        //   299: invokevirtual 101	java/io/BufferedOutputStream:close	()V
        //   302: aload_1
        //   303: ifnull +7 -> 310
        //   306: aload_1
        //   307: invokevirtual 104	java/io/InputStream:close	()V
        //   310: aconst_null
        //   311: astore 5
        //   313: goto -144 -> 169
        //   316: astore_1
        //   317: aconst_null
        //   318: astore 4
        //   320: aload 7
        //   322: ifnull +8 -> 330
        //   325: aload 7
        //   327: invokevirtual 104	java/io/InputStream:close	()V
        //   330: aload 4
        //   332: ifnull +8 -> 340
        //   335: aload 4
        //   337: invokevirtual 101	java/io/BufferedOutputStream:close	()V
        //   340: aload 5
        //   342: ifnull +8 -> 350
        //   345: aload 5
        //   347: invokevirtual 104	java/io/InputStream:close	()V
        //   350: aload_1
        //   351: athrow
        //   352: astore 6
        //   354: aload 6
        //   356: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   359: goto -29 -> 330
        //   362: astore 4
        //   364: aload 4
        //   366: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   369: goto -29 -> 340
        //   372: astore 4
        //   374: aload 4
        //   376: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   379: goto -29 -> 350
        //   382: astore 5
        //   384: aload 5
        //   386: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   389: goto -97 -> 292
        //   392: astore 4
        //   394: aload 4
        //   396: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   399: goto -97 -> 302
        //   402: astore_1
        //   403: aload_1
        //   404: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   407: goto -97 -> 310
        //   410: astore 5
        //   412: aload 5
        //   414: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   417: goto -276 -> 141
        //   420: astore 5
        //   422: aload 5
        //   424: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   427: goto -274 -> 153
        //   430: astore_1
        //   431: aload_1
        //   432: invokevirtual 160	java/io/IOException:printStackTrace	()V
        //   435: aload 4
        //   437: astore 5
        //   439: goto -270 -> 169
        //   442: astore_1
        //   443: goto -123 -> 320
        //   446: astore 6
        //   448: aconst_null
        //   449: astore 4
        //   451: aload_1
        //   452: astore 5
        //   454: aload 6
        //   456: astore_1
        //   457: goto -137 -> 320
        //   460: astore 6
        //   462: aload_1
        //   463: astore 5
        //   465: aload 6
        //   467: astore_1
        //   468: goto -148 -> 320
        //   471: astore 5
        //   473: aconst_null
        //   474: astore_1
        //   475: goto -198 -> 277
        //   478: astore 5
        //   480: aconst_null
        //   481: astore 4
        //   483: goto -206 -> 277
        //   486: lconst_0
        //   487: lstore_2
        //   488: goto -303 -> 185
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	491	0	this	4
        //   0	491	1	paramAnonymousa	b.a
        //   184	304	2	l	long
        //   83	253	4	localObject1	Object
        //   362	3	4	localIOException1	java.io.IOException
        //   372	3	4	localIOException2	java.io.IOException
        //   392	44	4	localIOException3	java.io.IOException
        //   449	33	4	localObject2	Object
        //   1	177	5	localObject3	Object
        //   270	8	5	localIOException4	java.io.IOException
        //   311	35	5	localObject4	Object
        //   382	3	5	localIOException5	java.io.IOException
        //   410	3	5	localIOException6	java.io.IOException
        //   420	3	5	localIOException7	java.io.IOException
        //   437	27	5	localObject5	Object
        //   471	1	5	localIOException8	java.io.IOException
        //   478	1	5	localIOException9	java.io.IOException
        //   352	3	6	localIOException10	java.io.IOException
        //   446	9	6	localObject6	Object
        //   460	6	6	localObject7	Object
        //   58	268	7	localInputStream	java.io.InputStream
        // Exception table:
        //   from	to	target	type
        //   60	85	270	java/io/IOException
        //   97	111	270	java/io/IOException
        //   60	85	316	finally
        //   97	111	316	finally
        //   325	330	352	java/io/IOException
        //   335	340	362	java/io/IOException
        //   345	350	372	java/io/IOException
        //   287	292	382	java/io/IOException
        //   297	302	392	java/io/IOException
        //   306	310	402	java/io/IOException
        //   136	141	410	java/io/IOException
        //   145	153	420	java/io/IOException
        //   161	165	430	java/io/IOException
        //   85	97	442	finally
        //   111	131	446	finally
        //   277	282	460	finally
        //   85	97	471	java/io/IOException
        //   111	131	478	java/io/IOException
      }
    });
  }
  
  private void Gl()
  {
    final com.google.android.gms.drive.c localc = a.sO.a(this.aAB, this.aCO);
    localc.a(this.aAB, 268435456, new c.a()
    {
      public void a(long paramAnonymousLong1, long paramAnonymousLong2) {}
    }).a(new com.google.android.gms.common.api.g()
    {
      /* Error */
      public void a(b.a paramAnonymousa)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aconst_null
        //   4: astore_3
        //   5: aload_1
        //   6: invokeinterface 40 1 0
        //   11: invokevirtual 46	com/google/android/gms/common/api/Status:mu	()Z
        //   14: ifne +4 -> 18
        //   17: return
        //   18: aload_1
        //   19: invokeinterface 50 1 0
        //   24: astore 5
        //   26: aload 4
        //   28: astore_1
        //   29: new 52	java/io/BufferedOutputStream
        //   32: dup
        //   33: new 54	java/io/FileOutputStream
        //   36: dup
        //   37: aload_0
        //   38: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   41: invokestatic 60	com/mobisystems/mobiscanner/common/d:aa	(Landroid/content/Context;)Ljava/io/File;
        //   44: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   47: invokespecial 66	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   50: astore_2
        //   51: aload 5
        //   53: invokevirtual 72	com/google/android/gms/drive/Contents:getInputStream	()Ljava/io/InputStream;
        //   56: astore 6
        //   58: aload 6
        //   60: aload_2
        //   61: invokestatic 76	com/mobisystems/mobiscanner/common/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   64: aload_2
        //   65: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   68: aload 4
        //   70: astore_1
        //   71: aload 6
        //   73: invokevirtual 82	java/io/InputStream:close	()V
        //   76: aload 4
        //   78: astore_1
        //   79: aload_0
        //   80: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   83: ldc 84
        //   85: invokevirtual 88	com/mobisystems/mobiscanner/controller/GDriveChangeService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   88: checkcast 90	android/app/NotificationManager
        //   91: astore_2
        //   92: aload 4
        //   94: astore_1
        //   95: new 92	android/support/v4/app/NotificationCompat$Builder
        //   98: dup
        //   99: aload_0
        //   100: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   103: invokespecial 95	android/support/v4/app/NotificationCompat$Builder:<init>	(Landroid/content/Context;)V
        //   106: ldc 96
        //   108: invokevirtual 100	android/support/v4/app/NotificationCompat$Builder:setSmallIcon	(I)Landroid/support/v4/app/NotificationCompat$Builder;
        //   111: aload_0
        //   112: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   115: ldc 101
        //   117: invokevirtual 105	com/mobisystems/mobiscanner/controller/GDriveChangeService:getString	(I)Ljava/lang/String;
        //   120: invokevirtual 109	android/support/v4/app/NotificationCompat$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
        //   123: aload_0
        //   124: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   127: ldc 101
        //   129: invokevirtual 105	com/mobisystems/mobiscanner/controller/GDriveChangeService:getString	(I)Ljava/lang/String;
        //   132: invokevirtual 112	android/support/v4/app/NotificationCompat$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;
        //   135: astore 8
        //   137: aload 4
        //   139: astore_1
        //   140: new 114	android/content/Intent
        //   143: dup
        //   144: aload_0
        //   145: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   148: ldc 116
        //   150: invokespecial 119	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
        //   153: astore 6
        //   155: aload 4
        //   157: astore_1
        //   158: aload 6
        //   160: ldc 121
        //   162: iconst_1
        //   163: invokevirtual 125	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   166: pop
        //   167: aload 4
        //   169: astore_1
        //   170: aload_0
        //   171: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   174: invokestatic 131	android/support/v4/app/TaskStackBuilder:create	(Landroid/content/Context;)Landroid/support/v4/app/TaskStackBuilder;
        //   177: astore 7
        //   179: aload 4
        //   181: astore_1
        //   182: aload 7
        //   184: ldc 116
        //   186: invokevirtual 135	android/support/v4/app/TaskStackBuilder:addParentStack	(Ljava/lang/Class;)Landroid/support/v4/app/TaskStackBuilder;
        //   189: pop
        //   190: aload 4
        //   192: astore_1
        //   193: aload 7
        //   195: aload 6
        //   197: invokevirtual 139	android/support/v4/app/TaskStackBuilder:addNextIntent	(Landroid/content/Intent;)Landroid/support/v4/app/TaskStackBuilder;
        //   200: pop
        //   201: aload 4
        //   203: astore_1
        //   204: aload 8
        //   206: aload 7
        //   208: iconst_0
        //   209: ldc -116
        //   211: invokevirtual 144	android/support/v4/app/TaskStackBuilder:getPendingIntent	(II)Landroid/app/PendingIntent;
        //   214: invokevirtual 148	android/support/v4/app/NotificationCompat$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;
        //   217: pop
        //   218: aload 4
        //   220: astore_1
        //   221: aload 8
        //   223: iconst_1
        //   224: invokevirtual 152	android/support/v4/app/NotificationCompat$Builder:setAutoCancel	(Z)Landroid/support/v4/app/NotificationCompat$Builder;
        //   227: pop
        //   228: aload 4
        //   230: astore_1
        //   231: aload_0
        //   232: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   235: iconst_1
        //   236: invokestatic 155	com/mobisystems/mobiscanner/controller/GDriveChangeService:a	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;I)I
        //   239: pop
        //   240: aload 4
        //   242: astore_1
        //   243: aload_2
        //   244: aload_0
        //   245: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   248: invokestatic 159	com/mobisystems/mobiscanner/controller/GDriveChangeService:g	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)I
        //   251: aload 8
        //   253: invokevirtual 163	android/support/v4/app/NotificationCompat$Builder:build	()Landroid/app/Notification;
        //   256: invokevirtual 167	android/app/NotificationManager:notify	(ILandroid/app/Notification;)V
        //   259: iconst_0
        //   260: ifeq +11 -> 271
        //   263: new 169	java/lang/NullPointerException
        //   266: dup
        //   267: invokespecial 170	java/lang/NullPointerException:<init>	()V
        //   270: athrow
        //   271: aload_0
        //   272: getfield 24	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCV	Lcom/google/android/gms/drive/c;
        //   275: aload_0
        //   276: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   279: invokestatic 173	com/mobisystems/mobiscanner/controller/GDriveChangeService:a	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)Lcom/google/android/gms/common/api/c;
        //   282: aload 5
        //   284: invokeinterface 178 3 0
        //   289: astore_1
        //   290: new 14	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1
        //   293: dup
        //   294: aload_0
        //   295: invokespecial 181	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1:<init>	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService$6;)V
        //   298: astore_2
        //   299: aload_1
        //   300: aload_2
        //   301: invokeinterface 186 2 0
        //   306: return
        //   307: astore_1
        //   308: aload_3
        //   309: astore_2
        //   310: aload_1
        //   311: astore_3
        //   312: aload_2
        //   313: astore_1
        //   314: aload_3
        //   315: invokevirtual 189	java/io/IOException:printStackTrace	()V
        //   318: aload_2
        //   319: ifnull +7 -> 326
        //   322: aload_2
        //   323: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   326: aload_0
        //   327: getfield 24	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCV	Lcom/google/android/gms/drive/c;
        //   330: aload_0
        //   331: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   334: invokestatic 173	com/mobisystems/mobiscanner/controller/GDriveChangeService:a	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)Lcom/google/android/gms/common/api/c;
        //   337: aload 5
        //   339: invokeinterface 178 3 0
        //   344: astore_1
        //   345: new 14	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1
        //   348: dup
        //   349: aload_0
        //   350: invokespecial 181	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1:<init>	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService$6;)V
        //   353: astore_2
        //   354: goto -55 -> 299
        //   357: astore_3
        //   358: aload_1
        //   359: astore_2
        //   360: aload_3
        //   361: astore_1
        //   362: aload_2
        //   363: ifnull +7 -> 370
        //   366: aload_2
        //   367: invokevirtual 79	java/io/BufferedOutputStream:close	()V
        //   370: aload_0
        //   371: getfield 24	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCV	Lcom/google/android/gms/drive/c;
        //   374: aload_0
        //   375: getfield 22	com/mobisystems/mobiscanner/controller/GDriveChangeService$6:aCT	Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;
        //   378: invokestatic 173	com/mobisystems/mobiscanner/controller/GDriveChangeService:a	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService;)Lcom/google/android/gms/common/api/c;
        //   381: aload 5
        //   383: invokeinterface 178 3 0
        //   388: new 14	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1
        //   391: dup
        //   392: aload_0
        //   393: invokespecial 181	com/mobisystems/mobiscanner/controller/GDriveChangeService$6$1:<init>	(Lcom/mobisystems/mobiscanner/controller/GDriveChangeService$6;)V
        //   396: invokeinterface 186 2 0
        //   401: aload_1
        //   402: athrow
        //   403: astore_2
        //   404: aload_2
        //   405: invokevirtual 189	java/io/IOException:printStackTrace	()V
        //   408: goto -38 -> 370
        //   411: astore_1
        //   412: aload_1
        //   413: invokevirtual 189	java/io/IOException:printStackTrace	()V
        //   416: goto -90 -> 326
        //   419: astore_1
        //   420: aload_1
        //   421: invokevirtual 189	java/io/IOException:printStackTrace	()V
        //   424: goto -153 -> 271
        //   427: astore_1
        //   428: goto -66 -> 362
        //   431: astore_3
        //   432: goto -120 -> 312
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	435	0	this	6
        //   0	435	1	paramAnonymousa	b.a
        //   50	317	2	localObject1	Object
        //   403	2	2	localIOException1	java.io.IOException
        //   4	311	3	locala	b.a
        //   357	4	3	localObject2	Object
        //   431	1	3	localIOException2	java.io.IOException
        //   1	240	4	localObject3	Object
        //   24	358	5	localContents	com.google.android.gms.drive.Contents
        //   56	140	6	localObject4	Object
        //   177	30	7	localTaskStackBuilder	android.support.v4.app.TaskStackBuilder
        //   135	117	8	localBuilder	android.support.v4.app.NotificationCompat.Builder
        // Exception table:
        //   from	to	target	type
        //   29	51	307	java/io/IOException
        //   71	76	307	java/io/IOException
        //   79	92	307	java/io/IOException
        //   95	137	307	java/io/IOException
        //   140	155	307	java/io/IOException
        //   158	167	307	java/io/IOException
        //   170	179	307	java/io/IOException
        //   182	190	307	java/io/IOException
        //   193	201	307	java/io/IOException
        //   204	218	307	java/io/IOException
        //   221	228	307	java/io/IOException
        //   231	240	307	java/io/IOException
        //   243	259	307	java/io/IOException
        //   29	51	357	finally
        //   71	76	357	finally
        //   79	92	357	finally
        //   95	137	357	finally
        //   140	155	357	finally
        //   158	167	357	finally
        //   170	179	357	finally
        //   182	190	357	finally
        //   193	201	357	finally
        //   204	218	357	finally
        //   221	228	357	finally
        //   231	240	357	finally
        //   243	259	357	finally
        //   314	318	357	finally
        //   366	370	403	java/io/IOException
        //   322	326	411	java/io/IOException
        //   263	271	419	java/io/IOException
        //   51	68	427	finally
        //   51	68	431	java/io/IOException
      }
    });
  }
  
  public void a(Bundle paramBundle)
  {
    apd.dl("service connected");
    Gi();
  }
  
  public void a(com.google.android.gms.common.b paramb)
  {
    apd.dl("connection failed " + paramb.toString());
    this.mHandler.postDelayed(this.aCR, 10000L);
  }
  
  public void a(ChangeEvent paramChangeEvent)
  {
    apd.dl("onEvent " + paramChangeEvent.nd() + " ; " + paramChangeEvent.getType() + " ; " + paramChangeEvent.nc());
    if (paramChangeEvent.nd()) {
      Gk();
    }
  }
  
  public void bl(int paramInt)
  {
    apd.dl("onConnectionSuspended");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mHandler.removeCallbacks(this.aCR);
    if (this.aAB == null) {
      Gg();
    }
    for (;;)
    {
      return 1;
      if (this.aAB.isConnected())
      {
        if ((this.aCO == null) || (this.aCP == null)) {
          Gi();
        } else {
          Gj();
        }
      }
      else {
        Gh();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/GDriveChangeService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */