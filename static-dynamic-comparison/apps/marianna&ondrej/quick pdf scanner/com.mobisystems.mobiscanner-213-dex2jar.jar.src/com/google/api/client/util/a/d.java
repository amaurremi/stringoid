package com.google.api.client.util.a;

final class d
{
  private static final ThreadLocal<char[]> aer = new ThreadLocal()
  {
    protected char[] yW()
    {
      return new char['Ѐ'];
    }
  };
  
  static char[] yV()
  {
    return (char[])aer.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */