package com.flurry.android;

import java.io.DataInput;

final class v
  extends aj
{
  long a;
  long b;
  String c;
  String d;
  long e;
  Long f;
  byte[] g;
  AdImage h;
  
  v() {}
  
  v(DataInput paramDataInput)
  {
    b(paramDataInput);
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] >> 4 & 0xF;
      if (j < 10)
      {
        localStringBuilder.append((char)(j + 48));
        label41:
        j = paramArrayOfByte[i] & 0xF;
        if (j >= 10) {
          break label87;
        }
        localStringBuilder.append((char)(j + 48));
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((char)(j + 65 - 10));
        break label41;
        label87:
        localStringBuilder.append((char)(j + 65 - 10));
      }
    }
    return localStringBuilder.toString();
  }
  
  private void b(DataInput paramDataInput)
  {
    this.a = paramDataInput.readLong();
    this.b = paramDataInput.readLong();
    this.d = paramDataInput.readUTF();
    this.c = paramDataInput.readUTF();
    this.e = paramDataInput.readLong();
    this.f = Long.valueOf(paramDataInput.readLong());
    this.g = new byte[paramDataInput.readUnsignedByte()];
    paramDataInput.readFully(this.g);
  }
  
  final void a(DataInput paramDataInput)
  {
    b(paramDataInput);
  }
  
  public final String toString()
  {
    return "ad {id=" + this.a + ", name='" + this.d + "', cookie: '" + a(this.g) + "'}";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */