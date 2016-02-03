package com.go.weatherex.setting;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.model.RecommendedAppsBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ag
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextView a;
  private View b;
  private ArrayList c;
  private ListView d;
  private ak e;
  private String f;
  private volatile boolean g = false;
  private volatile boolean h = false;
  private View i;
  private String j = null;
  private boolean k = true;
  private BroadcastReceiver l = new ah(this);
  private com.gau.go.launcherex.gowidget.d.h m;
  
  private int a(InputStream paramInputStream, ArrayList paramArrayList)
  {
    paramInputStream = new DataInputStream(paramInputStream);
    for (;;)
    {
      int n;
      RecommendedAppsBean localRecommendedAppsBean;
      int i1;
      try
      {
        paramInputStream.readInt();
        paramInputStream.readInt();
        if (paramInputStream.readInt() > 0)
        {
          paramInputStream.readLong();
          paramInputStream.readInt();
          paramInputStream.readInt();
          paramInputStream.readInt();
          n = paramInputStream.readInt();
          if (n <= 0) {
            break label337;
          }
          localRecommendedAppsBean = new RecommendedAppsBean();
          localRecommendedAppsBean.a(paramInputStream.readInt());
          localRecommendedAppsBean.o(paramInputStream.readUTF());
          localRecommendedAppsBean.f(paramInputStream.readInt());
          localRecommendedAppsBean.b(paramInputStream.readInt());
          localRecommendedAppsBean.c(paramInputStream.readInt());
          localRecommendedAppsBean.a(paramInputStream.readUTF());
          localRecommendedAppsBean.b(paramInputStream.readUTF());
          localRecommendedAppsBean.c(paramInputStream.readUTF());
          localRecommendedAppsBean.d(paramInputStream.readUTF());
          localRecommendedAppsBean.d(paramInputStream.readInt());
          localRecommendedAppsBean.e(paramInputStream.readUTF());
          localRecommendedAppsBean.e(paramInputStream.readInt());
          localRecommendedAppsBean.f(paramInputStream.readUTF());
          localRecommendedAppsBean.g(paramInputStream.readUTF());
          localRecommendedAppsBean.h(paramInputStream.readUTF());
          localRecommendedAppsBean.i(paramInputStream.readUTF());
          i1 = paramInputStream.readInt();
          if (i1 <= 0) {
            break label323;
          }
          switch (paramInputStream.readInt())
          {
          case 1: 
            localRecommendedAppsBean.j(paramInputStream.readUTF());
          }
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
      return 0;
      localRecommendedAppsBean.k(paramInputStream.readUTF());
      break label339;
      localRecommendedAppsBean.l(paramInputStream.readUTF());
      break label339;
      localRecommendedAppsBean.m(paramInputStream.readUTF());
      break label339;
      localRecommendedAppsBean.n(paramInputStream.readUTF());
      break label339;
      label323:
      paramArrayList.add(localRecommendedAppsBean);
      n -= 1;
      continue;
      label337:
      return 1;
      label339:
      i1 -= 1;
    }
  }
  
  /* Error */
  private int a(java.util.List paramList, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: new 142	org/apache/http/client/methods/HttpPost
    //   12: dup
    //   13: ldc -112
    //   15: invokespecial 146	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   18: astore 7
    //   20: iload 6
    //   22: istore_3
    //   23: aload 7
    //   25: ifnull +153 -> 178
    //   28: new 148	org/apache/http/client/entity/UrlEncodedFormEntity
    //   31: dup
    //   32: aload_1
    //   33: ldc -106
    //   35: invokespecial 153	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   38: astore_1
    //   39: iload 6
    //   41: istore_3
    //   42: aload_1
    //   43: ifnull +135 -> 178
    //   46: aload 7
    //   48: aload_1
    //   49: invokevirtual 159	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   52: new 161	org/apache/http/params/BasicHttpParams
    //   55: dup
    //   56: invokespecial 162	org/apache/http/params/BasicHttpParams:<init>	()V
    //   59: astore_1
    //   60: aload_1
    //   61: sipush 25000
    //   64: invokestatic 168	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   67: aload_1
    //   68: sipush 25000
    //   71: invokestatic 171	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   74: new 173	org/apache/http/impl/client/DefaultHttpClient
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 176	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   82: astore 8
    //   84: aload 8
    //   86: aload 7
    //   88: invokeinterface 182 2 0
    //   93: astore_1
    //   94: iload 5
    //   96: istore_3
    //   97: aload_1
    //   98: ifnull +68 -> 166
    //   101: iload 5
    //   103: istore_3
    //   104: aload_1
    //   105: invokeinterface 188 1 0
    //   110: invokeinterface 193 1 0
    //   115: sipush 200
    //   118: if_icmpne +48 -> 166
    //   121: aload_1
    //   122: invokeinterface 197 1 0
    //   127: astore 7
    //   129: iload 5
    //   131: istore_3
    //   132: aload 7
    //   134: ifnull +32 -> 166
    //   137: aload 7
    //   139: invokeinterface 203 1 0
    //   144: astore_1
    //   145: iload 4
    //   147: istore_3
    //   148: aload_1
    //   149: ifnull +10 -> 159
    //   152: aload_0
    //   153: aload_1
    //   154: aload_2
    //   155: invokespecial 205	com/go/weatherex/setting/ag:a	(Ljava/io/InputStream;Ljava/util/ArrayList;)I
    //   158: istore_3
    //   159: aload 7
    //   161: invokeinterface 208 1 0
    //   166: aload 8
    //   168: invokeinterface 212 1 0
    //   173: invokeinterface 217 1 0
    //   178: iload_3
    //   179: ireturn
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 218	java/lang/IllegalArgumentException:printStackTrace	()V
    //   187: aconst_null
    //   188: astore 7
    //   190: goto -170 -> 20
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 219	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -161 -> 39
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 220	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   208: aconst_null
    //   209: astore_1
    //   210: goto -116 -> 94
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   218: aconst_null
    //   219: astore_1
    //   220: goto -126 -> 94
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 221	java/lang/IllegalStateException:printStackTrace	()V
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -85 -> 145
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   238: aconst_null
    //   239: astore_1
    //   240: goto -95 -> 145
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   248: goto -82 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	ag
    //   0	251	1	paramList	java.util.List
    //   0	251	2	paramArrayList	ArrayList
    //   22	157	3	n	int
    //   7	139	4	i1	int
    //   1	129	5	i2	int
    //   4	36	6	i3	int
    //   18	142	7	localObject1	Object
    //   180	3	7	localIllegalArgumentException	IllegalArgumentException
    //   188	1	7	localObject2	Object
    //   82	85	8	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    // Exception table:
    //   from	to	target	type
    //   9	20	180	java/lang/IllegalArgumentException
    //   28	39	193	java/io/UnsupportedEncodingException
    //   84	94	203	org/apache/http/client/ClientProtocolException
    //   84	94	213	java/io/IOException
    //   137	145	223	java/lang/IllegalStateException
    //   137	145	233	java/io/IOException
    //   159	166	243	java/io/IOException
  }
  
  private void a(int paramInt)
  {
    if ((!this.g) && (!this.h)) {
      Toast.makeText(getActivity(), paramInt, 1).show();
    }
  }
  
  private void a(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    try
    {
      startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(getActivity().getApplicationContext(), 2131165768, 0).show();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SETTING_USER_LANGUAGE");
    localIntent.putExtra("extra_language_code", paramString1);
    localIntent.putExtra("extra_language_package", paramString2);
    getActivity().sendBroadcast(localIntent);
  }
  
  private void b(int paramInt)
  {
    FragmentActivity localFragmentActivity = getActivity();
    com.gau.go.launcherex.gowidget.weather.model.h localh;
    if (localFragmentActivity != null)
    {
      localh = (com.gau.go.launcherex.gowidget.weather.model.h)this.c.get(paramInt);
      if (!g.a(localFragmentActivity)) {
        Toast.makeText(localFragmentActivity, 2131166414, 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject;
    if (!TextUtils.isEmpty(localh.e()))
    {
      if (TextUtils.isEmpty(localh.i())) {}
      for (localObject = getText(2131166412).toString() + localh.a();; localObject = localh.i())
      {
        com.gau.go.launcherex.gowidget.download.b.a(localFragmentActivity, (String)localObject + ".apk", localh.e(), localh.a(), localh.d());
        return;
      }
    }
    if ((!TextUtils.isEmpty(localh.f())) && (y.s(localFragmentActivity)))
    {
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(localh.f().trim()));
      try
      {
        ((Intent)localObject).setPackage("com.android.vending");
        ((Intent)localObject).setFlags(268435456);
        startActivity((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    if (!TextUtils.isEmpty(localh.h()))
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(localFragmentActivity, localh.h());
      return;
    }
    if (!TextUtils.isEmpty(localh.g()))
    {
      com.gau.go.launcherex.gowidget.weather.globaltheme.a.d(localFragmentActivity, localh.g());
      return;
    }
    Toast.makeText(localFragmentActivity, 2131166415, 1).show();
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.a, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.m = new com.gau.go.launcherex.gowidget.d.h();
    this.j = getActivity().getIntent().getStringExtra("weather_alerts_lists_entrance");
    if ((this.j != null) && (this.j.equals("widget&notification"))) {
      this.k = false;
    }
    this.f = d.a(getActivity()).c();
    this.c = d.a(getActivity()).g();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131166106);
    this.b = c(2131231196);
    this.b.setOnClickListener(this);
    this.e = new ak(this);
    this.d = ((ListView)c(2131231432));
    this.d.setAdapter(this.e);
    this.d.setOnItemClickListener(this);
    this.i = c(2131231431);
    this.i.setOnClickListener(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.PACKAGE_ADDED");
    paramBundle.addAction("android.intent.action.PACKAGE_REMOVED");
    paramBundle.addAction("android.intent.action.PACKAGE_REPLACED");
    paramBundle.addDataScheme("package");
    getActivity().registerReceiver(this.l, paramBundle);
    b();
  }
  
  public void onClick(View paramView)
  {
    if (this.m.a(hashCode())) {}
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        h();
        return;
      }
    } while (!paramView.equals(this.i));
    a("http://crowdin.net/project/goweather/invite");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903153, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.l != null)
    {
      getActivity().unregisterReceiver(this.l);
      this.l = null;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((am)paramView.getTag()).c.getVisibility() == 0) {
      if (r.c(getActivity()))
      {
        a(2131166213);
        new aj(this, paramInt).execute(new Void[0]);
      }
    }
    do
    {
      return;
      a(2131166304);
      return;
      paramAdapterView = (com.gau.go.launcherex.gowidget.weather.model.h)this.c.get(paramInt);
    } while (paramAdapterView.b().equals(this.f));
    paramView = new com.gau.go.launcherex.gowidget.weather.globalview.b(getActivity());
    paramView.setTitle(2131165545);
    paramView.b(getResources().getString(2131166212, new Object[] { paramAdapterView.i() }));
    paramView.d(2131166210);
    paramView.e(2131166211);
    paramView.a(new ai(this, paramAdapterView));
    paramView.b();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.k) {
      h();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */