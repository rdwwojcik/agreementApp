package agreement.rest.mvc;

import agreement.core.dto.ContractorDTO;
import agreement.core.services.ConractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "/{contractorId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorDTO> getContractor(@PathVariable Long contractorId){

        ContractorDTO contractor = conractorService.findById(contractorId);

        return new ResponseEntity<>(contractor, HttpStatus.FOUND);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorDTO> createContractor(@Valid @RequestBody ContractorDTO contractor){

        ContractorDTO contractorDTO = conractorService.create(contractor);

        return new ResponseEntity<>(contractorDTO, HttpStatus.CREATED);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorDTO> updateContractor(@Valid @RequestBody ContractorDTO contractorDTO){

        ContractorDTO dto = conractorService.update(contractorDTO);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{contractorId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteContractor(@PathVariable Long contractorId){

        conractorService.delete(contractorId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
