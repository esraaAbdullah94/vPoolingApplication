package com.example.Polling.Controller;

import com.example.Polling.Service.ReportServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/report")
public class PollReportController {
    @Autowired
    ReportServices reportServices;
    @RequestMapping(value = "/pollReport", method = RequestMethod.GET)
    public String pollReport() throws JRException, FileNotFoundException {
        return reportServices.pollReport();
    }
}
