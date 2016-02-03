package com.flurry.android;

import java.io.DataInput;

final class e
  extends aj
{
  String a;
  byte b;
  byte c;
  c d;
  
  e() {}
  
  e(DataInput paramDataInput)
  {
    this.a = paramDataInput.readUTF();
    this.b = paramDataInput.readByte();
    this.c = paramDataInput.readByte();
  }
  
  public final String toString()
  {
    return "{name: " + this.a + ", blockId: " + this.b + ", themeId: " + this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */