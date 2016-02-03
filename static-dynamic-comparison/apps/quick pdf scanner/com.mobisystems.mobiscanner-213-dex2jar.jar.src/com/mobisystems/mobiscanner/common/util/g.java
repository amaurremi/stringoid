package com.mobisystems.mobiscanner.common.util;

import org.json.JSONObject;

public class g
{
  String axq;
  String axr;
  String axs;
  String axt;
  long axu;
  int axv;
  String axw;
  String axx;
  String axy;
  String axz;
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    this.axq = paramString1;
    this.axy = paramString2;
    paramString1 = new JSONObject(this.axy);
    this.axr = paramString1.optString("orderId");
    this.axs = paramString1.optString("packageName");
    this.axt = paramString1.optString("productId");
    this.axu = paramString1.optLong("purchaseTime");
    this.axv = paramString1.optInt("purchaseState");
    this.axw = paramString1.optString("developerPayload");
    this.axx = paramString1.optString("token", paramString1.optString("purchaseToken"));
    this.axz = paramString3;
  }
  
  public String DW()
  {
    return this.axq;
  }
  
  public String DX()
  {
    return this.axr;
  }
  
  public String DY()
  {
    return this.axt;
  }
  
  public String DZ()
  {
    return this.axw;
  }
  
  public String toString()
  {
    return "PurchaseInfo(type:" + this.axq + "):" + this.axy;
  }
  
  public String wK()
  {
    return this.axx;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */