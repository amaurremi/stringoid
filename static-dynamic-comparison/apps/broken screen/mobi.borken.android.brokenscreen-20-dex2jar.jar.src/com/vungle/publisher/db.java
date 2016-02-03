package com.vungle.publisher;

public abstract class db<T>
{
  public final Class<T> a;
  public final String[] b;
  public final Class<?>[] c;
  public final boolean d;
  public final Class<?>[] e;
  public final boolean f;
  public final boolean g;
  
  public db(Class<T> paramClass, String[] paramArrayOfString, Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    this.a = paramClass;
    this.b = paramArrayOfString;
    this.c = paramArrayOfClass1;
    this.d = false;
    this.e = paramArrayOfClass2;
    this.f = true;
    this.g = false;
  }
  
  public T a()
  {
    throw new UnsupportedOperationException("No no-args constructor on " + getClass().getName());
  }
  
  public void a(ct paramct, T paramT) {}
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof db))
    {
      paramObject = (db)paramObject;
      return this.a.equals(((db)paramObject).a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */