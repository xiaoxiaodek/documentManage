package com.upsmart.document.domain;

import javax.persistence.*;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-21
 */
    @Entity
    @Table(name = "doc")
    public class Doc {
        // 用户编号
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private int id;

        // 文件名
        @Column(name = "name", length = 20, nullable = false)
        private String name;
        //文件类型
        @Column(name = "type",length = 15,nullable = false)
        private String type;

         //文件路径
        @Column(name="path",length = 20,nullable = false)
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

}

