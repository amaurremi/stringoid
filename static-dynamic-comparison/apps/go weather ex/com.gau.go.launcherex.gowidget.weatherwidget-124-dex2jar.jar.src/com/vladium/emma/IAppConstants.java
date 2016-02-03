package com.vladium.emma;

import com.vladium.app.IAppVersion;
import com.vladium.jcd.lib.Types;

public abstract interface IAppConstants
  extends IAppVersion
{
  public static final String APP_COPYRIGHT = "(C) Vladimir Roubtsov";
  public static final String APP_NAME = "EMMA";
  public static final String APP_NAME_LC = "emma";
  public static final String APP_PACKAGE = Types.getClassPackageName(IAppConstants.class);
  public static final String APP_THROWABLE_BUILD_ID = "[EMMA v0.0.0 (unsupported private build)]";
  public static final String APP_USAGE_BUILD_ID = "[EMMA v0.0, build 0 (unsupported private build)]";
  public static final String APP_USAGE_PREFIX = "EMMA usage: ";
  public static final String APP_VERBOSE_BUILD_ID = "[EMMA v0.0, build 0 (unsupported private build) (unknown)]";
  public static final long DATA_FORMAT_VERSION = 32L;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/IAppConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */