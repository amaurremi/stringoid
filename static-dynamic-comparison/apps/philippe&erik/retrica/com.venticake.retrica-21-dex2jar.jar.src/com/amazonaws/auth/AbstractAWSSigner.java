package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractAWSSigner
  implements Signer
{
  protected InputStream getBinaryRequestPayloadStream(Request<?> paramRequest)
  {
    if (HttpUtils.usePayloadForQueryParameters(paramRequest))
    {
      paramRequest = HttpUtils.encodeParameters(paramRequest);
      if (paramRequest == null) {
        return new ByteArrayInputStream(new byte[0]);
      }
      return new ByteArrayInputStream(paramRequest.getBytes(StringUtils.UTF8));
    }
    return getBinaryRequestPayloadStreamWithoutQueryParams(paramRequest);
  }
  
  protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> paramRequest)
  {
    try
    {
      InputStream localInputStream2 = paramRequest.getContent();
      if (localInputStream2 == null) {
        return new ByteArrayInputStream(new byte[0]);
      }
      localInputStream1 = localInputStream2;
      if ((localInputStream2 instanceof StringInputStream)) {
        return localInputStream1;
      }
      if (!localInputStream2.markSupported()) {
        throw new AmazonClientException("Unable to read request payload to sign request.");
      }
    }
    catch (Exception paramRequest)
    {
      throw new AmazonClientException("Unable to read request payload to sign request: " + paramRequest.getMessage(), paramRequest);
    }
    InputStream localInputStream1 = paramRequest.getContent();
    return localInputStream1;
  }
  
  /* Error */
  protected byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> paramRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 43	com/amazonaws/auth/AbstractAWSSigner:getBinaryRequestPayloadStreamWithoutQueryParams	(Lcom/amazonaws/Request;)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_1
    //   7: iconst_m1
    //   8: invokevirtual 93	java/io/InputStream:mark	(I)V
    //   11: new 95	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 96	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_3
    //   19: sipush 5120
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload_1
    //   27: aload 4
    //   29: invokevirtual 100	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpne +16 -> 51
    //   38: aload_3
    //   39: invokevirtual 103	java/io/ByteArrayOutputStream:close	()V
    //   42: aload_1
    //   43: invokevirtual 106	java/io/InputStream:reset	()V
    //   46: aload_3
    //   47: invokevirtual 110	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   50: areturn
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 114	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -33 -> 26
    //   62: astore_1
    //   63: new 63	com/amazonaws/AmazonClientException
    //   66: dup
    //   67: new 70	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   74: ldc 73
    //   76: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 81	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   83: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: aload_1
    //   90: invokespecial 87	com/amazonaws/AmazonClientException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	AbstractAWSSigner
    //   0	94	1	paramRequest	Request<?>
    //   32	24	2	i	int
    //   18	34	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   24	29	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	26	62	java/lang/Exception
    //   26	33	62	java/lang/Exception
    //   38	51	62	java/lang/Exception
    //   51	59	62	java/lang/Exception
  }
  
  protected String getCanonicalizedEndpoint(URI paramURI)
  {
    String str2 = paramURI.getHost().toLowerCase();
    String str1 = str2;
    if (HttpUtils.isUsingNonDefaultPort(paramURI)) {
      str1 = str2 + ":" + paramURI.getPort();
    }
    return str1;
  }
  
  protected String getCanonicalizedQueryString(Request<?> paramRequest)
  {
    if (HttpUtils.usePayloadForQueryParameters(paramRequest)) {
      return "";
    }
    return getCanonicalizedQueryString(paramRequest.getParameters());
  }
  
  protected String getCanonicalizedQueryString(Map<String, String> paramMap)
  {
    Object localObject1 = new TreeMap();
    paramMap = paramMap.entrySet().iterator();
    Object localObject2;
    while (paramMap.hasNext())
    {
      Object localObject3 = (Map.Entry)paramMap.next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      ((SortedMap)localObject1).put(HttpUtils.urlEncode((String)localObject2, false), HttpUtils.urlEncode((String)localObject3, false));
    }
    paramMap = new StringBuilder();
    localObject1 = ((SortedMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramMap.append((String)((Map.Entry)localObject2).getKey());
      paramMap.append("=");
      paramMap.append((String)((Map.Entry)localObject2).getValue());
      if (((Iterator)localObject1).hasNext()) {
        paramMap.append("&");
      }
    }
    return paramMap.toString();
  }
  
  protected String getCanonicalizedResourcePath(String paramString)
  {
    return getCanonicalizedResourcePath(paramString, true);
  }
  
  protected String getCanonicalizedResourcePath(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "/";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramBoolean) {
        str = HttpUtils.urlEncode(paramString, true);
      }
      paramString = str;
    } while (str.startsWith("/"));
    return "/".concat(str);
  }
  
  protected String getRequestPayloadWithoutQueryParams(Request<?> paramRequest)
  {
    return newString(getBinaryRequestPayloadWithoutQueryParams(paramRequest));
  }
  
  protected Date getSignatureDate(int paramInt)
  {
    Date localDate2 = new Date();
    Date localDate1 = localDate2;
    if (paramInt != 0) {
      localDate1 = new Date(localDate2.getTime() - paramInt * 1000);
    }
    return localDate1;
  }
  
  protected int getTimeOffset(Request<?> paramRequest)
  {
    int i = paramRequest.getTimeOffset();
    if (SDKGlobalConfiguration.getGlobalTimeOffset() != 0) {
      i = SDKGlobalConfiguration.getGlobalTimeOffset();
    }
    return i;
  }
  
  protected byte[] hash(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new SdkDigestInputStream(paramInputStream, MessageDigest.getInstance("SHA-256"));
      byte[] arrayOfByte = new byte['Ѐ'];
      while (paramInputStream.read(arrayOfByte) > -1) {}
      paramInputStream = paramInputStream.getMessageDigest().digest();
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      throw new AmazonClientException("Unable to compute hash while signing request: " + paramInputStream.getMessage(), paramInputStream);
    }
  }
  
  public byte[] hash(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes(StringUtils.UTF8));
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new AmazonClientException("Unable to compute hash while signing request: " + paramString.getMessage(), paramString);
    }
  }
  
  protected String newString(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, StringUtils.UTF8);
  }
  
  protected AWSCredentials sanitizeCredentials(AWSCredentials paramAWSCredentials)
  {
    String str1 = null;
    label108:
    label111:
    for (;;)
    {
      String str3;
      String str2;
      try
      {
        str3 = paramAWSCredentials.getAWSAccessKeyId();
        str2 = paramAWSCredentials.getAWSSecretKey();
        if ((paramAWSCredentials instanceof AWSSessionCredentials)) {
          str1 = ((AWSSessionCredentials)paramAWSCredentials).getSessionToken();
        }
        if (str2 == null) {
          break label111;
        }
        str2 = str2.trim();
        if (str3 == null) {
          break label108;
        }
        str3 = str3.trim();
        String str4 = str1;
        if (str1 != null) {
          str4 = str1.trim();
        }
        if ((paramAWSCredentials instanceof AWSSessionCredentials)) {
          return new BasicSessionCredentials(str3, str2, str4);
        }
      }
      finally {}
      return new BasicAWSCredentials(str3, str2);
    }
  }
  
  public byte[] sign(String paramString, byte[] paramArrayOfByte, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      paramString = sign(paramString.getBytes(StringUtils.UTF8), paramArrayOfByte, paramSigningAlgorithm);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new AmazonClientException("Unable to calculate a request signature: " + paramString.getMessage(), paramString);
    }
  }
  
  protected byte[] sign(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramSigningAlgorithm.toString());
      localMac.init(new SecretKeySpec(paramArrayOfByte2, paramSigningAlgorithm.toString()));
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new AmazonClientException("Unable to calculate a request signature: " + paramArrayOfByte1.getMessage(), paramArrayOfByte1);
    }
  }
  
  protected String signAndBase64Encode(String paramString1, String paramString2, SigningAlgorithm paramSigningAlgorithm)
  {
    return signAndBase64Encode(paramString1.getBytes(StringUtils.UTF8), paramString2, paramSigningAlgorithm);
  }
  
  protected String signAndBase64Encode(byte[] paramArrayOfByte, String paramString, SigningAlgorithm paramSigningAlgorithm)
  {
    try
    {
      paramArrayOfByte = Base64.encodeAsString(sign(paramArrayOfByte, paramString.getBytes(StringUtils.UTF8), paramSigningAlgorithm));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new AmazonClientException("Unable to calculate a request signature: " + paramArrayOfByte.getMessage(), paramArrayOfByte);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/auth/AbstractAWSSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */