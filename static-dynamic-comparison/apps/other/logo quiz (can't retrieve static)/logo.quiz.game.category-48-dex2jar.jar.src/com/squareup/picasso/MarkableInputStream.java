package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream
  extends InputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  private long defaultMark = -1L;
  private final InputStream in;
  private long limit;
  private long offset;
  private long reset;
  
  public MarkableInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, 4096);
  }
  
  public MarkableInputStream(InputStream paramInputStream, int paramInt)
  {
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new BufferedInputStream(paramInputStream, paramInt);
    }
    this.in = ((InputStream)localObject);
  }
  
  /* Error */
  private void setLimit(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/squareup/picasso/MarkableInputStream:reset	J
    //   4: aload_0
    //   5: getfield 44	com/squareup/picasso/MarkableInputStream:offset	J
    //   8: lcmp
    //   9: ifge +54 -> 63
    //   12: aload_0
    //   13: getfield 44	com/squareup/picasso/MarkableInputStream:offset	J
    //   16: aload_0
    //   17: getfield 46	com/squareup/picasso/MarkableInputStream:limit	J
    //   20: lcmp
    //   21: ifgt +42 -> 63
    //   24: aload_0
    //   25: getfield 36	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   28: invokevirtual 48	java/io/InputStream:reset	()V
    //   31: aload_0
    //   32: getfield 36	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   35: lload_1
    //   36: aload_0
    //   37: getfield 42	com/squareup/picasso/MarkableInputStream:reset	J
    //   40: lsub
    //   41: l2i
    //   42: invokevirtual 52	java/io/InputStream:mark	(I)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 42	com/squareup/picasso/MarkableInputStream:reset	J
    //   50: aload_0
    //   51: getfield 44	com/squareup/picasso/MarkableInputStream:offset	J
    //   54: invokespecial 56	com/squareup/picasso/MarkableInputStream:skip	(JJ)V
    //   57: aload_0
    //   58: lload_1
    //   59: putfield 46	com/squareup/picasso/MarkableInputStream:limit	J
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 44	com/squareup/picasso/MarkableInputStream:offset	J
    //   68: putfield 42	com/squareup/picasso/MarkableInputStream:reset	J
    //   71: aload_0
    //   72: getfield 36	com/squareup/picasso/MarkableInputStream:in	Ljava/io/InputStream;
    //   75: lload_1
    //   76: aload_0
    //   77: getfield 44	com/squareup/picasso/MarkableInputStream:offset	J
    //   80: lsub
    //   81: l2i
    //   82: invokevirtual 52	java/io/InputStream:mark	(I)V
    //   85: goto -28 -> 57
    //   88: astore_3
    //   89: new 58	java/lang/IllegalStateException
    //   92: dup
    //   93: new 60	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   100: ldc 63
    //   102: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 77	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MarkableInputStream
    //   0	116	1	paramLong	long
    //   88	18	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	57	88	java/io/IOException
    //   57	62	88	java/io/IOException
    //   63	85	88	java/io/IOException
  }
  
  private void skip(long paramLong1, long paramLong2)
    throws IOException
  {
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        long l2 = this.in.skip(paramLong2 - paramLong1);
        l1 = l2;
        if (l2 != 0L) {
          break label41;
        }
        if (read() != -1) {}
      }
      else
      {
        return;
      }
      long l1 = 1L;
      label41:
      paramLong1 += l1;
    }
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    this.in.close();
  }
  
  public void mark(int paramInt)
  {
    this.defaultMark = savePosition(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      this.offset += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte);
    if (i != -1) {
      this.offset += i;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.offset += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    reset(this.defaultMark);
  }
  
  public void reset(long paramLong)
    throws IOException
  {
    if ((this.offset > this.limit) || (paramLong < this.reset)) {
      throw new IOException("Cannot reset");
    }
    this.in.reset();
    skip(this.reset, paramLong);
    this.offset = paramLong;
  }
  
  public long savePosition(int paramInt)
  {
    long l = this.offset + paramInt;
    if (this.limit < l) {
      setLimit(l);
    }
    return this.offset;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = this.in.skip(paramLong);
    this.offset += paramLong;
    return paramLong;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/squareup/picasso/MarkableInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */