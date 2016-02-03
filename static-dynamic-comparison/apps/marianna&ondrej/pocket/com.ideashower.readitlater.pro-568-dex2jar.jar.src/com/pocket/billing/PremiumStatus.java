package com.pocket.billing;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class PremiumStatus
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public PremiumStatus a(Parcel paramAnonymousParcel)
    {
      return new PremiumStatus(paramAnonymousParcel);
    }
    
    public PremiumStatus[] a(int paramAnonymousInt)
    {
      return new PremiumStatus[paramAnonymousInt];
    }
  };
  private final String a;
  private final int b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final ArrayList h;
  private final boolean i;
  
  public PremiumStatus(Parcel paramParcel)
  {
    this(l.a(paramParcel.readString()));
  }
  
  public PremiumStatus(ObjectNode paramObjectNode)
  {
    this.g = paramObjectNode.toString();
    Object localObject = (ObjectNode)paramObjectNode.get("subscription_info");
    this.a = ((ObjectNode)localObject).get("subscription_type").asText();
    this.b = ((ObjectNode)localObject).get("subscription_type_id").asInt();
    this.c = ((ObjectNode)localObject).get("source").asText();
    this.d = l.a((JsonNode)localObject, "source_display", null);
    this.e = a((ObjectNode)localObject, "purchase_date");
    this.f = a((ObjectNode)localObject, "renew_date");
    if (((ObjectNode)localObject).get("is_active").asInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.i = bool;
      localObject = l.b(paramObjectNode, "features");
      paramObjectNode = new ArrayList();
      localObject = ((ArrayNode)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
        h localh = new h(this);
        localh.a = localJsonNode.get("name").asText();
        localh.b = localJsonNode.get("status").asInt();
        localh.c = localJsonNode.get("status_text").asText();
        localh.d = localJsonNode.get("faq_link").asText();
        paramObjectNode.add(localh);
      }
    }
    this.h = paramObjectNode;
  }
  
  private static String a(ObjectNode paramObjectNode, String paramString)
  {
    paramObjectNode = paramObjectNode.get(paramString).asText();
    try
    {
      paramObjectNode = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramObjectNode);
      return DateFormat.getDateInstance().format(paramObjectNode);
    }
    catch (ParseException paramObjectNode)
    {
      e.a(paramObjectNode, true);
    }
    return "?";
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public ArrayList c()
  {
    return this.h;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return k.b("googleplay", this.c);
  }
  
  public boolean f()
  {
    return k.b("web", this.c);
  }
  
  public String g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.g);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/PremiumStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */