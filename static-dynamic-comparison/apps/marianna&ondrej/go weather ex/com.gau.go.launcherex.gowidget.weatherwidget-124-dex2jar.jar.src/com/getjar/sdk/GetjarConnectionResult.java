package com.getjar.sdk;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GetjarConnectionResult
{
  public static final int BLACKLISTED = 2;
  public static final int NETWORK_FAILURE = 4;
  public static final int RESOLUTION_REQUIRED = 6;
  private static final List<Integer> SUPPORTED_ERROR_CODES = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(6), Integer.valueOf(13) });
  public static final int UNKNOWN_FAILURE = 13;
  public static final int UNSUPPORTED = 3;
  private final int _errorCode;
  private final boolean _hasResolution;
  private final Intent _resolutionIntent;
  
  protected GetjarConnectionResult(boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if ((paramBoolean) && (paramIntent == null)) {
      throw new IllegalArgumentException("If 'hasResolution' is true then a 'resolutionIntent' must be provided");
    }
    if (!SUPPORTED_ERROR_CODES.contains(Integer.valueOf(paramInt))) {
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported 'errorCode' value [%1$d]", new Object[] { Integer.valueOf(paramInt) }));
    }
    this._hasResolution = paramBoolean;
    this._errorCode = paramInt;
    this._resolutionIntent = paramIntent;
  }
  
  public int getErrorCode()
  {
    return this._errorCode;
  }
  
  public Intent getResolutionIntent()
  {
    return this._resolutionIntent;
  }
  
  public boolean hasResolution()
  {
    return this._hasResolution;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/GetjarConnectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */