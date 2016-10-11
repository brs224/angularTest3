package com.thomsonreuters.grc.workflow.domain;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkStreamType", propOrder = {
	    "id",
	    "uuid",
	    "workOrderId",
	    "workOrderUuid",
	    "regarding",
	    "status",
            "hasChanged",
            "updatedBy",
            "updatedByToken",
            "isAmendPublishProduct",
            "amendedProductId",
            "isManualWorkOrder",
	    "workProduct",
	    "workProductId",
	    "baseWorkProduct",
	    "baseWorkProductId",
	    "publishMethod",
	    "country",
	    "countryConceptId",
	    "region",
	    "regionConceptId",
	    "jurisdiction",
	    "jurisdictionConceptId",
	    "regulator",
	    "regulatorConceptId",
	    "sector",
	    "sectorConceptId",
	    "vertical",
	    "priority",
	    "dueDate",
	    "attemptedPublishDate",
            "sourceCitation",
	    "customLabel1",
	    "customLabel2",
	    "customLabel3",
	    "customLabel4",
	    "sourceDocument",
	    "targetDocument"
})
public class WorkStreamType {
    public static final String STATUS_NEW = "New";
    @XmlElement
    protected BigInteger id;
    @XmlElement
    protected String uuid;
    @XmlElement
    protected BigInteger workOrderId;
    @XmlElement
    protected String workOrderUuid;
    @XmlElement
    protected String regarding;
    @XmlElement
    protected String status;
    protected boolean hasChanged;
    @XmlElement
    protected boolean isAmendPublishProduct;
    @XmlElement
    protected String amendedProductId;
    @XmlElement
    protected boolean isManualWorkOrder;
    @XmlElement
    protected String updatedBy;
    @XmlElement
    protected String updatedByToken;
    @XmlElement
    protected String workProduct;
    @XmlElement
    protected String workProductId;
    @XmlElement
    protected String baseWorkProduct;
    @XmlElement
    protected String baseWorkProductId;
    @XmlElement
    protected String publishMethod;
    @XmlElement
    protected String country;
    @XmlElement
    protected String countryConceptId;
    @XmlElement
    protected String region;
    @XmlElement
    protected String regionConceptId;
    @XmlElement
    protected String jurisdiction;
    @XmlElement
    protected String jurisdictionConceptId;
    @XmlElement
    protected String regulator;
    @XmlElement
    protected String regulatorConceptId;
    @XmlElement
    protected String sector;
    @XmlElement
    protected String sectorConceptId;
    @XmlElement
    protected String vertical;
    @XmlElement
    protected String priority;
    @XmlElement
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dueDate;
    @XmlElement
    protected String attemptedPublishDate;
    @XmlElement
    protected String sourceCitation;
    @XmlElement
    protected String customLabel1;
    @XmlElement
    protected String customLabel2;
    @XmlElement
    protected String customLabel3;
    @XmlElement
    protected String customLabel4;
    @XmlElement
    protected DocumentType sourceDocument;
    @XmlElement
    protected DocumentType targetDocument;
   
    public WorkStreamType() {
    	
    }

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

    public String getRegarding() {
        return regarding;
    }

    public void setRegarding(String regarding) {
        this.regarding = regarding;
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

    public boolean isAmendPublishProduct() {
        return isAmendPublishProduct;
    }

    public void setAmendPublishProduct(boolean isAmendPublishProduct) {
        this.isAmendPublishProduct = isAmendPublishProduct;
    }

    public String getAmendedProductId() {
        return amendedProductId;
    }

    public void setAmendedProductId(String amendedProductId) {
        this.amendedProductId = amendedProductId;
    }

    public boolean isManualWorkOrder() {
        return isManualWorkOrder;
    }

    public void setManualWorkOrder(boolean isManualWorkOrder) {
        this.isManualWorkOrder = isManualWorkOrder;
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

    public String getWorkProduct() {
        return workProduct;
    }

    public void setWorkProduct(String workProduct) {
        this.workProduct = workProduct;
    }

    public String getWorkProductId() {
        return workProductId;
    }

    public void setWorkProductId(String workProductId) {
        this.workProductId = workProductId;
    }

    public String getBaseWorkProduct() {
        return baseWorkProduct;
    }

    public void setBaseWorkProduct(String baseWorkProduct) {
        this.baseWorkProduct = baseWorkProduct;
    }

    public String getBaseWorkProductId() {
        return baseWorkProductId;
    }

    public void setBaseWorkProductId(String baseWorkProductId) {
        this.baseWorkProductId = baseWorkProductId;
    }

    public String getPublishMethod() {
        return publishMethod;
    }

    public void setPublishMethod(String publishMethod) {
        this.publishMethod = publishMethod;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryConceptId() {
        return countryConceptId;
    }

    public void setCountryConceptId(String countryConceptId) {
        this.countryConceptId = countryConceptId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionConceptId() {
        return regionConceptId;
    }

    public void setRegionConceptId(String regionConceptId) {
        this.regionConceptId = regionConceptId;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getJurisdictionConceptId() {
        return jurisdictionConceptId;
    }

    public void setJurisdictionConceptId(String jurisdictionConceptId) {
        this.jurisdictionConceptId = jurisdictionConceptId;
    }

    public String getRegulator() {
        return regulator;
    }

    public void setRegulator(String regulator) {
        this.regulator = regulator;
    }

    public String getRegulatorConceptId() {
        return regulatorConceptId;
    }

    public void setRegulatorConceptId(String regulatorConceptId) {
        this.regulatorConceptId = regulatorConceptId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSectorConceptId() {
        return sectorConceptId;
    }

    public void setSectorConceptId(String sectorConceptId) {
        this.sectorConceptId = sectorConceptId;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(XMLGregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }

    public String getAttemptedPublishDate() {
        return attemptedPublishDate;
    }

    public void setAttemptedPublishDate(String attemptedPublishDate) {
        this.attemptedPublishDate = attemptedPublishDate;
    }

    public String getSourceCitation() {
        return sourceCitation;
    }

    public void setSourceCitation(String sourceCitation) {
        this.sourceCitation = sourceCitation;
    }

    public String getCustomLabel1() {
        return customLabel1;
    }

    public void setCustomLabel1(String customLabel1) {
        this.customLabel1 = customLabel1;
    }

    public String getCustomLabel2() {
        return customLabel2;
    }

    public void setCustomLabel2(String customLabel2) {
        this.customLabel2 = customLabel2;
    }

    public String getCustomLabel3() {
        return customLabel3;
    }

    public void setCustomLabel3(String customLabel3) {
        this.customLabel3 = customLabel3;
    }

    public String getCustomLabel4() {
        return customLabel4;
    }

    public void setCustomLabel4(String customLabel4) {
        this.customLabel4 = customLabel4;
    }

    public DocumentType getSourceDocument() {
        return sourceDocument;
    }

    public void setSourceDocument(DocumentType sourceDocument) {
        this.sourceDocument = sourceDocument;
    }

    public DocumentType getTargetDocument() {
        return targetDocument;
    }

    public void setTargetDocument(DocumentType targetDocument) {
        this.targetDocument = targetDocument;
    }

    public static String getStatusNew() {
        return STATUS_NEW;
    }
    
}
