package com.gau.go.launcherex.gowidget.weather.globaltheme.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.messagecenter.util.am;
import com.gau.go.launcherex.gowidget.messagecenter.util.c;
import com.gau.go.launcherex.gowidget.messagecenter.util.g;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.a;
import java.util.ArrayList;
import java.util.Iterator;

public class MyCouponsActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, g
{
  private View a;
  private ViewGroup b;
  private ViewGroup c;
  private ViewGroup d;
  private View e;
  private View f;
  private View g;
  private c h;
  
  private View a(a parama, boolean paramBoolean)
  {
    Object localObject = getLayoutInflater();
    ImageView localImageView;
    TextView localTextView;
    if (paramBoolean)
    {
      localObject = ((LayoutInflater)localObject).inflate(2130903241, null);
      if (parama != null)
      {
        localImageView = (ImageView)((View)localObject).findViewById(2131231738);
        localTextView = (TextView)((View)localObject).findViewById(2131231739);
        if (parama.b() != 1) {
          break label113;
        }
        if (!paramBoolean) {
          break label103;
        }
        localImageView.setImageResource(2130837753);
      }
    }
    for (;;)
    {
      localTextView.setText(String.format(getString(2131166052), new Object[] { am.a(parama.c()) }));
      return (View)localObject;
      localObject = ((LayoutInflater)localObject).inflate(2130903240, null);
      break;
      label103:
      localImageView.setImageResource(2130837756);
      continue;
      label113:
      if (parama.b() == 2) {
        if (paramBoolean) {
          localImageView.setImageResource(2130837754);
        } else {
          localImageView.setImageResource(2130837757);
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.b.removeAllViews();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        View localView = a((a)paramArrayList.next(), true);
        this.b.addView(localView);
      }
      this.b.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.c.removeAllViews();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        View localView = a((a)paramArrayList.next(), false);
        this.c.addView(localView);
      }
      this.c.setVisibility(0);
      this.f.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  public void c(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      this.d.removeAllViews();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        View localView = a((a)paramArrayList.next(), false);
        this.d.addView(localView);
      }
      this.d.setVisibility(0);
      this.g.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903239);
    getWindow().clearFlags(134217728);
    this.a = findViewById(2131231737);
    this.b = ((ViewGroup)findViewById(2131231732));
    this.c = ((ViewGroup)findViewById(2131231734));
    this.d = ((ViewGroup)findViewById(2131231736));
    this.e = findViewById(2131231731);
    this.f = findViewById(2131231733);
    this.g = findViewById(2131231735);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.a.setOnClickListener(this);
    this.h = new c(getApplicationContext());
    this.h.a(this);
    this.h.b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h.c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/view/MyCouponsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */