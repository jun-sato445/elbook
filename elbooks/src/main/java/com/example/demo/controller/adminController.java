package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Book;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/")
public class adminController {

	@Autowired
	AdminService adminService;

	/**
	 * 画面表示のみ
	 */
	//管理者メインページ
	@RequestMapping("/01_admin")
	public String test(Model model) {
		model.addAttribute("books", adminService.findAll());
		return "/01_admin";
	}
	//ユーザー情報ページ
	@RequestMapping("/02_user_information")
	public String test2() {
		return "/02_user_information";
	}
	//お問い合わせ一覧ページ
	@RequestMapping("/03_Inquiry")
	public String test3() {
		return "/03_Inquiry";
	}
//本の在庫一覧ページ
	@RequestMapping("/04_stock")
	public String test4() {
		return "/04_stock";
	}
	//本の在庫一覧ページ
	@RequestMapping("/05_history")
	public String test5() {
		return "/05_history";
	}

	@RequestMapping("/06_book_register")
	public String test6() {
		return "/06_book_register";
	}

	
	/**
	 * /画面表示のみ
	 */
	
	/**
	 * 本の新規登録
	 * @author akira
	 * @basic 基本機能完成
	 * @application 未完了
	 */
	
	@PostMapping("/bookRegister")
	public String save(@ModelAttribute Book book, Model model) {
		adminService.save(book);
		return "redirect:/01_admin";
	}
	/**
	 * /本の新規登録
	 */
	
	/**
	 * 本の検索
	 * @author akira
	 * @basic 未完了
	 * @application 未完了
	 */
	@PostMapping("/01_admin")
	public String scope(@ModelAttribute Book book, Model model) {
		return "redirect:/01_admin";
	}
	/**
	 *　/本の検索
	 */
	
//	/**
//	 * 本のアップデート
//	 * @author akira
//	 * @basic 未完了
//	 * @application 未完了
//		*/
//	//本の編集処理
//	//main画面に戻る
//	@PostMapping("/book_update")
//	public String bookUpdate(Book book) {
//		//本のタイトルのアップデート
//		adminService.adminUpdate(book);
//		//
//		return "redirect:/threadList";
//	}
//	
//	/**
//	 * /スレッドのアップデート
//		*/
	
//	/**
//	 * スレッドのデリート
//	 * @author akira
//	 * @basic 未完了
//	 * @application 未完了
//		*/
//
//	//	スレッド削除画面
//	@GetMapping("/thread_delete/{id}")
//	public String Delete(@PathVariable("id") Integer id, Model model) {
//		//スレッドの検索 findOne
//		model.addAttribute("thread", threadService.findOne(id));
//		return "/thread_delete";
//	}
//
//	//スレッド削除処理
//	@PostMapping("/thread_delete")
//	public String DeleteOne(Thread thread) {
//		
//		//コメントの削除
//		commentService.DeleteAll(thread);
//
//		//スレッドの削除
//		threadService.DeleteOne(thread);
//	
//		return "redirect:/threadList";
//	}
//	/**
//	 * /スレッドのデリート
//		*/
}
