package agreement.rest.mvc;

import agreement.core.dto.AgreementFileDTO;
import agreement.core.services.AgreementFileService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Radek on 31.07.2017.
 */
class AgreementFileControllerTest {


    @Mock
    private AgreementFileService fileService;
    @InjectMocks
    private AgreementFileController fileController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.fileController).build();
    }


    public void createAgreementFile() {

        AgreementFileDTO fileDTO = getTestAgreementFile();
//        Mockito.when(fileService.addAgreementFile(fileDTO)).thenReturn(fileDTO);

//        MockMultipartFile mockMultipartFile = new MockMultipartFile("Umowa", "ustawienie.txt", MediaType.TEXT_PLAIN_VALUE, fileDTO.getFile());



//        mockMvc.perform(post("rest/agreementfile")
//                .content("{\"id\":1,\"name\":\"Umowa\",\"agreement\":\"\",\"extension\":\".txt\",\"file\":\"\"}")
//                .contentType());
    }

    private AgreementFileDTO getTestAgreementFile(){

        Path path = Paths.get("C:\\Programowanie\\ustawienie.txt");
        byte[] bFile = new byte[0];
        try {
            bFile = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AgreementFileDTO fileDTO = new AgreementFileDTO();
        fileDTO.setId(1L);
        fileDTO.setFileName("ustawienie.txt");
        fileDTO.setAgreement(null);
//        fileDTO.setFile(bFile);

        return fileDTO;
    }
}