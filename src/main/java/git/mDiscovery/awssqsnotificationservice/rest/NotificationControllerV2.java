package git.mDiscovery.awssqsnotificationservice.rest;

import git.mDiscovery.awssqsnotificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/notifications")
public class NotificationControllerV2 {
    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> findByUid(@PathVariable String uid) {
        return notificationService.findWithRecipientByUid(uid);
    }
}
