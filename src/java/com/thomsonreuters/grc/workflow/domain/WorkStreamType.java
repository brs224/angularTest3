/**
 * Copyright 2016: Thomson Reuters Global Resources. All Rights Reserved.
 * Proprietary and Confidential information of TRGR.
 * Disclosure, Use or Reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomsonreuters.grc.workflow.domain;

import java.math.BigInteger;

public class WorkStreamType {

    protected BigInteger id;
    protected String uuid;
    protected BigInteger workOrderId;
    protected String workOrderUuid;
    
    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public BigInteger getWorkOrderId() {
        return workOrderId;
    }
    public void setWorkOrderId(BigInteger workOrderId) {
        this.workOrderId = workOrderId;
    }
    public String getWorkOrderUuid() {
        return workOrderUuid;
    }
    public void setWorkOrderUuid(String workOrderUuid) {
        this.workOrderUuid = workOrderUuid;
    }    
}
