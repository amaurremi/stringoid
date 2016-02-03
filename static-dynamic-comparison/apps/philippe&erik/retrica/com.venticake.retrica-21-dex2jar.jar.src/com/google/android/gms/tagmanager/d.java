package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class d
{
  public final String a;
  public final Object b;
  
  d(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {}
    do
    {
      return false;
      paramObject = (d)paramObject;
    } while ((!this.a.equals(((d)paramObject).a)) || (!this.b.equals(((d)paramObject).b)));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Integer[] { Integer.valueOf(this.a.hashCode()), Integer.valueOf(this.b.hashCode()) });
  }
  
  public String toString()
  {
    return "Key: " + this.a + " value: " + this.b.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */