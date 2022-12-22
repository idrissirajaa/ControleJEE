package com.example.controlejee.web;

import com.example.controlejee.dtos.MatchDTORequest;
import com.example.controlejee.entities.Match;
import com.example.controlejee.services.Match.MatchServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MatchGraphqlController {
    @Autowired
    private MatchServices matchServices;

    @MutationMapping
    private Match ajoutMatch(@Argument MatchDTORequest matchDTORequest) {
        return matchServices.ajoutMatch(matchDTORequest);
    }

    @QueryMapping
    private List<Match> listMatch(){
        return matchServices.listMatch();
    }
}
