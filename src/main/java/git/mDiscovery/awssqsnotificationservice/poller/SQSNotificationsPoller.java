package git.mDiscovery.awssqsnotificationservice.poller;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class SQSNotificationsPoller {
    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(String message) {
        log.info("received notification: {}", message);}
}
