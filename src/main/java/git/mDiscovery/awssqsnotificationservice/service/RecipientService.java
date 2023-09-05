package git.mDiscovery.awssqsnotificationservice.service;

import git.mDiscovery.awssqsnotificationservice.dto.RecipientDto;
import git.mDiscovery.awssqsnotificationservice.entity.NotificationEntity;
import git.mDiscovery.awssqsnotificationservice.entity.RecipientEntity;
import git.mDiscovery.awssqsnotificationservice.mapper.RecipientMapper;
import git.mDiscovery.awssqsnotificationservice.repository.NotificationRepository;
import git.mDiscovery.awssqsnotificationservice.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findWithNotificationByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                        notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipient = tuples.getT1();
                    List<NotificationEntity> notifications = tuples.getT2();
                    recipient.setNotifications(notifications);
                    return recipientMapper.map(recipient);
                });
    }


}
