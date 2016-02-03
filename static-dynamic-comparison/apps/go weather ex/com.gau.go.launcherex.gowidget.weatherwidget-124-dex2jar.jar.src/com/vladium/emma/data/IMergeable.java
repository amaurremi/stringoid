package com.vladium.emma.data;

import java.io.Serializable;

public abstract interface IMergeable
  extends Serializable
{
  public abstract boolean isEmpty();
  
  public abstract IMergeable merge(IMergeable paramIMergeable);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/IMergeable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */