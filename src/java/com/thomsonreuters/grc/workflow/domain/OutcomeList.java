package com.thomsonreuters.grc.workflow.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outcomeList", namespace = "http://www.thomsonreuters.com/GRC/JetStream/schema/TaskPayload/v1", propOrder = {
    "outcomeInfo"
})
public class OutcomeList {

    protected List<OutcomeInfoType> outcomeInfo;

    public List<OutcomeInfoType> getOutcomeInfo() {
        if (outcomeInfo == null) {
            outcomeInfo = new ArrayList<OutcomeInfoType>();
        }
        return this.outcomeInfo;
    }

    public void setOutcomeInfo(List<OutcomeInfoType> outcomeInfo) {
        this.outcomeInfo = outcomeInfo;
    }

}
