/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.domain;

public class DocumentType {

    protected String id;
    protected String renditionId;
    protected String alertId;
    protected String url;
    protected String sourceUrl;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRenditionId() {
        return renditionId;
    }
    public void setRenditionId(String renditionId) {
        this.renditionId = renditionId;
    }
    public String getAlertId() {
        return alertId;
    }
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getSourceUrl() {
        return sourceUrl;
    }
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    
}
