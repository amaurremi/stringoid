package android.support.v7.media;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaRouteProviderDescriptor
{
  private static final String KEY_ROUTES = "routes";
  private final Bundle mBundle;
  private List<MediaRouteDescriptor> mRoutes;
  
  private MediaRouteProviderDescriptor(Bundle paramBundle, List<MediaRouteDescriptor> paramList)
  {
    this.mBundle = paramBundle;
    this.mRoutes = paramList;
  }
  
  private void ensureRoutes()
  {
    ArrayList localArrayList;
    if (this.mRoutes == null)
    {
      localArrayList = this.mBundle.getParcelableArrayList("routes");
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        break label36;
      }
      this.mRoutes = Collections.emptyList();
    }
    for (;;)
    {
      return;
      label36:
      int j = localArrayList.size();
      this.mRoutes = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.mRoutes.add(MediaRouteDescriptor.fromBundle((Bundle)localArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public static MediaRouteProviderDescriptor fromBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return new MediaRouteProviderDescriptor(paramBundle, null);
    }
    return null;
  }
  
  public Bundle asBundle()
  {
    return this.mBundle;
  }
  
  public List<MediaRouteDescriptor> getRoutes()
  {
    ensureRoutes();
    return this.mRoutes;
  }
  
  public boolean isValid()
  {
    ensureRoutes();
    int j = this.mRoutes.size();
    int i = 0;
    while (i < j)
    {
      MediaRouteDescriptor localMediaRouteDescriptor = (MediaRouteDescriptor)this.mRoutes.get(i);
      if ((localMediaRouteDescriptor == null) || (!localMediaRouteDescriptor.isValid())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaRouteProviderDescriptor{ ");
    localStringBuilder.append("routes=").append(Arrays.toString(getRoutes().toArray()));
    localStringBuilder.append(", isValid=").append(isValid());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private final Bundle mBundle;
    private ArrayList<MediaRouteDescriptor> mRoutes;
    
    public Builder()
    {
      this.mBundle = new Bundle();
    }
    
    public Builder(MediaRouteProviderDescriptor paramMediaRouteProviderDescriptor)
    {
      if (paramMediaRouteProviderDescriptor == null) {
        throw new IllegalArgumentException("descriptor must not be null");
      }
      this.mBundle = new Bundle(paramMediaRouteProviderDescriptor.mBundle);
      paramMediaRouteProviderDescriptor.ensureRoutes();
      if (!paramMediaRouteProviderDescriptor.mRoutes.isEmpty()) {
        this.mRoutes = new ArrayList(paramMediaRouteProviderDescriptor.mRoutes);
      }
    }
    
    public Builder addRoute(MediaRouteDescriptor paramMediaRouteDescriptor)
    {
      if (paramMediaRouteDescriptor == null) {
        throw new IllegalArgumentException("route must not be null");
      }
      if (this.mRoutes == null) {
        this.mRoutes = new ArrayList();
      }
      while (!this.mRoutes.contains(paramMediaRouteDescriptor))
      {
        this.mRoutes.add(paramMediaRouteDescriptor);
        return this;
      }
      throw new IllegalArgumentException("route descriptor already added");
    }
    
    public Builder addRoutes(Collection<MediaRouteDescriptor> paramCollection)
    {
      if (paramCollection == null) {
        throw new IllegalArgumentException("routes must not be null");
      }
      if (!paramCollection.isEmpty())
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          addRoute((MediaRouteDescriptor)paramCollection.next());
        }
      }
      return this;
    }
    
    public MediaRouteProviderDescriptor build()
    {
      if (this.mRoutes != null)
      {
        int j = this.mRoutes.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          localArrayList.add(((MediaRouteDescriptor)this.mRoutes.get(i)).asBundle());
          i += 1;
        }
        this.mBundle.putParcelableArrayList("routes", localArrayList);
      }
      return new MediaRouteProviderDescriptor(this.mBundle, this.mRoutes, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouteProviderDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */