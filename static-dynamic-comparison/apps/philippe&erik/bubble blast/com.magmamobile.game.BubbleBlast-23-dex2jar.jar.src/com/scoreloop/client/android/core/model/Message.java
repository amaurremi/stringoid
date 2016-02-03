package com.scoreloop.client.android.core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Message
{
  private Object a;
  private String b;
  private List<MessageReceiver> c = new ArrayList();
  
  private JSONArray f()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext())
    {
      MessageReceiver localMessageReceiver = (MessageReceiver)localIterator.next();
      try
      {
        localJSONArray.put(localMessageReceiver.b());
      }
      catch (JSONException localJSONException)
      {
        throw new IllegalStateException(localJSONException);
      }
    }
    return localJSONException;
  }
  
  private JSONObject g()
  {
    if (b() == null) {
      throw new IllegalStateException();
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", ((MessageTarget)b()).getIdentifier());
      localJSONObject.put("target_type", ((MessageTarget)b()).b());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
  
  public Message a()
  {
    Message localMessage = new Message();
    localMessage.a(b());
    localMessage.a(c());
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext()) {
      localMessage.a((MessageReceiver)localIterator.next());
    }
    return localMessage;
  }
  
  public void a(MessageReceiver paramMessageReceiver)
  {
    if (!this.c.contains(paramMessageReceiver)) {
      this.c.add(paramMessageReceiver);
    }
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof MessageTarget)) {
      throw new IllegalArgumentException();
    }
    this.a = paramObject;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public Object b()
  {
    return this.a;
  }
  
  public void b(MessageReceiver paramMessageReceiver)
  {
    this.c.remove(paramMessageReceiver);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public List<MessageReceiver> d()
  {
    return this.c;
  }
  
  public JSONObject e()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (c() != null) {
      localJSONObject.put("text", c());
    }
    localJSONObject.put("target", g());
    localJSONObject.put("receivers", f());
    return localJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */