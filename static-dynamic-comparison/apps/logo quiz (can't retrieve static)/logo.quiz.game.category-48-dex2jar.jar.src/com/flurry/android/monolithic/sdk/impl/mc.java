package com.flurry.android.monolithic.sdk.impl;

import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class mc
  implements Flushable
{
  public abstract void a()
    throws IOException;
  
  public abstract void a(double paramDouble)
    throws IOException;
  
  public abstract void a(float paramFloat)
    throws IOException;
  
  public abstract void a(int paramInt)
    throws IOException;
  
  public abstract void a(long paramLong)
    throws IOException;
  
  public abstract void a(nw paramnw)
    throws IOException;
  
  public void a(CharSequence paramCharSequence)
    throws IOException
  {
    if ((paramCharSequence instanceof nw))
    {
      a((nw)paramCharSequence);
      return;
    }
    a(paramCharSequence.toString());
  }
  
  public void a(String paramString)
    throws IOException
  {
    a(new nw(paramString));
  }
  
  public abstract void a(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void a(boolean paramBoolean)
    throws IOException;
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void b()
    throws IOException;
  
  public abstract void b(int paramInt)
    throws IOException;
  
  public abstract void b(long paramLong)
    throws IOException;
  
  public void b(byte[] paramArrayOfByte)
    throws IOException
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void c()
    throws IOException;
  
  public abstract void c(int paramInt)
    throws IOException;
  
  public abstract void d()
    throws IOException;
  
  public abstract void e()
    throws IOException;
  
  public abstract void f()
    throws IOException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */