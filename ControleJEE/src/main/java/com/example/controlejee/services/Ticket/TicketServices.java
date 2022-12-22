package com.example.controlejee.services.Ticket;

import com.example.controlejee.dtos.TicketDTORequest;
import com.example.controlejee.entities.Ticket;

public interface TicketServices {

    Ticket achatTicket(TicketDTORequest ticketDTORequest);

    void modificationTicket(Long ticketId);
}
