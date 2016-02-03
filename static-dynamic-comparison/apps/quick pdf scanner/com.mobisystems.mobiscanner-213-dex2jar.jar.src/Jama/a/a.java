package Jama.a;

public class a
{
  public static double hypot(double paramDouble1, double paramDouble2)
  {
    double d = 0.0D;
    if (Math.abs(paramDouble1) > Math.abs(paramDouble2))
    {
      paramDouble2 /= paramDouble1;
      paramDouble1 = Math.abs(paramDouble1);
      d = Math.sqrt(paramDouble2 * paramDouble2 + 1.0D) * paramDouble1;
    }
    while (paramDouble2 == 0.0D) {
      return d;
    }
    paramDouble1 /= paramDouble2;
    paramDouble2 = Math.abs(paramDouble2);
    return Math.sqrt(paramDouble1 * paramDouble1 + 1.0D) * paramDouble2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/Jama/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */