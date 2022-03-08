package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static final Map<Integer, Product> productMap ;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"Iphone","green",12333));
        productMap.put(2, new Product(2,"IphoneX","green",12333));
        productMap.put(3, new Product(3,"IphoneZ","green",12333));
        productMap.put(4, new Product(4,"IphoneY","green",12333));
        productMap.put(5, new Product(5,"Iphone12","green",12333));
        productMap.put(6, new Product(6,"Asus","green",12333));

    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        productMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> ListProductSearch = new ArrayList<>();
        List<Product> productList = new ArrayList<>(productMap.values());

        for (Product p : productList){
            if (p.getName().contains(name)){
                ListProductSearch.add(p);
            }
        }
        return ListProductSearch;
    }
}
