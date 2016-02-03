package com.androidwasabi.ads;

import android.widget.ListView;
import java.util.ArrayList;

class AdActivity$2
  extends AdManager.OnAdListener
{
  AdActivity$2(AdActivity paramAdActivity) {}
  
  public void adListloaded(ArrayList<AdManager.AdItem> paramArrayList)
  {
    AdManager.FileListAdapter localFileListAdapter = new AdManager.FileListAdapter(this.this$0, R.layout.wall_activity_item, paramArrayList);
    ListView localListView = (ListView)this.this$0.findViewById(R.id.ad_list);
    localListView.setAdapter(localFileListAdapter);
    localListView.setOnItemClickListener(new AdActivity.2.1(this));
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size())
      {
        AdManager.imageLoader.setListener(new AdActivity.2.2(this));
        return;
      }
      AdManager.imageLoader.loadImage(((AdManager.AdItem)paramArrayList.get(i)).image, Integer.valueOf(i));
      i += 1;
    }
  }
  
  public void failToLoad()
  {
    this.this$0.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */