package com.amazonaws.javax.xml.stream;

import java.io.InputStream;

public final class XMLEntityManager$RewindableInputStream
  extends InputStream
{
  private byte[] fData = new byte[64];
  private int fEndOffset;
  private InputStream fInputStream;
  private int fLength;
  private int fMark;
  private int fOffset;
  private int fStartOffset;
  
  public XMLEntityManager$RewindableInputStream(XMLEntityManager paramXMLEntityManager, InputStream paramInputStream)
  {
    this.fInputStream = paramInputStream;
    this.fStartOffset = 0;
    this.fEndOffset = -1;
    this.fOffset = 0;
    this.fLength = 0;
    this.fMark = 0;
  }
  
  public int available()
  {
    int j = this.fLength - this.fOffset;
    int i = j;
    if (j == 0)
    {
      if (this.fOffset == this.fEndOffset) {
        i = -1;
      }
    }
    else {
      return i;
    }
    if (this.this$0.fCurrentEntity.mayReadChunks) {
      return this.fInputStream.available();
    }
    return 0;
  }
  
  public void close()
  {
    if (this.fInputStream != null)
    {
      this.fInputStream.close();
      this.fInputStream = null;
    }
  }
  
  public void mark(int paramInt)
  {
    this.fMark = this.fOffset;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    int i = -1;
    if (this.fOffset < this.fLength)
    {
      arrayOfByte = this.fData;
      i = this.fOffset;
      this.fOffset = (i + 1);
      i = arrayOfByte[i] & 0xFF;
    }
    while (this.fOffset == this.fEndOffset) {
      return i;
    }
    if (this.fOffset == this.fData.length)
    {
      arrayOfByte = new byte[this.fOffset << 1];
      System.arraycopy(this.fData, 0, arrayOfByte, 0, this.fOffset);
      this.fData = arrayOfByte;
    }
    i = this.fInputStream.read();
    if (i == -1)
    {
      this.fEndOffset = this.fOffset;
      return -1;
    }
    byte[] arrayOfByte = this.fData;
    int j = this.fLength;
    this.fLength = (j + 1);
    arrayOfByte[j] = ((byte)i);
    this.fOffset += 1;
    return i & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = this.fLength - this.fOffset;
    if (j == 0)
    {
      if (this.fOffset == this.fEndOffset) {
        return -1;
      }
      return this.fInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    int i = j;
    if (paramInt2 < j)
    {
      if (paramInt2 <= 0) {
        return 0;
      }
      i = paramInt2;
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(this.fData, this.fOffset, paramArrayOfByte, paramInt1, i);
    }
    this.fOffset += i;
    return i;
  }
  
  public void reset()
  {
    this.fOffset = this.fMark;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    int i = this.fLength - this.fOffset;
    if (i == 0)
    {
      if (this.fOffset == this.fEndOffset) {
        return 0L;
      }
      return this.fInputStream.skip(paramLong);
    }
    if (paramLong <= i)
    {
      this.fOffset = ((int)(this.fOffset + paramLong));
      return paramLong;
    }
    this.fOffset += i;
    if (this.fOffset == this.fEndOffset) {
      return i;
    }
    long l = i;
    return this.fInputStream.skip(paramLong - l) + i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/XMLEntityManager$RewindableInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */