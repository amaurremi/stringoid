package mobi.beyondpod.downloadengine;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class DownloadStatisticsList
  extends ArrayList<DownloadStatistics>
{
  private static final long serialVersionUID = -2204644015452124422L;
  public Date DownloadTime;
  public boolean IsUnattended;
  
  public void ClearStatistics()
  {
    clear();
    this.DownloadTime = null;
  }
  
  public List<DownloadStatistics> GetFailedDownloads()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i == size()) {
      return localArrayList;
    }
    DownloadStatistics localDownloadStatistics1 = (DownloadStatistics)get(i);
    if (i + 1 < size())
    {
      DownloadStatistics localDownloadStatistics2 = (DownloadStatistics)get(i + 1);
      if (!StringUtils.Equals(localDownloadStatistics1.Url, localDownloadStatistics2.Url)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      if ((localDownloadStatistics1 != null) && (localDownloadStatistics1.HasErrors())) {
        localArrayList.add(localDownloadStatistics1);
      }
    }
  }
  
  public List<DownloadStatistics> GetSuccesfulDownloads()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      DownloadStatistics localDownloadStatistics = (DownloadStatistics)localIterator.next();
      if ((localDownloadStatistics != null) && (!localDownloadStatistics.HasErrors())) {
        localArrayList.add(localDownloadStatistics);
      }
    }
  }
  
  public boolean HasAnyFailedDownloads()
  {
    return GetFailedDownloads().size() > 0;
  }
  
  public boolean HasAnyReaderLoginFalures()
  {
    int i = 0;
    if (i == size()) {
      return false;
    }
    DownloadStatistics localDownloadStatistics1 = (DownloadStatistics)get(i);
    if (i + 1 < size())
    {
      DownloadStatistics localDownloadStatistics2 = (DownloadStatistics)get(i + 1);
      if (!StringUtils.Equals(localDownloadStatistics1.Url, localDownloadStatistics2.Url)) {}
    }
    while ((localDownloadStatistics1 == null) || (!localDownloadStatistics1.InidicatesReaderLoginFailure()))
    {
      i += 1;
      break;
    }
    return true;
  }
  
  public boolean HasAnySDCardCorruptionFalures()
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((DownloadStatistics)localIterator.next()).InidicatesSDCardCorruption());
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator;
    if (size() > 0)
    {
      localIterator = iterator();
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(((DownloadStatistics)localIterator.next()).toString());
      break;
      localStringBuilder.append("No feeds were Updated");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/DownloadStatisticsList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */