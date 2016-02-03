package org.osmdroid.contributor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.osmdroid.contributor.util.RecordedGeoPoint;
import org.osmdroid.contributor.util.RecordedRouteGPXFormatter;
import org.osmdroid.contributor.util.Util;
import org.osmdroid.contributor.util.constants.OpenStreetMapContributorConstants;

public class OSMUploader
  implements OpenStreetMapContributorConstants
{
  public static final String API_VERSION = "0.5";
  private static final String BASE64_ENC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  private static final String BOUNDARY = "----------------------------d10f7aa230e8";
  private static final int BUFFER_SIZE = 65535;
  private static final String DEFAULT_DESCRIPTION = "AndNav - automatically created route.";
  private static final String DEFAULT_TAGS = "AndNav";
  private static final String LINE_END = "\r\n";
  private static final SimpleDateFormat autoTagFormat = new SimpleDateFormat("MMMM yyyy");
  public static final SimpleDateFormat pseudoFileNameFormat = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
  
  private static String encodeBase64(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < (paramString.length() + 2) / 3)
    {
      int k = Math.min(3, paramString.length() - i * 3);
      String str = paramString.substring(i * 3, i * 3 + k);
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(str.charAt(0) >> '\002'));
      int m = str.charAt(0);
      int j;
      if (k == 1)
      {
        j = 0;
        label87:
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j | (m & 0x3) << 4));
        if (k <= 1) {
          break label218;
        }
        m = str.charAt(1);
        if (k != 2) {
          break label201;
        }
        j = 0;
        label128:
        c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j | (m & 0xF) << 2);
        label143:
        localStringBuilder.append(c);
        if (k <= 2) {
          break label224;
        }
      }
      label201:
      label218:
      label224:
      for (char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(str.charAt(2) & 0x3F);; c = '=')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
        j = (str.charAt(1) & 0xF0) >> '\004';
        break label87;
        j = (str.charAt(2) & 0xC0) >> '\006';
        break label128;
        c = '=';
        break label143;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void upload(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, ArrayList<RecordedGeoPoint> paramArrayList, String paramString5)
    throws IOException
  {
    uploadAsync(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramArrayList, paramString5);
  }
  
  public static void uploadAsync(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final boolean paramBoolean, ArrayList<RecordedGeoPoint> paramArrayList, final String paramString5)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while ((paramString2 == null) || (paramString2.length() == 0) || (paramString3 == null) || (paramString3.length() == 0) || (paramString4 == null) || (paramString4.length() == 0) || (paramString5 == null) || (paramString5.endsWith(".gpx"))) {
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        if (!Util.isSufficienDataForUpload(this.val$recordedGeoPoints)) {
          return;
        }
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(RecordedRouteGPXFormatter.create(this.val$recordedGeoPoints).getBytes());
        String str3 = paramString4;
        String str1;
        if (!paramBoolean)
        {
          str1 = str3;
          if (str3 != null) {}
        }
        else
        {
          if (str3 != null) {
            break label379;
          }
          str1 = OSMUploader.autoTagFormat.format(new GregorianCalendar().getTime());
        }
        for (;;)
        {
          try
          {
            if (paramString3 != null) {
              break label421;
            }
            str3 = "AndNav - automatically created route.";
          }
          catch (Exception localException)
          {
            int i;
            return;
          }
          HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://www.openstreetmap.org/api/0.5/gpx/create").openConnection();
          localHttpURLConnection.setConnectTimeout(15000);
          localHttpURLConnection.setRequestMethod("POST");
          localHttpURLConnection.setDoOutput(true);
          localHttpURLConnection.addRequestProperty("Authorization", "Basic " + OSMUploader.encodeBase64(new StringBuilder().append(paramString1).append(":").append(paramString2).toString()));
          localHttpURLConnection.addRequestProperty("Content-Type", "multipart/form-data; boundary=----------------------------d10f7aa230e8");
          localHttpURLConnection.addRequestProperty("Connection", "close");
          localHttpURLConnection.addRequestProperty("Expect", "");
          localHttpURLConnection.connect();
          DataOutputStream localDataOutputStream = new DataOutputStream(new BufferedOutputStream(localHttpURLConnection.getOutputStream()));
          OSMUploader.writeContentDispositionFile(localDataOutputStream, "file", localByteArrayInputStream, paramString5);
          OSMUploader.writeContentDisposition(localDataOutputStream, "description", str3);
          OSMUploader.writeContentDisposition(localDataOutputStream, "tags", str1);
          OSMUploader.writeContentDisposition(localDataOutputStream, "public", "1");
          localDataOutputStream.writeBytes("------------------------------d10f7aa230e8--\r\n");
          localDataOutputStream.flush();
          i = localHttpURLConnection.getResponseCode();
          str3 = localHttpURLConnection.getResponseMessage();
          label379:
          String str2;
          if (i != 200)
          {
            str1 = str3;
            if (localHttpURLConnection.getHeaderField("Error") != null) {
              str1 = str3 + "\n" + localHttpURLConnection.getHeaderField("Error");
            }
            localHttpURLConnection.disconnect();
            throw new RuntimeException(i + " " + str1);
            str2 = str3 + " " + OSMUploader.autoTagFormat.format(new GregorianCalendar().getTime());
            continue;
            label421:
            str3 = paramString3.replaceAll("\\.;&?,/", "_");
          }
          else
          {
            while (str2 != null)
            {
              str2 = str2.replaceAll("\\\\.;&?,/", "_");
              break;
              localDataOutputStream.close();
              localHttpURLConnection.disconnect();
              return;
            }
            str2 = "AndNav";
          }
        }
      }
    }, "OSMUpload-Thread").start();
  }
  
  public static void uploadAsync(String paramString1, String paramString2, boolean paramBoolean, ArrayList<RecordedGeoPoint> paramArrayList)
  {
    uploadAsync("PUT_YOUR_USERNAME_HERE", "PUT_YOUR_PASSWORD_HERE", paramString1, paramString2, paramBoolean, paramArrayList, pseudoFileNameFormat.format(new GregorianCalendar().getTime()) + "_" + "PUT_YOUR_USERNAME_HERE" + ".gpx");
  }
  
  public static void uploadAsync(ArrayList<RecordedGeoPoint> paramArrayList)
  {
    uploadAsync("AndNav - automatically created route.", "AndNav", true, paramArrayList);
  }
  
  private static void writeContentDisposition(DataOutputStream paramDataOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    paramDataOutputStream.writeBytes("------------------------------d10f7aa230e8\r\n");
    paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + paramString1 + "\"" + "\r\n");
    paramDataOutputStream.writeBytes("\r\n");
    paramDataOutputStream.writeBytes(paramString2 + "\r\n");
  }
  
  private static void writeContentDispositionFile(DataOutputStream paramDataOutputStream, String paramString1, InputStream paramInputStream, String paramString2)
    throws IOException
  {
    paramDataOutputStream.writeBytes("------------------------------d10f7aa230e8\r\n");
    paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + paramString1 + "\"; filename=\"" + paramString2 + "\"" + "\r\n");
    paramDataOutputStream.writeBytes("Content-Type: application/octet-stream\r\n");
    paramDataOutputStream.writeBytes("\r\n");
    paramString1 = new byte[65535];
    int i = 0;
    paramInputStream = new BufferedInputStream(paramInputStream);
    for (;;)
    {
      int j = paramInputStream.read(paramString1);
      if (j < 0) {
        break;
      }
      paramDataOutputStream.write(paramString1, 0, j);
      paramDataOutputStream.flush();
      i += j;
    }
    paramInputStream.close();
    paramDataOutputStream.writeBytes("\r\n");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/OSMUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */