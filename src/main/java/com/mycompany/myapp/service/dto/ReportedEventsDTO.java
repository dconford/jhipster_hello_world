package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.ReportedEvents} entity.
 */
public class ReportedEventsDTO implements Serializable {

    private Long id;

    private String complaintId;

    private String codedMonth;

    private Integer codedMonthAsInt;

    private String eventOccurred;

    private String newCrimeflag;

    private String crimeUnfoundedFlag;

    private String administrativeAdjustmentFlag;

    private Integer count;

    private String cleanupFlag;

    private Integer crimeCode;

    private Integer districtCode;

    private String eventDescription;

    private String ileadsAddressNumber;

    private String ileadsStreetName;

    private Integer neighborhoodCode;

    private String eventLocationName;

    private String eventLocationComment;

    private String cadStreetNumber;

    private String cadStreetName;

    private String xCoordinates;

    private String yCoordinates;

    private Integer crimeCategoryShortened;

    private LocalDate newDateField;


    private Long crimeCategoryDataId;

    private Long neighborhoodDataId;

    private Long codedDateDataId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getCodedMonth() {
        return codedMonth;
    }

    public void setCodedMonth(String codedMonth) {
        this.codedMonth = codedMonth;
    }

    public Integer getCodedMonthAsInt() {
        return codedMonthAsInt;
    }

    public void setCodedMonthAsInt(Integer codedMonthAsInt) {
        this.codedMonthAsInt = codedMonthAsInt;
    }

    public String getEventOccurred() {
        return eventOccurred;
    }

    public void setEventOccurred(String eventOccurred) {
        this.eventOccurred = eventOccurred;
    }

    public String getNewCrimeflag() {
        return newCrimeflag;
    }

    public void setNewCrimeflag(String newCrimeflag) {
        this.newCrimeflag = newCrimeflag;
    }

    public String getCrimeUnfoundedFlag() {
        return crimeUnfoundedFlag;
    }

    public void setCrimeUnfoundedFlag(String crimeUnfoundedFlag) {
        this.crimeUnfoundedFlag = crimeUnfoundedFlag;
    }

    public String getAdministrativeAdjustmentFlag() {
        return administrativeAdjustmentFlag;
    }

    public void setAdministrativeAdjustmentFlag(String administrativeAdjustmentFlag) {
        this.administrativeAdjustmentFlag = administrativeAdjustmentFlag;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCleanupFlag() {
        return cleanupFlag;
    }

    public void setCleanupFlag(String cleanupFlag) {
        this.cleanupFlag = cleanupFlag;
    }

    public Integer getCrimeCode() {
        return crimeCode;
    }

    public void setCrimeCode(Integer crimeCode) {
        this.crimeCode = crimeCode;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getIleadsAddressNumber() {
        return ileadsAddressNumber;
    }

    public void setIleadsAddressNumber(String ileadsAddressNumber) {
        this.ileadsAddressNumber = ileadsAddressNumber;
    }

    public String getIleadsStreetName() {
        return ileadsStreetName;
    }

    public void setIleadsStreetName(String ileadsStreetName) {
        this.ileadsStreetName = ileadsStreetName;
    }

    public Integer getNeighborhoodCode() {
        return neighborhoodCode;
    }

    public void setNeighborhoodCode(Integer neighborhoodCode) {
        this.neighborhoodCode = neighborhoodCode;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

    public void setEventLocationName(String eventLocationName) {
        this.eventLocationName = eventLocationName;
    }

    public String getEventLocationComment() {
        return eventLocationComment;
    }

    public void setEventLocationComment(String eventLocationComment) {
        this.eventLocationComment = eventLocationComment;
    }

    public String getCadStreetNumber() {
        return cadStreetNumber;
    }

    public void setCadStreetNumber(String cadStreetNumber) {
        this.cadStreetNumber = cadStreetNumber;
    }

    public String getCadStreetName() {
        return cadStreetName;
    }

    public void setCadStreetName(String cadStreetName) {
        this.cadStreetName = cadStreetName;
    }

    public String getxCoordinates() {
        return xCoordinates;
    }

    public void setxCoordinates(String xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    public String getyCoordinates() {
        return yCoordinates;
    }

    public void setyCoordinates(String yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    public Integer getCrimeCategoryShortened() {
        return crimeCategoryShortened;
    }

    public void setCrimeCategoryShortened(Integer crimeCategoryShortened) {
        this.crimeCategoryShortened = crimeCategoryShortened;
    }

    public LocalDate getNewDateField() {
        return newDateField;
    }

    public void setNewDateField(LocalDate newDateField) {
        this.newDateField = newDateField;
    }

    public Long getCrimeCategoryDataId() {
        return crimeCategoryDataId;
    }

    public void setCrimeCategoryDataId(Long crimeCategoryDataId) {
        this.crimeCategoryDataId = crimeCategoryDataId;
    }

    public Long getNeighborhoodDataId() {
        return neighborhoodDataId;
    }

    public void setNeighborhoodDataId(Long neighborhoodDataId) {
        this.neighborhoodDataId = neighborhoodDataId;
    }

    public Long getCodedDateDataId() {
        return codedDateDataId;
    }

    public void setCodedDateDataId(Long codedDateDataId) {
        this.codedDateDataId = codedDateDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReportedEventsDTO reportedEventsDTO = (ReportedEventsDTO) o;
        if (reportedEventsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reportedEventsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReportedEventsDTO{" +
            "id=" + getId() +
            ", complaintId='" + getComplaintId() + "'" +
            ", codedMonth='" + getCodedMonth() + "'" +
            ", codedMonthAsInt=" + getCodedMonthAsInt() +
            ", eventOccurred='" + getEventOccurred() + "'" +
            ", newCrimeflag='" + getNewCrimeflag() + "'" +
            ", crimeUnfoundedFlag='" + getCrimeUnfoundedFlag() + "'" +
            ", administrativeAdjustmentFlag='" + getAdministrativeAdjustmentFlag() + "'" +
            ", count=" + getCount() +
            ", cleanupFlag='" + getCleanupFlag() + "'" +
            ", crimeCode=" + getCrimeCode() +
            ", districtCode=" + getDistrictCode() +
            ", eventDescription='" + getEventDescription() + "'" +
            ", ileadsAddressNumber='" + getIleadsAddressNumber() + "'" +
            ", ileadsStreetName='" + getIleadsStreetName() + "'" +
            ", neighborhoodCode=" + getNeighborhoodCode() +
            ", eventLocationName='" + getEventLocationName() + "'" +
            ", eventLocationComment='" + getEventLocationComment() + "'" +
            ", cadStreetNumber='" + getCadStreetNumber() + "'" +
            ", cadStreetName='" + getCadStreetName() + "'" +
            ", xCoordinates='" + getxCoordinates() + "'" +
            ", yCoordinates='" + getyCoordinates() + "'" +
            ", crimeCategoryShortened=" + getCrimeCategoryShortened() +
            ", newDateField='" + getNewDateField() + "'" +
            ", crimeCategoryDataId=" + getCrimeCategoryDataId() +
            ", neighborhoodDataId=" + getNeighborhoodDataId() +
            ", codedDateDataId=" + getCodedDateDataId() +
            "}";
    }
}
