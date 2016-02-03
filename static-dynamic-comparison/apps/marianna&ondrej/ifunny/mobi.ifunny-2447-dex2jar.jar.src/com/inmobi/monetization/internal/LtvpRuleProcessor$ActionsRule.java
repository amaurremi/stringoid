package com.inmobi.monetization.internal;

public enum LtvpRuleProcessor$ActionsRule {
    int a;

    static {
        ACTIONS_TO_MEDIATION = new ActionsRule("ACTIONS_TO_MEDIATION", 2, 2);
    }

    private LtvpRuleProcessor$ActionsRule(int paramInt) {
        this.a = paramInt;
    }

    static ActionsRule a(int paramInt) {
        switch (paramInt) {
            default:
                return MEDIATION;
            case 1:
                return NO_ADS;
            case 2:
                return ACTIONS_TO_MEDIATION;
        }
        return ACTIONS_ONLY;
    }

    public int getValue() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/LtvpRuleProcessor$ActionsRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */