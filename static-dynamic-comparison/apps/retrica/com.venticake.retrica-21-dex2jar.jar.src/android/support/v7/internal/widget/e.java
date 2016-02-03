package android.support.v7.internal.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class e
  implements Comparable<e>
{
  public final ResolveInfo a;
  public float b;
  
  public e(d paramd, ResolveInfo paramResolveInfo)
  {
    this.a = paramResolveInfo;
  }
  
  public int a(e parame)
  {
    return Float.floatToIntBits(parame.b) - Float.floatToIntBits(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (e)paramObject;
    } while (Float.floatToIntBits(this.b) == Float.floatToIntBits(((e)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.b) + 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(this.a.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(this.b));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */