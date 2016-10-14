
package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "OutcomeSourceType", namespace = "http://www.thomsonreuters.com/GRC/JetStream/schema/TaskPayload/v1")
@XmlEnum
public enum OutcomeSourceType {

    @XmlEnumValue("WorkStream")
    WORK_STREAM("WorkStream"),
    
    @XmlEnumValue("WorkOrder")
    WORK_ORDER("WorkOrder"),
    
    @XmlEnumValue("WorkSpace")
    WORK_SPACE("WorkSpace"),
    
    @XmlEnumValue("Activiti")
    ACTIVITI("Activiti");
    
    private final String value;

    OutcomeSourceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OutcomeSourceType fromValue(String v) {
        for (OutcomeSourceType c: OutcomeSourceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
