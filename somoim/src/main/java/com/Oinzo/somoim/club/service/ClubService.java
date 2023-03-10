package com.Oinzo.somoim.club.service;

import com.Oinzo.somoim.club.entity.*;
import com.Oinzo.somoim.club.repository.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;

    public Club addClub(Club club){
        Club newClub = Club.builder()
                        .name(club.getName())
                        .description(club.getDescription())
                        .imageUrl(club.getImageUrl())
                        .area(club.getArea())
                        .memberLimit(club.getMemberLimit())
                        .memberCnt(club.getMemberCnt())
                        .favorite(club.getFavorite()).build();
        clubRepository.save(newClub);
        return club;
    }

    public List<Club> readClubByName(String name){
        List<Club> club = clubRepository.findAllByNameLike(name);
        return club;
    }

    public List<Club> readClubByFavorite(String favorite,String area){
        List<Club> club = clubRepository.findAllByFavoriteLikeAndAreaLike(favorite,area);
        return club;
    }

}
