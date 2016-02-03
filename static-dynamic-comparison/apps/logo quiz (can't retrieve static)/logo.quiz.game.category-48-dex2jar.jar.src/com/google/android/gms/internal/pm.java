package com.google.android.gms.internal;

import java.io.IOException;

public abstract class pm
{
  protected volatile int awJ = -1;
  
  public static final <T extends pm> T a(T paramT, byte[] paramArrayOfByte)
    throws pl
  {
    return b(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void a(pm parampm, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = pf.b(paramArrayOfByte, paramInt1, paramInt2);
      parampm.a(paramArrayOfByte);
      paramArrayOfByte.qw();
      return;
    }
    catch (IOException parampm)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", parampm);
    }
  }
  
  public static final <T extends pm> T b(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws pl
  {
    try
    {
      paramArrayOfByte = pe.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.b(paramArrayOfByte);
      paramArrayOfByte.gl(0);
      return paramT;
    }
    catch (pl paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] f(pm parampm)
  {
    byte[] arrayOfByte = new byte[parampm.qG()];
    a(parampm, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public void a(pf parampf)
    throws IOException
  {}
  
  public abstract pm b(pe parampe)
    throws IOException;
  
  protected int c()
  {
    return 0;
  }
  
  public int qF()
  {
    if (this.awJ < 0) {
      qG();
    }
    return this.awJ;
  }
  
  public int qG()
  {
    int i = c();
    this.awJ = i;
    return i;
  }
  
  public String toString()
  {
    return pn.g(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */