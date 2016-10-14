
package com.thomsonreuters.grc.workflow.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", namespace = "http://www.thomsonreuters.com/GRC/JetStream/entity/Document/v1", propOrder = {
    "id",
    "renditionId",
    "alertId",
    "url",
    "sourceUrl",
    "sourceUrlId",
    "title",
    "cite",
    "correlationId",
    "contentType",
    "contentTypeId",
    "complianceCompleteContentType",
    "complianceCompleteContentTypeId",
    "artifactDescriptorId",
    "contentTypeConceptId",
    "duplicate",
    "docType",
    "country",
    "countryConceptId",
    "region",
    "regionConceptId",
    "publicationDate",
    "effectiveDate",
    "sectorsConceptId",
    "jurisdiction",
    "jurisdictionConceptId",
    "regulator",
    "regulatorConceptId",
    "commentDates",
    "effectiveDates",
    "feedType",
    "docText",
    "documentNumber",
    "proxyUUID"
    
})
public class DocumentType {
    
    public DocumentType() {
	artifactDescriptorId = "";
	cite = "";
	complianceCompleteContentType = "";
	complianceCompleteContentTypeId = "";
	country = "";
	proxyUUID = "";
	title = "";
	countryConceptId = "";
    }

    @XmlElement
    protected String id;
    @XmlElement
    protected String renditionId;
    @XmlElement
    protected String alertId;
    @XmlElement
    protected String url;
    @XmlElement
    protected String sourceUrl;
    @XmlElement
    protected String sourceUrlId;
    @XmlElement
    protected String title;
    @XmlElement
    protected String cite;
    @XmlElement
    protected String correlationId;
    @XmlElement
    protected String contentType;
    @XmlElement
    protected String contentTypeId;
    @XmlElement
    protected String complianceCompleteContentType;
    @XmlElement
    protected String complianceCompleteContentTypeId;
    @XmlElement
    protected String artifactDescriptorId;
    @XmlElement
    protected String contentTypeConceptId;
    @XmlElement
    protected boolean duplicate;
    @XmlElement
    protected String docType;
    @XmlElement
    protected String country;
    @XmlElement
    protected String countryConceptId;
    @XmlElement
    protected String region;
    @XmlElement
    protected String regionConceptId;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar publicationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar effectiveDate;
    protected String sectorsConceptId;
    protected String jurisdiction;
    protected String jurisdictionConceptId;
    protected String regulator;
    protected String regulatorConceptId;
    @XmlElement
    protected String commentDates;
    @XmlElement
    protected String effectiveDates;
    @XmlElement
    protected String documentNumber;
    @XmlElement
    protected String feedType;
    @XmlElement
    protected String docText;
    @XmlElement
    protected String proxyUUID;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the renditionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenditionId() {
        return renditionId;
    }

    /**
     * Sets the value of the renditionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenditionId(String value) {
        this.renditionId = value;
    }

    /**
     * Gets the value of the alertId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertId() {
        return alertId;
    }

    /**
     * Sets the value of the alertId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertId(String value) {
        this.alertId = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the sourceUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * Sets the value of the sourceUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceUrl(String value) {
        this.sourceUrl = value;
    }

    /**
     * Gets the value of the sourceUrlId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceUrlId() {
        return sourceUrlId;
    }

    /**
     * Sets the value of the sourceUrlId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceUrlId(String value) {
        this.sourceUrlId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the cite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCite() {
        return cite;
    }

    /**
     * Sets the value of the cite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCite(String value) {
        this.cite = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the contentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentTypeId() {
        return contentTypeId;
    }

    /**
     * Sets the value of the contentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentTypeId(String value) {
        this.contentTypeId = value;
    }
    
    /**
     * Gets the value of the complianceCompleteContentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplianceCompleteContentType() {
        return complianceCompleteContentType;
    }

    /**
     * Sets the value of the complianceCompleteContentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplianceCompleteContentType(String value) {
        this.complianceCompleteContentType = value;
    }
    
    /**
     * Gets the value of the complianceCompleteContentTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplianceCompleteContentTypeId() {
        return complianceCompleteContentTypeId;
    }

    /**
     * Sets the value of the ccContentTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplianceCompleteContentTypeId(String value) {
        this.complianceCompleteContentTypeId = value;
    }

    /**
     * Gets the value of the artifactDescriptorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtifactDescriptorId() {
        return artifactDescriptorId;
    }

    /**
     * Sets the value of the artifactDescriptorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtifactDescriptorId(String value) {
        this.artifactDescriptorId = value;
    }

    /**
     * Gets the value of the contentTypeConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentTypeConceptId() {
        return contentTypeConceptId;
    }

    /**
     * Sets the value of the contentTypeConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentTypeConceptId(String value) {
        this.contentTypeConceptId = value;
    }

    /**
     * Gets the value of the duplicate property.
     * 
     */
    public boolean isDuplicate() {
        return duplicate;
    }

    /**
     * Sets the value of the duplicate property.
     * 
     */
    public void setDuplicate(boolean value) {
        this.duplicate = value;
    }

    /**
     * Gets the value of the docType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegion(String value) {
        this.region = value;
    }

    /**
     * Gets the value of the publicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the value of the publicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublicationDate(XMLGregorianCalendar value) {
        this.publicationDate = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the sectorsConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectorsConceptId() {
        return sectorsConceptId;
    }

    /**
     * Sets the value of the sectorsConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectorsConceptId(String value) {
        this.sectorsConceptId = value;
    }
 
    /**
     * Gets the value of the jurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the value of the jurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdiction(String value) {
        this.jurisdiction = value;
    }

    /**
     * Gets the value of the regulator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulator() {
        return regulator;
    }

    /**
     * Sets the value of the regulator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulator(String value) {
        this.regulator = value;
    }

    /**
     * Gets the value of the regulatorConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulatorConceptId() {
        return regulatorConceptId;
    }
    
    /**
     * Sets the value of the regulatorConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulatorConceptId(String value) {
        this.regulatorConceptId = value;
    }
    
    /**
     * Gets the value of the regionConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegionConceptId() {
        return regionConceptId;
    }
    
    /**
     * Sets the value of the regionConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegionConceptId(String value) {
        this.regionConceptId = value;
    }
    
    /**
     * Gets the value of the countryConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryConceptId() {
        return countryConceptId;
    }
    
    /**
     * Sets the value of the countryConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryConceptId(String value) {
        this.countryConceptId = value;
    }
    
    /**
     * Gets the value of the jurisdictionConceptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionConceptId() {
        return jurisdictionConceptId;
    }
    
    /**
     * Sets the value of the jurisdictionConceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionConceptId(String value) {
        this.jurisdictionConceptId = value;
    }

    public String getCommentDates() {
        return commentDates;
    }

    public void setCommentDates(String commentDates) {
        this.commentDates = commentDates;
    }

    public String getEffectiveDates() {
        return effectiveDates;
    }

    public void setEffectiveDates(String effectiveDates) {
        this.effectiveDates = effectiveDates;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getDocText() {
        return docText;
    }

    public void setDocText(String text) {
        this.docText = text;
    }

    public String getProxyUUID() {
        return proxyUUID;
    }

    public void setProxyUUID(String proxyUUID) {
        this.proxyUUID = proxyUUID;
    }
    
}
