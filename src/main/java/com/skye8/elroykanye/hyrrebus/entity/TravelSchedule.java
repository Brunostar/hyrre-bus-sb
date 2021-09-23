package com.skye8.elroykanye.hyrrebus.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Table(name = "travel_schedule")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class TravelSchedule implements Serializable {
    private static final long serialVersionUID = 5439613684461611827L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id", nullable = false)
    private Long scheduleId;

    @Column(name = "departure_date", nullable = false)
    private Instant departureDate;

    @Column(name = "departure_time", nullable = false)
    private Instant departureTime;

    @Column(name = "total_fare", nullable = false)
    private Long totalFare;

    @OneToMany(mappedBy = "travelSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusSeat> busSeats;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "travel_route_route_id", nullable = false)
    private TravelRoute travelRoute;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_customer_id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "travelSchedule", optional = false, orphanRemoval = true)
    private TravelTicket travelTicket;

}