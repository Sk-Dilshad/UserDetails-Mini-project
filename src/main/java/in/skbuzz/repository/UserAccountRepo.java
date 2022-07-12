package in.skbuzz.repository;

import in.skbuzz.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccountEntity,Integer> {

    public  UserAccountEntity findByEmailAndPwd(String email, String pwd);
    public  UserAccountEntity  findByEmail(String email);
}
