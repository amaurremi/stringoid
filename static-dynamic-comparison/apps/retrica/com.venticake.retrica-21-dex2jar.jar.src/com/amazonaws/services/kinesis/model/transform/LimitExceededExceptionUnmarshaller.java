package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.kinesis.model.LimitExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class LimitExceededExceptionUnmarshaller
  extends JsonErrorUnmarshaller
{
  public LimitExceededExceptionUnmarshaller()
  {
    super(LimitExceededException.class);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      paramString = parseErrorCode(paramJSONObject);
      return (paramString != null) && (paramString.equals("LimitExceededException"));
    }
    return paramString.equals("LimitExceededException");
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    paramJSONObject = (LimitExceededException)super.unmarshall(paramJSONObject);
    paramJSONObject.setErrorCode("LimitExceededException");
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/LimitExceededExceptionUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */