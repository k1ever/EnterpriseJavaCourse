package com.mvc.library.service;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.StatisticEntity;
import com.mvc.library.model.UserEntity;
import com.mvc.library.report.BookReport;
import com.mvc.library.report.UserReport;
import com.mvc.library.repository.StatisticRepository;
import com.mvc.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Date;
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
    public void setTaken(BookEntity book) {

        StatisticEntity statistic = new StatisticEntity();

        statistic.setUser(book.getUser());
        statistic.setBook(book);
        statistic.setTakeDate(new Date());

        statisticRepository.addStatistic(statistic);
    }

    @Transactional
    public void setReturnDate(BookEntity book) {
        statisticRepository.setReturnDate(book);
    }

    public List<UserReport> getUserReport(int userId){
        return statisticRepository.getUserReport(userId);
    }

    public List<BookReport> getBookReport(int bookId){
        return statisticRepository.getBookReport(bookId);
    }
}
