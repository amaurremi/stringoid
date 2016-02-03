package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class cz
{
  private static int fb = 1;
  private final int fc;
  private final long fd;
  private final String fe;
  private List<bu> ff;
  
  cz(long paramLong, String paramString)
  {
    int i = fb;
    fb = i + 1;
    this.fc = i;
    this.fd = paramLong;
    this.fe = paramString;
    this.ff = new ArrayList();
  }
  
  cz(DataInput paramDataInput)
    throws IOException
  {
    this.fc = paramDataInput.readInt();
    this.fd = paramDataInput.readLong();
    this.fe = paramDataInput.readUTF();
    this.ff = new ArrayList();
    int j = paramDataInput.readShort();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      this.ff.add(new bu(paramDataInput));
    }
  }
  
  final void a(bu parambu)
  {
    this.ff.add(parambu);
  }
  
  final void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeInt(this.fc);
    paramDataOutput.writeLong(this.fd);
    paramDataOutput.writeUTF(this.fe);
    paramDataOutput.writeShort(this.ff.size());
    Iterator localIterator = this.ff.iterator();
    while (localIterator.hasNext()) {
      ((bu)localIterator.next()).a(paramDataOutput);
    }
  }
  
  final String at()
  {
    return this.fe;
  }
  
  final long au()
  {
    return this.fd;
  }
  
  final List<bu> av()
  {
    return this.ff;
  }
  
  final int getIndex()
  {
    return this.fc;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */