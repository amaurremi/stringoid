package com.mobisystems.a;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class a
  extends FilterOutputStream
{
  private int aoP;
  
  public a(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public int position()
  {
    return this.aoP;
  }
  
  public void write(int paramInt)
  {
    this.out.write(paramInt);
    this.aoP += 1;
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    this.out.write(paramArrayOfByte);
    this.aoP += paramArrayOfByte.length;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.aoP += paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */