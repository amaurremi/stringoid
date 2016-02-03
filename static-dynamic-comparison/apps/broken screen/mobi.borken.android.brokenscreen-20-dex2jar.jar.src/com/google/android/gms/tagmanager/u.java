package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class u
  extends aj
{
  private static final String ID = a.C.toString();
  private static final String NAME = b.dc.toString();
  private static final String aff = b.cb.toString();
  private final DataLayer aer;
  
  public u(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.aer = paramDataLayer;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject = this.aer.get(dh.j((d.a)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (d.a)paramMap.get(aff);
      if (paramMap != null) {
        return paramMap;
      }
      return dh.mY();
    }
    return dh.r(localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */