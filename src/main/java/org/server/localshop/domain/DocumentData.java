package org.server.localshop.domain;

public class DocumentData {

    private final Long id;
    private final String parentEntityType;
    private final Long parentEntityId;
    @SuppressWarnings("unused")
    private final String name;
    private final String fileName;
    @SuppressWarnings("unused")
    private final Long size;
    private final String type;
    @SuppressWarnings("unused")
    private final String description;
    private final String location;

    public DocumentData(final Long id, final String parentEntityType, final Long parentEntityId, final String name, final String fileName,
            final Long size, final String type, final String description, final String location) {
        this.id = id;
        this.parentEntityType = parentEntityType;
        this.parentEntityId = parentEntityId;
        this.name = name;
        this.fileName = fileName;
        this.size = size;
        this.type = type;
        this.description = description;
        this.location = location;
    }

    public String contentType() {
        return this.type;
    }

    public String fileName() {
        return this.fileName;
    }

    public String fileLocation() {
        return this.location;
    }

   

    public String getParentEntityType() {
        return this.parentEntityType;
    }

    public Long getParentEntityId() {
        return this.parentEntityId;
    }

    public Long getId() {
        return this.id;
    }

}