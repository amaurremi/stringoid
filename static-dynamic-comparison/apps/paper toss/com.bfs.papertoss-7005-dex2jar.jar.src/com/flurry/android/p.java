package com.flurry.android;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class p
{
  final String a;
  v b;
  long c;
  List d = new ArrayList();
  private byte e;
  
  p(p paramp, long paramLong)
  {
    this(paramp.a, paramp.e, paramLong);
    this.b = paramp.b;
    this.c = paramp.c;
  }
  
  p(String paramString, byte paramByte, long paramLong)
  {
    this.a = paramString;
    this.e = paramByte;
    this.d.add(new f((byte)1, paramLong));
  }
  
  final long a()
  {
    return ((f)this.d.get(0)).b;
  }
  
  final void a(f paramf)
  {
    this.d.add(paramf);
  }
  
  final void a(DataOutput paramDataOutput)
  {
    paramDataOutput.writeUTF(this.a);
    paramDataOutput.writeByte(this.e);
    if (this.b == null)
    {
      paramDataOutput.writeLong(0L);
      paramDataOutput.writeLong(0L);
      paramDataOutput.writeByte(0);
    }
    for (;;)
    {
      paramDataOutput.writeShort(this.d.size());
      Object localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        paramDataOutput.writeByte(localf.a);
        paramDataOutput.writeLong(localf.b);
      }
      paramDataOutput.writeLong(this.b.a);
      paramDataOutput.writeLong(this.b.e);
      localObject = this.b.g;
      paramDataOutput.writeByte(localObject.length);
      paramDataOutput.write((byte[])localObject);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{hook: " + this.a + ", ad: " + this.b.d + ", transitions: [");
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((f)localIterator.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */