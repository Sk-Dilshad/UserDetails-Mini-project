package in.skbuzz.entity;

import javax.persistence.*;

@Entity
@Table(name = "STATE_MASTER")
public class StateMasterEntity {

    @Id
    @GeneratedValue
    @Column(name ="STATE_ID")
    private Integer stateId;

    @Column(name ="STATE_NAME")
    private String stateName;

    @Column(name ="COUNTRY_ID")
    private String countryId;

    public StateMasterEntity(Integer stateId, String stateName, String countryId) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.countryId = countryId;
    }

    public StateMasterEntity() {
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
