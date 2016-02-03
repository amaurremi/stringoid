package com.venticake.retrica.view.album;

import android.content.Context;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.microedition.khronos.opengles.GL11;

public final class MenuBar
  extends Layer
  implements PopupMenu.Listener
{
  private static final int BACKGROUND = 2130837668;
  public static final int HEIGHT = 45;
  private static final int HIT_TEST_MARGIN = 15;
  private static final long LONG_PRESS_THRESHOLD_MS = 350L;
  private static final int MENU_HIGHLIGHT_EDGE_INSET = 9;
  private static final int MENU_HIGHLIGHT_EDGE_WIDTH = 21;
  private static final int MENU_HIGHLIGHT_LEFT = 2130837670;
  private static final int MENU_HIGHLIGHT_MIDDLE = 2130837669;
  private static final int MENU_HIGHLIGHT_RIGHT = 2130837671;
  private static final StringTexture.Config MENU_TITLE_STYLE;
  public static final StringTexture.Config MENU_TITLE_STYLE_TEXT = new StringTexture.Config();
  private static final int SEPERATOR = 2130837672;
  private GL11 mGL;
  private MenuBar.Menu[] mMenus = new MenuBar.Menu[0];
  private boolean mNeedsLayout = false;
  private boolean mSecondTouch;
  private final PopupMenu mSubmenu;
  private final HashMap<String, Texture> mTextureMap = new HashMap();
  private boolean mTouchActive = false;
  private int mTouchMenu = -1;
  private int mTouchMenuItem = -1;
  private boolean mTouchOverMenu = false;
  
  static
  {
    MENU_TITLE_STYLE = new StringTexture.Config();
    MENU_TITLE_STYLE.fontSize = (17.0F * Gallery.PIXEL_DENSITY);
    MENU_TITLE_STYLE.sizeMode = 0;
    MENU_TITLE_STYLE.overflowMode = 2;
    MENU_TITLE_STYLE_TEXT.fontSize = (15.0F * Gallery.PIXEL_DENSITY);
    MENU_TITLE_STYLE_TEXT.xalignment = 0;
    MENU_TITLE_STYLE_TEXT.sizeMode = 0;
    MENU_TITLE_STYLE_TEXT.overflowMode = 2;
  }
  
  public MenuBar(Context paramContext)
  {
    this.mSubmenu = new PopupMenu(paramContext);
    this.mSubmenu.setListener(this);
  }
  
  private boolean canDrawHighlight()
  {
    return (this.mTouchMenu != -1) && (this.mTouchMenuItem == -1) && ((!this.mTouchActive) || (this.mTouchOverMenu));
  }
  
  private void drawHighlight(RenderView paramRenderView, GL11 paramGL11, int paramInt)
  {
    paramGL11 = paramRenderView.getResource(2130837670);
    ResourceTexture localResourceTexture1 = paramRenderView.getResource(2130837669);
    ResourceTexture localResourceTexture2 = paramRenderView.getResource(2130837671);
    int i = paramGL11.getHeight();
    int j = (int)(45.0F * Gallery.PIXEL_DENSITY);
    MenuBar.Menu localMenu = this.mMenus[paramInt];
    paramInt = MenuBar.Menu.access$1(localMenu) + (int)(9.0F * Gallery.PIXEL_DENSITY);
    int k = MenuBar.Menu.access$2(localMenu) - (int)(18.0F * Gallery.PIXEL_DENSITY);
    j = (int)this.mY - (i - j);
    paramRenderView.draw2D(paramGL11, paramInt - 21.0F * Gallery.PIXEL_DENSITY, j, Gallery.PIXEL_DENSITY * 21.0F, i);
    paramRenderView.draw2D(localResourceTexture1, paramInt, j, k, i);
    paramRenderView.draw2D(localResourceTexture2, paramInt + k, j, 21.0F * Gallery.PIXEL_DENSITY, i);
  }
  
  private int hitTestMenu(int paramInt1, int paramInt2)
  {
    MenuBar.Menu[] arrayOfMenu;
    if (paramInt2 > this.mY - 15.0F * Gallery.PIXEL_DENSITY)
    {
      arrayOfMenu = this.mMenus;
      paramInt2 = arrayOfMenu.length - 1;
    }
    for (;;)
    {
      if (paramInt2 < 0) {}
      do
      {
        return -1;
        if (paramInt1 <= MenuBar.Menu.access$1(arrayOfMenu[paramInt2])) {
          break;
        }
      } while ((arrayOfMenu[paramInt2].onSelect == null) && (arrayOfMenu[paramInt2].options == null) && (arrayOfMenu[paramInt2].onSingleTapUp == null));
      return paramInt2;
      paramInt2 -= 1;
    }
  }
  
  private void layoutMenus()
  {
    this.mTextureMap.clear();
    MenuBar.Menu[] arrayOfMenu = this.mMenus;
    int i3 = arrayOfMenu.length;
    float f1;
    int i;
    int j;
    int m;
    if (i3 != 0)
    {
      f1 = this.mWidth;
      i = 0;
      j = 0;
      if (i < i3) {
        break label71;
      }
      if (j <= f1) {
        break label173;
      }
      m = (int)Math.floor(f1 / i3);
      i = 0;
      j = 0;
      if (i < i3) {
        break label90;
      }
    }
    label71:
    label90:
    int k;
    label173:
    int n;
    label186:
    int i1;
    label206:
    float f2;
    for (;;)
    {
      return;
      j += arrayOfMenu[i].computeRequiredWidth();
      i += 1;
      break;
      MenuBar.Menu localMenu = arrayOfMenu[i];
      MenuBar.Menu.access$3(localMenu, j);
      MenuBar.Menu.access$4(localMenu, m);
      if (localMenu.icon != 0) {}
      for (k = 45;; k = 0)
      {
        localMenu.titleWidth = (m - (k + 20));
        if (i == i3 - 1) {
          MenuBar.Menu.access$4(localMenu, (int)f1 - j);
        }
        j += m;
        i += 1;
        break;
      }
      m = 0;
      j = 1;
      n = Integer.MAX_VALUE;
      k = 0;
      if ((j == 0) || (m >= i3)) {
        break label419;
      }
      i1 = 0;
      i = 0;
      j = 0;
      if (i1 < i3) {
        break label358;
      }
      n = (i3 - m) * i + k;
      if ((n >= f1) && (j != 0) && (m != i3 - 1)) {
        break label403;
      }
      f2 = (f1 - n) / i3;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      j = 0;
      k = 0;
      while (j < i3)
      {
        localMenu = arrayOfMenu[j];
        MenuBar.Menu.access$3(localMenu, k);
        f2 = arrayOfMenu[j].computeRequiredWidth();
        if (f2 >= i) {
          break label396;
        }
        f2 = i + f1;
        label316:
        MenuBar.Menu.access$4(localMenu, (int)f2);
        localMenu.titleWidth = StringTexture.computeTextWidthForConfig(localMenu.title, localMenu.config);
        k = (int)(f2 + k);
        j += 1;
      }
    }
    label358:
    int i2 = arrayOfMenu[i1].computeRequiredWidth();
    if ((i2 > i) && (i2 < n))
    {
      j = 1;
      i = i2;
    }
    for (;;)
    {
      i1 += 1;
      break label206;
      label396:
      f2 += f1;
      break label316;
      label403:
      m += 1;
      n = i;
      k += i;
      break label186;
      label419:
      break;
    }
  }
  
  private void selectMenu(int paramInt)
  {
    int i = this.mTouchMenu;
    if (i != paramInt)
    {
      Object localObject = this.mMenus;
      if (i != -1)
      {
        localObject = localObject[i];
        if (((MenuBar.Menu)localObject).onDeselect != null) {
          ((MenuBar.Menu)localObject).onDeselect.run();
        }
      }
      this.mTouchMenu = paramInt;
      this.mTouchMenuItem = -1;
      localObject = this.mSubmenu;
      int j = 0;
      i = j;
      if (paramInt != -1)
      {
        MenuBar.Menu localMenu = this.mMenus[paramInt];
        if (localMenu.onSelect != null) {
          localMenu.onSelect.run();
        }
        PopupMenu.Option[] arrayOfOption = localMenu.options;
        i = j;
        if (arrayOfOption != null)
        {
          paramInt = (int)this.mX;
          i = MenuBar.Menu.access$1(localMenu);
          j = MenuBar.Menu.access$2(localMenu) / 2;
          int k = (int)this.mY;
          ((PopupMenu)localObject).setOptions(arrayOfOption);
          ((PopupMenu)localObject).showAtPoint(paramInt + i + j, k, (int)this.mWidth, (int)this.mHeight);
          i = 1;
        }
      }
      if (i == 0) {
        ((PopupMenu)localObject).close(true);
      }
    }
  }
  
  public void close()
  {
    int i = this.mTouchMenu;
    if (i != -1)
    {
      Object localObject = this.mMenus;
      if (i != -1)
      {
        localObject = localObject[i];
        if (((MenuBar.Menu)localObject).onDeselect != null) {
          ((MenuBar.Menu)localObject).onDeselect.run();
        }
      }
    }
    selectMenu(-1);
    if (this.mSubmenu != null) {
      this.mSubmenu.close(false);
    }
  }
  
  public void generate(RenderView paramRenderView, RenderView.Lists paramLists)
  {
    paramLists.blendedList.add(this);
    paramLists.hitTestList.add(this);
    paramLists.systemList.add(this);
    paramLists.updateList.add(this);
    this.mSubmenu.generate(paramRenderView, paramLists);
  }
  
  public MenuBar.Menu[] getMenus()
  {
    return this.mMenus;
  }
  
  protected void onHiddenChanged()
  {
    if (this.mHidden) {
      this.mSubmenu.close(false);
    }
  }
  
  public void onSelectionChanged(PopupMenu paramPopupMenu, int paramInt)
  {
    this.mTouchMenuItem = paramInt;
  }
  
  public void onSelectionClicked(PopupMenu paramPopupMenu, int paramInt)
  {
    selectMenu(-1);
  }
  
  protected void onSizeChanged()
  {
    this.mNeedsLayout = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = hitTestMenu((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      label102:
      long l1;
      long l2;
      do
      {
        do
        {
          return true;
          this.mTouchActive = true;
          if (this.mTouchMenu == i)
          {
            this.mSecondTouch = true;
            if (i == -1) {
              break label102;
            }
            selectMenu(i);
          }
          for (this.mTouchOverMenu = true;; this.mTouchOverMenu = false)
          {
            this.mSubmenu.onTouchEvent(paramMotionEvent);
            return true;
            this.mSecondTouch = false;
            break;
          }
          if ((this.mTouchMenu == i) && (this.mSecondTouch))
          {
            this.mSubmenu.close(true);
            this.mTouchMenu = -1;
            return true;
          }
          this.mSubmenu.onTouchEvent(paramMotionEvent);
          l1 = paramMotionEvent.getEventTime();
          l2 = paramMotionEvent.getDownTime();
          if (i == -1) {
            break;
          }
          paramMotionEvent = this.mMenus[i];
          if (paramMotionEvent.onSingleTapUp != null) {
            paramMotionEvent.onSingleTapUp.run();
          }
        } while (paramMotionEvent.options != null);
        selectMenu(-1);
        return true;
      } while (l1 - l2 <= 350L);
      selectMenu(-1);
      return true;
    }
    selectMenu(-1);
    return true;
  }
  
  public void renderBlended(RenderView paramRenderView, GL11 paramGL11)
  {
    if (this.mNeedsLayout)
    {
      layoutMenus();
      this.mNeedsLayout = false;
    }
    if (this.mGL != paramGL11)
    {
      this.mTextureMap.clear();
      this.mGL = paramGL11;
    }
    Object localObject = paramRenderView.getResource(2130837668);
    int i = ((Texture)localObject).getHeight();
    int j = (int)(45.0F * Gallery.PIXEL_DENSITY + 0.5F);
    int k = ((Texture)localObject).getHeight();
    paramRenderView.draw2D((Texture)localObject, this.mX, this.mY - (k - j), this.mWidth, i);
    localObject = this.mMenus;
    k = localObject.length;
    int m = (int)this.mY;
    if (paramRenderView.bind(paramRenderView.getResource(2130837672))) {
      i = 1;
    }
    float f1;
    for (;;)
    {
      if (i >= k)
      {
        i = this.mTouchMenu;
        if (canDrawHighlight()) {
          drawHighlight(paramRenderView, paramGL11, i);
        }
        f1 = this.mHeight;
        i = 0;
        if (i != k) {
          break;
        }
        return;
      }
      paramRenderView.draw2D(MenuBar.Menu.access$1(localObject[i]), m, 0.0F, 1.0F, j);
      i += 1;
    }
    MenuBar.Menu localMenu = localObject[i];
    ResourceTexture localResourceTexture = paramRenderView.getResource(localMenu.icon);
    paramGL11 = (StringTexture)this.mTextureMap.get(localMenu.title);
    if (paramGL11 == null)
    {
      paramGL11 = new StringTexture(localMenu.title, localMenu.config, localMenu.titleWidth, MENU_TITLE_STYLE.height);
      paramRenderView.loadTexture(paramGL11);
      localMenu.titleTexture = paramGL11;
      this.mTextureMap.put(localMenu.title, paramGL11);
    }
    for (;;)
    {
      if (localResourceTexture != null) {}
      for (j = localResourceTexture.getWidth();; j = 0)
      {
        int n = localMenu.titleWidth;
        n = (MenuBar.Menu.access$2(localMenu) - (n + j)) / 2;
        if (localResourceTexture != null)
        {
          f2 = m;
          f3 = (f1 - localResourceTexture.getHeight()) / 2.0F;
          paramRenderView.draw2D(localResourceTexture, MenuBar.Menu.access$1(localMenu) + n, f2 + f3);
        }
        float f2 = m;
        float f3 = (f1 - MENU_TITLE_STYLE.height) / 2.0F;
        paramRenderView.draw2D(paramGL11, j + (MenuBar.Menu.access$1(localMenu) + n), f2 + f3 + 1.0F);
        i += 1;
        break;
      }
    }
  }
  
  public void setMenus(MenuBar.Menu[] paramArrayOfMenu)
  {
    this.mMenus = paramArrayOfMenu;
    this.mNeedsLayout = true;
  }
  
  public void updateMenu(MenuBar.Menu paramMenu, int paramInt)
  {
    this.mMenus[paramInt] = paramMenu;
    this.mNeedsLayout = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/MenuBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */