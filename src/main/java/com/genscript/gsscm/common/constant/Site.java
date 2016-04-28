package com.genscript.gsscm.common.constant;

public enum Site {

    US_ORDER("usorder"), JP_ORDER("jporder"), CN_ORDER("cnorder"), MES("mes"), CN_SHIPPING("cnshipping"), US_SHIPPING("usshipping");

    private final String value;

    Site(String s) {
        value = s;
    }

    public String value() {
        return value;
    }

    public static Site getSite(String s) {
        Site[] values = Site.values();
        for (Site site : values) {
            if (site.value.equals(s)) {
                return site;
            }
        }
        return null;
    }

}
