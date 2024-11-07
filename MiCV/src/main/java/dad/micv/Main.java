package dad.micv;

import dad.micv.model.CV;
import dad.micv.model.Email;
import dad.micv.ui.MiCVApp;
import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        Application.launch(MiCVApp.class, args);

//        CV cv = new CV();
//        cv.getPersonal().setNombre("Juan");
//        cv.getPersonal().setApellidos("García");
//        cv.getPersonal().setFechaNacimiento(LocalDate.of(1940, 1, 20));
//        cv.getPersonal().setPais("España");
//        cv.getPersonal().setIdentificacion("12345678Z");
//        cv.getPersonal().getEmails().add(new Email("juan@gmail.com"));
//
//        cv.save(new File("juan.cv"));

    }

}
