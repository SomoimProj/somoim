package com.Oinzo.somoim.club.controller;

import com.Oinzo.somoim.club.entity.*;
import com.Oinzo.somoim.club.repository.*;
import com.Oinzo.somoim.club.service.ClubService;
import com.Oinzo.somoim.common.exception.BaseException;
import com.Oinzo.somoim.common.exception.BaseResponse;
import com.Oinzo.somoim.common.exception.BaseResponseStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.Oinzo.somoim.common.exception.BaseResponseStatus.Fail;


@RestController
@AllArgsConstructor
@RequestMapping("/club")
public class ClubController {

    private final ClubService clubService;


    @ResponseBody
    @PostMapping()
    public BaseResponse<?> addClub(@RequestBody Club request){
        Club club = clubService.addClub(request);
        return new BaseResponse<>(club);
    }

    @GetMapping()
    public BaseResponse<?> readClubByName(@RequestBody String name){
        if(name!=null){
            return new BaseResponse<>(clubService.readClubByName(name));
        }
        else{
            return new BaseResponse<>(Fail);
        }
    }

    @GetMapping("/favorite")
    public BaseResponse<?> readClubByFavorite(@RequestBody String favorite,String area){
        if(favorite!=null){
            return new BaseResponse<>(clubService.readClubByFavorite(favorite,area));
        }
        else{
            return new BaseResponse<>(Fail);
        }
    }
}
