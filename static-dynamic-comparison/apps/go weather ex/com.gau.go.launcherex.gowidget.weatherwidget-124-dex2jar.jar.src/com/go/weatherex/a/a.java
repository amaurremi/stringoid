package com.go.weatherex.a;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.getjar.sdk.Account;
import com.getjar.sdk.GetjarClient;
import com.gtp.go.weather.sharephoto.b.o;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
  extends com.go.weatherex.framework.fragment.a
  implements TextWatcher, View.OnClickListener, e
{
  private View a;
  private EditText b;
  private TextView c;
  private Button d;
  private View e;
  private TextView f;
  private View g;
  private View h;
  private o i;
  private d j;
  private f k;
  private boolean l = false;
  
  public static String a(String paramString)
  {
    return Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
  }
  
  private void b()
  {
    String str = this.b.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      if (str.length() == 8)
      {
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        this.h.setVisibility(0);
        this.d.setVisibility(8);
        this.j.a(getActivity().getApplicationContext(), str, this.i.b());
        return;
      }
      this.c.setText(b(2131166065));
      this.c.setVisibility(0);
      return;
    }
    this.c.setText(b(2131166064));
    this.c.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if (getActivity() == null) {
      return;
    }
    this.h.setVisibility(8);
    this.a.setVisibility(0);
    this.d.setVisibility(0);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.c.setText(b(2131166073));
      this.c.setVisibility(0);
      return;
    case 1: 
      this.l = true;
      this.f.setText(b(2131166072));
      this.g.setVisibility(8);
      this.k.a("go_weather_ex_premium_activation", true);
      this.k.b("go_weather_ex_premium_activation");
      this.d.postDelayed(new c(this), 1000L);
      return;
    case 2: 
      this.c.setText(b(2131166074));
      this.c.setVisibility(0);
      return;
    case 3: 
      this.c.setText(b(2131166075));
      this.c.setVisibility(0);
      return;
    case 4: 
      this.c.setText(b(2131166076));
      this.c.setVisibility(0);
      return;
    }
    this.c.setText(b(2131166077));
    this.c.setVisibility(0);
  }
  
  protected boolean a()
  {
    if (this.l) {
      return true;
    }
    return super.a();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.b.getText().toString();
    String str = a(paramEditable.toString());
    if (TextUtils.isEmpty(str)) {
      this.b.setTypeface(Typeface.defaultFromStyle(0));
    }
    for (;;)
    {
      if (!paramEditable.equals(str))
      {
        this.b.setText(str);
        this.b.setSelection(str.length());
      }
      if ((paramEditable.length() < 8) && (this.c.getVisibility() == 0)) {
        this.c.setVisibility(8);
      }
      return;
      this.b.setTypeface(Typeface.defaultFromStyle(1));
    }
  }
  
  public String b(int paramInt)
  {
    if (getActivity() != null) {
      return getActivity().getResources().getString(paramInt);
    }
    return "";
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.c = ((TextView)c(2131230792));
    this.c.setVisibility(8);
    this.d = ((Button)c(2131230794));
    this.e = c(2131230795);
    this.f = ((TextView)c(2131230788));
    this.g = c(2131230789);
    this.h = c(2131230793);
    this.h.setVisibility(8);
    this.b = ((EditText)c(2131230791));
    this.a = c(2131230790);
    this.b.addTextChangedListener(this);
    this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(8) });
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.j = new d();
    this.j.a(this);
    this.k = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext()).e();
    this.i = new o(com.gtp.go.weather.sharephoto.a.g.a(getActivity().getApplicationContext()).b());
    Object localObject;
    if (TextUtils.isEmpty(this.i.b()))
    {
      localObject = com.gau.go.launcherex.gowidget.a.g.a(getActivity()).c();
      if (localObject == null) {
        break label365;
      }
      paramBundle = ((GetjarClient)localObject).getCurrentAccount();
      if (paramBundle == null) {
        break label370;
      }
      paramBundle = paramBundle.getName();
      label264:
      if (TextUtils.isEmpty(paramBundle)) {
        break label387;
      }
      this.i.b(paramBundle);
    }
    label315:
    label365:
    label370:
    label376:
    label381:
    label387:
    for (int m = 1;; m = 0)
    {
      if (m == 0)
      {
        localObject = ((GetjarClient)localObject).getAvailableAccounts();
        if ((localObject == null) || (((List)localObject).size() != 1)) {
          break label376;
        }
        localObject = (Account)((List)localObject).get(0);
        if (localObject == null) {
          break label381;
        }
      }
      for (localObject = ((Account)localObject).getName();; localObject = "")
      {
        if (!TextUtils.isEmpty(paramBundle)) {
          this.i.b((String)localObject);
        }
        this.b.setOnEditorActionListener(new b(this));
        a(this.f, 4, 0);
        return;
        paramBundle = null;
        break;
        paramBundle = "";
        break label264;
        localObject = null;
        break label315;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.d)) {
      b();
    }
    while (!paramView.equals(this.e)) {
      return;
    }
    paramView = new Intent(getActivity(), BillingActivity.class);
    paramView.addFlags(268435456);
    getActivity().startActivity(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903041, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.j.a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */