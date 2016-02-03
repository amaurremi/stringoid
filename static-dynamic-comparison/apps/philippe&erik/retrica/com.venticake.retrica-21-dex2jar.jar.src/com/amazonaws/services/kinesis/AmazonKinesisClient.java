package com.amazonaws.services.kinesis;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.kinesis.model.transform.ExpiredIteratorExceptionUnmarshaller;
import com.amazonaws.services.kinesis.model.transform.InvalidArgumentExceptionUnmarshaller;
import com.amazonaws.services.kinesis.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.kinesis.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazonaws.services.kinesis.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.kinesis.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AmazonKinesisClient
  extends AmazonWebServiceClient
  implements AmazonKinesis
{
  private static final Log log = LogFactory.getLog(AmazonKinesis.class);
  private AWSCredentialsProvider awsCredentialsProvider;
  protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;
  
  public AmazonKinesisClient()
  {
    this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
  }
  
  public AmazonKinesisClient(AWSCredentialsProvider paramAWSCredentialsProvider, ClientConfiguration paramClientConfiguration)
  {
    this(paramAWSCredentialsProvider, paramClientConfiguration, null);
  }
  
  public AmazonKinesisClient(AWSCredentialsProvider paramAWSCredentialsProvider, ClientConfiguration paramClientConfiguration, RequestMetricCollector paramRequestMetricCollector)
  {
    super(adjustClientConfiguration(paramClientConfiguration), paramRequestMetricCollector);
    this.awsCredentialsProvider = paramAWSCredentialsProvider;
    init();
  }
  
  private static ClientConfiguration adjustClientConfiguration(ClientConfiguration paramClientConfiguration)
  {
    return paramClientConfiguration;
  }
  
  private void init()
  {
    this.jsonErrorUnmarshallers = new ArrayList();
    this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new InvalidArgumentExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new ExpiredIteratorExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
    this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
    setEndpoint("kinesis.us-east-1.amazonaws.com");
    HandlerChainFactory localHandlerChainFactory = new HandlerChainFactory();
    this.requestHandler2s.addAll(localHandlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/kinesis/request.handlers"));
    this.requestHandler2s.addAll(localHandlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/kinesis/request.handler2s"));
  }
  
  private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> paramRequest, HttpResponseHandler<AmazonWebServiceResponse<X>> paramHttpResponseHandler, ExecutionContext paramExecutionContext)
  {
    paramRequest.setEndpoint(this.endpoint);
    paramRequest.setTimeOffset(this.timeOffset);
    Object localObject2 = paramExecutionContext.getAwsRequestMetrics();
    ((AWSRequestMetrics)localObject2).startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
    try
    {
      Object localObject1 = this.awsCredentialsProvider.getCredentials();
      ((AWSRequestMetrics)localObject2).endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
      AmazonWebServiceRequest localAmazonWebServiceRequest = paramRequest.getOriginalRequest();
      localObject2 = localObject1;
      if (localAmazonWebServiceRequest != null)
      {
        localObject2 = localObject1;
        if (localAmazonWebServiceRequest.getRequestCredentials() != null) {
          localObject2 = localAmazonWebServiceRequest.getRequestCredentials();
        }
      }
      paramExecutionContext.setCredentials((AWSCredentials)localObject2);
      localObject1 = new JsonErrorResponseHandler(this.jsonErrorUnmarshallers);
      return this.client.execute(paramRequest, paramHttpResponseHandler, (HttpResponseHandler)localObject1, paramExecutionContext);
    }
    finally
    {
      ((AWSRequestMetrics)localObject2).endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
    }
  }
  
  /* Error */
  public com.amazonaws.services.kinesis.model.PutRecordResult putRecord(com.amazonaws.services.kinesis.model.PutRecordRequest paramPutRecordRequest)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 191	com/amazonaws/services/kinesis/AmazonKinesisClient:createExecutionContext	(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 134	com/amazonaws/http/ExecutionContext:getAwsRequestMetrics	()Lcom/amazonaws/util/AWSRequestMetrics;
    //   17: astore 6
    //   19: aload 6
    //   21: getstatic 194	com/amazonaws/util/AWSRequestMetrics$Field:ClientExecuteTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   24: invokevirtual 146	com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   27: aload 6
    //   29: getstatic 197	com/amazonaws/util/AWSRequestMetrics$Field:RequestMarshallTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   32: invokevirtual 146	com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   35: new 199	com/amazonaws/services/kinesis/model/transform/PutRecordRequestMarshaller
    //   38: dup
    //   39: invokespecial 200	com/amazonaws/services/kinesis/model/transform/PutRecordRequestMarshaller:<init>	()V
    //   42: aload_1
    //   43: invokevirtual 204	com/amazonaws/services/kinesis/model/transform/PutRecordRequestMarshaller:marshall	(Lcom/amazonaws/services/kinesis/model/PutRecordRequest;)Lcom/amazonaws/Request;
    //   46: astore_3
    //   47: aload_3
    //   48: aload 6
    //   50: invokeinterface 208 2 0
    //   55: aload_3
    //   56: astore_1
    //   57: aload 5
    //   59: astore_2
    //   60: aload 6
    //   62: getstatic 197	com/amazonaws/util/AWSRequestMetrics$Field:RequestMarshallTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   65: invokevirtual 155	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   68: aload_3
    //   69: astore_1
    //   70: aload 5
    //   72: astore_2
    //   73: aload_0
    //   74: aload_3
    //   75: new 210	com/amazonaws/http/JsonResponseHandler
    //   78: dup
    //   79: new 212	com/amazonaws/services/kinesis/model/transform/PutRecordResultJsonUnmarshaller
    //   82: dup
    //   83: invokespecial 213	com/amazonaws/services/kinesis/model/transform/PutRecordResultJsonUnmarshaller:<init>	()V
    //   86: invokespecial 216	com/amazonaws/http/JsonResponseHandler:<init>	(Lcom/amazonaws/transform/Unmarshaller;)V
    //   89: aload 4
    //   91: invokespecial 218	com/amazonaws/services/kinesis/AmazonKinesisClient:invoke	(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
    //   94: astore 4
    //   96: aload_3
    //   97: astore_1
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: invokevirtual 224	com/amazonaws/Response:getAwsResponse	()Ljava/lang/Object;
    //   106: checkcast 226	com/amazonaws/services/kinesis/model/PutRecordResult
    //   109: astore 5
    //   111: aload_0
    //   112: aload 6
    //   114: aload_3
    //   115: aload 4
    //   117: iconst_1
    //   118: invokevirtual 230	com/amazonaws/services/kinesis/AmazonKinesisClient:endClientExecution	(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
    //   121: aload 5
    //   123: areturn
    //   124: astore 4
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_3
    //   129: astore_1
    //   130: aload 5
    //   132: astore_2
    //   133: aload 6
    //   135: getstatic 197	com/amazonaws/util/AWSRequestMetrics$Field:RequestMarshallTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   138: invokevirtual 155	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   141: aload_3
    //   142: astore_1
    //   143: aload 5
    //   145: astore_2
    //   146: aload 4
    //   148: athrow
    //   149: astore 4
    //   151: aload_2
    //   152: astore_3
    //   153: aload_1
    //   154: astore_2
    //   155: aload 4
    //   157: astore_1
    //   158: aload_0
    //   159: aload 6
    //   161: aload_2
    //   162: aload_3
    //   163: iconst_1
    //   164: invokevirtual 230	com/amazonaws/services/kinesis/AmazonKinesisClient:endClientExecution	(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -14 -> 158
    //   175: astore 4
    //   177: goto -49 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	AmazonKinesisClient
    //   0	180	1	paramPutRecordRequest	com.amazonaws.services.kinesis.model.PutRecordRequest
    //   59	113	2	localObject1	Object
    //   1	162	3	localObject2	Object
    //   10	106	4	localObject3	Object
    //   124	23	4	localObject4	Object
    //   149	7	4	localObject5	Object
    //   175	1	4	localObject6	Object
    //   3	141	5	localPutRecordResult	com.amazonaws.services.kinesis.model.PutRecordResult
    //   17	143	6	localAWSRequestMetrics	AWSRequestMetrics
    // Exception table:
    //   from	to	target	type
    //   35	47	124	finally
    //   60	68	149	finally
    //   73	96	149	finally
    //   101	111	149	finally
    //   133	141	149	finally
    //   146	149	149	finally
    //   27	35	169	finally
    //   47	55	175	finally
  }
  
  public void setEndpoint(String paramString)
  {
    super.setEndpoint(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/services/kinesis/AmazonKinesisClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */