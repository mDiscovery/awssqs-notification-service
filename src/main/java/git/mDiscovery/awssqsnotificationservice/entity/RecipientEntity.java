package git.mDiscovery.awssqsnotificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flywaydb.core.internal.util.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("recipients")
public class RecipientEntity implements Persistable<String> {

    @Id
    private String id;
    @Column("channel")
    private String channel;
    @Column("address")
    private String address;
    @Column("fullName")
    private String fullName;

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }
}
