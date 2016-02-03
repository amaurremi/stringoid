package com.flurry.android;

import java.io.DataInput;

public final class AdImage
  extends aj
{
  long a;
  int b;
  int c;
  String d;
  byte[] e;
  
  AdImage() {}
  
  AdImage(DataInput paramDataInput)
  {
    a(paramDataInput);
  }
  
  final void a(DataInput paramDataInput)
  {
    this.a = paramDataInput.readLong();
    this.b = paramDataInput.readInt();
    this.c = paramDataInput.readInt();
    this.d = paramDataInput.readUTF();
    this.e = new byte[paramDataInput.readInt()];
    paramDataInput.readFully(this.e);
  }
  
  public final int getHeight()
  {
    return this.c;
  }
  
  public final long getId()
  {
    return this.a;
  }
  
  public final byte[] getImageData()
  {
    return this.e;
  }
  
  public final String getMimeType()
  {
    return this.d;
  }
  
  public final int getWidth()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/AdImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */