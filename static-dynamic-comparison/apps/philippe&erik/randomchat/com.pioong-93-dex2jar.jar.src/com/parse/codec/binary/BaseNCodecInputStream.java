package com.parse.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseNCodecInputStream
  extends FilterInputStream
{
  private final BaseNCodec baseNCodec;
  private final boolean doEncode;
  private final byte[] singleByte = new byte[1];
  
  protected BaseNCodecInputStream(InputStream paramInputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean)
  {
    super(paramInputStream);
    this.doEncode = paramBoolean;
    this.baseNCodec = paramBaseNCodec;
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    for (int i = read(this.singleByte, 0, 1);; i = read(this.singleByte, 0, 1)) {
      if (i != 0)
      {
        if (i <= 0) {
          break label60;
        }
        if (this.singleByte[0] >= 0) {
          break;
        }
        return this.singleByte[0] + 256;
      }
    }
    return this.singleByte[0];
    label60:
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if ((paramInt1 > paramArrayOfByte.length) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException();
    }
    int j;
    if (paramInt2 == 0) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      i = 0;
      j = i;
    } while (i != 0);
    label94:
    byte[] arrayOfByte;
    if (!this.baseNCodec.hasData())
    {
      if (!this.doEncode) {
        break label145;
      }
      i = 4096;
      arrayOfByte = new byte[i];
      i = this.in.read(arrayOfByte);
      if (!this.doEncode) {
        break label153;
      }
      this.baseNCodec.encode(arrayOfByte, 0, i);
    }
    for (;;)
    {
      i = this.baseNCodec.readResults(paramArrayOfByte, paramInt1, paramInt2);
      break;
      label145:
      i = 8192;
      break label94;
      label153:
      this.baseNCodec.decode(arrayOfByte, 0, i);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/codec/binary/BaseNCodecInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */