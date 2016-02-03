package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.json.JSONObject;

public class JsonErrorUnmarshaller
  extends AbstractErrorUnmarshaller<JSONObject>
{
  public JsonErrorUnmarshaller() {}
  
  protected JsonErrorUnmarshaller(Class<? extends AmazonServiceException> paramClass)
  {
    super(paramClass);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    return true;
  }
  
  public String parseErrorCode(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("__type"))
    {
      paramJSONObject = paramJSONObject.getString("__type");
      return paramJSONObject.substring(paramJSONObject.lastIndexOf("#") + 1);
    }
    return null;
  }
  
  public String parseMember(String paramString, JSONObject paramJSONObject)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    String str1;
    do
    {
      return paramString;
      str1 = paramString.substring(0, 1).toLowerCase() + paramString.substring(1);
      String str2 = paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
      paramString = "";
      if (paramJSONObject.has(str2)) {
        return paramJSONObject.getString(str2);
      }
    } while (!paramJSONObject.has(str1));
    return paramJSONObject.getString(str1);
  }
  
  public String parseMessage(JSONObject paramJSONObject)
  {
    return parseMember("message", paramJSONObject);
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    Object localObject = parseMessage(paramJSONObject);
    paramJSONObject = parseErrorCode(paramJSONObject);
    if (((localObject == null) || (((String)localObject).isEmpty())) && ((paramJSONObject == null) || (paramJSONObject.isEmpty()))) {
      throw new AmazonClientException("Neither error message nor error code is found in the error response payload.");
    }
    localObject = newException((String)localObject);
    ((AmazonServiceException)localObject).setErrorCode(paramJSONObject);
    return (AmazonServiceException)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/transform/JsonErrorUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */