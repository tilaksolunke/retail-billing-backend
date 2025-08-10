package in.tilaksolunke.billingsoftware.service;

import in.tilaksolunke.billingsoftware.io.CategoryRequest;
import in.tilaksolunke.billingsoftware.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request, MultipartFile file) throws IOException;

    List<CategoryResponse> read();

    void delete(String categoryId);
}
