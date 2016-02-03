package com.flurry.android;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlurryFreqCapInfo
{
  private String ef;
  private long eg;
  private long eh;
  private int ei;
  private int ej;
  private int ek;
  private int el;
  
  FlurryFreqCapInfo() {}
  
  FlurryFreqCapInfo(DataInput paramDataInput)
    throws IOException
  {
    this.ef = paramDataInput.readUTF();
    this.eg = paramDataInput.readLong();
    this.eh = paramDataInput.readLong();
    this.ei = paramDataInput.readInt();
    this.ej = paramDataInput.readInt();
    this.ek = paramDataInput.readInt();
    this.el = paramDataInput.readInt();
  }
  
  FlurryFreqCapInfo(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.ef = paramString;
    this.eg = paramLong1;
    this.eh = paramLong2;
    this.ej = paramInt1;
    this.ek = paramInt2;
    this.el = paramInt3;
    this.ei = 0;
  }
  
  final void a(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeUTF(this.ef);
    paramDataOutput.writeLong(this.eg);
    paramDataOutput.writeLong(this.eh);
    paramDataOutput.writeInt(this.ei);
    paramDataOutput.writeInt(this.ej);
    paramDataOutput.writeInt(this.ek);
    paramDataOutput.writeInt(this.el);
  }
  
  public FlurryFreqCapInfo getCopy()
  {
    FlurryFreqCapInfo localFlurryFreqCapInfo = new FlurryFreqCapInfo(getIdHash(), getServeTime(), getExpirationTime(), getNewCap(), getPreviousCap(), getPreviousCapType());
    localFlurryFreqCapInfo.setViews(getViews());
    return localFlurryFreqCapInfo;
  }
  
  public long getExpirationTime()
  {
    return this.eh;
  }
  
  public String getIdHash()
  {
    return this.ef;
  }
  
  public int getNewCap()
  {
    return this.ej;
  }
  
  public int getPreviousCap()
  {
    return this.ek;
  }
  
  public int getPreviousCapType()
  {
    return this.el;
  }
  
  public long getServeTime()
  {
    return this.eg;
  }
  
  public int getViews()
  {
    return this.ei;
  }
  
  public void setIdHash(String paramString)
  {
    this.ef = paramString;
  }
  
  public void setViews(int paramInt)
  {
    this.ei = paramInt;
  }
  
  public void updateViews()
  {
    this.ei += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryFreqCapInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */