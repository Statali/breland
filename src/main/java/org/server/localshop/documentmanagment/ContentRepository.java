package org.server.localshop.documentmanagment;

import java.io.InputStream;

import org.server.localshop.domain.Base64EncodedImage;
import org.server.localshop.domain.DocumentData;
import org.server.localshop.domain.FileData;
import org.springframework.stereotype.Service;


public interface ContentRepository {


    // TODO:Vishwas Need to move these settings to the Database
    public static final Integer MAX_FILE_UPLOAD_SIZE_IN_MB = 5;

    // TODO:Vishwas Need to move these settings to the Database
    public static final Integer MAX_IMAGE_UPLOAD_SIZE_IN_MB = 1;

    public abstract String saveFile(InputStream uploadedInputStream, DocumentCommand documentCommand);

    public abstract void deleteFile(String fileName, String documentPath);

    public abstract FileData fetchFile(DocumentData documentData);

    public abstract String saveImage(InputStream uploadedInputStream, Long resourceId, String imageName, Long fileSize);

    public abstract String saveImage(Base64EncodedImage base64EncodedImage, Long resourceId, String imageName);

    public abstract void deleteImage(final Long resourceId, final String location);

    public abstract ImageData fetchImage(ImageData imageData);


}
