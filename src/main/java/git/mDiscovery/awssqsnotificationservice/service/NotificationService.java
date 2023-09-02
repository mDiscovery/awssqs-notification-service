package git.mDiscovery.awssqsnotificationservice.service;

import git.mDiscovery.awssqsnotificationservice.dto.NotificationDto;
import git.mDiscovery.awssqsnotificationservice.mapper.NotificationMapper;
import git.mDiscovery.awssqsnotificationservice.repository.NotificationRepository;
import git.mDiscovery.awssqsnotificationservice.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findByUid(String uid) {
        return notificationRepository.findById(uid)
                .map(notificationMapper::map);
    }
}
