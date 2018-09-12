/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prayertimes.prayertimes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author fatih
 */
@Entity
@Table(name = "cities")
@NamedQueries({
@NamedQuery(name="City.findAll", query="SELECT e FROM City e where 1=1"),
//@NamedQuery(name="City.findByCountry", query="SELECT e FROM City e where e.country = :country"),
@NamedQuery(name="City.countAll", query="SELECT COUNT(e) FROM City e")
})
@NamedNativeQuery(name = "City.findbyname", query = "SELECT * FROM prayertimes.cities where MATCH(name) AGAINST ('*yenikoy*' IN BOOLEAN MODE);", resultClass = City.class)

//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},         allowGetters = true)
public class City extends AbstractEntity implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCitynumber() {
        return citynumber;
    }

    public void setCitynumber(String citynumber) {
        this.citynumber = citynumber;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @NotBlank
    private String name;

    @NotBlank
    private String countrycode;

    @NotBlank
    private String code;
    private String citynumber;
    
    private BigDecimal latitude;
    private BigDecimal  longitude;
    private Long population;
    
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;    
    
}
