package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ax
  extends aj
{
  private static final String ID = a.ab.toString();
  private static final String aeh = b.bH.toString();
  private final Context kM;
  
  public ax(Context paramContext)
  {
    super(ID, new String[0]);
    this.kM = paramContext;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    if ((d.a)paramMap.get(aeh) != null) {}
    for (paramMap = dh.j((d.a)paramMap.get(aeh));; paramMap = null)
    {
      paramMap = ay.e(this.kM, paramMap);
      if (paramMap == null) {
        break;
      }
      return dh.r(paramMap);
    }
    return dh.mY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */