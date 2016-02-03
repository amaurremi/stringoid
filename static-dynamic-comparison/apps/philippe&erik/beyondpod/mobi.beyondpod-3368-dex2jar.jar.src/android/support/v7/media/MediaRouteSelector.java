package android.support.v7.media;

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MediaRouteSelector
{
  public static final MediaRouteSelector EMPTY = new MediaRouteSelector(new Bundle(), null);
  private static final String KEY_CONTROL_CATEGORIES = "controlCategories";
  private final Bundle mBundle;
  private List<String> mControlCategories;
  
  private MediaRouteSelector(Bundle paramBundle, List<String> paramList)
  {
    this.mBundle = paramBundle;
    this.mControlCategories = paramList;
  }
  
  private void ensureControlCategories()
  {
    if (this.mControlCategories == null)
    {
      this.mControlCategories = this.mBundle.getStringArrayList("controlCategories");
      if ((this.mControlCategories == null) || (this.mControlCategories.isEmpty())) {
        this.mControlCategories = Collections.emptyList();
      }
    }
  }
  
  public static MediaRouteSelector fromBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return new MediaRouteSelector(paramBundle, null);
    }
    return null;
  }
  
  public Bundle asBundle()
  {
    return this.mBundle;
  }
  
  public boolean contains(MediaRouteSelector paramMediaRouteSelector)
  {
    if (paramMediaRouteSelector != null)
    {
      ensureControlCategories();
      paramMediaRouteSelector.ensureControlCategories();
      return this.mControlCategories.containsAll(paramMediaRouteSelector.mControlCategories);
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MediaRouteSelector))
    {
      paramObject = (MediaRouteSelector)paramObject;
      ensureControlCategories();
      ((MediaRouteSelector)paramObject).ensureControlCategories();
      return this.mControlCategories.equals(((MediaRouteSelector)paramObject).mControlCategories);
    }
    return false;
  }
  
  public List<String> getControlCategories()
  {
    ensureControlCategories();
    return this.mControlCategories;
  }
  
  public boolean hasControlCategory(String paramString)
  {
    if (paramString != null)
    {
      ensureControlCategories();
      int j = this.mControlCategories.size();
      int i = 0;
      while (i < j)
      {
        if (((String)this.mControlCategories.get(i)).equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    ensureControlCategories();
    return this.mControlCategories.hashCode();
  }
  
  public boolean isEmpty()
  {
    ensureControlCategories();
    return this.mControlCategories.isEmpty();
  }
  
  public boolean isValid()
  {
    ensureControlCategories();
    return !this.mControlCategories.contains(null);
  }
  
  public boolean matchesControlFilters(List<IntentFilter> paramList)
  {
    if (paramList != null)
    {
      ensureControlCategories();
      int k = this.mControlCategories.size();
      if (k != 0)
      {
        int m = paramList.size();
        int i = 0;
        while (i < m)
        {
          IntentFilter localIntentFilter = (IntentFilter)paramList.get(i);
          if (localIntentFilter != null)
          {
            int j = 0;
            while (j < k)
            {
              if (localIntentFilter.hasCategory((String)this.mControlCategories.get(j))) {
                return true;
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaRouteSelector{ ");
    localStringBuilder.append("controlCategories=").append(Arrays.toString(getControlCategories().toArray()));
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static final class Builder
  {
    private ArrayList<String> mControlCategories;
    
    public Builder() {}
    
    public Builder(MediaRouteSelector paramMediaRouteSelector)
    {
      if (paramMediaRouteSelector == null) {
        throw new IllegalArgumentException("selector must not be null");
      }
      paramMediaRouteSelector.ensureControlCategories();
      if (!paramMediaRouteSelector.mControlCategories.isEmpty()) {
        this.mControlCategories = new ArrayList(paramMediaRouteSelector.mControlCategories);
      }
    }
    
    public Builder addControlCategories(Collection<String> paramCollection)
    {
      if (paramCollection == null) {
        throw new IllegalArgumentException("categories must not be null");
      }
      if (!paramCollection.isEmpty())
      {
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          addControlCategory((String)paramCollection.next());
        }
      }
      return this;
    }
    
    public Builder addControlCategory(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("category must not be null");
      }
      if (this.mControlCategories == null) {
        this.mControlCategories = new ArrayList();
      }
      if (!this.mControlCategories.contains(paramString)) {
        this.mControlCategories.add(paramString);
      }
      return this;
    }
    
    public Builder addSelector(MediaRouteSelector paramMediaRouteSelector)
    {
      if (paramMediaRouteSelector == null) {
        throw new IllegalArgumentException("selector must not be null");
      }
      addControlCategories(paramMediaRouteSelector.getControlCategories());
      return this;
    }
    
    public MediaRouteSelector build()
    {
      if (this.mControlCategories == null) {
        return MediaRouteSelector.EMPTY;
      }
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("controlCategories", this.mControlCategories);
      return new MediaRouteSelector(localBundle, this.mControlCategories, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/media/MediaRouteSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */