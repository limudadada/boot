package com.example.web;

import com.alibaba.fastjson.JSONObject;
import com.example.model.EduScoreDTO;
import com.example.model.EduScoreItemDTO;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/test")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/do")
    @ResponseBody
    public Map<String, Object> test() {
        logger.info("------dddddddddddddd---------");
        String key = "redisLockKey";
        RLock lock = redissonClient.getLock(key);
        boolean lockd = false;
        if (lock != null) {
            try {
                lockd = lock.tryLock(0, 500, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.error("redisson getLock error");
            }
        }
        try {
            Map<String, Object> map = new HashMap<>();
            if (lockd) {
                logger.info("redisLockKey getLock success");
                Thread.sleep(10000);
                map.put("result", "succjenkioonds");
                return map;
            } else {
                map.put("result", "lockfail");
                logger.info("redisLockKey getLock fail");
                return map;
            }
        } catch (Exception e) {
            logger.error("RedissLockUtil lock error", e);
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()){
                lock.unlock();
                logger.info("redisLockKey unlock success");
            }
        }
        return null;
    }

    public static void main(String[] args){
        List<EduScoreDTO> list = new ArrayList<>();
        EduScoreDTO eduScoreDTO = new EduScoreDTO();
        EduScoreDTO eduScoreDTO1 = new EduScoreDTO();

        List<EduScoreItemDTO> eduScoreItemDTOList = new ArrayList<>();

        EduScoreItemDTO eduScoreItemDTO = new EduScoreItemDTO();
        eduScoreItemDTO.setSubject_name("subject");

        EduScoreItemDTO eduScoreItemDTO2 = new EduScoreItemDTO();
        eduScoreItemDTO2.setSubject_name("subject2");

        eduScoreItemDTOList.add(eduScoreItemDTO);
        eduScoreItemDTOList.add(eduScoreItemDTO2);

        List<EduScoreItemDTO> eduScoreItemDTOList2 = new ArrayList<>();
        EduScoreItemDTO eduScoreItemDTO3 = new EduScoreItemDTO();
        eduScoreItemDTO3.setSubject_name("subject3");
        eduScoreItemDTOList2.add(eduScoreItemDTO3);

        eduScoreDTO.setScore_items(eduScoreItemDTOList);
        eduScoreDTO1.setScore_items(eduScoreItemDTOList2);
        list.add(eduScoreDTO1);
        list.add(eduScoreDTO);

        eduScoreDTO.setSize(eduScoreItemDTOList.size());
        eduScoreDTO1.setSize(eduScoreItemDTOList2.size());

        Collections.sort(list, new Comparator<EduScoreDTO>() {
            @Override
            public int compare(EduScoreDTO o1, EduScoreDTO o2) {
                int i=o2.getScore_items().size()-o1.getScore_items().size();//升序
                // int i=o2.getMissId()-o1.getMissId();降序
                return i;
            }
        });


        System.out.println(JSONObject.toJSONString(list));

    }
}
