package com.magmamobile.game.engine;

import com.magmamobile.game.engine.interpolation.Interpolator;

public class Animation
{
  private float _factor;
  private float _from;
  private Interpolator _interpolator;
  private GameObject _parent;
  private boolean _playing;
  private int _start;
  private int _startcount;
  private float _to;
  
  public Animation(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, int paramInt)
  {
    this._interpolator = paramInterpolator;
    this._start = paramInt;
    this._from = paramFloat1;
    this._to = paramFloat2;
  }
  
  public void apply()
  {
    if (this._parent == null) {}
    while (!this._playing) {
      return;
    }
    if (this._startcount > 0) {
      this._startcount -= 1;
    }
    for (;;)
    {
      this._parent.setX(MathUtils.lerpLinear(this._from, this._to, this._interpolator.getInterpolation(this._factor)));
      return;
      if (this._factor >= 1.0F)
      {
        this._playing = false;
        return;
      }
      this._factor = ((float)(this._factor + 0.05D));
      if (this._factor > 1.0F) {
        this._factor = 1.0F;
      }
    }
  }
  
  public boolean hasFinish()
  {
    return !this._playing;
  }
  
  public void setParent(GameObject paramGameObject)
  {
    this._parent = paramGameObject;
  }
  
  public void start()
  {
    this._startcount = this._start;
    this._playing = true;
    this._factor = 0.0F;
    this._parent.setX(MathUtils.lerpLinear(this._from, this._to, this._interpolator.getInterpolation(this._factor)));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Animation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */