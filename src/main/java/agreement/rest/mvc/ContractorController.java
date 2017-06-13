package agreement.rest.mvc;

import agreement.core.dto.ContractorDTO;
import agreement.core.services.ConractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Radek on 13.06.2017.
 */
@RestController
@RequestMapping("/rest/contractor")
public class ContractorController {

    private ConractorService conractorService;

    @Autowired
    public ContractorController(ConractorService conractorService) {
        this.conractorService = conractorService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ContractorDTO>> getContractors(){

        List<ContractorDTO> dtoList = conractorService.findAll();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "{contractorId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorDTO> getContractor(Long contractorId){

        ContractorDTO contractor = conractorService.findById(contractorId);

        return new ResponseEntity<>(contractor, HttpStatus.FOUND);
    }
}
