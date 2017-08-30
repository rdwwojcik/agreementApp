package agreement.rest.mvc;

import agreement.core.dto.AgreementFileDTO;
import agreement.core.services.AgreementFileService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Radek on 31.07.2017.
 */
@RestController
@RequestMapping("rest/agreementfile")
public class AgreementFileController {

    private final Logger logger = Logger.getLogger(AgreementFileController.class);

    private final AgreementFileService fileService;

    @Autowired
    public AgreementFileController(AgreementFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<?> createAgreementFile(@ModelAttribute AgreementFileDTO fileDTO){

        logger.info("File name: " + fileDTO.getFile().getOriginalFilename());

        AgreementFileDTO agreementFileDTO = null;

        try {
            agreementFileDTO = fileService.addAgreementFile(fileDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
//        return new ResponseEntity<AgreementFileDTO>(agreementFileDTO, HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<AgreementFileDTO> saveFile(){
//
//
//        return null;
//    }


}
