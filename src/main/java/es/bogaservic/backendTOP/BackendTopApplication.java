package es.bogaservic.backendTOP;


import es.bogaservic.backendTOP.dao.T_TOP2000_STARTOFRECORDINGSESSION_Repository;
import es.bogaservic.backendTOP.models.FallosFracasoSalidaEntrante;
import es.bogaservic.backendTOP.models.T_TOP2000_STARTOFRECORDINGSESSION;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class BackendTopApplication implements CommandLineRunner {
    
    @Autowired
    T_TOP2000_STARTOFRECORDINGSESSION_Repository SORS_repository;

    public static void main(String[] args) {
        SpringApplication.run(BackendTopApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World from Application Runner");
        
        List<FallosFracasoSalidaEntrante> result = SORS_repository.findByMaquina(5);
        
            for (FallosFracasoSalidaEntrante sSession : result) {
                System.out.println(sSession);
            }
     
    }

}
