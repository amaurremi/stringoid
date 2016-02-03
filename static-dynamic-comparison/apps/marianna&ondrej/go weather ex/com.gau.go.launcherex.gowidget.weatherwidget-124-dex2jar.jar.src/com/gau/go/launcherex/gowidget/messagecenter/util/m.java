package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.download.b;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.a.e;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDetailActivity;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.ThemeSettingActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.Vector;

public class m
  extends a
  implements ai
{
  private static m a;
  private l b;
  private c c;
  private Context d;
  private u e;
  private t f;
  private int g = 0;
  private y h;
  
  private m(Context paramContext)
  {
    this.b = l.a(paramContext);
    this.b.a(this);
    this.c = new c(paramContext);
    this.d = paramContext;
    this.f = new t(paramContext.getContentResolver());
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.MSGCENTER_SHOWMSG");
    paramContext.addAction("action_update_message");
    paramContext.addAction("android.intent.action.TIME_SET");
    paramContext.addAction("android.intent.action.TIMEZONE_CHANGED");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.e = new u(this, null);
    this.d.registerReceiver(this.e, paramContext);
    i.a(this.d);
    this.h = new y(this.d);
  }
  
  public static m a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new m(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    this.d.sendBroadcast(new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_RECEIVE_THEME_COUPON_NOTIFICATION"));
  }
  
  private void a(Context paramContext, d paramd)
  {
    Intent localIntent = new Intent(paramContext, HtmlMsgDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extras_bundle_msg_id", paramd.a);
    localBundle.putString("extras_bundle_msg_url", paramd.k);
    localBundle.putString("extras_bundle_msg_title", paramd.b);
    localBundle.putString("extras_bundle_msg_pubished_time", paramd.d);
    localIntent.putExtra("weather_alerts_lists_entrance", "widget&notification");
    localIntent.putExtras(localBundle);
    localIntent.setFlags(872415232);
    paramContext.startActivity(localIntent);
  }
  
  private void a(Intent paramIntent)
  {
    if (!(this.d instanceof Activity)) {
      paramIntent.addFlags(268435456);
    }
    try
    {
      this.d.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      while (!com.gtp.a.a.b.c.a()) {}
      paramIntent.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    if (paramString2.equals("I")) {
      paramIntent.putExtra(paramString1, Integer.parseInt(paramString3));
    }
    do
    {
      return;
      if (paramString2.equals("S"))
      {
        paramIntent.putExtra(paramString1, paramString3);
        return;
      }
      if (paramString2.equals("Z"))
      {
        paramIntent.putExtra(paramString1, Boolean.parseBoolean(paramString3));
        return;
      }
      if (paramString2.equals("J"))
      {
        paramIntent.putExtra(paramString1, Long.parseLong(paramString3));
        return;
      }
      if (paramString2.equals("F"))
      {
        paramIntent.putExtra(paramString1, Float.parseFloat(paramString3));
        return;
      }
      if (paramString2.equals("D"))
      {
        paramIntent.putExtra(paramString1, Double.parseDouble(paramString3));
        return;
      }
    } while (!paramString2.equals("B"));
    paramIntent.putExtra(paramString1, Byte.parseByte(paramString3));
  }
  
  private void a(com.gau.go.launcherex.gowidget.messagecenter.a.c paramc)
  {
    paramc = paramc.a();
    int i = 0;
    if (i < paramc.size())
    {
      d locald = (d)paramc.get(i);
      if (locald.y) {}
      for (;;)
      {
        i += 1;
        break;
        if ((locald.l & 0x4) != 0) {
          h.a(this.d).a(locald);
        }
        if ((locald.l & 0x2) != 0) {
          c(locald);
        } else if (locald.B) {
          ae.a(this.d).b(locald);
        }
      }
    }
  }
  
  private void a(Class paramClass, Context paramContext, boolean paramBoolean)
  {
    Object localObject = this.d;
    if (paramContext != null) {}
    for (;;)
    {
      localObject = new Intent(paramContext, paramClass);
      if (!(paramContext instanceof Activity)) {
        ((Intent)localObject).addFlags(268435456);
      }
      if (paramClass.isAssignableFrom(ThemeSettingActivity.class)) {
        ((Intent)localObject).putExtra("extra_theme_entrance", 5);
      }
      if (!paramBoolean) {
        ((Intent)localObject).putExtra("extra_goto_main_activity", true);
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (ActivityNotFoundException paramClass)
      {
        while (!com.gtp.a.a.b.c.a()) {}
        paramClass.printStackTrace();
        return;
      }
      paramContext = (Context)localObject;
    }
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = Uri.parse(paramString);
    } while (paramString == null);
    paramString = new Intent("android.intent.action.VIEW", paramString);
    paramString.setFlags(268435456);
    try
    {
      this.d.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if ((paramString.startsWith("gostoredetail://id=")) || (paramString.startsWith("gostoretype://id=")) || (paramString.startsWith("gui://id=")) || (paramString.startsWith("guidetail://id=")) || (paramString.startsWith("guispec://id="))) {
        continue;
      }
      if (paramString.startsWith("http://"))
      {
        a(paramString);
        return;
      }
      if (paramString.startsWith("market://id="))
      {
        paramString = b(paramString, "market://id=");
        c("market://details?id=" + paramString, "https://play.google.com/store/apps/details?id=" + paramString);
        return;
      }
      if ((paramString.startsWith("appcentertype://id=")) || (paramString.startsWith("appcentertopic://id=")) || (paramString.startsWith("appcenterdetail://id="))) {
        break;
      }
      if (paramString.startsWith("activity://id="))
      {
        paramString = b(paramString, "activity://id=");
        try
        {
          a(Class.forName(paramString), paramContext, paramBoolean);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      if (!paramString.startsWith("intent:")) {
        break;
      }
      paramContext = null;
      try
      {
        paramString = c(paramString);
        if (paramString == null) {
          continue;
        }
        a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = paramContext;
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.endsWith(".apk")) {
        break label77;
      }
      paramString2 = paramString2 + ".apk";
    }
    label77:
    for (;;)
    {
      Context localContext = this.d;
      int i = this.g + 1;
      this.g = i;
      b.a(localContext, paramString2, paramString1, i, paramString3);
      return;
    }
  }
  
  private void a(Vector paramVector, ArrayList paramArrayList)
  {
    ContentValues localContentValues = new ContentValues();
    paramVector = paramVector.iterator();
    while (paramVector.hasNext())
    {
      d locald = (d)paramVector.next();
      if (locald.C == 1)
      {
        a(localContentValues, locald);
        paramArrayList.add(ContentProviderOperation.newInsert(WeatherContentProvider.p).withValues(localContentValues).build());
      }
      if (locald.C == 2)
      {
        a(localContentValues, locald);
        paramArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.p).withValues(localContentValues).withSelection("mesageid='" + locald.a + "'", null).build());
      }
    }
  }
  
  private void a(Vector paramVector1, Vector paramVector2)
  {
    ArrayList localArrayList = new ArrayList();
    d(paramVector1);
    a(new p(this, paramVector1, paramVector2, localArrayList));
  }
  
  private void a(Vector paramVector1, Vector paramVector2, Vector paramVector3)
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i < paramVector1.size())
    {
      d locald = (d)paramVector1.get(i);
      Iterator localIterator = paramVector2.iterator();
      while (localIterator.hasNext()) {
        if (((d)localIterator.next()).a.equals(locald.a)) {
          localVector.add(locald);
        }
      }
      i += 1;
    }
    paramVector1.removeAll(localVector);
    paramVector3.removeAll(localVector);
  }
  
  private s b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String[] arrayOfString = paramString.split("packagename=");
    if (arrayOfString.length == 2)
    {
      paramString = new s(this, null);
      paramString.a = arrayOfString[0];
      arrayOfString = arrayOfString[1].split("##");
      if (arrayOfString.length == 2)
      {
        paramString.b = arrayOfString[0];
        paramString.c = arrayOfString[1];
      }
    }
    for (;;)
    {
      return paramString;
      paramString = null;
      continue;
      paramString = null;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      localObject1 = localObject2;
      if (paramString2 != null)
      {
        localObject1 = localObject2;
        if (paramString1.length() > paramString2.length()) {
          localObject1 = paramString1.substring(paramString2.length());
        }
      }
    }
    return (String)localObject1;
  }
  
  private void b(Vector paramVector)
  {
    if (paramVector != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramVector = paramVector.iterator();
      int i = 0;
      while (paramVector.hasNext())
      {
        d locald = (d)paramVector.next();
        if (locald.E != null)
        {
          i = 1;
          localArrayList.addAll(locald.E);
        }
      }
      if (i != 0) {
        a();
      }
      this.c.a(localArrayList);
    }
  }
  
  private void b(Vector paramVector, ArrayList paramArrayList)
  {
    int j = paramVector.size();
    int k = paramVector.size();
    int i = 0;
    while (i < j - 20)
    {
      d locald = (d)paramVector.get(k - 1 - i);
      if (locald.y)
      {
        paramArrayList.add(ContentProviderOperation.newDelete(WeatherContentProvider.p).withSelection("mesageid='" + locald.a + "'", null).build());
        paramVector.remove(locald);
      }
      i += 1;
    }
  }
  
  private void b(Vector paramVector1, Vector paramVector2)
  {
    paramVector1 = paramVector1.iterator();
    if (paramVector1.hasNext())
    {
      d locald1 = (d)paramVector1.next();
      Iterator localIterator = paramVector2.iterator();
      label30:
      d locald2;
      while (localIterator.hasNext())
      {
        locald2 = (d)localIterator.next();
        if (locald1.a.equals(locald2.a))
        {
          if (!locald1.b(locald2)) {
            break label96;
          }
          locald1.C = 4;
        }
      }
      for (locald2.C = 4;; locald2.C = 2)
      {
        locald1.a(locald2);
        break label30;
        break;
        label96:
        locald1.C = 2;
      }
    }
  }
  
  private Intent c(String paramString)
  {
    paramString = paramString.split("\\?", 2);
    Object localObject = paramString[0].replace("intent:", "");
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    String[] arrayOfString1 = ((String)localObject).split("=", 2);
    int i;
    String[] arrayOfString2;
    if (arrayOfString1.length > 1)
    {
      if (((String)localObject).startsWith("classname=")) {
        localIntent.setClassName(this.d, arrayOfString1[1]);
      }
      for (;;)
      {
        if (paramString.length > 1)
        {
          localObject = paramString[1].split("#");
          i = 0;
          if (i < localObject.length)
          {
            arrayOfString2 = localObject[i].split("=", 2);
            if (arrayOfString2.length == 2) {
              break;
            }
          }
        }
        return localIntent;
        if (((String)localObject).startsWith("action=")) {
          localIntent.setAction(arrayOfString1[1]);
        }
      }
    }
    throw new Exception("messageManager->parseActValue:actionOrClass 不能为空");
    arrayOfString1 = arrayOfString2[0];
    paramString = "";
    String str = arrayOfString2[1].substring(0, 1);
    if (arrayOfString2[1].length() < 2) {
      if (str.equals("S")) {
        break label227;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      paramString = arrayOfString2[1].substring(1, arrayOfString2[1].length());
      label227:
      a(localIntent, arrayOfString1, str, paramString);
    }
  }
  
  private void c(d paramd)
  {
    if ((paramd.c == 2) || (paramd.c == 5) || (paramd.c == 4))
    {
      new r(this, paramd).execute(new String[] { paramd.h });
      return;
    }
    ae.a(this.d).a(paramd);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if ((com.gau.go.launcherex.gowidget.statistics.y.s(this.d)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      try
      {
        paramString1.setPackage("com.android.vending");
        paramString1.setFlags(268435456);
        this.d.startActivity(paramString1);
        i = 1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          int i = 0;
        }
      }
      if (i == 0) {
        Toast.makeText(this.d, 2131166006, 0).show();
      }
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    a(paramString2);
  }
  
  private void c(Vector paramVector)
  {
    if (paramVector != null)
    {
      Object localObject = new ArrayList();
      paramVector = paramVector.iterator();
      while (paramVector.hasNext())
      {
        d locald = (d)paramVector.next();
        if (locald.F != null) {
          ((ArrayList)localObject).add(locald.F);
        }
      }
      if (!((ArrayList)localObject).isEmpty())
      {
        paramVector = new aj(this.d);
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramVector.a((com.gau.go.launcherex.gowidget.messagecenter.a.f)((Iterator)localObject).next());
        }
      }
    }
  }
  
  private void c(Vector paramVector, ArrayList paramArrayList)
  {
    if ((paramVector != null) && (paramVector.size() > 0))
    {
      int i = 0;
      if (i < paramVector.size())
      {
        paramArrayList = (d)paramVector.get(i);
        Object localObject = paramArrayList.m;
        int k = i;
        int j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(",");
          k = i;
          if (localObject != null) {
            j = 0;
          }
        }
        for (;;)
        {
          k = i;
          if (j < localObject.length)
          {
            String str = localObject[j];
            if (com.gau.go.launcherex.gowidget.statistics.y.a(this.d, str))
            {
              paramVector.remove(paramArrayList);
              k = i - 1;
            }
          }
          else
          {
            i = k + 1;
            break;
          }
          j += 1;
        }
      }
    }
  }
  
  private void d(Vector paramVector)
  {
    if (!GoWidgetApplication.b(this.d).a()) {
      return;
    }
    Vector localVector = new Vector();
    Iterator localIterator = paramVector.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.c == 5) {
        localVector.add(locald);
      }
    }
    paramVector.removeAll(localVector);
  }
  
  /* Error */
  private void d(Vector paramVector, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +268 -> 269
    //   4: aload_1
    //   5: invokevirtual 268	java/util/Vector:size	()I
    //   8: ifle +261 -> 269
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: aload_1
    //   15: invokevirtual 268	java/util/Vector:size	()I
    //   18: if_icmpge +251 -> 269
    //   21: aload_1
    //   22: iload_3
    //   23: invokevirtual 272	java/util/Vector:get	(I)Ljava/lang/Object;
    //   26: checkcast 126	com/gau/go/launcherex/gowidget/messagecenter/a/d
    //   29: astore 9
    //   31: aload 9
    //   33: getfield 663	com/gau/go/launcherex/gowidget/messagecenter/a/d:n	Ljava/lang/String;
    //   36: astore_2
    //   37: iload_3
    //   38: istore 5
    //   40: aload_2
    //   41: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +152 -> 196
    //   47: aload_2
    //   48: ldc_w 647
    //   51: invokevirtual 509	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   54: astore 10
    //   56: iload_3
    //   57: istore 5
    //   59: aload 10
    //   61: ifnull +135 -> 196
    //   64: iconst_0
    //   65: istore 6
    //   67: iload 6
    //   69: aload 10
    //   71: arraylength
    //   72: if_icmpge +202 -> 274
    //   75: aload 10
    //   77: iload 6
    //   79: aaload
    //   80: astore_2
    //   81: aload_2
    //   82: ldc_w 575
    //   85: invokevirtual 666	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   88: istore 4
    //   90: aload_2
    //   91: ldc_w 668
    //   94: invokevirtual 666	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   97: istore 5
    //   99: iload 4
    //   101: iconst_m1
    //   102: if_icmpeq +119 -> 221
    //   105: aload_2
    //   106: iconst_0
    //   107: iload 4
    //   109: invokevirtual 586	java/lang/String:substring	(II)Ljava/lang/String;
    //   112: astore 8
    //   114: aload_2
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: iload 5
    //   121: invokevirtual 586	java/lang/String:substring	(II)Ljava/lang/String;
    //   124: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   127: istore 4
    //   129: aload_2
    //   130: iload 5
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 525	java/lang/String:substring	(I)Ljava/lang/String;
    //   137: invokestatic 196	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   140: istore 5
    //   142: aload 8
    //   144: astore_2
    //   145: aload_2
    //   146: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +111 -> 260
    //   152: aload_0
    //   153: getfield 47	com/gau/go/launcherex/gowidget/messagecenter/util/m:d	Landroid/content/Context;
    //   156: aload_2
    //   157: invokestatic 650	com/gau/go/launcherex/gowidget/statistics/y:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   160: ifeq +100 -> 260
    //   163: iload 5
    //   165: ifne +65 -> 230
    //   168: iload 4
    //   170: ifne +60 -> 230
    //   173: iconst_1
    //   174: istore 4
    //   176: iload_3
    //   177: istore 5
    //   179: iload 4
    //   181: ifne +15 -> 196
    //   184: aload_1
    //   185: aload 9
    //   187: invokevirtual 549	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: iload_3
    //   192: iconst_1
    //   193: isub
    //   194: istore 5
    //   196: iload 5
    //   198: iconst_1
    //   199: iadd
    //   200: istore_3
    //   201: goto -188 -> 13
    //   204: astore_2
    //   205: iconst_0
    //   206: istore 4
    //   208: aload_2
    //   209: invokevirtual 413	java/lang/Exception:printStackTrace	()V
    //   212: iconst_0
    //   213: istore 5
    //   215: aload 8
    //   217: astore_2
    //   218: goto -73 -> 145
    //   221: iconst_0
    //   222: istore 4
    //   224: iconst_0
    //   225: istore 5
    //   227: goto -82 -> 145
    //   230: aload_0
    //   231: getfield 47	com/gau/go/launcherex/gowidget/messagecenter/util/m:d	Landroid/content/Context;
    //   234: aload_2
    //   235: invokestatic 671	com/gau/go/launcherex/gowidget/statistics/y:b	(Landroid/content/Context;Ljava/lang/String;)I
    //   238: istore 7
    //   240: iload 7
    //   242: iload 5
    //   244: if_icmpgt +16 -> 260
    //   247: iload 7
    //   249: iload 4
    //   251: if_icmplt +9 -> 260
    //   254: iconst_1
    //   255: istore 4
    //   257: goto -81 -> 176
    //   260: iload 6
    //   262: iconst_1
    //   263: iadd
    //   264: istore 6
    //   266: goto -199 -> 67
    //   269: return
    //   270: astore_2
    //   271: goto -63 -> 208
    //   274: iconst_0
    //   275: istore 4
    //   277: goto -101 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	m
    //   0	280	1	paramVector	Vector
    //   0	280	2	paramArrayList	ArrayList
    //   12	189	3	i	int
    //   88	188	4	j	int
    //   38	207	5	k	int
    //   65	200	6	m	int
    //   238	14	7	n	int
    //   112	104	8	str	String
    //   29	157	9	locald	d
    //   54	22	10	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   114	129	204	java/lang/Exception
    //   129	142	270	java/lang/Exception
  }
  
  private void e(Vector paramVector)
  {
    paramVector = paramVector.iterator();
    while (paramVector.hasNext())
    {
      d locald = (d)paramVector.next();
      this.f.a(-1, null, WeatherContentProvider.p, "mesageid=?", new String[] { locald.a });
    }
  }
  
  public void a(int paramInt)
  {
    if (!com.gau.go.launcherex.gowidget.weather.util.r.c(this.d)) {
      a(7, -1, null, null);
    }
    new n(this, paramInt).start();
  }
  
  public void a(ContentValues paramContentValues, d paramd)
  {
    int j = 1;
    if (paramContentValues == null) {
      return;
    }
    paramContentValues.put("mesageid", paramd.a);
    paramContentValues.put("title", paramd.b);
    if (paramd.y)
    {
      i = 1;
      paramContentValues.put("readed", Integer.valueOf(i));
      paramContentValues.put("type", Integer.valueOf(paramd.c));
      paramContentValues.put("viewtype", Integer.valueOf(paramd.l));
      paramContentValues.put("date", paramd.d);
      paramContentValues.put("url", paramd.e);
      paramContentValues.put("stime_start", paramd.f);
      paramContentValues.put("stime_end", paramd.g);
      paramContentValues.put("icon", paramd.h);
      paramContentValues.put("intro", paramd.i);
      paramContentValues.put("acttype", Integer.valueOf(paramd.j));
      paramContentValues.put("actvalue", paramd.k);
      paramContentValues.put("zicon1", paramd.q);
      paramContentValues.put("zicon2", paramd.r);
      paramContentValues.put("zpos", Integer.valueOf(paramd.s));
      paramContentValues.put("ztime", Long.valueOf(paramd.t));
      if (!paramd.u) {
        break label380;
      }
      i = 1;
      label228:
      paramContentValues.put("isclosed", Integer.valueOf(i));
      paramContentValues.put("filter_pkgs", paramd.m);
      paramContentValues.put("whitelist", paramd.n);
      if (!paramd.A) {
        break label385;
      }
      i = 1;
      label270:
      paramContentValues.put("clickclosed", Integer.valueOf(i));
      paramContentValues.put("dynamic", Integer.valueOf(paramd.v));
      paramContentValues.put("iconpos", Integer.valueOf(paramd.w));
      paramContentValues.put("fullscreenicon", paramd.x);
      if (!paramd.B) {
        break label390;
      }
    }
    label380:
    label385:
    label390:
    for (int i = j;; i = 0)
    {
      paramContentValues.put("removed", Integer.valueOf(i));
      paramContentValues.put("packagename", paramd.o);
      paramContentValues.put("mapid", paramd.p);
      paramContentValues.put("isdeleted", Integer.valueOf(0));
      return;
      i = 0;
      break;
      i = 0;
      break label228;
      i = 0;
      break label270;
    }
  }
  
  public void a(d paramd)
  {
    paramd.B = true;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("removed", "1");
    this.f.a(4, null, WeatherContentProvider.p, localContentValues, "mesageid='" + paramd.a + "'", null);
  }
  
  public void a(d paramd, int paramInt, Context paramContext, boolean paramBoolean)
  {
    int i = paramd.j;
    String str = paramd.k;
    switch (i)
    {
    }
    for (;;)
    {
      b(paramd.a, paramInt);
      do
      {
        return;
        a(str, paramContext, paramBoolean);
        break;
        a(str);
        break;
      } while (str == null);
      if (str.startsWith("market://"))
      {
        c("market://details?id=" + str.substring("market://".length()), "https://play.google.com/store/apps/details?id=" + str.substring("market://".length()));
        a(paramd.a, paramd.o);
        continue;
        paramContext = b(str);
        if (paramContext != null)
        {
          a(paramContext.a, paramContext.c, paramContext.b);
          continue;
          a(paramContext, paramd);
        }
      }
    }
  }
  
  public void a(e parame, String paramString, int paramInt, Activity paramActivity)
  {
    if (parame.a == 0) {
      paramActivity.finish();
    }
    for (;;)
    {
      a(paramString, parame.d, paramInt);
      return;
      if (parame.a == 1) {
        paramActivity.finish();
      } else if (parame.a == 2) {
        a(parame.b);
      } else if ((parame.a != 3) && (parame.a != 4)) {
        if (parame.a == 5)
        {
          c(parame.b, parame.b);
          a(paramString, new q(this));
        }
        else if (parame.a == 6)
        {
          paramActivity = b(parame.b);
          if (paramActivity != null) {
            a(paramActivity.a, paramActivity.c, paramActivity.b);
          }
        }
        else if (parame.a == 7)
        {
          a(parame.b, paramActivity, true);
        }
        else if (parame.a != 8) {}
      }
    }
  }
  
  public void a(ag paramag)
  {
    this.f.a(5, paramag, WeatherContentProvider.p, null, "isdeleted=?", new String[] { "1" }, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    ab localab = new ab();
    localab.a = System.currentTimeMillis();
    localab.b = paramString;
    localab.d = 1;
    localab.e = paramInt;
    localab.g = UUID.randomUUID().toString();
    this.h.a(localab);
  }
  
  public void a(String paramString, ag paramag)
  {
    this.f.a(2, paramag, WeatherContentProvider.p, null, "mesageid='" + paramString + "'", null, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.d.getSharedPreferences("message_center_app_statistics", 0).edit();
    localEditor.putString(paramString2, paramString1 + "#" + System.currentTimeMillis());
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ab localab = new ab();
    localab.a = System.currentTimeMillis();
    localab.b = paramString1;
    localab.i = 1;
    localab.h = paramString2;
    localab.e = paramInt;
    localab.g = UUID.randomUUID().toString();
    this.h.a(localab);
  }
  
  public void a(Vector paramVector)
  {
    int j = paramVector.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      ab localab = new ab();
      localab.a = System.currentTimeMillis();
      localab.b = ((d)paramVector.get(i)).a;
      localab.c = 1;
      localab.g = UUID.randomUUID().toString();
      localArrayList.add(localab);
      i += 1;
    }
    this.h.a(localArrayList);
  }
  
  public void a(boolean paramBoolean, com.gau.go.launcherex.gowidget.messagecenter.a.c paramc)
  {
    if ((paramc != null) && (!paramc.a().isEmpty()))
    {
      if (((d)paramc.a().get(0)).a.startsWith("go")) {
        a(paramc.a());
      }
      c(new o(this, paramc, paramBoolean));
    }
  }
  
  public void b(d paramd)
  {
    paramd.y = true;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("readed", "1");
    this.f.a(4, null, WeatherContentProvider.p, localContentValues, "mesageid='" + paramd.a + "'", null);
  }
  
  public void b(ag paramag)
  {
    this.f.a(1, paramag, WeatherContentProvider.p, null, "isdeleted=?", new String[] { "0" }, null);
  }
  
  public void b(String paramString, int paramInt)
  {
    ab localab = new ab();
    localab.a = System.currentTimeMillis();
    localab.b = paramString;
    localab.f = 1;
    localab.e = paramInt;
    localab.g = UUID.randomUUID().toString();
    this.h.a(localab);
  }
  
  public void c(ag paramag)
  {
    this.f.a(1, paramag, WeatherContentProvider.p, null, null, null, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */