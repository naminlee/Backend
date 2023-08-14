package LikeLion.UnderTheCBackend.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "payment")
public class B_Payment {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "merchant_uid", nullable = false, columnDefinition = "varchar(55)", unique = true)
    private String merchantUid;

    @Nullable
    @Column(columnDefinition = "varchar(20)")
    String status;

    @NonNull
    @Column(nullable = false, columnDefinition = "decimal(64,0)")
    BigDecimal amount;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String name;

    @Column(name = "call_number", nullable = false, columnDefinition = "varchar(20)")
    private String callNumber;

    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String address;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String method;

    @CreatedDate
    @Column(updatable = false)
    private Date created_at;

    @NonNull
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User UserId;
}
