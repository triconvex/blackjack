package com.zingoworks.blackjack.domain.player;

import com.zingoworks.blackjack.domain.Chip;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends BasePlayer {

    public static final GuestUser GUEST_USER = new GuestUser();
    public static final int DEFAULT_CHIP_AMOUNT = 2000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public User() {
    }

    public void betChip(int amount) {
        this.chip = this.chip.subtract(amount);
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isGuestUser() {
        return false;
    }

    public void update(User target) {
        if(this.userId.equals(target.userId) && matchPassword(target.password)) {
            this.name = target.name;
        }
    }

    private static class GuestUser extends User {
        @Override
        public boolean isGuestUser() {
            return true;
        }
    }

}
