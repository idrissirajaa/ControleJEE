package com.example.controlejee.services.Ticket;
import com.example.controlejee.dtos.TicketDTORequest;
import com.example.controlejee.entities.Match;
import com.example.controlejee.entities.Ticket;
import com.example.controlejee.enums.Status;
import com.example.controlejee.repositories.MatchRepository;
import com.example.controlejee.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class TicketServicesImpl implements TicketServices {
    MatchRepository matchRepository;
    TicketRepository ticketRepository;
    public TicketServicesImpl(MatchRepository matchRepository, TicketRepository ticketRepository) {
        this.matchRepository =matchRepository;
        this.ticketRepository =ticketRepository;
    }
    @Override
    public Ticket achatTicket(TicketDTORequest ticketDTORequest){
        Match m=matchRepository.findById(ticketDTORequest.getMatchId()).get();
        Ticket ticket=Ticket.builder()
                .reference(UUID.randomUUID().toString().substring(0,16))
                .price(ticketDTORequest.getPrice())
                .state(Status.ENABLED)
                .match(m)
                .build();
        ticketRepository.save(ticket);
        return ticket;
    }
    @Override
    public void modificationTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).get();
        ticket.setState(Status.DISABLED);
    }
}
