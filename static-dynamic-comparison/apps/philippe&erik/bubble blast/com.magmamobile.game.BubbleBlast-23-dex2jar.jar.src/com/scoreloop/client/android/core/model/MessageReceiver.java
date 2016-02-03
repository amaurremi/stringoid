package com.scoreloop.client.android.core.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageReceiver
{
  private Object a;
  private List<User> b;
  
  public MessageReceiver(Object paramObject, List<User> paramList)
  {
    this.a = paramObject;
    this.b = paramList;
  }
  
  public Object a()
  {
    return this.a;
  }
  
  public JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("receiver_type", ((SocialProvider)a()).getIdentifier());
    JSONArray localJSONArray = new JSONArray();
    if ((this.b != null) && (this.b.size() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((User)localIterator.next()).d());
      }
      localJSONObject.put("users", localJSONArray);
    }
    return localJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof MessageReceiver)) {
      return super.equals(paramObject);
    }
    paramObject = (MessageReceiver)paramObject;
    if (paramObject == this) {
      return true;
    }
    return a().equals(((MessageReceiver)paramObject).a());
  }
  
  public int hashCode()
  {
    return a().hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/model/MessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */