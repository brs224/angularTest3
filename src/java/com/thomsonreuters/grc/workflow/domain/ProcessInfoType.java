
package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessInfoType", propOrder = {
    "version",
    "processOwnerId",
    "environment"
})
public class ProcessInfoType {

    @XmlElement
    protected String version;
    @XmlElement
    protected String processOwnerId;
    @XmlElement
    protected String environment;

 
    public ProcessInfoType() {
    	
    }


    public String getVersion() {
        return version;
    }


    public void setVersion(String version) {
        this.version = version;
    }


    public String getProcessOwnerId() {
        return processOwnerId;
    }


    public void setProcessOwnerId(String processOwnerId) {
        this.processOwnerId = processOwnerId;
    }


    public String getEnvironment() {
        return environment;
    }


    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    
    

}
