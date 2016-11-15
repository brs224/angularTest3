/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.domain;

public class WorkOrderType {

    protected int id;
    protected String uuid;
    protected String regarding;
    protected String summary;
    protected String status;
    protected boolean hasChanged;
    protected String updatedBy;
    protected String updatedByToken;
    protected boolean isManualWorkOrder;
    protected String workProductType;
    protected String sectorsConceptIds;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getRegarding() {
        return regarding;
    }
    public void setRegarding(String regarding) {
        this.regarding = regarding;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isHasChanged() {
        return hasChanged;
    }
    public void setHasChanged(boolean hasChanged) {
        this.hasChanged = hasChanged;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getUpdatedByToken() {
        return updatedByToken;
    }
    public void setUpdatedByToken(String updatedByToken) {
        this.updatedByToken = updatedByToken;
    }
    public boolean isManualWorkOrder() {
        return isManualWorkOrder;
    }
    public void setManualWorkOrder(boolean isManualWorkOrder) {
        this.isManualWorkOrder = isManualWorkOrder;
    }
    public String getWorkProductType() {
        return workProductType;
    }
    public void setWorkProductType(String workProductType) {
        this.workProductType = workProductType;
    }
    public String getSectorsConceptIds() {
        return sectorsConceptIds;
    }
    public void setSectorsConceptIds(String sectorsConceptIds) {
        this.sectorsConceptIds = sectorsConceptIds;
    }
    
}
