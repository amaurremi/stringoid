package com.ideashower.readitlater.db.operation;

import com.ideashower.readitlater.util.l;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class g
{
  public int a = 0;
  public int b = 0;
  public String c = null;
  public String d = null;
  public String e = null;
  public boolean f = false;
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = false;
  }
  
  public boolean a(JsonParser paramJsonParser)
  {
    a();
    if (paramJsonParser.getCurrentToken() != JsonToken.START_OBJECT)
    {
      paramJsonParser.skipChildren();
      return false;
    }
    while ((paramJsonParser.nextToken() != JsonToken.END_OBJECT) && (!paramJsonParser.isClosed()))
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      if ("friend_id".equals(str))
      {
        this.a = paramJsonParser.getValueAsInt();
      }
      else if ("name".equals(str))
      {
        this.c = l.a(paramJsonParser);
      }
      else if ("username".equals(str))
      {
        this.d = l.a(paramJsonParser);
      }
      else if ("avatar_url".equals(str))
      {
        this.e = l.a(paramJsonParser);
      }
      else
      {
        if ("has_set_avatar".equals(str))
        {
          if (paramJsonParser.getValueAsInt() == 1) {}
          for (boolean bool = true;; bool = false)
          {
            this.f = bool;
            break;
          }
        }
        if ("local_friend_id".equals(str)) {
          this.b = paramJsonParser.getValueAsInt();
        } else {
          paramJsonParser.skipChildren();
        }
      }
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/db/operation/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */