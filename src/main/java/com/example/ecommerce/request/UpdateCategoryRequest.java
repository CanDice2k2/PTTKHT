package com.example.ecommerce.request;

public class UpdateCategoryRequest {
      private Long id;

    private String name;

    public UpdateCategoryRequest() {}

    public UpdateCategoryRequest(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
