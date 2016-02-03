package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class e
  extends aj
{
  private static final String ID = a.W.toString();
  private static final String WA = b.bH.toString();
  private static final String WB = b.bK.toString();
  private final Context kI;
  
  public e(Context paramContext)
  {
    super(ID, new String[] { WB });
    this.kI = paramContext;
  }
  
  public boolean jX()
  {
    return true;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(WB);
    if (localObject == null) {
      return dh.lT();
    }
    localObject = dh.j((d.a)localObject);
    paramMap = (d.a)paramMap.get(WA);
    if (paramMap != null) {}
    for (paramMap = dh.j(paramMap);; paramMap = null)
    {
      paramMap = ay.e(this.kI, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return dh.r(paramMap);
    }
    return dh.lT();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */