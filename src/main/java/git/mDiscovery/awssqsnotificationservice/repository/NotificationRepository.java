package git.mDiscovery.awssqsnotificationservice.repository;

import git.mDiscovery.awssqsnotificationservice.entity.NotificationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<NotificationEntity, String> {
}
