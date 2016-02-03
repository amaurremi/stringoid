package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bu
{
  private static List<String> dX = Arrays.asList(new String[] { "requested", "filled", "unfilled", "rendered", "clicked", "videoStart", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", "capExhausted", "capNotExhausted" });
  private final Map<String, String> bv;
  private final String dY;
  private final boolean dZ;
  private final long ea;
  
  bu(DataInput paramDataInput)
    throws IOException
  {
    this.dY = paramDataInput.readUTF();
    this.dZ = paramDataInput.readBoolean();
    this.ea = paramDataInput.readLong();
    this.bv = new HashMap();
    int j = paramDataInput.readShort();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      this.bv.put(paramDataInput.readUTF(), paramDataInput.readUTF());
    }
  }
  
  bu(String paramString, boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (!dX.contains(paramString)) {
      db.c("FlurryAgent", "AdEvent initialized with unrecognized type: " + paramString);
    }
    this.dY = paramString;
    this.dZ = paramBoolean;
    this.ea = paramLong;
    if (paramMap == null)
    {
      this.bv = new HashMap();
      return;
    }
    this.bv = paramMap;
  }
  
  final long M()
  {
    return this.ea;
  }
  
  final void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(this.dY);
    paramDataOutput.writeBoolean(this.dZ);
    paramDataOutput.writeLong(this.ea);
    paramDataOutput.writeShort(this.bv.size());
    Iterator localIterator = this.bv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramDataOutput.writeUTF((String)localEntry.getKey());
      paramDataOutput.writeUTF((String)localEntry.getValue());
    }
  }
  
  final boolean ai()
  {
    return this.dZ;
  }
  
  final Map<String, String> getParams()
  {
    return this.bv;
  }
  
  final String getType()
  {
    return this.dY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */