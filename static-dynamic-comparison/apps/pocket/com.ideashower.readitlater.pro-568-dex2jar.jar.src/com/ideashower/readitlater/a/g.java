package com.ideashower.readitlater.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.view.Window;
import android.widget.Toast;
import com.ideashower.readitlater.activity.AppCacheCheckActivity;
import com.ideashower.readitlater.activity.GiftMessageActivity;
import com.ideashower.readitlater.activity.SplashActivity;
import com.ideashower.readitlater.activity.UpdatedActivity;
import com.ideashower.readitlater.activity.a.s;
import com.ideashower.readitlater.db.operation.action.UiContext;
import com.ideashower.readitlater.service.WakefulAppService;
import com.pocket.oauth.PocketAuthorizeAppActivity;
import com.pocket.p.r;
import com.pocket.stats.f;
import com.pocket.user.UserMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
  extends Application
{
  protected static boolean a = false;
  private static com.pocket.g.a b;
  private static g c;
  private static Handler d;
  private static com.ideashower.readitlater.activity.a e;
  private static final AtomicBoolean f = new AtomicBoolean(false);
  private static Thread g;
  private static boolean h = false;
  private static boolean i;
  private static boolean j;
  private static boolean k = false;
  private static boolean l = false;
  private static boolean m = false;
  private static boolean n = false;
  private static boolean o = false;
  private static int p = 0;
  private static boolean q = false;
  private static m r;
  private static ai s;
  private static ArrayList t = new ArrayList();
  private static boolean u;
  private static Locale v = null;
  private static ArrayList w = new ArrayList();
  
  public g()
  {
    c = this;
    g = Thread.currentThread();
    b = a();
    if (b == null) {
      throw new RuntimeException("missing build version");
    }
    d = new Handler();
    r = new m(this);
  }
  
  private void B()
  {
    boolean bool = false;
    PackageManager localPackageManager = getPackageManager();
    try
    {
      if ((localPackageManager.getPackageInfo(getPackageName(), 0).applicationInfo.flags & 0x40000) == 262144) {
        bool = true;
      }
      n = bool;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("missing package name");
    }
  }
  
  /* Error */
  private void C()
  {
    // Byte code:
    //   0: getstatic 59	com/ideashower/readitlater/a/g:h	Z
    //   3: ifne +16 -> 19
    //   6: getstatic 161	com/ideashower/readitlater/h/a:aS	Lcom/ideashower/readitlater/h/b;
    //   9: invokestatic 166	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/b;)Z
    //   12: ifne +7 -> 19
    //   15: aload_0
    //   16: invokespecial 169	com/ideashower/readitlater/a/g:D	()V
    //   19: getstatic 100	com/ideashower/readitlater/a/g:b	Lcom/pocket/g/a;
    //   22: invokevirtual 174	com/pocket/g/a:j	()I
    //   25: istore_3
    //   26: getstatic 178	com/ideashower/readitlater/h/a:X	Lcom/ideashower/readitlater/h/d;
    //   29: invokestatic 181	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/d;)I
    //   32: istore 4
    //   34: iload_3
    //   35: iload 4
    //   37: if_icmple +34 -> 71
    //   40: invokestatic 184	com/ideashower/readitlater/h/i:b	()Lcom/ideashower/readitlater/h/l;
    //   43: astore 6
    //   45: iload 4
    //   47: putstatic 71	com/ideashower/readitlater/a/g:p	I
    //   50: iload 4
    //   52: ifne +20 -> 72
    //   55: aload 6
    //   57: getstatic 178	com/ideashower/readitlater/h/a:X	Lcom/ideashower/readitlater/h/d;
    //   60: iload_3
    //   61: invokevirtual 189	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/d;I)Lcom/ideashower/readitlater/h/l;
    //   64: pop
    //   65: aload 6
    //   67: invokevirtual 192	com/ideashower/readitlater/h/l:a	()Z
    //   70: pop
    //   71: return
    //   72: iload 4
    //   74: bipush 70
    //   76: if_icmpge +1257 -> 1333
    //   79: iload 4
    //   81: bipush 74
    //   83: if_icmpge +6 -> 89
    //   86: invokestatic 196	com/pocket/c/e:k	()V
    //   89: iload 4
    //   91: bipush 78
    //   93: if_icmpge +10 -> 103
    //   96: invokestatic 199	com/ideashower/readitlater/a/g:c	()Landroid/content/Context;
    //   99: iconst_0
    //   100: invokestatic 204	com/ideashower/readitlater/a/am:a	(Landroid/content/Context;Z)V
    //   103: iload 4
    //   105: bipush 99
    //   107: if_icmpge +18 -> 125
    //   110: aload 6
    //   112: getstatic 207	com/ideashower/readitlater/h/a:bc	Lcom/ideashower/readitlater/h/d;
    //   115: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   118: getstatic 213	com/ideashower/readitlater/h/a:bd	Lcom/ideashower/readitlater/h/d;
    //   121: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   124: pop
    //   125: iload 4
    //   127: bipush 121
    //   129: if_icmpge +22 -> 151
    //   132: getstatic 216	com/ideashower/readitlater/h/a:a	Lcom/ideashower/readitlater/h/h;
    //   135: invokestatic 219	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/h;)Ljava/lang/String;
    //   138: ifnull +13 -> 151
    //   141: aload 6
    //   143: getstatic 222	com/ideashower/readitlater/h/a:bh	Lcom/ideashower/readitlater/h/b;
    //   146: iconst_1
    //   147: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   150: pop
    //   151: iload 4
    //   153: bipush 122
    //   155: if_icmpge +36 -> 191
    //   158: iconst_0
    //   159: invokestatic 230	com/ideashower/readitlater/util/j:a	(Z)Z
    //   162: ifeq +6 -> 168
    //   165: invokestatic 234	com/ideashower/readitlater/util/q:a	()V
    //   168: iload_3
    //   169: bipush 122
    //   171: if_icmpne +20 -> 191
    //   174: iload 4
    //   176: bipush 121
    //   178: if_icmpne +13 -> 191
    //   181: aload 6
    //   183: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   186: iconst_0
    //   187: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   190: pop
    //   191: iload 4
    //   193: sipush 141
    //   196: if_icmpge +9 -> 205
    //   199: invokestatic 241	com/ideashower/readitlater/util/a:n	()Z
    //   202: ifeq +3 -> 205
    //   205: iload 4
    //   207: sipush 142
    //   210: if_icmpge +28 -> 238
    //   213: iload_3
    //   214: sipush 142
    //   217: if_icmpne +21 -> 238
    //   220: iload 4
    //   222: sipush 141
    //   225: if_icmpne +13 -> 238
    //   228: aload 6
    //   230: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   233: iconst_0
    //   234: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   237: pop
    //   238: iload 4
    //   240: sipush 150
    //   243: if_icmpge +84 -> 327
    //   246: getstatic 100	com/ideashower/readitlater/a/g:b	Lcom/pocket/g/a;
    //   249: invokevirtual 242	com/pocket/g/a:a	()Z
    //   252: ifeq +11 -> 263
    //   255: iload 4
    //   257: sipush 142
    //   260: if_icmpgt +67 -> 327
    //   263: getstatic 245	com/ideashower/readitlater/h/a:J	Lcom/ideashower/readitlater/h/d;
    //   266: invokestatic 181	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/d;)I
    //   269: iconst_1
    //   270: isub
    //   271: istore_2
    //   272: iload_2
    //   273: iflt +10 -> 283
    //   276: iload_2
    //   277: istore_1
    //   278: iload_2
    //   279: iconst_4
    //   280: if_icmple +5 -> 285
    //   283: iconst_4
    //   284: istore_1
    //   285: aload 6
    //   287: getstatic 245	com/ideashower/readitlater/h/a:J	Lcom/ideashower/readitlater/h/d;
    //   290: iload_1
    //   291: invokevirtual 189	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/d;I)Lcom/ideashower/readitlater/h/l;
    //   294: pop
    //   295: getstatic 248	com/ideashower/readitlater/h/a:F	Lcom/ideashower/readitlater/h/d;
    //   298: invokevirtual 252	com/ideashower/readitlater/h/d:b	()Ljava/lang/String;
    //   301: ldc -2
    //   303: invokestatic 257	com/ideashower/readitlater/h/i:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: ldc_w 259
    //   309: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +1057 -> 1369
    //   315: iconst_1
    //   316: istore_1
    //   317: aload 6
    //   319: getstatic 248	com/ideashower/readitlater/h/a:F	Lcom/ideashower/readitlater/h/d;
    //   322: iload_1
    //   323: invokevirtual 189	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/d;I)Lcom/ideashower/readitlater/h/l;
    //   326: pop
    //   327: iload 4
    //   329: sipush 152
    //   332: if_icmpge +28 -> 360
    //   335: iload_3
    //   336: sipush 152
    //   339: if_icmpne +21 -> 360
    //   342: iload 4
    //   344: sipush 150
    //   347: if_icmpne +13 -> 360
    //   350: aload 6
    //   352: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   355: iconst_0
    //   356: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   359: pop
    //   360: iload 4
    //   362: sipush 153
    //   365: if_icmpge +36 -> 401
    //   368: iload_3
    //   369: sipush 153
    //   372: if_icmpne +29 -> 401
    //   375: iload 4
    //   377: sipush 150
    //   380: if_icmpeq +11 -> 391
    //   383: iload 4
    //   385: sipush 152
    //   388: if_icmpne +13 -> 401
    //   391: aload 6
    //   393: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   396: iconst_0
    //   397: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   400: pop
    //   401: iload 4
    //   403: sipush 155
    //   406: if_icmpge +28 -> 434
    //   409: iload_3
    //   410: sipush 155
    //   413: if_icmpne +21 -> 434
    //   416: iload 4
    //   418: sipush 150
    //   421: if_icmplt +13 -> 434
    //   424: aload 6
    //   426: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   429: iconst_0
    //   430: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   433: pop
    //   434: iload 4
    //   436: sipush 156
    //   439: if_icmpge +28 -> 467
    //   442: iload_3
    //   443: sipush 156
    //   446: if_icmpne +21 -> 467
    //   449: iload 4
    //   451: sipush 150
    //   454: if_icmplt +13 -> 467
    //   457: aload 6
    //   459: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   462: iconst_0
    //   463: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   466: pop
    //   467: iload 4
    //   469: sipush 157
    //   472: if_icmpge +28 -> 500
    //   475: iload_3
    //   476: sipush 157
    //   479: if_icmpne +21 -> 500
    //   482: iload 4
    //   484: sipush 150
    //   487: if_icmplt +13 -> 500
    //   490: aload 6
    //   492: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   495: iconst_0
    //   496: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   499: pop
    //   500: iload 4
    //   502: sipush 168
    //   505: if_icmpge +111 -> 616
    //   508: getstatic 268	com/ideashower/readitlater/h/a:bx	Lcom/ideashower/readitlater/h/h;
    //   511: invokestatic 219	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/h;)Ljava/lang/String;
    //   514: astore 7
    //   516: aload 7
    //   518: ifnull +20 -> 538
    //   521: aload 7
    //   523: invokevirtual 271	java/lang/String:length	()I
    //   526: iconst_1
    //   527: if_icmpne +857 -> 1384
    //   530: aload 7
    //   532: invokestatic 277	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   535: invokestatic 282	com/ideashower/readitlater/views/ad:a	(I)V
    //   538: getstatic 285	com/ideashower/readitlater/h/a:by	Lcom/ideashower/readitlater/h/h;
    //   541: invokestatic 219	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/h;)Ljava/lang/String;
    //   544: astore 7
    //   546: aload 7
    //   548: ifnull +20 -> 568
    //   551: aload 7
    //   553: invokevirtual 271	java/lang/String:length	()I
    //   556: iconst_1
    //   557: if_icmpne +845 -> 1402
    //   560: aload 7
    //   562: invokestatic 277	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   565: invokestatic 282	com/ideashower/readitlater/views/ad:a	(I)V
    //   568: aload 6
    //   570: getstatic 268	com/ideashower/readitlater/h/a:bx	Lcom/ideashower/readitlater/h/h;
    //   573: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   576: pop
    //   577: aload 6
    //   579: getstatic 285	com/ideashower/readitlater/h/a:by	Lcom/ideashower/readitlater/h/h;
    //   582: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   585: pop
    //   586: invokestatic 199	com/ideashower/readitlater/a/g:c	()Landroid/content/Context;
    //   589: iconst_0
    //   590: invokestatic 204	com/ideashower/readitlater/a/am:a	(Landroid/content/Context;Z)V
    //   593: invokestatic 287	com/pocket/c/e:s	()V
    //   596: aload 6
    //   598: getstatic 290	com/ideashower/readitlater/h/a:aX	Lcom/ideashower/readitlater/h/b;
    //   601: iconst_1
    //   602: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   605: pop
    //   606: aload 6
    //   608: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   611: iconst_0
    //   612: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   615: pop
    //   616: iload 4
    //   618: sipush 173
    //   621: if_icmpge +28 -> 649
    //   624: iload_3
    //   625: sipush 173
    //   628: if_icmpne +21 -> 649
    //   631: iload 4
    //   633: sipush 172
    //   636: if_icmpne +13 -> 649
    //   639: aload 6
    //   641: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   644: iconst_0
    //   645: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   648: pop
    //   649: iload 4
    //   651: sipush 174
    //   654: if_icmpge +20 -> 674
    //   657: iload_3
    //   658: sipush 174
    //   661: if_icmpne +13 -> 674
    //   664: aload 6
    //   666: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   669: iconst_0
    //   670: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   673: pop
    //   674: iload 4
    //   676: sipush 176
    //   679: if_icmpge +20 -> 699
    //   682: iload_3
    //   683: sipush 176
    //   686: if_icmpne +13 -> 699
    //   689: aload 6
    //   691: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   694: iconst_0
    //   695: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   698: pop
    //   699: iload 4
    //   701: sipush 177
    //   704: if_icmpge +20 -> 724
    //   707: iload_3
    //   708: sipush 177
    //   711: if_icmpne +13 -> 724
    //   714: aload 6
    //   716: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   719: iconst_0
    //   720: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   723: pop
    //   724: iload 4
    //   726: sipush 178
    //   729: if_icmpge +20 -> 749
    //   732: iload_3
    //   733: sipush 178
    //   736: if_icmpne +13 -> 749
    //   739: aload 6
    //   741: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   744: iconst_0
    //   745: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   748: pop
    //   749: iload 4
    //   751: sipush 179
    //   754: if_icmpge +20 -> 774
    //   757: iload_3
    //   758: sipush 179
    //   761: if_icmpne +13 -> 774
    //   764: aload 6
    //   766: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   769: iconst_0
    //   770: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   773: pop
    //   774: iload 4
    //   776: sipush 180
    //   779: if_icmpge +41 -> 820
    //   782: iload_3
    //   783: sipush 180
    //   786: if_icmpne +13 -> 799
    //   789: aload 6
    //   791: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   794: iconst_0
    //   795: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   798: pop
    //   799: aload 6
    //   801: getstatic 293	com/ideashower/readitlater/h/a:ca	Lcom/ideashower/readitlater/h/h;
    //   804: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   807: getstatic 296	com/ideashower/readitlater/h/a:cb	Lcom/ideashower/readitlater/h/h;
    //   810: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   813: getstatic 299	com/ideashower/readitlater/h/a:cc	Lcom/ideashower/readitlater/h/h;
    //   816: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   819: pop
    //   820: iload 4
    //   822: sipush 182
    //   825: if_icmpge +84 -> 909
    //   828: getstatic 216	com/ideashower/readitlater/h/a:a	Lcom/ideashower/readitlater/h/h;
    //   831: invokestatic 219	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/h;)Ljava/lang/String;
    //   834: ifnull +75 -> 909
    //   837: getstatic 302	com/ideashower/readitlater/h/a:bE	Lcom/ideashower/readitlater/h/b;
    //   840: astore 7
    //   842: getstatic 305	com/ideashower/readitlater/h/a:bG	Lcom/ideashower/readitlater/h/d;
    //   845: invokestatic 181	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/d;)I
    //   848: ifeq +562 -> 1410
    //   851: iconst_1
    //   852: istore 5
    //   854: aload 6
    //   856: aload 7
    //   858: iload 5
    //   860: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   863: getstatic 308	com/ideashower/readitlater/h/a:bK	Lcom/ideashower/readitlater/h/b;
    //   866: iconst_1
    //   867: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   870: getstatic 311	com/ideashower/readitlater/h/a:bU	Lcom/ideashower/readitlater/h/d;
    //   873: iconst_2
    //   874: invokevirtual 189	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/d;I)Lcom/ideashower/readitlater/h/l;
    //   877: getstatic 314	com/ideashower/readitlater/h/a:bX	Lcom/ideashower/readitlater/h/b;
    //   880: iconst_1
    //   881: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   884: getstatic 317	com/ideashower/readitlater/h/a:bW	Lcom/ideashower/readitlater/h/b;
    //   887: iconst_1
    //   888: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   891: getstatic 320	com/ideashower/readitlater/h/a:bV	Lcom/ideashower/readitlater/h/b;
    //   894: iconst_1
    //   895: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   898: getstatic 323	com/ideashower/readitlater/h/a:bY	Lcom/ideashower/readitlater/h/b;
    //   901: iconst_1
    //   902: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   905: pop
    //   906: invokestatic 287	com/pocket/c/e:s	()V
    //   909: iload 4
    //   911: sipush 182
    //   914: if_icmpne +20 -> 934
    //   917: iload_3
    //   918: sipush 183
    //   921: if_icmpne +13 -> 934
    //   924: aload 6
    //   926: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   929: iconst_0
    //   930: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   933: pop
    //   934: iload 4
    //   936: sipush 184
    //   939: if_icmpge +57 -> 996
    //   942: iload 4
    //   944: sipush 182
    //   947: if_icmpeq +11 -> 958
    //   950: iload 4
    //   952: sipush 183
    //   955: if_icmpne +20 -> 975
    //   958: iload_3
    //   959: sipush 184
    //   962: if_icmpne +13 -> 975
    //   965: aload 6
    //   967: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   970: iconst_0
    //   971: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   974: pop
    //   975: aload 6
    //   977: getstatic 293	com/ideashower/readitlater/h/a:ca	Lcom/ideashower/readitlater/h/h;
    //   980: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   983: getstatic 296	com/ideashower/readitlater/h/a:cb	Lcom/ideashower/readitlater/h/h;
    //   986: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   989: getstatic 299	com/ideashower/readitlater/h/a:cc	Lcom/ideashower/readitlater/h/h;
    //   992: invokevirtual 210	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/f;)Lcom/ideashower/readitlater/h/l;
    //   995: pop
    //   996: iload 4
    //   998: sipush 251
    //   1001: if_icmpge +10 -> 1011
    //   1004: invokestatic 199	com/ideashower/readitlater/a/g:c	()Landroid/content/Context;
    //   1007: iconst_0
    //   1008: invokestatic 204	com/ideashower/readitlater/a/am:a	(Landroid/content/Context;Z)V
    //   1011: iload 4
    //   1013: sipush 252
    //   1016: if_icmpge +28 -> 1044
    //   1019: iload 4
    //   1021: sipush 251
    //   1024: if_icmpne +20 -> 1044
    //   1027: iload_3
    //   1028: sipush 252
    //   1031: if_icmpne +13 -> 1044
    //   1034: aload 6
    //   1036: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1039: iconst_0
    //   1040: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1043: pop
    //   1044: iload 4
    //   1046: sipush 500
    //   1049: if_icmpge +26 -> 1075
    //   1052: invokestatic 287	com/pocket/c/e:s	()V
    //   1055: aload 6
    //   1057: getstatic 290	com/ideashower/readitlater/h/a:aX	Lcom/ideashower/readitlater/h/b;
    //   1060: iconst_1
    //   1061: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1064: pop
    //   1065: aload 6
    //   1067: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1070: iconst_0
    //   1071: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1074: pop
    //   1075: iload 4
    //   1077: sipush 500
    //   1080: if_icmplt +20 -> 1100
    //   1083: iload_3
    //   1084: sipush 502
    //   1087: if_icmpgt +13 -> 1100
    //   1090: aload 6
    //   1092: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1095: iconst_0
    //   1096: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1099: pop
    //   1100: iload 4
    //   1102: sipush 510
    //   1105: if_icmplt +20 -> 1125
    //   1108: iload_3
    //   1109: sipush 512
    //   1112: if_icmpgt +13 -> 1125
    //   1115: aload 6
    //   1117: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1120: iconst_0
    //   1121: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1124: pop
    //   1125: iload 4
    //   1127: sipush 510
    //   1130: if_icmplt +20 -> 1150
    //   1133: iload_3
    //   1134: sipush 520
    //   1137: if_icmpgt +13 -> 1150
    //   1140: aload 6
    //   1142: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1145: iconst_0
    //   1146: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1149: pop
    //   1150: iload 4
    //   1152: sipush 530
    //   1155: if_icmplt +20 -> 1175
    //   1158: iload_3
    //   1159: sipush 533
    //   1162: if_icmpgt +13 -> 1175
    //   1165: aload 6
    //   1167: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1170: iconst_0
    //   1171: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1174: pop
    //   1175: iload 4
    //   1177: sipush 550
    //   1180: if_icmpge +49 -> 1229
    //   1183: invokestatic 287	com/pocket/c/e:s	()V
    //   1186: aload 6
    //   1188: getstatic 290	com/ideashower/readitlater/h/a:aX	Lcom/ideashower/readitlater/h/b;
    //   1191: iconst_0
    //   1192: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1195: pop
    //   1196: aload 6
    //   1198: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1201: iconst_1
    //   1202: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1205: pop
    //   1206: getstatic 216	com/ideashower/readitlater/h/a:a	Lcom/ideashower/readitlater/h/h;
    //   1209: invokestatic 219	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/h;)Ljava/lang/String;
    //   1212: invokestatic 328	org/apache/a/c/k:a	(Ljava/lang/CharSequence;)Z
    //   1215: ifne +201 -> 1416
    //   1218: iconst_1
    //   1219: istore 5
    //   1221: invokestatic 330	com/ideashower/readitlater/a/g:b	()Lcom/pocket/g/a;
    //   1224: iload 5
    //   1226: invokevirtual 332	com/pocket/g/a:b	(Z)V
    //   1229: iload 4
    //   1231: sipush 550
    //   1234: if_icmplt +20 -> 1254
    //   1237: iload_3
    //   1238: sipush 557
    //   1241: if_icmpgt +13 -> 1254
    //   1244: aload 6
    //   1246: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1249: iconst_0
    //   1250: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1253: pop
    //   1254: iload 4
    //   1256: sipush 555
    //   1259: if_icmpge +15 -> 1274
    //   1262: getstatic 336	com/ideashower/readitlater/h/a:ad	Lcom/ideashower/readitlater/h/e;
    //   1265: getstatic 339	com/ideashower/readitlater/h/a:ac	Lcom/ideashower/readitlater/h/e;
    //   1268: invokestatic 342	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/e;)J
    //   1271: invokestatic 345	com/ideashower/readitlater/h/i:a	(Lcom/ideashower/readitlater/h/e;J)V
    //   1274: iload 4
    //   1276: sipush 560
    //   1279: if_icmpge +26 -> 1305
    //   1282: invokestatic 349	com/pocket/m/a/a/c:d	()V
    //   1285: aload 6
    //   1287: getstatic 290	com/ideashower/readitlater/h/a:aX	Lcom/ideashower/readitlater/h/b;
    //   1290: iconst_0
    //   1291: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1294: pop
    //   1295: aload 6
    //   1297: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1300: iconst_1
    //   1301: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1304: pop
    //   1305: iload 4
    //   1307: sipush 560
    //   1310: if_icmplt -1255 -> 55
    //   1313: iload_3
    //   1314: sipush 570
    //   1317: if_icmpge -1262 -> 55
    //   1320: aload 6
    //   1322: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1325: iconst_0
    //   1326: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1329: pop
    //   1330: goto -1275 -> 55
    //   1333: getstatic 237	com/ideashower/readitlater/h/a:bg	Lcom/ideashower/readitlater/h/b;
    //   1336: astore 7
    //   1338: getstatic 100	com/ideashower/readitlater/a/g:b	Lcom/pocket/g/a;
    //   1341: invokevirtual 351	com/pocket/g/a:f	()Z
    //   1344: ifeq +19 -> 1363
    //   1347: iconst_1
    //   1348: istore 5
    //   1350: aload 6
    //   1352: aload 7
    //   1354: iload 5
    //   1356: invokevirtual 225	com/ideashower/readitlater/h/l:a	(Lcom/ideashower/readitlater/h/b;Z)Lcom/ideashower/readitlater/h/l;
    //   1359: pop
    //   1360: goto -1281 -> 79
    //   1363: iconst_0
    //   1364: istore 5
    //   1366: goto -16 -> 1350
    //   1369: iconst_0
    //   1370: istore_1
    //   1371: goto -1054 -> 317
    //   1374: astore 7
    //   1376: aload 7
    //   1378: invokestatic 356	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1381: goto -843 -> 538
    //   1384: aload 7
    //   1386: invokestatic 358	com/ideashower/readitlater/views/ad:a	(Ljava/lang/String;)V
    //   1389: goto -851 -> 538
    //   1392: astore 7
    //   1394: aload 7
    //   1396: invokestatic 356	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   1399: goto -831 -> 568
    //   1402: aload 7
    //   1404: invokestatic 358	com/ideashower/readitlater/views/ad:a	(Ljava/lang/String;)V
    //   1407: goto -839 -> 568
    //   1410: iconst_0
    //   1411: istore 5
    //   1413: goto -559 -> 854
    //   1416: iconst_0
    //   1417: istore 5
    //   1419: goto -198 -> 1221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1422	0	this	g
    //   277	1094	1	i1	int
    //   271	10	2	i2	int
    //   25	1293	3	i3	int
    //   32	1279	4	i4	int
    //   852	566	5	bool	boolean
    //   43	1308	6	locall	com.ideashower.readitlater.h.l
    //   514	839	7	localObject	Object
    //   1374	11	7	localNumberFormatException1	NumberFormatException
    //   1392	11	7	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   530	538	1374	java/lang/NumberFormatException
    //   560	568	1392	java/lang/NumberFormatException
  }
  
  private void D()
  {
    com.pocket.m.a.l.a();
    com.pocket.m.a.l.c().d();
    c.deleteDatabase("ril");
    com.ideashower.readitlater.h.a.a();
  }
  
  private static void E()
  {
    com.ideashower.readitlater.g.g.e();
    as.a();
    com.pocket.m.a.l.a();
    com.pocket.m.a.e.a();
    am.a();
    q.a();
    w.a();
    x.a();
    com.ideashower.readitlater.a.a.a.a();
    com.pocket.m.a.a(o());
    com.ideashower.readitlater.db.operation.d.a();
    com.pocket.c.e.a();
    l.a(c());
    o.a();
    if (y()) {
      r.a();
    }
    s = new ai();
  }
  
  private static void F()
  {
    com.ideashower.readitlater.g.g.f();
    as.b();
    com.pocket.m.a.l.b();
    com.pocket.m.a.e.b();
    am.b();
    q.b();
    w.b();
    x.b();
    com.ideashower.readitlater.a.a.a.b();
    com.pocket.m.a.a();
    com.ideashower.readitlater.db.operation.d.b();
    com.pocket.c.e.b();
    l.a();
    o.b();
    a.b();
    com.pocket.m.a.a.c.a();
  }
  
  private static boolean G()
  {
    return ((ActivityManager)c().getSystemService("activity")).isLowRamDevice();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    return c.getString(paramInt);
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 474	java/io/FileInputStream
    //   3: dup
    //   4: new 476	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 477	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 480	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_0
    //   16: aload_0
    //   17: astore_3
    //   18: aload_0
    //   19: invokevirtual 484	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   22: invokevirtual 490	java/nio/channels/FileChannel:size	()J
    //   25: lstore_1
    //   26: lload_1
    //   27: invokestatic 494	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: astore 4
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: ifnull +10 -> 46
    //   39: aload_0
    //   40: invokevirtual 497	java/io/FileInputStream:close	()V
    //   43: aload 4
    //   45: astore_3
    //   46: aload_3
    //   47: areturn
    //   48: astore 4
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: astore_3
    //   54: aload 4
    //   56: invokestatic 356	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: astore_3
    //   61: new 499	java/io/StringWriter
    //   64: dup
    //   65: invokespecial 500	java/io/StringWriter:<init>	()V
    //   68: astore 5
    //   70: aload_0
    //   71: astore_3
    //   72: aload 4
    //   74: new 502	java/io/PrintWriter
    //   77: dup
    //   78: aload 5
    //   80: invokespecial 505	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   83: invokevirtual 509	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   86: aload_0
    //   87: astore_3
    //   88: aload 5
    //   90: invokevirtual 512	java/io/StringWriter:toString	()Ljava/lang/String;
    //   93: astore 4
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: ifnull -53 -> 46
    //   102: aload_0
    //   103: invokevirtual 497	java/io/FileInputStream:close	()V
    //   106: aload 4
    //   108: areturn
    //   109: astore_0
    //   110: aload 4
    //   112: areturn
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_3
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 497	java/io/FileInputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: astore_0
    //   127: aload 4
    //   129: areturn
    //   130: astore_3
    //   131: goto -7 -> 124
    //   134: astore_0
    //   135: goto -19 -> 116
    //   138: astore 4
    //   140: goto -88 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   25	2	1	l1	long
    //   17	104	3	localObject	Object
    //   130	1	3	localIOException	java.io.IOException
    //   30	14	4	str1	String
    //   48	25	4	localThrowable1	Throwable
    //   93	35	4	str2	String
    //   138	1	4	localThrowable2	Throwable
    //   68	21	5	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   0	16	48	java/lang/Throwable
    //   102	106	109	java/io/IOException
    //   0	16	113	finally
    //   39	43	126	java/io/IOException
    //   120	124	130	java/io/IOException
    //   18	26	134	finally
    //   54	59	134	finally
    //   61	70	134	finally
    //   72	86	134	finally
    //   88	95	134	finally
    //   18	26	138	java/lang/Throwable
  }
  
  public static void a(Activity paramActivity)
  {
    if ((!b.e()) || (l)) {
      return;
    }
    l = true;
    a.a.a.l.a(paramActivity, b.b());
  }
  
  public static void a(h paramh)
  {
    i();
    t.add(paramh);
  }
  
  public static void a(i parami)
  {
    w.add(parami);
  }
  
  public static void a(final com.ideashower.readitlater.activity.a parama)
  {
    if ((u) || (!as.l())) {
      return;
    }
    u = true;
    com.ideashower.readitlater.activity.a.l locall;
    if (parama != null)
    {
      locall = new com.ideashower.readitlater.activity.a.l();
      locall.a(null, 2131493109);
      locall.a(parama);
      parama.getWindow().setBackgroundDrawableResource(2130837829);
      parama.r();
    }
    for (;;)
    {
      try
      {
        parama.k().j();
        new ac(new ae()
        {
          public void a(boolean paramAnonymousBoolean, ArrayList paramAnonymousArrayList)
          {
            if (!paramAnonymousBoolean) {
              throw new RuntimeException("Logout failed");
            }
            com.ideashower.readitlater.service.b.b(g.c());
            g.A().deleteDatabase("webview.db");
            g.A().deleteDatabase("webviewCache.db");
            com.ideashower.readitlater.h.i.f();
            ac.a(false);
            com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.u, true).a(com.ideashower.readitlater.h.a.v, false).a();
            paramAnonymousArrayList = paramAnonymousArrayList.iterator();
            while (paramAnonymousArrayList.hasNext()) {
              ((ag)paramAnonymousArrayList.next()).c();
            }
            if (g.this != null) {
              g.this.b();
            }
            paramAnonymousArrayList = new Intent();
            paramAnonymousArrayList.setAction("com.ideashower.readitlater.ACTION_LOGOUT");
            g.c().sendBroadcast(paramAnonymousArrayList);
            if (parama != null)
            {
              parama.q();
              parama.overridePendingTransition(0, 0);
              parama.finish();
            }
            com.pocket.e.a.b();
            g.b(false);
          }
        }).a();
        return;
      }
      catch (Throwable localThrowable)
      {
        com.ideashower.readitlater.util.e.a(localThrowable, true);
        continue;
      }
      locall = null;
    }
  }
  
  private static void a(com.pocket.c.b paramb, SplashActivity paramSplashActivity)
  {
    int i1 = 0;
    boolean bool1;
    boolean bool2;
    if (paramb == com.pocket.c.b.a)
    {
      bool1 = true;
      am.b(c());
      if (as.u()) {
        v.l();
      }
      paramb = com.ideashower.readitlater.h.i.b();
      Object localObject = com.ideashower.readitlater.h.a.aO;
      if (bool1) {
        break label245;
      }
      bool2 = true;
      label42:
      paramb = paramb.a((com.ideashower.readitlater.h.b)localObject, bool2).a(com.ideashower.readitlater.h.a.aU, true).a(com.ideashower.readitlater.h.a.aV, true).a(com.ideashower.readitlater.h.a.aW, true).a(com.ideashower.readitlater.h.a.aG, bool1).a(com.ideashower.readitlater.h.a.aR, bool1).a(com.ideashower.readitlater.h.a.aI, false).a(com.ideashower.readitlater.h.a.w, bool1).a(com.ideashower.readitlater.h.a.bJ, bool1);
      localObject = com.ideashower.readitlater.h.a.bV;
      if (bool1) {
        break label251;
      }
      bool2 = true;
      label119:
      paramb = paramb.a((com.ideashower.readitlater.h.b)localObject, bool2);
      localObject = com.ideashower.readitlater.h.a.bW;
      if (bool1) {
        break label257;
      }
      bool2 = true;
      label140:
      paramb = paramb.a((com.ideashower.readitlater.h.b)localObject, bool2);
      localObject = com.ideashower.readitlater.h.a.bX;
      if (bool1) {
        break label263;
      }
      bool2 = true;
      label161:
      paramb = paramb.a((com.ideashower.readitlater.h.b)localObject, bool2);
      localObject = com.ideashower.readitlater.h.a.bU;
      if (!bool1) {
        break label269;
      }
      label179:
      paramb.a((com.ideashower.readitlater.h.d)localObject, i1).a();
      com.pocket.c.e.l();
      o = true;
      com.pocket.articleprovider.m.e();
      com.pocket.e.a.c();
      paramSplashActivity.sendBroadcast(new Intent("com.ideashower.readitlater.ACTION_LOGIN"));
      if (!paramSplashActivity.getIntent().hasExtra("com.pocket.oauth.extra.app_auth")) {
        break label274;
      }
      PocketAuthorizeAppActivity.a(paramSplashActivity);
    }
    for (;;)
    {
      paramSplashActivity.finish();
      return;
      bool1 = false;
      break;
      label245:
      bool2 = false;
      break label42;
      label251:
      bool2 = false;
      break label119;
      label257:
      bool2 = false;
      break label140;
      label263:
      bool2 = false;
      break label161;
      label269:
      i1 = 2;
      break label179;
      label274:
      paramSplashActivity.q();
    }
  }
  
  public static void a(com.pocket.c.b paramb, UserMeta paramUserMeta, String paramString, SplashActivity paramSplashActivity)
  {
    as.a(paramUserMeta, paramString);
    a(paramb, paramSplashActivity);
  }
  
  public static void a(com.pocket.c.b paramb, UserMeta paramUserMeta, String paramString1, SplashActivity paramSplashActivity, String paramString2, boolean paramBoolean)
  {
    as.a(paramUserMeta, paramString1, paramString2);
    if (paramBoolean) {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.n, true).a();
    }
    if (paramString2 != null) {}
    for (;;)
    {
      Toast.makeText(paramSplashActivity, paramSplashActivity.getString(2131493445, new Object[] { paramString2 }), 1).show();
      a(paramb, paramSplashActivity);
      return;
      paramString2 = paramUserMeta.a();
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    d.post(paramRunnable);
  }
  
  public static void a(boolean paramBoolean, com.ideashower.readitlater.activity.a parama)
  {
    com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.L, paramBoolean).a(com.ideashower.readitlater.h.a.M, false).a();
    com.pocket.m.a.l.a(2, true, new Runnable()
    {
      public void run() {}
    }, false);
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, true);
  }
  
  public static boolean a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(524288);
    if (com.pocket.p.o.a(paramActivity, paramString))
    {
      paramActivity.startActivity(paramString);
      bool = true;
    }
    while (!paramBoolean) {
      return bool;
    }
    new AlertDialog.Builder(paramActivity).setTitle(2131493049).setMessage(2131493048).setNeutralButton(2131492924, null).show();
    return false;
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (q != paramBoolean)
    {
      if (e != null) {}
      for (Object localObject = e.z();; localObject = null)
      {
        new com.ideashower.readitlater.db.operation.action.h(paramBoolean, (UiContext)localObject).j();
        q = paramBoolean;
        if (!paramBoolean) {
          com.pocket.c.e.m();
        }
        com.pocket.gsf.e.a(paramBoolean);
        localObject = w.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).a(paramBoolean);
        }
      }
      return true;
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    return c().getResources().getInteger(paramInt);
  }
  
  public static com.pocket.g.a b()
  {
    return b;
  }
  
  public static void b(Activity paramActivity)
  {
    if (m) {
      return;
    }
    m = true;
    a.a.a.b.a(paramActivity, b.b(), new a.a.a.c()
    {
      public boolean a()
      {
        return true;
      }
    });
  }
  
  public static void b(h paramh)
  {
    i();
    t.remove(paramh);
  }
  
  public static void b(com.ideashower.readitlater.activity.a parama)
  {
    
    if (!k)
    {
      k = true;
      c(parama);
    }
    if ((com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bg)) && (!parama.isFinishing()) && (!(parama instanceof GiftMessageActivity)) && (!(parama instanceof AppCacheCheckActivity)))
    {
      com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.bg, false);
      if (as.l())
      {
        UpdatedActivity.c(parama);
        parama.overridePendingTransition(0, 0);
      }
    }
  }
  
  public static Context c()
  {
    return c;
  }
  
  protected static void c(com.ideashower.readitlater.activity.a parama)
  {
    com.ideashower.readitlater.util.q.a(parama);
  }
  
  public static void d(com.ideashower.readitlater.activity.a parama)
  {
    e = parama;
    Iterator localIterator;
    if (parama != null)
    {
      if ((!a) && (parama != null)) {
        c.e(parama);
      }
      if ((!j) && ((parama instanceof com.ideashower.readitlater.activity.a))) {
        j = true;
      }
      WakefulAppService.a();
      if (o)
      {
        o = false;
        f(parama);
      }
      if (a(true)) {
        com.pocket.c.e.c();
      }
      com.pocket.m.a.i();
      if (!t.isEmpty()) {
        localIterator = t.iterator();
      }
    }
    else
    {
      label88:
      label145:
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        h localh = (h)localIterator.next();
        if (parama != null) {}
        for (boolean bool = localh.a();; bool = localh.b())
        {
          if (!bool) {
            break label145;
          }
          localIterator.remove();
          break label88;
          ar.c();
          break;
        }
      }
    }
  }
  
  public static boolean d()
  {
    return n;
  }
  
  protected static void e()
  {
    String str = Build.VERSION.SDK_INT + Build.VERSION.INCREMENTAL + Build.VERSION.RELEASE;
    if (!str.equals(com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.aE))) {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aE, str).a();
    }
  }
  
  private static void f(com.ideashower.readitlater.activity.a parama)
  {
    if ((d()) && (com.ideashower.readitlater.service.b.c()))
    {
      com.ideashower.readitlater.service.b.a(parama, 4, null);
      if (!h) {
        s.M().a(parama);
      }
    }
  }
  
  public static void g()
  {
    com.ideashower.readitlater.h.i.b(com.ideashower.readitlater.h.a.q);
    a(n());
  }
  
  public static void h() {}
  
  public static void i()
  {
    if (!q()) {
      throw new RuntimeException("May only be invoked from the UI thread");
    }
  }
  
  public static boolean j()
  {
    return e != null;
  }
  
  public static boolean k()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        return bool;
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean l()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo.getType() == 1)
      {
        boolean bool = localNetworkInfo.isConnected();
        return bool;
      }
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static g m()
  {
    return c;
  }
  
  public static com.ideashower.readitlater.activity.a n()
  {
    return e;
  }
  
  public static Handler o()
  {
    return d;
  }
  
  public static void p()
  {
    ApplicationInfo localApplicationInfo = c.getApplicationInfo();
    int i1 = localApplicationInfo.flags & 0x2;
    localApplicationInfo.flags = i1;
    if (i1 != 0)
    {
      if (e != null) {
        e.b(true);
      }
    }
    else {
      return;
    }
    Process.killProcess(Process.myPid());
  }
  
  public static boolean q()
  {
    return Thread.currentThread() == g;
  }
  
  public static int r()
  {
    return p;
  }
  
  public static m s()
  {
    return r;
  }
  
  public static boolean u()
  {
    return e != null;
  }
  
  public static ai v()
  {
    return s;
  }
  
  public static int w()
  {
    return ((ActivityManager)c().getSystemService("activity")).getMemoryClass();
  }
  
  public static boolean x()
  {
    if (com.ideashower.readitlater.util.a.r()) {
      return G();
    }
    return w() < 40;
  }
  
  public static boolean y()
  {
    return b.a();
  }
  
  public static String z()
  {
    Locale localLocale = m().getApplicationContext().getResources().getConfiguration().locale;
    return localLocale.getLanguage() + "-" + localLocale.getCountry();
  }
  
  protected com.pocket.g.a a()
  {
    return new com.pocket.g.a("play");
  }
  
  protected void e(com.ideashower.readitlater.activity.a parama)
  {
    if (parama == null) {
      return;
    }
    a = true;
  }
  
  protected void f() {}
  
  public void onCreate()
  {
    com.ideashower.readitlater.h.i.a();
    h = com.ideashower.readitlater.h.i.a(com.ideashower.readitlater.h.a.W);
    B();
    C();
    E();
    ApplicationInfo localApplicationInfo = getApplicationInfo();
    int i1 = localApplicationInfo.flags & 0x2;
    localApplicationInfo.flags = i1;
    if (i1 != 0) {
      Process.killProcess(Process.myPid());
    }
    super.onCreate();
    if (h)
    {
      com.ideashower.readitlater.h.i.b().a(com.ideashower.readitlater.h.a.aS, true).a(com.ideashower.readitlater.h.a.aT, b().h()).a();
      f();
    }
    if ((!getPackageName().startsWith("com.ideashower.readitlater")) && (!getPackageName().startsWith("com.pocket"))) {
      Process.killProcess(Process.myPid());
    }
    i = true;
    e();
    F();
    f.set(true);
    if (h) {
      f.a(33, 1, 1, 0);
    }
    o = as.l();
    com.ideashower.readitlater.util.e.a();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    x.d();
  }
  
  public boolean t()
  {
    return f.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */