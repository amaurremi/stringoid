package com.parse;

import java.util.Map;

public class ParseCloud
{
  public static <T> T callFunction(String paramString, Map<String, ?> paramMap)
    throws ParseException
  {
    return (T)Parse.waitForTask(callFunctionAsync(paramString, paramMap));
  }
  
  private static <T> Task<T> callFunctionAsync(String paramString, Map<String, ?> paramMap)
  {
    constructCallCommand(paramString, paramMap).performAsync().onSuccess(new Continuation()
    {
      public T then(Task<Object> paramAnonymousTask)
        throws Exception
      {
        return (T)ParseCloud.convertCloudResponse(paramAnonymousTask.getResult());
      }
    });
  }
  
  public static <T> void callFunctionInBackground(String paramString, Map<String, ?> paramMap, FunctionCallback<T> paramFunctionCallback)
  {
    Parse.callbackOnMainThreadAsync(callFunctionAsync(paramString, paramMap), paramFunctionCallback);
  }
  
  private static ParseCommand constructCallCommand(String paramString, Map<String, ?> paramMap)
  {
    ParseCommand localParseCommand = new ParseCommand("client_function", ParseUser.getCurrentSessionToken());
    localParseCommand.put("data", Parse.encodeJSONObject(paramMap, false));
    localParseCommand.put("function", paramString);
    return localParseCommand;
  }
  
  private static Object convertCloudResponse(Object paramObject)
  {
    Object localObject = Parse.decodeJSONObject(paramObject);
    if (localObject == null) {
      return paramObject;
    }
    return localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseCloud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */