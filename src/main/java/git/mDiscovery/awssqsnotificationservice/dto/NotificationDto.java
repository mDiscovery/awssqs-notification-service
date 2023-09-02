package git.mDiscovery.awssqsnotificationservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NotificationDto(String id,
                              String subject,
                              String body,
                              String recipientUid,
                              RecipientDto recipient) {
}

