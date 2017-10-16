package simple.products;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ProductsListBean implements Serializable{
    private List<Product> products = new ArrayList<Product>();
    private Product newProduct = new Product();

    @PostConstruct
    private void initialize(){
        Product product = new Product();
        product.setId("id");
        product.setName("Food");
        product.setPrice(100);
        products.add(product);

        product = new Product();
        product.setId("id1");
        product.setName("Computer");
        product.setPrice(1000);
        products.add(product);

        product = new Product();
        product.setId("id2");
        product.setName("Water");
        product.setPrice(10);
        products.add(product);

    }

    public List<Product> getProducts(){
        return products;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void addNewProduct(){
        products.add(newProduct);
        newProduct = new Product();
    }

}
