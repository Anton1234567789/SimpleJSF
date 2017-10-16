package simple.products;

import org.apache.commons.lang3.StringUtils;
import simple.products.domain.ProductEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class ProductManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public boolean create(ProductEntity productEntity){
        if (!checkValid(productEntity)){
            return false;
        }
        ProductEntity existingProduct = entityManager.find(ProductEntity.class,productEntity.getId());
        if (existingProduct!=null){
            return false;
        }
        entityManager.persist(productEntity);
        return true;
    }

//    public ProductEntity read(String id){
//
//    }
//
//    public boolean update(ProductEntity productEntity){
//
//    }
//    public List<ProductEntity> readList(int offset, int limit){
//
//    }
//    public boolean delete(String id){
//
//    }
    private boolean checkValid(ProductEntity productEntity){
        return !(productEntity == null || StringUtils.isEmpty(productEntity.getId())
                || StringUtils.isEmpty(productEntity.getName())
                || productEntity.getPrice() <= 0);
    }
}
