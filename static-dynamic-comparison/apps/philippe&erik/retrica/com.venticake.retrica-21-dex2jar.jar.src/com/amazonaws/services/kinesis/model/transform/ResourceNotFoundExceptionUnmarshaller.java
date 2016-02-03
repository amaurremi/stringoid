package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.kinesis.model.ResourceNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;

public class ResourceNotFoundExceptionUnmarshaller
  extends JsonErrorUnmarshaller
{
  public ResourceNotFoundExceptionUnmarshaller()
  {
    super(ResourceNotFoundException.class);
  }
  
  public boolean match(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null)
    {
      paramString = parseErrorCode(paramJSONObject);
      return (paramString != null) && (paramString.equals("ResourceNotFoundException"));
    }
    return paramString.equals("ResourceNotFoundException");
  }
  
  public AmazonServiceException unmarshall(JSONObject paramJSONObject)
  {
    paramJSONObject = (ResourceNotFoundException)super.unmarshall(paramJSONObject);
    paramJSONObject.setErrorCode("ResourceNotFoundException");
    return paramJSONObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/ResourceNotFoundExceptionUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */