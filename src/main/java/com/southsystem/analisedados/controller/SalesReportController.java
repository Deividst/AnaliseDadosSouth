package com.southsystem.analisedados.controller;

import com.southsystem.analisedados.processor.ReportProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlador que inicializa a Thread do relatório.
 *
 * @author Deivid
 */
@Controller
public class SalesReportController {

    @Autowired
    public SalesReportController(ReportProcessor processor) {
        processor.start();
    }
}
