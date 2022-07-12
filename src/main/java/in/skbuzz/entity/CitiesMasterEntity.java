package in.skbuzz.entity;

import javax.persistence.*;

@Entity
@Table(name = "CITIES_MASTER")
public class CitiesMasterEntity {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID")
    private Integer cityId;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "STATE_ID")
    private String stateId;

    public CitiesMasterEntity(Integer cityId, String cityName, String stateId) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.stateId = stateId;
    }

    public CitiesMasterEntity() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
}
