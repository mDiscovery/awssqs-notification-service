package git.mDiscovery.awssqsnotificationservice.mapper;

import git.mDiscovery.awssqsnotificationservice.dto.NotificationDto;
import git.mDiscovery.awssqsnotificationservice.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationDto map(NotificationEntity entity);
    @InheritInverseConfiguration
    NotificationEntity map(NotificationDto dto);
}
