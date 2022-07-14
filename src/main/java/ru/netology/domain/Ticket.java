package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int flightTime;

    @Override
    public int compareTo(Ticket c) {
        return this.cost - c.cost;
    }

}
