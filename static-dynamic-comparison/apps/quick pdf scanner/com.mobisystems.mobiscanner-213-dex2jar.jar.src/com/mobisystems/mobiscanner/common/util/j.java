package com.mobisystems.mobiscanner.common.util;

import org.json.JSONObject;

public class j
{
  String axD;
  String axE;
  String axF;
  String axG;
  String axH;
  String axq;
  String axt;
  
  public j(String paramString1, String paramString2)
  {
    this.axq = paramString1;
    this.axH = paramString2;
    paramString1 = new JSONObject(this.axH);
    this.axt = paramString1.optString("productId");
    this.axD = paramString1.optString("type");
    this.axE = paramString1.optString("price");
    this.axF = paramString1.optString("title");
    this.axG = paramString1.optString("description");
  }
  
  public String DY()
  {
    return this.axt;
  }
  
  public String toString()
  {
    return "SkuDetails:" + this.axH;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */