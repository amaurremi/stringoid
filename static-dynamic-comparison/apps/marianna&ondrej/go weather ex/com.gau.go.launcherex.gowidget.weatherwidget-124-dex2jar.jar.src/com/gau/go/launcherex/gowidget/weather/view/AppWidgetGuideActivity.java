package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;

public class AppWidgetGuideActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private View a;
  private View b;
  private View c;
  
  private void a(ImageView paramImageView)
  {
    int i = (int)(paramImageView.getWidth() / 0.60330576F);
    paramImageView.getLayoutParams().height = i;
    paramImageView.requestLayout();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      finish();
    }
    while (!paramView.equals(this.b)) {
      return;
    }
    paramView = new Intent("android.intent.action.MAIN");
    paramView.addCategory("android.intent.category.HOME");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903069);
    getWindow().clearFlags(134217728);
    this.b = findViewById(2131231073);
    this.b.setOnClickListener(this);
    this.c = findViewById(2131230796);
    this.c.setOnClickListener(this);
    this.a = findViewById(2131231062);
    this.a.post(new r(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AppWidgetGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */