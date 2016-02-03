package com.pocket.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.db.operation.g;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.a.c.k;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class UserMeta
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public UserMeta a(Parcel paramAnonymousParcel)
    {
      return new UserMeta(paramAnonymousParcel);
    }
    
    public UserMeta[] a(int paramAnonymousInt)
    {
      return new UserMeta[paramAnonymousInt];
    }
  };
  private final String a;
  private final String b;
  private final String c;
  private String d;
  private final String e;
  private final int f;
  private final boolean g;
  private final boolean h;
  private final ArrayList i;
  private final int j;
  private final int k;
  
  public UserMeta(Parcel paramParcel)
  {
    this(a(paramParcel));
  }
  
  private UserMeta(d paramd)
  {
    this.d = d.a(paramd);
    this.i = d.b(paramd);
    this.a = d.c(paramd);
    this.b = d.d(paramd);
    this.e = d.e(paramd);
    this.c = d.f(paramd);
    this.f = d.g(paramd);
    this.g = d.h(paramd);
    this.h = d.i(paramd);
    this.j = d.j(paramd);
    this.k = d.k(paramd);
  }
  
  public static UserMeta a(String paramString, UserMeta paramUserMeta)
  {
    return new d(paramUserMeta).d(paramString).a();
  }
  
  public static UserMeta a(JsonParser paramJsonParser)
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT)
    {
      paramJsonParser.skipChildren();
      return null;
    }
    d locald = new d();
    while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
    {
      Object localObject = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if ("user_id".equals(localObject))
      {
        locald.e(com.ideashower.readitlater.util.l.a(paramJsonParser));
      }
      else if ("first_name".equals(localObject))
      {
        locald.b(com.ideashower.readitlater.util.l.a(paramJsonParser));
      }
      else if ("last_name".equals(localObject))
      {
        locald.c(com.ideashower.readitlater.util.l.a(paramJsonParser));
      }
      else if ("username".equals(localObject))
      {
        locald.d(com.ideashower.readitlater.util.l.a(paramJsonParser));
      }
      else if ("premium_status".equals(localObject))
      {
        locald.b(Integer.valueOf(com.ideashower.readitlater.util.l.a(paramJsonParser)).intValue());
      }
      else if ("premium_alltime_status".equals(localObject))
      {
        locald.c(Integer.valueOf(com.ideashower.readitlater.util.l.a(paramJsonParser)).intValue());
      }
      else if ("friend".equals(localObject))
      {
        localObject = new g();
        if (((g)localObject).a(paramJsonParser))
        {
          locald.a(((g)localObject).a);
          locald.a(((g)localObject).f);
        }
      }
      else if ("email".equals(localObject))
      {
        locald.a(com.ideashower.readitlater.util.l.a(paramJsonParser));
      }
      else if ("aliases".equals(localObject))
      {
        if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
          localObject = JsonToken.END_ARRAY;
        }
        while ((paramJsonParser.nextToken() != localObject) && (!paramJsonParser.isClosed()))
        {
          if (localObject == JsonToken.END_OBJECT) {
            paramJsonParser.nextToken();
          }
          String str1 = null;
          boolean bool = false;
          for (;;)
          {
            if ((paramJsonParser.nextToken() == JsonToken.END_OBJECT) || (paramJsonParser.isClosed())) {
              break label416;
            }
            String str2 = paramJsonParser.getCurrentName();
            paramJsonParser.nextToken();
            if ("email".equals(str2))
            {
              str1 = com.ideashower.readitlater.util.l.a(paramJsonParser);
              continue;
              localObject = JsonToken.END_OBJECT;
              break;
            }
            if ("confirmed".equals(str2))
            {
              if (Integer.valueOf(com.ideashower.readitlater.util.l.a(paramJsonParser)).intValue() == 1) {
                bool = true;
              } else {
                bool = false;
              }
            }
            else {
              paramJsonParser.skipChildren();
            }
          }
          label416:
          locald.a(str1, bool);
        }
      }
      else
      {
        paramJsonParser.skipChildren();
      }
    }
    return locald.a();
  }
  
  private static d a(Parcel paramParcel)
  {
    d locald = new d();
    locald.b(paramParcel.readString());
    locald.c(paramParcel.readString());
    locald.e(paramParcel.readString());
    locald.a(paramParcel.readString());
    locald.d(paramParcel.readString());
    locald.a(paramParcel.readInt());
    label88:
    label112:
    String str;
    if (paramParcel.readInt() == 1)
    {
      bool = true;
      locald.a(bool);
      if (paramParcel.readInt() != 1) {
        break label155;
      }
      bool = true;
      locald.b(bool);
      locald.b(paramParcel.readInt());
      locald.c(paramParcel.readInt());
      if (paramParcel.dataPosition() >= paramParcel.dataSize() - 1) {
        return locald;
      }
      str = paramParcel.readString();
      if (paramParcel.readInt() != 1) {
        break label160;
      }
    }
    label155:
    label160:
    for (boolean bool = true;; bool = false)
    {
      locald.a(str, bool);
      break label112;
      bool = false;
      break;
      bool = false;
      break label88;
    }
    return locald;
  }
  
  public static UserMeta l()
  {
    d locald = new d();
    locald.d(i.a(a.a)).e(i.a(a.e)).a(i.a(a.f)).a(i.a(a.g)).b(i.a(a.h)).b(i.a(a.s)).b(i.a(a.i)).c(i.a(a.j)).a(i.a(a.k));
    Object localObject = com.ideashower.readitlater.util.l.b(i.a(a.l));
    if (localObject != null)
    {
      localObject = ((ArrayNode)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
        locald.a(localJsonNode.get("email").asText(), localJsonNode.get("confirmed").asBoolean());
      }
    }
    return locald.a();
  }
  
  public com.ideashower.readitlater.h.l a(com.ideashower.readitlater.h.l paraml)
  {
    paraml.a(a.e, j()).a(a.f, k()).a(a.g, b()).a(a.h, c()).a(a.s, d()).a(a.i, g()).a(a.j, h()).a(a.k, a());
    ArrayNode localArrayNode = com.ideashower.readitlater.util.l.c();
    if (this.i != null)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        ObjectNode localObjectNode = com.ideashower.readitlater.util.l.b();
        localObjectNode.put("email", e.b(locale));
        localObjectNode.put("confirmed", e.a(locale));
        localArrayNode.add(localObjectNode);
      }
    }
    paraml.a(a.l, localArrayNode.toString());
    return paraml;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(e parame)
  {
    this.i.remove(parame);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.i.add(new e(paramString, paramBoolean, null));
  }
  
  public boolean a(String paramString)
  {
    if (k.a(a(), paramString)) {
      return true;
    }
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      if (k.a(e.b((e)localIterator.next()), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int e()
  {
    return this.k;
  }
  
  public ArrayList f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public String i()
  {
    return this.e;
  }
  
  public String j()
  {
    return this.c;
  }
  
  public int k()
  {
    return this.f;
  }
  
  public boolean m()
  {
    return (this.f != 0) && (this.c != null);
  }
  
  public String toString()
  {
    return super.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    if (this.g)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.h) {
        break label152;
      }
      paramInt = 1;
      label71:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.j);
      paramParcel.writeInt(this.k);
      Iterator localIterator = this.i.iterator();
      label100:
      if (!localIterator.hasNext()) {
        return;
      }
      e locale = (e)localIterator.next();
      paramParcel.writeString(locale.a());
      if (!e.a(locale)) {
        break label157;
      }
    }
    label152:
    label157:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      break label100;
      paramInt = 0;
      break;
      paramInt = 0;
      break label71;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/user/UserMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */