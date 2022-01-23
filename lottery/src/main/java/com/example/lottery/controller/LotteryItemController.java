package com.example.lottery.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lottery.constants.ReturnCodeEnum;
import com.example.lottery.dal.model.LotteryRecord;
import com.example.lottery.service.ILotteryRecordService;
import com.example.lottery.service.dto.ResultResp;
import com.example.lottery.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/lottery-count")
public class LotteryItemController {

    @Autowired
    ILotteryRecordService lotteryRecordService;

    @GetMapping
    public ResultResp<Integer> count() {
        ResultResp<Integer> resultResp = new ResultResp();
        QueryWrapper<LotteryRecord> queryWrapper = new QueryWrapper<LotteryRecord>();
        //当天的零点
        queryWrapper.gt("createTime", Instant.ofEpochMilli(DateUtil.getTodayZero().getTime()).atZone(ZoneId.systemDefault()));
        resultResp.setMsg(ReturnCodeEnum.SUCCESS.getMsg());
        resultResp.setCode(ReturnCodeEnum.SUCCESS.getCode());
        resultResp.setResult(lotteryRecordService.count(queryWrapper));
        return resultResp;
    }
}
