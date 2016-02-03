package cmn;

import android.util.FloatMath;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

public final class n
{
  public static abstract interface a
  {
    public abstract Object a(Object paramObject);
    
    public abstract void a(Object paramObject1, Object paramObject2);
  }
  
  public static final class b
    implements n.a
  {
    private final LinkedHashMap a = new o(this, (int)FloatMath.ceil(133.33333F) + 1);
    
    public final Object a(Object paramObject)
    {
      Object localObject1 = (SoftReference)this.a.get(paramObject);
      if (localObject1 == null) {
        localObject1 = null;
      }
      Object localObject2;
      do
      {
        return localObject1;
        localObject2 = ((SoftReference)localObject1).get();
        localObject1 = localObject2;
      } while (localObject2 != null);
      this.a.remove(paramObject);
      return localObject2;
    }
    
    public final void a(Object paramObject1, Object paramObject2)
    {
      if (paramObject2 == null)
      {
        this.a.put(paramObject1, null);
        return;
      }
      this.a.put(paramObject1, new SoftReference(paramObject2));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */