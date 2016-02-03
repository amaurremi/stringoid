package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;

public class at
  extends au
{
  private int a;
  private int b;
  private byte[] c = new byte['Ȁ'];
  
  public int a()
  {
    return this.a;
  }
  
  public int a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.c, 0, this.b);
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  void b(int paramInt)
  {
    int j = this.a + paramInt;
    if (j < this.c.length) {
      return;
    }
    int i = this.c.length * 2;
    paramInt = i;
    if (i <= j) {
      paramInt = j + 128;
    }
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.c, 0, arrayOfByte, 0, this.b);
    this.c = arrayOfByte;
  }
  
  public void write(int paramInt)
  {
    b(1);
    byte[] arrayOfByte = this.c;
    int i = this.a;
    this.a = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    this.b = Math.max(this.a, this.b);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, this.c, this.a, paramInt2);
    this.a += paramInt2;
    this.b = Math.max(this.a, this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */