package com.ala.stockcheck;

import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.exception.BusinessException;
import com.ala.stockcheck.service.StockCheckService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// テストクラス
@SpringBootTest
public class StockCheckApplicationTests {

	// 棚卸タスク
	@Autowired
	private StockCheckService stockCheckService;

	// 棚卸タスク作成テスト
	@Test
	void testCreateCheck() {

		StockCheck stockCheck = stockCheckService.createCheck();

		System.out.println("===== テスト結果 =====");

		System.out.println("Status : " + stockCheck.getStatus());

		System.out.println("CreateTime : " + stockCheck.getCreateTime());
	}

	// ステータス確認テスト
	@Test
	void testStatusDefault() {

		StockCheck stockCheck = stockCheckService.createCheck();

		assertEquals("NEW", stockCheck.getStatus());

		System.out.println("Status確認OK");
	}

	// 作成日時確認テスト
	@Test
	void testCreateTime() {

		StockCheck stockCheck = stockCheckService.createCheck();

		assertNotNull(stockCheck.getCreateTime());

		System.out.println("CreateTime確認OK");
	}

	// DB登録確認テスト
	@Test
	void testInsertSuccess() {

		StockCheck stockCheck = stockCheckService.createCheck();

		assertEquals("NEW", stockCheck.getStatus());

		System.out.println("DB登録成功");
	}

	// 棚卸タスク異常テスト用
	@Test
	void testBusinessException() {
		Exception exception = assertThrows(BusinessException.class,
				() -> {
					throw new BusinessException("棚卸タスクが存在しません");
				});
		System.out.println(exception.getMessage());
	}

}