package org.apache.a.c;

public class e
{
  public static final f a = new f();
  
  public static void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("Cannot get the toString of a null identity");
    }
    paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */