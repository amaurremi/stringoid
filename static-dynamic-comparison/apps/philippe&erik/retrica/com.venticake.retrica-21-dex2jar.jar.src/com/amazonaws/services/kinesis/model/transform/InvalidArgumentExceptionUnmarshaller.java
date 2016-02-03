package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.kinesis.model.InvalidArgumentException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class InvalidArgumentExceptionUnmarshaller
  extends JsonErrorUnmarshaller
{
  public InvalidArgumentExceptionUnmarshaller()
  {
    super(InvalidArgumentException.class);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      paramString = parseErrorCode(paramJSONObject);
      return (paramString != null) && (paramString.equals("InvalidArgumentException"));
    }
    return paramString.equals("InvalidArgumentException");
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    paramJSONObject = (InvalidArgumentException)super.unmarshall(paramJSONObject);
    paramJSONObject.setErrorCode("InvalidArgumentException");
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/InvalidArgumentExceptionUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */