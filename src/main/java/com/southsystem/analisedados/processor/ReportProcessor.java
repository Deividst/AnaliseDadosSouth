package com.southsystem.analisedados.processor;

import com.southsystem.analisedados.config.PathConfig;
import com.southsystem.analisedados.dto.ReportDto;
import com.southsystem.analisedados.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

@Component
public class ReportProcessor extends Thread {

    private final InputFileProcessor inputFileProcessor;
    private final OutputFileProcessor outputFileProcessor;

    @Autowired
    public ReportProcessor(InputFileProcessor inputFileProcessor, OutputFileProcessor outputFileProcessor) {
        this.inputFileProcessor = inputFileProcessor;
        this.outputFileProcessor = outputFileProcessor;
    }

    private static final Path folder = PathConfig.PATH_IN;

    @Override
    public void run() {

        WatchService watchService;

        try {
            createFolderIfNotExist();
            watchService = FileSystems.getDefault().newWatchService();

            folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key;
                key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    Path path = (Path) event.context();
                    Path filePath = Paths.get(String.valueOf(folder), String.valueOf(path.toString()));

                    ReportDto dto = inputFileProcessor.process(filePath);
                    outputFileProcessor.process(dto);

                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createFolderIfNotExist() throws IOException {
        FileUtil.createFolder(PathConfig.PATH_DATA);
        FileUtil.createFolder(PathConfig.PATH_IN);
        FileUtil.createFolder(PathConfig.PATH_OUT);
    }
}
