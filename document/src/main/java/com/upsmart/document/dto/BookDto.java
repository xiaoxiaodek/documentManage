package com.upsmart.document.dto;

import javax.persistence.Column;

/**
 * Created by upsmart on 17-3-29.
 */
public class BookDto {
    private int id;

    // 书籍名
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    //书籍分类
    @Column(name = "type",length = 25,nullable = false)
    private String type;

    //书籍标签
    @Column(name = "label",length = 100,nullable = false)
    private String label;
    //书籍存储路径
    @Column(name="path",length = 50,nullable = false)
    private String path;
    // 文件描述
    @Column(name = "discription", length = 32, nullable = false)
    private String discription;

    //
    @Column(name = "owner", length = 32, nullable = false)
    private String owner;
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     *
     * @return
     */
    public String getDiscription() {
        return discription;
    }
    /**
     *
     * @param discription
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    /**
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     *
     * @return
     */
    public String getOwner() {
        return owner;
    }
    /**
     *
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }
    /**
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
