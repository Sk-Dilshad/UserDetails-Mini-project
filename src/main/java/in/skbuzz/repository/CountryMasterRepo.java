package in.skbuzz.repository;

import in.skbuzz.entity.CountryMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryMasterRepo extends JpaRepository<CountryMasterEntity, Integer> {

}
