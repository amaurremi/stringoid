package com.go.weatherex.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.service.error.model.LocationErrorBean;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globalview.n;
import com.gau.go.launcherex.gowidget.weather.model.FeedbackBean;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.model.HourlyBean;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.ScrollViewEx;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class a
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener
{
  private boolean A = false;
  private TextView a;
  private View b;
  private ScrollViewEx c;
  private n d = null;
  private n e = null;
  private ListView f = null;
  private VerticalStretchLayout g;
  private List h = null;
  private EditText i = null;
  private EditText j = null;
  private ListView k = null;
  private VerticalStretchLayout l;
  private String m = "";
  private long n = 0L;
  private EditText o = null;
  private ImageView p = null;
  private Button q = null;
  private ImageView r;
  private TextView s;
  private TextView t;
  private boolean u = false;
  private long v = 0L;
  private LayoutInflater w;
  private i x;
  private e y;
  private h z;
  
  public static float a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.density;
  }
  
  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Product=" + Build.PRODUCT + "\n");
    localStringBuffer.append("PhoneModel=" + Build.MODEL + "\n");
    localStringBuffer.append("ROM=" + Build.DISPLAY + "\n");
    localStringBuffer.append("Board=" + Build.BOARD + "\n");
    localStringBuffer.append("Device=" + Build.DEVICE + "\n");
    localStringBuffer.append("Density=" + a(getActivity()) + "\n");
    localStringBuffer.append("PackageName=" + paramContext.getPackageName() + "\n");
    localStringBuffer.append("AndroidVersion=" + Build.VERSION.RELEASE + "\n");
    localStringBuffer.append("TotalMemSize=" + b() / 1024L / 1024L + "MB\n");
    localStringBuffer.append("FreeMemSize=" + c() / 1024L / 1024L + "MB\n");
    localStringBuffer.append("Rom App Heap Size=" + d() / 1024L / 1024L + "MB\n");
    return localStringBuffer.toString();
  }
  
  private void a(Intent paramIntent, FeedbackBean paramFeedbackBean)
  {
    paramFeedbackBean = new File(com.gtp.a.a.b.a.a);
    if (!paramFeedbackBean.exists()) {
      paramFeedbackBean.mkdirs();
    }
    ArrayList localArrayList = new ArrayList();
    paramFeedbackBean = new File(paramFeedbackBean, "feedback_extra.zip");
    paramFeedbackBean.delete();
    File localFile = getActivity().getFileStreamPath("network_time_and_status_statistics_email.txt");
    if ((localFile != null) && (localFile.exists())) {
      localArrayList.add(localFile);
    }
    localFile = getActivity().getFileStreamPath("collect_data_weather_refresh_error_info.txt");
    if ((localFile != null) && (localFile.exists())) {
      localArrayList.add(localFile);
    }
    try
    {
      com.gtp.a.a.a.c.a(localArrayList, paramFeedbackBean);
      if (paramFeedbackBean != null) {
        paramIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramFeedbackBean));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localArrayList = null;
        paramFeedbackBean = localArrayList;
        if (com.gtp.a.a.b.c.a())
        {
          localIOException.printStackTrace();
          paramFeedbackBean = localArrayList;
        }
      }
    }
  }
  
  private void a(FeedbackBean paramFeedbackBean)
  {
    Object localObject2 = getActivity().getSharedPreferences("myLocation", 0);
    Object localObject1 = ((SharedPreferences)localObject2).getString("lat", "");
    String str1 = ((SharedPreferences)localObject2).getString("lng", "");
    String str2 = ((SharedPreferences)localObject2).getString("cityId", "");
    String str3 = ((SharedPreferences)localObject2).getString("cityName", "");
    String str4 = ((SharedPreferences)localObject2).getString("stateName", "");
    String str5 = ((SharedPreferences)localObject2).getString("countryName", "");
    localObject2 = ((SharedPreferences)localObject2).getString("url", "");
    paramFeedbackBean = new LocationErrorBean(str2, str3, str4, str5, (String)localObject1, str1, paramFeedbackBean.b(), (String)localObject2);
    localObject1 = new Intent(getActivity().getApplicationContext(), NotifyService.class);
    ((Intent)localObject1).putExtra("notify_request", 30);
    ((Intent)localObject1).putExtra("request_extra_feedback_location_data", paramFeedbackBean);
    getActivity().startService((Intent)localObject1);
  }
  
  private g[] a(Cursor paramCursor)
  {
    int i3 = 0;
    WeatherBean[] arrayOfWeatherBean = new WeatherBean[paramCursor.getCount()];
    int i4 = paramCursor.getColumnCount();
    int i1 = 0;
    while (paramCursor.moveToNext())
    {
      arrayOfWeatherBean[i1] = new WeatherBean();
      i2 = 0;
      if (i2 < i4)
      {
        localObject = paramCursor.getColumnName(i2);
        if ("cityName".equals(localObject)) {
          arrayOfWeatherBean[i1].e(paramCursor.getString(i2));
        }
        for (;;)
        {
          i2 += 1;
          break;
          if ("country".equals(localObject)) {
            arrayOfWeatherBean[i1].b(paramCursor.getString(i2));
          } else if ("state".equals(localObject)) {
            arrayOfWeatherBean[i1].a(paramCursor.getString(i2));
          } else if ("cityId".equals(localObject)) {
            arrayOfWeatherBean[i1].c(paramCursor.getString(i2));
          } else if ("city_my_location".equals(localObject)) {
            arrayOfWeatherBean[i1].a(paramCursor.getInt(i2));
          } else if ("timestamp".equals(localObject)) {
            arrayOfWeatherBean[i1].k.b(paramCursor.getLong(i2));
          }
        }
      }
      i1 += 1;
    }
    Object localObject = "";
    int i2 = arrayOfWeatherBean.length;
    i1 = 0;
    paramCursor = (Cursor)localObject;
    if (i1 < i2)
    {
      if (arrayOfWeatherBean[i1].e() == 2) {
        paramCursor = arrayOfWeatherBean[i1].c();
      }
    }
    else
    {
      localObject = new ArrayList();
      i1 = i3;
      label292:
      if (i1 >= i2) {
        break label421;
      }
      if ((!arrayOfWeatherBean[i1].c().equals(paramCursor)) || (arrayOfWeatherBean[i1].e() != 1)) {
        break label336;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label292;
      i1 += 1;
      break;
      label336:
      g localg = new g(this, null);
      localg.a = arrayOfWeatherBean[i1].c();
      localg.b = arrayOfWeatherBean[i1].d();
      localg.c = arrayOfWeatherBean[i1].b();
      localg.d = arrayOfWeatherBean[i1].a();
      localg.e = arrayOfWeatherBean[i1].k.g();
      ((ArrayList)localObject).add(localg);
    }
    label421:
    return (g[])((ArrayList)localObject).toArray(new g[((ArrayList)localObject).size()]);
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l1;
  }
  
  private boolean b(FeedbackBean paramFeedbackBean)
  {
    if (TextUtils.isEmpty(paramFeedbackBean.a())) {
      if (System.currentTimeMillis() - this.v > 2000L)
      {
        Toast.makeText(getActivity(), getText(2131165653), 2000).show();
        this.v = System.currentTimeMillis();
      }
    }
    do
    {
      do
      {
        return false;
        if ((!this.s.isShown()) || (!TextUtils.isEmpty(paramFeedbackBean.b()))) {
          break;
        }
      } while (System.currentTimeMillis() - this.v <= 2000L);
      Toast.makeText(getActivity(), getText(2131165654), 2000).show();
      this.v = System.currentTimeMillis();
      return false;
      if ((!this.t.isShown()) || (!TextUtils.isEmpty(paramFeedbackBean.c()))) {
        break;
      }
    } while (System.currentTimeMillis() - this.v <= 2000L);
    Toast.makeText(getActivity(), getText(2131165655), 2000).show();
    this.v = System.currentTimeMillis();
    return false;
    return true;
  }
  
  public static long c()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l1;
  }
  
  private void c(FeedbackBean paramFeedbackBean)
  {
    paramFeedbackBean.d();
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("plain/text");
    String str1 = d(paramFeedbackBean);
    String str2 = paramFeedbackBean.a(getActivity().getApplicationContext()) + "\n\n" + a(getActivity());
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "goweatherexfeedback@gmail.com" });
    localIntent.putExtra("android.intent.extra.SUBJECT", str1);
    localIntent.putExtra("android.intent.extra.TEXT", str2);
    a(localIntent, paramFeedbackBean);
    try
    {
      startActivityForResult(Intent.createChooser(localIntent, getString(2131165659)), 110);
      this.A = true;
      e(paramFeedbackBean);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        Toast.makeText(getActivity().getApplicationContext(), 2131165661, 0).show();
      }
    }
  }
  
  public static long d()
  {
    return Runtime.getRuntime().maxMemory();
  }
  
  private String d(FeedbackBean paramFeedbackBean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("GO Weather EX(v" + y.c(getActivity()) + "--versionCode:" + y.e(getActivity()) + ")");
    localStringBuffer.append(" ");
    localStringBuffer.append("Feedback(" + getString(2131165646) + ")/" + paramFeedbackBean.d() + ". " + paramFeedbackBean.a());
    return localStringBuffer.toString();
  }
  
  private void e(FeedbackBean paramFeedbackBean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("upload_statistics_data_file_2_extra_feedback_bean", paramFeedbackBean);
    com.gau.go.launcherex.gowidget.statistics.d.a(getActivity().getApplicationContext(), 2, localBundle);
  }
  
  private void j()
  {
    if (this.h == null) {
      this.h = r();
    }
    if (this.x == null)
    {
      this.x = new i(this);
      this.f.setAdapter(this.x);
    }
    int i1 = (int)(getResources().getDisplayMetrics().density * 228.0F);
    ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
    localLayoutParams.height = i1;
    this.f.setLayoutParams(localLayoutParams);
    this.f.setTag(Boolean.valueOf(true));
    this.c.a(this.f);
    this.g.d();
    this.p.setImageResource(2130837698);
    s();
  }
  
  private void k()
  {
    this.f.setTag(Boolean.valueOf(false));
    this.c.b(this.f);
    this.g.c();
    this.p.setImageResource(2130837688);
  }
  
  private void l()
  {
    if (this.z == null)
    {
      this.s.setVisibility(4);
      this.t.setVisibility(4);
      return;
    }
    int i1 = this.z.a();
    if ((i1 == 3) || (i1 == 2) || (i1 == 7) || (i1 == 8)) {
      this.s.setVisibility(0);
    }
    while ((i1 == 1) || (i1 == 17))
    {
      this.t.setVisibility(0);
      return;
      this.s.setVisibility(4);
    }
    this.t.setVisibility(4);
  }
  
  private void m()
  {
    if (this.y == null)
    {
      q();
      return;
    }
    n();
  }
  
  private void n()
  {
    int i1 = 5;
    this.k.setAdapter(this.y);
    Object localObject = getResources().getDisplayMetrics();
    int i3 = ((DisplayMetrics)localObject).heightPixels;
    int i4 = this.j.getBottom();
    int i2 = this.y.getCount();
    i3 = (int)((i3 - i4 - 20) / ((45.0F + 0.5F) * ((DisplayMetrics)localObject).density));
    if (i3 > 5) {}
    for (;;)
    {
      if (i1 > i2) {
        i1 = i2;
      }
      for (;;)
      {
        float f1 = i1;
        i1 = (int)(((i1 - 1) * 0.5F + f1 * 45.0F) * ((DisplayMetrics)localObject).density);
        localObject = this.k.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = i1;
        this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.k.setTag(Boolean.valueOf(true));
        this.c.a(this.k);
        this.l.d();
        this.r.setImageResource(2130837698);
        s();
        return;
      }
      i1 = i3;
    }
  }
  
  private void o()
  {
    this.k.setTag(Boolean.valueOf(false));
    this.c.b(this.k);
    this.l.c();
    this.r.setImageResource(2130837688);
  }
  
  private void p()
  {
    Boolean localBoolean = (Boolean)this.f.getTag();
    if ((localBoolean != null) && (localBoolean.booleanValue() == true)) {
      k();
    }
    localBoolean = (Boolean)this.k.getTag();
    if ((localBoolean != null) && (localBoolean.booleanValue() == true)) {
      o();
    }
  }
  
  private void q()
  {
    new l(getActivity().getContentResolver(), this).a(1, null, WeatherContentProvider.a, new String[] { "cityName", "country", "state", "cityId", "city_my_location", "timestamp" }, null, null, "sequence");
  }
  
  private List r()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new h(this, 1, getString(2131165662)));
    localArrayList.add(new h(this, 2, getString(2131165663)));
    localArrayList.add(new h(this, 3, getString(2131165672)));
    localArrayList.add(new h(this, 4, getString(2131165664)));
    localArrayList.add(new h(this, 5, getString(2131165666)));
    localArrayList.add(new h(this, 6, getString(2131165667)));
    localArrayList.add(new h(this, 7, getString(2131165668)));
    localArrayList.add(new h(this, 8, getString(2131165669)));
    localArrayList.add(new h(this, 9, getString(2131165670)));
    localArrayList.add(new h(this, 16, getString(2131165673)));
    localArrayList.add(new h(this, 17, getString(2131165671)));
    return localArrayList;
  }
  
  private void s()
  {
    View localView = getActivity().getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 2);
    }
  }
  
  private void t()
  {
    this.i.setText("");
    this.j.setText("");
    this.o.setText("");
    if (this.y != null) {
      this.y.a();
    }
    this.z = null;
    l();
  }
  
  private boolean u()
  {
    if (this.d != null) {
      this.d.a();
    }
    if (this.e != null) {
      this.e.a();
    }
    return false;
  }
  
  protected boolean a()
  {
    if (u()) {
      return true;
    }
    return super.a();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.w = getActivity().getLayoutInflater();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131165646);
    this.b = c(2131231196);
    this.c = ((ScrollViewEx)c(2131231349));
    this.i = ((EditText)c(2131231353));
    this.f = ((ListView)c(2131231356));
    this.g = ((VerticalStretchLayout)c(2131231355));
    this.j = ((EditText)c(2131231359));
    this.k = ((ListView)c(2131231362));
    this.l = ((VerticalStretchLayout)c(2131231361));
    this.o = ((EditText)c(2131231298));
    this.q = ((Button)c(2131231365));
    this.r = ((ImageView)c(2131231360));
    this.p = ((ImageView)c(2131231354));
    this.s = ((TextView)c(2131231358));
    this.t = ((TextView)c(2131231364));
    this.s.setVisibility(4);
    this.t.setVisibility(4);
    this.b.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.i.setEnabled(true);
    this.j.clearFocus();
    this.j.addTextChangedListener(new b(this));
    this.o.clearFocus();
    this.o.setMovementMethod(ScrollingMovementMethod.getInstance());
    this.o.setOnTouchListener(new c(this));
    this.c.setOnTouchListener(new d(this));
    if (!com.gau.go.launcherex.gowidget.d.g.a(getActivity().getApplicationContext()))
    {
      Toast.makeText(getActivity(), getText(2131165656), 0).show();
      this.v = System.currentTimeMillis();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (110 == paramInt1) {
      t();
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = 0;
    if (paramView.equals(this.b)) {
      if (!u()) {
        h();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramView.equals(this.p)) || (paramView.equals(this.i)))
          {
            paramView = (Boolean)this.k.getTag();
            if ((paramView != null) && (paramView.booleanValue() == true)) {
              o();
            }
            paramView = (Boolean)this.f.getTag();
            if ((paramView == null) || (!paramView.booleanValue()))
            {
              j();
              return;
            }
            k();
            return;
          }
          if ((paramView.equals(this.j)) || (paramView.equals(this.r)))
          {
            paramView = (Boolean)this.f.getTag();
            if ((paramView != null) && (paramView.booleanValue() == true)) {
              k();
            }
            paramView = (Boolean)this.k.getTag();
            if ((paramView == null) || (!paramView.booleanValue()))
            {
              m();
              return;
            }
            o();
            return;
          }
        } while (!paramView.equals(this.q));
        p();
        paramView = new FeedbackBean();
        if (this.z != null)
        {
          paramView.a(this.z.b());
          paramView.b(this.j.getText().toString());
          paramView.c(this.o.getText().toString());
          paramView.a(this.z.a());
          paramView.e(this.m);
        }
      } while (!b(paramView));
      if (com.gau.go.launcherex.gowidget.d.g.a(getActivity().getApplicationContext())) {
        break;
      }
    } while (System.currentTimeMillis() - this.v <= 2000L);
    Toast.makeText(getActivity(), getText(2131165656), 2000).show();
    this.v = System.currentTimeMillis();
    return;
    if (this.y != null)
    {
      Object localObject1 = this.y.b();
      if (localObject1 != null)
      {
        paramView.b(((g)localObject1).a() + "[" + ((g)localObject1).a + "]");
        localObject1 = f.a(getActivity().getApplicationContext()).a(((g)localObject1).a);
        if (localObject1 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("\nNow Weather:\n");
          Object localObject2 = com.gau.go.launcherex.gowidget.language.d.a(getActivity().getApplicationContext()).d();
          localStringBuilder.append("language : " + (String)localObject2 + "\n");
          localObject2 = com.jiubang.b.c.a.a(((WeatherBean)localObject1).k.f(), "yyyy-MM-dd HH:mm:ss Z");
          localStringBuilder.append("UpdateTime : " + (String)localObject2 + "\n");
          localObject2 = com.jiubang.b.c.a.a(((WeatherBean)localObject1).k.B(), "yyyy-MM-dd HH:mm:ss Z");
          localStringBuilder.append("WeatherTimestamp : " + (String)localObject2 + "\n");
          localStringBuilder.append("Weather status : " + ((WeatherBean)localObject1).k.e() + "\n");
          localStringBuilder.append("NowTemp : " + ((WeatherBean)localObject1).k.a(2) + "\n");
          localStringBuilder.append("HighTemp : " + ((WeatherBean)localObject1).k.b(2) + "\n");
          localStringBuilder.append("LowTemp : " + ((WeatherBean)localObject1).k.c(2) + "\n");
          localStringBuilder.append("\nHourly Forecast:\n");
          int i3 = ((WeatherBean)localObject1).h.size();
          int i1 = 0;
          while (i1 < i3)
          {
            localObject2 = (HourlyBean)((WeatherBean)localObject1).h.get(i1);
            localStringBuilder.append("Time : " + ((HourlyBean)localObject2).a() + "/" + ((HourlyBean)localObject2).b() + "/" + ((HourlyBean)localObject2).c() + " " + ((HourlyBean)localObject2).d() + ":00" + "\n");
            localStringBuilder.append("Status : " + ((HourlyBean)localObject2).g() + "\n");
            localStringBuilder.append("Temp : " + ((HourlyBean)localObject2).b(2) + "\n \n");
            i1 += 1;
          }
          localStringBuilder.append("Future Weather:\n");
          i3 = ((WeatherBean)localObject1).g.size();
          i1 = i2;
          while (i1 < i3)
          {
            localObject2 = (ForecastBean)((WeatherBean)localObject1).g.get(i1);
            localStringBuilder.append("Time : " + ((ForecastBean)localObject2).e() + "/" + ((ForecastBean)localObject2).f() + "/" + ((ForecastBean)localObject2).g() + "\n");
            localStringBuilder.append("Status : " + ((ForecastBean)localObject2).d() + "\n");
            localStringBuilder.append("HighTemp : " + ((ForecastBean)localObject2).b(2) + "\n");
            localStringBuilder.append("LowTemp : " + ((ForecastBean)localObject2).a(2) + "\n \n");
            i1 += 1;
          }
          paramView.d(localStringBuilder.toString());
        }
      }
    }
    if (3 == paramView.d()) {
      a(paramView);
    }
    c(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903143, paramViewGroup, false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.A) {
      this.A = false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */