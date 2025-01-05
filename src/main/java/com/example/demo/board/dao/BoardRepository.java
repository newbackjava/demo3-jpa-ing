package com.example.demo.board.dao;

import com.example.demo.board.vo.Board;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
//    @Query("select b from Board b where b.title like concat('%', :keyoword, '%')")
//    Page<Board> findByKeyword(String keyword, Pageable pageable);
//
//    @Query(value = "select now()", nativeQuery = true)
//    String getTime();
//    @Override
//    void flush();
//
//    @Override
//    <S extends Board> S saveAndFlush(S entity);
//
//    @Override
//    <S extends Board> List<S> saveAllAndFlush(Iterable<S> entities);
//
//    @Override
//    default void deleteInBatch(Iterable<Board> entities) {
//        JpaRepository.super.deleteInBatch(entities);
//    }
//
//    @Override
//    void deleteAllInBatch(Iterable<Board> entities);
//
//    @Override
//    void deleteAllByIdInBatch(Iterable<Long> longs);
//
//    @Override
//    void deleteAllInBatch();
//
//    @Override
//    Board getOne(Long aLong);
//
//    @Override
//    Board getById(Long aLong);
//
//    @Override
//    Board getReferenceById(Long aLong);
//
//    @Override
//    <S extends Board> List<S> findAll(Example<S> example);
//
//    @Override
//    <S extends Board> List<S> findAll(Example<S> example, Sort sort);
//
//    @Override
//    <S extends Board> S save(S entity);
//
//    @Override
//    Optional<Board> findById(Long aLong);
//
//    @Override
//    boolean existsById(Long aLong);
//
//    @Override
//    long count();
//
//    @Override
//    void delete(Board entity);
//
//    @Override
//    void deleteById(Long aLong);
//
//    @Override
//    void deleteAllById(Iterable<? extends Long> longs);
//
//    @Override
//    void deleteAll(Iterable<? extends Board> entities);
//
//    @Override
//    void deleteAll();
//
//    @Override
//    List<Board> findAll(Sort sort);
//
//    @Override
//    Page<Board> findAll(Pageable pageable);
//
//    @Override
//    <S extends Board> Optional<S> findOne(Example<S> example);
//
//    @Override
//    <S extends Board> Page<S> findAll(Example<S> example, Pageable pageable);
//
//    @Override
//    <S extends Board> boolean exists(Example<S> example);
}
