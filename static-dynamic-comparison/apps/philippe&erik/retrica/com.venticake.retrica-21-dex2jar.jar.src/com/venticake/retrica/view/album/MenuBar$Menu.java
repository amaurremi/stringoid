package com.venticake.retrica.view.album;

public final class MenuBar$Menu
{
  private static final float ICON_WIDTH = 45.0F;
  public final StringTexture.Config config;
  public final int icon;
  private int mWidth;
  public final Runnable onDeselect;
  public final Runnable onSelect;
  public final Runnable onSingleTapUp;
  public PopupMenu.Option[] options;
  public final boolean resizeToAccomodate;
  public final String title;
  public StringTexture titleTexture = null;
  public int titleWidth = 0;
  private int x;
  
  private MenuBar$Menu(MenuBar.Menu.Builder paramBuilder)
  {
    this.config = MenuBar.Menu.Builder.access$0(paramBuilder);
    this.title = MenuBar.Menu.Builder.access$1(paramBuilder);
    this.icon = MenuBar.Menu.Builder.access$2(paramBuilder);
    this.onSelect = MenuBar.Menu.Builder.access$3(paramBuilder);
    this.onDeselect = MenuBar.Menu.Builder.access$4(paramBuilder);
    this.onSingleTapUp = MenuBar.Menu.Builder.access$5(paramBuilder);
    this.options = MenuBar.Menu.Builder.access$6(paramBuilder);
    this.resizeToAccomodate = MenuBar.Menu.Builder.access$7(paramBuilder);
  }
  
  public int computeRequiredWidth()
  {
    int i = 0;
    if (this.icon != 0) {
      i = (int)(0 + 45.0F);
    }
    int j = i;
    if (this.title != null) {
      j = i + StringTexture.computeTextWidthForConfig(this.title, this.config);
    }
    j += 20;
    i = j;
    if (j < 45) {
      i = 45;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MenuBar$Menu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */