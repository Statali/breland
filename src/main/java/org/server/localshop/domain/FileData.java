package org.server.localshop.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.spi.LoggerFactory;

public  class FileData {


    private final File file;
    private final String fileName;
    private final String contentType;
    private final InputStream inputStream;

    public FileData(final File file, final String fileName, final String contentType) {
        this.file = file;
        this.fileName = fileName;
        this.contentType = contentType;
        this.inputStream = null;
    }

    public FileData(final InputStream inputStream, final String fileName, final String contentType) {
        this.file = null;
        this.inputStream = inputStream;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public String contentType() {
        return this.contentType;
    }

    public String name() {
        return this.fileName;
    }

    public InputStream file() {
        try {
            if (this.inputStream == null) { return new FileInputStream(this.file); }
            return this.inputStream;
        } catch (final FileNotFoundException e) {
            //logger.error(e.toString());
            return null;
        }
    }
}
