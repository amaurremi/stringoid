package com.millennialmedia.android;

import org.json.JSONException;
import org.json.JSONObject;

class MMJSResponse
{
  static final int ERROR = 0;
  static final int SUCCESS = 1;
  String className;
  byte[] dataResponse;
  String methodName;
  Object response;
  int result;
  
  static MMJSResponse responseWithError()
  {
    return responseWithError("An unknown error occured.");
  }
  
  static MMJSResponse responseWithError(String paramString)
  {
    MMJSResponse localMMJSResponse = new MMJSResponse();
    localMMJSResponse.result = 0;
    localMMJSResponse.response = paramString;
    return localMMJSResponse;
  }
  
  static MMJSResponse responseWithSuccess()
  {
    return responseWithSuccess("Success.");
  }
  
  static MMJSResponse responseWithSuccess(String paramString)
  {
    MMJSResponse localMMJSResponse = new MMJSResponse();
    localMMJSResponse.result = 1;
    localMMJSResponse.response = paramString;
    return localMMJSResponse;
  }
  
  String toJSONString()
  {
    try
    {
      if ((this.className != null) && (this.methodName != null))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("class", this.className);
        localJSONObject.put("call", this.methodName);
        localJSONObject.put("result", this.result);
        if (this.response != null) {
          localJSONObject.put("response", this.response);
        }
        for (;;)
        {
          return localJSONObject.toString();
          if (this.dataResponse == null) {
            break;
          }
          localJSONObject.put("response", Base64.encodeToString(this.dataResponse, false));
        }
        return "";
      }
    }
    catch (JSONException localJSONException)
    {
      MMAdViewSDK.Log.e(localJSONException.getMessage());
      return "";
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMJSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */