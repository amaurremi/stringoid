package com.go.weatherex.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class i
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private Activity d;
  private a e;
  
  public i(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = ((Activity)paramContext);
    this.d.getLayoutInflater().inflate(2130903170, this, true);
    setBackgroundResource(2130837940);
    this.a = ((ImageView)findViewById(2131231567));
    this.b = ((TextView)findViewById(2131231568));
    this.c = ((TextView)findViewById(2131231569));
  }
  
  public void a(a parama)
  {
    this.e = parama;
    parama = BitmapFactory.decodeFile(this.e.c());
    if (parama != null) {
      this.a.setImageBitmap(parama);
    }
    this.b.setText(this.e.f());
    this.c.setText(this.e.i());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */