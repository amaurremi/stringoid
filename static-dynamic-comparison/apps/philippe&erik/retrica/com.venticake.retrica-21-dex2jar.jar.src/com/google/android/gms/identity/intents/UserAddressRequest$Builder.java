package com.google.android.gms.identity.intents;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest$Builder
{
  private UserAddressRequest$Builder(UserAddressRequest paramUserAddressRequest) {}
  
  public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification)
  {
    if (this.UF.UE == null) {
      this.UF.UE = new ArrayList();
    }
    this.UF.UE.add(paramCountrySpecification);
    return this;
  }
  
  public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection)
  {
    if (this.UF.UE == null) {
      this.UF.UE = new ArrayList();
    }
    this.UF.UE.addAll(paramCollection);
    return this;
  }
  
  public UserAddressRequest build()
  {
    if (this.UF.UE != null) {
      this.UF.UE = Collections.unmodifiableList(this.UF.UE);
    }
    return this.UF;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/identity/intents/UserAddressRequest$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */