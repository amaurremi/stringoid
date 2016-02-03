package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.nativeads.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class NativeResponse
{
  private String mCallToAction;
  private String mClickDestinationUrl;
  private String mClickTracker;
  private final Map<String, Object> mExtras = new HashMap();
  private String mIconImageUrl;
  private List<String> mImpressionTrackers = new ArrayList();
  private boolean mIsDestroyed;
  private String mMainImageUrl;
  private boolean mRecordedImpression;
  private String mText;
  private String mTitle;
  
  NativeResponse(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    if (!containsRequiredKeys(paramJSONObject)) {
      throw new IllegalArgumentException("JSONObject did not contain required keys.");
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Parameter localParameter = Parameter.from(str);
      if (localParameter != null) {
        try
        {
          addInstanceVariable(localParameter, paramJSONObject.opt(str));
        }
        catch (ClassCastException paramJSONObject)
        {
          throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
        }
      } else {
        addExtra(str, paramJSONObject.opt(str));
      }
    }
  }
  
  private void addExtra(String paramString, Object paramObject)
  {
    this.mExtras.put(paramString, paramObject);
  }
  
  private void addImpressionTrackers(Object paramObject)
    throws ClassCastException
  {
    if (!(paramObject instanceof JSONArray)) {
      throw new ClassCastException("Expected impression trackers of type JSONArray.");
    }
    paramObject = (JSONArray)paramObject;
    int i = 0;
    for (;;)
    {
      if (i < ((JSONArray)paramObject).length()) {
        try
        {
          this.mImpressionTrackers.add(((JSONArray)paramObject).getString(i));
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Utils.MoPubLog("Unable to parse impression trackers.");
          }
        }
      }
    }
  }
  
  private void addInstanceVariable(Parameter paramParameter, Object paramObject)
    throws ClassCastException
  {
    for (;;)
    {
      try
      {
        switch (paramParameter)
        {
        case ???: 
          Utils.MoPubLog("Unable to add JSON key to internal mapping: " + paramParameter.name);
          return;
        }
      }
      catch (ClassCastException paramObject)
      {
        if (paramParameter.required) {
          continue;
        }
        Utils.MoPubLog("Ignoring class cast exception for optional defined key: " + paramParameter.name);
        return;
        this.mIconImageUrl = ((String)paramObject);
        return;
        addImpressionTrackers(paramObject);
        return;
        this.mClickTracker = ((String)paramObject);
        return;
        this.mClickDestinationUrl = ((String)paramObject);
        return;
        this.mCallToAction = ((String)paramObject);
        return;
        this.mTitle = ((String)paramObject);
        return;
        this.mText = ((String)paramObject);
        return;
        throw ((Throwable)paramObject);
      }
      this.mMainImageUrl = ((String)paramObject);
      return;
    }
  }
  
  private boolean containsRequiredKeys(JSONObject paramJSONObject)
  {
    HashSet localHashSet = new HashSet();
    paramJSONObject = paramJSONObject.keys();
    while (paramJSONObject.hasNext()) {
      localHashSet.add(paramJSONObject.next());
    }
    return localHashSet.containsAll(Parameter.requiredKeys);
  }
  
  private void loadImageView(String paramString, ImageView paramImageView)
  {
    ImageViewService.loadImageView(paramString, paramImageView);
  }
  
  public void destroy()
  {
    this.mIsDestroyed = true;
    this.mExtras.clear();
  }
  
  List<String> getAllImageUrls()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mMainImageUrl != null) {
      localArrayList.add(this.mMainImageUrl);
    }
    if (this.mIconImageUrl != null) {
      localArrayList.add(this.mIconImageUrl);
    }
    localArrayList.addAll(getExtrasImageUrls());
    return localArrayList;
  }
  
  public String getCallToAction()
  {
    return this.mCallToAction;
  }
  
  public String getClickDestinationUrl()
  {
    return this.mClickDestinationUrl;
  }
  
  public String getClickTracker()
  {
    return this.mClickTracker;
  }
  
  public Object getExtra(String paramString)
  {
    return this.mExtras.get(paramString);
  }
  
  public Map<String, Object> getExtras()
  {
    return new HashMap(this.mExtras);
  }
  
  List<String> getExtrasImageUrls()
  {
    ArrayList localArrayList = new ArrayList(this.mExtras.size());
    Iterator localIterator = this.mExtras.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((Parameter.isImageKey((String)localEntry.getKey())) && ((localEntry.getValue() instanceof String))) {
        localArrayList.add((String)localEntry.getValue());
      }
    }
    return localArrayList;
  }
  
  public String getIconImageUrl()
  {
    return this.mIconImageUrl;
  }
  
  public List<String> getImpressionTrackers()
  {
    return this.mImpressionTrackers;
  }
  
  public String getMainImageUrl()
  {
    return this.mMainImageUrl;
  }
  
  public boolean getRecordedImpression()
  {
    return this.mRecordedImpression;
  }
  
  public String getSubtitle()
  {
    return this.mText;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void loadExtrasImage(String paramString, ImageView paramImageView)
  {
    Object localObject = this.mExtras.get(paramString);
    if ((localObject != null) && ((localObject instanceof String))) {
      loadImageView((String)this.mExtras.get(paramString), paramImageView);
    }
  }
  
  public void loadIconImage(ImageView paramImageView)
  {
    loadImageView(this.mIconImageUrl, paramImageView);
  }
  
  public void loadMainImage(ImageView paramImageView)
  {
    loadImageView(this.mMainImageUrl, paramImageView);
  }
  
  void recordImpression()
  {
    this.mRecordedImpression = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Parameter.TITLE.name).append(":").append(this.mTitle).append("\n");
    localStringBuilder.append(Parameter.TEXT.name).append(":").append(this.mText).append("\n");
    localStringBuilder.append(Parameter.ICON_IMAGE.name).append(":").append(this.mIconImageUrl).append("\n");
    localStringBuilder.append(Parameter.MAIN_IMAGE.name).append(":").append(this.mMainImageUrl).append("\n");
    localStringBuilder.append(Parameter.IMPRESSION_TRACKER.name).append(":").append(this.mImpressionTrackers).append("\n");
    localStringBuilder.append(Parameter.CLICK_TRACKER.name).append(":").append(this.mClickTracker).append("\n");
    localStringBuilder.append(Parameter.CLICK_DESTINATION.name).append(":").append(this.mClickDestinationUrl).append("\n");
    localStringBuilder.append(Parameter.CALL_TO_ACTION.name).append(":").append(this.mCallToAction).append("\n");
    localStringBuilder.append("recordedImpression").append(":").append(this.mRecordedImpression).append("\n");
    localStringBuilder.append("extras").append(":").append(this.mExtras);
    return localStringBuilder.toString();
  }
  
  static enum Parameter
  {
    static Set<String> requiredKeys;
    private final String name;
    private final boolean required;
    
    static
    {
      int i = 0;
      IMPRESSION_TRACKER = new Parameter("IMPRESSION_TRACKER", 0, "imptracker", true);
      CLICK_TRACKER = new Parameter("CLICK_TRACKER", 1, "clktracker", true);
      TITLE = new Parameter("TITLE", 2, "title", false);
      TEXT = new Parameter("TEXT", 3, "text", false);
      MAIN_IMAGE = new Parameter("MAIN_IMAGE", 4, "mainimage", false);
      ICON_IMAGE = new Parameter("ICON_IMAGE", 5, "iconimage", false);
      CLICK_DESTINATION = new Parameter("CLICK_DESTINATION", 6, "clk", false);
      FALLBACK = new Parameter("FALLBACK", 7, "fallback", false);
      CALL_TO_ACTION = new Parameter("CALL_TO_ACTION", 8, "ctatext", false);
      STAR_RATING = new Parameter("STAR_RATING", 9, "starrating", false);
      $VALUES = new Parameter[] { IMPRESSION_TRACKER, CLICK_TRACKER, TITLE, TEXT, MAIN_IMAGE, ICON_IMAGE, CLICK_DESTINATION, FALLBACK, CALL_TO_ACTION, STAR_RATING };
      requiredKeys = new HashSet();
      Parameter[] arrayOfParameter = values();
      int j = arrayOfParameter.length;
      while (i < j)
      {
        Parameter localParameter = arrayOfParameter[i];
        if (localParameter.required) {
          requiredKeys.add(localParameter.name);
        }
        i += 1;
      }
    }
    
    private Parameter(String paramString, boolean paramBoolean)
    {
      this.name = paramString;
      this.required = paramBoolean;
    }
    
    static Parameter from(String paramString)
    {
      Parameter[] arrayOfParameter = values();
      int j = arrayOfParameter.length;
      int i = 0;
      while (i < j)
      {
        Parameter localParameter = arrayOfParameter[i];
        if (localParameter.name.equals(paramString)) {
          return localParameter;
        }
        i += 1;
      }
      return null;
    }
    
    static boolean isImageKey(String paramString)
    {
      return (paramString != null) && (paramString.toLowerCase().endsWith("image"));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/nativeads/NativeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */