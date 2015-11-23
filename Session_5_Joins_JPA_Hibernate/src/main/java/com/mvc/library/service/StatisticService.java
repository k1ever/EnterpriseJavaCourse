package com.mvc.library.service;

import com.mvc.library.model.StatisticEntity;
import com.mvc.library.model.UserEntity;
import com.mvc.library.repository.StatisticRepository;
import com.mvc.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by svoitenko on 23 Nov 2015.
 */
@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public List<UserEntity> getStatistics(){
        return statisticRepository.getStatistics();
    }

    @Transactional
    public void addStatistic(StatisticEntity statistic){
        statisticRepository.addStatistic(statistic);
    }

    @Transactional
    public void updateStatistic(StatisticEntity statistic){
        statisticRepository.updateStatistic(statistic);
    }

}
