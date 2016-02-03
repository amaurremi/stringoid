package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class e
{
  private static final a cP = new d();
  private final Object cQ;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      cP = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      cP = new b();
      return;
    }
  }
  
  public e()
  {
    this.cQ = cP.a(this);
  }
  
  public e(Object paramObject)
  {
    this.cQ = paramObject;
  }
  
  public Object Q()
  {
    return this.cQ;
  }
  
  public List<a> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  public a q(int paramInt)
  {
    return null;
  }
  
  public a r(int paramInt)
  {
    return null;
  }
  
  static abstract interface a
  {
    public abstract Object a(e parame);
  }
  
  static class b
    extends e.d
  {
    public Object a(final e parame)
    {
      f.a(new f.a()
      {
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = parame.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((a)paramAnonymousString.get(paramAnonymousInt)).P());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return parame.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
        
        public Object s(int paramAnonymousInt)
        {
          a locala = parame.q(paramAnonymousInt);
          if (locala == null) {
            return null;
          }
          return locala.P();
        }
      });
    }
  }
  
  static class c
    extends e.d
  {
    public Object a(final e parame)
    {
      g.a(new g.a()
      {
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          paramAnonymousString = parame.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          ArrayList localArrayList = new ArrayList();
          int i = paramAnonymousString.size();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            localArrayList.add(((a)paramAnonymousString.get(paramAnonymousInt)).P());
            paramAnonymousInt += 1;
          }
          return localArrayList;
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return parame.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
        
        public Object s(int paramAnonymousInt)
        {
          a locala = parame.q(paramAnonymousInt);
          if (locala == null) {
            return null;
          }
          return locala.P();
        }
        
        public Object t(int paramAnonymousInt)
        {
          a locala = parame.r(paramAnonymousInt);
          if (locala == null) {
            return null;
          }
          return locala.P();
        }
      });
    }
  }
  
  static class d
    implements e.a
  {
    public Object a(e parame)
    {
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */