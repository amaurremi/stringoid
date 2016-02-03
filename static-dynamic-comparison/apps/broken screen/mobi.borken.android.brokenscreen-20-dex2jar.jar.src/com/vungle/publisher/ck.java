package com.vungle.publisher;

public final class ck
{
  public static String a(Throwable paramThrowable)
  {
    String str2 = paramThrowable.getMessage();
    String str1 = str2;
    if (str2 == null) {
      str1 = paramThrowable.getClass().getSimpleName();
    }
    return str1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */