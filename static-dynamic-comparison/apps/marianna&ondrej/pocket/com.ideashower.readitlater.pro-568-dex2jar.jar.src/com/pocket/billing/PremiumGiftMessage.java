package com.pocket.billing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

public class PremiumGiftMessage
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public PremiumGiftMessage a(Parcel paramAnonymousParcel)
    {
      return new PremiumGiftMessage(paramAnonymousParcel);
    }
    
    public PremiumGiftMessage[] a(int paramAnonymousInt)
    {
      return new PremiumGiftMessage[paramAnonymousInt];
    }
  };
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  
  public PremiumGiftMessage(Parcel paramParcel)
  {
    this(paramParcel.readString());
  }
  
  public PremiumGiftMessage(String paramString)
  {
    this(l.a(paramString));
  }
  
  public PremiumGiftMessage(JsonNode paramJsonNode)
  {
    this.a = l.a(paramJsonNode, "title", null);
    this.b = l.a(paramJsonNode, "message", null);
    this.c = l.a(paramJsonNode, "button", null);
    this.d = l.a(paramJsonNode, "disclaimer", null);
    this.e = paramJsonNode.toString();
  }
  
  public PremiumGiftMessage(JsonParser paramJsonParser)
  {
    this(l.a().readTree(paramJsonParser));
  }
  
  public static void a(PremiumGiftMessage paramPremiumGiftMessage)
  {
    if (paramPremiumGiftMessage != null) {}
    for (paramPremiumGiftMessage = paramPremiumGiftMessage.h().toString();; paramPremiumGiftMessage = null)
    {
      i.a(a.t, paramPremiumGiftMessage);
      return;
    }
  }
  
  public static boolean a()
  {
    return i.a(a.t) != null;
  }
  
  public static PremiumGiftMessage b()
  {
    String str = i.a(a.t);
    if (str != null) {
      return new PremiumGiftMessage(str);
    }
    return null;
  }
  
  public static void c()
  {
    a(null);
  }
  
  public String d()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.d;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/PremiumGiftMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */