package com.example.MeowDate.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(name = "dateOfLike")
    private LocalDate dateOfLike;

    public Like() {}

    public Like(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.dateOfLike = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public LocalDate getDateOfLike() {
        return dateOfLike;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setDateOfLike(LocalDate dateOfLike) {
        this.dateOfLike = dateOfLike;
    }
}
