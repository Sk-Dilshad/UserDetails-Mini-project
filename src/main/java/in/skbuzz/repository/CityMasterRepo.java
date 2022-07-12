package in.skbuzz.repository;

import in.skbuzz.entity.CitiesMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityMasterRepo extends JpaRepository<CitiesMasterEntity,Integer> {

    public List<CitiesMasterEntity> findBystateId(Integer stateId);
}
