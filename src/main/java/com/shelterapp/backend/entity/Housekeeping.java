package com.shelterapp.backend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "housekept")
@Data
public class Housekeeping {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @NotNull
    private LocalDateTime submitTimestamp;

    private boolean cleanGroomRoom;

    private boolean emptyWashKongs;

    private boolean organizeVolArea;

    private boolean laundry;

    private boolean groundsKeeping;
}
