package com.example.controlejee.services.Match;

import com.example.controlejee.dtos.MatchDTORequest;
import com.example.controlejee.entities.Match;

import java.util.List;

public interface MatchServices {


    Match ajoutMatch(MatchDTORequest matchInputDto);
    List<Match> listMatch();
}
