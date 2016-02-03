package com.jirbo.adcolony;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class ADCStreamReader
  extends InputStream
{
  byte[] buffer = new byte['Ѐ'];
  int buffer_count;
  int buffer_position;
  int dx;
  InputStream input;
  int position;
  int size;
  int x;
  
  ADCStreamReader(String paramString)
    throws IOException
  {
    if (ADC.log_level != 0)
    {
      this.dx = 23;
      this.x = 23;
    }
    this.size = ((int)new File(paramString).length());
    this.input = new FileInputStream(paramString);
  }
  
  public int available()
    throws IOException
  {
    return this.buffer_count - this.buffer_position + this.input.available();
  }
  
  public void close()
    throws IOException
  {
    this.input.close();
  }
  
  void fillBuffer()
    throws IOException
  {
    for (this.buffer_count = 0; this.buffer_count == 0; this.buffer_count = this.input.read(this.buffer, 0, 1024)) {}
    int i = 0;
    while (i < this.buffer_count)
    {
      this.buffer[i] = ((byte)(this.buffer[i] ^ this.x));
      this.x += this.dx;
      i += 1;
    }
    this.buffer_position = 0;
  }
  
  public void mark(int paramInt) {}
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.position == this.size) {
      return -1;
    }
    if (this.buffer_position >= this.buffer_count) {
      fillBuffer();
    }
    this.position += 1;
    byte[] arrayOfByte = this.buffer;
    int i = this.buffer_position;
    this.buffer_position = (i + 1);
    return arrayOfByte[i];
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.position == this.size)
    {
      j = -1;
      return j;
    }
    int j = this.size - this.position;
    int i = paramInt2;
    if (paramInt2 > j) {
      i = j;
    }
    j = 0;
    paramInt2 = i;
    i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      j = paramInt1;
      if (paramInt2 <= 0) {
        break;
      }
      if (this.buffer_position == this.buffer_count) {
        fillBuffer();
      }
      if (paramInt2 < this.buffer_count) {}
      for (j = paramInt2;; j = this.buffer_count)
      {
        int k = 0;
        while (k < j)
        {
          byte[] arrayOfByte = this.buffer;
          int m = this.buffer_position;
          this.buffer_position = (m + 1);
          paramArrayOfByte[i] = arrayOfByte[m];
          k += 1;
          i += 1;
        }
      }
      paramInt2 -= j;
      paramInt1 += j;
      this.position += j;
    }
  }
  
  public void reset()
    throws IOException
  {
    throw new IOException("ADCStreamReader does not support reset().");
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    throw new IOException("ADCStreamReader does not support skip().");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCStreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */