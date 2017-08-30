package agreement.core.mapper.utils;

import agreement.core.entities.AgreementFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Radek on 18.08.2017.
 */
public class AgreementFileMapperUtil {

    public static MultipartFile convertByteToMf(AgreementFile agreementFile){

        FileOutputStream fos = null;

        String path = "C:\\Programowanie\\temp\\" + agreementFile.getFileName();

        try {
            fos = new FileOutputStream(path);
            fos.write(agreementFile.getFile());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(path);

        FileItem fileItem = new DiskFileItem("file", "text/plain", false, agreementFile.getFileName(), 100000000, file);
//        FileItem fileItem = new DiskFileItemFactory().createItem("file", "text/plain", true, agreementFile.getFileName());

        try {
            fileItem.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new CommonsMultipartFile(fileItem);
    }

}
