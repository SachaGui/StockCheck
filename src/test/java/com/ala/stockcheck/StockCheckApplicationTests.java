package com.ala.stockcheck;

import com.ala.stockcheck.entity.StockCheck;
import com.ala.stockcheck.service.StockCheckService;
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

		System.out.println("ID : " + stockCheck.getId());

		System.out.println("Status : " + stockCheck.getStatus());

		System.out.println("CreateTime : " + stockCheck.getCreateTime());
	}
}