package Robin.TechItEasy.repository;

import Robin.TechItEasy.model.CiModule;
import Robin.TechItEasy.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {
}
