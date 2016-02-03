package com.inmobi.commons.thinICE.wifi;

import android.net.wifi.ScanResult;
import java.util.List;

public abstract interface WifiScanListener
{
  public abstract void onResultsReceived(List<ScanResult> paramList);
  
  public abstract void onTimeout();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/commons/thinICE/wifi/WifiScanListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */