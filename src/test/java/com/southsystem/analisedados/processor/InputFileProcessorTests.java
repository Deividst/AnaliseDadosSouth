package com.southsystem.analisedados.processor;

import com.southsystem.analisedados.config.PathConfig;
import com.southsystem.analisedados.dto.ReportDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Deivid
 */
public class InputFileProcessorTests {

    private InputFileProcessor processor = new InputFileProcessor();

    @Test
    public void shouldProcessFile() {
        createFile(PathConfig.PATH_IN);

        Path path = Paths.get(System.getProperty("user.home")
                + File.separator
                + "data"
                + File.separator
                + "in"
                + File.separator
                + "testes.dat");

        ReportDto dto = processor.process(path);

        Assert.assertTrue(!dto.getSaleList().isEmpty()
                && !dto.getSalesmanList().isEmpty()
                && !dto.getClientList().isEmpty());
    }

    private void createFile(Path path) {
        try {
            FileOutputStream fos = new FileOutputStream(path.toString()
                    + File.separator
                    + "testes."
                    + PathConfig.FILE_EXTENSION);

            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("001ç1234567891234çPedroç500000");
            bw.newLine();
            bw.write("001ç3245678865434çPauloç40000.99");
            bw.newLine();
            bw.write("002ç2345675434544345çJose da SilvaçRural");
            bw.newLine();
            bw.write("002ç2345675433444345çEduardo PereiraçRural");
            bw.newLine();
            bw.write("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro");
            bw.newLine();
            bw.write("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
