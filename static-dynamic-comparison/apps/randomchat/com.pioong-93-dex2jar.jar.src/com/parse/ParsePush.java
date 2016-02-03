package com.parse;

import com.parse.gdata.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePush
{
  private static final String TAG = "com.parse.ParsePush";
  private Set<String> channelSet = null;
  private JSONObject data;
  private Long expirationTime = null;
  private Long expirationTimeInterval = null;
  private Boolean pushToAndroid = null;
  private Boolean pushToIOS = null;
  private ParseQuery<ParseInstallation> query = null;
  
  private Task<Void> sendAsync()
  {
    buildCommand(ParseUser.getCurrentSessionToken()).performAsync().continueWith(new Continuation()
    {
      public Void then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        return null;
      }
    });
  }
  
  public static void sendDataInBackground(JSONObject paramJSONObject, ParseQuery<ParseInstallation> paramParseQuery)
  {
    sendDataInBackground(paramJSONObject, paramParseQuery, null);
  }
  
  public static void sendDataInBackground(JSONObject paramJSONObject, ParseQuery<ParseInstallation> paramParseQuery, SendCallback paramSendCallback)
  {
    ParsePush localParsePush = new ParsePush();
    localParsePush.setQuery(paramParseQuery);
    localParsePush.setData(paramJSONObject);
    localParsePush.sendInBackground(paramSendCallback);
  }
  
  public static void sendMessageInBackground(String paramString, ParseQuery<ParseInstallation> paramParseQuery)
  {
    sendMessageInBackground(paramString, paramParseQuery, null);
  }
  
  public static void sendMessageInBackground(String paramString, ParseQuery<ParseInstallation> paramParseQuery, SendCallback paramSendCallback)
  {
    ParsePush localParsePush = new ParsePush();
    localParsePush.setQuery(paramParseQuery);
    localParsePush.setMessage(paramString);
    localParsePush.sendInBackground(paramSendCallback);
  }
  
  ParseCommand buildCommand(String paramString)
  {
    paramString = new ParseCommand("client_push", paramString);
    if (this.data == null) {
      throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
    }
    paramString.put("data", this.data);
    label83:
    int i;
    if (this.query != null)
    {
      paramString.put("where", this.query.getFindParams().optJSONObject("data"));
      if (this.expirationTime == null) {
        break label202;
      }
      paramString.put("expiration_time", this.expirationTime.longValue());
      if ((this.query == null) && ((this.pushToAndroid != null) || (this.pushToIOS != null)))
      {
        if ((this.pushToAndroid == null) || (this.pushToAndroid.booleanValue())) {
          break label225;
        }
        i = 0;
        label123:
        if ((this.pushToIOS == null) || (!this.pushToIOS.booleanValue())) {
          break label230;
        }
      }
    }
    label202:
    label225:
    label230:
    for (int j = 1;; j = 0)
    {
      if ((j == 0) || (i == 0))
      {
        if (j == 0) {
          break label235;
        }
        paramString.put("type", "ios");
      }
      return paramString;
      if (this.channelSet == null)
      {
        paramString.put("channel", "");
        break;
      }
      paramString.put("channels", new JSONArray(this.channelSet));
      break;
      if (this.expirationTimeInterval == null) {
        break label83;
      }
      paramString.put("expiration_time_interval", this.expirationTimeInterval.longValue());
      break label83;
      i = 1;
      break label123;
    }
    label235:
    if (i != 0)
    {
      paramString.put("type", "android");
      return paramString;
    }
    throw new IllegalArgumentException("Cannot push if both pushToIOS and pushToAndroid are false");
  }
  
  public void clearExpiration()
  {
    this.expirationTime = null;
    this.expirationTimeInterval = null;
  }
  
  public void send()
    throws ParseException
  {
    Parse.waitForTask(sendAsync());
  }
  
  public void sendInBackground()
  {
    sendInBackground(null);
  }
  
  public void sendInBackground(SendCallback paramSendCallback)
  {
    Parse.callbackOnMainThreadAsync(sendAsync(), paramSendCallback);
  }
  
  public void setChannel(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "channel cannot be null");
      this.channelSet = new HashSet();
      this.channelSet.add(paramString);
      this.query = null;
      return;
    }
  }
  
  public void setChannels(Collection<String> paramCollection)
  {
    if (paramCollection != null) {}
    Iterator localIterator;
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "channels collection cannot be null");
      localIterator = paramCollection.iterator();
      if (localIterator.hasNext()) {
        break;
      }
      this.channelSet = new HashSet();
      this.channelSet.addAll(paramCollection);
      this.query = null;
      return;
    }
    if ((String)localIterator.next() != null) {}
    for (bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "channel cannot be null");
      break;
    }
  }
  
  public void setData(JSONObject paramJSONObject)
  {
    this.data = paramJSONObject;
  }
  
  public void setExpirationTime(long paramLong)
  {
    this.expirationTime = Long.valueOf(paramLong);
    this.expirationTimeInterval = null;
  }
  
  public void setExpirationTimeInterval(long paramLong)
  {
    this.expirationTime = null;
    this.expirationTimeInterval = Long.valueOf(paramLong);
  }
  
  public void setMessage(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("alert", paramString);
      setData(localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParsePush", "JSONException in setMessage", paramString);
      }
    }
  }
  
  @Deprecated
  public void setPushToAndroid(boolean paramBoolean)
  {
    if (this.query == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      this.pushToAndroid = Boolean.valueOf(paramBoolean);
      return;
    }
  }
  
  @Deprecated
  public void setPushToIOS(boolean paramBoolean)
  {
    if (this.query == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      this.pushToIOS = Boolean.valueOf(paramBoolean);
      return;
    }
  }
  
  public void setQuery(ParseQuery<ParseInstallation> paramParseQuery)
  {
    boolean bool2 = true;
    if (paramParseQuery != null)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Cannot target a null query");
      if ((this.pushToIOS != null) || (this.pushToAndroid != null)) {
        break label73;
      }
    }
    label73:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
      Preconditions.checkArgument(paramParseQuery.getClassName().equals(ParseObject.getClassName(ParseInstallation.class)), "Can only push to a query for Installations");
      this.channelSet = null;
      this.query = paramParseQuery;
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParsePush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */