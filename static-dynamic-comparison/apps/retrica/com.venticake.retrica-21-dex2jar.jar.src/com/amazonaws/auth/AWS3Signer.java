package com.amazonaws.auth;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AWS3Signer
  extends AbstractAWSSigner
{
  @Deprecated
  protected static final DateUtils dateUtils = new DateUtils();
  private static final Log log = LogFactory.getLog(AWS3Signer.class);
  private String overriddenDate;
  
  private String getSignedHeadersComponent(Request<?> paramRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SignedHeaders=");
    paramRequest = getHeadersForStringToSign(paramRequest).iterator();
    for (int i = 1; paramRequest.hasNext(); i = 0)
    {
      String str = (String)paramRequest.next();
      if (i == 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  protected void addSessionCredentials(Request<?> paramRequest, AWSSessionCredentials paramAWSSessionCredentials)
  {
    paramRequest.addHeader("x-amz-security-token", paramAWSSessionCredentials.getSessionToken());
  }
  
  protected String getCanonicalizedHeadersForStringToSign(Request<?> paramRequest)
  {
    Object localObject2 = getHeadersForStringToSign(paramRequest);
    int i = 0;
    while (i < ((List)localObject2).size())
    {
      ((List)localObject2).set(i, ((String)((List)localObject2).get(i)).toLowerCase());
      i += 1;
    }
    Object localObject1 = new TreeMap();
    paramRequest = paramRequest.getHeaders().entrySet().iterator();
    while (paramRequest.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramRequest.next();
      if (((List)localObject2).contains(((String)localEntry.getKey()).toLowerCase())) {
        ((SortedMap)localObject1).put(((String)localEntry.getKey()).toLowerCase(), localEntry.getValue());
      }
    }
    paramRequest = new StringBuilder();
    localObject1 = ((SortedMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramRequest.append(((String)((Map.Entry)localObject2).getKey()).toLowerCase()).append(":").append((String)((Map.Entry)localObject2).getValue()).append("\n");
    }
    return paramRequest.toString();
  }
  
  protected List<String> getHeadersForStringToSign(Request<?> paramRequest)
  {
    ArrayList localArrayList = new ArrayList();
    paramRequest = paramRequest.getHeaders().entrySet().iterator();
    while (paramRequest.hasNext())
    {
      String str1 = (String)((Map.Entry)paramRequest.next()).getKey();
      String str2 = str1.toLowerCase();
      if ((str2.startsWith("x-amz")) || (str2.equals("host"))) {
        localArrayList.add(str1);
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public void sign(Request<?> paramRequest, AWSCredentials paramAWSCredentials)
  {
    if ((paramAWSCredentials instanceof AnonymousAWSCredentials)) {
      return;
    }
    AWSCredentials localAWSCredentials = sanitizeCredentials(paramAWSCredentials);
    SigningAlgorithm localSigningAlgorithm = SigningAlgorithm.HmacSHA256;
    UUID.randomUUID().toString();
    paramAWSCredentials = DateUtils.formatRFC822Date(getSignatureDate(getTimeOffset(paramRequest)));
    if (this.overriddenDate != null) {
      paramAWSCredentials = this.overriddenDate;
    }
    paramRequest.addHeader("Date", paramAWSCredentials);
    paramRequest.addHeader("X-Amz-Date", paramAWSCredentials);
    Object localObject = paramRequest.getEndpoint().getHost();
    paramAWSCredentials = (AWSCredentials)localObject;
    if (HttpUtils.isUsingNonDefaultPort(paramRequest.getEndpoint())) {
      paramAWSCredentials = (String)localObject + ":" + paramRequest.getEndpoint().getPort();
    }
    paramRequest.addHeader("Host", paramAWSCredentials);
    if ((localAWSCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(paramRequest, (AWSSessionCredentials)localAWSCredentials);
    }
    paramAWSCredentials = HttpUtils.appendUri(paramRequest.getEndpoint().getPath(), paramRequest.getResourcePath());
    paramAWSCredentials = paramRequest.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(paramAWSCredentials) + "\n" + getCanonicalizedQueryString(paramRequest.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(paramRequest) + "\n" + getRequestPayloadWithoutQueryParams(paramRequest);
    localObject = hash(paramAWSCredentials);
    log.debug("Calculated StringToSign: " + paramAWSCredentials);
    paramAWSCredentials = signAndBase64Encode((byte[])localObject, localAWSCredentials.getAWSSecretKey(), localSigningAlgorithm);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AWS3").append(" ");
    ((StringBuilder)localObject).append("AWSAccessKeyId=" + localAWSCredentials.getAWSAccessKeyId() + ",");
    ((StringBuilder)localObject).append("Algorithm=" + localSigningAlgorithm.toString() + ",");
    ((StringBuilder)localObject).append(getSignedHeadersComponent(paramRequest) + ",");
    ((StringBuilder)localObject).append("Signature=" + paramAWSCredentials);
    paramRequest.addHeader("X-Amzn-Authorization", ((StringBuilder)localObject).toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AWS3Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */