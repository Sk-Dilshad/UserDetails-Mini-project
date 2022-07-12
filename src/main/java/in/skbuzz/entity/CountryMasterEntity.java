package in.skbuzz.entity;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryMasterEntity {

    @Id
    @GeneratedValue
    @Column(name = "COUNTRY_ID")
    private Integer countryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    public CountryMasterEntity(Integer countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public CountryMasterEntity() {
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
