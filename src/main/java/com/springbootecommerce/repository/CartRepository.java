package com.springbootecommerce.repository;

import com.springbootecommerce.dto.PriceDTO;
import com.springbootecommerce.dto.TotalCartDTO;
import com.springbootecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByProductId(int product_id);

    Cart findByUserId(int user_id);

    @Query(nativeQuery = true, value = "select *" +
            " from Cart c where c.product_id=:id AND c.user_id=:user_id ")
    Cart returnResult(@Param("id") int id, @Param("user_id") int user_id);

    @Query(nativeQuery = true)
    List<TotalCartDTO[]> productsInCart(@Param("user_id")int user_id);

    @Query(nativeQuery = true)
    List<PriceDTO[]> findQuantityAndPriceUsingId(@Param("user_id")int user_id);
}
