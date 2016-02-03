package com.vungle.publisher;

import java.util.ArrayList;
import java.util.List;

final class dm
{
  private static final List<dm> d = new ArrayList();
  Object a;
  dr b;
  dm c;
  
  private dm(Object paramObject, dr paramdr)
  {
    this.a = paramObject;
    this.b = paramdr;
  }
  
  static dm a(dr paramdr, Object paramObject)
  {
    synchronized (d)
    {
      int i = d.size();
      if (i > 0)
      {
        dm localdm = (dm)d.remove(i - 1);
        localdm.a = paramObject;
        localdm.b = paramdr;
        localdm.c = null;
        return localdm;
      }
      return new dm(paramObject, paramdr);
    }
  }
  
  static void a(dm paramdm)
  {
    paramdm.a = null;
    paramdm.b = null;
    paramdm.c = null;
    synchronized (d)
    {
      if (d.size() < 10000) {
        d.add(paramdm);
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */