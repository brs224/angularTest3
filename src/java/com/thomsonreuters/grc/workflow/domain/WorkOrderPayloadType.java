package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkOrderPayloadType", propOrder = {
    "workOrder",
    "action",
    "processInfo",
    "outcomeSource"
})
public class WorkOrderPayloadType {

    @XmlElement
    protected WorkOrderType workOrder;
    @XmlElement
    protected ActionType action;
    @XmlElement
    protected ProcessInfoType processInfo;
    @XmlElement
    protected OutcomeSourceType outcomeSource;
    
    public WorkOrderType getWorkOrder() {
        return workOrder;
    }
    public void setWorkOrder(WorkOrderType workOrder) {
        this.workOrder = workOrder;
    }
    public ActionType getAction() {
        return action;
    }
    public void setAction(ActionType action) {
        this.action = action;
    }
    public ProcessInfoType getProcessInfo() {
        return processInfo;
    }
    public void setProcessInfo(ProcessInfoType processInfo) {
        this.processInfo = processInfo;
    }
    public OutcomeSourceType getOutcomeSource() {
        return outcomeSource;
    }
    public void setOutcomeSource(OutcomeSourceType outcomeSource) {
        this.outcomeSource = outcomeSource;
    }
    
}
