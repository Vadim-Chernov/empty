package cvr.bercut.empty.repo;

import cvr.bercut.empty.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackageClasses = User.class)
public interface UserRepository extends JpaRepository<User, Long> {

    User findByParoleAndName(String password, String name);
}
