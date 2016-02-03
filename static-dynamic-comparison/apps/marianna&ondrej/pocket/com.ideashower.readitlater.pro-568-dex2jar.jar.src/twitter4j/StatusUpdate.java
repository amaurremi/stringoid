package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

public final class StatusUpdate
  implements Serializable
{
  private static final long serialVersionUID = -3595502688477609916L;
  private boolean displayCoordinates = true;
  private long inReplyToStatusId = -1L;
  private GeoLocation location = null;
  private transient InputStream mediaBody;
  private File mediaFile;
  private String mediaName;
  private String placeId = null;
  private boolean possiblySensitive;
  private String status;
  
  public StatusUpdate(String paramString)
  {
    this.status = paramString;
  }
  
  private void appendParameter(String paramString, double paramDouble, List paramList)
  {
    paramList.add(new HttpParameter(paramString, String.valueOf(paramDouble)));
  }
  
  private void appendParameter(String paramString, long paramLong, List paramList)
  {
    paramList.add(new HttpParameter(paramString, String.valueOf(paramLong)));
  }
  
  private void appendParameter(String paramString1, String paramString2, List paramList)
  {
    if (paramString2 != null) {
      paramList.add(new HttpParameter(paramString1, paramString2));
    }
  }
  
  HttpParameter[] asHttpParameterArray()
  {
    ArrayList localArrayList = new ArrayList();
    appendParameter("status", this.status, localArrayList);
    if (-1L != this.inReplyToStatusId) {
      appendParameter("in_reply_to_status_id", this.inReplyToStatusId, localArrayList);
    }
    if (this.location != null)
    {
      appendParameter("lat", this.location.getLatitude(), localArrayList);
      appendParameter("long", this.location.getLongitude(), localArrayList);
    }
    appendParameter("place_id", this.placeId, localArrayList);
    if (!this.displayCoordinates) {
      appendParameter("display_coordinates", "false", localArrayList);
    }
    if (this.mediaFile != null)
    {
      localArrayList.add(new HttpParameter("media[]", this.mediaFile));
      localArrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
    }
    for (;;)
    {
      return (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]);
      if ((this.mediaName != null) && (this.mediaBody != null))
      {
        localArrayList.add(new HttpParameter("media[]", this.mediaName, this.mediaBody));
        localArrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
      }
    }
  }
  
  public StatusUpdate displayCoordinates(boolean paramBoolean)
  {
    setDisplayCoordinates(paramBoolean);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (StatusUpdate)paramObject;
      if (this.displayCoordinates != ((StatusUpdate)paramObject).displayCoordinates) {
        return false;
      }
      if (this.inReplyToStatusId != ((StatusUpdate)paramObject).inReplyToStatusId) {
        return false;
      }
      if (this.possiblySensitive != ((StatusUpdate)paramObject).possiblySensitive) {
        return false;
      }
      if (this.location != null)
      {
        if (this.location.equals(((StatusUpdate)paramObject).location)) {}
      }
      else {
        while (((StatusUpdate)paramObject).location != null) {
          return false;
        }
      }
      if (this.mediaBody != null)
      {
        if (this.mediaBody.equals(((StatusUpdate)paramObject).mediaBody)) {}
      }
      else {
        while (((StatusUpdate)paramObject).mediaBody != null) {
          return false;
        }
      }
      if (this.mediaFile != null)
      {
        if (this.mediaFile.equals(((StatusUpdate)paramObject).mediaFile)) {}
      }
      else {
        while (((StatusUpdate)paramObject).mediaFile != null) {
          return false;
        }
      }
      if (this.mediaName != null)
      {
        if (this.mediaName.equals(((StatusUpdate)paramObject).mediaName)) {}
      }
      else {
        while (((StatusUpdate)paramObject).mediaName != null) {
          return false;
        }
      }
      if (this.placeId != null)
      {
        if (this.placeId.equals(((StatusUpdate)paramObject).placeId)) {}
      }
      else {
        while (((StatusUpdate)paramObject).placeId != null) {
          return false;
        }
      }
      if (this.status == null) {
        break;
      }
    } while (this.status.equals(((StatusUpdate)paramObject).status));
    for (;;)
    {
      return false;
      if (((StatusUpdate)paramObject).status == null) {
        break;
      }
    }
  }
  
  public long getInReplyToStatusId()
  {
    return this.inReplyToStatusId;
  }
  
  public GeoLocation getLocation()
  {
    return this.location;
  }
  
  public String getPlaceId()
  {
    return this.placeId;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    int n = 1;
    int i3 = 0;
    int i;
    int i4;
    int j;
    label51:
    int k;
    label66:
    int m;
    label76:
    label83:
    int i1;
    if (this.status != null)
    {
      i = this.status.hashCode();
      i4 = (int)(this.inReplyToStatusId ^ this.inReplyToStatusId >>> 32);
      if (this.location == null) {
        break label184;
      }
      j = this.location.hashCode();
      if (this.placeId == null) {
        break label189;
      }
      k = this.placeId.hashCode();
      if (!this.displayCoordinates) {
        break label194;
      }
      m = 1;
      if (!this.possiblySensitive) {
        break label200;
      }
      if (this.mediaName == null) {
        break label206;
      }
      i1 = this.mediaName.hashCode();
      label99:
      if (this.mediaBody == null) {
        break label212;
      }
    }
    label184:
    label189:
    label194:
    label200:
    label206:
    label212:
    for (int i2 = this.mediaBody.hashCode();; i2 = 0)
    {
      if (this.mediaFile != null) {
        i3 = this.mediaFile.hashCode();
      }
      return (i2 + (i1 + ((m + (k + (j + (i * 31 + i4) * 31) * 31) * 31) * 31 + n) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label66;
      m = 0;
      break label76;
      n = 0;
      break label83;
      i1 = 0;
      break label99;
    }
  }
  
  public StatusUpdate inReplyToStatusId(long paramLong)
  {
    setInReplyToStatusId(paramLong);
    return this;
  }
  
  public boolean isDisplayCoordinates()
  {
    return this.displayCoordinates;
  }
  
  public boolean isPossiblySensitive()
  {
    return this.possiblySensitive;
  }
  
  boolean isWithMedia()
  {
    return (this.mediaFile != null) || (this.mediaName != null);
  }
  
  public StatusUpdate location(GeoLocation paramGeoLocation)
  {
    setLocation(paramGeoLocation);
    return this;
  }
  
  public StatusUpdate media(File paramFile)
  {
    setMedia(paramFile);
    return this;
  }
  
  public StatusUpdate media(String paramString, InputStream paramInputStream)
  {
    setMedia(paramString, paramInputStream);
    return this;
  }
  
  public StatusUpdate placeId(String paramString)
  {
    setPlaceId(paramString);
    return this;
  }
  
  public StatusUpdate possiblySensitive(boolean paramBoolean)
  {
    setPossiblySensitive(paramBoolean);
    return this;
  }
  
  public void setDisplayCoordinates(boolean paramBoolean)
  {
    this.displayCoordinates = paramBoolean;
  }
  
  public void setInReplyToStatusId(long paramLong)
  {
    this.inReplyToStatusId = paramLong;
  }
  
  public void setLocation(GeoLocation paramGeoLocation)
  {
    this.location = paramGeoLocation;
  }
  
  public void setMedia(File paramFile)
  {
    this.mediaFile = paramFile;
  }
  
  public void setMedia(String paramString, InputStream paramInputStream)
  {
    this.mediaName = paramString;
    this.mediaBody = paramInputStream;
  }
  
  public void setPlaceId(String paramString)
  {
    this.placeId = paramString;
  }
  
  public void setPossiblySensitive(boolean paramBoolean)
  {
    this.possiblySensitive = paramBoolean;
  }
  
  public String toString()
  {
    return "StatusUpdate{status='" + this.status + '\'' + ", inReplyToStatusId=" + this.inReplyToStatusId + ", location=" + this.location + ", placeId='" + this.placeId + '\'' + ", displayCoordinates=" + this.displayCoordinates + ", possiblySensitive=" + this.possiblySensitive + ", mediaName='" + this.mediaName + '\'' + ", mediaBody=" + this.mediaBody + ", mediaFile=" + this.mediaFile + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/StatusUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */