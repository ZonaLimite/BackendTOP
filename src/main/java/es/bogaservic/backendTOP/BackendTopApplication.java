package es.bogaservic.backendTOP;

import es.bogaservic.backendTOP.dao.EmptyTrayInsertedFault_Repository;
import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import es.bogaservic.backendTOP.dao.StartOfRecordingSession_Repository;

@SpringBootApplication
public class BackendTopApplication implements CommandLineRunner {

    @Autowired
    StartOfRecordingSession_Repository SORS_repository;
    
    @Autowired
    EmptyTrayInsertedFault_Repository ETIF_repository;

    public static void main(String[] args) {
        SpringApplication.run(BackendTopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World from Application Runner");
        int centro = 2;
        int maquina =5;

        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<EmptyTrayInsertedFault> result = ETIF_repository.findEmptyTrayInsertedFaults(2, 5, "2024/04/11", null, "Tarde", null);

                for (EmptyTrayInsertedFault etif : result) {
                    System.out.println(etif);
                }
            }
        });

        timer.start();

    }

}
