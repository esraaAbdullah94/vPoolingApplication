package com.example.Polling.Service;

import com.example.Polling.DTO.PollResultDto;
import com.example.Polling.DTO.ReportDto;
import com.example.Polling.Modle.Poll;
import com.example.Polling.Modle.PollChoice;
import com.example.Polling.Repository.PollRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServices {
    @Autowired
    PollRepository pollRepository;

    public static final String pathToReports = "C:\\Users\\user005\\Downloads\\PoolingApp-main\\PoolingApp-main\\Report";

    public String pollReport() throws FileNotFoundException, JRException {
        List<PollChoice> PollChoiceList = pollRepository.getPollReport();
        List<ReportDto> reportDtoList = new ArrayList<>();
        for(PollChoice pollChoice : PollChoiceList){
            String choice = pollChoice.getChoice();
            Integer votes = pollChoice.getVotes();
            ReportDto reportDto = new ReportDto(choice, votes);
            reportDtoList.add(reportDto);
        }

        File file = ResourceUtils.getFile("classpath:PollingVote.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportDtoList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Esraa");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Poll.pdf");
        return "Report generated : " + pathToReports + "\\Poll.pdf";
    }

}
