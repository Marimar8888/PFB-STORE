package com.marimar.store.application.dto;


import java.io.Serializable;

public class CategoryImageDTO implements Serializable{

        private Long id;
        private String title;
        private byte[] image;

        public CategoryImageDTO() {  }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public byte[] getImage() {
            return image;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }


}
