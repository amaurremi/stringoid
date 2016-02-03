package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WidgetUserGuideActivity
  extends Activity
  implements View.OnClickListener
{
  private LinearLayout a;
  private LinearLayout b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private View f;
  private LayoutInflater g;
  
  private void a(LinearLayout paramLinearLayout, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      TextView localTextView = (TextView)this.g.inflate(2130903315, null);
      localTextView.setText(paramArrayOfString[i]);
      paramLinearLayout.addView(localTextView);
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.f)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903314);
    getWindow().clearFlags(134217728);
    this.g = getLayoutInflater();
    this.a = ((LinearLayout)findViewById(2131231963));
    this.b = ((LinearLayout)findViewById(2131231965));
    this.c = ((TextView)findViewById(2131231962));
    this.d = ((TextView)findViewById(2131231964));
    this.e = ((ImageView)findViewById(2131231146));
    this.f = findViewById(2131230796);
    this.f.setOnClickListener(this);
    switch (getIntent().getIntExtra("widget_user_guide_type", 3))
    {
    default: 
      return;
    case 3: 
      paramBundle = getResources().getStringArray(2131558446);
      a(this.a, paramBundle);
      paramBundle = getResources().getStringArray(2131558447);
      a(this.b, paramBundle);
      return;
    case 1: 
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      this.b.setVisibility(8);
      paramBundle = getResources().getStringArray(2131558446);
      a(this.a, paramBundle);
      return;
    }
    this.e.setVisibility(8);
    this.c.setVisibility(8);
    this.a.setVisibility(8);
    paramBundle = getResources().getStringArray(2131558447);
    a(this.b, paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/WidgetUserGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */