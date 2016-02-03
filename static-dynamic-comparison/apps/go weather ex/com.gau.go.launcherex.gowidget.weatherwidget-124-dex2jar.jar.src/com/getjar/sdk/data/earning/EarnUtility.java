package com.getjar.sdk.data.earning;

import com.getjar.sdk.comm.Result;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EarnUtility
{
  public static EarnInfo getEarnInfo(Result paramResult)
  {
    Long localLong = null;
    JSONArray localJSONArray = null;
    JSONObject localJSONObject = null;
    Object localObject18 = null;
    String str = null;
    Object localObject19 = null;
    localObject1 = null;
    Object localObject20 = null;
    Object localObject21 = null;
    localObject2 = null;
    Object localObject22 = null;
    Object localObject23 = null;
    localObject3 = null;
    Object localObject24 = null;
    Object localObject25 = null;
    localObject4 = null;
    Object localObject26 = null;
    Object localObject27 = null;
    localObject5 = null;
    long l = getResponseAmount(paramResult, -1L);
    if (l >= 0L) {
      localLong = Long.valueOf(l);
    }
    localObject6 = localJSONObject;
    localObject7 = localObject19;
    localObject8 = localObject21;
    localObject9 = localObject23;
    localObject10 = localObject25;
    localObject11 = localObject27;
    for (;;)
    {
      try
      {
        paramResult = paramResult.getResponseJson();
        localObject17 = localJSONArray;
        localObject16 = str;
        localObject15 = localObject20;
        localObject14 = localObject22;
        localObject13 = localObject24;
        localObject12 = localObject26;
        if (paramResult == null) {
          continue;
        }
        localObject17 = localJSONArray;
        localObject16 = str;
        localObject15 = localObject20;
        localObject14 = localObject22;
        localObject13 = localObject24;
        localObject12 = localObject26;
        localObject6 = localJSONObject;
        localObject7 = localObject19;
        localObject8 = localObject21;
        localObject9 = localObject23;
        localObject10 = localObject25;
        localObject11 = localObject27;
        if (paramResult.length() <= 0) {
          continue;
        }
        localObject17 = localJSONArray;
        localObject16 = str;
        localObject15 = localObject20;
        localObject14 = localObject22;
        localObject13 = localObject24;
        localObject12 = localObject26;
        localObject6 = localJSONObject;
        localObject7 = localObject19;
        localObject8 = localObject21;
        localObject9 = localObject23;
        localObject10 = localObject25;
        localObject11 = localObject27;
        if (!paramResult.has("return")) {
          continue;
        }
        localObject17 = localJSONArray;
        localObject16 = str;
        localObject15 = localObject20;
        localObject14 = localObject22;
        localObject13 = localObject24;
        localObject12 = localObject26;
        localObject6 = localJSONObject;
        localObject7 = localObject19;
        localObject8 = localObject21;
        localObject9 = localObject23;
        localObject10 = localObject25;
        localObject11 = localObject27;
        if (!paramResult.getJSONObject("return").has("lines")) {
          continue;
        }
        localObject6 = localJSONObject;
        localObject7 = localObject19;
        localObject8 = localObject21;
        localObject9 = localObject23;
        localObject10 = localObject25;
        localObject11 = localObject27;
        localJSONArray = paramResult.getJSONObject("return").getJSONArray("lines");
        i = 0;
        paramResult = (Result)localObject18;
        localObject17 = paramResult;
        localObject16 = localObject1;
        localObject15 = localObject2;
        localObject14 = localObject3;
        localObject13 = localObject4;
        localObject12 = localObject5;
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if (i >= localJSONArray.length()) {
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject18 = localJSONArray.getJSONObject(i);
        localObject12 = paramResult;
        localObject13 = localObject1;
        localObject14 = localObject2;
        localObject15 = localObject3;
        localObject16 = localObject4;
        localObject17 = localObject5;
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if (!((JSONObject)localObject18).has("item_metadata")) {
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject18 = ((JSONObject)localObject18).getJSONArray("item_metadata");
        j = 0;
      }
      catch (JSONException paramResult)
      {
        int i;
        int j;
        boolean bool;
        Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramResult, "getResponseAmount() failed", new Object[0]);
        Object localObject17 = localObject6;
        Object localObject16 = localObject7;
        Object localObject15 = localObject8;
        Object localObject14 = localObject9;
        Object localObject13 = localObject10;
        Object localObject12 = localObject11;
        continue;
        j += 1;
        paramResult = (Result)localObject12;
        localObject1 = localObject13;
        localObject2 = localObject14;
        localObject3 = localObject15;
        localObject4 = localObject16;
        localObject5 = localObject17;
        continue;
      }
      localObject6 = paramResult;
      localObject7 = localObject1;
      localObject8 = localObject2;
      localObject9 = localObject3;
      localObject10 = localObject4;
      localObject11 = localObject5;
      if (j < ((JSONArray)localObject18).length())
      {
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localJSONObject = ((JSONArray)localObject18).getJSONObject(j);
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject12 = paramResult;
        localObject13 = localObject1;
        localObject14 = localObject2;
        localObject15 = localObject3;
        localObject16 = localObject4;
        localObject17 = localObject5;
        if (!localJSONObject.has("key")) {
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject12 = paramResult;
        localObject13 = localObject1;
        localObject14 = localObject2;
        localObject15 = localObject3;
        localObject16 = localObject4;
        localObject17 = localObject5;
        if (!localJSONObject.has("value")) {
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        str = localJSONObject.getString("key");
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if ("currency_amount".equals(str))
        {
          localObject6 = paramResult;
          localObject7 = localObject1;
          localObject8 = localObject2;
          localObject9 = localObject3;
          localObject10 = localObject4;
          localObject11 = localObject5;
          localObject12 = localJSONObject.getString("value");
          localObject13 = localObject1;
          localObject14 = localObject2;
          localObject15 = localObject3;
          localObject16 = localObject4;
          localObject17 = localObject5;
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if ("currency_display_amount".equals(str))
        {
          localObject6 = paramResult;
          localObject7 = localObject1;
          localObject8 = localObject2;
          localObject9 = localObject3;
          localObject10 = localObject4;
          localObject11 = localObject5;
          localObject13 = localJSONObject.getString("value");
          localObject12 = paramResult;
          localObject14 = localObject2;
          localObject15 = localObject3;
          localObject16 = localObject4;
          localObject17 = localObject5;
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if ("currency_key".equals(str))
        {
          localObject6 = paramResult;
          localObject7 = localObject1;
          localObject8 = localObject2;
          localObject9 = localObject3;
          localObject10 = localObject4;
          localObject11 = localObject5;
          localObject14 = localJSONObject.getString("value");
          localObject12 = paramResult;
          localObject13 = localObject1;
          localObject15 = localObject3;
          localObject16 = localObject4;
          localObject17 = localObject5;
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if ("currency_name".equals(str))
        {
          localObject6 = paramResult;
          localObject7 = localObject1;
          localObject8 = localObject2;
          localObject9 = localObject3;
          localObject10 = localObject4;
          localObject11 = localObject5;
          localObject15 = localJSONObject.getString("value");
          localObject12 = paramResult;
          localObject13 = localObject1;
          localObject14 = localObject2;
          localObject16 = localObject4;
          localObject17 = localObject5;
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        if ("currency_type".equals(str))
        {
          localObject6 = paramResult;
          localObject7 = localObject1;
          localObject8 = localObject2;
          localObject9 = localObject3;
          localObject10 = localObject4;
          localObject11 = localObject5;
          localObject16 = localJSONObject.getString("value");
          localObject12 = paramResult;
          localObject13 = localObject1;
          localObject14 = localObject2;
          localObject15 = localObject3;
          localObject17 = localObject5;
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject12 = paramResult;
        localObject13 = localObject1;
        localObject14 = localObject2;
        localObject15 = localObject3;
        localObject16 = localObject4;
        localObject17 = localObject5;
        if (!"voucher_token".equals(str)) {
          continue;
        }
        localObject6 = paramResult;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        localObject10 = localObject4;
        localObject11 = localObject5;
        localObject17 = localJSONObject.getString("value");
        localObject12 = paramResult;
        localObject13 = localObject1;
        localObject14 = localObject2;
        localObject15 = localObject3;
        localObject16 = localObject4;
        continue;
      }
      localObject6 = paramResult;
      localObject7 = localObject1;
      localObject8 = localObject2;
      localObject9 = localObject3;
      localObject10 = localObject4;
      localObject11 = localObject5;
      bool = StringUtility.isNullOrEmpty((String)localObject2);
      localObject12 = paramResult;
      localObject13 = localObject1;
      localObject14 = localObject2;
      localObject15 = localObject3;
      localObject16 = localObject4;
      localObject17 = localObject5;
      if (!bool)
      {
        localObject12 = localObject5;
        localObject13 = localObject4;
        localObject14 = localObject3;
        localObject15 = localObject2;
        localObject16 = localObject1;
        localObject17 = paramResult;
        return new EarnInfo(localLong, (String)localObject17, (String)localObject16, (String)localObject15, (String)localObject14, (String)localObject13, (String)localObject12, null);
      }
      i += 1;
      paramResult = (Result)localObject12;
      localObject1 = localObject13;
      localObject2 = localObject14;
      localObject3 = localObject15;
      localObject4 = localObject16;
      localObject5 = localObject17;
    }
  }
  
  public static long getResponseAmount(Result paramResult, long paramLong)
  {
    paramResult = paramResult.getResponseJson();
    long l = paramLong;
    if (paramResult != null)
    {
      l = paramLong;
      if (paramResult.length() <= 0) {}
    }
    try
    {
      int i = paramResult.getJSONObject("return").getInt("amount");
      l = i;
      return l;
    }
    catch (JSONException paramResult)
    {
      Logger.e(Area.EARN.value() | Area.TRANSACTION.value(), paramResult, "getResponseAmount() failed", new Object[0]);
    }
    return paramLong;
  }
  
  public static class EarnInfo
  {
    private final Long _amount;
    private final String _currencyAmount;
    private final String _currencyDisplayAmount;
    private final String _currencyKey;
    private final String _currencyName;
    private final String _currencyType;
    private final String _voucherToken;
    
    private EarnInfo(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this._amount = paramLong;
      this._currencyAmount = paramString1;
      this._currencyDisplayAmount = paramString2;
      this._currencyKey = paramString3;
      this._currencyName = paramString4;
      this._currencyType = paramString5;
      this._voucherToken = paramString6;
    }
    
    public Long getAmount()
    {
      return this._amount;
    }
    
    public String getCurrencyAmount()
    {
      return this._currencyAmount;
    }
    
    public String getCurrencyDisplayAmount()
    {
      return this._currencyDisplayAmount;
    }
    
    public String getCurrencyKey()
    {
      return this._currencyKey;
    }
    
    public String getCurrencyName()
    {
      return this._currencyName;
    }
    
    public String getCurrencyType()
    {
      return this._currencyType;
    }
    
    public String getVoucherToken()
    {
      return this._voucherToken;
    }
    
    public String toString()
    {
      return String.format(Locale.US, "amount:%1$d currencyAmount:%2$s currencyDisplayAmount:%3$s currencyKey:%4$s currencyName:%5$s currencyType:%6$s voucherToken:%7$s", new Object[] { this._amount, this._currencyAmount, this._currencyDisplayAmount, this._currencyKey, this._currencyName, this._currencyType, this._voucherToken });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/earning/EarnUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */