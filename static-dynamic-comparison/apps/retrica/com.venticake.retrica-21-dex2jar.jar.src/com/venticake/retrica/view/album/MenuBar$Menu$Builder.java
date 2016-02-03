package com.venticake.retrica.view.album;

public final class MenuBar$Menu$Builder
{
  private StringTexture.Config config;
  private int icon = 0;
  private Runnable onDeselect = null;
  private Runnable onSelect = null;
  private Runnable onSingleTapUp = null;
  private PopupMenu.Option[] options = null;
  private boolean resizeToAccomodate;
  private final String title;
  
  public MenuBar$Menu$Builder(String paramString)
  {
    this.title = paramString;
    this.config = MenuBar.access$0();
  }
  
  public MenuBar.Menu build()
  {
    return new MenuBar.Menu(this, null);
  }
  
  public Builder config(StringTexture.Config paramConfig)
  {
    this.config = paramConfig;
    return this;
  }
  
  public Builder icon(int paramInt)
  {
    this.icon = paramInt;
    return this;
  }
  
  public Builder onDeselect(Runnable paramRunnable)
  {
    this.onDeselect = paramRunnable;
    return this;
  }
  
  public Builder onSelect(Runnable paramRunnable)
  {
    this.onSelect = paramRunnable;
    return this;
  }
  
  public Builder onSingleTapUp(Runnable paramRunnable)
  {
    this.onSingleTapUp = paramRunnable;
    return this;
  }
  
  public Builder options(PopupMenu.Option[] paramArrayOfOption)
  {
    this.options = paramArrayOfOption;
    return this;
  }
  
  public Builder resizeToAccomodate()
  {
    this.resizeToAccomodate = true;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MenuBar$Menu$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */