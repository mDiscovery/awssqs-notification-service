package git.mDiscovery.awssqsnotificationservice.poller;

import git.mDiscovery.awssqsnotificationservice.dto.NotificationDto;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class SQSNotificationsPoller {
    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto message) {
        log.info("received notification: {}", message);}
}
