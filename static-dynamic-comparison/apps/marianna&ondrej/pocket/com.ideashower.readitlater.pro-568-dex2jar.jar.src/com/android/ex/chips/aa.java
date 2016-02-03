package com.android.ex.chips;

import android.net.Uri;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import com.ideashower.readitlater.db.operation.f;
import com.pocket.h.b;

public class aa
{
  private final int a;
  private boolean b;
  private final String c;
  private final String d;
  private final long e;
  private final long f;
  private final boolean g;
  private final Uri h;
  private final f i;
  private byte[] j;
  
  public aa(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, Uri paramUri, boolean paramBoolean, f paramf)
  {
    this.a = paramInt;
    this.b = paramBoolean;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramLong1;
    this.f = paramLong2;
    this.h = paramUri;
    this.j = null;
    this.g = false;
    this.i = paramf;
  }
  
  public static aa a(f paramf)
  {
    if ((paramf != null) && (paramf.m())) {
      return new aa(1, paramf.h(), paramf.j(), -3L, -1L, paramf.k(), true, paramf);
    }
    return new aa(0, paramf.h(), paramf.h(), -2L, -1L, null, true, paramf);
  }
  
  public static aa a(String paramString)
  {
    return new aa(0, paramString, paramString, -1L, -1L, null, true, null);
  }
  
  public static aa a(String paramString1, String paramString2)
  {
    return new aa(0, paramString1, paramString2, -2L, -1L, null, true, null);
  }
  
  public static aa a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    if (paramString3 != null) {}
    for (paramString3 = Uri.parse(paramString3);; paramString3 = null) {
      return new aa(0, paramString1, paramString2, paramLong1, paramLong2, paramString3, true, null);
    }
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == -1L) || (paramLong == -2L);
  }
  
  public static aa b(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    if (paramString3 != null) {}
    for (paramString3 = Uri.parse(paramString3);; paramString3 = null) {
      return new aa(0, paramString1, paramString2, paramLong1, paramLong2, paramString3, false, null);
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.j = paramArrayOfByte;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public long d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public Uri f()
  {
    return this.h;
  }
  
  public byte[] g()
  {
    try
    {
      byte[] arrayOfByte = this.j;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean h()
  {
    return !this.g;
  }
  
  public f i()
  {
    return this.i;
  }
  
  public long j()
  {
    return this.f;
  }
  
  public String toString()
  {
    Object localObject = i();
    if (localObject != null) {
      if (((f)localObject).m()) {
        localObject = b.a((f)localObject).toString();
      }
    }
    String str2;
    String str1;
    do
    {
      do
      {
        return (String)localObject;
        return ((f)localObject).h();
        str2 = b();
        str1 = c();
        localObject = str1;
      } while (TextUtils.isEmpty(str2));
      localObject = str1;
    } while (TextUtils.equals(str2, str1));
    return new Rfc822Token(str2, str1, null).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */