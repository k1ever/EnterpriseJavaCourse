package com.mvc.library.controller;

import com.mvc.library.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by svoitenko on 25 Nov 2015.
 */
@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    StatisticService statisticService;

    @RequestMapping(value = "/byuser/{userId}", method = RequestMethod.GET)
    public String getUserReport(Model model, @PathVariable int userId) {
        model.addAttribute("userReport", statisticService.getUserReport(userId));
        return "userReportPage";
    }

    @RequestMapping(value = "/bybook/{bookId}", method = RequestMethod.GET)
    public String getBookReport(Model model, @PathVariable int bookId) {
        model.addAttribute("bookReport", statisticService.getBookReport(bookId));
        return "bookReportPage";
    }

}
