package com.ideashower.readitlater.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.a.as;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.a.t;
import com.ideashower.readitlater.activity.al;
import com.ideashower.readitlater.activity.an;
import com.ideashower.readitlater.h.b;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.util.e;
import com.pocket.stats.d;
import com.pocket.stats.m;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class UserMessage
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public UserMessage a(Parcel paramAnonymousParcel)
    {
      return new UserMessage(paramAnonymousParcel);
    }
    
    public UserMessage[] a(int paramAnonymousInt)
    {
      return new UserMessage[paramAnonymousInt];
    }
  };
  private final ObjectNode a;
  private long b;
  
  public UserMessage(Parcel paramParcel)
  {
    this(com.ideashower.readitlater.util.l.a(paramParcel.readString()));
  }
  
  private UserMessage(ObjectNode paramObjectNode)
  {
    this.a = paramObjectNode;
  }
  
  public static UserMessage a(String paramString)
  {
    return a(com.ideashower.readitlater.util.l.a(paramString));
  }
  
  public static UserMessage a(JsonParser paramJsonParser)
  {
    return a((ObjectNode)com.ideashower.readitlater.util.l.a().readTree(paramJsonParser));
  }
  
  public static UserMessage a(ObjectNode paramObjectNode)
  {
    return new UserMessage(paramObjectNode);
  }
  
  private String a(int paramInt)
  {
    JsonNode localJsonNode = b(paramInt);
    if (localJsonNode != null) {
      return localJsonNode.get("label").asText();
    }
    return null;
  }
  
  private void a(String paramString, JsonNode paramJsonNode, com.ideashower.readitlater.activity.a parama)
  {
    if ("close".equalsIgnoreCase(paramString)) {}
    do
    {
      return;
      if (("premium".equalsIgnoreCase(paramString)) || ("renew".equalsIgnoreCase(paramString)))
      {
        if (as.m())
        {
          an.a(parama, null, null);
          return;
        }
        al.a(parama, 2, d.a(this));
        return;
      }
    } while (!"browser".equalsIgnoreCase(paramString));
    g.a(parama, paramJsonNode.get("url").asText());
  }
  
  private JsonNode b(int paramInt)
  {
    ArrayNode localArrayNode = com.ideashower.readitlater.util.l.b(this.a, "buttons");
    if ((localArrayNode != null) && (localArrayNode.size() > paramInt)) {
      return localArrayNode.get(paramInt);
    }
    return null;
  }
  
  private boolean c(com.ideashower.readitlater.activity.a parama)
  {
    switch (d())
    {
    default: 
      return false;
    }
    d(parama);
    return true;
  }
  
  private void d(com.ideashower.readitlater.activity.a parama)
  {
    t.a(parama, this);
  }
  
  public String a()
  {
    return com.ideashower.readitlater.util.l.a(this.a, "title", null);
  }
  
  public void a(int paramInt, com.ideashower.readitlater.activity.a parama)
  {
    JsonNode localJsonNode = b(paramInt).get("action");
    a(localJsonNode.get("id").asText(), localJsonNode.get("meta"), parama);
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(com.ideashower.readitlater.activity.a parama)
  {
    com.pocket.stats.l.c.a(this);
    a(1, parama);
  }
  
  public String b()
  {
    return com.ideashower.readitlater.util.l.a(this.a, "message", null);
  }
  
  public void b(com.ideashower.readitlater.activity.a parama)
  {
    com.pocket.stats.l.b.a(this);
    a(0, parama);
  }
  
  public int c()
  {
    return com.ideashower.readitlater.util.l.a(this.a, "message_id", -1);
  }
  
  public int d()
  {
    return com.ideashower.readitlater.util.l.a(this.a, "message_ui_id", -1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return a(1);
  }
  
  public String f()
  {
    return a(0);
  }
  
  public void g()
  {
    if (this.b <= 0L)
    {
      e.a("since value was not set or was set to 0", true);
      return;
    }
    g.a(new Runnable()
    {
      public void run()
      {
        com.ideashower.readitlater.activity.a locala = g.n();
        if ((locala != null) && (!locala.isFinishing()))
        {
          b localb = (b)com.ideashower.readitlater.h.a.bq.b(UserMessage.this.c());
          if (!i.a(localb))
          {
            if (UserMessage.a(UserMessage.this, locala)) {
              com.pocket.stats.l.a.a(UserMessage.this);
            }
          }
          else {
            i.b().a(com.ideashower.readitlater.h.a.ad, UserMessage.a(UserMessage.this)).a(localb, true).a();
          }
        }
      }
    });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/UserMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */