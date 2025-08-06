package in.tilaksolunke.billingsoftware.service;

import in.tilaksolunke.billingsoftware.io.CategoryRequest;
import in.tilaksolunke.billingsoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
    List<CategoryResponse> read();
    void delete(String categoryId);
}
