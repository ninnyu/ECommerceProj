package com.example.potatopaloozac.ecommerceproj.data.network.model;

public class ProductSubCategory {

    private String scid, scname, scdescription, scimageUrl;

    public ProductSubCategory(String scid, String scname, String scdescription, String scimageUrl) {
        this.scid = scid;
        this.scname = scname;
        this.scdescription = scdescription;
        this.scimageUrl = scimageUrl;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public String getScdescription() {
        return scdescription;
    }

    public void setScdescription(String scdescription) {
        this.scdescription = scdescription;
    }

    public String getScimageUrl() {
        return scimageUrl;
    }

    public void setScimageUrl(String scimageUrl) {
        this.scimageUrl = scimageUrl;
    }
}
