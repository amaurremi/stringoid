package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.FileRecordStore;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.JSONRecordAdapter;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.RecordStore;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesis.AmazonKinesisClient;
import com.amazonaws.services.kinesis.model.PutRecordRequest;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

public class KinesisRecorder
{
  private static final String USER_AGENT = KinesisRecorder.class.getName() + "/" + VersionInfoUtils.getVersion();
  protected static final Log log = LogFactory.getLog(KinesisRecorder.class);
  private JSONRecordAdapter adapter;
  private AmazonKinesisClient client;
  private KinesisRecorderConfig config;
  private File directory;
  private RecordStore recordStore;
  
  public KinesisRecorder(File paramFile, Regions paramRegions, AWSCredentialsProvider paramAWSCredentialsProvider)
  {
    this(paramFile, paramRegions, paramAWSCredentialsProvider, new KinesisRecorderConfig());
  }
  
  public KinesisRecorder(File paramFile, Regions paramRegions, AWSCredentialsProvider paramAWSCredentialsProvider, KinesisRecorderConfig paramKinesisRecorderConfig)
  {
    if ((paramFile == null) || (paramAWSCredentialsProvider == null) || (paramRegions == null) || (paramKinesisRecorderConfig == null)) {
      throw new IllegalArgumentException("You must pass a non-null credentialsProvider, region, directory, and config to KinesisRecordStore");
    }
    this.config = new KinesisRecorderConfig(paramKinesisRecorderConfig);
    this.directory = paramFile;
    this.recordStore = new FileRecordStore(paramFile, this.config);
    this.adapter = new JSONRecordAdapter();
    this.client = new AmazonKinesisClient(paramAWSCredentialsProvider, this.config.getClientConfiguration());
    this.client.setRegion(Region.getRegion(paramRegions));
  }
  
  public void saveRecord(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 1)) {
      throw new IllegalArgumentException("You must pass a non-null, non-empty stream name and non-empty data");
    }
    paramArrayOfByte = new PutRecordRequest().withData(ByteBuffer.wrap(paramArrayOfByte)).withStreamName(paramString).withPartitionKey(UUID.randomUUID().toString());
    this.recordStore.put(this.adapter.translateFromRecord(paramArrayOfByte).toString());
  }
  
  /* Error */
  public void submitAllRecords()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:recordStore	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/RecordStore;
    //   6: invokeinterface 170 1 0
    //   11: astore 5
    //   13: aconst_null
    //   14: astore_2
    //   15: aload 5
    //   17: invokeinterface 175 1 0
    //   22: istore_1
    //   23: iload_1
    //   24: ifeq +145 -> 169
    //   27: aload_2
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: new 154	org/json/JSONObject
    //   35: dup
    //   36: aload 5
    //   38: invokeinterface 179 1 0
    //   43: checkcast 115	java/lang/String
    //   46: invokespecial 180	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore 6
    //   51: aload_2
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: aload_0
    //   57: getfield 90	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:adapter	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/JSONRecordAdapter;
    //   60: aload 6
    //   62: invokevirtual 184	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/JSONRecordAdapter:translateToRecord	(Lorg/json/JSONObject;)Lcom/amazonaws/services/kinesis/model/PutRecordRequest;
    //   65: astore_2
    //   66: aload_2
    //   67: astore 4
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: invokevirtual 188	com/amazonaws/services/kinesis/model/PutRecordRequest:getRequestClientOptions	()Lcom/amazonaws/RequestClientOptions;
    //   75: getstatic 55	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:USER_AGENT	Ljava/lang/String;
    //   78: invokevirtual 193	com/amazonaws/RequestClientOptions:appendUserAgent	(Ljava/lang/String;)V
    //   81: aload_2
    //   82: astore 4
    //   84: aload_2
    //   85: astore_3
    //   86: aload_0
    //   87: getfield 101	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:client	Lcom/amazonaws/services/kinesis/AmazonKinesisClient;
    //   90: aload_2
    //   91: invokevirtual 197	com/amazonaws/services/kinesis/AmazonKinesisClient:putRecord	(Lcom/amazonaws/services/kinesis/model/PutRecordRequest;)Lcom/amazonaws/services/kinesis/model/PutRecordResult;
    //   94: pop
    //   95: goto -80 -> 15
    //   98: astore_2
    //   99: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:log	Lorg/apache/commons/logging/Log;
    //   102: ldc -57
    //   104: aload_2
    //   105: invokeinterface 205 3 0
    //   110: aload 4
    //   112: astore_2
    //   113: goto -98 -> 15
    //   116: astore_2
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: aload 5
    //   124: invokeinterface 208 1 0
    //   129: getstatic 214	com/amazonaws/retry/PredefinedRetryPolicies:DEFAULT_RETRY_CONDITION	Lcom/amazonaws/retry/RetryPolicy$RetryCondition;
    //   132: aload_3
    //   133: aload_2
    //   134: iconst_1
    //   135: invokeinterface 220 4 0
    //   140: ifeq +39 -> 179
    //   143: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:log	Lorg/apache/commons/logging/Log;
    //   146: ldc -34
    //   148: aload_2
    //   149: invokeinterface 225 3 0
    //   154: aload_0
    //   155: aload_3
    //   156: invokevirtual 229	com/amazonaws/services/kinesis/model/PutRecordRequest:getData	()Ljava/nio/ByteBuffer;
    //   159: invokevirtual 233	java/nio/ByteBuffer:array	()[B
    //   162: aload_3
    //   163: invokevirtual 236	com/amazonaws/services/kinesis/model/PutRecordRequest:getStreamName	()Ljava/lang/String;
    //   166: invokevirtual 238	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:saveRecord	([BLjava/lang/String;)V
    //   169: aload 5
    //   171: invokeinterface 208 1 0
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: aload_2
    //   180: instanceof 240
    //   183: ifeq +97 -> 280
    //   186: aload_2
    //   187: checkcast 240	com/amazonaws/AmazonServiceException
    //   190: invokevirtual 243	com/amazonaws/AmazonServiceException:getErrorCode	()Ljava/lang/String;
    //   193: astore 4
    //   195: aload 4
    //   197: ldc -11
    //   199: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   202: ifne +66 -> 268
    //   205: aload 4
    //   207: ldc -6
    //   209: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   212: ifne +56 -> 268
    //   215: aload 4
    //   217: ldc -4
    //   219: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   222: ifne +46 -> 268
    //   225: aload 4
    //   227: ldc -2
    //   229: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: ifne +36 -> 268
    //   235: aload 4
    //   237: ldc_w 256
    //   240: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   243: ifne +25 -> 268
    //   246: aload 4
    //   248: ldc_w 258
    //   251: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   254: ifne +14 -> 268
    //   257: aload 4
    //   259: ldc_w 260
    //   262: invokevirtual 248	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   265: ifeq +17 -> 282
    //   268: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:log	Lorg/apache/commons/logging/Log;
    //   271: ldc_w 262
    //   274: aload_2
    //   275: invokeinterface 205 3 0
    //   280: aload_2
    //   281: athrow
    //   282: aload_0
    //   283: aload_3
    //   284: invokevirtual 229	com/amazonaws/services/kinesis/model/PutRecordRequest:getData	()Ljava/nio/ByteBuffer;
    //   287: invokevirtual 233	java/nio/ByteBuffer:array	()[B
    //   290: aload_3
    //   291: invokevirtual 236	com/amazonaws/services/kinesis/model/PutRecordRequest:getStreamName	()Ljava/lang/String;
    //   294: invokevirtual 238	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:saveRecord	([BLjava/lang/String;)V
    //   297: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder:log	Lorg/apache/commons/logging/Log;
    //   300: ldc_w 264
    //   303: aload_2
    //   304: invokeinterface 205 3 0
    //   309: goto -29 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	KinesisRecorder
    //   22	2	1	bool	boolean
    //   14	77	2	localPutRecordRequest1	PutRecordRequest
    //   98	7	2	localJSONException	org.json.JSONException
    //   112	1	2	localObject1	Object
    //   116	4	2	localObject2	Object
    //   121	183	2	localAmazonClientException	com.amazonaws.AmazonClientException
    //   31	260	3	localPutRecordRequest2	PutRecordRequest
    //   28	230	4	localObject3	Object
    //   11	159	5	localRecordIterator	com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.RecordStore.RecordIterator
    //   49	12	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   32	51	98	org/json/JSONException
    //   56	66	98	org/json/JSONException
    //   71	81	98	org/json/JSONException
    //   86	95	98	org/json/JSONException
    //   2	13	116	finally
    //   15	23	116	finally
    //   32	51	116	finally
    //   56	66	116	finally
    //   71	81	116	finally
    //   86	95	116	finally
    //   99	110	116	finally
    //   122	169	116	finally
    //   169	176	116	finally
    //   179	268	116	finally
    //   268	280	116	finally
    //   280	282	116	finally
    //   282	309	116	finally
    //   32	51	121	com/amazonaws/AmazonClientException
    //   56	66	121	com/amazonaws/AmazonClientException
    //   71	81	121	com/amazonaws/AmazonClientException
    //   86	95	121	com/amazonaws/AmazonClientException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */