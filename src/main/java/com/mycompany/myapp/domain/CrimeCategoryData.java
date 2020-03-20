package com.mycompany.myapp.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A CrimeCategoryData.
 */
@Entity
@Table(name = "crime_category_data")
public class CrimeCategoryData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "crime_category_id", nullable = false)
    private Integer crimeCategoryId;

    @Column(name = "crime_category")
    private String crimeCategory;

    @OneToMany(mappedBy = "crimeCategoryData")
    private Set<ReportedEvents> reportedEvents = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCrimeCategoryId() {
        return crimeCategoryId;
    }

    public CrimeCategoryData crimeCategoryId(Integer crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
        return this;
    }

    public void setCrimeCategoryId(Integer crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
    }

    public String getCrimeCategory() {
        return crimeCategory;
    }

    public CrimeCategoryData crimeCategory(String crimeCategory) {
        this.crimeCategory = crimeCategory;
        return this;
    }

    public void setCrimeCategory(String crimeCategory) {
        this.crimeCategory = crimeCategory;
    }

    public Set<ReportedEvents> getReportedEvents() {
        return reportedEvents;
    }

    public CrimeCategoryData reportedEvents(Set<ReportedEvents> reportedEvents) {
        this.reportedEvents = reportedEvents;
        return this;
    }

    public CrimeCategoryData addReportedEvents(ReportedEvents reportedEvents) {
        this.reportedEvents.add(reportedEvents);
        reportedEvents.setCrimeCategoryData(this);
        return this;
    }

    public CrimeCategoryData removeReportedEvents(ReportedEvents reportedEvents) {
        this.reportedEvents.remove(reportedEvents);
        reportedEvents.setCrimeCategoryData(null);
        return this;
    }

    public void setReportedEvents(Set<ReportedEvents> reportedEvents) {
        this.reportedEvents = reportedEvents;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CrimeCategoryData)) {
            return false;
        }
        return id != null && id.equals(((CrimeCategoryData) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CrimeCategoryData{" +
            "id=" + getId() +
            ", crimeCategoryId=" + getCrimeCategoryId() +
            ", crimeCategory='" + getCrimeCategory() + "'" +
            "}";
    }
}
