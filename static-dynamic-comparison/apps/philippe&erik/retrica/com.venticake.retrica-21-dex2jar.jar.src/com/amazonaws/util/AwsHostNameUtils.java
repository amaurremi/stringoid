package com.amazonaws.util;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AwsHostNameUtils
{
  private static final Pattern S3_ENDPOINT_PATTERN = Pattern.compile("^(?:.+\\.)?s3[.-]([a-z0-9-]+)$");
  
  public static String parseRegionName(String paramString1, String paramString2)
  {
    if (paramString1.endsWith(".amazonaws.com")) {
      return parseStandardRegionName(paramString1.substring(0, paramString1.length() - ".amazonaws.com".length()));
    }
    if (paramString2 != null)
    {
      paramString1 = Pattern.compile("^(?:.+\\.)?" + Pattern.quote(paramString2) + "[.-]([a-z0-9-]+)\\.").matcher(paramString1);
      if (paramString1.find()) {
        return paramString1.group(1);
      }
    }
    return "us-east-1";
  }
  
  @Deprecated
  public static String parseServiceName(URI paramURI)
  {
    paramURI = paramURI.getHost();
    if (!paramURI.endsWith(".amazonaws.com")) {
      throw new IllegalArgumentException("Cannot parse a service name from an unrecognized endpoint (" + paramURI + ").");
    }
    String str = paramURI.substring(0, paramURI.indexOf(".amazonaws.com"));
    if ((str.endsWith(".s3")) || (S3_ENDPOINT_PATTERN.matcher(str).matches())) {
      paramURI = "s3";
    }
    do
    {
      return paramURI;
      paramURI = str;
    } while (str.indexOf('.') == -1);
    return str.substring(0, str.indexOf('.'));
  }
  
  private static String parseStandardRegionName(String paramString)
  {
    if ((paramString.endsWith(".s3")) || (paramString.endsWith(".s3-external-1"))) {
      paramString = "us-east-1";
    }
    Object localObject;
    do
    {
      return paramString;
      localObject = S3_ENDPOINT_PATTERN.matcher(paramString);
      if (((Matcher)localObject).matches()) {
        return ((Matcher)localObject).group(1);
      }
      int i = paramString.lastIndexOf('.');
      if (i == -1) {
        return "us-east-1";
      }
      localObject = paramString.substring(i + 1);
      paramString = (String)localObject;
    } while (!"us-gov".equals(localObject));
    return "us-gov-west-1";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/AwsHostNameUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */