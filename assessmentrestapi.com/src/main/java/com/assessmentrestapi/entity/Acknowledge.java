package com.assessmentrestapi.entity;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "acknowledgements")
public class Acknowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String clientName;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm a z", timezone = "Asia/Kolkata")
    private LocalDateTime timestamp;

    public Acknowledge() {}

    public Acknowledge(String userName, String clientName, String message) {
        this.userName = userName;
        this.clientName = clientName;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z").withZone(ZoneId.of("Asia/Kolkata"));
        return "Acknowledge{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp.format(formatter) +
                '}';
    }
}