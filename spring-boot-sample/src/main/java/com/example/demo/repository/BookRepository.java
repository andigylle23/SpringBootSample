package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Books;

// 特定のクラスをデータアクセスオブジェクトとしてマークする
@Repository
public interface BookRepository extends CrudRepository<Books, Integer> {
	// タイトルに対応して、本の返す
	Books findByTitle(String title);
	// 作者に対応して、本のリストの返す
	List<Books> findByAuthor(String author);
	// 全部の本の返す
	List<Books> findAll();
}
