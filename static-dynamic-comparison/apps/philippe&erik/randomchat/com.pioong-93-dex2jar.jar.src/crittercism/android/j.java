package crittercism.android;

import java.util.Vector;

public abstract class j
{
  protected String a;
  protected Vector b;
  
  public final void a(Object paramObject)
  {
    try
    {
      this.b.add(paramObject);
      return;
    }
    catch (Exception paramObject) {}
  }
  
  public final void a(Vector paramVector)
  {
    try
    {
      this.b.addAll(paramVector);
      return;
    }
    catch (Exception paramVector) {}
  }
  
  public final Vector e()
  {
    return this.b;
  }
  
  public final void f()
  {
    try
    {
      this.b.clear();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */