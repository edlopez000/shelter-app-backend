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
    @Column(name = "submit_timestamp")
    private LocalDateTime submitTimestamp;
    @Column(name = "h_clean_groom_room")
    private boolean hCleanGroomRoom;
    @Column(name = "h_empty_wash_kongs")
    private boolean hEmptyWashKongs;
    @Column(name = "h_organize_vol_area")
    private boolean hOrganizeVolArea;
    @Column(name = "h_laundry")
    private boolean hLaundry;
    @Column(name = "h_groundskeeping")
    private boolean hGroundskeeping;
}
