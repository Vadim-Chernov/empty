package cvr.bercut.empty.repo;

import cvr.bercut.empty.model.BaseObject;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan(basePackageClasses = BaseObject.class)
public interface BaseObjectRepository extends JpaRepository<BaseObject, Long> {
    List<BaseObject> findByName(String name);
    List<BaseObject> All();
}
