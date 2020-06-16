package com.example.demo.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

import java.util.List;

// POSTManのために
@RestController
@RequestMapping("/v1/api/book")
public class BookController {

	// 初期化
	private final BookRepository bookRepository;

	// コンストラクタ
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// Iterableに使って、全の本の返す
	@GetMapping
	private Iterable<Books> getAllBooks() throws ResourceNotFoundException {
		// CRUDの操作の使う
		Iterable<Books> bookList = bookRepository.findAll();

		// bookListの見つからないの場合：
		if (bookList == null) {
			// エラーの表示する
			throw new ResourceNotFoundException("No registered books yet.");
		}
		return bookList;
	}

	// タイトルに対応して、本の返す
	@GetMapping("/title/{title}")
	private Books getBook(@PathVariable("title") String title) throws ResourceNotFoundException {

		Books book = bookRepository.findByTitle(title);

		// bookListの見つからないの場合：
		if (book == null) {
			// エラーの表示する
			throw new ResourceNotFoundException("No book found with that book title");
		}
		return book;
	}

	// 作者に対応して、リストの本の返す
	@GetMapping("/author/{author}")
	private List<Books> getAuthor(@PathVariable("author") String author) throws ResourceNotFoundException {

		List<Books> bookList = bookRepository.findByAuthor(author);

		// bookListの見つからないの場合：
		if (bookList == null || bookList.isEmpty()) {
			// エラーの表示する
			throw new ResourceNotFoundException("No book found with that author name");
		}

		return bookList;
	}

	// 本の登録する
	@PostMapping
	private Books registerBook(@RequestBody Books book) throws ResourceNotFoundException {

		Books books = bookRepository.findByTitle(book.getTitle());

		// bookListの見つかった場合：
		if (books != null) {
			// エラーの表示する　
			// TODO: 存在の本エラーの作成
			throw new ResourceNotFoundException("The same book title already exists ");
		}

		return bookRepository.save(book);
	}

	//　本の削除する
	@GetMapping("/delete/{title}")
	private void deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {

		Books book = bookRepository.findByTitle(title);

		// bookListの見つからないの場合：
		if (book == null) {
			// エラーの表示する
			throw new ResourceNotFoundException("No such title found. Please check and try again.");
		}

		int bookId = book.getId();
		bookRepository.deleteById(bookId);
	}

}
