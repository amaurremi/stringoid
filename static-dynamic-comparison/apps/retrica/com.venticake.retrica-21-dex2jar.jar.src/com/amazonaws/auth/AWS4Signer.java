package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.a.a.d.a;
import org.a.a.d.b;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AWS4Signer
  extends AbstractAWSSigner
  implements RegionAwareSigner, ServiceAwareSigner
{
  private static final b dateFormatter = a.a("yyyyMMdd").d();
  protected static final Log log = LogFactory.getLog(AWS4Signer.class);
  private static final b timeFormatter = a.a("yyyyMMdd'T'HHmmss'Z'").d();
  protected boolean doubleUrlEncode;
  protected Date overriddenDate;
  protected String regionName;
  protected String serviceName;
  
  public AWS4Signer()
  {
    this(true);
  }
  
  public AWS4Signer(boolean paramBoolean)
  {
    this.doubleUrlEncode = paramBoolean;
  }
  
  protected void addHostHeader(Request<?> paramRequest)
  {
    String str2 = paramRequest.getEndpoint().getHost();
    String str1 = str2;
    if (HttpUtils.isUsingNonDefaultPort(paramRequest.getEndpoint())) {
      str1 = str2 + ":" + paramRequest.getEndpoint().getPort();
    }
    paramRequest.addHeader("Host", str1);
  }
  
  protected void addSessionCredentials(Request<?> paramRequest, AWSSessionCredentials paramAWSSessionCredentials)
  {
    paramRequest.addHeader("x-amz-security-token", paramAWSSessionCredentials.getSessionToken());
  }
  
  protected String calculateContentHash(Request<?> paramRequest)
  {
    paramRequest = getBinaryRequestPayloadStream(paramRequest);
    paramRequest.mark(-1);
    String str = BinaryUtils.toHex(hash(paramRequest));
    try
    {
      paramRequest.reset();
      return str;
    }
    catch (IOException paramRequest)
    {
      throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", paramRequest);
    }
  }
  
  protected final AWS4Signer.HeaderSigningResult computeSignature(Request<?> paramRequest, String paramString1, String paramString2, String paramString3, String paramString4, AWSCredentials paramAWSCredentials)
  {
    String str2 = extractRegionName(paramRequest.getEndpoint());
    String str3 = extractServiceName(paramRequest.getEndpoint());
    String str1 = paramString1 + "/" + str2 + "/" + str3 + "/" + "aws4_request";
    paramRequest = getStringToSign(paramString3, paramString2, str1, getCanonicalRequest(paramRequest, paramString4));
    paramString1 = sign("aws4_request", sign(str3, sign(str2, sign(paramString1, ("AWS4" + paramAWSCredentials.getAWSSecretKey()).getBytes(), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256), SigningAlgorithm.HmacSHA256);
    return new AWS4Signer.HeaderSigningResult(paramString2, str1, paramString1, sign(paramRequest.getBytes(), paramString1, SigningAlgorithm.HmacSHA256));
  }
  
  protected String extractRegionName(URI paramURI)
  {
    if (this.regionName != null) {
      return this.regionName;
    }
    return AwsHostNameUtils.parseRegionName(paramURI.getHost(), this.serviceName);
  }
  
  protected String extractServiceName(URI paramURI)
  {
    if (this.serviceName != null) {
      return this.serviceName;
    }
    return AwsHostNameUtils.parseServiceName(paramURI);
  }
  
  protected String getCanonicalRequest(Request<?> paramRequest, String paramString)
  {
    String str = HttpUtils.appendUri(paramRequest.getEndpoint().getPath(), paramRequest.getResourcePath());
    paramRequest = paramRequest.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(str, this.doubleUrlEncode) + "\n" + getCanonicalizedQueryString(paramRequest) + "\n" + getCanonicalizedHeaderString(paramRequest) + "\n" + getSignedHeadersString(paramRequest) + "\n" + paramString;
    log.debug("AWS4 Canonical Request: '\"" + paramRequest + "\"");
    return paramRequest;
  }
  
  protected String getCanonicalizedHeaderString(Request<?> paramRequest)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(paramRequest.getHeaders().keySet());
    Collections.sort((List)localObject, String.CASE_INSENSITIVE_ORDER);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = (String)((Iterator)localObject).next();
      String str1 = str2.toLowerCase().replaceAll("\\s+", " ");
      str2 = (String)paramRequest.getHeaders().get(str2);
      localStringBuilder.append(str1).append(":");
      if (str2 != null) {
        localStringBuilder.append(str2.replaceAll("\\s+", " "));
      }
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
  
  protected final long getDateFromRequest(Request<?> paramRequest)
  {
    paramRequest = getSignatureDate(getTimeOffset(paramRequest));
    if (this.overriddenDate != null) {
      paramRequest = this.overriddenDate;
    }
    return paramRequest.getTime();
  }
  
  protected final String getDateStamp(long paramLong)
  {
    return dateFormatter.a(paramLong);
  }
  
  protected String getScope(Request<?> paramRequest, String paramString)
  {
    String str = extractRegionName(paramRequest.getEndpoint());
    paramRequest = extractServiceName(paramRequest.getEndpoint());
    return paramString + "/" + str + "/" + paramRequest + "/" + "aws4_request";
  }
  
  protected String getSignedHeadersString(Request<?> paramRequest)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(paramRequest.getHeaders().keySet());
    Collections.sort((List)localObject, String.CASE_INSENSITIVE_ORDER);
    paramRequest = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (paramRequest.length() > 0) {
        paramRequest.append(";");
      }
      paramRequest.append(str.toLowerCase());
    }
    return paramRequest.toString();
  }
  
  protected String getStringToSign(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = paramString1 + "\n" + paramString2 + "\n" + paramString3 + "\n" + BinaryUtils.toHex(hash(paramString4));
    log.debug("AWS4 String to Sign: '\"" + paramString1 + "\"");
    return paramString1;
  }
  
  protected final String getTimeStamp(long paramLong)
  {
    return timeFormatter.a(paramLong);
  }
  
  protected void processRequestPayload(Request<?> paramRequest, AWS4Signer.HeaderSigningResult paramHeaderSigningResult) {}
  
  public void setRegionName(String paramString)
  {
    this.regionName = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void sign(Request<?> paramRequest, AWSCredentials paramAWSCredentials)
  {
    if ((paramAWSCredentials instanceof AnonymousAWSCredentials)) {
      return;
    }
    paramAWSCredentials = sanitizeCredentials(paramAWSCredentials);
    if ((paramAWSCredentials instanceof AWSSessionCredentials)) {
      addSessionCredentials(paramRequest, (AWSSessionCredentials)paramAWSCredentials);
    }
    addHostHeader(paramRequest);
    long l = getDateFromRequest(paramRequest);
    String str1 = getDateStamp(l);
    String str4 = getScope(paramRequest, str1);
    String str2 = calculateContentHash(paramRequest);
    String str3 = getTimeStamp(l);
    paramRequest.addHeader("X-Amz-Date", str3);
    if ((paramRequest.getHeaders().get("x-amz-content-sha256") != null) && (((String)paramRequest.getHeaders().get("x-amz-content-sha256")).equals("required"))) {
      paramRequest.addHeader("x-amz-content-sha256", str2);
    }
    str4 = paramAWSCredentials.getAWSAccessKeyId() + "/" + str4;
    paramAWSCredentials = computeSignature(paramRequest, str1, str3, "AWS4-HMAC-SHA256", str2, paramAWSCredentials);
    str1 = "Credential=" + str4;
    str2 = "SignedHeaders=" + getSignedHeadersString(paramRequest);
    str3 = "Signature=" + BinaryUtils.toHex(paramAWSCredentials.getSignature());
    paramRequest.addHeader("Authorization", "AWS4-HMAC-SHA256 " + str1 + ", " + str2 + ", " + str3);
    processRequestPayload(paramRequest, paramAWSCredentials);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AWS4Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */