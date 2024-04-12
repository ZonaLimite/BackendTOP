package es.bogaservic.backendTOP;

import es.bogaservic.backendTOP.models.EmptyTrayInsertedFault;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
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
        /*System.out.println("Hello World from Application Runner");
        Integer centro = 2;
        Integer maquina =null;
        //String fecha="2024/04/02";
        String fecha=null;
        String turno=null;

        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<EmptyTrayInsertedFault> result = ETIF_Service.findEmptyTrayInsertedFaults(centro, maquina,fecha , null, turno, null);

                for (EmptyTrayInsertedFault etif : result) {
                    System.out.println(etif.getNivel()+etif.getLado()+etif.getSalida());
                }
            }
        });

        timer.start();*/

    }

}
