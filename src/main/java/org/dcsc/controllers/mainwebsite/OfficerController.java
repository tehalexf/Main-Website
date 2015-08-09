package org.dcsc.controllers.mainwebsite;

import org.dcsc.officers.DcscOfficer;
import org.dcsc.officers.DcscOfficerService;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by tktong on 7/28/2015.
 */
@Controller
public class OfficerController {
    @Autowired
    private DcscOfficerService dcscOfficerService;

    @RequestMapping(value = "/officers")
    public String officers(@RequestParam(value = "year", defaultValue = "0") int year, Model model) {
        List<Integer> years = dcscOfficerService.getDistinctYears();

        if(!years.contains(year)) {
            year = years.get(years.size()-1);
        }

        List<DcscOfficer> officerList = dcscOfficerService.getOfficers(year);

        model.addAttribute("officers", officerList);
        model.addAttribute("years", years);

        return "main/officers";
    }

    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException(TypeMismatchException e) {
        return "redirect:/officers";
    }
}
