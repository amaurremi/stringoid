package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.Request<*>;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class QueryStringSigner
  extends AbstractAWSSigner
  implements Signer
{
  private Date overriddenDate;
  
  private String calculateStringToSignV1(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    ((SortedMap)localObject).putAll(paramMap);
    paramMap = ((SortedMap)localObject).entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)((Map.Entry)localObject).getKey());
      localStringBuilder.append((String)((Map.Entry)localObject).getValue());
    }
    return localStringBuilder.toString();
  }
  
  private String calculateStringToSignV2(Request<?> paramRequest)
  {
    URI localURI = paramRequest.getEndpoint();
    Map localMap = paramRequest.getParameters();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("POST").append("\n");
    localStringBuilder.append(getCanonicalizedEndpoint(localURI)).append("\n");
    localStringBuilder.append(getCanonicalizedResourcePath(paramRequest)).append("\n");
    localStringBuilder.append(getCanonicalizedQueryString(localMap));
    return localStringBuilder.toString();
  }
  
  private String getCanonicalizedResourcePath(Request<?> paramRequest)
  {
    Object localObject1 = "";
    if (paramRequest.getEndpoint().getPath() != null) {
      localObject1 = "" + paramRequest.getEndpoint().getPath();
    }
    if (paramRequest.getResourcePath() != null)
    {
      Object localObject2 = localObject1;
      if (((String)localObject1).length() > 0)
      {
        localObject2 = localObject1;
        if (!((String)localObject1).endsWith("/"))
        {
          localObject2 = localObject1;
          if (!paramRequest.getResourcePath().startsWith("/")) {
            localObject2 = (String)localObject1 + "/";
          }
        }
      }
      paramRequest = (String)localObject2 + paramRequest.getResourcePath();
    }
    for (;;)
    {
      localObject1 = paramRequest;
      if (!paramRequest.startsWith("/")) {
        localObject1 = "/" + paramRequest;
      }
      paramRequest = (Request<?>)localObject1;
      if (((String)localObject1).startsWith("//")) {
        paramRequest = ((String)localObject1).substring(1);
      }
      return paramRequest;
      paramRequest = (Request<?>)localObject1;
      if (!((String)localObject1).endsWith("/")) {
        paramRequest = (String)localObject1 + "/";
      }
    }
  }
  
  private String getFormattedTimestamp(int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    if (this.overriddenDate != null) {
      return localSimpleDateFormat.format(this.overriddenDate);
    }
    return localSimpleDateFormat.format(getSignatureDate(paramInt));
  }
  
  protected void addSessionCredentials(Request<?> paramRequest, AWSSessionCredentials paramAWSSessionCredentials)
  {
    paramRequest.addParameter("SecurityToken", paramAWSSessionCredentials.getSessionToken());
  }
  
  public void sign(Request<?> paramRequest, AWSCredentials paramAWSCredentials)
  {
    sign(paramRequest, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, paramAWSCredentials);
  }
  
  public void sign(Request<?> paramRequest, SignatureVersion paramSignatureVersion, SigningAlgorithm paramSigningAlgorithm, AWSCredentials paramAWSCredentials)
  {
    if ((paramAWSCredentials instanceof AnonymousAWSCredentials)) {
      return;
    }
    paramAWSCredentials = sanitizeCredentials(paramAWSCredentials);
    paramRequest.addParameter("AWSAccessKeyId", paramAWSCredentials.getAWSAccessKeyId());
    paramRequest.addParameter("SignatureVersion", paramSignatureVersion.toString());
    paramRequest.addParameter("Timestamp", getFormattedTimestamp(getTimeOffset(paramRequest)));
    if ((paramAWSCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(paramRequest, (AWSSessionCredentials)paramAWSCredentials);
    }
    if (paramSignatureVersion.equals(SignatureVersion.V1)) {}
    for (paramSignatureVersion = calculateStringToSignV1(paramRequest.getParameters());; paramSignatureVersion = calculateStringToSignV2(paramRequest))
    {
      paramRequest.addParameter("Signature", signAndBase64Encode(paramSignatureVersion, paramAWSCredentials.getAWSSecretKey(), paramSigningAlgorithm));
      return;
      if (!paramSignatureVersion.equals(SignatureVersion.V2)) {
        break;
      }
      paramRequest.addParameter("SignatureMethod", paramSigningAlgorithm.toString());
    }
    throw new AmazonClientException("Invalid Signature Version specified");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/QueryStringSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */