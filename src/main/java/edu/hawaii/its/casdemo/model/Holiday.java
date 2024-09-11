package edu.hawaii.its.casdemo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import edu.hawaii.its.casdemo.util.Dates;

@Entity
@Table(name = "holiday")
@JsonRootName("data")
public class Holiday implements Serializable {

    private static final long serialVersionUID = 53L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "version")
    @JsonIgnore
    private Integer version;

    @Column(name = "official_year", nullable = false)
    private Integer officialYear;

    @Column(name = "description")
    private String description;

    @Column(name = "observed_date")
    @JsonSerialize(using = HolidayDateShortSerializer.class)
    @JsonDeserialize(using = HolidayDateShortDeserializer.class)
    private LocalDate observedDate;

    @Column(name = "official_date")
    @JsonSerialize(using = HolidayDateShortSerializer.class)
    @JsonDeserialize(using = HolidayDateShortDeserializer.class)
    private LocalDate officialDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "holiday_type",
            joinColumns = @JoinColumn(name = "holiday_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    @OrderBy("sortId")
    private List<Type> types = new LinkedList<>();

    // Constructor.
    public Holiday() {
        // Empty, currently.
    }

    // Constructor.
    public Holiday(LocalDate officialDate, LocalDate observedDate) {
        this();
        this.officialDate = officialDate;
        this.observedDate = observedDate;
    }

    // Constructor.
    public Holiday(LocalDate officialDate, LocalDate observedDate, int year) {
        this(officialDate, observedDate);
        this.officialYear = year;
    }

    @Transient
    public Integer getYear() {
        if (officialDate != null) {
            return officialDate.getYear();
        }

        if (observedDate != null) {
            return observedDate.getYear();
        }

        return null;
    }

    public Integer getOfficialYear() {
        return officialYear;
    }

    public void setOfficialYear(Integer officialYear) {
        this.officialYear = officialYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    @JsonSerialize(using = HolidayDateSerializer.class)
    public LocalDate getOfficialDateFull() {
        return officialDate;
    }

    @Transient
    @JsonSerialize(using = HolidayDateSerializer.class)
    public LocalDate getObservedDateFull() {
        return observedDate;
    }

    public LocalDate getObservedDate() {
        return observedDate;
    }

    public void setObservedDate(LocalDate observedDate) {
        this.observedDate = observedDate;
    }

    public LocalDate getOfficialDate() {
        return officialDate;
    }

    public void setOfficialDate(LocalDate officialDate) {
        this.officialDate = officialDate;
    }

    @Transient
    @JsonIgnore
    public String getObservedDateStr() {
        return Dates.formatDate(observedDate, "yyyy-MM-dd");
    }

    @Transient
    @JsonIgnore
    public String getOfficialDateStr() {
        return Dates.formatDate(officialDate, "yyyy-MM-dd");
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types != null ? types : new ArrayList<>();
    }

    @Transient
    public void addType(Type type) {
        types.add(type);
    }

    @Transient
    @JsonGetter("types")
    public List<Type> getHolidayTypes() {
        return Collections.unmodifiableList(types);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((observedDate == null) ? 0 : observedDate.hashCode());
        result = prime * result + ((officialDate == null) ? 0 : officialDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Holiday other = (Holiday) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (observedDate == null) {
            if (other.observedDate != null)
                return false;
        } else if (!observedDate.equals(other.observedDate))
            return false;
        if (officialDate == null) {
            return other.officialDate == null;
        } else return officialDate.equals(other.officialDate);
    }

    @Override
    public String toString() {
        return "Holiday ["
                + "id=" + id
                + ", description=" + description
                + ", observedDate=" + observedDate
                + ", officialDate=" + officialDate
                + ", officialYear=" + officialYear
                + ", types=" + types
                + "]";
    }

}
