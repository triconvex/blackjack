package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Chip;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class User extends BasePlayer {
    public static final int DEFAULT_CHIP_AMOUNT = 2000;

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 2, max = 20)
    @Column(unique = true, nullable = false, length = 20)
    private String userId;

    @Size(min = 4, max = 20)
    @Column(nullable = false, length = 20)
    private String password;

    @Size(min = 2, max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @Embedded
    private Chip chip = new Chip(DEFAULT_CHIP_AMOUNT);

    public void betChip(int amount) {
        this.chip = this.chip.subtract(amount);
    }

    public boolean isVerified(String password) {
        return this.password.equals(password);
    }
}
