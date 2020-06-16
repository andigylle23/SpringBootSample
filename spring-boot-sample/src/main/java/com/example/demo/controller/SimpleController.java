package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.service.BookService;

// UIに対応する
@Controller
public class SimpleController {

	// 初期化
	private final BookService bookService;

	// コンストラクタ
	public SimpleController(BookService bookService) {
		this.bookService = bookService;
	}

	// GETのメソッドとページネーションの対応
	@GetMapping("/books")
	public String homeDisplay(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		// ページとサイズの設定する
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Books> bookPage = bookService.findPaginatedPage(PageRequest.of(currentPage - 1, pageSize));

		// UIのパラメータに対応する
		model.addAttribute("book", bookPage);

		// 全ページの数える
		int totalPages = bookPage.getTotalPages();
		// totalPagesが０より大きいの場合：
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			// UIのパラメータに対応する
			model.addAttribute("pageNumbers", pageNumbers);
		}

		// ページの名前の呼ぶ
		return "index";
	}

	// 削除のAPI
	@GetMapping("books/delete/{title}")
	private String deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {
		// サービスクラスのdeleteBookByTitle
		bookService.deleteBookByTitle(title);

		// APIのリダイレクト
		return "redirect:/books";
	}

	// "/"の入力するの場合、/bookｓのAPIリダイレクト
	@GetMapping("/")
	private String redirectToIndexPage() {
		return "redirect:/books";
	}

	// 間違ったURLの入力する場合、エラーページの表示する
	@RequestMapping(value = "/{[path:[^\\.]*}")
	private String redirectToErrorPage() {
		return "error";
	}

}
