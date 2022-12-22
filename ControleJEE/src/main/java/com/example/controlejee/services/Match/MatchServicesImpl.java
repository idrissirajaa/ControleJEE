package com.example.controlejee.services.Match;
import com.example.controlejee.dtos.MatchDTORequest;
import com.example.controlejee.entities.Match;
import com.example.controlejee.repositories.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MatchServicesImpl implements MatchServices {
    MatchRepository matchRepository;

    public MatchServicesImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match ajoutMatch(MatchDTORequest matchDTORequest)  {
        Match match=Match.builder()
                .date(new Date())
                .reference(UUID.randomUUID().toString())
                .stadium(matchDTORequest.getStadium())
                .team1(matchDTORequest.getTeam1())
                .team2(matchDTORequest.getTeam2())
                .build();
        matchRepository.save(match);
        return match;
    }

    @Override
    public List<Match> listMatch() {
        return matchRepository.findAll();
    }
}
