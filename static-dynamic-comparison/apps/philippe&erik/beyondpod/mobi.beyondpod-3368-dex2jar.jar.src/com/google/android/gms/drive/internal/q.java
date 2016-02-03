package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.iw;
import com.google.android.gms.internal.ix;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.jb;
import java.io.IOException;

public final class q
  extends iz
{
  public static final q[] rs = new q[0];
  public String rt = "";
  public long ru = -1L;
  public long rv = -1L;
  private int rw = -1;
  public int versionCode = 1;
  
  public static q e(byte[] paramArrayOfByte)
    throws iy
  {
    return (q)iz.a(new q(), paramArrayOfByte);
  }
  
  public q a(iw paramiw)
    throws IOException
  {
    for (;;)
    {
      int i = paramiw.fU();
      switch (i)
      {
      default: 
        if (jb.a(paramiw, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.versionCode = paramiw.fW();
        break;
      case 18: 
        this.rt = paramiw.readString();
        break;
      case 24: 
        this.ru = paramiw.fX();
        break;
      case 32: 
        this.rv = paramiw.fX();
      }
    }
  }
  
  public void a(ix paramix)
    throws IOException
  {
    paramix.d(1, this.versionCode);
    paramix.b(2, this.rt);
    paramix.c(3, this.ru);
    paramix.c(4, this.rv);
  }
  
  public int cP()
  {
    int i = 0 + ix.e(1, this.versionCode) + ix.e(2, this.rt) + ix.d(3, this.ru) + ix.d(4, this.rv);
    this.rw = i;
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */