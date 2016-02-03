package com.chartboost.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBOrientation;
import com.chartboost.sdk.Libraries.CBUtility;
import org.json.JSONObject;

public class c
  extends b
  implements g.b
{
  private static int b = 100;
  private static int c = 5;
  private f d;
  
  public c(Context paramContext)
  {
    super(paramContext);
    this.d = new f(paramContext);
    addView(this.d, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public int a()
  {
    return CBUtility.a(b + c * 2, getContext());
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    boolean bool = CBPreferences.getInstance().getOrientation().isPortrait();
    Object localObject = paramJSONObject.optJSONObject("assets");
    if (localObject != null) {
      if (!bool) {
        break label84;
      }
    }
    label84:
    for (paramJSONObject = "portrait";; paramJSONObject = "landscape")
    {
      paramJSONObject = ((JSONObject)localObject).optJSONObject(paramJSONObject);
      if (paramJSONObject != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("index", paramInt);
        n.a().a(paramJSONObject.optString("url"), paramJSONObject.optString("checksum"), null, this.d, (Bundle)localObject);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */