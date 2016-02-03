package com.amazonaws.services.kinesis.model.transform;

import com.amazonaws.services.kinesis.model.PutRecordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.fasterxml.jackson.core.JsonToken;

public class PutRecordResultJsonUnmarshaller
  implements Unmarshaller<PutRecordResult, JsonUnmarshallerContext>
{
  public PutRecordResult unmarshall(JsonUnmarshallerContext paramJsonUnmarshallerContext)
  {
    PutRecordResult localPutRecordResult = new PutRecordResult();
    int i = paramJsonUnmarshallerContext.getCurrentDepth();
    String str = paramJsonUnmarshallerContext.getCurrentParentElement();
    int j = i + 1;
    Object localObject2 = paramJsonUnmarshallerContext.currentToken;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJsonUnmarshallerContext.nextToken();
    }
    localObject2 = localObject1;
    if (localObject1 == JsonToken.VALUE_NULL) {
      return null;
    }
    while (localObject2 != null)
    {
      if ((localObject2 != JsonToken.FIELD_NAME) && (localObject2 != JsonToken.START_OBJECT)) {
        break;
      }
      if (paramJsonUnmarshallerContext.testExpression("ShardId", j))
      {
        paramJsonUnmarshallerContext.nextToken();
        localPutRecordResult.setShardId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(paramJsonUnmarshallerContext));
      }
      if (paramJsonUnmarshallerContext.testExpression("SequenceNumber", j))
      {
        paramJsonUnmarshallerContext.nextToken();
        localPutRecordResult.setSequenceNumber(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(paramJsonUnmarshallerContext));
      }
      localObject2 = paramJsonUnmarshallerContext.nextToken();
    }
    for (;;)
    {
      return localPutRecordResult;
      if (((localObject2 != JsonToken.END_ARRAY) && (localObject2 != JsonToken.END_OBJECT)) || ((paramJsonUnmarshallerContext.getLastParsedParentElement() != null) && (!paramJsonUnmarshallerContext.getLastParsedParentElement().equals(str))) || (paramJsonUnmarshallerContext.getCurrentDepth() > i)) {
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/model/transform/PutRecordResultJsonUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */