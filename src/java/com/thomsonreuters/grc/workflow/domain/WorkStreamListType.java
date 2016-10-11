package com.thomsonreuters.grc.workflow.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkStreamListType", namespace = "http://www.thomsonreuters.com/GRC/JetStream/entity/WorkOrder/v1", propOrder = {
    "workStream"
})
public class WorkStreamListType {

    @XmlElement(namespace = "http://www.thomsonreuters.com/GRC/JetStream/entity/WorkStream/v1")
    protected List<WorkStreamType> workStream;

    public List<WorkStreamType> getWorkStream() {
        if (workStream == null) {
            workStream = new ArrayList<WorkStreamType>();
        }
        return this.workStream;
    }

    public void setWorkStream(List<WorkStreamType> workStream) {
        this.workStream = workStream;
    }  

}
