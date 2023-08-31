package git.mDiscovery.awssqsnotificationservice.repository;

import git.mDiscovery.awssqsnotificationservice.entity.RecipientEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<RecipientEntity, String> {
}
