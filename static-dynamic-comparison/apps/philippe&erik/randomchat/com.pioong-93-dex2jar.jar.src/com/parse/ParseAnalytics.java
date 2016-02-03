package com.parse;

import android.content.Intent;
import android.os.Bundle;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseAnalytics
{
  private static final String TAG = "com.parse.ParseAnalytics";
  
  public static void trackAppOpened(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      trackAppOpened(paramIntent.getExtras().getString("com.parse.Data"));
    }
  }
  
  private static void trackAppOpened(String paramString)
  {
    ParseCommand localParseCommand = new ParseCommand("client_app_opened", ParseUser.getCurrentSessionToken());
    localParseCommand.put("at", Parse.dateToObject(new Date()));
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString).optString("push_hash");
      if (paramString.length() > 0) {
        localParseCommand.put("push_hash", paramString);
      }
      Parse.getCommandCache().runEventuallyAsync(localParseCommand, null);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Parse.logE("com.parse.ParseAnalytics", "Failed to parse push data: " + paramString.getMessage());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */