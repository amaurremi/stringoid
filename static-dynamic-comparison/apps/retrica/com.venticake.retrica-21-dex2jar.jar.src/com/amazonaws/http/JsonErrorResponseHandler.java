package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.Request;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonErrorResponseHandler
  implements HttpResponseHandler<AmazonServiceException>
{
  private List<? extends JsonErrorUnmarshaller> unmarshallerList;
  
  public JsonErrorResponseHandler(List<? extends JsonErrorUnmarshaller> paramList)
  {
    this.unmarshallerList = paramList;
  }
  
  private String parseErrorTypeFromHeader(HttpResponse paramHttpResponse)
  {
    String str = (String)paramHttpResponse.getHeaders().get("x-amzn-ErrorType");
    paramHttpResponse = str;
    if (str != null)
    {
      int i = str.indexOf(':');
      paramHttpResponse = str;
      if (i != -1) {
        paramHttpResponse = str.substring(0, i);
      }
    }
    return paramHttpResponse;
  }
  
  private String readStreamContents(InputStream paramInputStream)
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          return localStringBuilder.toString();
        }
        localStringBuilder.append(str);
      }
      try
      {
        paramInputStream.close();
        throw new AmazonClientException("Unable to read error response: " + localException.getMessage(), localException);
      }
      catch (Exception paramInputStream)
      {
        for (;;) {}
      }
    }
    catch (Exception localException) {}
  }
  
  private AmazonServiceException runErrorUnmarshallers(HttpResponse paramHttpResponse, JSONObject paramJSONObject, String paramString)
  {
    Iterator localIterator = this.unmarshallerList.iterator();
    while (localIterator.hasNext())
    {
      JsonErrorUnmarshaller localJsonErrorUnmarshaller = (JsonErrorUnmarshaller)localIterator.next();
      if (localJsonErrorUnmarshaller.match(paramString, paramJSONObject))
      {
        paramJSONObject = localJsonErrorUnmarshaller.unmarshall(paramJSONObject);
        paramJSONObject.setStatusCode(paramHttpResponse.getStatusCode());
        return paramJSONObject;
      }
    }
    return null;
  }
  
  public AmazonServiceException handle(HttpResponse paramHttpResponse)
  {
    Object localObject2 = readStreamContents(paramHttpResponse.getContent());
    for (;;)
    {
      try
      {
        if (((String)localObject2).length() == 0) {
          break label212;
        }
        if (((String)localObject2).trim().length() != 0) {
          break label207;
        }
      }
      catch (Exception paramHttpResponse)
      {
        throw new AmazonClientException("Unable to parse error response: '" + (String)localObject2 + "'", paramHttpResponse);
      }
      Object localObject1 = new JSONObject((String)localObject1);
      localObject1 = runErrorUnmarshallers(paramHttpResponse, (JSONObject)localObject1, parseErrorTypeFromHeader(paramHttpResponse));
      if (localObject1 == null) {
        return null;
      }
      ((AmazonServiceException)localObject1).setServiceName(paramHttpResponse.getRequest().getServiceName());
      ((AmazonServiceException)localObject1).setStatusCode(paramHttpResponse.getStatusCode());
      if (paramHttpResponse.getStatusCode() < 500) {
        ((AmazonServiceException)localObject1).setErrorType(AmazonServiceException.ErrorType.Client);
      }
      for (;;)
      {
        paramHttpResponse = paramHttpResponse.getHeaders().entrySet().iterator();
        while (paramHttpResponse.hasNext())
        {
          localObject2 = (Map.Entry)paramHttpResponse.next();
          if (((String)((Map.Entry)localObject2).getKey()).equalsIgnoreCase("X-Amzn-RequestId")) {
            ((AmazonServiceException)localObject1).setRequestId((String)((Map.Entry)localObject2).getValue());
          }
        }
        ((AmazonServiceException)localObject1).setErrorType(AmazonServiceException.ErrorType.Service);
      }
      return (AmazonServiceException)localObject1;
      label207:
      localObject1 = localObject2;
      continue;
      label212:
      localObject1 = "{}";
    }
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/JsonErrorResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */