package in.skbuzz.repository;

import in.skbuzz.entity.StateMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateMasterRepo extends JpaRepository<StateMasterEntity, Integer> {

    public List<StateMasterEntity> findBycountryId(Integer countryId);

}
