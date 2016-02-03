package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal;

import android.util.Base64;
import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.logging.Logger;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONRecordAdapter
{
  private static Logger logger = Logger.getLogger(JSONRecordAdapter.class);
  
  public JSONObject translateFromRecord(PutRecordRequest paramPutRecordRequest)
  {
    if (paramPutRecordRequest == null)
    {
      logger.i("The Record provided was null");
      return null;
    }
    if ((paramPutRecordRequest.getData() == null) || (paramPutRecordRequest.getPartitionKey() == null) || (paramPutRecordRequest.getPartitionKey().isEmpty()) || (paramPutRecordRequest.getStreamName() == null) || (paramPutRecordRequest.getStreamName().isEmpty())) {
      throw new AmazonClientException("RecordRequests must specify a partition key, stream name, and data");
    }
    if (!paramPutRecordRequest.getData().hasArray()) {
      throw new AmazonClientException("ByteBuffer must be based on array for proper storage");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Data", Base64.encodeToString(paramPutRecordRequest.getData().array(), 0));
      localJSONObject.put("StreamName", paramPutRecordRequest.getStreamName());
      localJSONObject.put("PartitionKey", paramPutRecordRequest.getPartitionKey());
      localJSONObject.putOpt("ExplicitHash", paramPutRecordRequest.getExplicitHashKey());
      localJSONObject.putOpt("SequenceNumber", paramPutRecordRequest.getSequenceNumberForOrdering());
      return localJSONObject;
    }
    catch (JSONException paramPutRecordRequest)
    {
      throw new AmazonClientException("Unable to convert KinesisRecord to JSON " + paramPutRecordRequest.getMessage());
    }
  }
  
  public PutRecordRequest translateToRecord(JSONObject paramJSONObject)
  {
    PutRecordRequest localPutRecordRequest = new PutRecordRequest();
    try
    {
      localPutRecordRequest.withData(ByteBuffer.wrap(Base64.decode(paramJSONObject.getString("Data"), 0)));
      localPutRecordRequest.withPartitionKey(paramJSONObject.getString("PartitionKey"));
      localPutRecordRequest.withStreamName(paramJSONObject.getString("StreamName"));
      if (paramJSONObject.has("ExplicitHash")) {
        localPutRecordRequest.withExplicitHashKey(paramJSONObject.getString("ExplicitHash"));
      }
      if (paramJSONObject.has("SequenceNumber")) {
        localPutRecordRequest.withSequenceNumberForOrdering(paramJSONObject.getString("SequenceNumber"));
      }
      return localPutRecordRequest;
    }
    catch (JSONException paramJSONObject)
    {
      logger.e("Error creating stored request from representation on disk, ignoring request", paramJSONObject);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/JSONRecordAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */