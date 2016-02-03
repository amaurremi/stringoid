package cmn;

import android.util.FloatMath;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

public final class ab
{
  protected LinkedHashMap a = new ac(this, (int)FloatMath.ceil(133.33333F) + 1);
  
  /* Error */
  public final Object a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	cmn/ab:a	Ljava/util/LinkedHashMap;
    //   6: aload_1
    //   7: invokevirtual 31	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 33	java/lang/ref/SoftReference
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: aload_2
    //   25: invokevirtual 36	java/lang/ref/SoftReference:get	()Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: ifnonnull -12 -> 20
    //   35: aload_0
    //   36: getfield 24	cmn/ab:a	Ljava/util/LinkedHashMap;
    //   39: aload_1
    //   40: invokevirtual 39	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_3
    //   45: astore_2
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ab
    //   0	54	1	paramObject	Object
    //   13	33	2	localObject1	Object
    //   28	17	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   24	29	49	finally
    //   35	44	49	finally
  }
  
  public final void a(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {}
    for (;;)
    {
      try
      {
        this.a.put(paramObject1, null);
        return;
      }
      finally {}
      this.a.put(paramObject1, new SoftReference(paramObject2));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */