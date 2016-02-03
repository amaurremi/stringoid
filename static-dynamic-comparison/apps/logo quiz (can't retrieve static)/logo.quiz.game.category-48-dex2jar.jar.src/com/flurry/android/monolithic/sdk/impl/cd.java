package com.flurry.android.monolithic.sdk.impl;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class cd
{
  private String a;
  private long b;
  private long c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public cd() {}
  
  public cd(DataInput paramDataInput)
    throws IOException
  {
    this.a = paramDataInput.readUTF();
    this.b = paramDataInput.readLong();
    this.c = paramDataInput.readLong();
    this.d = paramDataInput.readInt();
    this.e = paramDataInput.readInt();
    this.f = paramDataInput.readInt();
    this.g = paramDataInput.readInt();
  }
  
  public cd(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.d = 0;
  }
  
  public cd a()
  {
    cd localcd = new cd(b(), i(), h(), e(), f(), g());
    localcd.a(c());
    return localcd;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(this.a);
    paramDataOutput.writeLong(this.b);
    paramDataOutput.writeLong(this.c);
    paramDataOutput.writeInt(this.d);
    paramDataOutput.writeInt(this.e);
    paramDataOutput.writeInt(this.f);
    paramDataOutput.writeInt(this.g);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public void d()
  {
    this.d += 1;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public long h()
  {
    return this.c;
  }
  
  public long i()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */