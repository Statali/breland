package org.server.localshop.exception;

public class ImageUploadException extends AbstractPlatformDomainRuleException {

    public ImageUploadException() {
        super("error.msg.image.type.upload", "Only image files of type GIF,PNG and JPG are allowed ");
    }
}