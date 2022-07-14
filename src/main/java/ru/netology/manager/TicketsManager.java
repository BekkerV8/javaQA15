package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {
    private TicketsRepository repository = new TicketsRepository();

    public TicketsManager() {
        this.repository = repository;
    }


    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[0];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }


    public Ticket[] getTickets() {
        Ticket[] tickets = repository.findAll();
        return tickets;
    }
}
