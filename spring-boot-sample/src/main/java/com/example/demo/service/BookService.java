package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

// サービスコンポーネントアノテーション
@Service
public class BookService {

	// 初期化
	private final BookRepository bookRepository;

	// コンストラクタ
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// 削除昨日： パラメータ＝タイトル
	public void deleteBookByTitle(String title) throws ResourceNotFoundException {
		// タイトルごとに検索
		Books book = bookRepository.findByTitle(title);

		// 見つからない（null）の場合
		if (book == null) {
			// TODO: エラーページの連携する
			throw new ResourceNotFoundException("No such title found. Please check and try again.");
		}

		// GET本のID
		int bookId = book.getId();
		// IDが一致する場合： 削除する
		bookRepository.deleteById(bookId);
	}

	// 全部本の取得する
	public List<Books> findAllRegisteredBooks() {
		return bookRepository.findAll();

	}

	// ページネーション
	public Page<Books> findPaginatedPage(Pageable pageable) {
		// 全部本の取得して、新本のリストに割り当てます
		List<Books> books = findAllRegisteredBooks();
		// Pageableの機能
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		// 新本のリスト
		List<Books> bookList;

		// 本のオブジェクトがstartItem(っと０になる）より少ない場合
		if (books.size() < startItem) {
			// TODO: 本来のエラーの出す
			bookList = Collections.emptyList();
		} else {
			int toIndex = (int) Math.min(startItem + pageSize, books.size());
			// リスト内の指定された範囲のビューの返却する
			bookList = books.subList(startItem, toIndex);
		}

		// コンテンツとページネーションを返す
		Page<Books> bookPage = new PageImpl<Books>(bookList, PageRequest.of(currentPage, pageSize), books.size());

		return bookPage;

	}
	
	// TODO: It should throw an error if the title is already exists
	public Books addBook(Books book) {
		return bookRepository.save(book);
	}
}
