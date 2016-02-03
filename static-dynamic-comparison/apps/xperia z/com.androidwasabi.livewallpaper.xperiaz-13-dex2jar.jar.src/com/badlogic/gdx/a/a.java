package com.badlogic.gdx.a;

public class a<T>
{
  public final String a;
  public final Class<T> b;
  public final c c;
  public com.badlogic.gdx.c.a d;
  
  public a(String paramString, Class<T> paramClass, c<T> paramc)
  {
    this.a = paramString.replaceAll("\\\\", "/");
    this.b = paramClass;
    this.c = paramc;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(", ");
    localStringBuffer.append(this.b.getName());
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */