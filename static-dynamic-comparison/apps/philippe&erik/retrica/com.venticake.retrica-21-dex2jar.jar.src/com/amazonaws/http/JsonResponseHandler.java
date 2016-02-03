package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidJsonUnmarshaller;
import com.amazonaws.util.CRC32ChecksumCalculatingInputStream;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JsonResponseHandler<T>
  implements HttpResponseHandler<AmazonWebServiceResponse<T>>
{
  private static JsonFactory jsonFactory = new JsonFactory();
  private static final Log log = LogFactory.getLog("com.amazonaws.request");
  public boolean needsConnectionLeftOpen = false;
  private Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller;
  
  public JsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> paramUnmarshaller)
  {
    this.responseUnmarshaller = paramUnmarshaller;
    if (this.responseUnmarshaller == null) {
      this.responseUnmarshaller = new VoidJsonUnmarshaller();
    }
  }
  
  public AmazonWebServiceResponse<T> handle(HttpResponse paramHttpResponse)
  {
    Object localObject2 = null;
    log.trace("Parsing service response JSON");
    String str = (String)paramHttpResponse.getHeaders().get("x-amz-crc32");
    if (!this.needsConnectionLeftOpen) {
      if (str != null) {
        localObject2 = new CRC32ChecksumCalculatingInputStream(paramHttpResponse.getContent());
      }
    }
    Object localObject1;
    for (JsonParser localJsonParser = jsonFactory.createParser((InputStream)localObject2);; localObject1 = null) {
      for (;;)
      {
        AmazonWebServiceResponse localAmazonWebServiceResponse;
        JsonUnmarshallerContext localJsonUnmarshallerContext;
        Object localObject3;
        try
        {
          localAmazonWebServiceResponse = new AmazonWebServiceResponse();
          localJsonUnmarshallerContext = new JsonUnmarshallerContext(localJsonParser, paramHttpResponse);
          registerAdditionalMetadataExpressions(localJsonUnmarshallerContext);
          localObject3 = this.responseUnmarshaller.unmarshall(localJsonUnmarshallerContext);
          if (str != null)
          {
            long l = Long.parseLong(str);
            if (((CRC32ChecksumCalculatingInputStream)localObject2).getCRC32Checksum() != l) {
              throw new CRC32MismatchException("Client calculated crc32 checksum didn't match that calculated by server side");
            }
          }
        }
        finally
        {
          if (this.needsConnectionLeftOpen) {}
        }
        try
        {
          localJsonParser.close();
          throw paramHttpResponse;
          localJsonParser = jsonFactory.createParser(paramHttpResponse.getContent());
          continue;
          localAmazonWebServiceResponse.setResult(localObject3);
          localObject2 = localJsonUnmarshallerContext.getMetadata();
          ((Map)localObject2).put("AWS_REQUEST_ID", paramHttpResponse.getHeaders().get("x-amzn-RequestId"));
          localAmazonWebServiceResponse.setResponseMetadata(new ResponseMetadata((Map)localObject2));
          log.trace("Done parsing service response");
          if (!this.needsConnectionLeftOpen) {}
          try
          {
            localJsonParser.close();
            return localAmazonWebServiceResponse;
          }
          catch (IOException paramHttpResponse)
          {
            log.warn("Error closing json parser", paramHttpResponse);
            return localAmazonWebServiceResponse;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            log.warn("Error closing json parser", localIOException);
          }
        }
      }
    }
  }
  
  public boolean needsConnectionLeftOpen()
  {
    return this.needsConnectionLeftOpen;
  }
  
  protected void registerAdditionalMetadataExpressions(JsonUnmarshallerContext paramJsonUnmarshallerContext) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/JsonResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */