package git.mDiscovery.awssqsnotificationservice.service;

import git.mDiscovery.awssqsnotificationservice.mapper.RecipientMapper;
import git.mDiscovery.awssqsnotificationservice.repository.NotificationRepository;
import git.mDiscovery.awssqsnotificationservice.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper notificationMapper;

}
