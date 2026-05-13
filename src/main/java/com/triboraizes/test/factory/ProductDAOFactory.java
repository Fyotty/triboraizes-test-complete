package com.triboraizes.test.factory;

import com.triboraizes.test.dao.ProductDAO;
import com.triboraizes.test.dao.ProductDAOImpl;
import com.triboraizes.test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDAOFactory {

    private final ProductRepository repository;

    public ProductDAO createProductDAO() {
        return new ProductDAOImpl(repository);
    }
}
