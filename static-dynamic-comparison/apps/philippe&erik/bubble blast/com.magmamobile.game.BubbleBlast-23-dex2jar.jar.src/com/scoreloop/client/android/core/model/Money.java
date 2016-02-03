package com.scoreloop.client.android.core.model;

import com.scoreloop.client.android.core.PublishedFor__1_0_0;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class Money
  implements Cloneable, Comparable<Money>
{
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private BigDecimal a;
  private String b;
  
  public Money(String paramString, BigDecimal paramBigDecimal)
  {
    this.b = paramString;
    this.a = paramBigDecimal;
  }
  
  @PublishedFor__1_0_0
  public Money(BigDecimal paramBigDecimal)
  {
    this.a = paramBigDecimal;
    this.b = a();
  }
  
  public Money(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject);
  }
  
  public static String a()
  {
    if (c != null) {
      return c;
    }
    return "SLD";
  }
  
  static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void b(String paramString)
  {
    d = paramString;
  }
  
  public static void c(String paramString)
  {
    e = paramString;
  }
  
  public static void d(String paramString)
  {
    f = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.b = paramJSONObject.getString("currency");
    try
    {
      this.a = new BigDecimal(paramJSONObject.getString("amount"));
      this.a.divide(new BigDecimal(100));
      return;
    }
    catch (NumberFormatException paramJSONObject)
    {
      throw new JSONException("Invalid format of money amount");
    }
  }
  
  public Money b()
  {
    return new Money(this.b, this.a);
  }
  
  public JSONObject c()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("amount", this.a);
    localJSONObject.put("currency", this.b);
    return localJSONObject;
  }
  
  @PublishedFor__1_0_0
  public int compareTo(Money paramMoney)
  {
    if (paramMoney == null) {
      throw new IllegalArgumentException();
    }
    if (!d().equalsIgnoreCase(paramMoney.d())) {
      throw new IllegalArgumentException("tried to compare Money objects of different currencies: " + d() + ", " + paramMoney.d());
    }
    return getAmount().compareTo(paramMoney.getAmount());
  }
  
  public String d()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (!(paramObject instanceof Money)) {
        return super.equals(paramObject);
      }
      paramObject = (Money)paramObject;
    } while ((!d().equalsIgnoreCase(((Money)paramObject).d())) || (!getAmount().equals(((Money)paramObject).getAmount())));
    return true;
  }
  
  @PublishedFor__1_0_0
  public BigDecimal getAmount()
  {
    return this.a;
  }
  
  @PublishedFor__1_0_0
  public boolean hasAmount()
  {
    boolean bool = false;
    if (getAmount().compareTo(new BigDecimal(0)) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return d().hashCode() ^ getAmount().hashCode();
  }
  
  public String toString()
  {
    if (this.b.equalsIgnoreCase("SLD")) {
      return this.a.toString() + " " + "Coins";
    }
    return this.a.toString() + " " + this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Money.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */