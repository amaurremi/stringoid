package com.amazonaws.javax.xml.stream.xerces.impl.io;

import com.amazonaws.javax.xml.stream.util.BufferAllocator;
import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UTFDataFormatException;
import java.util.Locale;

public class UTF8Reader
  extends Reader
{
  protected byte[] fBuffer;
  private MessageFormatter fFormatter = null;
  protected InputStream fInputStream;
  private Locale fLocale = null;
  protected int fOffset;
  private int fSurrogate = -1;
  
  public UTF8Reader(InputStream paramInputStream, int paramInt, MessageFormatter paramMessageFormatter, Locale paramLocale)
  {
    this.fInputStream = paramInputStream;
    this.fFormatter = paramMessageFormatter;
    this.fLocale = paramLocale;
    this.fBuffer = ThreadLocalBufferAllocator.getBufferAllocator().getByteBuffer(paramInt);
    if (this.fBuffer == null) {
      this.fBuffer = new byte[paramInt];
    }
  }
  
  private void expectedByte(int paramInt1, int paramInt2)
  {
    throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "ExpectedByte", new Object[] { Integer.toString(paramInt1), Integer.toString(paramInt2) }));
  }
  
  private void invalidByte(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "InvalidByte", new Object[] { Integer.toString(paramInt1), Integer.toString(paramInt2) }));
  }
  
  private void invalidSurrogate(int paramInt)
  {
    new StringBuffer().append("high surrogate bits in UTF-8 sequence must not exceed 0x10 but found 0x");
    throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "InvalidHighSurrogate", new Object[] { Integer.toHexString(paramInt) }));
  }
  
  public void close()
  {
    ThreadLocalBufferAllocator.getBufferAllocator().returnByteBuffer(this.fBuffer);
    this.fBuffer = null;
    this.fInputStream.close();
  }
  
  public void mark(int paramInt)
  {
    throw new IOException(this.fFormatter.formatMessage(this.fLocale, "OperationNotSupported", new Object[] { "mark()", "UTF-8" }));
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
  {
    int k = this.fSurrogate;
    if (this.fSurrogate == -1)
    {
      int j;
      if (this.fOffset == 0) {
        j = this.fInputStream.read();
      }
      for (int i = 0; j == -1; i = 1)
      {
        return -1;
        j = this.fBuffer[0] & 0xFF;
      }
      if (j < 128) {
        return (char)j;
      }
      if ((j & 0xE0) == 192)
      {
        if (i == this.fOffset) {}
        for (i = this.fInputStream.read();; i = this.fBuffer[i] & 0xFF)
        {
          if (i == -1) {
            expectedByte(2, 2);
          }
          if ((i & 0xC0) != 128) {
            invalidByte(2, 2, i);
          }
          return i & 0x3F | j << 6 & 0x7C0;
        }
      }
      int m;
      if ((j & 0xF0) == 224)
      {
        if (i == this.fOffset)
        {
          m = this.fInputStream.read();
          k = i;
          i = m;
          if (i == -1) {
            expectedByte(2, 3);
          }
          if ((i & 0xC0) != 128) {
            invalidByte(2, 3, i);
          }
          if (k != this.fOffset) {
            break label298;
          }
        }
        label298:
        for (k = this.fInputStream.read();; k = this.fBuffer[k] & 0xFF)
        {
          if (k == -1) {
            expectedByte(3, 3);
          }
          if ((k & 0xC0) != 128) {
            invalidByte(3, 3, k);
          }
          return k & 0x3F | j << 12 & 0xF000 | i << 6 & 0xFC0;
          m = this.fBuffer[i] & 0xFF;
          k = i + 1;
          i = m;
          break;
        }
      }
      if ((j & 0xF8) == 240)
      {
        int n;
        if (i == this.fOffset)
        {
          k = this.fInputStream.read();
          if (k == -1) {
            expectedByte(2, 4);
          }
          if ((k & 0xC0) != 128) {
            invalidByte(2, 3, k);
          }
          if (i != this.fOffset) {
            break label560;
          }
          n = this.fInputStream.read();
          m = i;
          i = n;
          label391:
          if (i == -1) {
            expectedByte(3, 4);
          }
          if ((i & 0xC0) != 128) {
            invalidByte(3, 3, i);
          }
          if (m != this.fOffset) {
            break label583;
          }
        }
        label560:
        label583:
        for (m = this.fInputStream.read();; m = this.fBuffer[m] & 0xFF)
        {
          if (m == -1) {
            expectedByte(4, 4);
          }
          if ((m & 0xC0) != 128) {
            invalidByte(4, 4, m);
          }
          j = j << 2 & 0x1C | k >> 4 & 0x3;
          if (j > 16) {
            invalidSurrogate(j);
          }
          this.fSurrogate = (0xDC00 | i << 6 & 0x3C0 | m & 0x3F);
          return j - 1 << 6 & 0x3C0 | 0xD800 | k << 2 & 0x3C | i >> 4 & 0x3;
          k = this.fBuffer[i] & 0xFF;
          i += 1;
          break;
          n = this.fBuffer[i];
          m = i + 1;
          i = n & 0xFF;
          break label391;
        }
      }
      invalidByte(1, 1, j);
      return k;
    }
    this.fSurrogate = -1;
    return k;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.fSurrogate != -1)
    {
      paramArrayOfChar[(paramInt1 + 1)] = ((char)this.fSurrogate);
      this.fSurrogate = -1;
      paramInt2 -= 1;
    }
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      int j;
      int m;
      if (this.fOffset == 0)
      {
        j = paramInt2;
        if (paramInt2 > this.fBuffer.length) {
          j = this.fBuffer.length;
        }
        paramInt2 = this.fInputStream.read(this.fBuffer, 0, j);
        if (paramInt2 == -1) {
          m = -1;
        }
      }
      int k;
      label169:
      do
      {
        return m;
        j = paramInt2 + (i - paramInt1);
        for (;;)
        {
          m = 1;
          paramInt2 = i;
          k = 0;
          for (;;)
          {
            i = m;
            if (k >= j) {
              break label169;
            }
            i = this.fBuffer[k] & 0xFF;
            if (i >= 128) {
              break;
            }
            paramArrayOfChar[paramInt2] = ((char)i);
            k += 1;
            paramInt2 += 1;
          }
          j = this.fOffset;
          this.fOffset = 0;
        }
        i = 0;
        m = j;
      } while (i != 0);
      i = j;
      if (k < j)
      {
        int i3 = this.fBuffer[k] & 0xFF;
        if (i3 < 128)
        {
          m = paramInt2 + 1;
          paramArrayOfChar[paramInt2] = ((char)i3);
          paramInt2 = m;
        }
        for (;;)
        {
          k += 1;
          break;
          int n;
          if ((i3 & 0xE0) == 192)
          {
            m = k + 1;
            if (m < j)
            {
              k = this.fBuffer[m];
              n = k & 0xFF;
              k = i;
              i = n;
            }
            while ((i & 0xC0) != 128) {
              if (paramInt2 > paramInt1)
              {
                this.fBuffer[0] = ((byte)i3);
                this.fBuffer[1] = ((byte)i);
                this.fOffset = 2;
                return paramInt2 - paramInt1;
                n = this.fInputStream.read();
                if (n == -1)
                {
                  if (paramInt2 > paramInt1)
                  {
                    this.fBuffer[0] = ((byte)i3);
                    this.fOffset = 1;
                    return paramInt2 - paramInt1;
                  }
                  expectedByte(2, 2);
                }
                k = i + 1;
                i = n;
              }
              else
              {
                invalidByte(2, 2, i);
              }
            }
            n = paramInt2 + 1;
            paramArrayOfChar[paramInt2] = ((char)(i & 0x3F | i3 << 6 & 0x7C0));
            i = k - 1;
            k = m;
            paramInt2 = n;
          }
          else
          {
            int i1;
            if ((i3 & 0xF0) == 224)
            {
              m = k + 1;
              if (m < j) {
                k = this.fBuffer[m] & 0xFF;
              }
              while ((k & 0xC0) != 128) {
                if (paramInt2 > paramInt1)
                {
                  this.fBuffer[0] = ((byte)i3);
                  this.fBuffer[1] = ((byte)k);
                  this.fOffset = 2;
                  return paramInt2 - paramInt1;
                  k = this.fInputStream.read();
                  if (k == -1)
                  {
                    if (paramInt2 > paramInt1)
                    {
                      this.fBuffer[0] = ((byte)i3);
                      this.fOffset = 1;
                      return paramInt2 - paramInt1;
                    }
                    expectedByte(2, 3);
                  }
                  i += 1;
                }
                else
                {
                  invalidByte(2, 3, k);
                }
              }
              n = m + 1;
              if (n < j)
              {
                i1 = this.fBuffer[n] & 0xFF;
                m = i;
                i = i1;
              }
              while ((i & 0xC0) != 128) {
                if (paramInt2 > paramInt1)
                {
                  this.fBuffer[0] = ((byte)i3);
                  this.fBuffer[1] = ((byte)k);
                  this.fBuffer[2] = ((byte)i);
                  this.fOffset = 3;
                  return paramInt2 - paramInt1;
                  m = this.fInputStream.read();
                  if (m == -1)
                  {
                    if (paramInt2 > paramInt1)
                    {
                      this.fBuffer[0] = ((byte)i3);
                      this.fBuffer[1] = ((byte)k);
                      this.fOffset = 2;
                      return paramInt2 - paramInt1;
                    }
                    expectedByte(3, 3);
                  }
                  i1 = i + 1;
                  i = m;
                  m = i1;
                }
                else
                {
                  invalidByte(3, 3, i);
                }
              }
              i1 = paramInt2 + 1;
              paramArrayOfChar[paramInt2] = ((char)(i & 0x3F | i3 << 12 & 0xF000 | k << 6 & 0xFC0));
              i = m - 2;
              k = n;
              paramInt2 = i1;
            }
            else if ((i3 & 0xF8) == 240)
            {
              m = k + 1;
              if (m < j) {
                k = this.fBuffer[m] & 0xFF;
              }
              while ((k & 0xC0) != 128) {
                if (paramInt2 > paramInt1)
                {
                  this.fBuffer[0] = ((byte)i3);
                  this.fBuffer[1] = ((byte)k);
                  this.fOffset = 2;
                  return paramInt2 - paramInt1;
                  k = this.fInputStream.read();
                  if (k == -1)
                  {
                    if (paramInt2 > paramInt1)
                    {
                      this.fBuffer[0] = ((byte)i3);
                      this.fOffset = 1;
                      return paramInt2 - paramInt1;
                    }
                    expectedByte(2, 4);
                  }
                  i += 1;
                }
                else
                {
                  invalidByte(2, 4, k);
                }
              }
              n = m + 1;
              if (n < j) {
                m = this.fBuffer[n] & 0xFF;
              }
              while ((m & 0xC0) != 128) {
                if (paramInt2 > paramInt1)
                {
                  this.fBuffer[0] = ((byte)i3);
                  this.fBuffer[1] = ((byte)k);
                  this.fBuffer[2] = ((byte)m);
                  this.fOffset = 3;
                  return paramInt2 - paramInt1;
                  m = this.fInputStream.read();
                  if (m == -1)
                  {
                    if (paramInt2 > paramInt1)
                    {
                      this.fBuffer[0] = ((byte)i3);
                      this.fBuffer[1] = ((byte)k);
                      this.fOffset = 2;
                      return paramInt2 - paramInt1;
                    }
                    expectedByte(3, 4);
                  }
                  i += 1;
                }
                else
                {
                  invalidByte(3, 4, m);
                }
              }
              i1 = n + 1;
              if (i1 < j)
              {
                i2 = this.fBuffer[i1] & 0xFF;
                n = i;
                i = i2;
              }
              while ((i & 0xC0) != 128) {
                if (paramInt2 > paramInt1)
                {
                  this.fBuffer[0] = ((byte)i3);
                  this.fBuffer[1] = ((byte)k);
                  this.fBuffer[2] = ((byte)m);
                  this.fBuffer[3] = ((byte)i);
                  this.fOffset = 4;
                  return paramInt2 - paramInt1;
                  n = this.fInputStream.read();
                  if (n == -1)
                  {
                    if (paramInt2 > paramInt1)
                    {
                      this.fBuffer[0] = ((byte)i3);
                      this.fBuffer[1] = ((byte)k);
                      this.fBuffer[2] = ((byte)m);
                      this.fOffset = 3;
                      return paramInt2 - paramInt1;
                    }
                    expectedByte(4, 4);
                  }
                  i2 = i + 1;
                  i = n;
                  n = i2;
                }
                else
                {
                  invalidByte(4, 4, m);
                }
              }
              int i2 = i3 << 2 & 0x1C | k >> 4 & 0x3;
              if (i2 > 16) {
                invalidSurrogate(i2);
              }
              m &= 0x3F;
              i3 = paramInt2 + 1;
              paramArrayOfChar[paramInt2] = ((char)(i2 - 1 << 6 & 0x3C0 | 0xD800 | (k & 0xF) << 2 | m >> 4));
              paramInt2 = i3 + 1;
              paramArrayOfChar[i3] = ((char)(i & 0x3F | m << 6 & 0x3C0 | 0xDC00));
              i = n - 2;
              k = i1;
            }
            else
            {
              if (paramInt2 > paramInt1)
              {
                this.fBuffer[0] = ((byte)i3);
                this.fOffset = 1;
                return paramInt2 - paramInt1;
              }
              invalidByte(1, 1, i3);
            }
          }
        }
      }
      return i;
    }
  }
  
  public boolean ready()
  {
    return false;
  }
  
  public void reset()
  {
    this.fOffset = 0;
    this.fSurrogate = -1;
  }
  
  public long skip(long paramLong)
  {
    char[] arrayOfChar = new char[this.fBuffer.length];
    long l1 = paramLong;
    if (arrayOfChar.length < l1) {}
    for (int i = arrayOfChar.length;; i = (int)l1)
    {
      i = read(arrayOfChar, 0, i);
      long l2 = l1;
      if (i > 0)
      {
        l2 = l1 - i;
        l1 = l2;
        if (l2 > 0L) {
          break;
        }
      }
      return paramLong - l2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/impl/io/UTF8Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */