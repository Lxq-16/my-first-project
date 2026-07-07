package com.club.controller;
import com.club.common.result.Result;
import com.club.entity.ClubType;
import com.club.service.ClubTypeService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/clubType")
public class ClubTypeController {
    @Resource
    private ClubTypeService clubTypeService;

    @GetMapping("/list")
    public Result<?> listAll(){
        return clubTypeService.listAll();
    }

    @PostMapping("/add")
    public Result<?> add(@RequestBody ClubType clubType){
        return clubTypeService.addType(clubType);
    }

    @PutMapping("/update")
    public Result<?> update(@RequestBody ClubType clubType){
        return clubTypeService.updateType(clubType);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        return clubTypeService.deleteType(id);
    }

    @GetMapping("/{id}")
    public Result<?> getInfo(@PathVariable Long id){
        return clubTypeService.getByIdInfo(id);
    }
}