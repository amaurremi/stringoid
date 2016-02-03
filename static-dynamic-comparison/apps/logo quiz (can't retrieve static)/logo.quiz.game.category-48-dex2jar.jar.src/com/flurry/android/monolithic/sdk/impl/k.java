package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
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

public final class k
{
  static final List<String> a = Arrays.asList(new String[] { "requested", "filled", "unfilled", "rendered", "clicked", "videoStart", "videoCompleted", "videoProgressed", "sentToUrl", "adClosed", "adWillClose", "renderFailed", "requestAdComponents", "urlVerified", "capExhausted", "capNotExhausted" });
  private static final String b = k.class.getSimpleName();
  private final String c;
  private final boolean d;
  private final long e;
  private final Map<String, String> f;
  
  public k(DataInput paramDataInput)
    throws IOException
  {
    this.c = paramDataInput.readUTF();
    this.d = paramDataInput.readBoolean();
    this.e = paramDataInput.readLong();
    this.f = new HashMap();
    int j = paramDataInput.readShort();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      this.f.put(paramDataInput.readUTF(), paramDataInput.readUTF());
    }
  }
  
  public k(String paramString, boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (!a.contains(paramString)) {
      ja.a(b, "AdEvent initialized with unrecognized type: " + paramString);
    }
    this.c = paramString;
    this.d = paramBoolean;
    this.e = paramLong;
    if (paramMap == null)
    {
      this.f = new HashMap();
      return;
    }
    this.f = paramMap;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(this.c);
    paramDataOutput.writeBoolean(this.d);
    paramDataOutput.writeLong(this.e);
    paramDataOutput.writeShort(this.f.size());
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramDataOutput.writeUTF((String)localEntry.getKey());
      paramDataOutput.writeUTF((String)localEntry.getValue());
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public long c()
  {
    return this.e;
  }
  
  public Map<String, String> d()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof k)) {
        return false;
      }
      paramObject = (k)paramObject;
    } while ((TextUtils.equals(this.c, ((k)paramObject).c)) && (this.d == ((k)paramObject).d) && (this.e == ((k)paramObject).e) && ((this.f == ((k)paramObject).f) || ((this.f != null) && (this.f.equals(((k)paramObject).f)))));
    return false;
  }
  
  public int hashCode()
  {
    int i = 17;
    if (this.c != null) {
      i = 0x11 | this.c.hashCode();
    }
    int j = i;
    if (this.d) {
      j = i | 0x1;
    }
    j = (int)(j | this.e);
    i = j;
    if (this.f != null) {
      i = j | this.f.hashCode();
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */