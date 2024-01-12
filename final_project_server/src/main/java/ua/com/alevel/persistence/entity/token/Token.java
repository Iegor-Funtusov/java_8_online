package ua.com.alevel.persistence.entity.token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.entity.BaseEntity;
import ua.com.alevel.persistence.entity.user.User;

@Getter
@Setter
@Entity
@Table(name = "tokens")
public class Token extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String token;

    @Column(nullable = false)
    public Boolean expired;

    @ManyToOne
    public User user;

    public Token() {
        this.expired = false;
    }
}
