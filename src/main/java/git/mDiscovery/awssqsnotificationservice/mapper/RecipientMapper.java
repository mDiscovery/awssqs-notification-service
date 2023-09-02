package git.mDiscovery.awssqsnotificationservice.mapper;

import ch.qos.logback.core.model.ComponentModel;
import git.mDiscovery.awssqsnotificationservice.dto.NotificationDto;
import git.mDiscovery.awssqsnotificationservice.dto.RecipientDto;
import git.mDiscovery.awssqsnotificationservice.entity.NotificationEntity;
import git.mDiscovery.awssqsnotificationservice.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {
    RecipientDto map(RecipientEntity entity);

    @InheritInverseConfiguration
    RecipientEntity map(RecipientDto dto);
}
