package es.bogaservic.backendTOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.bogaservic.backendTOP.service.EmptyTrayInsertedFaultService;
import es.bogaservic.backendTOP.service.StartOfRecordingSessionService;

@SpringBootApplication
public class BackendTopApplication implements CommandLineRunner {

    @Autowired
    private StartOfRecordingSessionService SORS_Service;
    
    @Autowired
    private EmptyTrayInsertedFaultService ETIF_Service;

    public static void main(String[] args) {
        SpringApplication.run(BackendTopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    
    }

}
