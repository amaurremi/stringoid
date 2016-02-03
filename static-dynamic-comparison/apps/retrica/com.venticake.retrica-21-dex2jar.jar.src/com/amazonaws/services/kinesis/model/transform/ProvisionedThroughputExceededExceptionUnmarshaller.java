package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.kinesis.model.ProvisionedThroughputExceededException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ProvisionedThroughputExceededExceptionUnmarshaller
  extends JsonErrorUnmarshaller
{
  public ProvisionedThroughputExceededExceptionUnmarshaller()
  {
    super(ProvisionedThroughputExceededException.class);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      paramString = parseErrorCode(paramJSONObject);
      return (paramString != null) && (paramString.equals("ProvisionedThroughputExceededException"));
    }
    return paramString.equals("ProvisionedThroughputExceededException");
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    paramJSONObject = (ProvisionedThroughputExceededException)super.unmarshall(paramJSONObject);
    paramJSONObject.setErrorCode("ProvisionedThroughputExceededException");
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/ProvisionedThroughputExceededExceptionUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */