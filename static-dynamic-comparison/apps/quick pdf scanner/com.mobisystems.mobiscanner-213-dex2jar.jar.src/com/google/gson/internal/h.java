package com.google.gson.internal;

import com.google.gson.internal.a.n;
import com.google.gson.m;
import com.google.gson.stream.b;
import java.io.Writer;

public final class h
{
  public static Writer a(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new a(paramAppendable, null);
  }
  
  public static void b(com.google.gson.h paramh, b paramb)
  {
    n.agV.a(paramb, paramh);
  }
  
  private static class a
    extends Writer
  {
    private final Appendable afs;
    private final a aft = new a();
    
    private a(Appendable paramAppendable)
    {
      this.afs = paramAppendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int paramInt)
    {
      this.afs.append((char)paramInt);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      this.aft.afu = paramArrayOfChar;
      this.afs.append(this.aft, paramInt1, paramInt1 + paramInt2);
    }
    
    static class a
      implements CharSequence
    {
      char[] afu;
      
      public char charAt(int paramInt)
      {
        return this.afu[paramInt];
      }
      
      public int length()
      {
        return this.afu.length;
      }
      
      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.afu, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */