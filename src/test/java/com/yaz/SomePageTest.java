package com.yaz;

import io.quarkus.test.junit.QuarkusTest;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

@QuarkusTest
class SomePageTest {

  @Test
  void test() {

    final var driver = new ChromeDriver();

    driver.get("http://localhost:9898/some-page");

    final var pageSource = driver.getPageSource();
    driver.quit();

    final var document = Jsoup.parse(pageSource);

    final var csrfTable = document.getElementById("csrf-table");
    Assertions.assertTrue(csrfTable.childrenSize() > 1);

  }

}