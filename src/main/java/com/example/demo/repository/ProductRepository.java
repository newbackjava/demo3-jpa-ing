package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//싱글톤 : @Component(기본요소)
@Repository //dao가 싱글톤으로 하나가 만들어짐.
public interface ProductRepository
        extends JpaRepository<Product, Long> {
//JpaRepositor<파라메터타입1, 파라메터타입2>
    //파라메터타입1 - Entity명
    //파라메터타입2 - Entity 내 pk컬럼 데이터타입
    //Entity는 pk역할하는 @Id어노테이션이 반드시 있어야함.

  //기본 crud 메서드가 자동으로 이미 상속받아서 다 있다.
  //20개 정도의 추상메서드가 들어있음.
}