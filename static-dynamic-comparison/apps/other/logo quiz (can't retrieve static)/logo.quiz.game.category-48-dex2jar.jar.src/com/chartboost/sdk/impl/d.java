package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.CBUtility;
import org.json.JSONObject;

public class d
  extends b
  implements g.b
{
  private static int c = 50;
  private static int d = 10;
  public e b;
  private f e;
  private TextView f;
  
  public d(Context paramContext)
  {
    super(paramContext);
    this.e = new f(paramContext);
    this.b = new e(paramContext);
    this.f = new TextView(paramContext);
    this.f.setTypeface(null, 1);
    this.f.setTextSize(2, 16.0F);
    this.f.setShadowLayer(1.0F, 1.0F, 1.0F, -1);
    this.f.setBackgroundColor(0);
    this.f.setTextColor(-16777216);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    setBackgroundColor(-3355444);
    setFocusable(false);
    addView(this.e);
    addView(this.f);
    addView(this.b);
  }
  
  public int a()
  {
    return CBUtility.a(c + d * 2, getContext());
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    this.f.setText(paramJSONObject.optString("name", "Unknown App"));
    Object localObject = paramJSONObject.optString("deep-text");
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      this.b.setText((CharSequence)localObject);
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONObject("assets");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("icon");
        if (paramJSONObject != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("index", paramInt);
          n.a().a(paramJSONObject.optString("url"), paramJSONObject.optString("checksum"), null, this.e, (Bundle)localObject);
        }
      }
      b();
      return;
      localObject = paramJSONObject.optString("text", "VIEW");
      this.b.setText((CharSequence)localObject);
    }
  }
  
  protected void b()
  {
    int i = CBUtility.a(c, getContext());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(i, i);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-2, -2);
    i = CBUtility.a(d, getContext());
    localLayoutParams1.setMargins(i, i, i, i);
    localLayoutParams2.setMargins(i, i, i, i);
    localLayoutParams3.setMargins(i, i, i, i);
    localLayoutParams2.weight = 1.0F;
    this.f.setGravity(16);
    localLayoutParams3.gravity = 16;
    this.e.setLayoutParams(localLayoutParams1);
    this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.f.setLayoutParams(localLayoutParams2);
    this.b.setLayoutParams(localLayoutParams3);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */