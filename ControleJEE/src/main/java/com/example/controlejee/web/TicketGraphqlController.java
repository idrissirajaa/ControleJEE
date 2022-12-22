package com.example.controlejee.web;

import com.example.controlejee.dtos.TicketDTORequest;
import com.example.controlejee.entities.Ticket;
import com.example.controlejee.services.Ticket.TicketServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class TicketGraphqlController {
    @Autowired
    private TicketServices ticketServices;

    @MutationMapping
    private Ticket achatTicket(@Argument TicketDTORequest ticketDTORequest){
        return ticketServices.achatTicket(ticketDTORequest);
    }

    @MutationMapping
    private void modificationTicket(@Argument Long id){
        ticketServices.modificationTicket(id);
    }
}
