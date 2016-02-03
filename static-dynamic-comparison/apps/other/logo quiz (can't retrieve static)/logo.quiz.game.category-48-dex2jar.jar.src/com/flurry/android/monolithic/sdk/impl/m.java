package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class m
{
  private static int a = 1;
  private final int b;
  private final long c;
  private final String d;
  private List<k> e;
  
  public m(long paramLong1, String paramString, long paramLong2)
  {
    int i = a;
    a = i + 1;
    this.b = i;
    this.c = paramLong1;
    this.d = paramString;
    this.e = new ArrayList();
  }
  
  public m(DataInput paramDataInput)
    throws IOException
  {
    this.b = paramDataInput.readInt();
    this.c = paramDataInput.readLong();
    String str2 = paramDataInput.readUTF();
    String str1 = str2;
    if (str2.equals("")) {
      str1 = null;
    }
    this.d = str1;
    this.e = new ArrayList();
    int j = paramDataInput.readShort();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      this.e.add(new k(paramDataInput));
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(k paramk)
  {
    this.e.add(paramk);
  }
  
  public void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeInt(this.b);
    paramDataOutput.writeLong(this.c);
    if (this.d == null) {}
    for (Object localObject = "";; localObject = this.d)
    {
      paramDataOutput.writeUTF((String)localObject);
      paramDataOutput.writeShort(this.e.size());
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((k)((Iterator)localObject).next()).a(paramDataOutput);
      }
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public List<k> d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof m)) {
        return false;
      }
      paramObject = (m)paramObject;
    } while ((this.b == ((m)paramObject).b) && (this.c == ((m)paramObject).c) && (TextUtils.equals(this.d, ((m)paramObject).d)) && ((this.e == ((m)paramObject).e) || ((this.e != null) && (this.e.equals(((m)paramObject).e)))));
    return false;
  }
  
  public int hashCode()
  {
    int j = (int)(0x11 | this.b | this.c);
    int i = j;
    if (this.d != null) {
      i = j | this.d.hashCode();
    }
    j = i;
    if (this.e != null) {
      j = i | this.e.hashCode();
    }
    return j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */