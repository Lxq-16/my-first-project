package com.club.controller;
import com.club.common.result.Result;
import com.club.entity.ClubMember;
import com.club.service.ClubMemberService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/clubMember")
public class ClubMemberController {
    @Resource
    private ClubMemberService clubMemberService;

    @GetMapping("/list/{clubId}")
    public Result<?> list(@PathVariable Long clubId){
        return clubMemberService.getMemberByClubId(clubId);
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody ClubMember member){
        return clubMemberService.addMember(member);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody ClubMember member){
        return clubMemberService.updateMember(member);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        return clubMemberService.removeMember(id);
    }
}