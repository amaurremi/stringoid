package org.osmdroid.contributor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.params.HttpParams;
import org.osmdroid.contributor.util.RecordedGeoPoint;
import org.osmdroid.contributor.util.RecordedRouteGPXFormatter;
import org.osmdroid.contributor.util.Util;
import org.osmdroid.http.HttpClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GpxToPHPUploader
{
  protected static final String UPLOADSCRIPT_URL = "http://www.PLACEYOURDOMAINHERE.com/anyfolder/gpxuploader/upload.php";
  private static final Logger logger = LoggerFactory.getLogger(GpxToPHPUploader.class);
  
  public static void uploadAsync(ArrayList<RecordedGeoPoint> paramArrayList)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if (!Util.isSufficienDataForUpload(this.val$recordedGeoPoints)) {
            return;
          }
          Object localObject1 = new ByteArrayInputStream(RecordedRouteGPXFormatter.create(this.val$recordedGeoPoints).getBytes());
          Object localObject2 = HttpClientFactory.createHttpClient();
          Object localObject3 = new HttpPost("http://www.PLACEYOURDOMAINHERE.com/anyfolder/gpxuploader/upload.php");
          MultipartEntity localMultipartEntity = new MultipartEntity();
          localMultipartEntity.addPart("gpxfile", new InputStreamBody((InputStream)localObject1, "" + System.currentTimeMillis() + ".gpx"));
          ((HttpClient)localObject2).getParams().setBooleanParameter("http.protocol.expect-continue", false);
          ((HttpPost)localObject3).setEntity(localMultipartEntity);
          localObject1 = ((HttpClient)localObject2).execute((HttpUriRequest)localObject3);
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200)
          {
            GpxToPHPUploader.logger.error("GPXUploader", "status != HttpStatus.SC_OK");
            return;
          }
          localObject1 = new InputStreamReader(new BufferedInputStream(((HttpResponse)localObject1).getEntity().getContent()));
          localObject2 = new char[' '];
          localObject3 = new StringBuilder();
          for (;;)
          {
            int i = ((Reader)localObject1).read((char[])localObject2);
            if (i == -1) {
              break;
            }
            ((StringBuilder)localObject3).append((char[])localObject2, 0, i);
          }
          GpxToPHPUploader.logger.debug("GPXUploader", "Response: " + ((StringBuilder)localObject3).toString());
          return;
        }
        catch (Exception localException) {}
      }
    }).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/GpxToPHPUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */