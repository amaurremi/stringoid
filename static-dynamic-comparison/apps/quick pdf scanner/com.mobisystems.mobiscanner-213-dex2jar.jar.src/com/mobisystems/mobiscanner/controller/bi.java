package com.mobisystems.mobiscanner.controller;

import android.text.TextUtils;
import java.util.ArrayList;

public class bi
{
  private long aAa = -1L;
  private ArrayList<Long> aGs = new ArrayList();
  private String aGt = null;
  
  public long HK()
  {
    return this.aAa;
  }
  
  public long[] HL()
  {
    int j = this.aGs.size();
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong[i] = ((Long)this.aGs.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public String HM()
  {
    return this.aGt;
  }
  
  public int HN()
  {
    return this.aGs.size();
  }
  
  public void ac(long paramLong)
  {
    this.aAa = paramLong;
  }
  
  public void ad(long paramLong)
  {
    this.aGs.add(Long.valueOf(paramLong));
  }
  
  public void dJ(String paramString)
  {
    if (TextUtils.isEmpty(this.aGt)) {
      this.aGt = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */