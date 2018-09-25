package com.example.potatopaloozac.ecommerceproj.data.network.model;

public class ProductCategory {

    private String cid, cname, cdescription, cimageUrl;

    public ProductCategory(String cid, String cname, String cdescription, String cimageUrl) {
        this.cid = cid;
        this.cname = cname;
        this.cdescription = cdescription;
        this.cimageUrl = cimageUrl;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    public String getCimageUrl() {
        return cimageUrl;
    }

    public void setCimageUrl(String cimageUrl) {
        this.cimageUrl = cimageUrl;
    }
}
