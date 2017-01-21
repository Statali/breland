package org.server.localshop.exception;

public class ImageDataURLNotValidException extends AbstractPlatformDomainRuleException {

    public ImageDataURLNotValidException() {
        super("error.msg.dataURL.save", "Only GIF, PNG and JPEG Data URL's are allowed");
    }
}