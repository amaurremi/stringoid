package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.kinesis.model.ExpiredIteratorException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ExpiredIteratorExceptionUnmarshaller
  extends JsonErrorUnmarshaller
{
  public ExpiredIteratorExceptionUnmarshaller()
  {
    super(ExpiredIteratorException.class);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      paramString = parseErrorCode(paramJSONObject);
      return (paramString != null) && (paramString.equals("ExpiredIteratorException"));
    }
    return paramString.equals("ExpiredIteratorException");
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    paramJSONObject = (ExpiredIteratorException)super.unmarshall(paramJSONObject);
    paramJSONObject.setErrorCode("ExpiredIteratorException");
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/ExpiredIteratorExceptionUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */