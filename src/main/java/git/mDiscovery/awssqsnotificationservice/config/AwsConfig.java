package git.mDiscovery.awssqsnotificationservice.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

import static com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder.standard;

@Configuration
public class AwsConfig {

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(
            @Value("spring.cloud.aws.credentials.access-key") String accessKey,
            @Value("spring.cloud.aws.credentials.secret-key") String secretKey) {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
    }

    @Bean
    public AwsCredentialsProvider awsAsyncCredentialsProvider(
            @Value("spring.cloud.aws.credentials.access-key") String accessKey,
            @Value("spring.cloud.aws.credentials.secret-key") String secretKey) {
        return StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));
    }

    @Bean
    public AmazonSQSAsync amazonSQSAsync(AWSCredentialsProvider awsCredentialsProvider,
                                         @Value("") String region) {
        return AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(region)
                .build();
    }
}
