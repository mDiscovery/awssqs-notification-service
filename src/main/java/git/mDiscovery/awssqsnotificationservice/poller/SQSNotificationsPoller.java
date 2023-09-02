package git.mDiscovery.awssqsnotificationservice.poller;

import git.mDiscovery.awssqsnotificationservice.dto.NotificationDto;
import git.mDiscovery.awssqsnotificationservice.entity.NotificationEntity;
import git.mDiscovery.awssqsnotificationservice.mapper.NotificationMapper;
import git.mDiscovery.awssqsnotificationservice.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SQSNotificationsPoller {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto message) {
        log.info("received notification: {}", message);
        NotificationEntity entity = notificationMapper.map(message);
        notificationRepository.save(entity).subscribe();
    }
}
