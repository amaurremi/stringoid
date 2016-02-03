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
  private static final String aeh = b.bH.toString();
  private static final String aei = b.bK.toString();
  private final Context kM;
  
  public e(Context paramContext)
  {
    super(ID, new String[] { aei });
    this.kM = paramContext;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = (d.a)paramMap.get(aei);
    if (localObject == null) {
      return dh.mY();
    }
    localObject = dh.j((d.a)localObject);
    paramMap = (d.a)paramMap.get(aeh);
    if (paramMap != null) {}
    for (paramMap = dh.j(paramMap);; paramMap = null)
    {
      paramMap = ay.d(this.kM, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return dh.r(paramMap);
    }
    return dh.mY();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */