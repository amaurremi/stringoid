package mobi.beyondpod.sync.trackers.bp;

import java.util.Date;

public class DeviceActivity
{
  private String data;
  private Date dateTime;
  private String device;
  private String type;
  
  public String getData()
  {
    return this.data;
  }
  
  public Date getDateTime()
  {
    return this.dateTime;
  }
  
  public String getDevice()
  {
    return this.device;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setDateTime(Date paramDate)
  {
    this.dateTime = paramDate;
  }
  
  public void setDevice(String paramString)
  {
    this.device = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/sync/trackers/bp/DeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */