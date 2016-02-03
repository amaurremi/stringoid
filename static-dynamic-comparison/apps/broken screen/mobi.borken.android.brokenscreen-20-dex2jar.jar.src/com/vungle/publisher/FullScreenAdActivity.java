package com.vungle.publisher;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.AdReportEvent.a;
import com.vungle.publisher.db.model.EventTracking.a;
import com.vungle.publisher.display.view.AdFragment;
import com.vungle.publisher.display.view.PostRollFragment;
import com.vungle.publisher.display.view.PostRollFragment.a;
import com.vungle.publisher.display.view.VideoFragment;
import com.vungle.publisher.display.view.VideoFragment.Factory;
import com.vungle.publisher.display.view.VideoFragment.a;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.reporting.AdReportingHandler;
import com.vungle.publisher.reporting.AdReportingHandler.Factory;
import javax.inject.Inject;

public class FullScreenAdActivity
  extends FragmentActivity
{
  @Inject
  AdManager a;
  @Inject
  AdReportingHandler.Factory b;
  @Inject
  di c;
  @Inject
  VideoFragment.Factory d;
  @Inject
  SdkState e;
  private Ad f;
  private AdFragment g;
  private AdReportingHandler h;
  private PostRollFragment i;
  private View j;
  private VideoFragment k;
  
  private void a(AdFragment paramAdFragment)
  {
    if (paramAdFragment != this.g)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(17432576, 17432577);
      this.g = paramAdFragment;
      localFragmentTransaction.replace(16908290, paramAdFragment);
      localFragmentTransaction.commit();
    }
  }
  
  final void a()
  {
    if (au.a(19))
    {
      this.j.setSystemUiVisibility(5894);
      this.j.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          if ((paramAnonymousInt & 0x4) == 0) {
            FullScreenAdActivity.this.a();
          }
        }
      });
    }
  }
  
  final void a(boolean paramBoolean)
  {
    if (this.i == null)
    {
      if (paramBoolean)
      {
        d();
        return;
      }
      d();
      return;
    }
    this.h.a(EventTracking.a.j);
    a(this.i);
  }
  
  final void b()
  {
    if (this.k == null)
    {
      a(false);
      return;
    }
    a(this.k);
  }
  
  final void c()
  {
    localObject1 = null;
    try
    {
      String str1 = this.f.f();
      localObject1 = str1;
      Logger.v("VungleAd", "call to action destination " + str1);
      if (str1 != null)
      {
        localObject1 = str1;
        Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(str1));
        localObject1 = str1;
        ((Intent)localObject2).addFlags(268435456);
        localObject1 = str1;
        startActivity((Intent)localObject2);
        localObject1 = str1;
        localObject2 = this.h;
        localObject1 = str1;
        String str2 = this.f.g();
        localObject1 = str1;
        ((AdReportingHandler)localObject2).e.a(null, new String[] { str2 });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("VungleAd", "error loading call-to-action URL " + (String)localObject1, localException);
      }
    }
    d();
  }
  
  /* Error */
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/vungle/publisher/FullScreenAdActivity:a	Lcom/vungle/publisher/ad/AdManager;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 120	com/vungle/publisher/FullScreenAdActivity:f	Lcom/vungle/publisher/db/model/Ad;
    //   10: astore_3
    //   11: aload_3
    //   12: getstatic 193	com/vungle/publisher/db/model/Ad$a:f	Lcom/vungle/publisher/db/model/Ad$a;
    //   15: invokevirtual 196	com/vungle/publisher/db/model/Ad:a	(Lcom/vungle/publisher/db/model/Ad$a;)V
    //   18: aload_3
    //   19: invokevirtual 199	com/vungle/publisher/db/model/Ad:l	()I
    //   22: pop
    //   23: aload_3
    //   24: instanceof 201
    //   27: ifeq +9 -> 36
    //   30: aload 4
    //   32: invokevirtual 206	com/vungle/publisher/ad/AdManager:a	()Lcom/vungle/publisher/db/model/LocalAd;
    //   35: pop
    //   36: aload_0
    //   37: getfield 45	com/vungle/publisher/FullScreenAdActivity:h	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   40: astore_3
    //   41: aload_3
    //   42: getfield 209	com/vungle/publisher/reporting/AdReportingHandler:b	Lcom/vungle/publisher/db/model/AdReport;
    //   45: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   48: invokestatic 221	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: invokevirtual 226	com/vungle/publisher/db/model/AdReport:a	(Ljava/lang/Long;)V
    //   54: aload_3
    //   55: getfield 229	com/vungle/publisher/reporting/AdReportingHandler:g	Lcom/vungle/publisher/reporting/ReportManager;
    //   58: aload_3
    //   59: getfield 209	com/vungle/publisher/reporting/AdReportingHandler:b	Lcom/vungle/publisher/db/model/AdReport;
    //   62: invokevirtual 234	com/vungle/publisher/reporting/ReportManager:a	(Lcom/vungle/publisher/db/model/AdReport;)V
    //   65: aload_0
    //   66: getfield 236	com/vungle/publisher/FullScreenAdActivity:c	Lcom/vungle/publisher/di;
    //   69: new 238	com/vungle/publisher/y
    //   72: dup
    //   73: invokespecial 239	com/vungle/publisher/y:<init>	()V
    //   76: invokevirtual 244	com/vungle/publisher/di:b	(Ljava/lang/Object;)V
    //   79: aload_0
    //   80: getfield 246	com/vungle/publisher/FullScreenAdActivity:e	Lcom/vungle/publisher/env/SdkState;
    //   83: astore_3
    //   84: invokestatic 250	com/vungle/publisher/env/SdkState:b	()J
    //   87: lstore_1
    //   88: ldc 127
    //   90: new 129	java/lang/StringBuilder
    //   93: dup
    //   94: ldc -4
    //   96: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: lload_1
    //   100: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   103: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 147	com/vungle/publisher/log/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_3
    //   110: getfield 258	com/vungle/publisher/env/SdkState:h	Landroid/content/SharedPreferences;
    //   113: invokeinterface 264 1 0
    //   118: ldc_w 266
    //   121: lload_1
    //   122: invokeinterface 272 4 0
    //   127: invokeinterface 275 1 0
    //   132: aload_0
    //   133: invokevirtual 278	com/vungle/publisher/FullScreenAdActivity:finish	()V
    //   136: return
    //   137: astore 4
    //   139: ldc_w 280
    //   142: new 129	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 282
    //   149: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_3
    //   153: invokevirtual 285	com/vungle/publisher/db/model/Ad:u	()Ljava/lang/String;
    //   156: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: aload 4
    //   164: invokestatic 288	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -131 -> 36
    //   170: astore_3
    //   171: new 129	java/lang/StringBuilder
    //   174: dup
    //   175: ldc_w 290
    //   178: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: astore 4
    //   183: aload_0
    //   184: getfield 120	com/vungle/publisher/FullScreenAdActivity:f	Lcom/vungle/publisher/db/model/Ad;
    //   187: ifnonnull +45 -> 232
    //   190: aconst_null
    //   191: astore_3
    //   192: ldc 127
    //   194: aload 4
    //   196: aload_3
    //   197: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 292	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: invokevirtual 278	com/vungle/publisher/FullScreenAdActivity:finish	()V
    //   210: return
    //   211: astore_3
    //   212: ldc_w 294
    //   215: ldc_w 296
    //   218: aload_3
    //   219: invokestatic 288	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: goto -157 -> 65
    //   225: astore_3
    //   226: aload_0
    //   227: invokevirtual 278	com/vungle/publisher/FullScreenAdActivity:finish	()V
    //   230: aload_3
    //   231: athrow
    //   232: aload_0
    //   233: getfield 120	com/vungle/publisher/FullScreenAdActivity:f	Lcom/vungle/publisher/db/model/Ad;
    //   236: invokevirtual 298	com/vungle/publisher/db/model/Ad:d	()Ljava/lang/String;
    //   239: astore_3
    //   240: goto -48 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	FullScreenAdActivity
    //   87	35	1	l	long
    //   10	143	3	localObject1	Object
    //   170	1	3	localException1	Exception
    //   191	6	3	str1	String
    //   211	8	3	localException2	Exception
    //   225	6	3	localObject2	Object
    //   239	1	3	str2	String
    //   4	27	4	localAdManager	AdManager
    //   137	26	4	localException3	Exception
    //   181	14	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	36	137	java/lang/Exception
    //   0	11	170	java/lang/Exception
    //   36	41	170	java/lang/Exception
    //   65	132	170	java/lang/Exception
    //   139	167	170	java/lang/Exception
    //   212	222	170	java/lang/Exception
    //   41	65	211	java/lang/Exception
    //   0	11	225	finally
    //   11	36	225	finally
    //   36	41	225	finally
    //   41	65	225	finally
    //   65	132	225	finally
    //   139	167	225	finally
    //   171	190	225	finally
    //   192	206	225	finally
    //   212	222	225	finally
    //   232	240	225	finally
  }
  
  public void onBackPressed()
  {
    Logger.v("VungleAd", "back button pressed");
    this.h.a(AdReportEvent.a.a, null);
    this.g.a();
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 127
    //   4: ldc_w 317
    //   7: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 321	android/support/v4/app/FragmentActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: invokevirtual 325	com/vungle/publisher/FullScreenAdActivity:getIntent	()Landroid/content/Intent;
    //   19: ldc_w 327
    //   22: invokevirtual 331	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   25: checkcast 333	com/vungle/publisher/ay
    //   28: astore_1
    //   29: invokestatic 339	com/vungle/publisher/inject/Injector:getInstance	()Lcom/vungle/publisher/inject/Injector;
    //   32: getfield 342	com/vungle/publisher/inject/Injector:a	Lcom/vungle/publisher/cq;
    //   35: aload_0
    //   36: invokevirtual 347	com/vungle/publisher/cq:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_0
    //   41: getfield 188	com/vungle/publisher/FullScreenAdActivity:a	Lcom/vungle/publisher/ad/AdManager;
    //   44: astore 7
    //   46: aload 7
    //   48: getfield 349	com/vungle/publisher/ad/AdManager:a	Lcom/vungle/publisher/db/model/Ad;
    //   51: astore 6
    //   53: aload 7
    //   55: aconst_null
    //   56: putfield 349	com/vungle/publisher/ad/AdManager:a	Lcom/vungle/publisher/db/model/Ad;
    //   59: aload_0
    //   60: aload 6
    //   62: putfield 120	com/vungle/publisher/FullScreenAdActivity:f	Lcom/vungle/publisher/db/model/Ad;
    //   65: aload 6
    //   67: ifnonnull +16 -> 83
    //   70: ldc 127
    //   72: ldc_w 351
    //   75: invokestatic 292	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: invokevirtual 100	com/vungle/publisher/FullScreenAdActivity:d	()V
    //   82: return
    //   83: aload_0
    //   84: getfield 353	com/vungle/publisher/FullScreenAdActivity:b	Lcom/vungle/publisher/reporting/AdReportingHandler$Factory;
    //   87: astore 8
    //   89: aload 8
    //   91: getfield 358	com/vungle/publisher/reporting/AdReportingHandler$Factory:a	Ljavax/inject/Provider;
    //   94: invokeinterface 364 1 0
    //   99: checkcast 107	com/vungle/publisher/reporting/AdReportingHandler
    //   102: astore 7
    //   104: aload 7
    //   106: aload 6
    //   108: putfield 365	com/vungle/publisher/reporting/AdReportingHandler:a	Lcom/vungle/publisher/db/model/Ad;
    //   111: aload 8
    //   113: getfield 367	com/vungle/publisher/reporting/AdReportingHandler$Factory:b	Lcom/vungle/publisher/reporting/ReportManager;
    //   116: aload 6
    //   118: invokevirtual 370	com/vungle/publisher/reporting/ReportManager:a	(Lcom/vungle/publisher/db/model/Ad;)Lcom/vungle/publisher/db/model/AdReport;
    //   121: astore 8
    //   123: aload 7
    //   125: aload 8
    //   127: putfield 209	com/vungle/publisher/reporting/AdReportingHandler:b	Lcom/vungle/publisher/db/model/AdReport;
    //   130: aload 7
    //   132: aload 8
    //   134: invokevirtual 373	com/vungle/publisher/db/model/AdReport:k	()Lcom/vungle/publisher/db/model/AdPlay;
    //   137: putfield 376	com/vungle/publisher/reporting/AdReportingHandler:c	Lcom/vungle/publisher/db/model/AdPlay;
    //   140: aload_0
    //   141: aload 7
    //   143: putfield 45	com/vungle/publisher/FullScreenAdActivity:h	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   146: aload_0
    //   147: getfield 45	com/vungle/publisher/FullScreenAdActivity:h	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   150: invokevirtual 378	com/vungle/publisher/reporting/AdReportingHandler:b	()V
    //   153: aload_0
    //   154: aload_0
    //   155: invokevirtual 382	com/vungle/publisher/FullScreenAdActivity:getWindow	()Landroid/view/Window;
    //   158: invokevirtual 388	android/view/Window:getDecorView	()Landroid/view/View;
    //   161: putfield 82	com/vungle/publisher/FullScreenAdActivity:j	Landroid/view/View;
    //   164: aload 6
    //   166: invokevirtual 125	com/vungle/publisher/db/model/Ad:f	()Ljava/lang/String;
    //   169: astore 8
    //   171: aload 6
    //   173: invokevirtual 391	com/vungle/publisher/db/model/Ad:j	()Lcom/vungle/publisher/db/model/Video;
    //   176: astore 7
    //   178: aload 7
    //   180: ifnull +81 -> 261
    //   183: aload_0
    //   184: getfield 393	com/vungle/publisher/FullScreenAdActivity:d	Lcom/vungle/publisher/display/view/VideoFragment$Factory;
    //   187: astore 11
    //   189: new 13	com/vungle/publisher/FullScreenAdActivity$b
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 394	com/vungle/publisher/FullScreenAdActivity$b:<init>	(Lcom/vungle/publisher/FullScreenAdActivity;)V
    //   197: astore 9
    //   199: aload_0
    //   200: getfield 45	com/vungle/publisher/FullScreenAdActivity:h	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   203: astore 10
    //   205: aload 11
    //   207: getfield 397	com/vungle/publisher/display/view/VideoFragment$Factory:a	Ljavax/inject/Provider;
    //   210: invokeinterface 364 1 0
    //   215: checkcast 399	com/vungle/publisher/display/view/VideoFragment
    //   218: astore 11
    //   220: aload 11
    //   222: aload 9
    //   224: putfield 402	com/vungle/publisher/display/view/VideoFragment:c	Lcom/vungle/publisher/display/view/VideoFragment$a;
    //   227: aload 11
    //   229: aload_1
    //   230: putfield 405	com/vungle/publisher/display/view/VideoFragment:a	Lcom/vungle/publisher/ay;
    //   233: aload 11
    //   235: aload 10
    //   237: putfield 407	com/vungle/publisher/display/view/VideoFragment:b	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   240: aload 11
    //   242: aload 7
    //   244: putfield 410	com/vungle/publisher/display/view/VideoFragment:d	Lcom/vungle/publisher/db/model/Video;
    //   247: aload 11
    //   249: aload 8
    //   251: invokestatic 413	com/vungle/publisher/display/view/VideoFragment:a	(Lcom/vungle/publisher/display/view/VideoFragment;Ljava/lang/String;)Ljava/lang/String;
    //   254: pop
    //   255: aload_0
    //   256: aload 11
    //   258: putfield 114	com/vungle/publisher/FullScreenAdActivity:k	Lcom/vungle/publisher/display/view/VideoFragment;
    //   261: aload 6
    //   263: instanceof 201
    //   266: ifeq +106 -> 372
    //   269: aload 6
    //   271: checkcast 201	com/vungle/publisher/db/model/LocalAd
    //   274: invokevirtual 416	com/vungle/publisher/db/model/LocalAd:w	()Lcom/vungle/publisher/db/model/LocalArchive;
    //   277: astore 6
    //   279: aload 6
    //   281: ifnull +91 -> 372
    //   284: new 418	java/io/File
    //   287: dup
    //   288: iconst_2
    //   289: anewarray 420	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload 6
    //   296: invokevirtual 424	com/vungle/publisher/db/model/LocalArchive:w	()Ljava/lang/String;
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: ldc_w 426
    //   305: aastore
    //   306: invokestatic 431	com/vungle/publisher/bk:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   309: invokespecial 432	java/io/File:<init>	(Ljava/lang/String;)V
    //   312: invokevirtual 436	java/io/File:toURI	()Ljava/net/URI;
    //   315: invokevirtual 439	java/net/URI:toString	()Ljava/lang/String;
    //   318: astore 6
    //   320: ldc 127
    //   322: new 129	java/lang/StringBuilder
    //   325: dup
    //   326: ldc_w 441
    //   329: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   332: aload 6
    //   334: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_0
    //   344: new 443	com/vungle/publisher/display/view/PostRollFragment
    //   347: dup
    //   348: aload 6
    //   350: new 16	com/vungle/publisher/FullScreenAdActivity$c
    //   353: dup
    //   354: aload_0
    //   355: invokespecial 444	com/vungle/publisher/FullScreenAdActivity$c:<init>	(Lcom/vungle/publisher/FullScreenAdActivity;)V
    //   358: new 10	com/vungle/publisher/FullScreenAdActivity$a
    //   361: dup
    //   362: aload_0
    //   363: invokespecial 445	com/vungle/publisher/FullScreenAdActivity$a:<init>	(Lcom/vungle/publisher/FullScreenAdActivity;)V
    //   366: invokespecial 448	com/vungle/publisher/display/view/PostRollFragment:<init>	(Ljava/lang/String;Lcom/vungle/publisher/aw$a;Lcom/vungle/publisher/display/view/PostRollFragment$a;)V
    //   369: putfield 98	com/vungle/publisher/FullScreenAdActivity:i	Lcom/vungle/publisher/display/view/PostRollFragment;
    //   372: aload_0
    //   373: invokevirtual 449	com/vungle/publisher/FullScreenAdActivity:a	()V
    //   376: aload_1
    //   377: invokeinterface 453 1 0
    //   382: astore_1
    //   383: getstatic 456	com/vungle/publisher/FullScreenAdActivity$2:a	[I
    //   386: aload_1
    //   387: invokevirtual 461	com/vungle/publisher/Orientation:ordinal	()I
    //   390: iaload
    //   391: tableswitch	default:+348->739, 1:+183->574
    //   408: aload 7
    //   410: getfield 466	com/vungle/publisher/db/model/Video:k	Ljava/lang/Integer;
    //   413: ifnull +329 -> 742
    //   416: aload 7
    //   418: getfield 468	com/vungle/publisher/db/model/Video:u	Ljava/lang/Integer;
    //   421: ifnull +321 -> 742
    //   424: aload 7
    //   426: getfield 468	com/vungle/publisher/db/model/Video:u	Ljava/lang/Integer;
    //   429: invokevirtual 473	java/lang/Integer:intValue	()I
    //   432: aload 7
    //   434: getfield 466	com/vungle/publisher/db/model/Video:k	Ljava/lang/Integer;
    //   437: invokevirtual 473	java/lang/Integer:intValue	()I
    //   440: if_icmple +302 -> 742
    //   443: iconst_1
    //   444: istore_2
    //   445: iload_2
    //   446: ifeq +156 -> 602
    //   449: ldc 127
    //   451: new 129	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 475
    //   458: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: aload_1
    //   462: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   465: ldc_w 480
    //   468: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: bipush 9
    //   479: invokestatic 80	com/vungle/publisher/au:a	(I)Z
    //   482: ifeq +265 -> 747
    //   485: bipush 6
    //   487: istore_2
    //   488: aload_0
    //   489: iload_2
    //   490: invokevirtual 483	com/vungle/publisher/FullScreenAdActivity:setRequestedOrientation	(I)V
    //   493: aload_0
    //   494: invokevirtual 484	com/vungle/publisher/FullScreenAdActivity:b	()V
    //   497: aload_0
    //   498: getfield 45	com/vungle/publisher/FullScreenAdActivity:h	Lcom/vungle/publisher/reporting/AdReportingHandler;
    //   501: astore_1
    //   502: invokestatic 215	java/lang/System:currentTimeMillis	()J
    //   505: lstore 4
    //   507: aload_1
    //   508: getfield 209	com/vungle/publisher/reporting/AdReportingHandler:b	Lcom/vungle/publisher/db/model/AdReport;
    //   511: astore_1
    //   512: aload_1
    //   513: getstatic 489	com/vungle/publisher/db/model/AdReport$a:c	Lcom/vungle/publisher/db/model/AdReport$a;
    //   516: invokevirtual 492	com/vungle/publisher/db/model/AdReport:a	(Lcom/vungle/publisher/db/model/AdReport$a;)V
    //   519: aload_1
    //   520: lload 4
    //   522: invokestatic 221	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   525: invokevirtual 494	com/vungle/publisher/db/model/AdReport:b	(Ljava/lang/Long;)V
    //   528: aload_1
    //   529: invokevirtual 495	com/vungle/publisher/db/model/AdReport:l	()I
    //   532: pop
    //   533: aload_0
    //   534: getfield 236	com/vungle/publisher/FullScreenAdActivity:c	Lcom/vungle/publisher/di;
    //   537: ldc_w 497
    //   540: invokevirtual 500	com/vungle/publisher/di:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   543: pop
    //   544: aload_0
    //   545: getfield 236	com/vungle/publisher/FullScreenAdActivity:c	Lcom/vungle/publisher/di;
    //   548: new 502	com/vungle/publisher/x
    //   551: dup
    //   552: invokespecial 503	com/vungle/publisher/x:<init>	()V
    //   555: invokevirtual 244	com/vungle/publisher/di:b	(Ljava/lang/Object;)V
    //   558: return
    //   559: astore_1
    //   560: ldc 127
    //   562: ldc_w 505
    //   565: aload_1
    //   566: invokestatic 186	com/vungle/publisher/log/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   569: aload_0
    //   570: invokevirtual 100	com/vungle/publisher/FullScreenAdActivity:d	()V
    //   573: return
    //   574: ldc 127
    //   576: new 129	java/lang/StringBuilder
    //   579: dup
    //   580: ldc_w 475
    //   583: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   586: aload_1
    //   587: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: bipush 10
    //   598: istore_2
    //   599: goto -111 -> 488
    //   602: iload_3
    //   603: istore_2
    //   604: aload 7
    //   606: getfield 466	com/vungle/publisher/db/model/Video:k	Ljava/lang/Integer;
    //   609: ifnull +36 -> 645
    //   612: iload_3
    //   613: istore_2
    //   614: aload 7
    //   616: getfield 468	com/vungle/publisher/db/model/Video:u	Ljava/lang/Integer;
    //   619: ifnull +26 -> 645
    //   622: iload_3
    //   623: istore_2
    //   624: aload 7
    //   626: getfield 466	com/vungle/publisher/db/model/Video:k	Ljava/lang/Integer;
    //   629: invokevirtual 473	java/lang/Integer:intValue	()I
    //   632: aload 7
    //   634: getfield 468	com/vungle/publisher/db/model/Video:u	Ljava/lang/Integer;
    //   637: invokevirtual 473	java/lang/Integer:intValue	()I
    //   640: if_icmple +5 -> 645
    //   643: iconst_1
    //   644: istore_2
    //   645: iload_2
    //   646: ifeq +45 -> 691
    //   649: ldc 127
    //   651: new 129	java/lang/StringBuilder
    //   654: dup
    //   655: ldc_w 475
    //   658: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   661: aload_1
    //   662: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   665: ldc_w 507
    //   668: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: bipush 9
    //   679: invokestatic 80	com/vungle/publisher/au:a	(I)Z
    //   682: ifeq +70 -> 752
    //   685: bipush 7
    //   687: istore_2
    //   688: goto -200 -> 488
    //   691: ldc 127
    //   693: new 129	java/lang/StringBuilder
    //   696: dup
    //   697: ldc_w 475
    //   700: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   703: aload_1
    //   704: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   707: ldc_w 509
    //   710: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 319	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   719: bipush 10
    //   721: istore_2
    //   722: goto -234 -> 488
    //   725: astore_1
    //   726: ldc_w 294
    //   729: ldc_w 511
    //   732: aload_1
    //   733: invokestatic 288	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   736: goto -203 -> 533
    //   739: goto -331 -> 408
    //   742: iconst_0
    //   743: istore_2
    //   744: goto -299 -> 445
    //   747: iconst_0
    //   748: istore_2
    //   749: goto -261 -> 488
    //   752: iconst_1
    //   753: istore_2
    //   754: goto -266 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	757	0	this	FullScreenAdActivity
    //   0	757	1	paramBundle	android.os.Bundle
    //   444	310	2	m	int
    //   1	622	3	n	int
    //   505	16	4	l	long
    //   51	298	6	localObject1	Object
    //   44	589	7	localObject2	Object
    //   87	163	8	localObject3	Object
    //   197	26	9	localb	b
    //   203	33	10	localAdReportingHandler	AdReportingHandler
    //   187	70	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	65	559	java/lang/Exception
    //   70	82	559	java/lang/Exception
    //   83	178	559	java/lang/Exception
    //   183	261	559	java/lang/Exception
    //   261	279	559	java/lang/Exception
    //   284	372	559	java/lang/Exception
    //   372	408	559	java/lang/Exception
    //   408	443	559	java/lang/Exception
    //   449	485	559	java/lang/Exception
    //   488	507	559	java/lang/Exception
    //   533	558	559	java/lang/Exception
    //   574	596	559	java/lang/Exception
    //   604	612	559	java/lang/Exception
    //   614	622	559	java/lang/Exception
    //   624	643	559	java/lang/Exception
    //   649	685	559	java/lang/Exception
    //   691	719	559	java/lang/Exception
    //   726	736	559	java/lang/Exception
    //   507	533	725	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h.d();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    this.g.a(paramInt);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.e.d();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.e.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.g.a(paramBoolean);
  }
  
  final class a
    extends PostRollFragment.a
  {
    a() {}
    
    public final void a()
    {
      Logger.v("VungleAd", "postRoll.onCancel()");
      FullScreenAdActivity.this.d();
    }
    
    public final void b()
    {
      Logger.v("VungleAd", "postRoll.onCta()");
      FullScreenAdActivity.a(FullScreenAdActivity.this).a(EventTracking.a.i);
      FullScreenAdActivity.a(FullScreenAdActivity.this).a(AdReportEvent.a.d, null);
      FullScreenAdActivity.this.c();
    }
    
    public final void c()
    {
      Logger.v("VungleAd", "postRoll.onRepeat()");
      FullScreenAdActivity.this.b();
      AdReportingHandler localAdReportingHandler = FullScreenAdActivity.a(FullScreenAdActivity.this);
      try
      {
        localAdReportingHandler.a(AdReportEvent.a.h, null);
        localAdReportingHandler.c = localAdReportingHandler.b.k();
        return;
      }
      catch (Exception localException)
      {
        Logger.w("VungleReport", "error reporting replay", localException);
      }
    }
  }
  
  final class b
    implements VideoFragment.a
  {
    b() {}
    
    public final void a()
    {
      Logger.v("VungleAd", "video.onCancel()");
      FullScreenAdActivity.this.a(true);
    }
    
    public final void b()
    {
      Logger.v("VungleAd", "video.onCta()");
      FullScreenAdActivity.a(FullScreenAdActivity.this).a(AdReportEvent.a.e, null);
      FullScreenAdActivity.this.c();
    }
    
    public final void c()
    {
      Logger.v("VungleAd", "video.onNext()");
      FullScreenAdActivity.this.a(false);
    }
  }
  
  final class c
    implements aw.a
  {
    c() {}
    
    public final void a()
    {
      FullScreenAdActivity.this.d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/FullScreenAdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */