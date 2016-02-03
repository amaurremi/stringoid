package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JSONWriter;
import java.io.StringWriter;
import java.io.Writer;

public class PutRecordRequestMarshaller
{
  public Request<PutRecordRequest> marshall(PutRecordRequest paramPutRecordRequest)
  {
    if (paramPutRecordRequest == null) {
      throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }
    DefaultRequest localDefaultRequest = new DefaultRequest(paramPutRecordRequest, "AmazonKinesis");
    localDefaultRequest.addHeader("X-Amz-Target", "Kinesis_20131202.PutRecord");
    localDefaultRequest.setHttpMethod(HttpMethodName.POST);
    localDefaultRequest.setResourcePath("");
    try
    {
      Object localObject = new StringWriter();
      JSONWriter localJSONWriter = new JSONWriter((Writer)localObject);
      localJSONWriter.object();
      if (paramPutRecordRequest.getStreamName() != null) {
        localJSONWriter.key("StreamName").value(paramPutRecordRequest.getStreamName());
      }
      if (paramPutRecordRequest.getData() != null) {
        localJSONWriter.key("Data").value(paramPutRecordRequest.getData());
      }
      if (paramPutRecordRequest.getPartitionKey() != null) {
        localJSONWriter.key("PartitionKey").value(paramPutRecordRequest.getPartitionKey());
      }
      if (paramPutRecordRequest.getExplicitHashKey() != null) {
        localJSONWriter.key("ExplicitHashKey").value(paramPutRecordRequest.getExplicitHashKey());
      }
      if (paramPutRecordRequest.getSequenceNumberForOrdering() != null) {
        localJSONWriter.key("SequenceNumberForOrdering").value(paramPutRecordRequest.getSequenceNumberForOrdering());
      }
      localJSONWriter.endObject();
      paramPutRecordRequest = ((StringWriter)localObject).toString();
      localObject = paramPutRecordRequest.getBytes(StringUtils.UTF8);
      localDefaultRequest.setContent(new StringInputStream(paramPutRecordRequest));
      localDefaultRequest.addHeader("Content-Length", Integer.toString(localObject.length));
      localDefaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
      return localDefaultRequest;
    }
    catch (Throwable paramPutRecordRequest)
    {
      throw new AmazonClientException("Unable to marshall request to JSON: " + paramPutRecordRequest.getMessage(), paramPutRecordRequest);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/PutRecordRequestMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */