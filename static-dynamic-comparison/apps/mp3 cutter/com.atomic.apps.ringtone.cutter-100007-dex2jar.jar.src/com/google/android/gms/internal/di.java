package com.google.android.gms.internal;

public final class di
{
  private final byte[] a;
  private final int b;
  private int c;
  
  private di(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.c = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  public static di a(byte[] paramArrayOfByte)
  {
    return new di(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private void b(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        a(paramInt);
        return;
      }
      a(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final int a()
  {
    return this.b - this.c;
  }
  
  public final void a(int paramInt)
  {
    int i = (byte)paramInt;
    if (this.c == this.b) {
      throw new dj(this.c, this.b);
    }
    byte[] arrayOfByte = this.a;
    paramInt = this.c;
    this.c = (paramInt + 1);
    arrayOfByte[paramInt] = i;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    b(dk.a(paramInt1, paramInt2));
  }
  
  public final void a(int paramInt, String paramString)
  {
    a(paramInt, 2);
    paramString = paramString.getBytes("UTF-8");
    b(paramString.length);
    paramInt = paramString.length;
    if (this.b - this.c >= paramInt)
    {
      System.arraycopy(paramString, 0, this.a, this.c, paramInt);
      this.c += paramInt;
      return;
    }
    throw new dj(this.c, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */