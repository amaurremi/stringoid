package com.google.api.client.util;

import java.io.OutputStream;

final class e
  extends OutputStream
{
  long acZ;
  
  public void write(int paramInt)
  {
    this.acZ += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.acZ += paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */