package com.jirbo.adcolony;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class ADCMediaManager
  implements ADCDownload.Listener
{
  int active_downloads;
  ArrayList<Asset> assets = new ArrayList();
  boolean configured;
  ADCController controller;
  HashMap<String, Asset> lookup = new HashMap();
  boolean modified;
  int next_file_number = 1;
  ArrayList<String> pending_downloads = new ArrayList();
  ADCUtil.Timer save_timer = new ADCUtil.Timer(2.0D);
  double total_media_bytes;
  
  ADCMediaManager(ADCController paramADCController)
  {
    this.controller = paramADCController;
  }
  
  void cache(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    String str;
    Object localObject;
    do
    {
      return;
      str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      localObject = (Asset)this.lookup.get(paramString1);
      if (localObject == null) {
        break label210;
      }
      ((Asset)localObject).last_accessed = ADCUtil.current_time();
      paramString2 = (String)localObject;
      if (!((Asset)localObject).last_modified.equals(str)) {
        break;
      }
    } while ((((Asset)localObject).ready) || (((Asset)localObject).downloading));
    paramString2 = (String)localObject;
    for (;;)
    {
      if (paramString2.file_number == 0)
      {
        int i = get_next_file_number();
        localObject = url_to_filename(paramString1, i);
        localObject = this.controller.storage.media_path + (String)localObject;
        paramString2.file_number = i;
        paramString2.filepath = ((String)localObject);
      }
      paramString2.last_modified = str;
      paramString2.downloading = true;
      paramString2.ready = false;
      ADCLog.dev.print("Adding ").print(paramString1).println(" to pending downloads.");
      this.pending_downloads.add(paramString1);
      this.modified = true;
      this.save_timer.restart(2.0D);
      ADC.active = true;
      return;
      label210:
      paramString2 = new Asset();
      paramString2.url = paramString1;
      this.assets.add(paramString2);
      paramString2.last_accessed = ADCUtil.current_time();
      this.lookup.put(paramString1, paramString2);
    }
  }
  
  void configure()
  {
    load();
    this.configured = true;
  }
  
  int get_next_file_number()
  {
    this.modified = true;
    this.save_timer.restart(2.0D);
    int i = this.next_file_number;
    this.next_file_number = (i + 1);
    return i;
  }
  
  boolean is_cached(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    do
    {
      do
      {
        return false;
        paramString = (Asset)this.lookup.get(paramString);
        if (paramString == null)
        {
          this.controller.ad_manager.app.cache_media();
          return false;
        }
        if (!paramString.ready) {
          break;
        }
      } while (paramString.downloading);
      paramString.last_accessed = ADCUtil.current_time();
      return true;
    } while (paramString.downloading);
    this.controller.ad_manager.app.cache_media();
    return false;
  }
  
  void load()
  {
    ADCLog.dev.println("Loading media info");
    Object localObject = ADCJSON.load_Table(new ADCDataFile("media_info.txt"));
    if (localObject == null)
    {
      localObject = new ADCData.Table();
      ADCLog.dev.println("No saved media info exists.");
    }
    for (;;)
    {
      this.next_file_number = ((ADCData.Table)localObject).get_Integer("next_file_number");
      if (this.next_file_number <= 0) {
        this.next_file_number = 1;
      }
      localObject = ((ADCData.Table)localObject).get_List("assets");
      if (localObject == null) {
        break;
      }
      this.assets.clear();
      int i = 0;
      while (i < ((ADCData.List)localObject).count())
      {
        ADCData.Table localTable = ((ADCData.List)localObject).get_Table(i);
        Asset localAsset = new Asset();
        localAsset.url = localTable.get_String("url");
        localAsset.filepath = localTable.get_String("filepath");
        localAsset.last_modified = localTable.get_String("last_modified");
        localAsset.file_number = localTable.get_Integer("file_number");
        localAsset.size = localTable.get_Integer("size");
        localAsset.ready = localTable.get_Logical("ready");
        localAsset.last_accessed = localTable.get_Real("last_accessed");
        if (localAsset.file_number > this.next_file_number) {
          this.next_file_number = (localAsset.file_number + 1);
        }
        this.assets.add(localAsset);
        i += 1;
      }
      ADCLog.dev.println("Loaded media info");
    }
    refresh();
  }
  
  String local_filepath(String paramString)
  {
    paramString = (Asset)this.lookup.get(paramString);
    if ((paramString == null) || (paramString.filepath == null)) {
      return "(file not found)";
    }
    paramString.last_accessed = ADCUtil.current_time();
    this.modified = true;
    this.save_timer.restart(2.0D);
    return paramString.filepath;
  }
  
  public void on_download_finished(ADCDownload paramADCDownload)
  {
    Asset localAsset = (Asset)paramADCDownload.info;
    this.active_downloads -= 1;
    this.modified = true;
    this.save_timer.restart(2.0D);
    localAsset.ready = paramADCDownload.success;
    localAsset.downloading = false;
    if (paramADCDownload.success)
    {
      localAsset.size = paramADCDownload.size;
      this.total_media_bytes += localAsset.size;
      ADCLog.dev.print("Downloaded ").println(localAsset.url);
    }
    ADC.has_ad_availability_changed();
    start_next_download();
  }
  
  void purge_old_assets()
  {
    double d = this.controller.ad_manager.app.media_pool_size;
    if (d == 0.0D) {
      return;
    }
    Object localObject1;
    do
    {
      ADCLog.debug.print("Deleting ").println(((Asset)localObject1).filepath);
      ((Asset)localObject1).ready = false;
      new File(((Asset)localObject1).filepath).delete();
      ((Asset)localObject1).filepath = null;
      this.total_media_bytes -= ((Asset)localObject1).size;
      ADCLog.debug.print("Media pool now at ").print(this.total_media_bytes / 1048576.0D).print("/").print(d / 1048576.0D).println(" MB");
      this.modified = true;
      this.save_timer.restart(2.0D);
      if (this.total_media_bytes <= this.controller.ad_manager.app.media_pool_size) {
        break;
      }
      localObject1 = null;
      int i = 0;
      while (i < this.assets.size())
      {
        Asset localAsset = (Asset)this.assets.get(i);
        Object localObject2 = localObject1;
        if (localAsset.ready) {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localAsset.last_accessed >= ((Asset)localObject1).last_accessed) {}
          }
          else
          {
            localObject2 = localAsset;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    } while (localObject1 != null);
  }
  
  void refresh()
  {
    Object localObject3 = new HashMap();
    String str1 = this.controller.storage.media_path;
    Object localObject2 = new File(str1).list();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new String[0];
    }
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localObject2 = str1 + (String)localObject2;
      ((HashMap)localObject3).put(localObject2, localObject2);
      i += 1;
    }
    localObject2 = new HashMap();
    this.total_media_bytes = 0.0D;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < this.assets.size())
    {
      Asset localAsset = (Asset)this.assets.get(i);
      if ((!localAsset.downloading) && (localAsset.ready))
      {
        String str2 = localAsset.filepath;
        if ((((HashMap)localObject3).containsKey(str2)) && (new File(str2).length() == localAsset.size))
        {
          this.total_media_bytes += localAsset.size;
          localArrayList.add(localAsset);
          ((HashMap)localObject2).put(str2, str2);
        }
      }
      i += 1;
    }
    this.assets = localArrayList;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject3 = localObject1[i];
      localObject3 = str1 + (String)localObject3;
      if (!((HashMap)localObject2).containsKey(localObject3))
      {
        ADCLog.debug.print("Deleting unused media ").println(localObject3);
        new File((String)localObject3).delete();
      }
      i += 1;
    }
    this.lookup.clear();
    i = 0;
    while (i < this.assets.size())
    {
      localObject1 = (Asset)this.assets.get(i);
      this.lookup.put(((Asset)localObject1).url, localObject1);
      i += 1;
    }
    double d = this.controller.ad_manager.app.media_pool_size;
    if (d > 0.0D) {
      ADCLog.debug.print("Media pool at ").print(this.total_media_bytes / 1048576.0D).print("/").print(d / 1048576.0D).println(" MB");
    }
  }
  
  void save()
  {
    ADCLog.dev.println("Saving media info");
    ADCData.List localList = new ADCData.List();
    int i = 0;
    while (i < this.assets.size())
    {
      localObject = (Asset)this.assets.get(i);
      if ((((Asset)localObject).ready) && (!((Asset)localObject).downloading))
      {
        ADCData.Table localTable = new ADCData.Table();
        localTable.set("url", ((Asset)localObject).url);
        localTable.set("filepath", ((Asset)localObject).filepath);
        localTable.set("last_modified", ((Asset)localObject).last_modified);
        localTable.set("file_number", ((Asset)localObject).file_number);
        localTable.set("size", ((Asset)localObject).size);
        localTable.set("ready", ((Asset)localObject).ready);
        localTable.set("last_accessed", ((Asset)localObject).last_accessed);
        localList.add(localTable);
      }
      i += 1;
    }
    Object localObject = new ADCData.Table();
    ((ADCData.Table)localObject).set("next_file_number", this.next_file_number);
    ((ADCData.Table)localObject).set("assets", localList);
    ADCJSON.save(new ADCDataFile("media_info.txt"), (ADCData.Table)localObject);
    this.modified = false;
  }
  
  void start_next_download()
  {
    if ((this.controller.ad_manager.app.cache_network_pass_filter.equals("wifi")) && (!ADCNetwork.using_wifi())) {
      ADCLog.dev.println("Skipping asset download due to CACHE_FILTER_WIFI");
    }
    for (;;)
    {
      return;
      if ((this.controller.ad_manager.app.cache_network_pass_filter.equals("cell")) && (!ADCNetwork.using_mobile()))
      {
        ADCLog.dev.println("Skipping asset download due to CACHE_FILTER_CELL.");
        return;
      }
      while ((this.active_downloads < 3) && (this.pending_downloads.size() > 0))
      {
        String str = (String)this.pending_downloads.remove(0);
        Asset localAsset = (Asset)this.lookup.get(str);
        if ((localAsset != null) && ((str == null) || (str.equals(""))))
        {
          ADCLog.error.println("[ADC ERROR] - NULL URL");
          new RuntimeException().printStackTrace();
        }
        if ((localAsset != null) && (str != null) && (!str.equals("")))
        {
          ADC.active = true;
          this.active_downloads += 1;
          new ADCDownload(this.controller, str, this, localAsset.filepath).with_info(localAsset).start();
        }
      }
    }
  }
  
  void update()
  {
    start_next_download();
    if ((this.modified) && (this.save_timer.expired()))
    {
      purge_old_assets();
      save();
    }
  }
  
  String url_to_filename(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramInt + "";
    }
    return paramInt + paramString.substring(i);
  }
  
  static class Asset
  {
    boolean downloading;
    int file_number;
    String filepath;
    double last_accessed;
    String last_modified;
    boolean ready;
    int size;
    String url;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCMediaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */